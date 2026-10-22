package com.ss.android.lark.chat.utils;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class i1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f416680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f416681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f416682c;

    @Override // java.lang.Runnable
    public final void run() {
        h7b.i.b(this.f416680a, this.f416681b, this.f416682c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i1(Context r100, String r101) {
        this.f416680a = r100;
        this.f416681b = null;
        this.f416682c = r101;
    }
}
