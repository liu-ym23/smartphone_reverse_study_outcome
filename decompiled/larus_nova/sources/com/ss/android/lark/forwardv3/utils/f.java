package com.ss.android.lark.forwardv3.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyboardFunctionEditText f425575a;

    public f(KeyboardFunctionEditText r100) {
        this.f425575a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f425575a.requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
