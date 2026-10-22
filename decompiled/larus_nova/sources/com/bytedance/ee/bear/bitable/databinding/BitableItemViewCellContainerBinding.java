package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.page.PageCellContainerLayout;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewFieldViewV1;
import com.bytedance.ee.bear.bitable.itemview.cell.other.EmptyCell;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableItemViewCellContainerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PageCellContainerLayout f210830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PageCellContainerLayout f210831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f210832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f210833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f210834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EmptyCell f210835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ItemViewFieldViewV1 f210836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f210837h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210830a;
    }

    public BitableItemViewCellContainerBinding(PageCellContainerLayout r100, PageCellContainerLayout r101, FrameLayout r102, FrameLayout r103, View r104, EmptyCell r105, ItemViewFieldViewV1 r106, AppCompatTextView r107) {
        this.f210830a = r100;
        this.f210831b = r101;
        this.f210832c = r102;
        this.f210833d = r103;
        this.f210834e = r104;
        this.f210835f = r105;
        this.f210836g = r106;
        this.f210837h = r107;
    }
}
