package com.bytedance.locallife.poi.newdetail.component;

import android.animation.ValueAnimator;
import com.bytedance.locallife.dito.baseview.RoundLinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiRecommendDitoView f263216a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiRecommendDitoView f263217a;

        public a(PoiRecommendDitoView r100) {
            this.f263217a = r100;
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
            this.f263217a.getLayoutParams().height = r103;
            PoiRecommendDitoView r104 = this.f263217a;
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
        public final /* synthetic */ PoiRecommendDitoView f263218a;

        public b(PoiRecommendDitoView r100) {
            this.f263218a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RoundLinearLayout r100 = this.f263218a.C;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("poi_component_container");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.setVisibility(8);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public i0(PoiRecommendDitoView r100) {
        this.f263216a = r100;
    }

    public final void a() {
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{this.f263216a.F, 0});
        r100.setDuration(300);
        r100.addUpdateListener(new a(this.f263216a));
        r100.start();
        PoiRecommendDitoView r101 = this.f263216a;
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
