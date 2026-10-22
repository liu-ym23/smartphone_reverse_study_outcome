package com.bytedance.ee.bear.more.view3.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f235034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f235035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f235036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f235037d;

    public DividerItemDecoration(int r100, int r101, int r102) {
        this.f235034a = r100;
        this.f235035b = r101;
        this.f235036c = 0;
        Paint r103 = new Paint();
        this.f235037d = r103;
        r103.setColor(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        int r113 = r111.getChildCount();
        int r100 = 0;
    L4:
        if (r100 >= (r113 - 1)) goto L6;
        View r101 = r111.getChildAt(r100);
        int r102 = r101.getBottom() - this.f235034a;
        int r103 = r101.getBottom();
        int r104 = r101.getLeft() + this.f235035b;
        int r105 = r101.getRight() - this.f235036c;
        int r106 = (int) (r101.getTranslationY() + 0.5f);
        r110.save();
        r110.drawRect(r104, r102 + r106, r105, r103 + r106, this.f235037d);
        r110.restore();
        r100 = r100 + 1;
        goto L4
    }
}
