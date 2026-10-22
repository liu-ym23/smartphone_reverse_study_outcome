package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f233222a;

    public e(d r100) {
        this.f233222a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        d.b r101 = this.f233222a.f233213d;
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }
}
