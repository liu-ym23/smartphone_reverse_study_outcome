package com.bytedance.ies.xelement.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes19.dex */
public class CoverFlowTransformer implements ViewPager.PageTransformer {
    public CoverFlowTransformer() {
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(View r100, float r101) {
        ViewPager r102 = (ViewPager) r100.getParent();
        int r103 = (r100.getLeft() - r102.getPaddingLeft()) - r102.getScrollX();
        int r104 = (r102.getMeasuredWidth() - r102.getPaddingLeft()) - r102.getPaddingRight();
        if (r104 == 0) goto L5;
        float r105 = r103 / r104;
    L6:
        float r106 = Math.min(9.0f, Math.max(-9.0f, r105 * 9.0f));
        r100.setCameraDistance(1280.0f);
        r100.setRotationY(-r106);
        return;
    L5:
        r105 = 0.0f;
        goto L6
    }
}
