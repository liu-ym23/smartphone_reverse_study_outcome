package com.ss.android.ugc.tools.view.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.performance.AnimatorFpsMonitorKt;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.ITransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f454889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ITransition f454890b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f454891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f454892b;

        public a(g r100, int r101) {
            this.f454891a = r100;
            this.f454892b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            int r102 = this.f454892b;
            TransitionListener r103 = this.f454891a.f454889a.f454877a;
            if (r103 == null) goto L5;
            r103.c();
        L5:
            this.f454891a.f454889a.f454880d.setTranslationY(r102 + ((0 - r102) * r101));
            this.f454891a.f454889a.f454880d.setAlpha(r101);
            ITransition r104 = this.f454891a.f454890b;
            if (r104 == null) goto L9;
            r104.c();
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f454893a;

        public b(g r100) {
            this.f454893a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            TransitionListener r101 = this.f454893a.f454889a.f454877a;
            if (r101 == null) goto L5;
            r101.onShowEnd();
        L5:
            ITransition r102 = this.f454893a.f454890b;
            if (r102 == null) goto L9;
            r102.onShowEnd();
            return;
        }
    }

    public g(d r100, EmptyTransition r101) {
        this.f454889a = r100;
        this.f454890b = r101;
    }

    public final void a() {
        ITransition r100 = this.f454890b;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        d r101 = this.f454889a;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.f454889a.f454881e);
        Pair<String, String> r103 = this.f454889a.f454883g;
        if (r103 == null) goto L10;
        String r104 = r103.getFirst();
        if (r104 == null) goto L10;
    L11:
        AnimatorFpsMonitorKt.a(r102, r104, this.f454889a.f454878b);
        r101.f454879c = r102;
        d r105 = this.f454889a;
        r105.f454878b = false;
        ValueAnimator r106 = r105.f454879c;
        if (r106 == null) goto L14;
        r106.setInterpolator(new whc.b());
    L14:
        int r107 = this.f454889a.f454880d.getMeasuredHeight();
        ValueAnimator r108 = this.f454889a.f454879c;
        if (r108 == null) goto L17;
        r108.addUpdateListener(new a(this, r107));
    L17:
        ValueAnimator r109 = this.f454889a.f454879c;
        if (r109 == null) goto L20;
        r109.addListener(new b(this));
    L20:
        ValueAnimator r110 = this.f454889a.f454879c;
        if (r110 == null) goto L24;
        r110.start();
        return;
    L24:
        return;
    L10:
        r104 = "";
        goto L11
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
