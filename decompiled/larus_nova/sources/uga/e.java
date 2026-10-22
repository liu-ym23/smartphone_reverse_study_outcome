package uga;

import android.os.SystemClock;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f550075a = 0;

    static {
    }

    public static long a(long r100) {
        long r101 = SystemClock.elapsedRealtime();
        if (r100 > 0) goto L6;
        return r101;
    L6:
        return RangesKt.coerceIn(r101 - RangesKt.coerceAtLeast(SystemClock.uptimeMillis() - r100, 0), 0, r101);
    }
}
