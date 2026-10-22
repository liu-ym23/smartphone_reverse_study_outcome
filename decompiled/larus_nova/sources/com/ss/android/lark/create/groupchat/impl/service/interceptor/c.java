package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f420226a = null;

    static {
        f420226a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
