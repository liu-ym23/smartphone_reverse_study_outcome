package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorItemDivider extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f222367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f222368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f222369c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f222370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f222371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f222372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f222373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f222374e;

        public a(Context r100) {
            float r101 = h18.d.b(r100, 4);
            float r102 = h18.d.b(r100, 3);
            this.f222374e = h18.d.a(r100, 1.5f);
            this.f222372c = h18.d.b(r100, 7);
            this.f222373d = h18.d.b(r100, 7);
            Paint r103 = new Paint(1);
            r103.setColor(UDColorUtils.getColor(r100, R.color.bg_float));
            r103.setStrokeWidth(r101);
            r103.setStyle(Paint.Style.STROKE);
            this.f222370a = r103;
            Paint r104 = new Paint(1);
            r104.setColor(UDColorUtils.getColor(r100, R.color.primary_fill_default));
            r104.setStrokeWidth(r102);
            r104.setStyle(Paint.Style.STROKE);
            this.f222371b = r104;
        }
    }

    public SelectColorItemDivider(Context r100) {
        this.f222369c = -1;
        this.f222367a = new a(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDrawOver(r100, r101, r102);
        if (this.f222369c == (-1)) goto L8;
        View r103 = ((GridLayoutManager) r101.getLayoutManager()).getChildAt(this.f222369c);
        if (r103 == null) goto L9;
        int r104 = r103.getLeft();
        int r105 = r103.getTop();
        int r106 = r103.getRight();
        int r107 = r103.getBottom();
        a r108 = this.f222367a;
        r108.getClass();
        float r109 = r104;
        float r110 = r105;
        float r111 = r106;
        float r112 = r107;
        RectF r113 = new RectF(r109, r110, r111, r112);
        float r114 = r108.f222372c;
        r100.drawRoundRect(r113, r114, r114, r108.f222370a);
        a r115 = this.f222367a;
        r115.getClass();
        float r116 = r115.f222374e;
        RectF r117 = new RectF(r109 - r116, r110 - r116, r111 + r116, r112 + r116);
        float r118 = r115.f222373d;
        r100.drawRoundRect(r117, r118, r118, r115.f222371b);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r102.getChildAdapterPosition(r101);
        int r104 = this.f222368b;
        r100.left = r104;
        r100.top = r104;
    }
}
