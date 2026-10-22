package wi4;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.InitiativeTransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r0 extends TransitionListener.DefaultTransitionListener implements InitiativeTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f559830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f559831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Interpolator f559832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f559833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f559834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f559835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TransitionListener f559836g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void a(TransitionListener.DefaultTransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f559836g = r100;
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void d(final EmptyTransition r100) {
        this.f559830a.post(new p0(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void g(final EmptyTransition r100) {
        TransitionListener r101 = this.f559836g;
        if (r101 == null) goto L5;
        r101.f();
    L5:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.f559835f);
        Interpolator r103 = this.f559833d;
        if (r103 == null) goto L8;
        r102.setInterpolator(r103);
    L8:
        final int r104 = this.f559830a.getMeasuredHeight();
        r102.addUpdateListener(new o0(r104, this, r100));
        r102.addListener(new s0(this, r100));
        r102.start();
    }

    public r0(View r100, boolean r101, Interpolator r102, Interpolator r103, long r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f559830a = r100;
        this.f559831b = r101;
        this.f559832c = r102;
        this.f559833d = r103;
        this.f559834e = r104;
        this.f559835f = r105;
    }
}
