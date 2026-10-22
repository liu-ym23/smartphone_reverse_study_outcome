package com.ss.android.lark.conditional.access.nopermission.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeviceAuthenticationNoPermissionFragment f418286a;

    public a(DeviceAuthenticationNoPermissionFragment r100) {
        this.f418286a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceAuthenticationNoPermissionFragment r100 = this.f418286a;     // Catch: Throwable -> L8
        if (r100.f418202m == false) goto L5;
        String r101 = "cert_auto";
    L6:
        r100.W90(r101);     // Catch: Throwable -> L8
        return;
    L5:
        r101 = "cert_button";
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
