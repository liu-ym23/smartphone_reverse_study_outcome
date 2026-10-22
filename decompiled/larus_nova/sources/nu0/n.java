package nu0;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f520595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f520596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f520597c;

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
        ViewUtilsKt.e(this.f520595a);
        this.f520596b.setText(this.f520597c);
    }

    public n(View r100, TextView r101, String r102) {
        this.f520595a = r100;
        this.f520596b = r101;
        this.f520597c = r102;
    }
}
