package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockPrimaryItemId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockCellAttrDivider extends RecyclerView.ItemDecoration {
    public ItemV2[] a;
    public final ColorDrawable b;
    public final Rect c;

    public SheetBlockCellAttrDivider(Context r2, ItemV2[] r3) {
        this.c = new Rect();
        this.a = r3;
        this.b = new ColorDrawable(r2.getResources().getColor(2131103353));
    }

    public final void onDraw(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        if (r9.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L27;
        r8.save();
        if (r9.getClipToPadding() == false) goto L10;
        int r11 = r9.getPaddingLeft();
        int r1 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r11, r9.getPaddingTop(), r1, r9.getHeight() - r9.getPaddingBottom());
    L11:
        int r2 = r9.getChildCount();
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L21;
        ItemV2[] r4 = this.a;
        if (r3 != (r4.length - 1)) goto L16;
        boolean r5 = false;
    L17:
        if (r5 == false) goto L20;
        View r6 = r9.getChildAt(r3);
        r9.getDecoratedBoundsWithMargins(r6, this.c);
        int r7 = this.c.bottom + Math.round(r6.getTranslationY());
        this.b.setBounds(r11, r7 - this.b.getIntrinsicHeight(), r1, r7);
        this.b.draw(r8);
    L20:
        r3 = r3 + 1;
        goto L12
    L16:
        r5 = SheetBlockPrimaryItemId.CellAttrSecondaryItemId.separator.name().equals(r4[r3 + 1].getId());
        goto L17
    L21:
        r8.restore();
        return;
    L10:
        r1 = r9.getWidth();
        r11 = 0;
        goto L11
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        r1.set(0, 0, this.b.getIntrinsicWidth(), r2.getResources().getDimensionPixelOffset(2131168376));
    }
}
