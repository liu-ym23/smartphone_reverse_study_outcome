package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f239560a;

    public e(d r100) {
        this.f239560a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f239560a.f239552o = false;
        if (d.s() == false) goto L5;
        tt5.a.h("TtsSession", "showPermissionDialogWithoutFloatPermission, click cancel");
        this.f239560a.h();
        return;
    L5:
        this.f239560a.n("showPermissionDialog, click cancel");
    }
}
