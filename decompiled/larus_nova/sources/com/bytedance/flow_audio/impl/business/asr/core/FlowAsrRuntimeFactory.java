package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrAudioUplinkController;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrCallbackDispatcher;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrCompletionTimeoutController;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrFileReplayController;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrRetryAttemptController;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrRuntimeFactory {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f243820h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f243821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.flow_audio.impl.business.asr.o f243822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qw5.a f243823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sw5.a f243824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlowAsrFileAudioDataProvider f243825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dx5.a f243826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zw5.a f243827g;

    public static final class a {
    }

    static {
        f243820h = zw5.b.a("FlowAsrRuntimeFactory");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.bytedance.flow_audio.impl.business.asr.core.q] */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.bytedance.flow_audio.impl.business.asr.core.u] */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.bytedance.flow_audio.impl.business.asr.core.v] */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.bytedance.flow_audio.impl.business.asr.core.w] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.bytedance.flow_audio.impl.business.asr.core.x] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.flow_audio.impl.business.asr.core.k] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.bytedance.flow_audio.impl.business.asr.core.r] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, com.bytedance.flow_audio.impl.business.asr.core.f] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.flow_audio.impl.business.asr.core.j] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.flow_audio.impl.business.asr.core.a0] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.flow_audio.impl.business.asr.core.l] */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.bytedance.flow_audio.impl.business.asr.core.y] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.bytedance.flow_audio.impl.business.asr.core.s] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.flow_audio.impl.business.asr.core.t] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.bytedance.flow_audio.impl.business.asr.core.z] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.flow_audio.impl.business.asr.core.m] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.bytedance.flow_audio.impl.business.asr.core.o] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.bytedance.flow_audio.impl.business.asr.core.n] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.bytedance.flow_audio.impl.business.asr.core.p] */
    public final i a() {
        IKMPLoggerService r100 = lp7.a.f510233a;
        String r101 = f243820h;
        lp7.a.c(r101, this.f243827g.a("create runtime begin"));
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        final ?? r103 = new j(r102);
        ?? r104 = new a0(this, r103);
        String r105 = this.f243827g.f573840a;
        final FlowAsrCallbackDispatcher r106 = new FlowAsrCallbackDispatcher(this.f243822b, this.f243827g);
        final com.bytedance.flow_audio.impl.business.asr.p r107 = new com.bytedance.flow_audio.impl.business.asr.p(this.f243827g, new k(r106));
        com.bytedance.flow_audio.impl.business.asr.r r110 = new com.bytedance.flow_audio.impl.business.asr.r(this.f243823c, this.f243826f, this.f243827g);
        com.bytedance.flow_audio.impl.business.asr.k r111 = new com.bytedance.flow_audio.impl.business.asr.k(new FlowAsrRuntimeFactory$create$recordingStore$1(this));
        com.bytedance.flow_audio.impl.business.asr.m r112 = new com.bytedance.flow_audio.impl.business.asr.m(this.f243823c, this.f243827g);
        com.bytedance.flow_audio.impl.business.asr.j r113 = new com.bytedance.flow_audio.impl.business.asr.j();
        CoroutineScope r114 = this.f243821a;
        FlowAsrRuntimeFactory$create$audioUplinkController$1 r115 = new FlowAsrRuntimeFactory$create$audioUplinkController$1(r107);
        FlowAsrRuntimeFactory$create$audioUplinkController$2 r108 = new FlowAsrRuntimeFactory$create$audioUplinkController$2(r110);
        zw5.a r116 = this.f243827g;
        FlowAsrAudioUplinkController r109 = new FlowAsrAudioUplinkController(r114, r115, r108, new l(this, r107, r103), r116);
        FlowAsrFileReplayController r117 = new FlowAsrFileReplayController(r110, this.f243827g);
        FlowAsrRetryAttemptController r118 = new FlowAsrRetryAttemptController(r110, r109, r117, this.f243827g);
        FlowAsrCompletionTimeoutController r119 = new FlowAsrCompletionTimeoutController(this.f243821a, new m(this), new n(r103), this.f243827g);
        com.bytedance.flow_audio.impl.business.asr.d r120 = new com.bytedance.flow_audio.impl.business.asr.d(r105, this.f243827g);
        com.bytedance.flow_audio.impl.business.asr.f r310 = new com.bytedance.flow_audio.impl.business.asr.f(this.f243824d, this.f243827g, new o(r103), new p(r103), new q(r103), new r(r103));
        c0 r121 = new c0(this.f243823c, r107, r113, new s(this));
        h r122 = new h(r105, new t(this));
        FlowAsrEffectRunnerImpl r123 = new FlowAsrEffectRunnerImpl(r105, this.f243823c, this.f243827g, r107, r106, r110, r310, r109, r112, r118, r117, r120, r119, r111, r113, new u(this), new v(this), new w(this), r104, new x(r106, r102, this));
        f r124 = null;
        FlowAsrEventProcessor r125 = new FlowAsrEventProcessor(r121, r122, r123, this.f243827g, new FlowAsrRuntimeFactory$create$processor$1(this, r107, r123, null));
        r102.element = new f(this.f243821a, r125, new y(this, r107), new z(this, r107));
        lp7.a.c(r101, this.f243827g.a("[create] create runtime success"));
        T r126 = r102.element;
        if (r126 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("eventLoop");
    L7:
        return new i(r124, r107, r106);
    L5:
        r124 = (f) r126;
        goto L7
    }

    public FlowAsrRuntimeFactory(CoroutineScope r100, com.bytedance.flow_audio.impl.business.asr.o r101, qw5.a r102, sw5.a r103, FlowAsrFileAudioDataProvider r104, dx5.a r105, zw5.a r106) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r105, "assistantListener");
        Intrinsics.checkNotNullParameter(r106, "logContext");
        this.f243821a = r100;
        this.f243822b = r101;
        this.f243823c = r102;
        this.f243824d = r103;
        this.f243825e = r104;
        this.f243826f = r105;
        this.f243827g = r106;
    }
}
