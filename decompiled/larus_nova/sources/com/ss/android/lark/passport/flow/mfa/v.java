package com.ss.android.lark.passport.flow.mfa;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Object> f437921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ErrorResult f437922b;

    public v(IGetDataCallback<Object> r100, ErrorResult r101) {
        this.f437921a = r100;
        this.f437922b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f437921a.onError(this.f437922b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
