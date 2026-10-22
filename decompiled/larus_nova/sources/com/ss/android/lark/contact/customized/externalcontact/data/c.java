package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonalContactsLoader f419127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f419128b;

    public c(PersonalContactsLoader r100, String r101) {
        this.f419127a = r100;
        this.f419128b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((HashMap) this.f419127a.f419116f).clear();     // Catch: Throwable -> L4
        this.f419127a.f419115e.setValue(new i9b.a.C6245a(this.f419128b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
