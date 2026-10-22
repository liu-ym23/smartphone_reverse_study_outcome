package com.larus.voicecall.impl.plugins;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q1 extends com.larus.audio.call.arch.a<r> implements t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<? extends Map<String, ? extends Object>> f378597f;

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "RealtimeDenoisePlugin";
    }

    @Override // com.larus.voicecall.impl.plugins.t
    public final Function0<Map<String, Object>> X1() {
        return this.f378597f;
    }

    public q1(r r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.larus.voicecall.impl.plugins.t
    public final void F0(com.larus.voicecall.impl.component.denoise.j r100) {
        this.f378597f = r100;
    }
}
