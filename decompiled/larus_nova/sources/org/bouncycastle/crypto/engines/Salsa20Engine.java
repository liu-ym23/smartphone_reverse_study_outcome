package org.bouncycastle.crypto.engines;

import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class Salsa20Engine implements SkippingStreamCipher {
    public static final int DEFAULT_ROUNDS = 20;
    private static final int STATE_SIZE = 16;
    private static final int[] TAU_SIGMA = null;
    protected static final byte[] sigma = null;
    protected static final byte[] tau = null;
    private int cW0;
    private int cW1;
    private int cW2;
    protected int[] engineState;
    private int index;
    private boolean initialised;
    private byte[] keyStream;
    protected int rounds;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525201x;

    static {
        TAU_SIGMA = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
        sigma = Strings.toByteArray("expand 32-byte k");
        tau = Strings.toByteArray("expand 16-byte k");
    }

    public Salsa20Engine() {
        this(20);
    }

    public Salsa20Engine(int r100) {
        this.index = 0;
        this.engineState = new int[16];
        this.f525201x = new int[16];
        this.keyStream = new byte[64];
        this.initialised = false;
        if (r100 <= 0) goto L9;
        if ((r100 & 1) != 0) goto L9;
        this.rounds = r100;
        return;
    L9:
        throw new IllegalArgumentException("'rounds' must be a positive, even number");
    }

    private boolean limitExceeded() {
        int r100 = this.cW0 + 1;
        this.cW0 = r100;
        if (r100 != 0) goto L11;
        int r101 = this.cW1 + 1;
        this.cW1 = r101;
        if (r101 != 0) goto L11;
        int r102 = this.cW2 + 1;
        this.cW2 = r102;
        if ((r102 & 32) != 0) goto L12;
        return false;
    L12:
        return true;
    L11:
        return false;
    }

    private boolean limitExceeded(int r100) {
        int r101 = this.cW0 + r100;
        this.cW0 = r101;
        if (r101 >= r100) goto L11;
        if (r101 < 0) goto L12;
        int r102 = this.cW1 + 1;
        this.cW1 = r102;
        if (r102 != 0) goto L13;
        int r103 = this.cW2 + 1;
        this.cW2 = r103;
        if ((r103 & 32) == 0) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    private void resetLimitCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    public static void salsaCore(int r310, int[] r311, int[] r312) {
        if (r311.length != 16) goto L18;
        if (r312.length != 16) goto L16;
        if ((r310 % 2) != 0) goto L14;
        int r100 = r311[0];
        int r101 = r311[1];
        int r102 = r311[2];
        int r103 = r311[3];
        int r110 = r311[4];
        int r111 = r311[5];
        int r112 = r311[6];
        int r113 = 7;
        int r114 = r311[7];
        int r115 = r311[8];
        int r116 = 9;
        int r117 = r311[9];
        int r210 = r311[10];
        int r211 = r311[11];
        int r212 = r311[12];
        int r118 = 13;
        int r213 = r311[13];
        int r214 = r311[14];
        int r313 = r311[15];
        int r314 = r214;
        int r215 = r213;
        int r216 = r212;
        int r217 = r211;
        int r218 = r210;
        int r219 = r117;
        int r119 = r115;
        int r120 = r114;
        int r121 = r112;
        int r122 = r111;
        int r123 = r110;
        int r124 = r103;
        int r104 = r102;
        int r105 = r101;
        int r106 = r100;
        int r107 = r310;
    L9:
        if (r107 <= 0) goto L11;
        int r108 = Integers.rotateLeft(r106 + r216, r113) ^ r123;
        int r125 = r119 ^ Integers.rotateLeft(r108 + r106, r116);
        int r109 = r216 ^ Integers.rotateLeft(r125 + r108, r118);
        int r126 = Integers.rotateLeft(r109 + r125, 18) ^ r106;
        int r127 = r219 ^ Integers.rotateLeft(r122 + r105, r113);
        int r128 = r215 ^ Integers.rotateLeft(r127 + r122, r116);
        int r129 = r105 ^ Integers.rotateLeft(r128 + r127, r118);
        int r130 = Integers.rotateLeft(r129 + r128, 18) ^ r122;
        int r131 = r314 ^ Integers.rotateLeft(r218 + r121, 7);
        int r132 = r104 ^ Integers.rotateLeft(r131 + r218, 9);
        int r133 = r121 ^ Integers.rotateLeft(r132 + r131, 13);
        int r134 = r218 ^ Integers.rotateLeft(r133 + r132, 18);
        int r135 = r124 ^ Integers.rotateLeft(r313 + r217, 7);
        int r136 = r120 ^ Integers.rotateLeft(r135 + r313, 9);
        int r315 = r107;
        int r137 = r217 ^ Integers.rotateLeft(r136 + r135, 13);
        int r138 = r313 ^ Integers.rotateLeft(r137 + r136, 18);
        r105 = r129 ^ Integers.rotateLeft(r126 + r135, 7);
        r104 = r132 ^ Integers.rotateLeft(r105 + r126, 9);
        int r139 = r135 ^ Integers.rotateLeft(r104 + r105, 13);
        int r140 = r126 ^ Integers.rotateLeft(r139 + r104, 18);
        r121 = r133 ^ Integers.rotateLeft(r130 + r108, 7);
        r120 = r136 ^ Integers.rotateLeft(r121 + r130, 9);
        int r141 = Integers.rotateLeft(r120 + r121, 13) ^ r108;
        r122 = r130 ^ Integers.rotateLeft(r141 + r120, 18);
        r217 = r137 ^ Integers.rotateLeft(r134 + r127, 7);
        int r142 = Integers.rotateLeft(r217 + r134, 9) ^ r125;
        r219 = r127 ^ Integers.rotateLeft(r142 + r217, 13);
        r218 = r134 ^ Integers.rotateLeft(r219 + r142, 18);
        r216 = r109 ^ Integers.rotateLeft(r138 + r131, 7);
        r215 = r128 ^ Integers.rotateLeft(r216 + r138, 9);
        r314 = r131 ^ Integers.rotateLeft(r215 + r216, 13);
        r313 = r138 ^ Integers.rotateLeft(r314 + r215, 18);
        r124 = r139;
        r119 = r142;
        r106 = r140;
        r123 = r141;
        r118 = 13;
        r116 = 9;
        r113 = 7;
        r107 = r315 - 2;
        goto L9
    L11:
        r312[0] = r106 + r311[0];
        r312[1] = r105 + r311[1];
        r312[2] = r104 + r311[2];
        r312[3] = r124 + r311[3];
        r312[4] = r123 + r311[4];
        r312[5] = r122 + r311[5];
        r312[6] = r121 + r311[6];
        r312[7] = r120 + r311[7];
        r312[8] = r119 + r311[8];
        r312[9] = r219 + r311[9];
        r312[10] = r218 + r311[10];
        r312[11] = r217 + r311[11];
        r312[12] = r216 + r311[12];
        r312[13] = r215 + r311[13];
        r312[14] = r314 + r311[14];
        r312[15] = r313 + r311[15];
        return;
    L14:
        throw new IllegalArgumentException("Number of rounds must be even");
    L16:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalArgumentException();
    }

    public void advanceCounter() {
        int[] r100 = this.engineState;
        int r101 = r100[8] + 1;
        r100[8] = r101;
        if (r101 != 0) goto L6;
        r100[9] = r100[9] + 1;
        return;
    }

    public void advanceCounter(long r100) {
        int r101 = (int) (r100 >>> 32);
        int r102 = (int) r100;
        if (r101 <= 0) goto L5;
        int[] r103 = this.engineState;
        r103[9] = r103[9] + r101;
    L5:
        int[] r104 = this.engineState;
        int r105 = r104[8];
        int r106 = r102 + r105;
        r104[8] = r106;
        if (r105 == 0) goto L10;
        if (r106 >= r105) goto L11;
        r104[9] = r104[9] + 1;
        return;
    L11:
        return;
    }

    public void generateKeyStream(byte[] r100) {
        salsaCore(this.rounds, this.engineState, this.f525201x);
        Pack.intToLittleEndian(this.f525201x, r100, 0);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        if (this.rounds != 20) goto L7;
        return "Salsa20";
    L7:
        return "Salsa20/" + this.rounds;
    }

    public long getCounter() {
        int[] r100 = this.engineState;
        return (((long) r100[9]) << 32) | (((long) r100[8]) & BodyPartID.bodyIdMax);
    }

    public int getNonceSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long getPosition() {
        return (getCounter() * 64) + ((long) this.index);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithIV) == false) goto L25;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        if (r103 == null) goto L23;
        if (r103.length != getNonceSize()) goto L23;
        CipherParameters r104 = r102.getParameters();
        if (r104 != null) goto L16;
        if (this.initialised == false) goto L14;
        setKey(null, r103);
    L18:
        reset();
        this.initialised = true;
        return;
    L14:
        throw new IllegalStateException(getAlgorithmName() + " KeyParameter can not be null for first initialisation");
    L16:
        if ((r104 instanceof KeyParameter) == false) goto L21;
        setKey(((KeyParameter) r104).getKey(), r103);
        goto L18
    L21:
        throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must contain a KeyParameter (or null for re-init)");
    L23:
        throw new IllegalArgumentException(getAlgorithmName() + " requires exactly " + getNonceSize() + " bytes of IV");
    L25:
        throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must include an IV");
    }

    public void packTauOrSigma(int r100, int[] r101, int r102) {
        int r103 = (r100 - 16) / 4;
        int[] r104 = TAU_SIGMA;
        r101[r102] = r104[r103];
        r101[r102 + 1] = r104[r103 + 1];
        r101[r102 + 2] = r104[r103 + 2];
        r101[r102 + 3] = r104[r103 + 3];
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r110) {
        if (this.initialised == false) goto L24;
        if ((r101 + r102) > r100.length) goto L22;
        if ((r110 + r102) > r103.length) goto L20;
        if (limitExceeded(r102) == true) goto L18;
        int r104 = 0;
    L11:
        if (r104 >= r102) goto L16;
        byte[] r105 = this.keyStream;
        int r106 = this.index;
        r103[r104 + r110] = (byte) (r105[r106] ^ r100[r104 + r101]);
        int r107 = (r106 + 1) & 63;
        this.index = r107;
        if (r107 != 0) goto L15;
        advanceCounter();
        generateKeyStream(this.keyStream);
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        return r102;
    L18:
        throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
    L20:
        throw new OutputLengthException("output buffer too short");
    L22:
        throw new DataLengthException("input buffer too short");
    L24:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        this.index = 0;
        resetLimitCounter();
        resetCounter();
        generateKeyStream(this.keyStream);
    }

    public void resetCounter() {
        int[] r100 = this.engineState;
        r100[9] = 0;
        r100[8] = 0;
    }

    public void retreatCounter() {
        int[] r100 = this.engineState;
        int r101 = r100[8];
        if (r101 == 0) goto L5;
    L9:
        int r102 = r101 - 1;
        r100[8] = r102;
        if (r102 != (-1)) goto L13;
        r100[9] = r100[9] - 1;
        return;
    L13:
        return;
    L5:
        if (r100[9] != 0) goto L9;
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    public void retreatCounter(long r110) {
        int r100 = (int) (r110 >>> 32);
        int r111 = (int) r110;
        if (r100 == 0) goto L9;
        int[] r101 = this.engineState;
        int r102 = r101[9];
        if ((((long) r102) & BodyPartID.bodyIdMax) < (((long) r100) & BodyPartID.bodyIdMax)) goto L8;
        r101[9] = r102 - r100;
        goto L9
    L8:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    L9:
        int[] r103 = this.engineState;
        int r104 = r103[8];
        if ((((long) r104) & BodyPartID.bodyIdMax) < (BodyPartID.bodyIdMax & ((long) r111))) goto L12;
        r103[8] = r104 - r111;
        return;
    L12:
        int r105 = r103[9];
        if (r105 == 0) goto L17;
        r103[9] = r105 - 1;
        r103[8] = r104 - r111;
        return;
    L17:
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        if (limitExceeded() == true) goto L9;
        byte[] r101 = this.keyStream;
        int r102 = this.index;
        byte r103 = (byte) (r100 ^ r101[r102]);
        int r104 = (r102 + 1) & 63;
        this.index = r104;
        if (r104 != 0) goto L7;
        advanceCounter();
        generateKeyStream(this.keyStream);
    L7:
        return r103;
    L9:
        throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long seekTo(long r100) {
        reset();
        return skip(r100);
    }

    public void setKey(byte[] r100, byte[] r110) {
        if (r100 != null) goto L5;
    L12:
        Pack.littleEndianToInt(r110, 0, this.engineState, 6, 2);
        return;
    L5:
        if (r100.length != 16) goto L7;
    L11:
        int r101 = (r100.length - 16) / 4;
        int[] r102 = this.engineState;
        int[] r103 = TAU_SIGMA;
        r102[0] = r103[r101];
        r102[5] = r103[r101 + 1];
        r102[10] = r103[r101 + 2];
        r102[15] = r103[r101 + 3];
        Pack.littleEndianToInt(r100, 0, r102, 1, 4);
        Pack.littleEndianToInt(r100, r100.length - 16, this.engineState, 11, 4);
        goto L12
    L7:
        if (r100.length == 32) goto L11;
        throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long skip(long r100) {
        long r101 = 0;
        if (r100 >= 0) goto L5;
        long r102 = -r100;
        if (r102 < 64) goto L15;
        long r103 = r102 / 64;
        retreatCounter(r103);
        r102 = r102 - (r103 * 64);
    L15:
        if (r101 >= r102) goto L20;
        if (this.index != 0) goto L19;
        retreatCounter();
    L19:
        this.index = (this.index - 1) & 63;
        r101 = r101 + 1;
    L20:
        generateKeyStream(this.keyStream);
        return r100;
    L5:
        if (r100 < 64) goto L7;
        long r104 = r100 / 64;
        advanceCounter(r104);
        long r105 = r100 - (r104 * 64);
    L8:
        int r106 = this.index;
        int r107 = (((int) r105) + r106) & 63;
        this.index = r107;
        if (r107 >= r106) goto L20;
        advanceCounter();
        goto L20
    L7:
        r105 = r100;
        goto L8
    }
}
