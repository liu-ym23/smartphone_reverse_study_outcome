package com.ss.android.lark.edit.keyboard.producer;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f420605a;

    public c(b r100) {
        this.f420605a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f420605a;     // Catch: Throwable -> L6
        BaseKeyboardHeightProducer.b r101 = r100.f420600k;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        Log.i("InsetsKBH#Producer", "notify keyboardChanged " + r100.f420600k);     // Catch: Throwable -> L6
        r100.f420595f.a(r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
