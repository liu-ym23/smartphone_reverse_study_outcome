package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208714a;

    public c(StageDataViewHolder r100) {
        this.f208714a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        rcb.c.d(r100);
        this.f208714a.f208670a.f();
    }
}
