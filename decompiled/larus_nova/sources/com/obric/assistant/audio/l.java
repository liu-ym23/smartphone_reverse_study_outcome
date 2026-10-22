package com.obric.assistant.audio;

import kotlin.Lazy;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements bha.a {
    public l() {
    }

    @Override // bha.a
    public final void a() {
        Lazy r100 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.f385620d = true;
        Lazy r101 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.c("onRealtimeCallStop");
    }

    @Override // bha.a
    public final void b() {
        Lazy r100 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.f385620d = false;
        Lazy r101 = ObricAudioConnectionStatusMonitor.f385617a;
        ObricAudioConnectionStatusMonitor.d("onRealtimeCallStart");
    }
}
