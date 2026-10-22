package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BasicGCMExponentiator implements GCMExponentiator {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long[] f525277x;

    public BasicGCMExponentiator() {
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long r100, byte[] r110) {
        long[] r101 = GCMUtil.oneAsLongs();
        if (r100 <= 0) goto L10;
        long[] r102 = Arrays.clone(this.f525277x);
    L6:
        if ((1 & r100) == 0) goto L8;
        GCMUtil.multiply(r101, r102);
    L8:
        GCMUtil.square(r102, r102);
        r100 = r100 >>> 1;
        if (r100 > 0) goto L6;
    L10:
        GCMUtil.asBytes(r101, r110);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] r100) {
        this.f525277x = GCMUtil.asLongs(r100);
    }
}
