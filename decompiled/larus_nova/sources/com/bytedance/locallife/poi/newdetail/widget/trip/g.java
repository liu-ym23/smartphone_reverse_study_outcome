package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadGuideWidget f263680a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadGuideWidget f263681a;

        public a(TripPoiHeadGuideWidget r100) {
            this.f263681a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue();
            this.f263681a.setAlpha(r102);
        }
    }

    public g(TripPoiHeadGuideWidget r100) {
        this.f263680a = r100;
    }

    public final void a() {
        this.f263680a.setVisibility(0);
        this.f263680a.setAlpha(0.0f);
        LottieAnimationView r100 = this.f263680a.f263540c;
        if (r100 == null) goto L5;
        r100.setAnimation("poi_trip_head_image_guide.json");
    L5:
        LottieAnimationView r101 = this.f263680a.f263540c;
        if (r101 == null) goto L9;
        r101.setRepeatMode(1);
    L9:
        LottieAnimationView r102 = this.f263680a.f263540c;
        if (r102 == null) goto L13;
        r102.setRepeatCount(-1);
    L13:
        LottieAnimationView r103 = this.f263680a.f263540c;
        if (r103 == null) goto L16;
        r103.resumeAnimation();
    L16:
        TripPoiHeadGuideWidget r104 = this.f263680a;
        r104.f263541d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator r105 = this.f263680a.f263541d;
        if (r105 == null) goto L20;
        r105.setDuration(500);
    L20:
        TripPoiHeadGuideWidget r106 = this.f263680a;
        ValueAnimator r107 = r106.f263541d;
        if (r107 == null) goto L23;
        r107.addUpdateListener(new a(r106));
    L23:
        ValueAnimator r108 = this.f263680a.f263541d;
        if (r108 == null) goto L26;
        r108.start();
    L26:
        this.f263680a.f263539b.sendEmptyMessageDelayed(0, 2000);
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
