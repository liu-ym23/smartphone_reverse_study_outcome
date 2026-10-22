package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewNotice;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordEmpty;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordTitleBarContainer;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewRecordContainer2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f210872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemViewRecordEmpty f210873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemViewNotice f210874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemViewNotice f210875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemViewRecordTitleBarContainer f210876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f210877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f210878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StickyItemViewLayout f210879h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210872a;
    }

    public BitableItemViewRecordContainer2Binding(View r100, ItemViewRecordEmpty r101, ItemViewNotice r102, ItemViewNotice r103, ItemViewRecordTitleBarContainer r104, LinearLayout r105, RecyclerView r106, StickyItemViewLayout r107) {
        this.f210872a = r100;
        this.f210873b = r101;
        this.f210874c = r102;
        this.f210875d = r103;
        this.f210876e = r104;
        this.f210877f = r105;
        this.f210878g = r106;
        this.f210879h = r107;
    }
}
