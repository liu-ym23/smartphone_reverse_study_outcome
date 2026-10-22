package com.ss.android.lark.thirdshare.base.export.util;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f441229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f441230b;

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f441229a;     // Catch: Throwable -> L4
        UDToast.show(r100, r100.getString(this.f441230b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(Context r100, int r101) {
        this.f441229a = r100;
        this.f441230b = r101;
    }
}
