package com.ss.android.lark.inline.ai.creationai.editor;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inline.ai.creationai.d0;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f427087a = null;

    static {
        f427087a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("CreationAIEditorBridge", "mOvertimeRunnable");     // Catch: Throwable -> L4
        int r100 = d0.f427056b;     // Catch: Throwable -> L4
        d0.a.a(405, "overtime", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
