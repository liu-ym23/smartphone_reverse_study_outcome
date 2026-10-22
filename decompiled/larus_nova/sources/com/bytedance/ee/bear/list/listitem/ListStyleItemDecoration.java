package com.bytedance.ee.bear.list.listitem;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ListStyleItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f228617a;

    public ListStyleItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        if (r102.getAdapter().getItemViewType(r104) != 273) goto L5;
        return;
    L5:
        Resources r105 = r102.getResources();
        boolean r106 = true;
        int r107 = 0;
        if (r104 == (r102.getAdapter().getItemCount() - 1)) goto L9;
        r106 = false;
    L9:
        int r108 = r105.getDimensionPixelSize(R.dimen.list_edit_sort_dialog_menu_height);
        if (r106 == true) goto L12;
    L14:
        r100.bottom = r107;
        return;
    L12:
        if (this.f228617a == true) goto L14;
        r107 = r108;
        goto L14
    }
}
