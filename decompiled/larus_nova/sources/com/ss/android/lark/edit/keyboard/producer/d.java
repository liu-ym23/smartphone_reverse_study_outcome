package com.ss.android.lark.edit.keyboard.producer;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f420606a;

    public d(b r100) {
        this.f420606a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f420606a.f420598i = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
