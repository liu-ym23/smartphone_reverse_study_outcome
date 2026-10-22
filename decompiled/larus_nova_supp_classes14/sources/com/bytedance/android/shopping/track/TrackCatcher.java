package com.bytedance.android.shopping.track;

import cl.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TrackCatcher {
    public static final Lazy a = null;

    public static final class a {
        public static TrackCatcher a() {
            return (TrackCatcher) TrackCatcher.a.getValue();
        }
    }

    public TrackCatcher() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TrackCatcher$Companion$instance$2.INSTANCE);
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pageId");
        d.a.getClass();
        d r2 = d.a.b();
        if (r2 == null) goto L6;
        r2.f();
        return;
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pageId");
        d.a.getClass();
        d r2 = d.a.b();
        if (r2 == null) goto L6;
        r2.f();
        return;
    }

    public static void c(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "pageId");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "btm");
        d.a.getClass();
        d r4 = d.a.b();
        if (r4 == null) goto L6;
        r4.f();
        return;
    }
}
