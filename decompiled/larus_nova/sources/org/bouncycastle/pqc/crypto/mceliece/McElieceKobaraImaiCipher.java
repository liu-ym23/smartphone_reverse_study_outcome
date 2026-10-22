package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.bouncycastle.pqc.crypto.MessageEncryptor;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKobaraImaiCipher implements MessageEncryptor {
    private static final String DEFAULT_PRNG_NAME = "SHA1PRNG";
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.3";
    public static final byte[] PUBLIC_CONSTANT = null;
    private boolean forEncryption;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525560k;
    McElieceCCA2KeyParameters key;
    private Digest messDigest;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525561n;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    private SecureRandom f525562sr;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525563t;

    static {
        PUBLIC_CONSTANT = "a predetermined public constant".getBytes();
    }

    public McElieceKobaraImaiCipher() {
    }

    private void initCipherDecrypt(McElieceCCA2PrivateKeyParameters r100) {
        this.messDigest = Utils.getDigest(r100.getDigest());
        this.f525561n = r100.getN();
        this.f525560k = r100.getK();
        this.f525563t = r100.getT();
    }

    private void initCipherEncrypt(McElieceCCA2PublicKeyParameters r100) {
        this.messDigest = Utils.getDigest(r100.getDigest());
        this.f525561n = r100.getN();
        this.f525560k = r100.getK();
        this.f525563t = r100.getT();
    }

    public int getKeySize(McElieceCCA2KeyParameters r100) {
        if ((r100 instanceof McElieceCCA2PublicKeyParameters) == false) goto L7;
        return ((McElieceCCA2PublicKeyParameters) r100).getN();
    L7:
        if ((r100 instanceof McElieceCCA2PrivateKeyParameters) == false) goto L11;
        return ((McElieceCCA2PrivateKeyParameters) r100).getN();
    L11:
        throw new IllegalArgumentException("unsupported type");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public void init(boolean r100, CipherParameters r101) {
        this.forEncryption = r100;
        if (r100 == true) goto L5;
        McElieceCCA2PrivateKeyParameters r102 = (McElieceCCA2PrivateKeyParameters) r101;
        this.key = r102;
        initCipherDecrypt(r102);
        return;
    L5:
        if ((r101 instanceof ParametersWithRandom) == false) goto L7;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.f525562sr = r103.getRandom();
        McElieceCCA2PublicKeyParameters r104 = (McElieceCCA2PublicKeyParameters) r103.getParameters();
        this.key = r104;
        initCipherEncrypt(r104);
        return;
    L7:
        this.f525562sr = CryptoServicesRegistrar.getSecureRandom();
        McElieceCCA2PublicKeyParameters r105 = (McElieceCCA2PublicKeyParameters) r101;
        this.key = r105;
        initCipherEncrypt(r105);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public byte[] messageDecrypt(byte[] r100) throws InvalidCipherTextException {
        if (this.forEncryption == true) goto L27;
        int r101 = this.f525561n >> 3;
        if (r100.length < r101) goto L25;
        int r102 = this.messDigest.getDigestSize();
        int r103 = this.f525560k >> 3;
        int r104 = r100.length - r101;
        if (r104 <= 0) goto L9;
        byte[][] r105 = ByteUtils.split(r100, r104);
        byte[] r106 = r105[0];
        r100 = r105[1];
    L10:
        GF2Vector[] r107 = McElieceCCA2Primitives.decryptionPrimitive((McElieceCCA2PrivateKeyParameters) this.key, GF2Vector.OS2VP(this.f525561n, r100));
        byte[] r108 = r107[0].getEncoded();
        GF2Vector r109 = r107[1];
        if (r108.length <= r103) goto L13;
        r108 = ByteUtils.subArray(r108, 0, r103);
    L13:
        byte[] r110 = ByteUtils.concatenate(ByteUtils.concatenate(r106, Conversions.decode(this.f525561n, this.f525563t, r109)), r108);
        int r111 = r110.length - r102;
        byte[][] r112 = ByteUtils.split(r110, r102);
        byte[] r113 = r112[0];
        byte[] r114 = r112[1];
        byte[] r115 = new byte[this.messDigest.getDigestSize()];
        this.messDigest.update(r114, 0, r114.length);
        this.messDigest.doFinal(r115, 0);
        int r116 = r102 - 1;
    L14:
        if (r116 < 0) goto L16;
        r115[r116] = (byte) (r115[r116] ^ r113[r116]);
        r116 = r116 - 1;
        goto L14
    L16:
        DigestRandomGenerator r117 = new DigestRandomGenerator(new SHA1Digest());
        r117.addSeedMaterial(r115);
        byte[] r118 = new byte[r111];
        r117.nextBytes(r118);
        int r119 = r111 - 1;
    L17:
        if (r119 < 0) goto L19;
        r118[r119] = (byte) (r118[r119] ^ r114[r119]);
        r119 = r119 - 1;
        goto L17
    L19:
        byte[] r120 = PUBLIC_CONSTANT;
        byte[][] r121 = ByteUtils.split(r118, r111 - r120.length);
        byte[] r122 = r121[0];
        if (ByteUtils.equals(r121[1], r120) == false) goto L23;
        return r122;
    L23:
        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
    L9:
        r106 = new byte[0];
        goto L10
    L25:
        throw new InvalidCipherTextException("Bad Padding: Ciphertext too short.");
    L27:
        throw new IllegalStateException("cipher initialised for decryption");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public byte[] messageEncrypt(byte[] r110) {
        if (this.forEncryption == false) goto L21;
        int r100 = this.messDigest.getDigestSize();
        int r101 = this.f525560k >> 3;
        int r102 = (IntegerFunctions.binomial(this.f525561n, this.f525563t).bitLength() - 1) >> 3;
        byte[] r103 = PUBLIC_CONSTANT;
        int r104 = ((r101 + r102) - r100) - r103.length;
        if (r110.length <= r104) goto L7;
        r104 = r110.length;
    L7:
        int r105 = r103.length + r104;
        int r106 = ((r105 + r100) - r101) - r102;
        byte[] r107 = new byte[r105];
        System.arraycopy(r110, 0, r107, 0, r110.length);
        System.arraycopy(r103, 0, r107, r104, r103.length);
        byte[] r111 = new byte[r100];
        this.f525562sr.nextBytes(r111);
        DigestRandomGenerator r108 = new DigestRandomGenerator(new SHA1Digest());
        r108.addSeedMaterial(r111);
        byte[] r109 = new byte[r105];
        r108.nextBytes(r109);
        int r112 = r105 - 1;
    L8:
        if (r112 < 0) goto L10;
        r109[r112] = (byte) (r109[r112] ^ r107[r112]);
        r112 = r112 - 1;
        goto L8
    L10:
        byte[] r113 = new byte[this.messDigest.getDigestSize()];
        this.messDigest.update(r109, 0, r105);
        this.messDigest.doFinal(r113, 0);
        int r114 = r100 - 1;
    L11:
        if (r114 < 0) goto L13;
        r113[r114] = (byte) (r113[r114] ^ r111[r114]);
        r114 = r114 - 1;
        goto L11
    L13:
        byte[] r115 = ByteUtils.concatenate(r113, r109);
        byte[] r116 = new byte[0];
        if (r106 <= 0) goto L16;
        r116 = new byte[r106];
        System.arraycopy(r115, 0, r116, 0, r106);
    L16:
        byte[] r117 = new byte[r102];
        System.arraycopy(r115, r106, r117, 0, r102);
        byte[] r118 = new byte[r101];
        System.arraycopy(r115, r102 + r106, r118, 0, r101);
        byte[] r119 = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters) this.key, GF2Vector.OS2VP(this.f525560k, r118), Conversions.encode(this.f525561n, this.f525563t, r117)).getEncoded();
        if (r106 > 0) goto L19;
        return r119;
    L19:
        return ByteUtils.concatenate(r116, r119);
    L21:
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
