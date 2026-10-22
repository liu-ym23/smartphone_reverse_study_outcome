package com.bytedance.lark.policy.utils;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f253888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f253889b;

    public f() {
        this.f253888a = new LinkedHashMap();
        this.f253889b = new LinkedHashMap();
    }

    public final long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Long r101 = (Long) ((LinkedHashMap) this.f253888a).get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.longValue();
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f253889b.put(r100, Long.valueOf(SystemClock.elapsedRealtimeNanos()));
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Long r101 = (Long) ((LinkedHashMap) this.f253889b).get(r100);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
        long r103 = SystemClock.elapsedRealtimeNanos() - r102;
    L6:
        this.f253888a.put(r100, Long.valueOf(r103 / ((long) 1000)));
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
