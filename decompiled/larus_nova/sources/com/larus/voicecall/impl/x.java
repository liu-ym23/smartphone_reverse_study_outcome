package com.larus.voicecall.impl;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.arch.k0;
import com.larus.audio.call.plugins.CommonVideoAutoTestPlugin;
import com.larus.audio.call.plugins.RealtimeCallConnectTimeoutPlugin;
import com.larus.audio.call.plugins.RealtimeCallSubtitlePlugin;
import com.larus.audio.call.plugins.a1;
import com.larus.audio.call.plugins.k1;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.RealtimeCallAudioPlugin;
import com.larus.voicecall.impl.plugins.RealtimeCallScenePlugin;
import com.larus.voicecall.impl.plugins.RealtimeMediaFocusPlugin;
import com.larus.voicecall.impl.plugins.RealtimeSwitchMicroPlugin;
import com.larus.voicecall.impl.plugins.TtsPlaybackReportPlugin;
import com.larus.voicecall.impl.plugins.b1;
import com.larus.voicecall.impl.plugins.c1;
import com.larus.voicecall.impl.plugins.e2;
import com.larus.voicecall.impl.plugins.f1;
import com.larus.voicecall.impl.plugins.g1;
import com.larus.voicecall.impl.plugins.h1;
import com.larus.voicecall.impl.plugins.j1;
import com.larus.voicecall.impl.plugins.j2;
import com.larus.voicecall.impl.plugins.l1;
import com.larus.voicecall.impl.plugins.r;
import com.larus.voicecall.impl.plugins.y0;
import com.larus.voicecall.impl.tracer.CommonCallSessionMonitor;
import com.larus.voicecall.impl.tracer.RealtimeCallTracer;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes32.dex */
public final class x extends LLMCallController<r> {
    public final v A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f379659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f379660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f379661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RealtimeCallTracer f379662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public q f379663z;

    public final class a extends LLMCallController<r>.a implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f379664b;

        @Override // com.larus.voicecall.impl.plugins.r
        public final q h() {
            return this.f379664b.f379663z;
        }

        public a(x r100) {
            this.f379664b = r100;
            super(r100);
        }
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final com.larus.audio.call.arch.c K() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final Deferred<LLMCallController.b> L() {
        Deferred<LLMCallController.b> r100 = super.L();
        r100.invokeOnCompletion(new w(this));
        return r100;
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final String A() {
        return this.f379661x;
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final IRealtimeCallTracer B() {
        return this.f379662y;
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final CompletableDeferred R(RealtimeCallParam r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        CompletableDeferred r102 = super.R(r100, r101);
        a1 r103 = (a1) x().getContext().c(Reflection.getOrCreateKotlinClass(a1.class), null);
        if (r103 == null) goto L5;
        r103.H0(this.A);
    L5:
        FLogger r104 = FLogger.f375446a;
        String r105 = this.f379661x;
        StringBuilder r106 = new StringBuilder("on start .find plugin=");
        if (r103 == null) goto L8;
        boolean r107 = true;
    L9:
        r106.append(r107);
        r104.i(r105, r106.toString());
        return r102;
    L8:
        r107 = false;
        goto L9
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public final void p(com.larus.audio.call.arch.c r100, k0 r101) {
        r r102 = (r) r100;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "registry");
        if (c78.a.f22657a == false) goto L5;
        r101.a(new com.larus.audio.call.plugins.c(r102));
        r101.a(new CommonVideoAutoTestPlugin(r102));
    L5:
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.F == false) goto L8;
        r101.a(new h1(r102));
    L8:
        r101.a(new com.larus.audio.call.mgr.d(r102));
        r101.a(new RealtimeCallAudioPlugin(r102, this.f289026b.async(), this.f289026b.async()));
        r101.a(new l1(r102));
        r101.a(new CommonCallSessionMonitor(r102));
        r101.a(new c1(r102));
        r101.a(new f1(r102));
        r101.a(new RealtimeCallScenePlugin(r102));
        r101.a(new RealtimeCallSubtitlePlugin(r102));
        r101.a(new com.larus.audio.call.plugins.f1(r102));
        r101.a(new j2(r102));
        z2 r103 = z2.f365865a;
        if (r103.enableMuseumExtensionPack() == false) goto L11;
        r101.a(new e2(r102));
    L11:
        r101.a(new TtsPlaybackReportPlugin(r102));
        r101.a(new k1(r102));
        r101.a(new b1(r102));
        r101.a(new RealtimeSwitchMicroPlugin(r102));
        r101.a(new CommonAppletPlugin(r102));
        r101.a(new com.larus.audio.call.plugins.e(r102, this.f289034j));
        r101.a(new com.larus.audio.call.plugins.h(r102, this.f289026b.a(), this.f289033i));
        r101.a(new com.larus.call_plugins_doubao_common.c(r102));
        r101.a(new g1(r102));
        r101.a(new j1(r102));
        r101.a(new RealtimeMediaFocusPlugin(r102, this.f379659v));
        r101.a(new RealtimeCallConnectTimeoutPlugin(r102, r103.L3()));
        if (r103.enableRealtimeCallDowngrade() == true) goto L14;
        return;
    L14:
        if (this.f379660w == true) goto L18;
        r101.a(new y0(r102));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.voicecall.impl.v] */
    public x(b78.c r100, com.larus.voicecall.impl.tracer.q r101, Function0 r102, boolean r103, boolean r104, y r105) {
        Intrinsics.checkNotNullParameter(r100, "sessionCreator");
        Intrinsics.checkNotNullParameter(r101, "traceSpan");
        Intrinsics.checkNotNullParameter(r102, "lifecycleScope");
        super(r100, r101, r102);
        this.f379659v = r103;
        this.f379660w = r104;
        this.f379661x = "RealtimeCallLLMController";
        int r106 = RealtimeCallTracer.f379042s0;
        Function0 r107 = new u(this);
        Intrinsics.checkNotNullParameter(r107, "callParam");
        this.f379662y = new RealtimeCallTracer(r107);
        r105.invoke(x().getContext(), x());
        this.A = new v(this);
    }
}
