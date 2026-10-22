package com.ss.android.lark.imageocr.select;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f426549a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public j(e r100) {
        this.f426549a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        e r101 = this.f426549a;
        r101.f426502f.getViewTreeObserver().removeOnScrollChangedListener(r101.f426515s);
        r101.f426502f.getViewTreeObserver().removeOnPreDrawListener(r101.f426514r);
        r101.b();
        r101.f426497a = null;
        r101.f426498b = null;
        r101.f426499c = null;
    }
}
