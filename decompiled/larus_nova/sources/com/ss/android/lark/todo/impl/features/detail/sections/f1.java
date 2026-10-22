package com.ss.android.lark.todo.impl.features.detail.sections;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummarySection f443358a;

    public f1(SummarySection r100) {
        this.f443358a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r100 = this.f443358a.f443273j;     // Catch: Throwable -> L4
        r100.setSelection(r100.getText().length());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
