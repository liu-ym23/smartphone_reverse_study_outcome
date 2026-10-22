package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements w83.f {
    public final /* synthetic */ ll.a a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ LivePromotionListGroupPresenter c;
    public final /* synthetic */ LivePromotionListGroupPresenter$initListOpenArea$1 d;
    public final /* synthetic */ LivePromotionListGroupPresenter$initListOpenArea$2 e;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = this.a;     // Catch: Throwable -> L6
            LigoViewManager r1 = r0.c.A;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.d(r0.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void onFallback() {
        LigoViewManager r0 = this.c.A;
        if (r0 == null) goto L5;
        r0.d(this.b);
    L5:
        this.d.invoke(0);
    }

    public final void onLoadSuccess() {
        if (this.c.C == false) goto L6;
        this.d.invoke(EComABUtils.getListLeftMarginInInstantFusion());
        return;
    }

    public final void a(String r4) {
        dm.a.a("LigoViewManager").a("load failed, errorMessage = " + r4 + ", curThread = " + ThreadMethodProxy.currentThread().getName());
        a r5 = new a(this);
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L5;
        r5.run();
    L6:
        this.d.invoke(0);
        return;
    L5:
        this.c.a0().post(r5);
        goto L6
    }

    public final void b(String r2, int r3) {
        if ((!Intrinsics.areEqual(r2, this.a.e())) == true) goto L7;
        if (r3 != this.a.a()) goto L7;
        return;
    L7:
        if (((ViewGroup) this.c.Z().b(2131378074).f()).getVisibility() != 8) goto L11;
        this.e.m996invoke();
        return;
    }

    public h(ll.a r1, FrameLayout r2, LivePromotionListGroupPresenter r3, LivePromotionListGroupPresenter$initListOpenArea$1 r4, LivePromotionListGroupPresenter$initListOpenArea$2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
