package com.bytedance.locallife.dito.helper;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.LayoutManager f258309a;

    public static final class a {
    }

    static {
    }

    public b(RecyclerView.LayoutManager r100) {
        this.f258309a = r100;
    }

    public final void a(int r100, int r101) {
        RecyclerView.LayoutManager r102 = this.f258309a;
        if (r102 != null) goto L5;
    L10:
        rq6.a.f538927a.c("DitoScrollHelper", "执行handleScrollToPositionWithOffset， position = " + r100 + ", offset = " + r101);
        return;
    L5:
        if ((r102 instanceof LinearLayoutManager) == false) goto L8;
        ((LinearLayoutManager) r102).scrollToPositionWithOffset(r100, r101);
        goto L10
    L8:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L10;
        ((StaggeredGridLayoutManager) r102).scrollToPositionWithOffset(r100, r101);
        goto L10
    }
}
