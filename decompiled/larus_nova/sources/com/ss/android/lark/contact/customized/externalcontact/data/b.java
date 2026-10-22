package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnterpriseContactsLoader f419126a;

    public b(EnterpriseContactsLoader r100) {
        this.f419126a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EnterpriseContactsLoader r100 = this.f419126a;     // Catch: Throwable -> L4
        r100.f419112e.setValue(new i9b.a.c(r100.f419113f));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
