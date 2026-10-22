package com.bytedance.ee.bear.middleground.comment.card.aside;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsideComment f230943a;

    public c(AsideComment r100) {
        this.f230943a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f230943a.Ni(true);
    }
}
