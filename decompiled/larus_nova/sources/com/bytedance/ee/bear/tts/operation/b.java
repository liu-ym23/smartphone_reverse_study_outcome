package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements mo5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.tts.operation.a f239741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TtsOperationQueue f239742b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsOperationQueue f239743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.tts.operation.a f239744b;

        public a(TtsOperationQueue r100, com.bytedance.ee.bear.tts.operation.a r101) {
            this.f239743a = r100;
            this.f239744b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TtsOperationQueue r100 = this.f239743a;     // Catch: Throwable -> L4
            com.bytedance.ee.bear.tts.operation.a r101 = this.f239744b;     // Catch: Throwable -> L4
            int r102 = TtsOperationQueue.f239730d;     // Catch: Throwable -> L4
            r100.e(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(com.bytedance.ee.bear.tts.operation.a r100, TtsOperationQueue r101) {
        this.f239741a = r100;
        this.f239742b = r101;
    }

    @Override // mo5.b
    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.ee.bear.tts.operation.a r101 = this.f239741a;
        r101.f239740c = null;
        j.f(new a(this.f239742b, r101));
    }
}
