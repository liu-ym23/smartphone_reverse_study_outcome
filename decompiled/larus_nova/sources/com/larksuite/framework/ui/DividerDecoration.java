package com.larksuite.framework.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes24.dex */
public class DividerDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f285820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f285821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f285822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f285823d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f285824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f285825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f285826c;

        public a(Context r100) {
            this.f285824a = r100.getResources();
            Resources r101 = r100.getResources();
            this.f285825b = (int) TypedValue.applyDimension(0, 1.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
            this.f285826c = -16777216;
        }
    }

    public DividerDecoration(int r100, int r101, int r102) {
        this.f285820a = r100;
        this.f285821b = r101;
        this.f285822c = 0;
        Paint r103 = new Paint();
        this.f285823d = r103;
        r103.setColor(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        int r113 = r111.getChildCount();
        int r100 = 0;
    L3:
        if (r100 >= r113) goto L5;
        View r101 = r111.getChildAt(r100);
        int r102 = r101.getBottom();
        int r103 = this.f285820a + r102;
        int r104 = r101.getLeft() + this.f285821b;
        int r105 = r101.getRight() - this.f285822c;
        int r106 = (int) (r101.getTranslationY() + 0.5f);
        r110.save();
        r110.drawRect(r104, r102 + r106, r105, r103 + r106, this.f285823d);
        r110.restore();
        r100 = r100 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r100.set(0, 0, 0, this.f285820a);
    }
}
