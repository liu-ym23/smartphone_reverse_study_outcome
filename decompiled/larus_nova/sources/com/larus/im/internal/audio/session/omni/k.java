package com.larus.im.internal.audio.session.omni;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes29.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidOmniAudioEngine f347317a;

    public k(AndroidOmniAudioEngine r100) {
        this.f347317a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f347317a.c("onAudioRouteDevicesChanged");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
