package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserScopeDeviceDeclareFragment f418040a;

    public m(UserScopeDeviceDeclareFragment r100) {
        this.f418040a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        UserScopeDeviceDeclareFragment r102 = this.f418040a;
        int r103 = UserScopeDeviceDeclareFragment.f418024m;
        r102.ba0().pin();
    }
}
