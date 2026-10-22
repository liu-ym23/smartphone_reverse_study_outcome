package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes16.dex */
public class RecyclerViewScrollBottomListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f226264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f226265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f226266c;

    public interface a {
    }

    public RecyclerViewScrollBottomListener() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if (r103 != null) goto L5;
    L24:
        tt5.a.d("RecyclerViewScrollBottomListener", "layoutManager or scrollPositionListener is null");
        return;
    L5:
        if (this.f226266c == null) goto L24;
        if ((r103 instanceof GridLayoutManager) == false) goto L11;
        GridLayoutManager r104 = (GridLayoutManager) r103;
        this.f226264a = r104.findFirstCompletelyVisibleItemPosition();
        this.f226265b = r104.findLastCompletelyVisibleItemPosition();
    L13:
        int r105 = r103.getChildCount();
        int r106 = r103.getItemCount();
        if (r105 > 0) goto L16;
    L18:
        if (r105 > 0) goto L20;
    L22:
        ((BaseSubToolbarV2Fragment.a) this.f226266c).a(1);
        return;
    L20:
        if (this.f226264a != 0) goto L22;
        ((BaseSubToolbarV2Fragment.a) this.f226266c).a(0);
        return;
    L16:
        if (this.f226265b < (r106 - 1)) goto L18;
        ((BaseSubToolbarV2Fragment.a) this.f226266c).a(2);
        return;
    L11:
        if ((r103 instanceof LinearLayoutManager) == false) goto L13;
        LinearLayoutManager r107 = (LinearLayoutManager) r103;
        this.f226264a = r107.findFirstCompletelyVisibleItemPosition();
        this.f226265b = r107.findLastCompletelyVisibleItemPosition();
        goto L13
    }
}
