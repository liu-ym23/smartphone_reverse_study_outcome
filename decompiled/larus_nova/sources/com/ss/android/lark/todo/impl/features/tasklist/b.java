package com.ss.android.lark.todo.impl.features.tasklist;

import com.larus.apm.impl.protector.RunnableProtector;
import com.suite.lark.emm.design.edittext.SCUDEditText;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SCUDEditText f444017a;

    public b(SCUDEditText r100) {
        this.f444017a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SCUDEditText r100 = this.f444017a;     // Catch: Throwable -> L4
        r100.setSelection(r100.length());     // Catch: Throwable -> L4
        this.f444017a.requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
