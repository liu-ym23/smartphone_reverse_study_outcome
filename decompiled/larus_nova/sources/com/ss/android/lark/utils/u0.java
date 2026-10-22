package com.ss.android.lark.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class u0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0.c f444783a;

    public u0(s0.c r100) {
        this.f444783a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        s0.c r101 = this.f444783a;
        r101.getClass();
        ViewUtils.runOnUiThread(new t0(r101));
    }
}
