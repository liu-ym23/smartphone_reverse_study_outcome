package com.ss.android.lark.floating.widget.appfloat;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f421945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowManager f421946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f421947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f421948d;

    public e(h r100, WindowManager r101, d r102, ValueAnimator r103) {
        this.f421945a = r100;
        this.f421946b = r101;
        this.f421947c = r102;
        this.f421948d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.graphics.Point");     // Catch: Exception -> L5
        Point r102 = (Point) r101;     // Catch: Exception -> L5
        h r103 = this.f421945a;     // Catch: Exception -> L5
        int r104 = r102.x;     // Catch: Exception -> L5
        WindowManagerLayoutParamsInternal r105 = r103.f421955a;     // Catch: Exception -> L5
        ((WindowManager.LayoutParams) r105).x = r104;     // Catch: Exception -> L5
        ((WindowManager.LayoutParams) r105).y = r102.y;     // Catch: Exception -> L5
        this.f421946b.updateViewLayout(this.f421947c, r105);     // Catch: Exception -> L5
        return;
    L5:
        this.f421948d.cancel();
    }
}
