package com.obric.oui.panel.header;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f402117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f402118b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f402117a.removeOnAttachStateChangeListener(this);
        int r101 = pla.d.n(r100, 44);
        b r102 = this.f402118b;
        j.c(r102.f402123j, r101, r101, new View[]{r102.f402120g, r102.f402119f});
    }

    public a(View r100, b r101) {
        this.f402117a = r100;
        this.f402118b = r101;
    }
}
