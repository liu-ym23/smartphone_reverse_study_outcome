package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageEncryptor;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCipher implements MessageEncryptor {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
    public int cipherTextSize;
    private boolean forEncryption;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525549k;
    private McElieceKeyParameters key;
    public int maxPlainTextSize;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525550n;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    private SecureRandom f525551sr;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525552t;

    public McElieceCipher() {
    }

    private byte[] computeMessage(GF2Vector r100) throws InvalidCipherTextException {
        byte[] r101 = r100.getEncoded();
        int r102 = r101.length - 1;
    L3:
        if (r102 < 0) goto L7;
        if (r101[r102] != 0) goto L7;
        r102 = r102 - 1;
    L7:
        if (r102 < 0) goto L13;
        if (r101[r102] != 1) goto L13;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 0, r103, 0, r102);
        return r103;
    L13:
        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
    }

    private GF2Vector computeMessageRepresentative(byte[] r100) {
        int r101 = this.maxPlainTextSize;
        if ((this.f525549k & 7) == 0) goto L5;
        int r102 = 1;
    L6:
        byte[] r103 = new byte[r101 + r102];
        System.arraycopy(r100, 0, r103, 0, r100.length);
        r103[r100.length] = 1;
        return GF2Vector.OS2VP(this.f525549k, r103);
    L5:
        r102 = 0;
        goto L6
    }

    private void initCipherDecrypt(McEliecePrivateKeyParameters r100) {
        this.f525550n = r100.getN();
        int r101 = r100.getK();
        this.f525549k = r101;
        this.maxPlainTextSize = r101 >> 3;
        this.cipherTextSize = this.f525550n >> 3;
    }

    private void initCipherEncrypt(McEliecePublicKeyParameters r100) {
        this.f525550n = r100.getN();
        this.f525549k = r100.getK();
        this.f525552t = r100.getT();
        this.cipherTextSize = this.f525550n >> 3;
        this.maxPlainTextSize = this.f525549k >> 3;
    }

    public int getKeySize(McElieceKeyParameters r100) {
        if ((r100 instanceof McEliecePublicKeyParameters) == false) goto L7;
        return ((McEliecePublicKeyParameters) r100).getN();
    L7:
        if ((r100 instanceof McEliecePrivateKeyParameters) == false) goto L11;
        return ((McEliecePrivateKeyParameters) r100).getN();
    L11:
        throw new IllegalArgumentException("unsupported type");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public void init(boolean r100, CipherParameters r101) {
        this.forEncryption = r100;
        if (r100 == true) goto L5;
        McEliecePrivateKeyParameters r102 = (McEliecePrivateKeyParameters) r101;
        this.key = r102;
        initCipherDecrypt(r102);
        return;
    L5:
        if ((r101 instanceof ParametersWithRandom) == false) goto L7;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        this.f525551sr = r103.getRandom();
        McEliecePublicKeyParameters r104 = (McEliecePublicKeyParameters) r103.getParameters();
        this.key = r104;
        initCipherEncrypt(r104);
        return;
    L7:
        this.f525551sr = CryptoServicesRegistrar.getSecureRandom();
        McEliecePublicKeyParameters r105 = (McEliecePublicKeyParameters) r101;
        this.key = r105;
        initCipherEncrypt(r105);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public byte[] messageDecrypt(byte[] r100) throws InvalidCipherTextException {
        if (this.forEncryption == true) goto L7;
        GF2Vector r101 = GF2Vector.OS2VP(this.f525550n, r100);
        McEliecePrivateKeyParameters r102 = (McEliecePrivateKeyParameters) this.key;
        GF2mField r103 = r102.getField();
        PolynomialGF2mSmallM r104 = r102.getGoppaPoly();
        GF2Matrix r105 = r102.getSInv();
        Permutation r106 = r102.getP1();
        Permutation r107 = r102.getP2();
        GF2Matrix r108 = r102.getH();
        PolynomialGF2mSmallM[] r109 = r102.getQInv();
        Permutation r110 = r106.rightMultiply(r107);
        GF2Vector r111 = (GF2Vector) r101.multiply(r110.computeInverse());
        GF2Vector r112 = GoppaCode.syndromeDecode((GF2Vector) r108.rightMultiply(r111), r103, r104, r109);
        GF2Vector r113 = (GF2Vector) ((GF2Vector) r111.add(r112)).multiply(r106);
        GF2Vector r114 = (GF2Vector) r112.multiply(r110);
        return computeMessage((GF2Vector) r105.leftMultiply(r113.extractRightVector(this.f525549k)));
    L7:
        throw new IllegalStateException("cipher initialised for decryption");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageEncryptor
    public byte[] messageEncrypt(byte[] r100) {
        if (this.forEncryption == false) goto L7;
        GF2Vector r101 = computeMessageRepresentative(r100);
        GF2Vector r102 = new GF2Vector(this.f525550n, this.f525552t, this.f525551sr);
        return ((GF2Vector) ((McEliecePublicKeyParameters) this.key).getG().leftMultiply(r101).add(r102)).getEncoded();
    L7:
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
