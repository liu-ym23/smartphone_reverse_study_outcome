package com.bytedance.ee.bear.sheet.toolbar2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockCellAttrDivider extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemV2[] f238418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorDrawable f238419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f238420c;

    public SheetBlockCellAttrDivider(Context r100, ItemV2[] r101) {
        this.f238420c = new Rect();
        this.f238418a = r101;
        this.f238419b = new ColorDrawable(r100.getResources().getColor(R.color.line_divider_default));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        if (r101.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.f238419b == null) goto L27;
        r100.save();
        if (r101.getClipToPadding() == false) goto L10;
        int r111 = r101.getPaddingLeft();
        int r102 = r101.getWidth() - r101.getPaddingRight();
        r100.clipRect(r111, r101.getPaddingTop(), r102, r101.getHeight() - r101.getPaddingBottom());
    L11:
        int r103 = r101.getChildCount();
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L21;
        ItemV2[] r105 = this.f238418a;
        if (r104 != (r105.length - 1)) goto L16;
        boolean r106 = false;
    L17:
        if (r106 == false) goto L20;
        View r107 = r101.getChildAt(r104);
        r101.getDecoratedBoundsWithMargins(r107, this.f238420c);
        int r108 = this.f238420c.bottom + Math.round(r107.getTranslationY());
        this.f238419b.setBounds(r111, r108 - this.f238419b.getIntrinsicHeight(), r102, r108);
        this.f238419b.draw(r100);
    L20:
        r104 = r104 + 1;
        goto L12
    L16:
        r106 = SheetBlockPrimaryItemId.CellAttrSecondaryItemId.separator.name().equals(r105[r104 + 1].getId());
        goto L17
    L21:
        r100.restore();
        return;
    L10:
        r102 = r101.getWidth();
        r111 = 0;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r100.set(0, 0, this.f238419b.getIntrinsicWidth(), r101.getResources().getDimensionPixelOffset(R.dimen.space_kit_len_divider));
    }
}
