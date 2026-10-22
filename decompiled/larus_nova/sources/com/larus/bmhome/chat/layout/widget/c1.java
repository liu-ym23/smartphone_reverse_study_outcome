package com.larus.bmhome.chat.layout.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes25.dex */
public final class c1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollToRecyclerView f304975a;

    public c1(ScrollToRecyclerView r100) {
        this.f304975a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        ScrollToRecyclerView r103 = this.f304975a;
        r103.f304869k += r101;
        r103.f304870l += r102;
        super.onScrolled(r100, r101, r102);
        ScrollToRecyclerView r104 = this.f304975a;
        ScrollToRecyclerView.a r105 = r104.f304871m;
        if (r105 == null) goto L6;
        r105.a(r104.f304869k);
        return;
    }
}
