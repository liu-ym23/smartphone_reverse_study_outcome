package com.bytedance.sdk.account.impl;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f269098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f269099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f269100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f269101d;

    @Override // java.lang.Runnable
    public final void run() {
        j.h(this.f269101d, this.f269098a, this.f269099b, this.f269100c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(j r100, String r101, int r102) {
        this.f269101d = r100;
        this.f269098a = r101;
        this.f269099b = r102;
        this.f269100c = false;
    }
}
