package com.ss.android.lark.widget.light.viewstub;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Integer, Unit> f446336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f446337b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function2<? super Integer, ? super Integer, Unit> r100, TextView r101) {
        this.f446336a = r100;
        this.f446337b = r101;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.f446336a.invoke(Integer.valueOf(this.f446337b.getScrollX()), Integer.valueOf(this.f446337b.getScrollY()));
    }
}
