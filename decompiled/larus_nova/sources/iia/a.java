package iia;

import kotlin.jvm.internal.Intrinsics;
import z2a.g;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends com.larus.audio.call.tracer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.trace.tracespan.span.b f490015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f490017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f490018d;

    /* JADX INFO: renamed from: iia.a$a, reason: collision with other inner class name */
    public static final class C6271a {
    }

    static {
    }

    @Override // com.larus.audio.call.tracer.b
    public final void c() {
        int r100 = g.f569833a;
        g.a(this.f490017c);
    }

    @Override // com.larus.audio.call.tracer.b
    public final String d() {
        return this.f490017c;
    }

    @Override // com.larus.audio.call.tracer.b
    public final String e() {
        return this.f490018d;
    }

    public a(com.larus.trace.tracespan.span.b r100) {
        Intrinsics.checkNotNullParameter(r100, "spanWrap");
        Intrinsics.checkNotNullParameter("obric_cont_talk", "spanScene");
        this.f490015a = r100;
        this.f490016b = "obric_cont_talk";
        this.f490017c = r100.getTraceId();
        this.f490018d = r100.getTag();
    }

    @Override // com.larus.audio.call.tracer.b
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        Intrinsics.checkNotNullParameter(r101, "parentSpanName");
        int r102 = g.f569833a;
        wx9.a r103 = g.d(this.f490017c, r101);
        g.f(this.f490016b, r100, r103);
    }

    @Override // com.larus.audio.call.tracer.b
    public final void a(String r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "spanName");
        int r103 = g.f569833a;
        g.b(this.f490017c, r100, r102, r101);
    }
}
