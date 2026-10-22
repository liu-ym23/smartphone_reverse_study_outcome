package com.obric.miniapp.lynx;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class v1 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OBottomNavActionBar f398307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener f398308b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (this.f398307a.getViewTreeObserver().isAlive() == false) goto L6;
        this.f398307a.getViewTreeObserver().addOnPreDrawListener(this.f398308b);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (this.f398307a.getViewTreeObserver().isAlive() == false) goto L6;
        this.f398307a.getViewTreeObserver().removeOnPreDrawListener(this.f398308b);
        return;
    }

    public v1(OBottomNavActionBar r100, r1 r101) {
        this.f398307a = r100;
        this.f398308b = r101;
    }
}
