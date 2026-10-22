package com.larus.voicecall.impl.tracer;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends com.larus.audio.call.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f379208g;

    @Override // com.larus.audio.call.p
    public final void c(long r100) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "Got tts expiration");
        j r100 = this.f379208g;
        long r101 = j.b(r100.f379190p);
        j r102 = this.f379208g;
        r100.r(2, r101, r102.f379191q - r102.f379190p, j.b(r102.f379182h), -111);
    }

    public k(j r100) {
        this.f379208g = r100;
        super(5000, 5000);
    }
}
