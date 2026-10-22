package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spacing", "", "spanCount", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorPickerGridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public ColorPickerGridItemDecoration(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        GridLayoutManager r7 = r4.getLayoutManager();
        if ((r7 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r8 = r7;
    L6:
        if (r8 != null) goto L8;
        return;
    L8:
        GridLayoutManager.SpanSizeLookup r9 = r8.getSpanSizeLookup();
        int r10 = r9.getSpanSize(r6);
        int r0 = this.b;
        if (r10 != r0) goto L12;
        r2.set(0, 0, 0, 0);
        return;
    L12:
        int r11 = r9.getSpanIndex(r6, r0);
        int r12 = this.a;
        int r1 = this.b;
        r2.left = (r11 * r12) / r1;
        r2.right = r12 - (((r11 + 1) * r12) / r1);
        r2.top = r12;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
