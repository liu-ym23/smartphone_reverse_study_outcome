package org.bouncycastle.crypto.prng.drbg;

import java.math.BigInteger;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class DualECSP800DRBG implements SP80090DRBG {
    private static final int MAX_ADDITIONAL_INPUT = 4096;
    private static final int MAX_ENTROPY_LENGTH = 4096;
    private static final int MAX_PERSONALIZATION_STRING = 4096;
    private static final long RESEED_MAX = 2147483648L;
    private static final DualECPoints[] nistPoints = null;
    private static final BigInteger p256_Px = null;
    private static final BigInteger p256_Py = null;
    private static final BigInteger p256_Qx = null;
    private static final BigInteger p256_Qy = null;
    private static final BigInteger p384_Px = null;
    private static final BigInteger p384_Py = null;
    private static final BigInteger p384_Qx = null;
    private static final BigInteger p384_Qy = null;
    private static final BigInteger p521_Px = null;
    private static final BigInteger p521_Py = null;
    private static final BigInteger p521_Qx = null;
    private static final BigInteger p521_Qy = null;
    private ECPoint _P;
    private ECPoint _Q;
    private ECCurve.Fp _curve;
    private Digest _digest;
    private EntropySource _entropySource;
    private ECMultiplier _fixedPointMultiplier;
    private int _outlen;
    private long _reseedCounter;
    private byte[] _s;
    private int _sLength;
    private int _securityStrength;
    private int _seedlen;

    static {
        BigInteger r100 = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        p256_Px = r100;
        BigInteger r101 = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        p256_Py = r101;
        BigInteger r102 = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        p256_Qx = r102;
        BigInteger r103 = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        p256_Qy = r103;
        BigInteger r104 = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        p384_Px = r104;
        BigInteger r105 = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        p384_Py = r105;
        BigInteger r106 = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        p384_Qx = r106;
        BigInteger r107 = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        p384_Qy = r107;
        BigInteger r108 = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        p521_Px = r108;
        BigInteger r110 = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        p521_Py = r110;
        BigInteger r111 = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        p521_Qx = r111;
        BigInteger r112 = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        p521_Qy = r112;
        nistPoints = new DualECPoints[]{new DualECPoints(128, r13.createPoint(r100, r101), r13.createPoint(r102, r103), 1), new DualECPoints(192, r0.createPoint(r104, r105), r0.createPoint(r106, r107), 1), new DualECPoints(256, r0.createPoint(r108, r110), r0.createPoint(r111, r112), 1)};
        ECCurve.Fp r113 = (ECCurve.Fp) NISTNamedCurves.getByName("P-256").getCurve();
        ECCurve.Fp r109 = (ECCurve.Fp) NISTNamedCurves.getByName("P-384").getCurve();
        ECCurve.Fp r114 = (ECCurve.Fp) NISTNamedCurves.getByName("P-521").getCurve();
    }

    public DualECSP800DRBG(Digest r100, int r101, EntropySource r110, byte[] r111, byte[] r112) {
        this(nistPoints, r100, r101, r110, r111, r112);
    }

    public DualECSP800DRBG(DualECPoints[] r100, Digest r101, int r102, EntropySource r103, byte[] r104, byte[] r105) {
        this._fixedPointMultiplier = new FixedPointCombMultiplier();
        this._digest = r101;
        this._entropySource = r103;
        this._securityStrength = r102;
        if (Utils.isTooLarge(r104, 512) == true) goto L28;
        if (r103.entropySize() < r102) goto L26;
        if (r103.entropySize() > 4096) goto L26;
        byte[] r106 = Arrays.concatenate(getEntropy(), r105, r104);
        int r107 = 0;
    L10:
        if (r107 == r100.length) goto L20;
        if (r102 <= r100[r107].getSecurityStrength()) goto L14;
        r107 = r107 + 1;
        goto L10
    L14:
        if (Utils.getMaxSecurityStrength(r101) < r100[r107].getSecurityStrength()) goto L17;
        this._seedlen = r100[r107].getSeedLen();
        this._outlen = r100[r107].getMaxOutlen() / 8;
        this._P = r100[r107].getP();
        this._Q = r100[r107].getQ();
        goto L20
    L17:
        throw new IllegalArgumentException("Requested security strength is not supported by digest");
    L20:
        if (this._P == null) goto L24;
        byte[] r108 = Utils.hash_df(this._digest, r106, this._seedlen);
        this._s = r108;
        this._sLength = r108.length;
        this._reseedCounter = 0;
        return;
    L24:
        throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
    L26:
        throw new IllegalArgumentException("EntropySource must provide between " + r102 + " and 4096 bits");
    L28:
        throw new IllegalArgumentException("Personalization string too large");
    }

    private byte[] getEntropy() {
        byte[] r100 = this._entropySource.getEntropy();
        if (r100.length < ((this._securityStrength + 7) / 8)) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private BigInteger getScalarMultipleXCoord(ECPoint r100, BigInteger r101) {
        return this._fixedPointMultiplier.multiply(r100, r101).normalize().getAffineXCoord().toBigInteger();
    }

    private byte[] pad8(byte[] r100, int r101) {
        int r102 = r101 % 8;
        if (r102 != 0) goto L5;
        return r100;
    L5:
        int r103 = 8 - r102;
        int r104 = r100.length - 1;
        int r105 = 0;
    L6:
        if (r104 < 0) goto L8;
        int r106 = r100[r104] & 255;
        r100[r104] = (byte) ((r105 >> (8 - r103)) | (r106 << r103));
        r104 = r104 - 1;
        r105 = r106;
        goto L6
    L8:
        return r100;
    }

    private byte[] xor(byte[] r100, byte[] r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        int r102 = r100.length;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L5:
        if (r104 == r102) goto L7;
        r103[r104] = (byte) (r100[r104] ^ r101[r104]);
        r104 = r104 + 1;
        goto L5
    L7:
        return r103;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] r110, byte[] r111, boolean r112) {
        int r100 = r110.length * 8;
        int r101 = r110.length / this._outlen;
        if (Utils.isTooLarge(r111, 512) == true) goto L32;
        if ((this._reseedCounter + ((long) r101)) <= 2147483648L) goto L8;
        return -1;
    L8:
        if (r112 == false) goto L11;
        reseed(r111);
        r111 = null;
    L11:
        if (r111 == null) goto L13;
        BigInteger r102 = new BigInteger(1, xor(this._s, Utils.hash_df(this._digest, r111, this._seedlen)));
    L14:
        int r113 = 0;
        Arrays.fill(r110, (byte) 0);
        int r114 = 0;
        int r103 = 0;
    L16:
        if (r114 >= r101) goto L23;
        r102 = getScalarMultipleXCoord(this._P, r102);
        byte[] r104 = getScalarMultipleXCoord(this._Q, r102).toByteArray();
        int r105 = r104.length;
        int r106 = this._outlen;
        if (r105 <= r106) goto L20;
        System.arraycopy(r104, r104.length - r106, r110, r103, r106);
    L21:
        r103 = r103 + this._outlen;
        this._reseedCounter++;
        r114 = r114 + 1;
        goto L16
    L20:
        System.arraycopy(r104, 0, r110, (r106 - r104.length) + r103, r104.length);
        goto L21
    L23:
        if (r103 >= r110.length) goto L29;
        r102 = getScalarMultipleXCoord(this._P, r102);
        byte[] r115 = getScalarMultipleXCoord(this._Q, r102).toByteArray();
        int r107 = r110.length - r103;
        int r108 = r115.length;
        int r109 = this._outlen;
        if (r108 <= r109) goto L27;
        r113 = r115.length - r109;
    L28:
        System.arraycopy(r115, r113, r110, r103, r107);
        this._reseedCounter++;
        goto L29
    L27:
        r103 = r103 + (r109 - r115.length);
    L29:
        this._s = BigIntegers.asUnsignedByteArray(this._sLength, getScalarMultipleXCoord(this._P, r102));
        return r100;
    L13:
        r102 = new BigInteger(1, this._s);
        goto L14
    L32:
        throw new IllegalArgumentException("Additional input too large");
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._outlen * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] r100) {
        if (Utils.isTooLarge(r100, 512) == true) goto L7;
        byte[] r101 = getEntropy();
        byte[] r102 = Arrays.concatenate(pad8(this._s, this._seedlen), r101, r100);
        this._s = Utils.hash_df(this._digest, r102, this._seedlen);
        this._reseedCounter = 0;
        return;
    L7:
        throw new IllegalArgumentException("Additional input string too large");
    }
}
