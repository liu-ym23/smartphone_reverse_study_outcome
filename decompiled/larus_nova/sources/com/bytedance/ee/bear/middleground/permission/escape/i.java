package com.bytedance.ee.bear.middleground.permission.escape;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.b f233863a;

    public i(EscapeApiImpl.b r100) {
        this.f233863a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        g.b r102 = this.f233863a;
        if (r102 == null) goto L6;
        r102.onCancel();
        return;
    }
}
