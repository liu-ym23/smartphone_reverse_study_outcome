package org.bouncycastle.crypto.macs;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class VMPCMac implements Mac {
    private byte[] P;
    private byte[] T;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte f525258g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f525259n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private byte f525260s;
    private byte[] workingIV;
    private byte[] workingKey;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private byte f525261x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    private byte f525262x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    private byte f525263x3;

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    private byte f525264x4;

    public VMPCMac() {
        this.f525259n = 0;
        this.P = null;
        this.f525260s = 0;
    }

    private void initKey(byte[] r100, byte[] r101) {
        this.f525260s = 0;
        this.P = new byte[256];
        int r102 = 0;
    L3:
        if (r102 >= 256) goto L5;
        this.P[r102] = (byte) r102;
        r102 = r102 + 1;
        goto L3
    L5:
        int r103 = 0;
    L7:
        if (r103 >= 768) goto L9;
        byte[] r104 = this.P;
        byte r105 = this.f525260s;
        int r106 = r103 & 255;
        byte r107 = r104[r106];
        byte r108 = r104[((r105 + r107) + r100[r103 % r100.length]) & 255];
        this.f525260s = r108;
        r104[r106] = r104[r108 & UByte.MAX_VALUE];
        r104[r108 & UByte.MAX_VALUE] = r107;
        r103 = r103 + 1;
        goto L7
    L9:
        int r109 = 0;
    L10:
        if (r109 >= 768) goto L12;
        byte[] r110 = this.P;
        byte r111 = this.f525260s;
        int r112 = r109 & 255;
        byte r113 = r110[r112];
        byte r114 = r110[((r111 + r113) + r101[r109 % r101.length]) & 255];
        this.f525260s = r114;
        r110[r112] = r110[r114 & UByte.MAX_VALUE];
        r110[r114 & UByte.MAX_VALUE] = r113;
        r109 = r109 + 1;
        goto L10
    L12:
        this.f525259n = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r110, int r111) throws DataLengthException, IllegalStateException {
        int r100 = 1;
    L4:
        if (r100 >= 25) goto L6;
        byte[] r101 = this.P;
        byte r102 = this.f525260s;
        byte r103 = this.f525259n;
        byte r104 = r101[(r102 + r101[r103 & UByte.MAX_VALUE]) & 255];
        this.f525260s = r104;
        byte r105 = this.f525264x4;
        byte r106 = this.f525263x3;
        byte r107 = r101[((r105 + r106) + r100) & 255];
        this.f525264x4 = r107;
        byte r108 = this.f525262x2;
        byte r109 = r101[((r106 + r108) + r100) & 255];
        this.f525263x3 = r109;
        byte r112 = this.f525261x1;
        byte r113 = r101[((r108 + r112) + r100) & 255];
        this.f525262x2 = r113;
        byte r114 = r101[((r112 + r104) + r100) & 255];
        this.f525261x1 = r114;
        byte[] r115 = this.T;
        byte r116 = this.f525258g;
        r115[r116 & 31] = (byte) (r114 ^ r115[r116 & 31]);
        r115[(r116 + 1) & 31] = (byte) (r113 ^ r115[(r116 + 1) & 31]);
        r115[(r116 + 2) & 31] = (byte) (r109 ^ r115[(r116 + 2) & 31]);
        r115[(r116 + 3) & 31] = (byte) (r107 ^ r115[(r116 + 3) & 31]);
        this.f525258g = (byte) ((r116 + 4) & 31);
        byte r117 = r101[r103 & UByte.MAX_VALUE];
        r101[r103 & UByte.MAX_VALUE] = r101[r104 & UByte.MAX_VALUE];
        r101[r104 & UByte.MAX_VALUE] = r117;
        this.f525259n = (byte) ((r103 + 1) & 255);
        r100 = r100 + 1;
        goto L4
    L6:
        int r118 = 0;
    L8:
        if (r118 >= 768) goto L10;
        byte[] r119 = this.P;
        byte r120 = this.f525260s;
        int r121 = r118 & 255;
        byte r122 = r119[r121];
        byte r123 = r119[((r120 + r122) + this.T[r118 & 31]) & 255];
        this.f525260s = r123;
        r119[r121] = r119[r123 & UByte.MAX_VALUE];
        r119[r123 & UByte.MAX_VALUE] = r122;
        r118 = r118 + 1;
        goto L8
    L10:
        byte[] r124 = new byte[20];
        int r125 = 0;
    L11:
        if (r125 >= 20) goto L13;
        byte[] r126 = this.P;
        int r127 = r125 & 255;
        byte r128 = r126[(this.f525260s + r126[r127]) & 255];
        this.f525260s = r128;
        r124[r125] = r126[(r126[r126[r128 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];
        byte r129 = r126[r127];
        r126[r127] = r126[r128 & UByte.MAX_VALUE];
        r126[r128 & UByte.MAX_VALUE] = r129;
        r125 = r125 + 1;
        goto L11
    L13:
        System.arraycopy(r124, 0, r110, r111, 20);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof ParametersWithIV) == false) goto L19;
        ParametersWithIV r101 = (ParametersWithIV) r100;
        KeyParameter r102 = (KeyParameter) r101.getParameters();
        if ((r101.getParameters() instanceof KeyParameter) == false) goto L17;
        byte[] r103 = r101.getIV();
        this.workingIV = r103;
        if (r103 == null) goto L15;
        if (r103.length < 1) goto L15;
        if (r103.length > 768) goto L15;
        this.workingKey = r102.getKey();
        reset();
        return;
    L15:
        throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
    L17:
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
    L19:
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        initKey(this.workingKey, this.workingIV);
        this.f525259n = 0;
        this.f525264x4 = 0;
        this.f525263x3 = 0;
        this.f525262x2 = 0;
        this.f525261x1 = 0;
        this.f525258g = 0;
        this.T = new byte[32];
        int r100 = 0;
    L3:
        if (r100 >= 32) goto L5;
        this.T[r100] = 0;
        r100 = r100 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r110) throws IllegalStateException {
        byte[] r100 = this.P;
        byte r101 = this.f525260s;
        byte r102 = this.f525259n;
        byte r103 = r100[(r101 + r100[r102 & UByte.MAX_VALUE]) & 255];
        this.f525260s = r103;
        byte r111 = (byte) (r110 ^ r100[(r100[r100[r103 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255]);
        byte r104 = this.f525264x4;
        byte r105 = this.f525263x3;
        byte r106 = r100[(r104 + r105) & 255];
        this.f525264x4 = r106;
        byte r107 = this.f525262x2;
        byte r108 = r100[(r105 + r107) & 255];
        this.f525263x3 = r108;
        byte r109 = this.f525261x1;
        byte r112 = r100[(r107 + r109) & 255];
        this.f525262x2 = r112;
        byte r113 = r100[((r109 + r103) + r111) & 255];
        this.f525261x1 = r113;
        byte[] r114 = this.T;
        byte r115 = this.f525258g;
        r114[r115 & 31] = (byte) (r113 ^ r114[r115 & 31]);
        r114[(r115 + 1) & 31] = (byte) (r112 ^ r114[(r115 + 1) & 31]);
        r114[(r115 + 2) & 31] = (byte) (r108 ^ r114[(r115 + 2) & 31]);
        r114[(r115 + 3) & 31] = (byte) (r106 ^ r114[(r115 + 3) & 31]);
        this.f525258g = (byte) ((r115 + 4) & 31);
        byte r116 = r100[r102 & UByte.MAX_VALUE];
        r100[r102 & UByte.MAX_VALUE] = r100[r103 & UByte.MAX_VALUE];
        r100[r103 & UByte.MAX_VALUE] = r116;
        this.f525259n = (byte) ((r102 + 1) & 255);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) throws DataLengthException, IllegalStateException {
        if ((r101 + r102) > r100.length) goto L9;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        update(r100[r101 + r103]);
        r103 = r103 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new DataLengthException("input buffer too short");
    }
}
