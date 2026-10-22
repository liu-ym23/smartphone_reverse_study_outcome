package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f442091a;

    public s(View r100) {
        this.f442091a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larksuite.framework.section.utils.a.d(this.f442091a.findViewById(R.id.task_options_container), true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
