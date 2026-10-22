package com.bytedance.ee.bear.core.toolbar.selectcolor.impl;

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
import h18.d;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorItemDivider extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f217215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f217216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f217217c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f217218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f217219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f217220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f217221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f217222e;

        public a(Context r100) {
            float r101 = d.b(r100, 4);
            float r102 = d.b(r100, 3);
            this.f217222e = d.a(r100, 1.5f);
            this.f217220c = d.b(r100, 7);
            this.f217221d = d.b(r100, 7);
            Paint r103 = new Paint(1);
            r103.setColor(UDColorUtils.getColor(r100, R.color.bg_float));
            r103.setStrokeWidth(r101);
            r103.setStyle(Paint.Style.STROKE);
            this.f217218a = r103;
            Paint r104 = new Paint(1);
            r104.setColor(UDColorUtils.getColor(r100, R.color.primary_fill_default));
            r104.setStrokeWidth(r102);
            r104.setStyle(Paint.Style.STROKE);
            this.f217219b = r104;
        }
    }

    public SelectColorItemDivider(Context r100) {
        this.f217217c = -1;
        this.f217215a = new a(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDrawOver(r100, r101, r102);
        if (this.f217217c == (-1)) goto L8;
        View r103 = ((GridLayoutManager) r101.getLayoutManager()).getChildAt(this.f217217c);
        if (r103 == null) goto L9;
        int r104 = r103.getLeft();
        int r105 = r103.getTop();
        int r106 = r103.getRight();
        int r107 = r103.getBottom();
        a r108 = this.f217215a;
        r108.getClass();
        float r109 = r104;
        float r110 = r105;
        float r111 = r106;
        float r112 = r107;
        RectF r113 = new RectF(r109, r110, r111, r112);
        float r114 = r108.f217220c;
        r100.drawRoundRect(r113, r114, r114, r108.f217218a);
        a r115 = this.f217215a;
        r115.getClass();
        float r116 = r115.f217222e;
        RectF r117 = new RectF(r109 - r116, r110 - r116, r111 + r116, r112 + r116);
        float r118 = r115.f217221d;
        r100.drawRoundRect(r117, r118, r118, r115.f217219b);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r102.getChildAdapterPosition(r101);
        int r104 = this.f217216b;
        r100.left = r104;
        r100.top = r104;
    }
}
