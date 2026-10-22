package com.larus.audio.call.play;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRealtimeCallTracer f289338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RealtimeCallParam f289339b;

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void a() {
        this.f289338a.O(VideoEventOneOutSync.END_TYPE_FINISH, this.f289339b);
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void c() {
        this.f289338a.c();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onPaused() {
        this.f289338a.n0();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void onResume() {
        this.f289338a.u0();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void b(Map<String, String> r100) {
        this.f289338a.S();
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void d(h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f289338a.d(r100);
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void e(boolean r100) {
        if (r100 == false) goto L5;
        this.f289338a.O("manual_interrupt", this.f289339b);
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void i(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
        this.f289338a.i(r100);
    }

    public i(IRealtimeCallTracer r100, RealtimeCallParam r101) {
        Intrinsics.checkNotNullParameter(r100, "tracer");
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f289338a = r100;
        this.f289339b = r101;
    }
}
