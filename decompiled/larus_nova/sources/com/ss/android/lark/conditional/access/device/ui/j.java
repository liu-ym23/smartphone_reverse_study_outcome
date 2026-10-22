package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f418037a = null;

    static {
        f418037a = new j();
    }

    public j() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L5;
        r100.dismiss();
        return;
    }
}
