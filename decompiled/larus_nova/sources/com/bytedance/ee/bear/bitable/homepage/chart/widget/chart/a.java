package com.bytedance.ee.bear.bitable.homepage.chart.widget.chart;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<View, Boolean> f212697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChartItemView f212698b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super View, Boolean> r100, ChartItemView r101) {
        this.f212697a = r100;
        this.f212698b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<View, Boolean> r101 = this.f212697a;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        if (r101.invoke(r100).booleanValue() == false) goto L9;
        ChartItemView.d(this.f212698b, ChartItemView.c.C3049c.f212678b);
        return;
    L9:
        return;
    }
}
