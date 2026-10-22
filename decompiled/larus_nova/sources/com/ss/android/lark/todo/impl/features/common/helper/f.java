package com.ss.android.lark.todo.impl.features.common.helper;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDToast.a f442452a;

    public f(UDToast.a r100) {
        this.f442452a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f442452a.a().show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
