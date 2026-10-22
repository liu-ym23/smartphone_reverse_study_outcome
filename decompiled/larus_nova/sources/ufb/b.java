package ufb;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.floating.widget.appfloat.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f549967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowManager f549968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f549969c;

    public b(h r100, WindowManager r101, View r102) {
        this.f549967a = r100;
        this.f549968b = r101;
        this.f549969c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        h r101 = this.f549967a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        ((WindowManager.LayoutParams) r101.f421955a).x = ((Integer) r102).intValue();
        this.f549968b.updateViewLayout(this.f549969c, this.f549967a.f421955a);
    }
}
