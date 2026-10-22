package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.ChaCha7539Engine;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class ChaCha20Poly1305 implements AEADCipher {
    private static final long AAD_LIMIT = -1;
    private static final int BUF_SIZE = 64;
    private static final long DATA_LIMIT = 274877906880L;
    private static final int KEY_SIZE = 32;
    private static final int MAC_SIZE = 16;
    private static final int NONCE_SIZE = 12;
    private static final byte[] ZEROES = null;
    private long aadCount;
    private final byte[] buf;
    private int bufPos;
    private final ChaCha7539Engine chacha20;
    private long dataCount;
    private byte[] initialAAD;
    private final byte[] key;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private final byte[] f525265mac;
    private final byte[] nonce;
    private final Mac poly1305;
    private int state;

    public static final class State {
        static final int DEC_AAD = 6;
        static final int DEC_DATA = 7;
        static final int DEC_FINAL = 8;
        static final int DEC_INIT = 5;
        static final int ENC_AAD = 2;
        static final int ENC_DATA = 3;
        static final int ENC_FINAL = 4;
        static final int ENC_INIT = 1;
        static final int UNINITIALIZED = 0;

        private State() {
        }
    }

    static {
        ZEROES = new byte[15];
    }

    public ChaCha20Poly1305() {
        this(new Poly1305());
    }

    public ChaCha20Poly1305(Mac r100) {
        this.key = new byte[32];
        this.nonce = new byte[12];
        this.buf = new byte[80];
        this.f525265mac = new byte[16];
        this.state = 0;
        if (r100 == null) goto L11;
        if (16 != r100.getMacSize()) goto L9;
        this.chacha20 = new ChaCha7539Engine();
        this.poly1305 = r100;
        return;
    L9:
        throw new IllegalArgumentException("'poly1305' must be a 128-bit MAC");
    L11:
        throw new NullPointerException("'poly1305' cannot be null");
    }

    private void checkAAD() {
        int r100 = this.state;
        int r101 = 2;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L6;
        return;
    L6:
        if (r100 == 4) goto L14;
        r101 = 6;
        if (r100 == 5) goto L15;
        if (r100 != 6) goto L12;
        return;
    L12:
        throw new IllegalStateException();
    L14:
        throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
    L15:
        this.state = r101;
    }

    private void checkData() {
        switch(this.state) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L12;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L12;
            default: goto L5;
        };
    L6:
        int r100 = 7;
    L10:
        finishAAD(r100);
        return;
    L9:
        r100 = 3;
        goto L10
    L12:
        return;
    L5:
        throw new IllegalStateException();
    L8:
        throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
    }

    private void finishAAD(int r100) {
        padMAC(this.aadCount);
        this.state = r100;
    }

    private void finishData(int r100) {
        padMAC(this.dataCount);
        byte[] r101 = new byte[16];
        Pack.longToLittleEndian(this.aadCount, r101, 0);
        Pack.longToLittleEndian(this.dataCount, r101, 8);
        this.poly1305.update(r101, 0, 16);
        this.poly1305.doFinal(this.f525265mac, 0);
        this.state = r100;
    }

    private long incrementCount(long r100, int r101, long r110) {
        long r102 = r101;
        if ((r100 - Long.MIN_VALUE) > ((r110 - r102) - Long.MIN_VALUE)) goto L7;
        return r100 + r102;
    L7:
        throw new IllegalStateException("Limit exceeded");
    }

    private void initMAC() {
        byte[] r100 = new byte[64];
        this.chacha20.processBytes(r100, 0, 64, r100, 0);     // Catch: Throwable -> L6
        this.poly1305.init(new KeyParameter(r100, 0, 32));     // Catch: Throwable -> L6
        Arrays.clear(r100);
        return;
    L6:
        th = move-exception;
        Arrays.clear(r100);
        throw th;
    }

    private void padMAC(long r100) {
        int r101 = ((int) r100) & 15;
        if (r101 == 0) goto L6;
        this.poly1305.update(ZEROES, 0, 16 - r101);
        return;
    }

    private void processData(byte[] r100, int r110, int r111, byte[] r112, int r113) {
        if (r113 > (r112.length - r111)) goto L7;
        this.chacha20.processBytes(r100, r110, r111, r112, r113);
        this.dataCount = incrementCount(this.dataCount, r111, DATA_LIMIT);
        return;
    L7:
        throw new OutputLengthException("Output buffer too short");
    }

    private void reset(boolean r100, boolean r101) {
        Arrays.clear(this.buf);
        if (r100 == false) goto L5;
        Arrays.clear(this.f525265mac);
    L5:
        this.aadCount = 0;
        this.dataCount = 0;
        this.bufPos = 0;
        switch(this.state) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L12;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this.state = 5;
        goto L12
    L10:
        this.state = 4;
        return;
    L12:
        if (r101 == false) goto L14;
        this.chacha20.reset();
    L14:
        initMAC();
        byte[] r102 = this.initialAAD;
        if (r102 == null) goto L18;
        processAADBytes(r102, 0, r102.length);
        return;
    L18:
        return;
    L8:
        throw new IllegalStateException();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r110, int r111) throws IllegalStateException, InvalidCipherTextException {
        if (r110 == null) goto L37;
        if (r111 < 0) goto L35;
        checkData();
        Arrays.clear(this.f525265mac);
        int r100 = this.state;
        if (r100 != 3) goto L7;
        int r101 = this.bufPos;
        int r102 = r101 + 16;
        if (r111 > (r110.length - r102)) goto L33;
        if (r101 <= 0) goto L29;
        processData(this.buf, 0, r101, r110, r111);
        this.poly1305.update(r110, r111, this.bufPos);
    L29:
        finishData(4);
        System.arraycopy(this.f525265mac, 0, r110, r111 + this.bufPos, 16);
    L30:
        reset(false, true);
        return r102;
    L33:
        throw new OutputLengthException("Output buffer too short");
    L7:
        if (r100 != 7) goto L24;
        int r103 = this.bufPos;
        if (r103 < 16) goto L22;
        r102 = r103 - 16;
        if (r111 > (r110.length - r102)) goto L20;
        if (r102 <= 0) goto L14;
        this.poly1305.update(this.buf, 0, r102);
        processData(this.buf, 0, r102, r110, r111);
    L14:
        finishData(8);
        if (Arrays.constantTimeAreEqual(16, this.f525265mac, 0, this.buf, r102) == true) goto L30;
        throw new InvalidCipherTextException("mac check in ChaCha20Poly1305 failed");
    L20:
        throw new OutputLengthException("Output buffer too short");
    L22:
        throw new InvalidCipherTextException("data too short");
    L24:
        throw new IllegalStateException();
    L35:
        throw new IllegalArgumentException("'outOff' cannot be negative");
    L37:
        throw new NullPointerException("'out' cannot be null");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return "ChaCha20Poly1305";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        return Arrays.clone(this.f525265mac);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int r100) {
        int r101 = Math.max(0, r100) + this.bufPos;
        int r102 = this.state;
        if (r102 == 1) goto L20;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L20;
        if (r102 == 5) goto L18;
        if (r102 == 6) goto L18;
        if (r102 == 7) goto L18;
        throw new IllegalStateException();
    L18:
        return Math.max(0, r101 - 16);
    L20:
        return r101 + 16;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int r100) {
        int r101 = Math.max(0, r100) + this.bufPos;
        int r102 = this.state;
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L19;
        if (r102 != 5) goto L11;
    L17:
        r101 = Math.max(0, r101 - 16);
        goto L19
    L11:
        if (r102 == 6) goto L17;
        if (r102 == 7) goto L17;
        throw new IllegalStateException();
    L19:
        return r101 - (r101 % 64);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof AEADParameters) == false) goto L10;
        AEADParameters r102 = (AEADParameters) r101;
        int r103 = r102.getMacSize();
        if (128 != r103) goto L8;
        KeyParameter r104 = r102.getKey();
        byte[] r105 = r102.getNonce();
        ParametersWithIV r106 = new ParametersWithIV(r104, r105);
        this.initialAAD = r102.getAssociatedText();
    L13:
        if (r104 != null) goto L20;
        if (this.state == 0) goto L18;
    L21:
        if (r105 == null) goto L45;
        if (12 != r105.length) goto L45;
        if (this.state == 0) goto L36;
        if (r100 == false) goto L36;
        if (Arrays.areEqual(this.nonce, r105) == false) goto L36;
        if (r104 == null) goto L34;
        if (Arrays.areEqual(this.key, r104.getKey()) == false) goto L36;
    L34:
        throw new IllegalArgumentException("cannot reuse nonce for ChaCha20Poly1305 encryption");
    L36:
        if (r104 == null) goto L38;
        System.arraycopy(r104.getKey(), 0, this.key, 0, 32);
    L38:
        System.arraycopy(r105, 0, this.nonce, 0, 12);
        this.chacha20.init(true, r106);
        if (r100 == false) goto L41;
        int r107 = 1;
    L42:
        this.state = r107;
        reset(true, false);
        return;
    L41:
        r107 = 5;
    L45:
        throw new IllegalArgumentException("Nonce must be 96 bits");
    L18:
        throw new IllegalArgumentException("Key must be specified in initial init");
    L20:
        if (32 == r104.getKey().length) goto L21;
        throw new IllegalArgumentException("Key must be 256 bits");
    L8:
        throw new IllegalArgumentException("Invalid value for MAC size: " + r103);
    L10:
        if ((r101 instanceof ParametersWithIV) == false) goto L49;
        r106 = (ParametersWithIV) r101;
        r104 = (KeyParameter) r106.getParameters();
        r105 = r106.getIV();
        this.initialAAD = null;
        goto L13
    L49:
        throw new IllegalArgumentException("invalid parameters passed to ChaCha20Poly1305");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte r100) {
        checkAAD();
        this.aadCount = incrementCount(this.aadCount, 1, -1);
        this.poly1305.update(r100);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] r100, int r101, int r110) {
        if (r100 == null) goto L18;
        if (r101 < 0) goto L16;
        if (r110 < 0) goto L14;
        if (r101 > (r100.length - r110)) goto L12;
        checkAAD();
        if (r110 <= 0) goto L19;
        this.aadCount = incrementCount(this.aadCount, r110, -1);
        this.poly1305.update(r100, r101, r110);
        return;
    L19:
        return;
    L12:
        throw new DataLengthException("Input buffer too short");
    L14:
        throw new IllegalArgumentException("'len' cannot be negative");
    L16:
        throw new IllegalArgumentException("'inOff' cannot be negative");
    L18:
        throw new NullPointerException("'in' cannot be null");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte r110, byte[] r111, int r112) throws DataLengthException {
        checkData();
        int r100 = this.state;
        if (r100 != 3) goto L5;
        byte[] r101 = this.buf;
        int r102 = this.bufPos;
        r101[r102] = r110;
        int r103 = r102 + 1;
        this.bufPos = r103;
        if (r103 != 64) goto L17;
        processData(r101, 0, 64, r111, r112);
        this.poly1305.update(r111, r112, 64);
        this.bufPos = 0;
        return 64;
    L17:
        return 0;
    L5:
        if (r100 != 7) goto L12;
        byte[] r104 = this.buf;
        int r105 = this.bufPos;
        r104[r105] = r110;
        int r106 = r105 + 1;
        this.bufPos = r106;
        if (r106 != r104.length) goto L10;
        this.poly1305.update(r104, 0, 64);
        processData(this.buf, 0, 64, r111, r112);
        byte[] r113 = this.buf;
        System.arraycopy(r113, 64, r113, 0, 16);
        this.bufPos = 16;
        return 64;
    L10:
        return 0;
    L12:
        throw new IllegalStateException();
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] r110, int r111, int r112, byte[] r210, int r211) throws DataLengthException {
        int r100 = r111;
        int r101 = r112;
        if (r110 == null) goto L43;
        if (r100 < 0) goto L41;
        if (r101 < 0) goto L39;
        if (r100 > (r110.length - r101)) goto L37;
        if (r211 < 0) goto L35;
        checkData();
        int r102 = this.state;
        if (r102 == 3) goto L22;
        if (r102 != 7) goto L20;
        int r113 = 0;
        int r114 = 0;
    L14:
        if (r113 >= r101) goto L33;
        byte[] r103 = this.buf;
        int r104 = this.bufPos;
        r103[r104] = r110[r100 + r113];
        int r105 = r104 + 1;
        this.bufPos = r105;
        if (r105 != r103.length) goto L18;
        this.poly1305.update(r103, 0, 64);
        processData(this.buf, 0, 64, r210, r211 + r114);
        byte[] r106 = this.buf;
        System.arraycopy(r106, 64, r106, 0, 16);
        this.bufPos = 16;
        r114 = r114 + 64;
    L18:
        r113 = r113 + 1;
    L33:
        return r114;
    L20:
        throw new IllegalStateException();
    L22:
        if (this.bufPos == 0) goto L28;
    L23:
        if (r101 <= 0) goto L28;
        r101 = r101 - 1;
        byte[] r107 = this.buf;
        int r108 = this.bufPos;
        int r115 = r100 + 1;
        r107[r108] = r110[r100];
        int r109 = r108 + 1;
        this.bufPos = r109;
        if (r109 == 64) goto L26;
        r100 = r115;
        goto L23
    L26:
        processData(r107, 0, 64, r210, r211);
        this.poly1305.update(r210, r211, 64);
        this.bufPos = 0;
        r100 = r115;
        r114 = 64;
    L29:
        if (r101 < 64) goto L31;
        int r116 = r211 + r114;
        processData(r110, r100, 64, r210, r116);
        this.poly1305.update(r210, r116, 64);
        r100 = r100 + 64;
        r101 = r101 - 64;
        r114 = r114 + 64;
        goto L29
    L31:
        if (r101 <= 0) goto L33;
        System.arraycopy(r110, r100, this.buf, 0, r101);
        this.bufPos = r101;
    L28:
        r114 = 0;
        goto L29
    L35:
        throw new IllegalArgumentException("'outOff' cannot be negative");
    L37:
        throw new DataLengthException("Input buffer too short");
    L39:
        throw new IllegalArgumentException("'len' cannot be negative");
    L41:
        throw new IllegalArgumentException("'inOff' cannot be negative");
    L43:
        throw new NullPointerException("'in' cannot be null");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true, true);
    }
}
