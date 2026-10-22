package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes34.dex */
public final class a0 extends c0 {
    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int e() {
        return this.f401788a.f401672l;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int f() {
        RecyclerView.k r100 = this.f401788a;
        return r100.f401672l - r100.D();
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int g() {
        return this.f401788a.D();
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int h() {
        return this.f401788a.f401670j;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int i() {
        return this.f401788a.f401671k;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int j() {
        return this.f401788a.C();
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int k() {
        RecyclerView.k r100 = this.f401788a;
        return (r100.f401672l - r100.C()) - this.f401788a.D();
    }

    public a0(RecyclerView.k r100) {
        super(r100);
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int a(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f401788a.getClass();
        return (r100.getRight() + ((RecyclerView.LayoutParams) r100.getLayoutParams()).f401652b.right) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int b(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f401788a.getClass();
        return (RecyclerView.k.z(r100) + ((ViewGroup.MarginLayoutParams) r101).leftMargin) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int c(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f401788a.getClass();
        return (RecyclerView.k.y(r100) + ((ViewGroup.MarginLayoutParams) r101).topMargin) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int d(View r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        this.f401788a.getClass();
        return (r100.getLeft() - ((RecyclerView.LayoutParams) r100.getLayoutParams()).f401652b.left) - ((ViewGroup.MarginLayoutParams) r101).leftMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int l(View r100) {
        this.f401788a.H(r100, this.f401790c);
        return this.f401790c.right;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final int m(View r100) {
        this.f401788a.H(r100, this.f401790c);
        return this.f401790c.left;
    }

    @Override // com.obric.oui.orecyclerview.widget.c0
    public final void n(int r100) {
        RecyclerView r101 = this.f401788a.f401662b;
        if (r101 == null) goto L7;
        int r102 = r101.f401608e.e();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101.f401608e.d(r103).offsetLeftAndRight(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }
}
