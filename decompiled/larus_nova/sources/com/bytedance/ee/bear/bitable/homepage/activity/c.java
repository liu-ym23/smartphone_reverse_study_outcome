package com.bytedance.ee.bear.bitable.homepage.activity;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableMessageAdapter f212308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CardInfo f212309b;

    public c(BitableMessageAdapter r100, CardInfo r101) {
        this.f212308a = r100;
        this.f212309b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f212308a.f212269b.invoke(this.f212309b.getChatId());
    }
}
