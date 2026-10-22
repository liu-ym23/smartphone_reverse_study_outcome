package com.obric.miniapp.lynx;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x3 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUISearchBarUI f398328a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public x3(LynxOUISearchBarUI r100) {
        this.f398328a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        LynxOUISearchBarUI r101 = this.f398328a;
        if (r101.f397992f == false) goto L6;
        r101.M();
        return;
    }
}
