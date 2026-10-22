package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeInviteExternalFragment f419271a;

    public c(OfficeInviteExternalFragment r100) {
        this.f419271a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OfficeInviteExternalFragment r101 = this.f419271a;
        int r102 = OfficeInviteExternalFragment.f419262i;
        r101.U90().requestFinish(this.f419271a);
    }
}
