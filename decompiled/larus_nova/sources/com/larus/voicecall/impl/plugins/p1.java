package com.larus.voicecall.impl.plugins;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes32.dex */
public final class p1 extends com.larus.audio.call.arch.a<r> implements p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f378595f;

    @Override // com.larus.voicecall.impl.plugins.p
    public final void b0() {
        com.larus.audio.call.plugins.t0 r100 = (com.larus.audio.call.plugins.t0) getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r100 == null) goto L6;
        r100.b0();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.p
    public final void f0() {
        com.larus.audio.call.plugins.t0 r100 = (com.larus.audio.call.plugins.t0) getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r100 == null) goto L6;
        r100.f0();
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f378595f;
    }

    public p1(r r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f378595f = "RealtimeContinuousTalkPlugin";
    }
}
