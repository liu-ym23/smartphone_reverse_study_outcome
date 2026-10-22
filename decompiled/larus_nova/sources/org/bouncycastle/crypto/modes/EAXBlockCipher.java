package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private SICBlockCipher cipher;
    private boolean cipherInitialized;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private Mac f525266mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonceMac;

    public EAXBlockCipher(BlockCipher r100) {
        this.blockSize = r100.getBlockSize();
        CMac r101 = new CMac(r100);
        this.f525266mac = r101;
        this.macBlock = new byte[this.blockSize];
        this.associatedTextMac = new byte[r101.getMacSize()];
        this.nonceMac = new byte[this.f525266mac.getMacSize()];
        this.cipher = new SICBlockCipher(r100);
    }

    private void calculateMac() {
        byte[] r100 = new byte[this.blockSize];
        int r101 = 0;
        this.f525266mac.doFinal(r100, 0);
    L3:
        byte[] r102 = this.macBlock;
        if (r101 >= r102.length) goto L6;
        r102[r101] = (byte) ((this.nonceMac[r101] ^ this.associatedTextMac[r101]) ^ r100[r101]);
        r101 = r101 + 1;
        goto L3
    }

    private void initCipher() {
        if (this.cipherInitialized == false) goto L5;
        return;
    L5:
        this.cipherInitialized = true;
        this.f525266mac.doFinal(this.associatedTextMac, 0);
        int r100 = this.blockSize;
        byte[] r101 = new byte[r100];
        r101[r100 - 1] = 2;
        this.f525266mac.update(r101, 0, r100);
    }

    private int process(byte r100, byte[] r101, int r102) {
        byte[] r103 = this.bufBlock;
        int r104 = this.bufOff;
        int r105 = r104 + 1;
        this.bufOff = r105;
        r103[r104] = r100;
        if (r105 != r103.length) goto L16;
        int r106 = r101.length;
        int r107 = this.blockSize;
        if (r106 < (r102 + r107)) goto L15;
        if (this.forEncryption == false) goto L9;
        int r108 = this.cipher.processBlock(r103, 0, r101, r102);
        this.f525266mac.update(r101, r102, this.blockSize);
    L10:
        this.bufOff = 0;
        if (this.forEncryption == true) goto L13;
        byte[] r109 = this.bufBlock;
        System.arraycopy(r109, this.blockSize, r109, 0, this.macSize);
        this.bufOff = this.macSize;
    L13:
        return r108;
    L9:
        this.f525266mac.update(r103, 0, r107);
        r108 = this.cipher.processBlock(this.bufBlock, 0, r101, r102);
        goto L10
    L15:
        throw new OutputLengthException("Output buffer is too short");
    L16:
        return 0;
    }

    private void reset(boolean r100) {
        this.cipher.reset();
        this.f525266mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (r100 == false) goto L5;
        Arrays.fill(this.macBlock, (byte) 0);
    L5:
        int r101 = this.blockSize;
        byte[] r102 = new byte[r101];
        r102[r101 - 1] = 1;
        this.f525266mac.update(r102, 0, r101);
        this.cipherInitialized = false;
        byte[] r103 = this.initialAssociatedText;
        if (r103 == null) goto L9;
        processAADBytes(r103, 0, r103.length);
        return;
    }

    private boolean verifyMac(byte[] r100, int r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= this.macSize) goto L6;
        r103 = r103 | (this.macBlock[r102] ^ r100[r101 + r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        if (r103 != 0) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r100, int r110) throws IllegalStateException, InvalidCipherTextException {
        initCipher();
        int r101 = this.bufOff;
        byte[] r102 = this.bufBlock;
        byte[] r103 = new byte[r102.length];
        this.bufOff = 0;
        if (this.forEncryption == false) goto L10;
        int r104 = r110 + r101;
        if (r100.length < (this.macSize + r104)) goto L9;
        this.cipher.processBlock(r102, 0, r103, 0);
        System.arraycopy(r103, 0, r100, r110, r101);
        this.f525266mac.update(r103, 0, r101);
        calculateMac();
        System.arraycopy(this.macBlock, 0, r100, r104, this.macSize);
        reset(false);
        return r101 + this.macSize;
    L9:
        throw new OutputLengthException("Output buffer too short");
    L10:
        int r105 = this.macSize;
        if (r101 < r105) goto L25;
        if (r100.length < ((r110 + r101) - r105)) goto L23;
        if (r101 <= r105) goto L16;
        this.f525266mac.update(r102, 0, r101 - r105);
        this.cipher.processBlock(this.bufBlock, 0, r103, 0);
        System.arraycopy(r103, 0, r100, r110, r101 - this.macSize);
    L16:
        calculateMac();
        if (verifyMac(this.bufBlock, r101 - this.macSize) == false) goto L21;
        reset(false);
        return r101 - this.macSize;
    L21:
        throw new InvalidCipherTextException("mac check in EAX failed");
    L23:
        throw new OutputLengthException("Output buffer too short");
    L25:
        throw new InvalidCipherTextException("data too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
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
        int r101 = r100 + this.bufOff;
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
        return this.cipher.getUnderlyingCipher();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int r100) {
        int r101 = r100 + this.bufOff;
        if (this.forEncryption == true) goto L10;
        int r102 = this.macSize;
        if (r101 >= r102) goto L8;
        return 0;
    L8:
        r101 = r101 - r102;
    L10:
        return r101 - (r101 % this.blockSize);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        if ((r101 instanceof AEADParameters) == false) goto L6;
        AEADParameters r102 = (AEADParameters) r101;
        byte[] r103 = r102.getNonce();
        this.initialAssociatedText = r102.getAssociatedText();
        this.macSize = r102.getMacSize() / 8;
        CipherParameters r104 = r102.getKey();
    L8:
        if (r100 == false) goto L10;
        int r105 = this.blockSize;
    L11:
        this.bufBlock = new byte[r105];
        byte[] r106 = new byte[this.blockSize];
        this.f525266mac.init(r104);
        int r107 = this.blockSize;
        r106[r107 - 1] = 0;
        this.f525266mac.update(r106, 0, r107);
        this.f525266mac.update(r103, 0, r103.length);
        this.f525266mac.doFinal(this.nonceMac, 0);
        this.cipher.init(true, new ParametersWithIV(null, this.nonceMac));
        reset();
        return;
    L10:
        r105 = this.blockSize + this.macSize;
        goto L11
    L6:
        if ((r101 instanceof ParametersWithIV) == false) goto L14;
        ParametersWithIV r108 = (ParametersWithIV) r101;
        r103 = r108.getIV();
        this.initialAssociatedText = null;
        this.macSize = this.f525266mac.getMacSize() / 2;
        r104 = r108.getParameters();
        goto L8
    L14:
        throw new IllegalArgumentException("invalid parameters passed to EAX");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte r100) {
        if (this.cipherInitialized == true) goto L7;
        this.f525266mac.update(r100);
        return;
    L7:
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] r100, int r101, int r102) {
        if (this.cipherInitialized == true) goto L7;
        this.f525266mac.update(r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException {
        initCipher();
        return process(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException {
        initCipher();
        if (r100.length < (r101 + r102)) goto L9;
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r105 == r102) goto L7;
        r106 = r106 + process(r100[r101 + r105], r103, r104 + r106);
        r105 = r105 + 1;
        goto L5
    L7:
        return r106;
    L9:
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true);
    }
}
