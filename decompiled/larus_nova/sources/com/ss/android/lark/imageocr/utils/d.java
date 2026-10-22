package com.ss.android.lark.imageocr.utils;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ llb.b f426578a;

    public d(llb.b r100) {
        this.f426578a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f426578a.onError(new ErrorResult("bitmap is exception"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
