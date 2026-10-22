package com.bytedance.ee.bear.bitable.card.view.form;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public class FormItemDecoration extends RecyclerView.ItemDecoration {
    public FormItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = r102.getChildViewHolder(r101).getItemViewType();
        int r105 = r102.getChildAdapterPosition(r101);
        Context r106 = r101.getContext();
        if (r104 != (-2)) goto L5;
    L16:
        int r107 = 0;
    L17:
        int r108 = 0;
    L18:
        r100.set(r107, r108, r107, 0);
        return;
    L5:
        if (r104 == (-5)) goto L16;
        if (r104 != (-3)) goto L13;
        if (r105 != 1) goto L11;
        r108 = r106.getResources().getDimensionPixelSize(R.dimen.bitable_form_footer_no_cell_vertical_margin);
    L12:
        r107 = r106.getResources().getDimensionPixelSize(R.dimen.bitable_form_horizon_margin);
        goto L18
    L11:
        r108 = r106.getResources().getDimensionPixelSize(R.dimen.bitable_form_footer_vertical_margin);
        goto L12
    L13:
        if (r105 != 1) goto L15;
        r107 = r106.getResources().getDimensionPixelSize(R.dimen.bitable_form_horizon_margin);
        goto L17
    L15:
        r108 = r106.getResources().getDimensionPixelSize(R.dimen.bitable_form_vertical_margin);
        r107 = r106.getResources().getDimensionPixelSize(R.dimen.bitable_form_horizon_margin);
        goto L18
    }
}
