package com.bytedance.dux.indicator;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DuxCarouselIndicator f205223d;

    @Override // com.bytedance.dux.indicator.c
    public final void a() {
    }

    @Override // com.bytedance.dux.indicator.c
    public final int b() {
        return this.f205223d.f205186c.size();
    }

    public a(DuxCarouselIndicator r100) {
        this.f205223d = r100;
    }

    @Override // com.bytedance.dux.indicator.c
    public final void e(int r100) {
        b.a((View) ListProtector.get(this.f205223d.f205186c, r100), (int) this.f205223d.getDotsSize());
        this.f205223d.d(r100);
    }

    @Override // com.bytedance.dux.indicator.c
    public final void d(int r100, int r110, float r111) {
        View r101 = (View) ListProtector.get(this.f205223d.f205186c, r100);
        boolean r102 = true;
        float r103 = 1;
        b.a(r101, (int) (this.f205223d.getDotsSize() + ((this.f205223d.getDotsSize() * (this.f205223d.getDotsWidthFactor() - r103)) * (r103 - r111))));
        ArrayList<View> r104 = this.f205223d.f205186c;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r110 >= 0) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L20;
        View r112 = (View) ListProtector.get(this.f205223d.f205186c, r110);
        b.a(r112, (int) (this.f205223d.getDotsSize() + ((this.f205223d.getDotsSize() * (this.f205223d.getDotsWidthFactor() - r103)) * r111)));
        Drawable r106 = r101.getBackground();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r107 = (GradientDrawable) r106;
        Drawable r113 = r112.getBackground();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r114 = (GradientDrawable) r113;
        if (this.f205223d.getSelectedDotColor() == this.f205223d.getDotsColor()) goto L20;
        DuxCarouselIndicator r108 = this.f205223d;
        Object r109 = r108.f205220p.evaluate(r111, Integer.valueOf(r108.getSelectedDotColor()), Integer.valueOf(this.f205223d.getDotsColor()));
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Int");
        int r115 = ((Integer) r109).intValue();
        DuxCarouselIndicator r116 = this.f205223d;
        Object r117 = r116.f205220p.evaluate(r111, Integer.valueOf(r116.getDotsColor()), Integer.valueOf(this.f205223d.getSelectedDotColor()));
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type kotlin.Int");
        r114.setColor(((Integer) r117).intValue());
        DuxBaseIndicator.b r118 = this.f205223d.getPager();
        if (r118 != null) goto L14;
    L16:
        r102 = false;
    L17:
        if (r102 == false) goto L19;
        r107.setColor(this.f205223d.getSelectedDotColor());
        goto L20
    L19:
        r107.setColor(r115);
        goto L20
    L14:
        if (r100 != r118.getCurrentItem()) goto L16;
    L20:
        this.f205223d.invalidate();
        return;
    L5:
        if (r110 >= r104.size()) goto L7;
        r105 = true;
        goto L8
    }
}
