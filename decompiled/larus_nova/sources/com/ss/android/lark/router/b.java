package com.ss.android.lark.router;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f439674a;

    public b(Context r100) {
        this.f439674a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.f439674a, R.string.Lark_Legacy_JoinFailed);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
