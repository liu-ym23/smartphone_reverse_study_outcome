package com.ss.android.ugc.aweme.search.filter.view.component.panel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes40.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f453172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f453173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f453174c;

    public GridSpaceItemDecoration(int r100) {
        this.f453172a = Math.max(1, 2);
        this.f453173b = 0;
        this.f453174c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f453172a;
        if (r105 > 1) goto L5;
        return;
    L5:
        int r106 = r104 % r105;
        int r107 = this.f453174c;
        r100.left = (r106 * r107) / r105;
        r100.right = r107 - (((r106 + 1) * r107) / r105);
        r100.bottom = this.f453173b;
    }
}
