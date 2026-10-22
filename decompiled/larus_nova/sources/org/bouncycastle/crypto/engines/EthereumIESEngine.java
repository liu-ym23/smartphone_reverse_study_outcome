package org.bouncycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class EthereumIESEngine {
    private byte[] IV;
    byte[] V;
    BasicAgreement agree;
    BufferedBlockCipher cipher;
    byte[] commonMac;
    boolean forEncryption;
    DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    Mac f525181mac;
    byte[] macBuf;
    IESParameters param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public static class HandshakeKDFFunction implements DigestDerivationFunction {
        private int counterStart;
        private Digest digest;

        /* JADX INFO: renamed from: iv, reason: collision with root package name */
        private byte[] f525182iv;
        private byte[] shared;

        public HandshakeKDFFunction(int r100, Digest r101) {
            this.counterStart = r100;
            this.digest = r101;
        }

        @Override // org.bouncycastle.crypto.DerivationFunction
        public int generateBytes(byte[] r110, int r111, int r112) throws DataLengthException, IllegalArgumentException {
            int r100 = r112;
            int r101 = r111;
            if ((r110.length - r100) < r101) goto L24;
            long r102 = r100;
            int r103 = this.digest.getDigestSize();
            if (r102 > 8589934591L) goto L22;
            long r104 = r103;
            int r105 = (int) (((r102 + r104) - 1) / r104);
            byte[] r106 = new byte[this.digest.getDigestSize()];
            int r107 = 4;
            byte[] r113 = new byte[4];
            Pack.intToBigEndian(this.counterStart, r113, 0);
            int r114 = this.counterStart & (-256);
            int r115 = 0;
        L7:
            if (r115 >= r105) goto L19;
            this.digest.update(r113, 0, r107);
            Digest r116 = this.digest;
            byte[] r117 = this.shared;
            r116.update(r117, 0, r117.length);
            byte[] r108 = this.f525182iv;
            if (r108 == null) goto L11;
            this.digest.update(r108, 0, r108.length);
        L11:
            this.digest.doFinal(r106, 0);
            if (r100 <= r103) goto L14;
            System.arraycopy(r106, 0, r110, r101, r103);
            r101 = r101 + r103;
            r100 = r100 - r103;
        L15:
            byte r118 = (byte) (r113[3] + 1);
            r113[3] = r118;
            if (r118 != 0) goto L18;
            r114 = r114 + 256;
            Pack.intToBigEndian(r114, r113, 0);
        L18:
            r115 = r115 + 1;
            r107 = 4;
            goto L7
        L14:
            System.arraycopy(r106, 0, r110, r101, r100);
            goto L15
        L19:
            this.digest.reset();
            return (int) r102;
        L22:
            throw new IllegalArgumentException("output length too large");
        L24:
            throw new OutputLengthException("output buffer too small");
        }

        @Override // org.bouncycastle.crypto.DigestDerivationFunction
        public Digest getDigest() {
            return this.digest;
        }

        @Override // org.bouncycastle.crypto.DerivationFunction
        public void init(DerivationParameters r100) {
            if ((r100 instanceof KDFParameters) == false) goto L6;
            KDFParameters r101 = (KDFParameters) r100;
            this.shared = r101.getSharedSecret();
            this.f525182iv = r101.getIV();
            return;
        L6:
            if ((r100 instanceof ISO18033KDFParameters) == false) goto L10;
            this.shared = ((ISO18033KDFParameters) r100).getSeed();
            this.f525182iv = null;
            return;
        L10:
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
    }

    public EthereumIESEngine(BasicAgreement r100, DerivationFunction r101, Mac r102, byte[] r103) {
        this.agree = r100;
        this.kdf = r101;
        this.f525181mac = r102;
        this.macBuf = new byte[r102.getMacSize()];
        this.commonMac = r103;
        this.cipher = null;
    }

    public EthereumIESEngine(BasicAgreement r100, DerivationFunction r101, Mac r102, byte[] r103, BufferedBlockCipher r104) {
        this.agree = r100;
        this.kdf = r101;
        this.f525181mac = r102;
        this.macBuf = new byte[r102.getMacSize()];
        this.commonMac = r103;
        this.cipher = r104;
    }

    private byte[] decryptBlock(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        if (r112 < (this.V.length + this.f525181mac.getMacSize())) goto L38;
        if (this.cipher != null) goto L14;
        int r100 = (r112 - this.V.length) - this.f525181mac.getMacSize();
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
        byte[] r115 = Arrays.copyOfRange(r110, r114 - this.f525181mac.getMacSize(), r114);
        int r116 = r115.length;
        byte[] r117 = new byte[r116];
        SHA256Digest r118 = new SHA256Digest();
        byte[] r119 = new byte[r118.getDigestSize()];
        r118.reset();
        r118.update(r103, 0, r103.length);
        r118.doFinal(r119, 0);
        this.f525181mac.init(new KeyParameter(r119));
        Mac r120 = this.f525181mac;
        byte[] r121 = this.IV;
        r120.update(r121, 0, r121.length);
        Mac r122 = this.f525181mac;
        byte[] r123 = this.V;
        r122.update(r110, r111 + r123.length, (r112 - r123.length) - r116);
        if (r109 == null) goto L26;
        this.f525181mac.update(r109, 0, r109.length);
    L26:
        if (this.V.length == 0) goto L28;
        this.f525181mac.update(r113, 0, r113.length);
    L28:
        Mac r124 = this.f525181mac;
        byte[] r125 = this.commonMac;
        r124.update(r125, 0, r125.length);
        this.f525181mac.doFinal(r117, 0);
        if (Arrays.constantTimeAreEqual(r115, r117) == false) goto L36;
        BufferedBlockCipher r126 = this.cipher;
        if (r126 != null) goto L34;
        return r106;
    L34:
        return Arrays.copyOfRange(r106, 0, r108 + r126.doFinal(r106, r108));
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
        int r127 = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
        byte[] r128 = new byte[r127];
        int r129 = this.param.getMacKeySize() / 8;
        r103 = new byte[r129];
        int r130 = r127 + r129;
        byte[] r131 = new byte[r130];
        this.kdf.generateBytes(r131, 0, r130);
        System.arraycopy(r131, 0, r128, 0, r127);
        System.arraycopy(r131, r127, r103, 0, r129);
        CipherParameters r132 = new KeyParameter(r128);
        byte[] r133 = this.IV;
        if (r133 == null) goto L17;
        r132 = new ParametersWithIV(r132, r133);
    L17:
        this.cipher.init(false, r132);
        r106 = new byte[this.cipher.getOutputSize((r112 - this.V.length) - this.f525181mac.getMacSize())];
        BufferedBlockCipher r134 = this.cipher;
        byte[] r135 = this.V;
        r108 = r134.processBytes(r110, r111 + r135.length, (r112 - r135.length) - this.f525181mac.getMacSize(), r106, 0);
        goto L18
    L38:
        throw new InvalidCipherTextException("length of input must be greater than the MAC and V combined");
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
        int r107 = this.f525181mac.getMacSize();
        byte[] r108 = new byte[r107];
        SHA256Digest r109 = new SHA256Digest();
        byte[] r115 = new byte[r109.getDigestSize()];
        r109.reset();
        r109.update(r102, 0, r102.length);
        r109.doFinal(r115, 0);
        this.f525181mac.init(new KeyParameter(r115));
        Mac r116 = this.f525181mac;
        byte[] r117 = this.IV;
        r116.update(r117, 0, r117.length);
        this.f525181mac.update(r105, 0, r105.length);
        if (r113 == null) goto L24;
        this.f525181mac.update(r113, 0, r113.length);
    L24:
        if (this.V.length == 0) goto L26;
        this.f525181mac.update(r114, 0, r114.length);
    L26:
        Mac r118 = this.f525181mac;
        byte[] r119 = this.commonMac;
        r118.update(r119, 0, r119.length);
        this.f525181mac.doFinal(r108, 0);
        byte[] r120 = this.V;
        byte[] r121 = new byte[(r120.length + r112) + r107];
        System.arraycopy(r120, 0, r121, 0, r120.length);
        System.arraycopy(r105, 0, r121, this.V.length, r112);
        System.arraycopy(r108, 0, r121, this.V.length + r112, r107);
        return r121;
    L19:
        r114 = null;
        goto L20
    L7:
        System.arraycopy(r104, 0, r100, 0, r112);
        System.arraycopy(r104, r112, r102, 0, r101);
        goto L8
    L11:
        int r122 = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
        byte[] r123 = new byte[r122];
        int r124 = this.param.getMacKeySize() / 8;
        byte[] r125 = new byte[r124];
        int r126 = r122 + r124;
        byte[] r127 = new byte[r126];
        this.kdf.generateBytes(r127, 0, r126);
        System.arraycopy(r127, 0, r123, 0, r122);
        System.arraycopy(r127, r122, r125, 0, r124);
        if (this.IV == null) goto L14;
        BufferedBlockCipher r128 = this.cipher;
        CipherParameters r129 = new ParametersWithIV(new KeyParameter(r123), this.IV);
    L15:
        r128.init(true, r129);
        r105 = new byte[this.cipher.getOutputSize(r112)];
        int r130 = this.cipher.processBytes(r110, r111, r112, r105, 0);
        r112 = r130 + this.cipher.doFinal(r105, r130);
        r102 = r125;
        goto L16
    L14:
        r128 = this.cipher;
        r129 = new KeyParameter(r123);
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
        return this.f525181mac;
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
