package com.obric.oui.titlebar;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OFloatingTitleBar f403535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f403536b;

    public /* synthetic */ e(OFloatingTitleBar r100, View.OnClickListener r101) {
        this.f403535a = r100;
        this.f403536b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OFloatingTitleBar r101 = this.f403535a;
        View.OnClickListener r102 = this.f403536b;
        Token$Bounce r103 = OFloatingTitleBar.H0;
        Intrinsics.checkNotNullParameter(r101, "this$0");
        r101.B();
        r102.onClick(r100);
    }
}
