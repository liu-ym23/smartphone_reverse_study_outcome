package com.larus.bmhome.chat.outerinput;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f308440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f308441b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f308440a.getHeight() <= 0) goto L9;
        Function1<Integer, Unit> r100 = this.f308441b;
        if (r100 == null) goto L7;
        r100.invoke(Integer.valueOf(this.f308440a.getHeight() - c7.b(Float.valueOf(12.0f))));
    L7:
        this.f308440a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(View r100, Function1<? super Integer, Unit> r101) {
        this.f308440a = r100;
        this.f308441b = r101;
    }
}
