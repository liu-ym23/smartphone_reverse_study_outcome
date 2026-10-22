package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Tables64kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][][] T;

    public Tables64kGCMMultiplier() {
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] r100) {
        if (this.T != null) goto L6;
        this.T = (long[][][]) Array.newInstance(Long.TYPE, new int[]{16, 256, 2});
    L8:
        this.H = Arrays.clone(r100);
        int r101 = 0;
    L10:
        if (r101 >= 16) goto L20;
        long[][][] r102 = this.T;
        long[][] r103 = r102[r101];
        if (r101 != 0) goto L14;
        GCMUtil.asLongs(this.H, r103[1]);
        long[] r104 = r103[1];
        GCMUtil.multiplyP7(r104, r104);
    L15:
        int r105 = 2;
    L17:
        if (r105 >= 256) goto L19;
        GCMUtil.divideP(r103[r105 >> 1], r103[r105]);
        GCMUtil.xor(r103[r105], r103[1], r103[r105 + 1]);
        r105 = r105 + 2;
        goto L17
    L19:
        r101 = r101 + 1;
        goto L10
    L14:
        GCMUtil.multiplyP8(r102[r101 - 1][1], r103[1]);
        goto L15
    L20:
        return;
    L6:
        if (Arrays.areEqual(this.H, r100) == false) goto L8;
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] r110) {
        long[] r100 = this.T[15][r110[15] & UByte.MAX_VALUE];
        long r101 = r100[0];
        long r102 = r100[1];
        int r103 = 14;
    L3:
        if (r103 < 0) goto L5;
        long[] r104 = this.T[r103][r110[r103] & UByte.MAX_VALUE];
        r101 = r101 ^ r104[0];
        r102 = r102 ^ r104[1];
        r103 = r103 - 1;
        goto L3
    L5:
        Pack.longToBigEndian(r101, r110, 0);
        Pack.longToBigEndian(r102, r110, 8);
    }
}
