package com.tonicartos.superslim;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Recycler f461911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<View> f461912b;

    /* JADX INFO: renamed from: com.tonicartos.superslim.a$a, reason: collision with other inner class name */
    public static class C5547a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f461913a;

        public C5547a(View r100, boolean r101) {
            this.f461913a = r100;
        }
    }

    public final C5547a a(int r100) {
        View r101 = this.f461912b.get(r100);
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r101 != null) goto L9;
        r101 = this.f461911a.getViewForPosition(r100);
    L9:
        return new C5547a(r101, r102);
    L5:
        r102 = false;
        goto L6
    }

    public a(RecyclerView.LayoutManager r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        this.f461912b = new SparseArray(r100.getChildCount());
        this.f461911a = r101;
        r100.getLayoutDirection();
    }
}
