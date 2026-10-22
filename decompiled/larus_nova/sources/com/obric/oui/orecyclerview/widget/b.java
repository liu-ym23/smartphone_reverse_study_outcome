package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f401782a;

    public b(RecyclerView.Adapter r100) {
        this.f401782a = r100;
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onInserted(int r100, int r101) {
        this.f401782a.f401640a.d(r100, r101);
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onMoved(int r100, int r101) {
        this.f401782a.f401640a.b(r100, r101);
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onRemoved(int r100, int r101) {
        this.f401782a.f401640a.e(r100, r101);
    }

    @Override // com.obric.oui.orecyclerview.widget.x
    public final void onChanged(int r100, int r101, Object r102) {
        this.f401782a.f401640a.c(r100, r101, r102);
    }
}
