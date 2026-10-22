package com.ss.android.lark.chatbase.view;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatImageGroup f416922a;

    public b(ChatImageGroup r100) {
        this.f416922a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        ChatImageGroup r102 = this.f416922a;
        if (r101 != 0) goto L5;
        boolean r103 = true;
    L6:
        int r104 = ChatImageGroup.f416892k;
        r102.a(r103);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        super.onScrolled(r100, r101, r102);
    }
}
