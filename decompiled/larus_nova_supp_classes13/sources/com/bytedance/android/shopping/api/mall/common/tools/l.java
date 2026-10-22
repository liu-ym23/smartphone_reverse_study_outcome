package com.bytedance.android.shopping.api.mall.common.tools;

import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public static final l a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject r1) {
            this.a = r1;
        }

        public final void a() {
            l r0 = l.a;
            JSONObject r1 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "params");
            l.c(r1);
            l.d(r1);
            IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
            if (r2 == null) goto L8;
            yj.g r3 = r2.getHostAB();
            if (r3 == null) goto L9;
            r3.l();
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public l() {
    }

    static {
        a = new l();
    }

    public static void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r2));
    }

    public static void c(JSONObject r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r1 = r4.optJSONObject("detail");     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L8;
        String r3 = r2.next();     // Catch: Throwable -> L12
        r4.putOpt(r3, r1.opt(r3));     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.constructor-impl(r5);     // Catch: Throwable -> L12
        return;
    L9:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void d(JSONObject r6) {
        Long r0 = HybridAppInfoService.p.f();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
        r6.putOpt("t_app_launch_time", Long.valueOf(System.currentTimeMillis() - (SystemClock.uptimeMillis() - r1)));
    L5:
        r6.putOpt("EVENT_ORIGIN_FEATURE", "TEMAI");
        AppLogNewUtils.onEventV3("ies_ecommerce_client_custom_log", r6);
    }

    public static void b(l r2, JSONObject r3, Integer r4, boolean r5, int r6) {
        boolean r1 = false;
        if ((r6 & 4) == 0) goto L6;
        r5 = false;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r1 = true;
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
        com.bytedance.android.ec.hybrid.a.d().submit(new m(r3, r4, r5, r1));
    }
}
