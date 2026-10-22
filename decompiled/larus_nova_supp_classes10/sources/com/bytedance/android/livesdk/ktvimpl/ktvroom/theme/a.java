package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Runnable {
    public final /* synthetic */ KtvThemeControl a;

    public a(KtvThemeControl r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvThemeControl.a(this.a);     // Catch: Throwable -> L4
        ALogger.i("alog_ktv_smooth_enter_room", "removeFeedMockView ;; ktv bg visible time out");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
