package qp9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes31.dex */
public final class x extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScaleGestureLayout f534439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f534440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f534441c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        FLogger.f375446a.i("ScaleGestureLayout", "animateDisappear Step3 appearOrDisAppearAnimator end");
        this.f534439a.f364578v = null;
        this.f534440b.element = true;
        this.f534441c.invoke();
    }

    public x(ScaleGestureLayout r100, Ref.BooleanRef r101, vp9.b r102) {
        this.f534439a = r100;
        this.f534440b = r101;
        this.f534441c = r102;
    }
}
