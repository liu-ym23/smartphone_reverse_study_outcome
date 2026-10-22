package com.bytedance.live.livelink.kmp.impl.core.audio;

import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f255379a;

    public h(f r100) {
        this.f255379a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f255379a;     // Catch: Throwable -> L10
        ILiveWrappedAudio.Companion.getClass();     // Catch: Throwable -> L10
        ILiveWrappedAudio r101 = ILiveWrappedAudio.a.a();     // Catch: Throwable -> L10
        if (r101 == null) goto L5;
        mf2.a r102 = r101.newSAMICore();     // Catch: Throwable -> L10
    L6:
        r100.f255371a = r102;     // Catch: Throwable -> L10
        ILiveWrappedAudio r103 = ILiveWrappedAudio.a.a();     // Catch: Throwable -> L10
        if (r103 == null) goto L13;
        r103.newSAMICoreExecutorContextCreateParameter();     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L5:
        r102 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
