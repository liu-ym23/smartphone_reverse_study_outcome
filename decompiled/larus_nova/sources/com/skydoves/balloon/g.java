package com.skydoves.balloon;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class g implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Balloon f406149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f406150b;

    public /* synthetic */ g(Balloon r100, i r101) {
        this.f406149a = r100;
        this.f406150b = r101;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        Balloon r100 = this.f406149a;
        n r101 = this.f406150b;
        Intrinsics.checkNotNullParameter(r100, "this$0");
        FrameLayout r102 = r100.f406020c.f406139b;
        Animation r103 = r102.getAnimation();
        if (r103 == null) goto L5;
        r103.cancel();
        r103.reset();
    L5:
        r102.clearAnimation();
        r100.h();
        if (r101 == null) goto L9;
        r101.a();
        return;
    }
}
