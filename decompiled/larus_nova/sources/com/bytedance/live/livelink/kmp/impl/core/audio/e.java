package com.bytedance.live.livelink.kmp.impl.core.audio;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f255370a;

    public e(d r100) {
        this.f255370a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ui6.d r100 = this.f255370a.f255368d.l();     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        mi6.a r101 = r100.b();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.Q(LiveWrappedAudioRoute.AUDIO_ROUTE_EARPIECE);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
