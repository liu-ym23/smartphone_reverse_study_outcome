package rcc;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f537200a;

    public final boolean a() {
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - this.f537200a;
        this.f537200a = r100;
        if (r101 >= 500) goto L5;
        return true;
    L5:
        return false;
    }

    public a() {
    }
}
