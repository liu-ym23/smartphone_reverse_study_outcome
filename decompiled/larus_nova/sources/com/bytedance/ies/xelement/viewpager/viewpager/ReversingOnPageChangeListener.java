package com.bytedance.ies.xelement.viewpager.viewpager;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.base.LLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/ReversingOnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class ReversingOnPageChangeListener implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager.OnPageChangeListener f250618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseCustomViewPager f250619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PagerAdapter f250620c;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        this.f250618a.onPageScrollStateChanged(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        PagerAdapter r101 = this.f250620c;
        if (this.f250619b.f250591g == false) goto L6;
        if (r101 == null) goto L6;
        r100 = (r101.getCount() - r100) - 1;
    L6:
        this.f250618a.onPageSelected(r100);
    }

    public ReversingOnPageChangeListener(ViewPager.OnPageChangeListener r100, BaseCustomViewPager r101, PagerAdapter r102) {
        Intrinsics.checkNotNullParameter(r100, "mListener");
        Intrinsics.checkNotNullParameter(r101, "mViewPager");
        this.f250618a = r100;
        this.f250619b = r101;
        this.f250620c = r102;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        int r103 = this.f250619b.getWidth();
        PagerAdapter r104 = this.f250620c;
        if (this.f250619b.f250591g == false) goto L15;
        if (r104 == null) goto L15;
        int r105 = r104.getCount();
        float r106 = r103;
        int r107 = ((int) ((1 - r104.getPageWidth(r100)) * r106)) + r102;
    L6:
        if (r100 >= r105) goto L9;
        if (r107 <= 0) goto L9;
        r100 = r100 + 1;
        r107 = r107 - ((int) (r104.getPageWidth(r100) * r106));
    L9:
        r100 = (r105 - r100) - 1;
        r102 = -r107;
        r101 = r102 / (r106 * r104.getPageWidth(r100));
    L15:
        this.f250618a.onPageScrolled(r100, r101, r102);     // Catch: NullPointerException -> L12
        return;
    L12:
        e = move-exception;
        LLog.e("ReversingOnPageChangeListener", e.toString());
    }
}
