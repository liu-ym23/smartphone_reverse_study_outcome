package com.bytedance.android.shopping.store.moments.module.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ECStoreMomentPresenter a;

    public c(ECStoreMomentPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.d0().fetchMomentApi();
    }
}
