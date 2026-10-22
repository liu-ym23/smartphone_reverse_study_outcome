package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CCMBlockCipher implements AEADBlockCipher {
    private ExposedByteArrayOutputStream associatedText;
    private int blockSize;
    private BlockCipher cipher;
    private ExposedByteArrayOutputStream data;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        final /* synthetic */ CCMBlockCipher this$0;

        public ExposedByteArrayOutputStream(CCMBlockCipher r100) {
            this.this$0 = r100;
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public CCMBlockCipher(BlockCipher r100) {
        this.associatedText = new ExposedByteArrayOutputStream(this);
        this.data = new ExposedByteArrayOutputStream(this);
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.macBlock = new byte[r101];
        if (r101 != 16) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    private int calculateMac(byte[] r110, int r111, int r112, byte[] r113) {
        CBCBlockCipherMac r100 = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        r100.init(this.keyParam);
        byte[] r101 = new byte[16];
        if (hasAssociatedText() == false) goto L5;
        r101[0] = (byte) (r101[0] | 64);
    L5:
        int r102 = 2;
        byte r103 = (byte) (r101[0] | ((((r100.getMacSize() - 2) / 2) & 7) << 3));
        r101[0] = r103;
        byte[] r104 = this.nonce;
        r101[0] = (byte) (r103 | (((15 - r104.length) - 1) & 7));
        System.arraycopy(r104, 0, r101, 1, r104.length);
        int r105 = r112;
        int r106 = 1;
    L6:
        if (r105 <= 0) goto L8;
        r101[16 - r106] = (byte) (r105 & 255);
        r105 = r105 >>> 8;
        r106 = r106 + 1;
        goto L6
    L8:
        r100.update(r101, 0, 16);
        if (hasAssociatedText() == false) goto L24;
        int r107 = getAssociatedTextLength();
        if (r107 >= 65280) goto L13;
        r100.update((byte) (r107 >> 8));
        r100.update((byte) r107);
    L14:
        byte[] r108 = this.initialAssociatedText;
        if (r108 == null) goto L18;
        r100.update(r108, 0, r108.length);
    L18:
        if (this.associatedText.size() <= 0) goto L20;
        r100.update(this.associatedText.getBuffer(), 0, this.associatedText.size());
    L20:
        int r109 = (r102 + r107) % 16;
        if (r109 == 0) goto L24;
    L22:
        if (r109 == 16) goto L24;
        r100.update((byte) 0);
        r109 = r109 + 1;
        goto L22
    L13:
        r100.update((byte) -1);
        r100.update((byte) -2);
        r100.update((byte) (r107 >> 24));
        r100.update((byte) (r107 >> 16));
        r100.update((byte) (r107 >> 8));
        r100.update((byte) r107);
        r102 = 6;
    L24:
        r100.update(r110, r111, r112);
        return r100.doFinal(r113, 0);
    }

    private int getAssociatedTextLength() {
        int r100 = this.associatedText.size();
        byte[] r101 = this.initialAssociatedText;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.length;
        goto L7
    }

    private int getMacSize(boolean r100, int r101) {
        if (r100 == false) goto L13;
        if (r101 < 32) goto L11;
        if (r101 > 128) goto L11;
        if ((r101 & 15) == 0) goto L13;
    L11:
        throw new IllegalArgumentException("tag length in octets must be one of {4,6,8,10,12,14,16}");
    L13:
        return r101 >>> 3;
    }

    private boolean hasAssociatedText() {
        if (getAssociatedTextLength() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r100, int r101) throws IllegalStateException, InvalidCipherTextException {
        int r102 = processPacket(this.data.getBuffer(), 0, this.data.size(), r100, r101);
        reset();
        return r102;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        int r100 = this.macSize;
        byte[] r101 = new byte[r100];
        System.arraycopy(this.macBlock, 0, r101, 0, r100);
        return r101;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int r100) {
        int r101 = r100 + this.data.size();
        if (this.forEncryption == true) goto L5;
        int r102 = this.macSize;
        if (r101 >= r102) goto L10;
        return 0;
    L10:
        return r101 - r102;
    L5:
        return r101 + this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int r100) {
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        if ((r101 instanceof AEADParameters) == false) goto L6;
        AEADParameters r102 = (AEADParameters) r101;
        this.nonce = r102.getNonce();
        this.initialAssociatedText = r102.getAssociatedText();
        this.macSize = getMacSize(r100, r102.getMacSize());
        CipherParameters r103 = r102.getKey();
    L8:
        if (r103 == null) goto L10;
        this.keyParam = r103;
    L10:
        byte[] r104 = this.nonce;
        if (r104 == null) goto L19;
        if (r104.length < 7) goto L19;
        if (r104.length > 13) goto L19;
        reset();
        return;
    L19:
        throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
    L6:
        if ((r101 instanceof ParametersWithIV) == false) goto L21;
        ParametersWithIV r105 = (ParametersWithIV) r101;
        this.nonce = r105.getIV();
        this.initialAssociatedText = null;
        this.macSize = getMacSize(r100, 64);
        r103 = r105.getParameters();
        goto L8
    L21:
        throw new IllegalArgumentException("invalid parameters passed to CCM: ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte r100) {
        this.associatedText.write(r100);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] r100, int r101, int r102) {
        this.associatedText.write(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException, IllegalStateException {
        this.data.write(r100);
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException, IllegalStateException {
        if (r100.length < (r101 + r102)) goto L7;
        this.data.write(r100, r101, r102);
        return 0;
    L7:
        throw new DataLengthException("Input buffer too short");
    }

    public int processPacket(byte[] r110, int r111, int r112, byte[] r113, int r114) throws IllegalStateException, InvalidCipherTextException, DataLengthException {
        if (this.keyParam == null) goto L45;
        byte[] r100 = this.nonce;
        int r101 = 15 - r100.length;
        if (r101 < 4) goto L7;
    L11:
        byte[] r102 = new byte[this.blockSize];
        r102[0] = (byte) ((r101 - 1) & 7);
        System.arraycopy(r100, 0, r102, 1, r100.length);
        SICBlockCipher r103 = new SICBlockCipher(this.cipher);
        r103.init(this.forEncryption, new ParametersWithIV(this.keyParam, r102));
        if (this.forEncryption == false) goto L22;
        int r104 = this.macSize + r112;
        if (r113.length < (r104 + r114)) goto L21;
        calculateMac(r110, r111, r112, this.macBlock);
        byte[] r105 = new byte[this.blockSize];
        r103.processBlock(this.macBlock, 0, r105, 0);
        int r106 = r111;
        int r107 = r114;
    L16:
        int r108 = r111 + r112;
        int r109 = this.blockSize;
        if (r106 >= (r108 - r109)) goto L19;
        r103.processBlock(r110, r106, r113, r107);
        int r115 = this.blockSize;
        r107 = r107 + r115;
        r106 = r106 + r115;
        goto L16
    L19:
        byte[] r116 = new byte[r109];
        int r117 = r108 - r106;
        System.arraycopy(r110, r106, r116, 0, r117);
        r103.processBlock(r116, 0, r116, 0);
        System.arraycopy(r116, 0, r113, r107, r117);
        System.arraycopy(r105, 0, r113, r114 + r112, this.macSize);
        return r104;
    L21:
        throw new OutputLengthException("Output buffer too short.");
    L22:
        int r118 = this.macSize;
        if (r112 < r118) goto L43;
        int r119 = r112 - r118;
        if (r113.length < (r119 + r114)) goto L41;
        int r120 = r111 + r119;
        System.arraycopy(r110, r120, this.macBlock, 0, r118);
        byte[] r121 = this.macBlock;
        r103.processBlock(r121, 0, r121, 0);
        int r122 = this.macSize;
    L27:
        byte[] r123 = this.macBlock;
        if (r122 == r123.length) goto L30;
        r123[r122] = 0;
        r122 = r122 + 1;
        goto L27
    L30:
        int r124 = r111;
        int r125 = r114;
    L31:
        int r126 = this.blockSize;
        if (r124 >= (r120 - r126)) goto L34;
        r103.processBlock(r110, r124, r113, r125);
        int r127 = this.blockSize;
        r125 = r125 + r127;
        r124 = r124 + r127;
        goto L31
    L34:
        byte[] r128 = new byte[r126];
        int r129 = r119 - (r124 - r111);
        System.arraycopy(r110, r124, r128, 0, r129);
        r103.processBlock(r128, 0, r128, 0);
        System.arraycopy(r128, 0, r113, r125, r129);
        byte[] r130 = new byte[this.blockSize];
        calculateMac(r113, r114, r119, r130);
        if (Arrays.constantTimeAreEqual(this.macBlock, r130) == false) goto L39;
        return r119;
    L39:
        throw new InvalidCipherTextException("mac check in CCM failed");
    L41:
        throw new OutputLengthException("Output buffer too short.");
    L43:
        throw new InvalidCipherTextException("data too short");
    L7:
        if (r112 < (1 << (r101 * 8))) goto L11;
        throw new IllegalStateException("CCM packet too large for choice of q.");
    L45:
        throw new IllegalStateException("CCM cipher unitialized.");
    }

    public byte[] processPacket(byte[] r100, int r101, int r110) throws IllegalStateException, InvalidCipherTextException {
        if (this.forEncryption == false) goto L6;
        int r102 = this.macSize + r110;
    L5:
        byte[] r103 = new byte[r102];
        processPacket(r100, r101, r110, r103, 0);
        return r103;
    L6:
        int r104 = this.macSize;
        if (r110 < r104) goto L12;
        r102 = r110 - r104;
        goto L5
    L12:
        throw new InvalidCipherTextException("data too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        this.cipher.reset();
        this.associatedText.reset();
        this.data.reset();
    }
}
