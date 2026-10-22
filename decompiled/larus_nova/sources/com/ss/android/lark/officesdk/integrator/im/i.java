package com.ss.android.lark.officesdk.integrator.im;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.preview.actions.ActionImpl$onActionTriggered$1;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Object> f433276a;

    public i(ActionImpl$onActionTriggered$1 r100) {
        this.f433276a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f433276a.onError(new ErrorResult("IIMApi is unavailable"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
