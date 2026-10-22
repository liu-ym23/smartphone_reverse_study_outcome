package com.ss.android.lark.conditional.access.web.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RejectBindDeviceWebActivity f418510a;

    public b(RejectBindDeviceWebActivity r100) {
        this.f418510a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L4;
        r100.dismiss();
    L4:
        this.f418510a.finish();
    }
}
