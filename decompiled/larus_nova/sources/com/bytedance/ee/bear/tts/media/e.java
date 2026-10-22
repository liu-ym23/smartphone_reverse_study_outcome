package com.bytedance.ee.bear.tts.media;

import android.app.Application;
import android.content.Intent;
import android.content.ServiceConnection;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239724a;

    public e(b r100) {
        this.f239724a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Application r100 = LarkContext.getApplication();     // Catch: Throwable -> L4
        r100.bindService(new Intent(r100, TtsMediaService.class), (ServiceConnection) this.f239724a.f239706i.getValue(), 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
