package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.os.SystemClock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public static long a;
    public static int b;

    static {
        a = -1;
    }

    public static void a(Map r6) {
        Intrinsics.checkNotNullParameter(r6, "reportParamsMap");
        if (a <= 0) goto L9;
        long r0 = SystemClock.elapsedRealtime() - a;
        if (r0 <= 0) goto L7;
        r6.put("duration", Long.valueOf(r0));
        d14.a r1 = b14.a.a;
        b14.a.a(d34.a.class).F2("feed_leave_duration", r6, null);
    L7:
        a = -1;
        return;
    }
}
