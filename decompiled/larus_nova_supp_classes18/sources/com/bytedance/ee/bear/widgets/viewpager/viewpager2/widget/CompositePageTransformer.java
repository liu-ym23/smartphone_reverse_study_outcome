package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers;

    public CompositePageTransformer() {
        this.mTransformers = new ArrayList();
    }

    public void addTransformer(ViewPager2.PageTransformer r2) {
        this.mTransformers.add(r2);
    }

    public void removeTransformer(ViewPager2.PageTransformer r2) {
        this.mTransformers.remove(r2);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r3, float r4) {
        Iterator<ViewPager2.PageTransformer> r0 = this.mTransformers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().transformPage(r3, r4);
        goto L4
    }
}
