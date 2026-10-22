package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class VMPCEngine implements StreamCipher {
    protected byte[] P;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected byte f525206n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected byte f525207s;
    protected byte[] workingIV;
    protected byte[] workingKey;

    public VMPCEngine() {
        this.f525206n = 0;
        this.P = null;
        this.f525207s = 0;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithIV) == false) goto L19;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        if ((r102.getParameters() instanceof KeyParameter) == false) goto L17;
        KeyParameter r103 = (KeyParameter) r102.getParameters();
        byte[] r104 = r102.getIV();
        this.workingIV = r104;
        if (r104 == null) goto L15;
        if (r104.length < 1) goto L15;
        if (r104.length > 768) goto L15;
        byte[] r105 = r103.getKey();
        this.workingKey = r105;
        initKey(r105, this.workingIV);
        return;
    L15:
        throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
    L17:
        throw new IllegalArgumentException("VMPC init parameters must include a key");
    L19:
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    public void initKey(byte[] r100, byte[] r101) {
        this.f525207s = 0;
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
        byte r105 = this.f525207s;
        int r106 = r103 & 255;
        byte r107 = r104[r106];
        byte r108 = r104[((r105 + r107) + r100[r103 % r100.length]) & 255];
        this.f525207s = r108;
        r104[r106] = r104[r108 & UByte.MAX_VALUE];
        r104[r108 & UByte.MAX_VALUE] = r107;
        r103 = r103 + 1;
        goto L7
    L9:
        int r109 = 0;
    L10:
        if (r109 >= 768) goto L12;
        byte[] r110 = this.P;
        byte r111 = this.f525207s;
        int r112 = r109 & 255;
        byte r113 = r110[r112];
        byte r114 = r110[((r111 + r113) + r101[r109 % r101.length]) & 255];
        this.f525207s = r114;
        r110[r112] = r110[r114 & UByte.MAX_VALUE];
        r110[r114 & UByte.MAX_VALUE] = r113;
        r109 = r109 + 1;
        goto L10
    L12:
        this.f525206n = 0;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r110, int r111, byte[] r112, int r113) {
        if ((r110 + r111) > r100.length) goto L13;
        if ((r113 + r111) > r112.length) goto L11;
        int r101 = 0;
    L7:
        if (r101 >= r111) goto L9;
        byte[] r102 = this.P;
        byte r103 = this.f525207s;
        byte r104 = this.f525206n;
        byte r105 = r102[(r103 + r102[r104 & UByte.MAX_VALUE]) & 255];
        this.f525207s = r105;
        byte r106 = r102[(r102[r102[r105 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];
        byte r107 = r102[r104 & UByte.MAX_VALUE];
        r102[r104 & UByte.MAX_VALUE] = r102[r105 & UByte.MAX_VALUE];
        r102[r105 & UByte.MAX_VALUE] = r107;
        this.f525206n = (byte) ((r104 + 1) & 255);
        r112[r101 + r113] = (byte) (r100[r101 + r110] ^ r106);
        r101 = r101 + 1;
        goto L7
    L9:
        return r111;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        byte[] r101 = this.P;
        byte r102 = this.f525207s;
        byte r103 = this.f525206n;
        byte r104 = r101[(r102 + r101[r103 & UByte.MAX_VALUE]) & 255];
        this.f525207s = r104;
        byte r105 = r101[(r101[r101[r104 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];
        byte r106 = r101[r103 & UByte.MAX_VALUE];
        r101[r103 & UByte.MAX_VALUE] = r101[r104 & UByte.MAX_VALUE];
        r101[r104 & UByte.MAX_VALUE] = r106;
        this.f525206n = (byte) ((r103 + 1) & 255);
        return (byte) (r100 ^ r105);
    }
}
