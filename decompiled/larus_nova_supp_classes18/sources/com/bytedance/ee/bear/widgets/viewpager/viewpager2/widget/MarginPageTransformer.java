package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int r2) {
        Preconditions.checkArgumentNonnegative(r2, "Margin must be non-negative");
        this.mMarginPx = r2;
    }

    private ViewPager2 requireViewPager(View r2) {
        ViewParent r3 = r2.getParent();
        ViewParent r0 = r3.getParent();
        if ((r3 instanceof RecyclerView) == false) goto L9;
        if ((r0 instanceof ViewPager2) == false) goto L9;
        return (ViewPager2) r0;
    L9:
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r3, float r4) {
        ViewPager2 r0 = requireViewPager(r3);
        float r1 = this.mMarginPx * r4;
        if (r0.getOrientation() == 0) goto L5;
        r3.setTranslationY(r1);
        return;
    L5:
        if (r0.isRtl() == false) goto L7;
        r1 = -r1;
    L7:
        r3.setTranslationX(r1);
    }
}
