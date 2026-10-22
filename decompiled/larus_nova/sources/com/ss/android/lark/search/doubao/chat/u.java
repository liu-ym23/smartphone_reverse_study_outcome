package com.ss.android.lark.search.doubao.chat;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoSugAdapter f440097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoubaoSugAdapter.a f440098b;

    public u(DoubaoSugAdapter r100, DoubaoSugAdapter.a r101) {
        this.f440097a = r100;
        this.f440098b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f440097a.f440047c.invoke(this.f440098b);
    }
}
