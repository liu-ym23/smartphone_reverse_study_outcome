package org.bouncycastle.crypto.engines;

import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class VMPCKSA3Engine extends VMPCEngine {
    public VMPCKSA3Engine() {
    }

    @Override // org.bouncycastle.crypto.engines.VMPCEngine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC-KSA3";
    }

    @Override // org.bouncycastle.crypto.engines.VMPCEngine
    public void initKey(byte[] r100, byte[] r110) {
        this.f525207s = 0;
        this.P = new byte[256];
        int r101 = 0;
    L3:
        if (r101 >= 256) goto L5;
        this.P[r101] = (byte) r101;
        r101 = r101 + 1;
        goto L3
    L5:
        int r102 = 0;
    L7:
        if (r102 >= 768) goto L9;
        byte[] r103 = this.P;
        byte r104 = this.f525207s;
        int r105 = r102 & 255;
        byte r106 = r103[r105];
        byte r107 = r103[((r104 + r106) + r100[r102 % r100.length]) & 255];
        this.f525207s = r107;
        r103[r105] = r103[r107 & UByte.MAX_VALUE];
        r103[r107 & UByte.MAX_VALUE] = r106;
        r102 = r102 + 1;
        goto L7
    L9:
        int r108 = 0;
    L10:
        if (r108 >= 768) goto L12;
        byte[] r109 = this.P;
        byte r111 = this.f525207s;
        int r112 = r108 & 255;
        byte r113 = r109[r112];
        byte r114 = r109[((r111 + r113) + r110[r108 % r110.length]) & 255];
        this.f525207s = r114;
        r109[r112] = r109[r114 & UByte.MAX_VALUE];
        r109[r114 & UByte.MAX_VALUE] = r113;
        r108 = r108 + 1;
        goto L10
    L12:
        int r115 = 0;
    L13:
        if (r115 >= 768) goto L15;
        byte[] r116 = this.P;
        byte r117 = this.f525207s;
        int r118 = r115 & 255;
        byte r119 = r116[r118];
        byte r120 = r116[((r117 + r119) + r100[r115 % r100.length]) & 255];
        this.f525207s = r120;
        r116[r118] = r116[r120 & UByte.MAX_VALUE];
        r116[r120 & UByte.MAX_VALUE] = r119;
        r115 = r115 + 1;
        goto L13
    L15:
        this.f525206n = 0;
    }
}
