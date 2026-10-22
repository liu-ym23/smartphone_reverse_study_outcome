package org.bouncycastle.crypto.modes;

import java.util.Vector;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class OCBBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] Checksum;
    private byte[] KtopInput;
    private Vector L;
    private byte[] L_Asterisk;
    private byte[] L_Dollar;
    private byte[] OffsetHASH;
    private byte[] OffsetMAIN;
    private byte[] OffsetMAIN_0;
    private byte[] Stretch;
    private byte[] Sum;
    private boolean forEncryption;
    private byte[] hashBlock;
    private long hashBlockCount;
    private int hashBlockPos;
    private BlockCipher hashCipher;
    private byte[] initialAssociatedText;
    private byte[] macBlock;
    private int macSize;
    private byte[] mainBlock;
    private long mainBlockCount;
    private int mainBlockPos;
    private BlockCipher mainCipher;

    public OCBBlockCipher(BlockCipher r100, BlockCipher r101) {
        this.KtopInput = null;
        this.Stretch = new byte[24];
        this.OffsetMAIN_0 = new byte[16];
        this.OffsetMAIN = new byte[16];
        if (r100 == null) goto L22;
        if (r100.getBlockSize() != 16) goto L20;
        if (r101 == null) goto L18;
        if (r101.getBlockSize() != 16) goto L16;
        if (r100.getAlgorithmName().equals(r101.getAlgorithmName()) == false) goto L14;
        this.hashCipher = r100;
        this.mainCipher = r101;
        return;
    L14:
        throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
    L16:
        throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
    L18:
        throw new IllegalArgumentException("'mainCipher' cannot be null");
    L20:
        throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
    L22:
        throw new IllegalArgumentException("'hashCipher' cannot be null");
    }

    public static byte[] OCB_double(byte[] r100) {
        byte[] r101 = new byte[16];
        int r102 = shiftLeft(r100, r101);
        int r103 = 135 >>> ((1 - r102) << 3);
        r101[15] = (byte) (r103 ^ r101[15]);
        return r101;
    }

    public static void OCB_extend(byte[] r100, int r101) {
        r100[r101] = ByteCompanionObject.MIN_VALUE;
    L3:
        r101 = r101 + 1;
        if (r101 >= 16) goto L6;
        r100[r101] = 0;
        goto L3
    }

    public static int OCB_ntz(long r100) {
        if (r100 != 0) goto L6;
        return 64;
    L6:
        int r101 = 0;
    L8:
        if ((1 & r100) != 0) goto L10;
        r101 = r101 + 1;
        r100 = r100 >>> 1;
        goto L8
    L10:
        return r101;
    }

    public static int shiftLeft(byte[] r100, byte[] r101) {
        int r102 = 16;
        int r103 = 0;
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L6;
        int r104 = r100[r102] & UByte.MAX_VALUE;
        r101[r102] = (byte) (r103 | (r104 << 1));
        r103 = (r104 >>> 7) & 1;
        goto L3
    L6:
        return r103;
    }

    public static void xor(byte[] r100, byte[] r101) {
        int r102 = 15;
    L3:
        if (r102 < 0) goto L5;
        r100[r102] = (byte) (r100[r102] ^ r101[r102]);
        r102 = r102 - 1;
        goto L3
    }

    public void clear(byte[] r100) {
        if (r100 == null) goto L5;
        Arrays.fill(r100, (byte) 0);
        return;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r100, int r101) throws IllegalStateException, InvalidCipherTextException {
        if (this.forEncryption == true) goto L9;
        int r102 = this.mainBlockPos;
        int r103 = this.macSize;
        if (r102 < r103) goto L8;
        int r104 = r102 - r103;
        this.mainBlockPos = r104;
        byte[] r105 = new byte[r103];
        System.arraycopy(this.mainBlock, r104, r105, 0, r103);
    L10:
        int r106 = this.hashBlockPos;
        if (r106 <= 0) goto L13;
        OCB_extend(this.hashBlock, r106);
        updateHASH(this.L_Asterisk);
    L13:
        int r107 = this.mainBlockPos;
        if (r107 > 0) goto L16;
    L25:
        xor(this.Checksum, this.OffsetMAIN);
        xor(this.Checksum, this.L_Dollar);
        BlockCipher r108 = this.hashCipher;
        byte[] r109 = this.Checksum;
        r108.processBlock(r109, 0, r109, 0);
        xor(this.Checksum, this.Sum);
        int r110 = this.macSize;
        byte[] r111 = new byte[r110];
        this.macBlock = r111;
        System.arraycopy(this.Checksum, 0, r111, 0, r110);
        int r112 = this.mainBlockPos;
        if (this.forEncryption == false) goto L33;
        int r113 = r100.length;
        int r114 = r101 + r112;
        int r115 = this.macSize;
        if (r113 < (r114 + r115)) goto L31;
        System.arraycopy(this.macBlock, 0, r100, r114, r115);
        r112 = r112 + this.macSize;
    L34:
        reset(false);
        return r112;
    L31:
        throw new OutputLengthException("Output buffer too short");
    L33:
        if (Arrays.constantTimeAreEqual(this.macBlock, r105) == true) goto L34;
        throw new InvalidCipherTextException("mac check in OCB failed");
    L16:
        if (this.forEncryption == false) goto L18;
        OCB_extend(this.mainBlock, r107);
        xor(this.Checksum, this.mainBlock);
    L18:
        xor(this.OffsetMAIN, this.L_Asterisk);
        byte[] r116 = new byte[16];
        this.hashCipher.processBlock(this.OffsetMAIN, 0, r116, 0);
        xor(this.mainBlock, r116);
        int r117 = r100.length;
        int r118 = this.mainBlockPos;
        if (r117 < (r101 + r118)) goto L24;
        System.arraycopy(this.mainBlock, 0, r100, r101, r118);
        if (this.forEncryption == true) goto L25;
        OCB_extend(this.mainBlock, this.mainBlockPos);
        xor(this.Checksum, this.mainBlock);
        goto L25
    L24:
        throw new OutputLengthException("Output buffer too short");
    L8:
        throw new InvalidCipherTextException("data too short");
    L9:
        r105 = null;
        goto L10
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.mainCipher.getAlgorithmName() + "/OCB";
    }

    public byte[] getLSub(int r100) {
    L3:
        if (r100 < this.L.size()) goto L6;
        Vector r101 = this.L;
        r101.addElement(OCB_double((byte[]) r101.lastElement()));
        goto L3
    L6:
        return (byte[]) this.L.elementAt(r100);
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
        int r101 = r100 + this.mainBlockPos;
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
        return this.mainCipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int r100) {
        int r101 = r100 + this.mainBlockPos;
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
    public void init(boolean r100, CipherParameters r110) throws IllegalArgumentException {
        boolean r101 = this.forEncryption;
        this.forEncryption = r100;
        this.macBlock = null;
        if ((r110 instanceof AEADParameters) == false) goto L14;
        AEADParameters r111 = (AEADParameters) r110;
        byte[] r102 = r111.getNonce();
        this.initialAssociatedText = r111.getAssociatedText();
        int r103 = r111.getMacSize();
        if (r103 < 64) goto L12;
        if (r103 > 128) goto L12;
        if ((r103 % 8) != 0) goto L12;
        this.macSize = r103 / 8;
        KeyParameter r112 = r111.getKey();
    L16:
        this.hashBlock = new byte[16];
        if (r100 == false) goto L19;
        int r104 = 16;
    L20:
        this.mainBlock = new byte[r104];
        if (r102 != null) goto L24;
        r102 = new byte[0];
    L24:
        if (r102.length > 15) goto L42;
        if (r112 == null) goto L28;
        this.hashCipher.init(true, r112);
        this.mainCipher.init(r100, r112);
        this.KtopInput = null;
    L29:
        byte[] r105 = new byte[16];
        this.L_Asterisk = r105;
        this.hashCipher.processBlock(r105, 0, r105, 0);
        this.L_Dollar = OCB_double(this.L_Asterisk);
        Vector r106 = new Vector();
        this.L = r106;
        r106.addElement(OCB_double(this.L_Dollar));
        int r107 = processNonce(r102);
        int r113 = r107 % 8;
        int r108 = r107 / 8;
        if (r113 != 0) goto L32;
        System.arraycopy(this.Stretch, r108, this.OffsetMAIN_0, 0, 16);
    L35:
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0;
        this.mainBlockCount = 0;
        this.OffsetHASH = new byte[16];
        this.Sum = new byte[16];
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        this.Checksum = new byte[16];
        byte[] r109 = this.initialAssociatedText;
        if (r109 == null) goto L46;
        processAADBytes(r109, 0, r109.length);
        return;
    L46:
        return;
    L32:
        int r114 = 0;
    L33:
        if (r114 >= 16) goto L35;
        byte[] r115 = this.Stretch;
        int r116 = r115[r108] & UByte.MAX_VALUE;
        r108 = r108 + 1;
        this.OffsetMAIN_0[r114] = (byte) (((r115[r108] & UByte.MAX_VALUE) >>> (8 - r113)) | (r116 << r113));
        r114 = r114 + 1;
        goto L33
    L28:
        if (r101 == r100) goto L29;
        throw new IllegalArgumentException("cannot change encrypting state without providing key.");
    L42:
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    L19:
        r104 = this.macSize + 16;
    L12:
        throw new IllegalArgumentException("Invalid value for MAC size: " + r103);
    L14:
        if ((r110 instanceof ParametersWithIV) == false) goto L44;
        ParametersWithIV r117 = (ParametersWithIV) r110;
        r102 = r117.getIV();
        this.initialAssociatedText = null;
        this.macSize = 16;
        r112 = (KeyParameter) r117.getParameters();
        goto L16
    L44:
        throw new IllegalArgumentException("invalid parameters passed to OCB");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte r100) {
        byte[] r101 = this.hashBlock;
        int r102 = this.hashBlockPos;
        r101[r102] = r100;
        int r103 = r102 + 1;
        this.hashBlockPos = r103;
        if (r103 != r101.length) goto L6;
        processHashBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        byte[] r104 = this.hashBlock;
        int r105 = this.hashBlockPos;
        r104[r105] = r100[r101 + r103];
        int r106 = r105 + 1;
        this.hashBlockPos = r106;
        if (r106 != r104.length) goto L7;
        processHashBlock();
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException {
        byte[] r103 = this.mainBlock;
        int r104 = this.mainBlockPos;
        r103[r104] = r100;
        int r105 = r104 + 1;
        this.mainBlockPos = r105;
        if (r105 != r103.length) goto L6;
        processMainBlock(r101, r102);
        return 16;
    L6:
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r110) throws DataLengthException {
        if (r100.length < (r101 + r102)) goto L12;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r102) goto L10;
        byte[] r106 = this.mainBlock;
        int r107 = this.mainBlockPos;
        r106[r107] = r100[r101 + r104];
        int r108 = r107 + 1;
        this.mainBlockPos = r108;
        if (r108 != r106.length) goto L9;
        processMainBlock(r103, r110 + r105);
        r105 = r105 + 16;
    L9:
        r104 = r104 + 1;
        goto L5
    L10:
        return r105;
    L12:
        throw new DataLengthException("Input buffer too short");
    }

    public void processHashBlock() {
        long r100 = this.hashBlockCount + 1;
        this.hashBlockCount = r100;
        updateHASH(getLSub(OCB_ntz(r100)));
        this.hashBlockPos = 0;
    }

    public void processMainBlock(byte[] r100, int r101) {
        if (r100.length < (r101 + 16)) goto L12;
        if (this.forEncryption == false) goto L7;
        xor(this.Checksum, this.mainBlock);
        this.mainBlockPos = 0;
    L7:
        byte[] r102 = this.OffsetMAIN;
        long r103 = this.mainBlockCount + 1;
        this.mainBlockCount = r103;
        xor(r102, getLSub(OCB_ntz(r103)));
        xor(this.mainBlock, this.OffsetMAIN);
        BlockCipher r104 = this.mainCipher;
        byte[] r105 = this.mainBlock;
        r104.processBlock(r105, 0, r105, 0);
        xor(this.mainBlock, this.OffsetMAIN);
        System.arraycopy(this.mainBlock, 0, r100, r101, 16);
        if (this.forEncryption == true) goto L13;
        xor(this.Checksum, this.mainBlock);
        byte[] r106 = this.mainBlock;
        System.arraycopy(r106, 16, r106, 0, this.macSize);
        this.mainBlockPos = this.macSize;
        return;
    L13:
        return;
    L12:
        throw new OutputLengthException("Output buffer too short");
    }

    public int processNonce(byte[] r100) {
        byte[] r101 = new byte[16];
        int r102 = 0;
        System.arraycopy(r100, 0, r101, 16 - r100.length, r100.length);
        r101[0] = (byte) (this.macSize << 4);
        int r103 = 15 - r100.length;
        r101[r103] = (byte) (r101[r103] | 1);
        byte r104 = r101[15];
        int r105 = r104 & 63;
        r101[15] = (byte) (r104 & 192);
        byte[] r106 = this.KtopInput;
        if (r106 != null) goto L5;
    L6:
        byte[] r107 = new byte[16];
        this.KtopInput = r101;
        this.hashCipher.processBlock(r101, 0, r107, 0);
        System.arraycopy(r107, 0, this.Stretch, 0, 16);
    L8:
        if (r102 >= 8) goto L10;
        byte[] r108 = this.Stretch;
        int r109 = r102 + 16;
        byte r110 = r107[r102];
        r102 = r102 + 1;
        r108[r109] = (byte) (r110 ^ r107[r102]);
    L10:
        return r105;
    L5:
        if (Arrays.areEqual(r101, r106) == true) goto L10;
        goto L6
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true);
    }

    public void reset(boolean r100) {
        this.hashCipher.reset();
        this.mainCipher.reset();
        clear(this.hashBlock);
        clear(this.mainBlock);
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0;
        this.mainBlockCount = 0;
        clear(this.OffsetHASH);
        clear(this.Sum);
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        clear(this.Checksum);
        if (r100 == false) goto L5;
        this.macBlock = null;
    L5:
        byte[] r101 = this.initialAssociatedText;
        if (r101 == null) goto L9;
        processAADBytes(r101, 0, r101.length);
        return;
    }

    public void updateHASH(byte[] r100) {
        xor(this.OffsetHASH, r100);
        xor(this.hashBlock, this.OffsetHASH);
        BlockCipher r101 = this.hashCipher;
        byte[] r102 = this.hashBlock;
        r101.processBlock(r102, 0, r102, 0);
        xor(this.Sum, this.hashBlock);
    }
}
