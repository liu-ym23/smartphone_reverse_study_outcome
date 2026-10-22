package com.oubowu.stickyitemdecoration;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import koa.a;
import koa.b;

/* JADX INFO: loaded from: classes34.dex */
public class StickyItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f404344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f404345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f404346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f404347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView.Adapter f404348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StickyHeadContainer f404349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f404350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f404351h;

    public static void h(StickyItemDecoration r100) {
        r100.f404349f.f404339c = Integer.MIN_VALUE;
    }

    public StickyItemDecoration(StickyHeadContainer r100, int r101) {
        this.f404350g = true;
        this.f404349f = r100;
        this.f404344a = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDraw(r100, r101, r102);
        RecyclerView.Adapter r103 = r101.getAdapter();
        if (this.f404348e == r103) goto L6;
        this.f404348e = r103;
        this.f404346c = -1;
        r103.registerAdapterDataObserver(new b(this));
    L6:
        if (this.f404348e != null) goto L8;
        return;
    L8:
        RecyclerView.LayoutManager r104 = r101.getLayoutManager();
        int r105 = 0;
        if ((r104 instanceof GridLayoutManager) == false) goto L12;
        int r106 = ((GridLayoutManager) r104).findFirstVisibleItemPosition();
    L21:
        this.f404345b = r106;
    L22:
        boolean r107 = true;
        if (r106 < 0) goto L31;
        if (this.f404344a != this.f404348e.getItemViewType(r106)) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == true) goto L33;
        r106 = r106 - 1;
    L33:
        if (this.f404346c == r106) goto L36;
        this.f404346c = r106;
    L36:
        if (this.f404350g == false) goto L57;
        int r109 = this.f404345b;
        int r110 = this.f404346c;
        if (r109 < r110) goto L57;
        if (r110 == (-1)) goto L57;
        View r111 = r101.findChildViewUnder(r100.getWidth() / 2.0f, this.f404349f.getChildHeight() + 0.01f);
        StickyHeadContainer r112 = this.f404349f;
        int r113 = this.f404346c;
        StickyHeadContainer.a r114 = r112.f404343g;
        if (r114 != null) goto L43;
    L45:
        r112.f404339c = r113;
        int r115 = r101.getChildAdapterPosition(r111);
        if (r115 != (-1)) goto L49;
    L47:
        r107 = false;
    L50:
        if (r107 == true) goto L52;
    L54:
        a r116 = this.f404351h;
        if (r116 == null) goto L64;
        r116.a(r105);
        return;
    L64:
        return;
    L52:
        if (r111.getTop() <= 0) goto L54;
        r105 = r111.getTop() - this.f404349f.getChildHeight();
        goto L54
    L49:
        if (this.f404344a != this.f404348e.getItemViewType(r115)) goto L47;
    L43:
        if (r112.f404339c == r113) goto L45;
        r114.a(r113);
    L57:
        a r117 = this.f404351h;
        if (r117 == null) goto L66;
        r117.b();
        return;
    L66:
        return;
    L27:
        r108 = false;
        goto L28
    L31:
        r106 = -1;
        goto L33
    L12:
        if ((r104 instanceof LinearLayoutManager) == false) goto L15;
        r106 = ((LinearLayoutManager) r104).findFirstVisibleItemPosition();
        goto L21
    L15:
        if ((r104 instanceof StaggeredGridLayoutManager) == false) goto L20;
        StaggeredGridLayoutManager r118 = (StaggeredGridLayoutManager) r104;
        int[] r119 = new int[r118.getSpanCount()];
        this.f404347d = r119;
        r118.findFirstVisibleItemPositions(r119);
        int[] r120 = this.f404347d;
        int r121 = r120.length;
        int r122 = Integer.MAX_VALUE;
        int r123 = 0;
    L17:
        if (r123 >= r121) goto L19;
        r122 = Math.min(r120[r123], r122);
        r123 = r123 + 1;
        goto L17
    L19:
        r106 = r122;
        goto L21
    L20:
        r106 = 0;
        goto L21
    }
}
