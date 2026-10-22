package com.bytedance.ee.bear.bitable.card.view.record;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public class CellItemDecoration extends RecyclerView.ItemDecoration {
    public boolean h(int r100, int r101) {
        if (r101 == (r100 - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public CellItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r110) {
        LinearLayoutManager r111 = (LinearLayoutManager) r102.getLayoutManager();
        if (r111 != null) goto L5;
        return;
    L5:
        int r103 = r111.getItemViewType(r101);
        int r104 = r111.getItemCount();
        if (r103 == (-1)) goto L9;
        i(r100, r101, r103, r104, r102.getChildAdapterPosition(r101));
        return;
    }

    public void i(Rect r100, View r101, int r102, int r103, int r104) {
        Context r105 = r101.getContext();
        int r106 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_horizon_margin);
        int r107 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_vertical_margin);
        int r108 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_last_vertical_margin);
        if (r104 != 0) goto L5;
        boolean r109 = true;
    L6:
        if (r109 == false) goto L8;
        int r110 = r107;
    L10:
        if (h(r103, r104) == true) goto L13;
        r108 = r107 / 2;
    L13:
        r100.set(r106, r110, r106, r108);
        return;
    L8:
        r110 = r107 / 2;
        goto L10
    L5:
        r109 = false;
        goto L6
    }
}
