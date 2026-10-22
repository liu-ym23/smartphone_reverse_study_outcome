package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnterpriseContactsLoader f419124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f419125b;

    public a(EnterpriseContactsLoader r100) {
        this.f419124a = r100;
        this.f419125b = "";
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f419124a.f419112e.setValue(new i9b.a.C6245a(this.f419125b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
