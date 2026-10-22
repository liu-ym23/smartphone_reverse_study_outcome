package org.bouncycastle.crypto.macs;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithSBox;

/* JADX INFO: loaded from: classes42.dex */
public class GOST28147Mac implements Mac {
    private byte[] S;
    private int blockSize;
    private byte[] buf;
    private int bufOff;
    private boolean firstStep;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private byte[] f525229mac;
    private byte[] macIV;
    private int macSize;
    private int[] workingKey;

    public GOST28147Mac() {
        this.blockSize = 8;
        this.macSize = 4;
        this.firstStep = true;
        this.workingKey = null;
        this.macIV = null;
        this.S = new byte[]{9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, HTTP.CR, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, HTTP.CR, 1, 14, 4, 6, 2, 11, 3, HTTP.CR, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, HTTP.CR, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, HTTP.CR, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, HTTP.CR, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, HTTP.CR, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, HTTP.CR, 4};
        this.f525229mac = new byte[8];
        this.buf = new byte[8];
        this.bufOff = 0;
    }

    private byte[] CM5func(byte[] r100, int r101, byte[] r102) {
        byte[] r103 = new byte[r100.length - r101];
        int r104 = 0;
        System.arraycopy(r100, r101, r103, 0, r102.length);
    L4:
        if (r104 == r102.length) goto L6;
        r103[r104] = (byte) (r103[r104] ^ r102[r104]);
        r104 = r104 + 1;
        goto L4
    L6:
        return r103;
    }

    private int bytesToint(byte[] r100, int r101) {
        return ((((r100[r101 + 3] << 24) & (-16777216)) + ((r100[r101 + 2] << 16) & 16711680)) + ((r100[r101 + 1] << 8) & 65280)) + (r100[r101] & UByte.MAX_VALUE);
    }

