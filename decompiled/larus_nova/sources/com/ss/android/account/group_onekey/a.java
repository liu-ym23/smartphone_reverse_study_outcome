package com.ss.android.account.group_onekey;

import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f406283a;

    public a(String r100) {
        this.f406283a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.f406295e.removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
        String r100 = this.f406283a;     // Catch: Throwable -> L4
        Intent r101 = new Intent();     // Catch: Throwable -> L4
        r101.putExtra("code", -4);     // Catch: Throwable -> L4
        r101.putExtra("message", "time out");     // Catch: Throwable -> L4
        c.a(r100, r101, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
