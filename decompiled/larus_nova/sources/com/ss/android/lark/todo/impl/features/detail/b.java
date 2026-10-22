package com.ss.android.lark.todo.impl.features.detail;

import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f442824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f442825b;

    public b(Context r100, Intent r101) {
        this.f442824a = r100;
        this.f442825b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f442824a.startActivity(this.f442825b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
