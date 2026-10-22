package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class TripPoiHeadGuideWidget extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f263538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f263539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieAnimationView f263540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f263541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f263542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.locallife.poi.newdetail.widget.trip.b f263543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f263544g;

    public static final class a {
    }

    public static final class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadGuideWidget f263545a;

        public b(TripPoiHeadGuideWidget r100) {
            this.f263545a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            TripPoiHeadGuideWidget r101 = this.f263545a;
            r101.getClass();
            ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r101.f263542e = r102;
            if (r102 == null) goto L6;
            r102.setDuration(500);
        L6:
            ValueAnimator r103 = r101.f263542e;
            if (r103 == null) goto L9;
            r103.addUpdateListener(new h(r101));
        L9:
            ValueAnimator r104 = r101.f263542e;
            if (r104 == null) goto L12;
            r104.addListener(new i(r101));
        L12:
            ValueAnimator r105 = r101.f263542e;
            if (r105 == null) goto L17;
            r105.start();
            return true;
        L17:
            return true;
        }
    }

    static {
    }

    public final void a() {
        if (this.f263544g == true) goto L8;
        this.f263544g = true;
        com.bytedance.locallife.poi.newdetail.widget.trip.b r100 = this.f263543f;
        if (r100 == null) goto L9;
        r100.a();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f263541d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f263541d = null;
        ValueAnimator r101 = this.f263542e;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f263542e = null;
        this.f263539b.removeCallbacksAndMessages(null);
        a();
    }

    public final int getTopOffset() {
        return this.f263538a;
    }

    public final void setOnGuideEndListener(com.bytedance.locallife.poi.newdetail.widget.trip.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f263543f = r100;
    }

    public TripPoiHeadGuideWidget(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f263538a = r101;
        this.f263539b = new Handler(Looper.getMainLooper(), new b(this));
        setVisibility(4);
        setBackground(com.bytedance.locallife.dito.utils.o.a(AnonymousClass1.INSTANCE));
        LayoutInflater.from(r100).inflate(R.layout.saas_poi_trip_head_image_guide, this);
        LinearLayout r102 = (LinearLayout) findViewById(R.id.trip_head_image_guide_content);
        this.f263540c = (LottieAnimationView) findViewById(R.id.trip_head_image_guide_lottie);
        ViewGroup.MarginLayoutParams r103 = null;
        if (r102 == null) goto L5;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
    L7:
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r103 = (ViewGroup.MarginLayoutParams) r104;
    L9:
        if (r103 == null) goto L14;
        r103.topMargin = r101 - ((int) UIUtils.dip2Px(r100, 78.0f));
        if (r102 == null) goto L14;
        r102.setLayoutParams(r103);
    L14:
        post(new g(this));
        return;
    L5:
        r104 = null;
        goto L7
    }
}
