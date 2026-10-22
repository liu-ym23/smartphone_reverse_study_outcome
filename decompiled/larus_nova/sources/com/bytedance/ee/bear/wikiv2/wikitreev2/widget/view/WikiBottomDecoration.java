package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: classes18.dex */
public class WikiBottomDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f242248a;

    public WikiBottomDecoration(int r100) {
        this.f242248a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        RecyclerView.Adapter r104 = r102.getAdapter();
        if (r104 != null) goto L6;
        return;
    L6:
        if (r101 != ((BaseQuickAdapter) r104).getHeaderLayout()) goto L8;
        return;
    L8:
        boolean r105 = true;
        if (r102.getChildAdapterPosition(r101) == (r104.getItemCount() - 1)) goto L12;
        r105 = false;
    L12:
        if (r105 == false) goto L14;
        r100.bottom = r102.getResources().getDimensionPixelSize(this.f242248a);
        return;
    L14:
        r100.bottom = 0;
    }
}
