package com.ss.android.lark.conditional.access.nopermission.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NoPermissionModuleManager f418177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qnc.e f418178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qnc.b f418179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qnc.c.a f418180d;

    public i(NoPermissionModuleManager r100, qnc.e r101, qnc.b r102, qnc.c.a r103) {
        this.f418177a = r100;
        this.f418178b = r101;
        this.f418179c = r102;
        this.f418180d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NoPermissionModuleManager.d(this.f418177a, false, this.f418178b, this.f418179c, this.f418180d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
