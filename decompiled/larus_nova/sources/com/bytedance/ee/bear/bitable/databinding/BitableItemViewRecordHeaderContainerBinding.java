package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordCatalog;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordCover;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewRecordHeaderContainerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f210916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f210917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemViewRecordCatalog f210918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemViewRecordCover f210919d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210916a;
    }

    public BitableItemViewRecordHeaderContainerBinding(View r100, View r101, ItemViewRecordCatalog r102, ItemViewRecordCover r103) {
        this.f210916a = r100;
        this.f210917b = r101;
        this.f210918c = r102;
        this.f210919d = r103;
    }
}
