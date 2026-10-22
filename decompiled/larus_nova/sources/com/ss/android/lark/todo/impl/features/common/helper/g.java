package com.ss.android.lark.todo.impl.features.common.helper;

import android.content.Context;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f442453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f442454b;

    public g(Context r100, int r101) {
        this.f442453a = r100;
        this.f442454b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OperationToastHelper r100 = OperationToastHelper.f442443a;     // Catch: Throwable -> L4
        LKUIToast.cancelLoading();     // Catch: Throwable -> L4
        UDToast.a r101 = UDToast.build(this.f442453a);     // Catch: Throwable -> L4
        int r102 = this.f442454b;     // Catch: Throwable -> L4
        r101.f285429b.e(r102);     // Catch: Throwable -> L4
        r101.f285429b.f417630d = -1;     // Catch: Throwable -> L4
        r101.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
