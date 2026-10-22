package com.bytedance.locallife.pdp.container;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.dito.baseview.RoundLinearLayout;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.pdp.view.GoodsDetailInternalPopupView;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GoodsDetailBizContainerFragment f261113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f261114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f261115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f261116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f261117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f261118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f261119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f261120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<ViewGroup> f261121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Animator> f261122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<IPoiLynxKitDelegate> f261123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f261124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f261125m;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f261126a;

        public b(a0 r100) {
            this.f261126a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            FrameLayout r101 = this.f261126a.f261115c;
            if (r101 == null) goto L6;
            float r102 = wo6.a.c(r101.getContext());
            Object r103 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
            r101.setTranslationX(r102 * ((Float) r103).floatValue());
            return;
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f261127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a0 f261128b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            ValueAnimator r101 = this.f261127a;
            if (r101 == null) goto L5;
            r101.start();
        L5:
            FrameLayout r102 = this.f261128b.f261115c;
            if (r102 == null) goto L10;
            r102.setVisibility(8);
            return;
        }

        public c(ValueAnimator r100, a0 r101) {
            this.f261127a = r100;
            this.f261128b = r101;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f261129a;

        public d(a0 r100) {
            this.f261129a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            FrameLayout r101 = this.f261129a.f261114b;
            if (r101 == null) goto L6;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            r101.setAlpha(((Float) r102).floatValue());
            return;
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f261130a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
        }

        public e(a0 r100) {
            this.f261130a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f261130a.e();
            a0.c(this.f261130a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            FrameLayout r101 = this.f261130a.f261114b;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
        L6:
            a0 r102 = this.f261130a;
            Integer r103 = r102.f261124l;
            if (r103 == null) goto L12;
            int r104 = r103.intValue();
            View r105 = r102.f261118f;
            if (r105 == null) goto L12;
            r105.setVisibility(r104);
        L12:
            this.f261130a.e();
            a0.c(this.f261130a);
        }
    }

    static {
    }

    public final void d() {
        this.f261125m = false;
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r100.setDuration(300);
        r100.addUpdateListener(new d(this));
        r100.addListener(new e(this));
        this.f261122j.add(r100);
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.setDuration(300);
        r101.addUpdateListener(new b(this));
        r101.addListener(new c(r100, this));
        this.f261122j.add(r101);
        r101.start();
    }

    public final void e() {
        Iterator<T> r100 = this.f261121i.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ViewGroup) r100.next()).removeAllViews();
        goto L4
    L6:
        this.f261121i.clear();
        Iterator<T> r101 = this.f261122j.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((Animator) r101.next()).cancel();
        goto L8
    L10:
        this.f261122j.clear();
        Iterator<T> r102 = this.f261123k.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        IPoiLynxKitDelegate r103 = (IPoiLynxKitDelegate) r102.next();
        kp6.a<ICubeGlobalListener> r104 = Cube.f257155a;
        Cube.k(r103);
        goto L12
    L14:
        this.f261123k.clear();
    }

    public static final void c(a0 r100) {
        r100.getClass();
        Event r101 = new Event("goods_detail_close_secondary_page_finished", System.currentTimeMillis(), null, 4, null);
        r101.setMapParams(MapsKt.mapOf(TuplesKt.to(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r100.f261113a.getTraceSessionId())));
        EventCenter.enqueueEvent(r101);
    }

    public static final int a(a0 r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r101), "container_bg_color");     // Catch: Throwable -> L17
        if (r103 != null) goto L6;
    L8:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L15;
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L17
        if (r103 == null) goto L14;
        r105.append(r103.substring(6, 8));     // Catch: Throwable -> L17
        r105.append(r103.substring(0, 6));     // Catch: Throwable -> L17
        r103 = r105.toString();     // Catch: Throwable -> L17
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L17
    L15:
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#" + r103)));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r106) == false) goto L22;
        r106 = null;
    L22:
        Integer r107 = (Integer) r106;
        if (r107 != null) goto L28;
        return -1;
    L28:
        return r107.intValue();
    L6:
        if (r103.length() != 8) goto L8;
        r104 = true;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static final void b(a0 r100, String r101, FrameLayout r102) {
        kp6.c r103 = kp6.c.f505514a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        CubeInternalSchemaModel r104 = kp6.c.e(r103, r101);
        IPoiLynxKitDelegate r105 = r100.f261113a.nD(r104, GoodsDetailInternalPopupController$injectLynxView$1.INSTANCE);
        if (r105 == null) goto L12;
        r105.load(r104, GoodsDetailInternalPopupController$injectLynxView$2$1.INSTANCE);
        View r106 = r105.realView();
        if (r106 == null) goto L10;
        r102.addView(r106);
    L10:
        r100.f261123k.add(r105);
        return;
    }

    public a0(GoodsDetailBizContainerFragment r100, GoodsDetailInternalPopupView r101, GoodsDetailInternalPopupView r102, RoundLinearLayout r103, RoundLinearLayout r104, View r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f261113a = r100;
        this.f261114b = r101;
        this.f261115c = r102;
        this.f261116d = r103;
        this.f261117e = r104;
        this.f261118f = r105;
        this.f261119g = r106;
        this.f261120h = r107;
        this.f261121i = new LinkedHashSet();
        this.f261122j = new LinkedHashSet();
        this.f261123k = new LinkedHashSet();
    }
}
