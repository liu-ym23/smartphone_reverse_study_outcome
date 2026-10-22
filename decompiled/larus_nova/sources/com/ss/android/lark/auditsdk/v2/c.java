package com.ss.android.lark.auditsdk.v2;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f409625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f409626b;

    public c(Context r100, int r101) {
        this.f409625a = r100;
        this.f409626b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.f409625a, this.f409626b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
