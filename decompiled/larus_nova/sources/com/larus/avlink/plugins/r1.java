package com.larus.avlink.plugins;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class r1 extends com.larus.audio.call.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ o1 f294064g;

    @Override // com.larus.audio.call.p
    public final void c(long r100) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        FLogger.f375446a.i("DoraIsolatedCallQueryMonitor", "Got tts expiration");
        o1 r100 = this.f294064g;
        long r101 = o1.b(r100.f294022n);
        o1 r102 = this.f294064g;
        r100.f(2, r101, r102.f294023o - r102.f294022n, o1.b(r102.f294016h), -111);
    }

    public r1(o1 r100) {
        this.f294064g = r100;
        super(5000, 5000);
    }
}
