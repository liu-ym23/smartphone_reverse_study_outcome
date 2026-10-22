package com.ss.android.lark.contact.base.service;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InvRequestUtils.LocalAndServerRequestImpl<Object> f418912a;

    public b0(InvRequestUtils.LocalAndServerRequestImpl<Object> r100) {
        this.f418912a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InvRequestUtils.LocalAndServerRequestImpl<Object> r100 = this.f418912a;     // Catch: Throwable -> L4
        r100.f418900b = false;     // Catch: Throwable -> L4
        r100.f418901c = false;     // Catch: Throwable -> L4
        r100.f418899a.onShowLoading();     // Catch: Throwable -> L4
        InvRequestUtils.LocalAndServerRequestImpl<Object> r101 = this.f418912a;     // Catch: Throwable -> L4
        r101.f418900b = true;     // Catch: Throwable -> L4
        r101.f418899a.a(r101.f418902d);     // Catch: Throwable -> L4
        InvRequestUtils.LocalAndServerRequestImpl<Object> r102 = this.f418912a;     // Catch: Throwable -> L4
        r102.f418899a.e(r102.f418903e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
