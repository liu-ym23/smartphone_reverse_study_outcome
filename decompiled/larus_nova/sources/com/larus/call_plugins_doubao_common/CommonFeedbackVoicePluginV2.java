package com.larus.call_plugins_doubao_common;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.p;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager;
import com.larus.im.service.audio.z0;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import pf9.a0;
import pf9.c0;
import pf9.e0;
import pf9.f0;
import pf9.r;
import pf9.z;

/* JADX INFO: loaded from: classes26.dex */
public class CommonFeedbackVoicePluginV2<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f321344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f321345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f321346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f321347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p f321348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f321349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Job f321350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f321351m;

    public static final class a implements com.larus.audio.call.mgr.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> f321352a;

        public a(CommonFeedbackVoicePluginV2<C> r100) {
            this.f321352a = r100;
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r100, MajorState r101) {
            Intrinsics.checkNotNullParameter(r100, "prev");
            Intrinsics.checkNotNullParameter(r101, "current");
            FLogger.f375446a.i(this.f321352a.T2(), "[onStateChanged] prev:" + r100 + ", current:" + r101);
            this.f321352a.l3(r100, r101);
        }
    }

    public static final class b extends z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f321353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f321354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> f321355c;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f321354b;
        }

        public b(CommonFeedbackVoicePluginV2<C> r100) {
            this.f321355c = r100;
            this.f321354b = r100.T2();
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof z) == false) goto L6;
            this.f321353a = true;
            CommonFeedbackVoicePluginV2<C> r101 = this.f321355c;
            r101.f321349k = ((z) r100).f528980a;
            FLogger.f375446a.i(r101.T2(), "[FlowLLMQueryBeginEvent] try stopVoiceAppease on intent interrupt");
            this.f321355c.r3(null);
            return;
        L6:
            if ((r100 instanceof c0) == false) goto L9;
            this.f321355c.f321351m = false;
            return;
        L9:
            if ((r100 instanceof a0) == false) goto L19;
            if (this.f321353a == false) goto L13;
        L14:
            this.f321353a = false;
            a0 r102 = (a0) r100;
            if (r102.f528884d == false) goto L17;
            this.f321355c.f321351m = false;
        L17:
            FLogger.f375446a.i(this.f321355c.T2(), "[FlowLLMQueryEndEvent] tryTriggerAppeaseTask");
            this.f321355c.s3(r102);
            return;
        L13:
            if (((a0) r100).f528884d == true) goto L14;
            return;
        L19:
            if ((r100 instanceof f0) == false) goto L22;
            this.f321355c.n3((f0) r100);
            return;
        L22:
            if ((r100 instanceof e0) == false) goto L25;
            this.f321355c.m3((e0) r100);
            return;
        L25:
            if ((r100 instanceof r) == false) goto L36;
            int r103 = sf9.b.f541744a;
            if (sf9.b.a(((r) r100).getType()) == false) goto L37;
            this.f321355c.f321351m = false;
            return;
        L37:
            return;
        }
    }

    public static final class c extends p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CommonFeedbackVoicePluginV2<C> f321356g;

        @Override // com.larus.audio.call.p
        public final void c(long r100) {
        }

        @Override // com.larus.audio.call.p
        public final void b() {
            CommonFeedbackVoicePluginV2<C> r100 = this.f321356g;
            r100.f321348j = null;
            if (r100.f321347i == false) goto L6;
            FLogger.f375446a.i(this.f321356g.T2(), "[voiceAppeaseTimer] onFinish cancelled due to shouldCancelAppease");
            return;
        L6:
            CommonFeedbackVoicePluginV2.q3(this.f321356g);
        }

        public c(long r100, CommonFeedbackVoicePluginV2<C> r101) {
            this.f321356g = r101;
            super(r100, r100);
        }
    }

    public void O0() {
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        r3(null);
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        r3(null);
        j3().f();
        IVideoController r100 = j3().d();
        if (r100 == null) goto L6;
        r100.t();
        return;
    }

    public void k3() {
    }

    public void o0() {
    }

    @Override // com.larus.audio.call.arch.a
    public final z0 S2() {
        return new b(this);
    }

    public AudioSoundAppeaseManager j3() {
        return (AudioSoundAppeaseManager) this.f321345g.getValue();
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public final long B2() {
        AudioSoundAppeaseManager r100 = j3();
        if (r100.f321382f == false) goto L7;
        IVideoController r101 = r100.d();
        if (r101 == null) goto L7;
        return r101.getWatchedDuration();
    L7:
        return 0;
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r100 = this.f321350l;
        if (r100 != null) goto L7;
    L8:
        this.f321350l = U2(new CommonFeedbackVoicePluginV2$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r100.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        CoroutineScope r100 = getContext().r();
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new CommonFeedbackVoicePluginV2$onStop$1(this, null), 2, null);
        return;
    }

    @Override // com.larus.call_plugins_doubao_common.k
    public final boolean isPlaying() {
        return j3().f321382f;
    }

    public void o3() {
        IRealtimeCallTracer r100 = getContext().k();
        String r101 = getContext().params().f288745e;
        String r102 = getContext().params().f288755o.f288906h;
        IVoiceCallService r103 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r103 == null) goto L6;
        String r104 = r103.s();
        if (r104 == null) goto L6;
    L7:
        r100.e(r101, r102, r104, this.f321349k);
        return;
    L6:
        r104 = "";
        goto L7
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f321344f;
    }

    public CommonFeedbackVoicePluginV2(C r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f321344f = "CommonFeedbackVoicePluginV2";
        this.f321345g = LazyKt.lazy(new g());
    }

    public static final <C extends com.larus.audio.call.arch.c> void q3(final CommonFeedbackVoicePluginV2<C> r100) {
        FLogger.f375446a.i(r100.T2(), "[startVoiceAppease] .isPlaying() :" + r100.j3().f321382f);
        r100.k3();
        r100.o3();
        r100.f321346h = true;
        com.larus.audio.call.arch.b.e(r100.getContext(), new e(r100));
    }

    public void m1(Function1<? super MajorState, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "stateChecker");
    }

    public void m3(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f321351m == true) goto L6;
        FLogger.f375446a.i(T2(), "[FlowLLMReplyEndEvent] stopVoiceAppease");
        r3(null);
        return;
    }

    public void n3(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (pf9.i.j(r100) == true) goto L5;
        return;
    L5:
        if (this.f321351m == true) goto L9;
        this.f321351m = true;
        FLogger.f375446a.i(T2(), "[FlowLLMReplyUpdateEvent] sentenceUpdate stopVoiceAppease");
        r3(null);
        return;
    }

    public final void r3(Function1<? super Boolean, Unit> r100) {
        FLogger.f375446a.i(T2(), "[stopVoiceAppeaseImmediately] stop");
        this.f321347i = true;
        p r101 = this.f321348j;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        this.f321348j = null;
        j3().h(true, r100);
    }

    public void s3(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (z2.f365865a.getRealCallSoundConfig().f486815c == true) goto L5;
        return;
    L5:
        if (getContext().n().f289045u == true) goto L19;
        Long r101 = Long.valueOf(r100.f528885e);
        if (r101.longValue() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        long r103 = r101.longValue();
    L16:
        p3(r103, new d());
        return;
    L15:
        r103 = 2000;
        goto L16
    L9:
        r102 = false;
        goto L10
    }

    public void c1(boolean r100, Function1<? super Boolean, Unit> r101) {
        AudioSoundAppeaseManager r102 = j3();
        int r103 = AudioSoundAppeaseManager.f321376i;
        r102.h(false, r101);
    }

    public void l3(MajorState r100, MajorState r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        if ((r100 instanceof MajorState.g) == false) goto L5;
        return;
    L5:
        if ((r101 instanceof MajorState.g) == false) goto L9;
        r3(null);
        return;
    }

    public final void p3(long r100, Function1<? super MajorState, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "stateChecker");
        if (this.f321348j == null) goto L6;
        FLogger.f375446a.i(T2(), "startVoiceAppeaseCountdownTimer ignored, timer already running");
        return;
    L6:
        this.f321347i = false;
        if (r100 > 0) goto L10;
        FLogger.f375446a.i(T2(), "startVoiceAppeaseCountdownTimer start directly, waitTime: " + r100);
        q3(this);
        return;
    L10:
        c r102 = new c(r100, this);
        this.f321348j = r102;
        FLogger.f375446a.i(T2(), "startVoiceAppeaseCountdownTimer interval: " + r100);
        r102.d();
    }
}
