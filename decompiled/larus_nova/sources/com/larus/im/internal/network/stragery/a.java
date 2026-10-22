package com.larus.im.internal.network.stragery;

import android.os.SystemClock;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final long b() {
        return fuc.a.a().a();
    }

    public static final long a(long r100) {
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r100, 0);
    }
}
