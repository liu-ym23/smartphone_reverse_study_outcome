package com.ss.android.lark.log.trace;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class LogTraceWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f431409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f431410b = null;

    public LogTraceWrapper() {
    }

    static {
        f431409a = LazyKt.lazy(LogTraceWrapper$processName$2.INSTANCE);
        f431410b = LazyKt.lazy(LogTraceWrapper$processId$2.INSTANCE);
    }

    public static void a(String r110, String r111, int r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "name");
        com.bytedance.apm6.foundation.trace.a.a((String) f431409a.getValue(), ((Number) f431410b.getValue()).longValue(), r110, r111, r113, r112, null);
    }
}
