package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427169a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIDragView f427170a;

        public a(CreationAIDragView r100) {
            this.f427170a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CreationAIDragView r100 = this.f427170a;     // Catch: Throwable -> L4
            int r101 = CreationAIDragView.f426912h0;     // Catch: Throwable -> L4
            r100.n();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public o(CreationAIDragView r100) {
        this.f427169a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("CreationAIDragView", "showInternalRunnable() called");     // Catch: Throwable -> L4
        CreationAIDragView.c(this.f427169a);     // Catch: Throwable -> L4
        CreationAIDragView r100 = this.f427169a;     // Catch: Throwable -> L4
        r100.f426918b.post(new a(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
