package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.os.SystemClock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f195095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f195096b;

    static {
        f195095a = -1;
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "reportParamsMap");
        if (f195095a <= 0) goto L9;
        long r101 = SystemClock.elapsedRealtime() - f195095a;
        if (r101 <= 0) goto L7;
        r100.put("duration", Long.valueOf(r101));
        d14.a r102 = b14.a.f16924a;
        ((d34.a) b14.a.a(d34.a.class)).F2("feed_leave_duration", r100, null);
    L7:
        f195095a = -1;
        return;
    }
}
