package com.bytedance.locallife.dito.utils;

import android.graphics.drawable.GradientDrawable;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f258713a;

    public p(GradientDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f258713a = r100;
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final void a(int r100) {
        this.f258713a.setColor(r100);
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final x b(Function1<? super x, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        x r101 = new x(0);
        r100.invoke(r101);
        this.f258713a.setStroke(r101.f258726a, r101.f258727b, 0.0f, 0.0f);
        return r101;
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final d c(Function1<? super d, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        d r101 = new d(0);
        r100.invoke(r101);
        this.f258713a.setCornerRadii(new float[]{r101.a(r101.f258692b), r101.a(r101.f258692b), r101.a(r101.f258693c), r101.a(r101.f258693c), r101.a(Float.NaN), r101.a(Float.NaN), r101.a(Float.NaN), r101.a(Float.NaN)});
        return r101;
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final void d(GradientDrawable.Orientation r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f258713a.setOrientation(r100);
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final void e(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f258713a.setColors(r100);
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final void f(w r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f258713a.setShape(r100.f258723a);
    }

    @Override // com.bytedance.locallife.dito.utils.r
    public final void setCornerRadius(float r100) {
        this.f258713a.setCornerRadius(r100);
    }
}
