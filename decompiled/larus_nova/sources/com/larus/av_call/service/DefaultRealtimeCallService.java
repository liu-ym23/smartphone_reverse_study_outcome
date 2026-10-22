package com.larus.av_call.service;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.plugins.t0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import t1a.c;

/* JADX INFO: loaded from: classes24.dex */
public final class DefaultRealtimeCallService extends com.larus.audio.call.a implements c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f290565s = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.a
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tosKey");
    }

    @Override // com.larus.audio.call.a
    public final void b() {
        throw null;
    }

    @Override // com.larus.audio.call.a
    public final void a(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        FLogger.f375446a.i("RealtimeCallService", "interruptAsr");
        LLMCallController.w(null, Reflection.getOrCreateKotlinClass(t0.class));
        throw null;
    }

    @Override // com.larus.audio.call.a
    public final void d(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "params");
        LLMCallController.S(null, r100);
        throw null;
    }

    @Override // com.larus.audio.call.a
    public final void e(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "params");
        throw null;
    }
}
