package com.bytedance.android.shopping.ligo.monitor;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LigoMonitor {
    public final Lazy a;
    public final d b;
    public final a c;

    public final c a() {
        return (c) this.a.getValue();
    }

    public LigoMonitor(a r2) {
        Intrinsics.checkNotNullParameter(r2, "eventTracker");
        this.c = r2;
        this.a = LazyKt.lazy(new LigoMonitor$perfMonitor$2(this));
        this.b = new d(r2.a());
    }

    public final void c(ll.a r5) {
        Intrinsics.checkNotNullParameter(r5, "dynamicRegion");
        this.c.b("livesdk_ligo_load_success", b.a(r5));
        d r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "dynamicRegion");
        String r0 = r1.a;
        String r2 = "load_success_" + r5.b();
        Map r6 = d.a(r5, new Pair[0]);
        xh.b r3 = new xh.b();
        r3.c(r0);
        r3.b(r2);
        r3.a(r6);
        xh.c.a("Ligo").f(4, r3);
    }

    public final void b(ll.a r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r9, "errorCode");
        a r2 = this.c;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(b.a(r8));
        r3.put("error_code", r9);
        r3.put("error_msg", r10);
        Unit r6 = Unit.INSTANCE;
        r2.b("livesdk_ligo_load_failed", r3);
        d r4 = this.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r9, "errorCode");
        String r0 = r4.a;
        String r1 = "load_fail_" + r8.b();
        Map r11 = d.a(r8, new Pair[]{new Pair("error_code", r9), new Pair("error_msg", r10)});
        xh.b r12 = new xh.b();
        r12.c(r0);
        r12.b(r1);
        r12.a(r11);
        xh.c.a("Ligo").f(6, r12);
    }

    public final void d(ll.a r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r7, "errorCode");
        d r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r7, "errorCode");
        String r0 = r2.a;
        String r1 = "load_lynx_fail_" + r6.b();
        Map r9 = d.a(r6, new Pair[]{new Pair("error_code", r7), new Pair("error_msg", r8)});
        xh.b r10 = new xh.b();
        r10.c(r0);
        r10.b(r1);
        r10.a(r9);
        xh.c.a("Ligo").f(6, r10);
    }
}
