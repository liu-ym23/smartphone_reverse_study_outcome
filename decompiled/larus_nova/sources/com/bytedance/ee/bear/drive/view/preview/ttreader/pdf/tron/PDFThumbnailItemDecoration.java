package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes16.dex */
public class PDFThumbnailItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f225261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f225262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f225263c;

    public PDFThumbnailItemDecoration(int r100) {
        this.f225261a = 3;
        this.f225262b = r100;
        this.f225263c = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        if (this.f225261a <= 0) goto L20;
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        int r105 = r102.getChildAdapterPosition(r101);
        if ((r104 instanceof GridLayoutManager) == false) goto L7;
        GridLayoutManager r106 = (GridLayoutManager) r104;
        int r107 = r106.getSpanSizeLookup().getSpanIndex(r105, this.f225261a);
        int r108 = r106.getSpanSizeLookup().getSpanSize(r105);
    L8:
        boolean r109 = this.f225263c;
        if (r109 == true) goto L11;
    L13:
        int r110 = this.f225262b;
        int r111 = this.f225261a;
        r100.left = r110 - ((r107 * r110) / r111);
        r100.right = ((r107 + 1) * r110) / r111;
    L14:
        if (r109 == false) goto L16;
    L18:
        r100.top = 0;
    L19:
        r100.bottom = this.f225262b;
        return;
    L16:
        if (r105 >= this.f225261a) goto L18;
        r100.top = this.f225262b;
        goto L19
    L11:
        if (r108 != this.f225261a) goto L13;
        r100.left = 0;
        r100.right = 0;
        goto L14
    L7:
        r107 = r105 % this.f225261a;
        r108 = 0;
        goto L8
    L20:
        r100.setEmpty();
    }
}
