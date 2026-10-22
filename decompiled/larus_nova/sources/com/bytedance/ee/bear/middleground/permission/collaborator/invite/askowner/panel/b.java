package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f233269a;

    public b(a r100) {
        this.f233269a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f233269a.f233258b.close();
    }
}
