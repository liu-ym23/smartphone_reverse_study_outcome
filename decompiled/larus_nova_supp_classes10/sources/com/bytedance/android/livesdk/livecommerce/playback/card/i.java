package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ ExplainPlaybackCardPresenter a;

    public i(ExplainPlaybackCardPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExplainPlaybackCardPresenter r0 = this.a;     // Catch: Throwable -> L6
        FrameLayout r1 = r0.h;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r0.l = (r1.getWidth() - r1.getPaddingLeft()) - r1.getPaddingRight();     // Catch: Throwable -> L6
        ExplainPlaybackCardPresenter r2 = this.a;     // Catch: Throwable -> L6
        r2.m = (r1.getHeight() - r1.getPaddingTop()) - r1.getPaddingBottom();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
