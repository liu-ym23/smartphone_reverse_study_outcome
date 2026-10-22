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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetTabItemDecoration extends RecyclerView.ItemDecoration {
    public static final int[] c = null;
    public final Drawable a;
    public final Context b;

    static {
        c = new int[]{R.attr.listDivider};
    }

    public SheetTabItemDecoration(Context r3) {
        TypedArray r0 = r3.obtainStyledAttributes(c);
        this.a = r0.getDrawable(0);
        r0.recycle();
        this.b = r3;
    }

    public final void onDraw(Canvas r11, RecyclerView r12, RecyclerView.State r13) {
        int r14 = r12.getPaddingTop();
        int r0 = r12.getHeight() - r12.getPaddingBottom();
        int r1 = r12.getChildCount() - 1;
        boolean r4 = false;
    L3:
        if (r1 < 0) goto L11;
        View r5 = r12.getChildAt(r1);
        SheetTabItem r6 = (SheetTabItem) r5.getTag();
        int r8 = (r5.getRight() + ((ViewGroup.MarginLayoutParams) r5.getLayoutParams()).rightMargin) + Math.round(r5.getTranslationX());
        int r7 = this.a.getIntrinsicHeight() + r8;
        if (r6.getSelected() == false) goto L7;
        this.a.setBounds(r8, r14, r7, r0);
        this.a.setColorFilter(this.b.getResources().getColor(2131105869), PorterDuff.Mode.SRC);
        this.a.draw(r11);
        r4 = true;
    L10:
        r1 = r1 - 1;
        goto L3
    L7:
        if (r4 == false) goto L9;
        this.a.setBounds(r8, r14, r7, r0);
        this.a.setColorFilter(this.b.getResources().getColor(2131105869), PorterDuff.Mode.SRC);
        this.a.draw(r11);
        r4 = false;
        goto L10
    L9:
        this.a.setBounds(r8, UIHelper.dp2px(4.0f) + r14, r7, r0 - UIHelper.dp2px(4.0f));
        this.a.setColorFilter(this.b.getResources().getColor(2131103353), PorterDuff.Mode.SRC);
        this.a.draw(r11);
        goto L10
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        r1.set(0, 0, this.a.getIntrinsicWidth(), 0);
    }
}
