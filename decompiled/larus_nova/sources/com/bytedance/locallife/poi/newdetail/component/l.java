package com.bytedance.locallife.poi.newdetail.component;

import android.animation.ValueAnimator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiMerchantFollowDitoView f263223a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263224a;

        public a(PoiMerchantFollowDitoView r100) {
            this.f263224a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Integer) == false) goto L5;
            Integer r102 = (Integer) r101;
        L6:
            if (r102 == null) goto L8;
            int r103 = r102.intValue();
        L9:
            this.f263224a.getLayoutParams().height = r103;
            PoiMerchantFollowDitoView r104 = this.f263224a;
            r104.setLayoutParams(r104.getLayoutParams());
            return;
        L8:
            r103 = 0;
            goto L9
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263225a;

        public b(PoiMerchantFollowDitoView r100) {
            this.f263225a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f263225a.E;     // Catch: Throwable -> L7
            if (r100 == null) goto L10;
            r100.setVisibility(8);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    public l(PoiMerchantFollowDitoView r100) {
        this.f263223a = r100;
    }

    public final void a() {
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{this.f263223a.D, 0});
        r100.setDuration(300);
        r100.addUpdateListener(new a(this.f263223a));
        r100.start();
        PoiMerchantFollowDitoView r101 = this.f263223a;
        r101.postDelayed(new b(r101), 300);
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
