package com.ss.android.lark.videosend.checker.raw;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPreCheckRawService.a f444879a;

    public d(VideoPreCheckRawService.a r100) {
        this.f444879a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreCheckRawService.a r100 = this.f444879a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onFinish();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
