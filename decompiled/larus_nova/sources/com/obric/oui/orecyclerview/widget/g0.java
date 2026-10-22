package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes34.dex */
public abstract class g0 extends RecyclerView.ItemAnimator {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f401822g;

    public abstract boolean h(RecyclerView.y r100, int r101, int r102, int r103, int r104);

    public g0() {
        this.f401822g = true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public final boolean a(RecyclerView.y r110, RecyclerView.y r111, RecyclerView.ItemAnimator.c r112, RecyclerView.ItemAnimator.c r113) {
        int r100 = r112.f401649a;
        int r101 = r112.f401650b;
        if (r111.o() == false) goto L5;
        int r114 = r112.f401649a;
        int r102 = r112.f401650b;
        int r103 = r114;
    L6:
        p r104 = (p) this;
        if (r110 == r111) goto L11;
        float r115 = r110.f401728a.getTranslationX();
        float r116 = r110.f401728a.getTranslationY();
        float r105 = r110.f401728a.getAlpha();
        r104.m(r110);
        r110.f401728a.setTranslationX(r115);
        r110.f401728a.setTranslationY(r116);
        r110.f401728a.setAlpha(r105);
        r104.m(r111);
        r111.f401728a.setTranslationX(-((int) ((r103 - r100) - r115)));
        r111.f401728a.setTranslationY(-((int) ((r102 - r101) - r116)));
        r111.f401728a.setAlpha(0.0f);
        r104.f401868k.add(new p.a(r110, r111, r100, r101, r103, r102));
        return true;
    L11:
        return r104.h(r110, r100, r101, r103, r102);
    L5:
        r103 = r113.f401649a;
        r102 = r113.f401650b;
        goto L6
    }
}
