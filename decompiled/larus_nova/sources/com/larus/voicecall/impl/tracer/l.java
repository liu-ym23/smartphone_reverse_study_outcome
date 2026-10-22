package com.larus.voicecall.impl.tracer;

/* JADX INFO: loaded from: classes32.dex */
public final class l extends com.larus.audio.call.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f379211g;

    @Override // com.larus.audio.call.p
    public final void c(long r100) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        this.f379211g.r(2, System.currentTimeMillis() - this.f379211g.f379190p, 0, System.currentTimeMillis() - this.f379211g.f379182h, -111);
    }

    public l(j r100) {
        this.f379211g = r100;
        super(5000, 5000);
    }
}
