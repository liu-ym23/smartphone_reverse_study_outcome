package com.ss.android.lark.inline.ai.logic;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f427286a = null;

    static {
        f427286a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L5;
        r100.cancel();
        return;
    }
}
