package com.bytedance.ee.bear.edit.component.toolbar2;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RecyclerViewScrollBottomListener extends RecyclerView.OnScrollListener {
    public int a;
    public int b;
    public a c;

    public interface a {
    }

    public RecyclerViewScrollBottomListener() {
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        GridLayoutManager r5 = r2.getLayoutManager();
        if (r5 != null) goto L5;
    L24:
        tt5.a.d("RecyclerViewScrollBottomListener", "layoutManager or scrollPositionListener is null");
        return;
    L5:
        if (this.c == null) goto L24;
        if ((r5 instanceof GridLayoutManager) == false) goto L11;
        GridLayoutManager r6 = r5;
        this.a = r6.findFirstCompletelyVisibleItemPosition();
        this.b = r6.findLastCompletelyVisibleItemPosition();
    L13:
        int r7 = r5.getChildCount();
        int r8 = r5.getItemCount();
        if (r7 > 0) goto L16;
    L18:
        if (r7 > 0) goto L20;
    L22:
        ((BaseSubToolbarV2Fragment.a) this.c).a(1);
        return;
    L20:
        if (this.a != 0) goto L22;
        ((BaseSubToolbarV2Fragment.a) this.c).a(0);
        return;
    L16:
        if (this.b < (r8 - 1)) goto L18;
        ((BaseSubToolbarV2Fragment.a) this.c).a(2);
        return;
    L11:
        if ((r5 instanceof LinearLayoutManager) == false) goto L13;
        LinearLayoutManager r9 = (LinearLayoutManager) r5;
        this.a = r9.findFirstCompletelyVisibleItemPosition();
        this.b = r9.findLastCompletelyVisibleItemPosition();
        goto L13
    }
}
