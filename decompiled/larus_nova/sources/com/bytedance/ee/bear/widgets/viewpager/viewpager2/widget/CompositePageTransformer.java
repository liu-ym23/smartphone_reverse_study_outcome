package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers;

    public CompositePageTransformer() {
        this.mTransformers = new ArrayList();
    }

    public void addTransformer(ViewPager2.PageTransformer r100) {
        this.mTransformers.add(r100);
    }

    public void removeTransformer(ViewPager2.PageTransformer r100) {
        this.mTransformers.remove(r100);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r100, float r101) {
        Iterator<ViewPager2.PageTransformer> r102 = this.mTransformers.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().transformPage(r100, r101);
        goto L4
    }
}
