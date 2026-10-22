package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
    private byte[] blockBuffer;
    private AsymmetricBlockCipher engine;
    private byte[] fallback;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private int pLen;
    private SecureRandom random;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher r100) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = r100;
        this.useStrictLength = useStrict();
    }

    public PKCS1Encoding(AsymmetricBlockCipher r100, int r101) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = r100;
        this.useStrictLength = useStrict();
        this.pLen = r101;
    }

    public PKCS1Encoding(AsymmetricBlockCipher r100, byte[] r101) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = r100;
        this.useStrictLength = useStrict();
        this.fallback = r101;
        this.pLen = r101.length;
    }

    private static int checkPkcs1Encoding(byte[] r100, int r101) {
        int r102 = 0 | (r100[0] ^ 2);
        int r103 = r101 + 1;
        int r104 = r100.length - r103;
        int r105 = 1;
    L3:
        if (r105 >= r104) goto L5;
        byte r106 = r100[r105];
        int r107 = r106 | (r106 >> 1);
        int r108 = r107 | (r107 >> 2);
        r102 = r102 | (((r108 | (r108 >> 4)) & 1) - 1);
        r105 = r105 + 1;
        goto L3
    L5:
        int r109 = r100[r100.length - r103] | r102;
        int r110 = r109 | (r109 >> 1);
        int r111 = r110 | (r110 >> 2);
        return ~(((r111 | (r111 >> 4)) & 1) - 1);
    }

    private byte[] decodeBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.pLen != (-1)) goto L5;
        byte[] r103 = this.engine.processBlock(r100, r101, r102);
        boolean r104 = this.useStrictLength;
        boolean r105 = true;
        if (r103.length == this.engine.getOutputBlockSize()) goto L9;
        boolean r106 = true;
    L10:
        boolean r107 = r104 & r106;
        if (r103.length >= getOutputBlockSize()) goto L13;
        r103 = this.blockBuffer;
    L13:
        byte r108 = r103[0];
        if (this.forPrivateKey == true) goto L16;
        if (r108 != 1) goto L17;
    L18:
        boolean r109 = false;
    L21:
        int r110 = findStart(r108, r103) + 1;
        if (r110 < 10) goto L26;
        r105 = false;
    L26:
        if ((r109 | r105) == true) goto L32;
        if (r107 == true) goto L30;
        int r111 = r103.length - r110;
        byte[] r112 = new byte[r111];
        System.arraycopy(r103, r110, r112, 0, r111);
        return r112;
    L30:
        Arrays.fill(r103, (byte) 0);
        throw new InvalidCipherTextException("block incorrect size");
    L32:
        Arrays.fill(r103, (byte) 0);
        throw new InvalidCipherTextException("block incorrect");
    L17:
        r109 = true;
        goto L21
    L16:
        if (r108 == 2) goto L18;
    L9:
        r106 = false;
        goto L10
    L5:
        return decodeBlockOrRandom(r100, r101, r102);
    }

    private byte[] decodeBlockOrRandom(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forPrivateKey == false) goto L21;
        byte[] r103 = this.engine.processBlock(r100, r101, r102);
        byte[] r104 = this.fallback;
        if (r104 != null) goto L7;
        r104 = new byte[this.pLen];
        this.random.nextBytes(r104);
    L7:
        boolean r105 = this.useStrictLength;
        if (r103.length == this.engine.getOutputBlockSize()) goto L10;
        boolean r106 = true;
    L12:
        if ((r105 & r106) == false) goto L14;
        r103 = this.blockBuffer;
    L14:
        int r107 = checkPkcs1Encoding(r103, this.pLen);
        byte[] r108 = new byte[this.pLen];
        int r109 = 0;
    L15:
        int r110 = this.pLen;
        if (r109 >= r110) goto L18;
        r108[r109] = (byte) ((r103[(r103.length - r110) + r109] & (~r107)) | (r104[r109] & r107));
        r109 = r109 + 1;
        goto L15
    L18:
        Arrays.fill(r103, (byte) 0);
        return r108;
    L10:
        r106 = false;
        goto L12
    L21:
        throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
    }

    private byte[] encodeBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (r102 > getInputBlockSize()) goto L20;
        int r103 = this.engine.getInputBlockSize();
        byte[] r104 = new byte[r103];
        if (this.forPrivateKey == false) goto L10;
        r104[0] = 1;
        int r105 = 1;
    L8:
        if (r105 == ((r103 - r102) - 1)) goto L17;
        r104[r105] = -1;
        r105 = r105 + 1;
    L17:
        int r106 = r103 - r102;
        r104[r106 - 1] = 0;
        System.arraycopy(r100, r101, r104, r106, r102);
        return this.engine.processBlock(r104, 0, r103);
    L10:
        this.random.nextBytes(r104);
        r104[0] = 2;
        int r107 = 1;
    L12:
        if (r107 == ((r103 - r102) - 1)) goto L17;
    L14:
        if (r104[r107] != 0) goto L16;
        r104[r107] = (byte) this.random.nextInt();
        goto L14
    L16:
        r107 = r107 + 1;
        goto L12
    L20:
        throw new IllegalArgumentException("input data too large");
    }

    private int findStart(byte r110, byte[] r111) throws InvalidCipherTextException {
        int r100 = 1;
        boolean r101 = false;
        int r102 = -1;
    L4:
        if (r100 == r111.length) goto L26;
        byte r103 = r111[r100];
        if (r103 != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r102 >= 0) goto L11;
        boolean r105 = true;
    L13:
        if ((r104 & r105) == false) goto L15;
        r102 = r100;
    L15:
        if (r110 != 1) goto L17;
        boolean r106 = true;
    L18:
        if (r102 >= 0) goto L20;
        boolean r107 = true;
    L21:
        boolean r108 = r106 & r107;
        if (r103 == (-1)) goto L24;
        boolean r109 = true;
    L25:
        r101 = r101 | (r109 & r108);
        r100 = r100 + 1;
        goto L4
    L24:
        r109 = false;
        goto L25
    L20:
        r107 = false;
        goto L21
    L17:
        r106 = false;
        goto L18
    L11:
        r105 = false;
        goto L13
    L8:
        r104 = false;
        goto L9
    L26:
        if (r101 == false) goto L28;
        return -1;
    L28:
        return r102;
    }

    private boolean useStrict() {
        if (Properties.isOverrideSetTo(NOT_STRICT_LENGTH_ENABLED_PROPERTY, true) == false) goto L6;
        return false;
    L6:
        return !Properties.isOverrideSetTo(STRICT_LENGTH_ENABLED_PROPERTY, false);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int r100 = this.engine.getInputBlockSize();
        if (this.forEncryption == true) goto L5;
        return r100;
    L5:
        return r100 - 10;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int r100 = this.engine.getOutputBlockSize();
        if (this.forEncryption == false) goto L6;
        return r100;
    L6:
        return r100 - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        this.random = r102.getRandom();
        AsymmetricKeyParameter r103 = (AsymmetricKeyParameter) r102.getParameters();
    L9:
        this.engine.init(r100, r101);
        this.forPrivateKey = r103.isPrivate();
        this.forEncryption = r100;
        this.blockBuffer = new byte[this.engine.getOutputBlockSize()];
        if (this.pLen > 0) goto L12;
        return;
    L12:
        if (this.fallback == null) goto L14;
        return;
    L14:
        if (this.random == null) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("encoder requires random");
    L5:
        r103 = (AsymmetricKeyParameter) r101;
        if (r103.isPrivate() == true) goto L9;
        if (r100 == false) goto L9;
        this.random = CryptoServicesRegistrar.getSecureRandom();
        goto L9
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forEncryption == false) goto L7;
        return encodeBlock(r100, r101, r102);
    L7:
        return decodeBlock(r100, r101, r102);
    }
}
