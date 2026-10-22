package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q extends com.larus.audio.call.tracer.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f379224d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f379225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f379226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f379227c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.tracer.b
    public final void c() {
        int r100 = z2a.g.f569833a;
        z2a.g.a(this.f379226b);
    }

    @Override // com.larus.audio.call.tracer.b
    public final String d() {
        return this.f379226b;
    }

    @Override // com.larus.audio.call.tracer.b
    public final String e() {
        return this.f379227c;
    }

    public q(com.larus.trace.tracespan.span.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spanWrap");
        Intrinsics.checkNotNullParameter(r101, "spanScene");
        this.f379225a = r101;
        this.f379226b = r100.getTraceId();
        this.f379227c = r100.getTag();
    }

    @Override // com.larus.audio.call.tracer.b
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        Intrinsics.checkNotNullParameter(r101, "parentSpanName");
        int r102 = z2a.g.f569833a;
        wx9.a r103 = z2a.g.d(this.f379226b, r101);
        z2a.g.f(this.f379225a, r100, r103);
    }

    @Override // com.larus.audio.call.tracer.b
    public final void a(String r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        int r103 = z2a.g.f569833a;
        z2a.g.b(this.f379226b, r100, r102, r101);
    }
}
