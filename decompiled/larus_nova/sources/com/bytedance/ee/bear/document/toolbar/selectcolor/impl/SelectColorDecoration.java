package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f222358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f222359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f222360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f222361d;

    public SelectColorDecoration(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getDimensionPixelSize(R.dimen.toolbar_color_item_shadow_size);
        this.f222360c = r101.getDimensionPixelSize(R.dimen.toolbar_color_item_horizontal_margin);
        this.f222361d = r101.getDimensionPixelSize(R.dimen.toolbar_color_item_vertical_margin);
        Bitmap r103 = BitmapFactory.decodeResource(r101, R.drawable.sheet_item_shadow);
        this.f222359b = r103;
        this.f222359b = Bitmap.createScaledBitmap(r103, r102, r102, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        View r103 = this.f222358a;
        if (r103 == null) goto L6;
        int r104 = r103.getLeft();
        int r105 = this.f222358a.getTop();
        r100.drawBitmap(this.f222359b, r104 - ((this.f222359b.getWidth() - this.f222358a.getWidth()) / 2), r105 - ((this.f222359b.getHeight() - this.f222358a.getHeight()) / 2), null);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r102.getLayoutParams() == null) goto L29;
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = ((GridLayoutManager) r102.getLayoutManager()).getSpanCount();
        boolean r106 = true;
        int r107 = 0;
        if ((r104 % r105) != 0) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == false) goto L12;
        int r109 = this.f222360c;
    L13:
        r100.left = r109;
        if ((r104 / r105) != 0) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == false) goto L19;
        int r111 = this.f222361d;
    L20:
        r100.top = r111;
        if (((r104 + 1) % r105) == 0) goto L24;
        r106 = false;
    L24:
        if (r106 == false) goto L26;
        r107 = this.f222360c;
    L26:
        r100.right = r107;
        r100.bottom = this.f222361d;
        return;
    L19:
        r111 = 0;
        goto L20
    L16:
        r110 = false;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L9:
        r108 = false;
        goto L10
    }
}
