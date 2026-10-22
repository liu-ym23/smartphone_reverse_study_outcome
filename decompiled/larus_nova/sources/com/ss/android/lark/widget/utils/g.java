package com.ss.android.lark.widget.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f449083a = null;

    static {
        f449083a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
