package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.common.widgets.NoScrollViewPager;
import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordFooterContainer;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewRecordPagesContainerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f210922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemViewRecordFooterContainer f210923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NoScrollViewPager f210924c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210922a;
    }

    public BitableItemViewRecordPagesContainerBinding(View r100, ItemViewRecordFooterContainer r101, NoScrollViewPager r102) {
        this.f210922a = r100;
        this.f210923b = r101;
        this.f210924c = r102;
    }
}
