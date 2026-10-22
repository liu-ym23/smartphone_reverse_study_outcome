package com.bytedance.android.livesdk.livecommerce.playback.card;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ ExplainPlaybackCardPresenter a;

    public h(ExplainPlaybackCardPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExplainPlaybackCardPresenter r0 = this.a;     // Catch: Throwable -> L6
        if (r0.t == true) goto L9;
        ExplainPlaybackCardPresenter.d0(r0, false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
