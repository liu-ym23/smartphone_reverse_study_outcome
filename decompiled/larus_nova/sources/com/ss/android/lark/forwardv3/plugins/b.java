package com.ss.android.lark.forwardv3.plugins;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardAtPlugin f425501a;

    public b(ForwardAtPlugin r100) {
        this.f425501a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KeyboardFunctionEditText r100 = this.f425501a.f425434b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.requestFocus();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
