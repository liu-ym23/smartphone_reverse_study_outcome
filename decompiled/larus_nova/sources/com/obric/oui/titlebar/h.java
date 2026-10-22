package com.obric.oui.titlebar;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f403614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OFloatingTitleBar f403615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f403616c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f403614a.isAlive() == false) goto L5;
        this.f403614a.removeOnPreDrawListener(this);
    L9:
        this.f403616c.invoke();
        return true;
    L5:
        View r100 = this.f403615b.f403417p;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r100 = null;
    L8:
        r100.getViewTreeObserver().removeOnPreDrawListener(this);
        goto L9
    }

    public h(ViewTreeObserver r100, OFloatingTitleBar r101, Function0<Unit> r102) {
        this.f403614a = r100;
        this.f403615b = r101;
        this.f403616c = r102;
    }
}
