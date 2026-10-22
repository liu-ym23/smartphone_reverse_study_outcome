package com.ss.android.lark.passport.flow.mfa;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Object> f437923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f437924b;

    public w(IGetDataCallback<Object> r100, Object r101) {
        this.f437923a = r100;
        this.f437924b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f437923a.onSuccess(this.f437924b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
