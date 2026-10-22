package com.bytedance.locallife.poi.newdetail.component;

import android.animation.ValueAnimator;
import com.bytedance.locallife.dito.baseview.RoundLinearLayout;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiRecommendDitoView f263219a;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiRecommendDitoView f263220a;

        public a(PoiRecommendDitoView r100) {
            this.f263220a = r100;
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
            this.f263220a.getLayoutParams().height = r103;
            PoiRecommendDitoView r104 = this.f263220a;
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

    public j0(PoiRecommendDitoView r100) {
        this.f263219a = r100;
    }

    public final void a() {
        PoiRecommendDitoView r100 = this.f263219a;
        if (r100.F != 0) goto L5;
        r100.F = r100.getHeight();
    L5:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f263219a.F});
        r101.setDuration(300);
        r101.addUpdateListener(new a(this.f263219a));
        r101.start();
        RoundLinearLayout r102 = this.f263219a.C;
        String r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("poi_component_container");
        r102 = null;
    L8:
        r102.setVisibility(0);
        PoiRecommendDitoView r104 = this.f263219a;
        r104.getClass();
        int r105 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r106 = new mq6.c();
        mq6.a r107 = mq6.c.a.f514894a;
        r106.g("enter_from", "poi_page");
        PoiDetail r108 = r104.I;
        if (r108 == null) goto L11;
        String r109 = r108.getPoiId();
    L12:
        r106.g("poi_id", r109);
        PoiDetail r110 = r104.I;
        if (r110 == null) goto L15;
        String r111 = r110.getBackendType();
    L16:
        r106.g("poi_backend_type", r111);
        r106.g("event_type", "show");
        com.bytedance.locallife.biz.mob.a.C3646a.c("similiar_poi_recommend", r106.f514893a);
        mq6.c r112 = new mq6.c();
        r112.g("enter_from", "poi_page");
        r112.g("enter_method", DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        PoiDetail r113 = r104.I;
        if (r113 == null) goto L19;
        String r114 = r113.getPoiId();
    L20:
        r112.g("poi_id", r114);
        PoiDetail r115 = r104.I;
        if (r115 == null) goto L23;
        r103 = r115.getBackendType();
    L23:
        r112.g("poi_backend_type", r103);
        com.bytedance.locallife.biz.mob.a.C3646a.c("show_personal_favourite_info", r112.f514893a);
        return;
    L19:
        r114 = null;
        goto L20
    L15:
        r111 = null;
        goto L16
    L11:
        r109 = null;
        goto L12
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
