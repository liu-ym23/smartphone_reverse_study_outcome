package com.larus.office.base.plugins.toolbar.colorpicker;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/colorpicker/ColorPickerGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spacing", "", "spanCount", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorPickerGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f360839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f360840b;

    public ColorPickerGridItemDecoration(int r100, int r101) {
        this.f360839a = r100;
        this.f360840b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.LayoutManager r105 = r102.getLayoutManager();
        if ((r105 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r106 = (GridLayoutManager) r105;
    L6:
        if (r106 != null) goto L8;
        return;
    L8:
        GridLayoutManager.SpanSizeLookup r107 = r106.getSpanSizeLookup();
        int r108 = r107.getSpanSize(r104);
        int r109 = this.f360840b;
        if (r108 != r109) goto L12;
        r100.set(0, 0, 0, 0);
        return;
    L12:
        int r110 = r107.getSpanIndex(r104, r109);
        int r111 = this.f360839a;
        int r112 = this.f360840b;
        r100.left = (r110 * r111) / r112;
        r100.right = r111 - (((r110 + 1) * r111) / r112);
        r100.top = r111;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
