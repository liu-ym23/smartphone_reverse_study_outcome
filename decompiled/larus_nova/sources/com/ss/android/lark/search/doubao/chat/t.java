package com.ss.android.lark.search.doubao.chat;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoSugAdapter f440095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoubaoSugAdapter.a f440096b;

    public t(DoubaoSugAdapter r100, DoubaoSugAdapter.a r101) {
        this.f440095a = r100;
        this.f440096b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f440095a.f440046b.invoke(this.f440096b);
    }
}
