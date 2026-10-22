package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouch;

/* JADX INFO: loaded from: classes19.dex */
public class ImageViewTouchViewPager extends SSViewPager {
    public ImageViewTouchViewPager(Context r100) {
        super(r100);
    }

    public ImageViewTouchViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final boolean canScroll(View r100, boolean r101, int r102, int r103, int r104) {
        if ((r100 instanceof ImageViewTouch) == false) goto L21;
        ImageViewTouch r105 = (ImageViewTouch) r100;
        if (r105.getDrawable() == null) goto L24;
        RectF r106 = r105.getBitmapRect();
        if (r106 == null) goto L25;
        r105.o(r106, r105.f248998p);
        Rect r107 = new Rect();
        r105.getGlobalVisibleRect(r107);
        float r108 = r106.right;
        float r109 = r107.right;
        if (r108 < r109) goto L17;
        if (r102 >= 0) goto L17;
        if (Math.abs(r108 - r109) <= 1.0f) goto L19;
    L15:
        return true;
    L19:
        return false;
    L17:
        if (Math.abs(r106.left - r105.f248998p.left) > 1.0d) goto L15;
        return false;
    L25:
        return false;
    L24:
        return false;
    L21:
        return super.canScroll(r100, r101, r102, r103, r104);
    }
}
