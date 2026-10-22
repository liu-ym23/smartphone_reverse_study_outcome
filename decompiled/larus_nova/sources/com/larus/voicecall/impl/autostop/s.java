package com.larus.voicecall.impl.autostop;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class s extends com.larus.audio.call.tracer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.trace.tracespan.span.b f377177a;

    @Override // com.larus.audio.call.tracer.b
    public final void c() {
        com.larus.trace.tracespan.span.b r100 = this.f377177a;
        if (r100 == null) goto L5;
        int r101 = z2a.g.f569833a;
        z2a.g.a(r100.getTraceId());
    L5:
        this.f377177a = null;
    }

    @Override // com.larus.audio.call.tracer.b
    public final String d() {
        com.larus.trace.tracespan.span.b r100 = this.f377177a;
        if (r100 == null) goto L5;
        String r101 = r100.getTraceId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.audio.call.tracer.b
    public final String e() {
        com.larus.trace.tracespan.span.b r100 = this.f377177a;
        if (r100 == null) goto L5;
        String r101 = r100.getTag();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public s() {
    }

    @Override // com.larus.audio.call.tracer.b
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        Intrinsics.checkNotNullParameter(r101, "parentSpanName");
        if (this.f377177a != null) goto L5;
        return;
    L5:
        int r102 = z2a.g.f569833a;
        z2a.g.f("voice_call", r100, z2a.g.d(d(), r101));
    }

    @Override // com.larus.audio.call.tracer.b
    public final void a(String r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        if (this.f377177a != null) goto L5;
        return;
    L5:
        int r103 = z2a.g.f569833a;
        z2a.g.b(d(), r100, r102, r101);
    }
}
