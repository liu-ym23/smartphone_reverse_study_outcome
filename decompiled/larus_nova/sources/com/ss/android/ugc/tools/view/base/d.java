package com.ss.android.ugc.tools.view.base;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.performance.AnimatorFpsMonitorKt;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.InitiativeTransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends TransitionListener.DefaultTransitionListener implements InitiativeTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TransitionListener f454877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f454878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f454879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f454880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f454881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f454882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pair<String, String> f454883g;

    public static final class a {
    }

    static {
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f454880d = r100;
        this.f454881e = 200;
        this.f454882f = 200;
        this.f454883g = null;
        this.f454878b = true;
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void a(TransitionListener.DefaultTransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f454877a = r100;
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void d(EmptyTransition r100) {
        ValueAnimator r101 = this.f454879c;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        TransitionListener r102 = this.f454877a;
        if (r102 == null) goto L8;
        r102.e();
    L8:
        this.f454880d.setAlpha(0.0f);
        this.f454880d.post(new g(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void g(EmptyTransition r100) {
        ValueAnimator r101 = this.f454879c;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        TransitionListener r102 = this.f454877a;
        if (r102 == null) goto L8;
        r102.f();
    L8:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.f454882f);
        Pair<String, String> r104 = this.f454883g;
        if (r104 == null) goto L13;
        String r105 = r104.getSecond();
        if (r105 == null) goto L13;
    L14:
        AnimatorFpsMonitorKt.a(r103, r105, false);
        this.f454879c = r103;
        int r106 = this.f454880d.getMeasuredHeight();
        ValueAnimator r107 = this.f454879c;
        if (r107 == null) goto L17;
        r107.addUpdateListener(new e(this, r106, r100));
    L17:
        ValueAnimator r108 = this.f454879c;
        if (r108 == null) goto L20;
        r108.addListener(new f(this, r100));
    L20:
        ValueAnimator r109 = this.f454879c;
        if (r109 == null) goto L24;
        r109.start();
        return;
    L24:
        return;
    L13:
        r105 = "";
        goto L14
    }
}
