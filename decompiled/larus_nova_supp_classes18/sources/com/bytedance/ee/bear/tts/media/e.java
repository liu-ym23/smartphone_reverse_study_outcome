package com.bytedance.ee.bear.tts.media;

import android.app.Application;
import android.content.Intent;
import android.content.ServiceConnection;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Application r0 = LarkContext.getApplication();     // Catch: Throwable -> L4
        r0.bindService(new Intent(r0, TtsMediaService.class), (ServiceConnection) this.a.i.getValue(), 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
