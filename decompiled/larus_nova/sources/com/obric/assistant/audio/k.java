package com.obric.assistant.audio;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements f09.a.b {
    public k() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onAppBackground, canDisconnect()=");
        Lazy r102 = ObricAudioConnectionStatusMonitor.f385617a;
        r101.append(ObricAudioConnectionStatusMonitor.a());
        r101.append(", mode=");
        hm9.s r103 = hm9.j.f485966h;
        r101.append(r103.f485995y);
        r100.i("ObricAudioConnectionStatusMonitor", r101.toString());
        if (ObricAudioConnectionStatusMonitor.a() == true) goto L5;
        return;
    L5:
        if (r103.f485995y != 2) goto L9;
        ObricAudioConnectionStatusMonitor.c("onAppBackground");
        return;
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onAppForeground, mode=");
        hm9.s r102 = hm9.j.f485966h;
        r101.append(r102.f485995y);
        r100.i("ObricAudioConnectionStatusMonitor", r101.toString());
        if (r102.f485995y != 2) goto L6;
        Lazy r103 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.d("onAppForeground");
        return;
    }
}
