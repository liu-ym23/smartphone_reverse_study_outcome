package com.bytedance.commerce.base.preview.transfer;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes15.dex */
public class TransferChangeListener extends ViewPager.SimpleOnPageChangeListener {
    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        super.onPageScrollStateChanged(r100);
        if (r100 == 0) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        throw null;
    }
}
