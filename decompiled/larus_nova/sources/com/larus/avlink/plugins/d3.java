package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d3 extends com.larus.audio.call.arch.a<n4> implements com.larus.audio.call.arch.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f293878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c3 f293879g;

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        Map<Function1<Boolean, Unit>, k4> r100 = x2.f294117a;
        c3 r101 = this.f293879g;
        Intrinsics.checkNotNullParameter(r101, "callback");
        w2 r102 = new w2(r101);
        x2.f294117a.put(r101, r102);
        IDoraService r103 = x2.c();
        if (r103 == null) goto L8;
        SessionService r104 = r103.d();
        if (r104 == null) goto L9;
        r104.i(r102);
        return;
    L9:
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        Map<Function1<Boolean, Unit>, k4> r100 = x2.f294117a;
        c3 r101 = this.f293879g;
        Intrinsics.checkNotNullParameter(r101, "callback");
        k4 r102 = x2.f294117a.remove(r101);
        if (r102 == null) goto L10;
        IDoraService r103 = x2.c();
        if (r103 == null) goto L11;
        SessionService r104 = r103.d();
        if (r104 == null) goto L12;
        r104.x(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f293878f;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.plugins.c3] */
    public d3(final n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f293878f = "DoraSpanTracePlugin";
        this.f293879g = new c3(r100);
    }
}
