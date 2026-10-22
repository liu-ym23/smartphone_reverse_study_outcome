package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService;
import com.bytedance.android.shopping.api.mall.common.tools.DeliveryViewAnimHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kk.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y93.b;
import y93.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallDeliveryMonitor implements b {
    public final Map<String, Map<String, Object>> a;
    public final Map<String, Map<String, Object>> b;
    public final Map<String, Map<String, Object>> c;
    public final Map<String, Set<String>> d;
    public final Map<String, Map<String, String>> e;
    public final Map<String, Integer> f;
    public MallDeliveryLifecycleCallback g;
    public final Lazy h;
    public final Map<String, String> i;
    public String j;

    public final class MallDeliveryLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        public Integer a;
        public boolean b;
        public boolean c;
        public final MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1 d;
        public final String e;
        public final String f;
        public final boolean g;
        public final /* synthetic */ MallDeliveryMonitor h;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Integer r0 = this.a;
            int r3 = r2.hashCode();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.intValue() != r3) goto L9;
            this.d.run();
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(final Activity r12) {
            Intrinsics.checkNotNullParameter(r12, "activity");
            Integer r0 = this.a;
            int r1 = r12.hashCode();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.intValue() != r1) goto L34;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
            DeliveryViewAnimHelper.n.getClass();     // Catch: Throwable -> L25
            if (DeliveryViewAnimHelper.f != null) goto L10;
        L20:
            boolean r3 = false;
        L21:
            if (r3 == false) goto L23;
            int r6 = DeliveryViewAnimHelper.b;     // Catch: Throwable -> L25
            int r7 = DeliveryViewAnimHelper.c;     // Catch: Throwable -> L25
            int r8 = DeliveryViewAnimHelper.d;     // Catch: Throwable -> L25
            int r9 = DeliveryViewAnimHelper.e;     // Catch: Throwable -> L25
            ImageView r5 = ((IMallDeepFeedAnimationService) ServiceManager.get().getService(IMallDeepFeedAnimationService.class)).b(r12, DeliveryViewAnimHelper.g, true);     // Catch: Throwable -> L25
            DeliveryViewAnimHelper.c(r12, ((IMallDeepFeedAnimationService) ServiceManager.get().getService(IMallDeepFeedAnimationService.class)).b(r12, DeliveryViewAnimHelper.f, false), r5, r6, r7, r8, r9, this.g);     // Catch: Throwable -> L25
        L23:
            DeliveryViewAnimHelper.b();     // Catch: Throwable -> L25
            Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L28:
            if (Result.exceptionOrNull-impl(r4) == null) goto L30;
            DeliveryViewAnimHelper.n.getClass();
            DeliveryViewAnimHelper.b();
        L30:
            d.c(new MallDeliveryMonitor$MallDeliveryLifecycleCallback$onActivityResumed$3(this, r12));
            return;
        L10:
            if (DeliveryViewAnimHelper.g == null) goto L20;
            if (DeliveryViewAnimHelper.b <= 0) goto L20;
            if (DeliveryViewAnimHelper.c <= 0) goto L20;
            if (DeliveryViewAnimHelper.d <= 0) goto L20;
            if (DeliveryViewAnimHelper.e <= 0) goto L20;
            r3 = true;
        L25:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Integer r0 = this.a;
            int r1 = r3.hashCode();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.intValue() == r1) goto L8;
            return;
        L8:
            if (r3.isFinishing() == false) goto L10;
        L11:
            this.d.run();
            return;
        L10:
            if (r3.isDestroyed() == true) goto L11;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            if (this.a != null) goto L6;
            this.a = Integer.valueOf(r1.hashCode());
            return;
        }

        public MallDeliveryLifecycleCallback(MallDeliveryMonitor r2, String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "uuid");
            Intrinsics.checkNotNullParameter(r4, "schema");
            this.h = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1 r6 = new MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1(this);
            this.d = r6;
            if (((Number) r2.h.getValue()).intValue() != 0) goto L6;
            t93.a.b().postDelayed(r6, 10000);
            return;
        }
    }

    public static final class a {
    }

    static {
    }

    public MallDeliveryMonitor() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.h = LazyKt.lazy(MallDeliveryMonitor$enableInitUnregister$2.INSTANCE);
        this.i = new LinkedHashMap();
        this.j = "";
    }

    @Override // y93.b
    public final void c(final e r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        d.c(new MallDeliveryMonitor$reportAction$1(this, r2));
    }

    @Override // y93.b
    public final Map<String, Object> h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        return (Map) ((LinkedHashMap) this.b).get(r2);
    }

    @Override // y93.b
    public final void a(final String r2, final Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "lynxRecord");
        d.c(new MallDeliveryMonitor$onRecordLynx$1(this, r2, r3));
    }

    @Override // y93.b
    public final void b(final String r2, final Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        d.c(new MallDeliveryMonitor$reportDeliveryErr$1(this, r2, r3));
    }

    @Override // y93.b
    public final void e(final String r3, final Map r4) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        final String r1 = "tti";
        Intrinsics.checkNotNullParameter("tti", "process");
        Intrinsics.checkNotNullParameter(r4, "actionParams");
        d.c(new MallDeliveryMonitor$reportActionFromLynx$1(this, r3, r1, r4));
    }

    @Override // y93.b
    public final void f(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, "params");
        Map r0 = (Map) ((LinkedHashMap) this.b).get(r3);
        if (r0 == null) goto L5;
        r0.putAll(r4);
        return;
    L5:
        LinkedHashMap r1 = (LinkedHashMap) this.c;
        Object r2 = r1.get(r3);
        if (r2 != null) goto L8;
        r2 = new LinkedHashMap();
        r1.put(r3, r2);
    L8:
        ((Map) r2).putAll(r4);
    }

    @Override // y93.b
    public final void g(final String r2, final boolean r3, final Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        d.c(new MallDeliveryMonitor$reportRecord$1(this, r2, r3, r4));
    }

    public static final void i(final MallDeliveryMonitor r1, final JSONObject r2, final String r3, final String r4) {
        r1.getClass();
        d.c(new MallDeliveryMonitor$fillingBaseEventParams$1(r1, r2, r3, r4));
    }

    @Override // y93.b
    public final void d(String r4, String r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "uuid");
        Intrinsics.checkNotNullParameter(r5, "timing");
        Map r0 = (Map) ((LinkedHashMap) this.b).get(r4);
        if (r0 == null) goto L9;
        if (r6 == null) goto L6;
        long r1 = r6.longValue();
    L7:
        r0.put(r5, Long.valueOf(r1));
        goto L9
    L6:
        r1 = System.currentTimeMillis();
    L9:
        if (Intrinsics.areEqual(r5, "mall_enter_time") == false) goto L16;
        if (r7 == null) goto L14;
        Map r8 = (Map) ((LinkedHashMap) this.b).get(r4);
        if (r8 == null) goto L14;
        r8.put("mall_source_page", r7);
    L14:
        c(new e("mall_enter", r4));
        return;
    }
}
