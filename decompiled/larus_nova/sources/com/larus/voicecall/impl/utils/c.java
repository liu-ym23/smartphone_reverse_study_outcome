package com.larus.voicecall.impl.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import com.bytedance.common.utility.UIUtils;
import com.larus.common.apphost.AppHost;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f379530a = 0;

    public static final class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f379531a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(View r100) {
            this.f379531a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f379531a.setVisibility(4);
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f379532a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        public b(View r100) {
            this.f379532a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            this.f379532a.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.utils.c$c, reason: collision with other inner class name */
    public static final class AnimationAnimationListenerC4535c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f379533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f379534b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            if (this.f379534b == true) goto L6;
            this.f379533a.setVisibility(8);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            this.f379533a.setVisibility(0);
        }

        public AnimationAnimationListenerC4535c(View r100, boolean r101) {
            this.f379533a = r100;
            this.f379534b = r101;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f379535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f379536b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            if (this.f379536b == true) goto L6;
            this.f379535a.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f379535a.setVisibility(0);
        }

        public d(View r100, boolean r101) {
            this.f379535a = r100;
            this.f379536b = r101;
        }
    }

    static {
        f379530a = (int) UIUtils.dip2Px(AppHost.f326268a.getApplication(), 111.0f);
    }

    public static final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        if (r110.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        ScaleAnimation r101 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.2f, 1, 0.8f);
        r101.setDuration(200);
        int r102 = f379530a;
        r101.initialize(r102, r102, r102, r102);
        r101.setAnimationListener(new a(r110));
        r110.startAnimation(r101);
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static final void b(View r110) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        ScaleAnimation r100 = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.2f, 1, 0.8f);
        r100.setDuration(200);
        int r101 = f379530a;
        r100.initialize(r101, r101, r101, r101);
        r100.setAnimationListener(new b(r110));
        r110.startAnimation(r100);
    }

    public static /* synthetic */ void d(View r100, boolean r101) {
        c(r100, r101, 200);
    }

    public static final void c(View r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        float r103 = 0.0f;
        if (r101 == false) goto L5;
        float r104 = 0.0f;
    L6:
        if (r101 == false) goto L9;
        r103 = 1.0f;
    L9:
        if (r102 > 0) goto L16;
        r100.setAlpha(r103);
        if (r101 == false) goto L13;
        int r105 = 0;
    L14:
        r100.setVisibility(r105);
        return;
    L13:
        r105 = 8;
        goto L14
    L16:
        AlphaAnimation r106 = new AlphaAnimation(r104, r103);
        r106.setDuration(r102);
        r106.setAnimationListener(new AnimationAnimationListenerC4535c(r100, r101));
        r100.startAnimation(r106);
        return;
    L5:
        r104 = 1.0f;
        goto L6
    }

    public static void e(VoiceCallContentLayout r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{r101, r102});
        r103.setDuration(300);
        r103.start();
    }

    public static final void f(final View r100, boolean r101, long r102, final Function1<? super Float, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r110, "onAlphaChange");
        float r103 = 1.0f;
        if (r101 == false) goto L5;
        float r104 = 0.0f;
    L6:
        if (r101 == true) goto L9;
        r103 = 0.0f;
    L9:
        int r105 = 0;
        if (r102 > 0) goto L17;
        r100.setAlpha(r103);
        if (r101 == true) goto L15;
        r105 = 8;
    L15:
        r100.setVisibility(r105);
        return;
    L17:
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r104, r103});
        r106.setInterpolator(new LinearInterpolator());
        r106.addUpdateListener(new com.larus.voicecall.impl.utils.a(r110, r100));
        r106.addListener(new d(r100, r101));
        r106.setDuration(r102);
        r106.start();
        return;
    L5:
        r104 = 1.0f;
        goto L6
    }
}
