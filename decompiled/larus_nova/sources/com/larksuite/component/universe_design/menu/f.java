package com.larksuite.component.universe_design.menu;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f285137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f285138b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f285137a.c(this.f285138b);
        this.f285138b.removeOnAttachStateChangeListener(this);
    }

    public f(c r100, View r101) {
        this.f285137a = r100;
        this.f285138b = r101;
    }
}
