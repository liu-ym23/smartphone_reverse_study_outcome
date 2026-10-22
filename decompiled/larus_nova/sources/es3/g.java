package es3;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f473716a;

    public g() {
        this.f473716a = new long[4];
    }

    public final void a(long r100) {
        long[] r101 = this.f473716a;
        if (r101[0] != 0) goto L5;
        r101[0] = SystemClock.uptimeMillis();
    L5:
        long[] r102 = this.f473716a;
        r102[1] = r102[1] + 1;
        if (r100 >= r102[2]) goto L9;
        r102[2] = r100;
    L9:
        if (r100 <= r102[3]) goto L12;
        r102[3] = r100;
        return;
    }
}
