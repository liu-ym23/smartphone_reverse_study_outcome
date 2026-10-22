package com.ss.android.lark.inline.ai.ui.richtext;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f427646a = null;

    static {
        f427646a = new h();
    }

    public h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("RichtextPreviewBridge", "mOvertimeRunnable");     // Catch: Throwable -> L4
        int r100 = zlb.a.f572823d;     // Catch: Throwable -> L4
        zlb.a.C8475a.e(405, "overtime", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
