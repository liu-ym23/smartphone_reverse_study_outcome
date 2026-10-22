package org.bouncycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class IESEngine {
    private byte[] IV;
    byte[] V;
    BasicAgreement agree;
    BufferedBlockCipher cipher;
    boolean forEncryption;
    DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    Mac f525190mac;
    byte[] macBuf;
    IESParameters param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public IESEngine(BasicAgreement r100, DerivationFunction r101, Mac r102) {
        this.agree = r100;
        this.kdf = r101;
        this.f525190mac = r102;
        this.macBuf = new byte[r102.getMacSize()];
        this.cipher = null;
    }

    public IESEngine(BasicAgreement r100, DerivationFunction r101, Mac r102, BufferedBlockCipher r103) {
        this.agree = r100;
        this.kdf = r101;
        this.f525190mac = r102;
        this.macBuf = new byte[r102.getMacSize()];
        this.cipher = r103;
    }

    private byte[] decryptBlock(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        if (r112 < (this.V.length + this.f525190mac.getMacSize())) goto L38;
        if (this.cipher != null) goto L14;
        int r100 = (r112 - this.V.length) - this.f525190mac.getMacSize();
        byte[] r101 = new byte[r100];
        int r102 = this.param.getMacKeySize() / 8;
        byte[] r103 = new byte[r102];
        int r104 = r100 + r102;
        byte[] r105 = new byte[r104];
        this.kdf.generateBytes(r105, 0, r104);
        if (this.V.length == 0) goto L9;
        System.arraycopy(r105, 0, r103, 0, r102);
        System.arraycopy(r105, r102, r101, 0, r100);
    L10:
        byte[] r106 = new byte[r100];
        int r107 = 0;
    L11:
        if (r107 == r100) goto L13;
        r106[r107] = (byte) (r110[(this.V.length + r111) + r107] ^ r101[r107]);
        r107 = r107 + 1;
        goto L11
    L13:
        int r108 = 0;
    L18:
        byte[] r109 = this.param.getEncodingV();
        if (this.V.length == 0) goto L21;
        byte[] r113 = getLengthTag(r109);
    L22:
        int r114 = r111 + r112;
        byte[] r115 = Arrays.copyOfRange(r110, r114 - this.f525190mac.getMacSize(), r114);
        int r116 = r115.length;
        byte[] r117 = new byte[r116];
        this.f525190mac.init(new KeyParameter(r103));
        Mac r118 = this.f525190mac;
        byte[] r119 = this.V;
        r118.update(r110, r111 + r119.length, (r112 - r119.length) - r116);
        if (r109 == null) goto L26;
        this.f525190mac.update(r109, 0, r109.length);
    L26:
        if (this.V.length == 0) goto L28;
        this.f525190mac.update(r113, 0, r113.length);
    L28:
        this.f525190mac.doFinal(r117, 0);
        if (Arrays.constantTimeAreEqual(r115, r117) == false) goto L36;
        BufferedBlockCipher r120 = this.cipher;
        if (r120 != null) goto L34;
        return r106;
    L34:
        return Arrays.copyOfRange(r106, 0, r108 + r120.doFinal(r106, r108));
    L36:
        throw new InvalidCipherTextException("invalid MAC");
    L21:
        r113 = null;
        goto L22
    L9:
        System.arraycopy(r105, 0, r101, 0, r100);
        System.arraycopy(r105, r100, r103, 0, r102);
        goto L10
    L14:
        int r121 = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
        byte[] r122 = new byte[r121];
        int r123 = this.param.getMacKeySize() / 8;
        r103 = new byte[r123];
        int r124 = r121 + r123;
        byte[] r125 = new byte[r124];
        this.kdf.generateBytes(r125, 0, r124);
        System.arraycopy(r125, 0, r122, 0, r121);
        System.arraycopy(r125, r121, r103, 0, r123);
        CipherParameters r126 = new KeyParameter(r122);
        byte[] r127 = this.IV;
        if (r127 == null) goto L17;
        r126 = new ParametersWithIV(r126, r127);
    L17:
        this.cipher.init(false, r126);
        r106 = new byte[this.cipher.getOutputSize((r112 - this.V.length) - this.f525190mac.getMacSize())];
        BufferedBlockCipher r128 = this.cipher;
        byte[] r129 = this.V;
        r108 = r128.processBytes(r110, r111 + r129.length, (r112 - r129.length) - this.f525190mac.getMacSize(), r106, 0);
        goto L18
    L38:
        throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
    }

    private byte[] encryptBlock(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        if (this.cipher != null) goto L11;
        byte[] r100 = new byte[r112];
        int r101 = this.param.getMacKeySize() / 8;
        byte[] r102 = new byte[r101];
        int r103 = r112 + r101;
        byte[] r104 = new byte[r103];
        this.kdf.generateBytes(r104, 0, r103);
        if (this.V.length == 0) goto L7;
        System.arraycopy(r104, 0, r102, 0, r101);
        System.arraycopy(r104, r101, r100, 0, r112);
    L8:
        byte[] r105 = new byte[r112];
        int r106 = 0;
    L9:
        if (r106 == r112) goto L16;
        r105[r106] = (byte) (r110[r111 + r106] ^ r100[r106]);
        r106 = r106 + 1;
    L16:
        byte[] r113 = this.param.getEncodingV();
        if (this.V.length == 0) goto L19;
        byte[] r114 = getLengthTag(r113);
    L20:
        int r107 = this.f525190mac.getMacSize();
        byte[] r108 = new byte[r107];
        this.f525190mac.init(new KeyParameter(r102));
        this.f525190mac.update(r105, 0, r105.length);
        if (r113 == null) goto L24;
        this.f525190mac.update(r113, 0, r113.length);
    L24:
        if (this.V.length == 0) goto L26;
        this.f525190mac.update(r114, 0, r114.length);
    L26:
        this.f525190mac.doFinal(r108, 0);
        byte[] r115 = this.V;
        byte[] r116 = new byte[(r115.length + r112) + r107];
        System.arraycopy(r115, 0, r116, 0, r115.length);
        System.arraycopy(r105, 0, r116, this.V.length, r112);
        System.arraycopy(r108, 0, r116, this.V.length + r112, r107);
        return r116;
    L19:
        r114 = null;
        goto L20
    L7:
        System.arraycopy(r104, 0, r100, 0, r112);
        System.arraycopy(r104, r112, r102, 0, r101);
        goto L8
    L11:
        int r109 = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
        byte[] r117 = new byte[r109];
        int r118 = this.param.getMacKeySize() / 8;
        byte[] r119 = new byte[r118];
        int r120 = r109 + r118;
        byte[] r121 = new byte[r120];
        this.kdf.generateBytes(r121, 0, r120);
        System.arraycopy(r121, 0, r117, 0, r109);
        System.arraycopy(r121, r109, r119, 0, r118);
        if (this.IV == null) goto L14;
        BufferedBlockCipher r122 = this.cipher;
        CipherParameters r123 = new ParametersWithIV(new KeyParameter(r117), this.IV);
    L15:
        r122.init(true, r123);
        r105 = new byte[this.cipher.getOutputSize(r112)];
        int r124 = this.cipher.processBytes(r110, r111, r112, r105, 0);
        r112 = r124 + this.cipher.doFinal(r105, r124);
        r102 = r119;
        goto L16
    L14:
        r122 = this.cipher;
        r123 = new KeyParameter(r117);
        goto L15
    }

    private void extractParams(CipherParameters r100) {
        if ((r100 instanceof ParametersWithIV) == false) goto L5;
        ParametersWithIV r101 = (ParametersWithIV) r100;
        this.IV = r101.getIV();
        r100 = r101.getParameters();
    L6:
        this.param = (IESParameters) r100;
        return;
    L5:
        this.IV = null;
        goto L6
    }

    public BufferedBlockCipher getCipher() {
        return this.cipher;
    }

    public byte[] getLengthTag(byte[] r100) {
        byte[] r101 = new byte[8];
        if (r100 == null) goto L5;
        Pack.longToBigEndian(((long) r100.length) * 8, r101, 0);
    L5:
        return r101;
    }

    public Mac getMac() {
        return this.f525190mac;
    }

    public void init(AsymmetricKeyParameter r100, CipherParameters r101, KeyParser r102) {
        this.forEncryption = false;
        this.privParam = r100;
        this.keyParser = r102;
        extractParams(r101);
    }

    public void init(AsymmetricKeyParameter r100, CipherParameters r101, EphemeralKeyPairGenerator r102) {
        this.forEncryption = true;
        this.pubParam = r100;
        this.keyPairGenerator = r102;
        extractParams(r101);
    }

    public void init(boolean r100, CipherParameters r101, CipherParameters r102, CipherParameters r103) {
        this.forEncryption = r100;
        this.privParam = r101;
        this.pubParam = r102;
        this.V = new byte[0];
        extractParams(r103);
    }

    public byte[] processBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forEncryption == false) goto L8;
        EphemeralKeyPairGenerator r103 = this.keyPairGenerator;
        if (r103 == null) goto L18;
        EphemeralKeyPair r104 = r103.generate();
        this.privParam = r104.getKeyPair().getPrivate();
        this.V = r104.getEncodedPublicKey();
    L18:
        this.agree.init(this.privParam);
        byte[] r105 = BigIntegers.asUnsignedByteArray(this.agree.getFieldSize(), this.agree.calculateAgreement(this.pubParam));
        byte[] r106 = this.V;
        if (r106.length == 0) goto L30;
        byte[] r107 = Arrays.concatenate(r106, r105);
        Arrays.fill(r105, (byte) 0);
        r105 = r107;
    L30:
        this.kdf.init(new KDFParameters(r105, this.param.getDerivationV()));     // Catch: Throwable -> L27
        if (this.forEncryption == false) goto L24;
        byte[] r108 = encryptBlock(r100, r101, r102);     // Catch: Throwable -> L27
    L25:
        Arrays.fill(r105, (byte) 0);
        return r108;
    L24:
        r108 = decryptBlock(r100, r101, r102);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Arrays.fill(r105, (byte) 0);
        throw th;
    L8:
        if (this.keyParser == null) goto L18;
        ByteArrayInputStream r109 = new ByteArrayInputStream(r100, r101, r102);
        this.pubParam = this.keyParser.readKey(r109);     // Catch: IllegalArgumentException -> L12 IOException -> L15
        this.V = Arrays.copyOfRange(r100, r101, (r102 - r109.available()) + r101);
        goto L18
    L15:
        e = move-exception;
        throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e.getMessage(), e);
    L12:
        e = move-exception;
        throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e.getMessage(), e);
    }
}
