package wl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f560164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f560165b = 0;

    static {
    }

    public static long a(long r100) {
        return (SystemClock.elapsedRealtime() + (r100 + f560164a)) - System.currentTimeMillis();
    }
}
