package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements mo5.b {
    public final /* synthetic */ TtsViewModel a;
    public final /* synthetic */ mo5.b b;

    public static final class a implements Runnable {
        public final /* synthetic */ mo5.b a;
        public final /* synthetic */ TtsResult b;

        public a(mo5.b r1, TtsResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            mo5.b r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public o(TtsViewModel r1, po5.b.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // mo5.b
    public final void a(TtsResult r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        tt5.a.h("TtsViewModel", this.a.d + " selectTone, save to cache, result: " + r3);
        com.bytedance.ee.util.ui.j.c(new a(this.b, r3));
    }
}
