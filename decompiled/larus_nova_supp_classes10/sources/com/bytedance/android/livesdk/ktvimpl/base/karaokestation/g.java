package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.view.View;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ KSongOrderSongDialog a;

    public g(KSongOrderSongDialog r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KSongOrderSongDialog r0 = this.a;     // Catch: Throwable -> L9
        int r1 = KSongOrderSongDialog.p;     // Catch: Throwable -> L9
        int[] r2 = new int[2];     // Catch: Throwable -> L9
        View r3 = ((BaseKtvDialogFragment) r0).f;     // Catch: Throwable -> L9
        if (r3 == null) goto L5;
        r3.getLocationOnScreen(r2);     // Catch: Throwable -> L9
    L5:
        d r4 = r0.l;     // Catch: Throwable -> L9
        if (r4 == null) goto L12;
        r4.onDialogShow(r2);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
