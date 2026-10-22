package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Tables4kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][] T;

    public Tables4kGCMMultiplier() {
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] r100) {
        int r101 = 2;
        if (this.T != null) goto L6;
        Class r102 = Long.TYPE;
        this.T = (long[][]) Array.newInstance(r102, new int[]{256, 2});
    L8:
        byte[] r103 = Arrays.clone(r100);
        this.H = r103;
        GCMUtil.asLongs(r103, this.T[1]);
        long[] r104 = this.T[1];
        GCMUtil.multiplyP7(r104, r104);
    L10:
        if (r101 >= 256) goto L12;
        long[][] r105 = this.T;
        GCMUtil.divideP(r105[r101 >> 1], r105[r101]);
        long[][] r106 = this.T;
        GCMUtil.xor(r106[r101], r106[1], r106[r101 + 1]);
        r101 = r101 + 2;
        goto L10
    L12:
        return;
    L6:
        if (Arrays.areEqual(this.H, r100) == false) goto L8;
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] r110) {
        long[] r100 = this.T[r110[15] & UByte.MAX_VALUE];
        long r101 = r100[0];
        long r102 = r100[1];
        int r103 = 14;
    L4:
        if (r103 < 0) goto L6;
        long[] r111 = this.T[r110[r103] & UByte.MAX_VALUE];
        long r112 = r102 << 56;
        r102 = ((r102 >>> 8) | (r101 << 56)) ^ r111[1];
        r101 = (((((r101 >>> 8) ^ r111[0]) ^ r112) ^ (r112 >>> 1)) ^ (r112 >>> 2)) ^ (r112 >>> 7);
        r103 = r103 - 1;
        goto L4
    L6:
        Pack.longToBigEndian(r101, r110, 0);
        Pack.longToBigEndian(r102, r110, 8);
    }
}
