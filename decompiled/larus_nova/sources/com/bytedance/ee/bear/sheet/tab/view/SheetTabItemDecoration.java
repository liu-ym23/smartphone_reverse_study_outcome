package com.bytedance.ee.bear.sheet.tab.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetTabItem;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes18.dex */
public class SheetTabItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f238402c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f238403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f238404b;

    static {
        f238402c = new int[]{R.attr.listDivider};
    }

    public SheetTabItemDecoration(Context r100) {
        TypedArray r101 = r100.obtainStyledAttributes(f238402c);
        this.f238403a = r101.getDrawable(0);
        r101.recycle();
        this.f238404b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        int r113 = r111.getPaddingTop();
        int r100 = r111.getHeight() - r111.getPaddingBottom();
        int r101 = r111.getChildCount() - 1;
        boolean r102 = false;
    L3:
        if (r101 < 0) goto L11;
        View r103 = r111.getChildAt(r101);
        SheetTabItem r104 = (SheetTabItem) r103.getTag();
        int r105 = (r103.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r103.getLayoutParams())).rightMargin) + Math.round(r103.getTranslationX());
        int r106 = this.f238403a.getIntrinsicHeight() + r105;
        if (r104.getSelected() == false) goto L7;
        this.f238403a.setBounds(r105, r113, r106, r100);
        this.f238403a.setColorFilter(this.f238404b.getResources().getColor(com.larus.nova.R.color.sheet_tab_item_divider_selected), PorterDuff.Mode.SRC);
        this.f238403a.draw(r110);
        r102 = true;
    L10:
        r101 = r101 - 1;
        goto L3
    L7:
        if (r102 == false) goto L9;
        this.f238403a.setBounds(r105, r113, r106, r100);
        this.f238403a.setColorFilter(this.f238404b.getResources().getColor(com.larus.nova.R.color.sheet_tab_item_divider_selected), PorterDuff.Mode.SRC);
        this.f238403a.draw(r110);
        r102 = false;
        goto L10
    L9:
        this.f238403a.setBounds(r105, UIHelper.dp2px(4.0f) + r113, r106, r100 - UIHelper.dp2px(4.0f));
        this.f238403a.setColorFilter(this.f238404b.getResources().getColor(com.larus.nova.R.color.line_divider_default), PorterDuff.Mode.SRC);
        this.f238403a.draw(r110);
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r100.set(0, 0, this.f238403a.getIntrinsicWidth(), 0);
    }
}
