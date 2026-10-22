package com.ss.android.lark.contact.base.contact_list.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_list.mvp.f;
import com.ss.android.lark.contact.base.contact_list.mvp.g;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w8b.a f418639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExternalContactAdapter2 f418640b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ExternalContactAdapter2.a r101 = this.f418640b.f418616e;
        if (r101 == null) goto L6;
        g r102 = (g) r101;
        qqb.c.c(new f(r102, this.f418639a));
        return;
    }

    public c(ExternalContactAdapter2 r100, w8b.a r101) {
        this.f418640b = r100;
        this.f418639a = r101;
    }
}
