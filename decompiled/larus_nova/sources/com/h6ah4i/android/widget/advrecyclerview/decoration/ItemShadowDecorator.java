package com.h6ah4i.android.widget.advrecyclerview.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public class ItemShadowDecorator extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        int r103 = r101.getChildCount();
        if (r103 != 0) goto L5;
        return;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L26;
        View r105 = r101.getChildAt(r104);
        if (r105.getVisibility() == 0) goto L11;
    L9:
        boolean r106 = false;
    L22:
        if (r106 == true) goto L24;
        r104 = r104 + 1;
        goto L6
    L24:
        r105.getTranslationX();
        r105.getTranslationY();
        r105.getLeft();
        throw null;
    L11:
        if (r105.getAlpha() != 1.0f) goto L9;
        Drawable r107 = r105.getBackground();
        if (r107 == null) goto L9;
        if ((r107 instanceof ColorDrawable) == true) goto L19;
    L21:
        r106 = true;
        goto L22
    L19:
        if (((ColorDrawable) r107).getAlpha() != 0) goto L21;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r100.set(0, 0, 0, 0);
    }
}
