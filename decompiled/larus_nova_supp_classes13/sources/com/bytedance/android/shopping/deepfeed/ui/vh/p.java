package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements com.bytedance.android.ecom.arch.slice.render.context.a {
    public final /* synthetic */ DeepFeedProductSlcVH a;

    public static final class a implements Runnable {
        public final /* synthetic */ uc3.f a;

        public a(uc3.f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            uc3.f r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b(System.currentTimeMillis());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ uc3.f a;

        public b(uc3.f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            uc3.f r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.h(System.currentTimeMillis());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ p a;
        public final /* synthetic */ uc3.f b;

        public c(p r1, uc3.f r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            uc3.f r0 = this.b;
            if (r0 == null) goto L5;
            r0.g(System.currentTimeMillis());
        L5:
            com.bytedance.android.shopping.deepfeed.data.repo.l r1 = this.a.a.i4().getResp();
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.l == true) goto L21;
            uc3.f r2 = this.b;
            if (r2 == null) goto L16;
            Map<String, ? extends Object> r3 = r2.a();
            if (r3 == null) goto L16;
            DeepFeedProductEventTracker r4 = this.a.a.i4().getEventTracker();
            if (r4 == null) goto L16;
            Intrinsics.checkNotNullParameter(r3, "data");
            r4.doEventAction("ec_perf_duration_mall_deep_feed", r3);
        L16:
            com.bytedance.android.shopping.deepfeed.data.repo.l r5 = this.a.a.i4().getResp();
            if (r5 == null) goto L22;
            r5.l = true;
            return;
        L22:
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

    public p(DeepFeedProductSlcVH r1) {
        this.a = r1;
    }

    public final void a(SlcTemplateContext r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        this.a.getClass();
        if (Intrinsics.areEqual(null, r3) == false) goto L28;
        if (r4 != null) goto L29;
        com.bytedance.android.shopping.deepfeed.data.repo.l r5 = this.a.i4().getResp();
        if (r5 == null) goto L8;
        uc3.f r6 = r5.g();
    L9:
        DeepFeedProductSlcVH r7 = this.a;
        if (r7.R == false) goto L15;
        r7.R = false;
        if (r6 == null) goto L14;
        r6.e(System.currentTimeMillis());
    L14:
        this.a.p.post(new a(r6));
    L15:
        DeepFeedProductSlcVH r8 = this.a;
        if (r8.S == false) goto L21;
        r8.S = false;
        if (r6 == null) goto L20;
        r6.i(System.currentTimeMillis());
    L20:
        this.a.p.post(new b(r6));
    L21:
        DeepFeedProductSlcVH r9 = this.a;
        if (r9.T == false) goto L30;
        r9.T = false;
        if (r6 == null) goto L26;
        r6.d(System.currentTimeMillis());
    L26:
        this.a.p.post(new c(this, r6));
        return;
    L30:
        return;
    L8:
        r6 = null;
        goto L9
    L29:
        return;
    }
}
