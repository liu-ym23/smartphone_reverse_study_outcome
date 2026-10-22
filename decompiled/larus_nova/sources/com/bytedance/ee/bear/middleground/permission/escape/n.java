package com.bytedance.ee.bear.middleground.permission.escape;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.b f233868a;

    public n(EscapeApiImpl.b r100) {
        this.f233868a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        g.b r101 = this.f233868a;
        if (r101 == null) goto L6;
        r101.onCancel();
        return;
    }
}
