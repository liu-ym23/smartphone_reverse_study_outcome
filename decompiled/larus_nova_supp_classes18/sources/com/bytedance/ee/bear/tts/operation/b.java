package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements mo5.b {
    public final /* synthetic */ com.bytedance.ee.bear.tts.operation.a a;
    public final /* synthetic */ TtsOperationQueue b;

    public static final class a implements Runnable {
        public final /* synthetic */ TtsOperationQueue a;
        public final /* synthetic */ com.bytedance.ee.bear.tts.operation.a b;

        public a(TtsOperationQueue r1, com.bytedance.ee.bear.tts.operation.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TtsOperationQueue r0 = this.a;     // Catch: Throwable -> L4
            com.bytedance.ee.bear.tts.operation.a r1 = this.b;     // Catch: Throwable -> L4
            int r2 = TtsOperationQueue.d;     // Catch: Throwable -> L4
            r0.e(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(com.bytedance.ee.bear.tts.operation.a r1, TtsOperationQueue r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // mo5.b
    public final void a(TtsResult r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        com.bytedance.ee.bear.tts.operation.a r4 = this.a;
        r4.c = null;
        j.f(new a(this.b, r4));
    }
}
