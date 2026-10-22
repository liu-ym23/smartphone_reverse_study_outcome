package com.bytedance.locallife.poi.newdetail.component;

import android.animation.ValueAnimator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiMerchantFollowDitoView f263226a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263227a;

        public a(PoiMerchantFollowDitoView r100) {
            this.f263227a = r100;
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
            this.f263227a.getLayoutParams().height = r103;
            PoiMerchantFollowDitoView r104 = this.f263227a;
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

    public m(PoiMerchantFollowDitoView r100) {
        this.f263226a = r100;
    }

    public final void a() {
        PoiMerchantFollowDitoView r100 = this.f263226a;
        if (r100.D != 0) goto L5;
        r100.D = r100.getHeight();
    L5:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f263226a.D});
        r101.setDuration(300);
        r101.addUpdateListener(new a(this.f263226a));
        r101.start();
        View r102 = this.f263226a.E;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        PoiMerchantFollowDitoView.b0(this.f263226a, "show_merchant_bar");
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
