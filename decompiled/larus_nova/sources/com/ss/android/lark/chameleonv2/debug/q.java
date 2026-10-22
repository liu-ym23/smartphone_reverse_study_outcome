package com.ss.android.lark.chameleonv2.debug;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.s;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f411413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f411414b;

    public q(Context r100, String r101) {
        this.f411413a = r100;
        this.f411414b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = s.f437234a;     // Catch: Throwable -> L4
        s.a.a(this.f411413a, this.f411414b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
