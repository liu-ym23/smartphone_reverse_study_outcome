package com.bytedance.ee.bear.bitable.jsapi.common;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f214414a = null;

    static {
        f214414a = new i();
    }

    public i() {
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        tt5.a.b("NewLarkForm", "onCancel");
    }
}
