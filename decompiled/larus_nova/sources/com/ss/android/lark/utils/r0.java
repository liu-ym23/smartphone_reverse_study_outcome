package com.ss.android.lark.utils;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f444752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0.c f444753b;

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f444752a;     // Catch: Throwable -> L4
        s0.a(r100, this.f444753b, ViewUtils.createActionLoadingDialog(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public r0(Context r100, s0.c r101) {
        this.f444752a = r100;
        this.f444753b = r101;
    }
}
