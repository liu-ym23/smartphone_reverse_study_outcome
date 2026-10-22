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

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePointchevalCipher implements MessageEncryptor {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.2";
    private boolean forEncryption;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525567k;
    McElieceCCA2KeyParameters key;
    private Digest messDigest;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525568n;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    private SecureRandom f525569sr;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525570t;

    public McEliecePointchevalCipher() {
    }

    private void initCipherDecrypt(McElieceCCA2PrivateKeyParameters r100) {
        this.messDigest = Utils.getDigest(r100.getDigest());
        this.f525568n = r100.getN();
        this.f525567k = r100.getK();
        this.f525570t = r100.getT();
    }

    private void initCipherEncrypt(McElieceCCA2PublicKeyParameters r100) {
        this.messDigest = Utils.getDigest(r100.getDigest());
        this.f525568n = r100.getN();
        this.f525567k = r100.getK();
        this.f525570t = r100.getT();
    }

    public int decryptOutputSize(int r100) {
        return 0;
    }

    public int encryptOutputSize(int r100) {
        return 0;
    }

    public int getKeySize(McElieceCCA2KeyParameters r100) throws IllegalArgumentException {
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
        this.f525569sr = r103.getRandom();
        McElieceCCA2PublicKeyParameters r104 = (McElieceCCA2PublicKeyParameters) r103.getParameters();
        this.key = r104;
        initCipherEncrypt(r104);
        return;
    L7:
        this.f525569sr = CryptoServicesRegistrar.getSecureRandom();
        McElieceCCA2PublicKeyParameters r105 = (McElieceCCA2PublicKeyParameters) r101;
        this.key = r105;
        initCipherEncrypt(r105);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public byte[] messageDecrypt(byte[] r100) throws InvalidCipherTextException {
        if (this.forEncryption == true) goto L14;
        int r101 = (this.f525568n + 7) >> 3;
        int r102 = r100.length - r101;
        byte[][] r103 = ByteUtils.split(r100, r101);
        byte[] r104 = r103[0];
        byte[] r105 = r103[1];
        GF2Vector r106 = GF2Vector.OS2VP(this.f525568n, r104);
        GF2Vector[] r107 = McElieceCCA2Primitives.decryptionPrimitive((McElieceCCA2PrivateKeyParameters) this.key, r106);
        byte[] r108 = r107[0].getEncoded();
        GF2Vector r109 = r107[1];
        DigestRandomGenerator r110 = new DigestRandomGenerator(new SHA1Digest());
        r110.addSeedMaterial(r108);
        byte[] r111 = new byte[r102];
        r110.nextBytes(r111);
        int r112 = 0;
    L5:
        if (r112 >= r102) goto L7;
        r111[r112] = (byte) (r111[r112] ^ r105[r112]);
        r112 = r112 + 1;
        goto L5
    L7:
        this.messDigest.update(r111, 0, r102);
        byte[] r113 = new byte[this.messDigest.getDigestSize()];
        this.messDigest.doFinal(r113, 0);
        if (Conversions.encode(this.f525568n, this.f525570t, r113).equals(r109) == false) goto L12;
        return ByteUtils.split(r111, r102 - (this.f525567k >> 3))[0];
    L12:
        throw new InvalidCipherTextException("Bad Padding: Invalid ciphertext.");
    L14:
        throw new IllegalStateException("cipher initialised for decryption");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public byte[] messageEncrypt(byte[] r100) {
        if (this.forEncryption == false) goto L13;
        int r101 = this.f525567k >> 3;
        byte[] r102 = new byte[r101];
        this.f525569sr.nextBytes(r102);
        GF2Vector r103 = new GF2Vector(this.f525567k, this.f525569sr);
        byte[] r104 = r103.getEncoded();
        byte[] r105 = ByteUtils.concatenate(r100, r102);
        int r106 = 0;
        this.messDigest.update(r105, 0, r105.length);
        byte[] r107 = new byte[this.messDigest.getDigestSize()];
        this.messDigest.doFinal(r107, 0);
        GF2Vector r108 = Conversions.encode(this.f525568n, this.f525570t, r107);
        byte[] r109 = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters) this.key, r103, r108).getEncoded();
        DigestRandomGenerator r110 = new DigestRandomGenerator(new SHA1Digest());
        r110.addSeedMaterial(r104);
        byte[] r111 = new byte[r100.length + r101];
        r110.nextBytes(r111);
        int r112 = 0;
    L6:
        if (r112 >= r100.length) goto L8;
        r111[r112] = (byte) (r111[r112] ^ r100[r112]);
        r112 = r112 + 1;
    L8:
        if (r106 >= r101) goto L11;
        int r113 = r100.length + r106;
        r111[r113] = (byte) (r111[r113] ^ r102[r106]);
        r106 = r106 + 1;
        goto L8
    L11:
        return ByteUtils.concatenate(r109, r111);
    L13:
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
