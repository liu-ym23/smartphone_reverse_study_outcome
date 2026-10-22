package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.CommentView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.hierarchy.HierarchyCounterView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.hierarchy.HierarchyTintView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.leftcontent.GridCheckBoxUI;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.leftcontent.GridCountNumberUI;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableGridFixedCellViewLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonCellView f210803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GridCheckBoxUI f210804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentView f210805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GridCountNumberUI f210806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f210807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f210808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HierarchyCounterView f210809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HierarchyTintView f210810i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210802a;
    }

    public BitableGridFixedCellViewLayoutBinding(LinearLayout r100, CommonCellView r101, GridCheckBoxUI r102, CommentView r103, GridCountNumberUI r104, View r105, View r106, HierarchyCounterView r107, HierarchyTintView r108) {
        this.f210802a = r100;
        this.f210803b = r101;
        this.f210804c = r102;
        this.f210805d = r103;
        this.f210806e = r104;
        this.f210807f = r105;
        this.f210808g = r106;
        this.f210809h = r107;
        this.f210810i = r108;
    }
}
