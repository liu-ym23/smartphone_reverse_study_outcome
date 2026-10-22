package com.bytedance.locallife.dito.utils;

import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes21.dex */
public final class u {
    public static Pair<Integer, Integer> a(RecyclerView r100) {
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L7;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
        return new Pair(Integer.valueOf(r102.findFirstVisibleItemPosition()), Integer.valueOf(r102.findLastVisibleItemPosition()));
    L7:
        if ((r101 instanceof GridLayoutManager) == false) goto L11;
        GridLayoutManager r103 = (GridLayoutManager) r101;
        return new Pair(Integer.valueOf(r103.findFirstVisibleItemPosition()), Integer.valueOf(r103.findLastVisibleItemPosition()));
    L11:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L27;
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r101;
        int r105 = r104.getSpanCount();
        int[] r106 = new int[r105];
        r104.findLastVisibleItemPositions(r106);
        int r107 = 0;
        int r108 = r106[0];
        int r109 = 0;
    L13:
        if (r109 >= r105) goto L18;
        int r110 = r106[r109];
        if (r110 <= r108) goto L17;
        r108 = r110;
    L17:
        r109 = r109 + 1;
        goto L13
    L18:
        r104.findFirstVisibleItemPositions(r106);
        int r111 = r106[0];
    L19:
        if (r107 >= r105) goto L25;
        int r112 = r106[r107];
        if (r112 >= r111) goto L23;
        r111 = r112;
    L23:
        r107 = r107 + 1;
        goto L19
    L25:
        return new Pair(Integer.valueOf(r111), Integer.valueOf(r108));
    L27:
        throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager");
    }
}
