package com.zhpan.bannerview.transform;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import drc.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/zhpan/bannerview/transform/OverlapPageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "bannerview_release"}, k = 1, mv = {1, 4, 0})
public final class OverlapPageTransformer implements ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f464571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f464572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f464573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f464574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f464575e;

    public OverlapPageTransformer() {
        this.f464571a = 0;
        this.f464572b = 0.85f;
        this.f464573c = 0.0f;
        this.f464574d = 1.0f;
        this.f464575e = 0.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(View r100, float r101) {
        r100.setElevation(-Math.abs(r101));
        float r102 = Math.max(1.0f - Math.abs(r101 * 0.5f), 0.5f);
        float r103 = this.f464573c;
        if (r103 == 0.0f) goto L9;
        float r104 = 1 - r102;
        if (r101 > 0) goto L8;
        r103 = -r103;
    L8:
        r100.setRotationY(r104 * r103);
    L9:
        float r105 = Math.max(1.0f - Math.abs(0.2f * r101), this.f464572b);
        r100.setScaleX(r105);
        r100.setScaleY(r105);
        int r106 = a.a(((int) this.f464575e) / 2);
        int r107 = this.f464571a;
        if (r107 == 0) goto L19;
        if (r107 != 1) goto L18;
        float r108 = r106 * r101;
        if (r101 <= 0) goto L15;
        int r109 = -r100.getWidth();
    L16:
        r100.setTranslationY(r108 + (r109 * (1.0f - r105)));
    L25:
        if (this.f464574d != 1.0f) goto L27;
        return;
    L27:
        if (r101 >= (-1.0f)) goto L29;
    L31:
        float r110 = 0.5f / Math.abs(r101 * r101);
    L32:
        r100.setAlpha(r110);
        return;
    L29:
        if (r101 > 1.0f) goto L31;
        r110 = ((1 - Math.abs(r101)) * 0.5f) + 0.5f;
        goto L32
    L15:
        r109 = r100.getWidth();
        goto L16
    L18:
        throw new IllegalArgumentException("Gives correct orientation value, ViewPager2.ORIENTATION_HORIZONTAL or ViewPager2.ORIENTATION_VERTICAL");
    L19:
        float r111 = r106 * r101;
        if (r101 <= 0) goto L22;
        int r112 = -r100.getWidth();
    L23:
        r100.setTranslationX(r111 + (r112 * (1.0f - r105)));
        goto L25
    L22:
        r112 = r100.getWidth();
        goto L23
    }
}
