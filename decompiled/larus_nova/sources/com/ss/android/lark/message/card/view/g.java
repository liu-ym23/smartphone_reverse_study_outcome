package com.ss.android.lark.message.card.view;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnLongClickListener f431936a;

    public g(c r100) {
        this.f431936a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        View.OnLongClickListener r101 = this.f431936a;
        if (r101 == null) goto L7;
        r101.onLongClick(r100);
        return true;
    L7:
        return true;
    }
}
