package com.zhpan.bannerview.transform;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes41.dex */
public class ScaleInTransformer implements ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f464576a;

    public ScaleInTransformer() {
        this.f464576a = 0.85f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(View r100, float r101) {
        int r102 = r100.getWidth();
        r100.setPivotY(r100.getHeight() / 2.0f);
        float r103 = r102;
        r100.setPivotX(r103 / 2.0f);
        if (r101 >= (-1.0f)) goto L6;
        r100.setScaleX(this.f464576a);
        r100.setScaleY(this.f464576a);
        r100.setPivotX(r103);
        return;
    L6:
        if (r101 <= 1.0f) goto L8;
        r100.setPivotX(0.0f);
        r100.setScaleX(this.f464576a);
        r100.setScaleY(this.f464576a);
        return;
    L8:
        if (r101 >= 0.0f) goto L10;
        float r104 = this.f464576a;
        float r105 = ((r101 + 1.0f) * (1.0f - r104)) + r104;
        r100.setScaleX(r105);
        r100.setScaleY(r105);
        r100.setPivotX(r103 * (((-r101) * 0.5f) + 0.5f));
        return;
    L10:
        float r106 = 1.0f - r101;
        float r107 = this.f464576a;
        float r108 = ((1.0f - r107) * r106) + r107;
        r100.setScaleX(r108);
        r100.setScaleY(r108);
        r100.setPivotX(r103 * (r106 * 0.5f));
    }
}