    private int[] generateWorkingKey(byte[] r100) {
        if (r100.length != 32) goto L9;
        int[] r101 = new int[8];
        int r102 = 0;
    L5:
        if (r102 == 8) goto L7;
        r101[r102] = bytesToint(r100, r102 * 4);
        r102 = r102 + 1;
        goto L5
    L7:
        return r101;
    L9:
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    private void gost28147MacFunc(int[] r100, byte[] r101, int r102, byte[] r103, int r110) {
        int r104 = bytesToint(r101, r102);
        int r105 = bytesToint(r101, r102 + 4);
        int r106 = 0;
    L4:
        if (r106 >= 2) goto L10;
        int r107 = 0;
    L7:
        if (r107 >= 8) goto L9;
        int r108 = r105 ^ gost28147_mainStep(r104, r100[r107]);
        r107 = r107 + 1;
        int r109 = r104;
        r104 = r108;
        r105 = r109;
        goto L7
    L9:
        r106 = r106 + 1;
        goto L4
    L10:
        intTobytes(r104, r103, r110);
        intTobytes(r105, r103, r110 + 4);
    }

    private int gost28147_mainStep(int r100, int r101) {
        int r102 = r101 + r100;
        byte[] r103 = this.S;
        int r104 = (((((((r103[((r102 >> 0) & 15) + 0] << 0) + (r103[((r102 >> 4) & 15) + 16] << 4)) + (r103[((r102 >> 8) & 15) + 32] << 8)) + (r103[((r102 >> 12) & 15) + 48] << 12)) + (r103[((r102 >> 16) & 15) + 64] << 16)) + (r103[((r102 >> 20) & 15) + 80] << 20)) + (r103[((r102 >> 24) & 15) + 96] << 24)) + (r103[((r102 >> 28) & 15) + 112] << 28);
        return (r104 << 11) | (r104 >>> 21);
    }

    private void intTobytes(int r100, byte[] r101, int r102) {
        r101[r102 + 3] = (byte) (r100 >>> 24);
        r101[r102 + 2] = (byte) (r100 >>> 16);
        r101[r102 + 1] = (byte) (r100 >>> 8);
        r101[r102] = (byte) r100;
    }

    private void recursiveInit(CipherParameters r100) throws IllegalArgumentException {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ParametersWithSBox) == false) goto L8;
        ParametersWithSBox r101 = (ParametersWithSBox) r100;
        System.arraycopy(r101.getSBox(), 0, this.S, 0, r101.getSBox().length);
        CipherParameters r102 = r101.getParameters();
    L13:
        recursiveInit(r102);
        return;
    L8:
        if ((r100 instanceof KeyParameter) == false) goto L11;
        this.workingKey = generateWorkingKey(((KeyParameter) r100).getKey());
        r102 = null;
        goto L13
    L11:
        if ((r100 instanceof ParametersWithIV) == false) goto L16;
        ParametersWithIV r103 = (ParametersWithIV) r100;
        byte[] r104 = r103.getIV();
        byte[] r105 = this.f525229mac;
        System.arraycopy(r104, 0, r105, 0, r105.length);
        this.macIV = r103.getIV();
        r102 = r103.getParameters();
        goto L13
    L16:
        throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - ".concat(r100.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r110) throws DataLengthException, IllegalStateException {
    L2:
        int r101 = this.bufOff;
        if (r101 >= this.blockSize) goto L5;
        this.buf[r101] = 0;
        this.bufOff = r101 + 1;
        goto L2
    L5:
        byte[] r102 = this.buf;
        byte[] r103 = new byte[r102.length];
        System.arraycopy(r102, 0, r103, 0, this.f525229mac.length);
        if (this.firstStep == false) goto L8;
        this.firstStep = false;
    L9:
        int[] r104 = this.workingKey;
        gost28147MacFunc(r104, r103, 0, this.f525229mac, 0);
        byte[] r105 = this.f525229mac;
        int r106 = r105.length / 2;
        int r107 = this.macSize;
        System.arraycopy(r105, r106 - r107, r100, r110, r107);
        reset();
        return this.macSize;
    L8:
        r103 = CM5func(this.buf, 0, this.f525229mac);
        goto L9
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        reset();
        this.buf = new byte[this.blockSize];
        this.macIV = null;
        recursiveInit(r100);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        int r100 = 0;
    L3:
        byte[] r101 = this.buf;
        if (r100 >= r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    L6:
        this.bufOff = 0;
        this.firstStep = true;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r110) throws IllegalStateException {
        int r100 = this.bufOff;
        byte[] r101 = this.buf;
        if (r100 != r101.length) goto L11;
        byte[] r102 = new byte[r101.length];
        System.arraycopy(r101, 0, r102, 0, this.f525229mac.length);
        if (this.firstStep == false) goto L9;
        this.firstStep = false;
        byte[] r103 = this.macIV;
        if (r103 == null) goto L10;
        r102 = CM5func(this.buf, 0, r103);
    L10:
        int[] r104 = this.workingKey;
        gost28147MacFunc(r104, r102, 0, this.f525229mac, 0);
        this.bufOff = 0;
        goto L11
    L9:
        r102 = CM5func(this.buf, 0, this.f525229mac);
    L11:
        byte[] r105 = this.buf;
        int r106 = this.bufOff;
        this.bufOff = r106 + 1;
        r105[r106] = r110;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r110, int r111, int r112) throws DataLengthException, IllegalStateException {
        if (r112 < 0) goto L18;
        int r100 = this.blockSize;
        int r101 = this.bufOff;
        int r102 = r100 - r101;
        if (r112 <= r102) goto L15;
        System.arraycopy(r110, r111, this.buf, r101, r102);
        byte[] r103 = this.buf;
        byte[] r104 = new byte[r103.length];
        System.arraycopy(r103, 0, r104, 0, this.f525229mac.length);
        if (this.firstStep == false) goto L10;
        this.firstStep = false;
        byte[] r105 = this.macIV;
        if (r105 == null) goto L11;
        r104 = CM5func(this.buf, 0, r105);
    L11:
        gost28147MacFunc(this.workingKey, r104, 0, this.f525229mac, 0);
        this.bufOff = 0;
    L12:
        r112 = r112 - r102;
        r111 = r111 + r102;
        if (r112 <= this.blockSize) goto L15;
        gost28147MacFunc(this.workingKey, CM5func(r110, r111, this.f525229mac), 0, this.f525229mac, 0);
        r102 = this.blockSize;
        goto L12
    L10:
        r104 = CM5func(this.buf, 0, this.f525229mac);
    L15:
        System.arraycopy(r110, r111, this.buf, this.bufOff, r112);
        this.bufOff += r112;
        return;
    L18:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
