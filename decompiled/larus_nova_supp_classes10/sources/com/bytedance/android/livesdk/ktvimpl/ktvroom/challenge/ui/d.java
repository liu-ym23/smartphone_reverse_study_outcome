package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ KtvComponentChallengeResultView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public d(KtvComponentChallengeResultView r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvComponentChallengeResultView r0 = this.a;     // Catch: Throwable -> L4
        int r1 = this.b;     // Catch: Throwable -> L4
        int r2 = this.c;     // Catch: Throwable -> L4
        int r3 = this.d;     // Catch: Throwable -> L4
        int r4 = KtvComponentChallengeResultView.g;     // Catch: Throwable -> L4
        r0.R5(r1, r2, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
