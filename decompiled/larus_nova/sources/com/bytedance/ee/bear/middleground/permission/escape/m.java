package com.bytedance.ee.bear.middleground.permission.escape;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.b f233867a;

    public m(EscapeApiImpl.b r100) {
        this.f233867a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        g.b r102 = this.f233867a;
        if (r102 == null) goto L6;
        r102.onConfirm();
        return;
    }
}
