package org.bouncycastle.crypto.modes;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.gcm.BasicGCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.crypto.modes.gcm.Tables4kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class GCMBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] H;
    private byte[] J0;
    private byte[] S;
    private byte[] S_at;
    private byte[] S_atPre;
    private byte[] atBlock;
    private int atBlockPos;
    private long atLength;
    private long atLengthPre;
    private int blocksRemaining;
    private byte[] bufBlock;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] counter;
    private GCMExponentiator exp;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private boolean initialised;
    private byte[] lastKey;
    private byte[] macBlock;
    private int macSize;
    private GCMMultiplier multiplier;
    private byte[] nonce;
    private long totalLength;

    public GCMBlockCipher(BlockCipher r100) {
        this(r100, null);
    }

    public GCMBlockCipher(BlockCipher r100, GCMMultiplier r101) {
        if (r100.getBlockSize() != 16) goto L9;
        if (r101 != null) goto L6;
        r101 = new Tables4kGCMMultiplier();
    L6:
        this.cipher = r100;
        this.multiplier = r101;
        return;
    L9:
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    private void checkStatus() {
        if (this.initialised == false) goto L5;
        return;
    L5:
        if (this.forEncryption == false) goto L9;
        throw new IllegalStateException("GCM cipher cannot be reused for encryption");
    L9:
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }

    private void gHASH(byte[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        gHASHPartial(r100, r101, r103, Math.min(r102 - r103, 16));
        r103 = r103 + 16;
        goto L3
    }

    private void gHASHBlock(byte[] r100, byte[] r101) {
        GCMUtil.xor(r100, r101);
        this.multiplier.multiplyH(r100);
    }

    private void gHASHBlock(byte[] r100, byte[] r101, int r102) {
        GCMUtil.xor(r100, r101, r102);
        this.multiplier.multiplyH(r100);
    }

    private void gHASHPartial(byte[] r100, byte[] r101, int r102, int r103) {
        GCMUtil.xor(r100, r101, r102, r103);
        this.multiplier.multiplyH(r100);
    }

    private void getNextCTRBlock(byte[] r100) {
        int r101 = this.blocksRemaining;
        if (r101 == 0) goto L7;
        this.blocksRemaining = r101 - 1;
        byte[] r102 = this.counter;
        int r103 = (r102[15] & UByte.MAX_VALUE) + 1;
        r102[15] = (byte) r103;
        int r104 = (r103 >>> 8) + (r102[14] & UByte.MAX_VALUE);
        r102[14] = (byte) r104;
        int r105 = (r104 >>> 8) + (r102[13] & UByte.MAX_VALUE);
        r102[13] = (byte) r105;
        r102[12] = (byte) ((r105 >>> 8) + (r102[12] & UByte.MAX_VALUE));
        this.cipher.processBlock(r102, 0, r100, 0);
        return;
    L7:
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    private void initCipher() {
        if (this.atLength <= 0) goto L5;
        System.arraycopy(this.S_at, 0, this.S_atPre, 0, 16);
        this.atLengthPre = this.atLength;
    L5:
        int r100 = this.atBlockPos;
        if (r100 <= 0) goto L9;
        gHASHPartial(this.S_atPre, this.atBlock, 0, r100);
        this.atLengthPre += (long) this.atBlockPos;
    L9:
        if (this.atLengthPre <= 0) goto L12;
        System.arraycopy(this.S_atPre, 0, this.S, 0, 16);
        return;
    }

    private void processBlock(byte[] r100, int r110, byte[] r111, int r112) {
        if ((r111.length - r112) < 16) goto L14;
        if (this.totalLength != 0) goto L7;
        initCipher();
    L7:
        byte[] r101 = new byte[16];
        getNextCTRBlock(r101);
        if (this.forEncryption == false) goto L10;
        GCMUtil.xor(r101, r100, r110);
        gHASHBlock(this.S, r101);
        System.arraycopy(r101, 0, r111, r112, 16);
    L11:
        this.totalLength += 16;
        return;
    L10:
        gHASHBlock(this.S, r100, r110);
        GCMUtil.xor(r101, 0, r100, r110, r111, r112);
        goto L11
    L14:
        throw new OutputLengthException("Output buffer too short");
    }

    private void processPartial(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        byte[] r105 = new byte[16];
        getNextCTRBlock(r105);
        if (this.forEncryption == false) goto L5;
        GCMUtil.xor(r100, r101, r105, 0, r102);
        gHASHPartial(this.S, r100, r101, r102);
    L6:
        System.arraycopy(r100, r101, r103, r104, r102);
        this.totalLength += (long) r102;
        return;
    L5:
        gHASHPartial(this.S, r100, r101, r102);
        GCMUtil.xor(r100, r101, r105, 0, r102);
        goto L6
    }

    private void reset(boolean r100) {
        this.cipher.reset();
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0;
        this.atLengthPre = 0;
        this.counter = Arrays.clone(this.J0);
        this.blocksRemaining = -2;
        this.bufOff = 0;
        this.totalLength = 0;
        byte[] r101 = this.bufBlock;
        if (r101 == null) goto L5;
        Arrays.fill(r101, (byte) 0);
    L5:
        if (r100 == false) goto L8;
        this.macBlock = null;
    L8:
        if (this.forEncryption == false) goto L10;
        this.initialised = false;
        return;
    L10:
        byte[] r102 = this.initialAssociatedText;
        if (r102 == null) goto L15;
        processAADBytes(r102, 0, r102.length);
        return;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r110, int r111) throws IllegalStateException, InvalidCipherTextException {
        checkStatus();
        if (this.totalLength != 0) goto L5;
        initCipher();
    L5:
        int r100 = this.bufOff;
        if (this.forEncryption == true) goto L8;
        int r101 = this.macSize;
        if (r100 < r101) goto L41;
        r100 = r100 - r101;
        if ((r110.length - r111) < r100) goto L39;
    L16:
        if (r100 <= 0) goto L18;
        processPartial(this.bufBlock, 0, r100, r110, r111);
    L18:
        long r102 = this.atLength;
        int r103 = this.atBlockPos;
        long r104 = r102 + ((long) r103);
        this.atLength = r104;
        if (r104 <= this.atLengthPre) goto L29;
        if (r103 <= 0) goto L23;
        gHASHPartial(this.S_at, this.atBlock, 0, r103);
    L23:
        if (this.atLengthPre <= 0) goto L25;
        GCMUtil.xor(this.S_at, this.S_atPre);
    L25:
        long r105 = ((this.totalLength * 8) + 127) >>> 7;
        byte[] r106 = new byte[16];
        if (this.exp != null) goto L28;
        BasicGCMExponentiator r107 = new BasicGCMExponentiator();
        this.exp = r107;
        r107.init(this.H);
    L28:
        this.exp.exponentiateX(r105, r106);
        GCMUtil.multiply(this.S_at, r106);
        GCMUtil.xor(this.S, this.S_at);
    L29:
        byte[] r108 = new byte[16];
        Pack.longToBigEndian(this.atLength * 8, r108, 0);
        Pack.longToBigEndian(this.totalLength * 8, r108, 8);
        gHASHBlock(this.S, r108);
        byte[] r109 = new byte[16];
        this.cipher.processBlock(this.J0, 0, r109, 0);
        GCMUtil.xor(r109, this.S);
        int r112 = this.macSize;
        byte[] r113 = new byte[r112];
        this.macBlock = r113;
        System.arraycopy(r109, 0, r113, 0, r112);
        if (this.forEncryption == false) goto L32;
        System.arraycopy(this.macBlock, 0, r110, r111 + this.bufOff, this.macSize);
        r100 = r100 + this.macSize;
    L34:
        reset(false);
        return r100;
    L32:
        int r114 = this.macSize;
        byte[] r115 = new byte[r114];
        System.arraycopy(this.bufBlock, r100, r115, 0, r114);
        if (Arrays.constantTimeAreEqual(this.macBlock, r115) == true) goto L34;
        throw new InvalidCipherTextException("mac check in GCM failed");
    L39:
        throw new OutputLengthException("Output buffer too short");
    L41:
        throw new InvalidCipherTextException("data too short");
    L8:
        if ((r110.length - r111) >= (this.macSize + r100)) goto L16;
        throw new OutputLengthException("Output buffer too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        byte[] r100 = this.macBlock;
        if (r100 != null) goto L7;
        return new byte[this.macSize];
    L7:
        return Arrays.clone(r100);
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
        return this.cipher;
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
        return r101 - (r101 % 16);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        this.macBlock = null;
        this.initialised = true;
        if ((r101 instanceof AEADParameters) == false) goto L14;
        AEADParameters r102 = (AEADParameters) r101;
        byte[] r103 = r102.getNonce();
        this.initialAssociatedText = r102.getAssociatedText();
        int r104 = r102.getMacSize();
        if (r104 < 32) goto L12;
        if (r104 > 128) goto L12;
        if ((r104 % 8) != 0) goto L12;
        this.macSize = r104 / 8;
        KeyParameter r105 = r102.getKey();
    L16:
        if (r100 == false) goto L18;
        int r106 = 16;
    L19:
        this.bufBlock = new byte[r106];
        if (r103 == null) goto L58;
        if (r103.length < 1) goto L58;
        if (r100 == false) goto L39;
        byte[] r107 = this.nonce;
        if (r107 == null) goto L39;
        if (Arrays.areEqual(r107, r103) == false) goto L39;
        if (r105 == null) goto L38;
        byte[] r108 = this.lastKey;
        if (r108 == null) goto L39;
        if (Arrays.areEqual(r108, r105.getKey()) == false) goto L39;
        throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
    L38:
        throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
    L39:
        this.nonce = r103;
        if (r105 == null) goto L43;
        this.lastKey = r105.getKey();
    L43:
        if (r105 == null) goto L46;
        this.cipher.init(true, r105);
        byte[] r109 = new byte[16];
        this.H = r109;
        this.cipher.processBlock(r109, 0, r109, 0);
        this.multiplier.init(this.H);
        this.exp = null;
    L47:
        byte[] r110 = new byte[16];
        this.J0 = r110;
        byte[] r111 = this.nonce;
        if (r111.length != 12) goto L50;
        System.arraycopy(r111, 0, r110, 0, r111.length);
        this.J0[15] = 1;
    L51:
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0;
        this.atLengthPre = 0;
        this.counter = Arrays.clone(this.J0);
        this.blocksRemaining = -2;
        this.bufOff = 0;
        this.totalLength = 0;
        byte[] r112 = this.initialAssociatedText;
        if (r112 == null) goto L61;
        processAADBytes(r112, 0, r112.length);
        return;
    L61:
        return;
    L50:
        gHASH(r110, r111, r111.length);
        byte[] r113 = new byte[16];
        Pack.longToBigEndian(((long) this.nonce.length) * 8, r113, 8);
        gHASHBlock(this.J0, r113);
        goto L51
    L46:
        if (this.H != null) goto L47;
        throw new IllegalArgumentException("Key must be specified in initial init");
    L58:
        throw new IllegalArgumentException("IV must be at least 1 byte");
    L18:
        r106 = this.macSize + 16;
    L12:
        throw new IllegalArgumentException("Invalid value for MAC size: " + r104);
    L14:
        if ((r101 instanceof ParametersWithIV) == false) goto L60;
        ParametersWithIV r114 = (ParametersWithIV) r101;
        r103 = r114.getIV();
        this.initialAssociatedText = null;
        this.macSize = 16;
        r105 = (KeyParameter) r114.getParameters();
        goto L16
    L60:
        throw new IllegalArgumentException("invalid parameters passed to GCM");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte r100) {
        checkStatus();
        byte[] r101 = this.atBlock;
        int r102 = this.atBlockPos;
        r101[r102] = r100;
        int r103 = r102 + 1;
        this.atBlockPos = r103;
        if (r103 != 16) goto L6;
        gHASHBlock(this.S_at, r101);
        this.atBlockPos = 0;
        this.atLength += 16;
        return;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] r100, int r101, int r102) {
        checkStatus();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        byte[] r104 = this.atBlock;
        int r105 = this.atBlockPos;
        r104[r105] = r100[r101 + r103];
        int r106 = r105 + 1;
        this.atBlockPos = r106;
        if (r106 != 16) goto L7;
        gHASHBlock(this.S_at, r104);
        this.atBlockPos = 0;
        this.atLength += 16;
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException {
        checkStatus();
        byte[] r103 = this.bufBlock;
        int r104 = this.bufOff;
        r103[r104] = r100;
        int r105 = r104 + 1;
        this.bufOff = r105;
        if (r105 != r103.length) goto L9;
        processBlock(r103, 0, r101, r102);
        if (this.forEncryption == false) goto L7;
        this.bufOff = 0;
    L8:
        return 16;
    L7:
        byte[] r106 = this.bufBlock;
        System.arraycopy(r106, 16, r106, 0, this.macSize);
        this.bufOff = this.macSize;
        goto L8
    L9:
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] r100, int r101, int r110, byte[] r111, int r112) throws DataLengthException {
        checkStatus();
        if ((r100.length - r101) < r110) goto L26;
        if (this.forEncryption == true) goto L7;
        int r102 = 0;
        int r103 = 0;
    L19:
        if (r103 >= r110) goto L24;
        byte[] r104 = this.bufBlock;
        int r105 = this.bufOff;
        r104[r105] = r100[r101 + r103];
        int r106 = r105 + 1;
        this.bufOff = r106;
        if (r106 != r104.length) goto L23;
        processBlock(r104, 0, r111, r112 + r102);
        byte[] r107 = this.bufBlock;
        System.arraycopy(r107, 16, r107, 0, this.macSize);
        this.bufOff = this.macSize;
        r102 = r102 + 16;
    L23:
        r103 = r103 + 1;
    L24:
        return r102;
    L7:
        if (this.bufOff == 0) goto L13;
    L8:
        if (r110 <= 0) goto L13;
        r110 = r110 - 1;
        byte[] r108 = this.bufBlock;
        int r109 = this.bufOff;
        int r113 = r101 + 1;
        r108[r109] = r100[r101];
        int r114 = r109 + 1;
        this.bufOff = r114;
        if (r114 == 16) goto L11;
        r101 = r113;
        goto L8
    L11:
        processBlock(r108, 0, r111, r112);
        this.bufOff = 0;
        r101 = r113;
        r102 = 16;
    L14:
        if (r110 < 16) goto L16;
        processBlock(r100, r101, r111, r112 + r102);
        r101 = r101 + 16;
        r110 = r110 - 16;
        r102 = r102 + 16;
        goto L14
    L16:
        if (r110 <= 0) goto L24;
        System.arraycopy(r100, r101, this.bufBlock, 0, r110);
        this.bufOff = r110;
    L13:
        r102 = 0;
        goto L14
    L26:
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true);
    }
}
