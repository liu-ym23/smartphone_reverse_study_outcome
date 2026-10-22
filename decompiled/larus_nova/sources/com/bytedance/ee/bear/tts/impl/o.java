package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements mo5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TtsViewModel f239617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mo5.b f239618b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mo5.b f239619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239620b;

        public a(mo5.b r100, TtsResult r101) {
            this.f239619a = r100;
            this.f239620b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            mo5.b r100 = this.f239619a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f239620b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public o(TtsViewModel r100, po5.b.a r101) {
        this.f239617a = r100;
        this.f239618b = r101;
    }

    @Override // mo5.b
    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        tt5.a.h("TtsViewModel", this.f239617a.f239485d + " selectTone, save to cache, result: " + r100);
        com.bytedance.ee.util.ui.j.c(new a(this.f239618b, r100));
    }
}
