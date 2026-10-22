package com.bytedance.locallife.biz.utils.rv;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ho6.a;

/* JADX INFO: loaded from: classes21.dex */
public class OnRecyclerViewFlingListener extends RecyclerView.OnFlingListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f256992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f256993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f256994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f256995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f256996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f256997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f256998g;

    public OnRecyclerViewFlingListener(RecyclerView r100, bw6.a r101) {
        this.f256994c = true;
        this.f256997f = -1;
        this.f256998g = 0;
        this.f256992a = r100;
        this.f256993b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public final boolean onFling(int r100, int r101) {
        if (this.f256994c == false) goto L45;
        RecyclerView.LayoutManager r102 = this.f256992a.getLayoutManager();
        boolean r103 = true;
        if ((r102 instanceof GridLayoutManager) == false) goto L11;
        GridLayoutManager r104 = (GridLayoutManager) r102;
        int r105 = r104.findFirstVisibleItemPosition();
        int r106 = r104.findLastVisibleItemPosition();
        if (this.f256997f != (-1)) goto L25;
        this.f256997f = r104.getSpanCount();
    L25:
        int r107 = r102.getChildCount();
        int r108 = r102.getItemCount();
        if (r107 <= 0) goto L45;
        View r109 = r102.findViewByPosition(r105);
        if (r109 == null) goto L30;
        int r110 = r109.getHeight();
    L31:
        if (r110 == 0) goto L45;
        int r111 = this.f256997f;
        if (r111 != (-1)) goto L42;
        int r112 = this.f256998g;
        if (r112 <= 0) goto L38;
        if (r112 > r108) goto L38;
    L40:
        if (((r101 / r110) + r106) < (r108 - this.f256998g)) goto L45;
    L46:
        if (r103 == true) goto L48;
    L51:
        return false;
    L48:
        if (this.f256993b.hasMore() == false) goto L50;
        this.f256993b.preload();
        goto L51
    L50:
        this.f256993b.x1();
    L38:
        this.f256998g = 2;
        goto L40
    L42:
        int r113 = r101 / r110;
        if (((r113 + (r106 / r111)) + 3) < (r108 / r111)) goto L45;
    L30:
        r110 = 0;
        goto L31
    L11:
        if ((r102 instanceof LinearLayoutManager) == false) goto L14;
        LinearLayoutManager r114 = (LinearLayoutManager) r102;
        r105 = r114.findFirstVisibleItemPosition();
        r106 = r114.findLastVisibleItemPosition();
        goto L25
    L14:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L53;
        StaggeredGridLayoutManager r115 = (StaggeredGridLayoutManager) r102;
        if (this.f256997f != (-1)) goto L19;
        this.f256997f = r115.getSpanCount();
    L19:
        if (this.f256995d != null) goto L22;
        this.f256995d = new int[r115.getSpanCount()];
    L22:
        if (this.f256996e != null) goto L24;
        this.f256996e = new int[r115.getSpanCount()];
    L24:
        r115.findFirstVisibleItemPositions(this.f256995d);
        r115.findLastVisibleItemPositions(this.f256996e);
        r105 = this.f256995d[0];
        int[] r116 = this.f256996e;
        r106 = r116[r116.length - 1];
        goto L25
    L53:
        throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
    L45:
        r103 = false;
        goto L46
    }
}
