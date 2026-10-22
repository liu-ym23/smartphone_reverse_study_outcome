package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ WindowHeaderAuthorInfoItemPresenter a;

    public d(WindowHeaderAuthorInfoItemPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        yn.d r4 = this.a.d0().getLiveManager();
        if (r4.f() == false) goto L5;
        r4.j(true);
        return;
    L5:
        r4.h(true);
    }
}
