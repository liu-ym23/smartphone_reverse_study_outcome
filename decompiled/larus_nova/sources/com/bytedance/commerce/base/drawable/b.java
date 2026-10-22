package com.bytedance.commerce.base.drawable;

import android.graphics.drawable.GradientDrawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f202801a;

    public b(GradientDrawable r100) {
        this.f202801a = r100;
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final void a(int r100) {
        this.f202801a.setColor(r100);
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final wf4.d b(Function1<? super wf4.d, Unit> r100) {
        wf4.d r101 = new wf4.d(0);
        r100.invoke(r101);
        this.f202801a.setStroke(r101.f559474a, r101.f559475b, 0.0f, 0.0f);
        return r101;
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final wf4.a c(Function1<? super wf4.a, Unit> r100) {
        wf4.a r101 = new wf4.a(0);
        r100.invoke(r101);
        this.f202801a.setCornerRadii(new float[]{r101.a(r101.f559465b), r101.a(r101.f559465b), r101.a(r101.f559466c), r101.a(r101.f559466c), r101.a(r101.f559468e), r101.a(r101.f559468e), r101.a(r101.f559467d), r101.a(r101.f559467d)});
        return r101;
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final void d(GradientDrawable.Orientation r100) {
        this.f202801a.setOrientation(r100);
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final void e(int[] r100) {
        this.f202801a.setColors(r100);
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final wf4.c f(Function1<? super wf4.c, Unit> r100) {
        wf4.c r101 = new wf4.c(0);
        r100.invoke(r101);
        this.f202801a.setSize(r101.f559472a, r101.f559473b);
        return r101;
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final void g(wf4.b r100) {
        this.f202801a.setShape(r100.f559469a);
    }

    @Override // com.bytedance.commerce.base.drawable.c
    public final void setCornerRadius(float r100) {
        this.f202801a.setCornerRadius(r100);
    }
}
