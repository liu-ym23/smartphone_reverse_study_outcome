package com.bytedance.flow_audio.impl.business.asr.viewModel;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.bytedance.flow_audio.api.business.asr.voiceInput.FlowVoiceInputStatus;
import com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneASRReplyEndReason;
import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneBroadcastEventType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes19.dex */
public final class VoiceInputViewModel implements lw5.e, jw5.b, pd6.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f244025m = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f244026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f244027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<String> f244028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.flow_audio.impl.business.asr.viewModel.a f244029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f244030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<? extends lw5.g> f244031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jw5.a f244032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public lw5.d f244033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f244034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public lw5.f f244035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FlowVoiceInputStatus f244036l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244037a = null;

        static {
            int[] r100 = new int[VoiceInputStopReason.values().length];
            r100[VoiceInputStopReason.Normal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[VoiceInputStopReason.Cancel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[VoiceInputStopReason.Interrupt.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[VoiceInputStopReason.FailToStartRecorder.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f244037a = r100;
        }
    }

    static {
    }

    @Override // jw5.b
    public final void P1(jw5.a r100, iw5.f r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "sentence");
    }

    @Override // lw5.e
    public final void C2() {
        h3("cancel voice input: prepareForNextSession=false");
        z0(new VoiceInputViewModel$launchActiveLifecycleEvent$1(this, new VoiceInputViewModel$cancelVoiceInput$1(this, null), null));
    }

    public final boolean m3() {
        h3("start voice input");
        if (this.f244027c == false) goto L6;
        z0(new VoiceInputViewModel$launchActiveLifecycleEvent$1(this, new VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1(this, null, null), null));
        Unit r100 = Unit.INSTANCE;
        return true;
    L6:
        IKMPFlowAudioSceneService r101 = xw5.d.f565229a;
        if (r101 != null) goto L9;
        l3("prepare audio scene ignored: FlowAudioSceneService is null");
    L12:
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return false;
    L16:
        z0(new VoiceInputViewModel$launchActiveLifecycleEvent$1(this, new VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1(this, null, null), null));
        Unit r103 = Unit.INSTANCE;
        return true;
    L9:
        h3("prepare audio scene begin: scene=" + this.f244026b);
        xw5.f r104 = r101.m0(this.f244026b);
        if (r104.f565230a == false) goto L13;
        h3("prepare audio scene success: scene=" + this.f244026b + " hasResource=false");
        goto L12
    L13:
        l3("prepare audio scene failed: scene=" + this.f244026b + " error=" + r104.f565231b);
        r102 = false;
        goto L14
    }

    @Override // lw5.e
    public final void z1() {
        h3("stop voice input");
        z0(new VoiceInputViewModel$launchActiveLifecycleEvent$1(this, new VoiceInputViewModel$stopVoiceInput$1(this, null), null));
    }

    @Override // lw5.e
    public final FlowVoiceInputStatus getVoiceInputStatus() {
        return this.f244036l;
    }

    @Override // jw5.b
    public final void C0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void E2(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidStartRecording$1(this, r100, null));
    }

    public final void H2(String r100) {
        com.bytedance.flow_audio.impl.business.asr.viewModel.a r101 = this.f244029e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "msg");
        pd6.b r102 = pd6.c.f528682a;
        IKMPLoggerService r103 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r103 == null) goto L6;
        r103.logError(r100, r101.f244038a);
        return;
    }

    @Override // jw5.b
    public final void Y1(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidPrepare$1(this, r100, null));
    }

    @Override // jw5.b
    public final void d2(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // jw5.b
    public final void f0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidReceiveEnd$1(this, r100, null));
    }

    @Override // jw5.b
    public final void g0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidStart$1(this, r100, null));
    }

    public final void h3(String r100) {
        com.bytedance.flow_audio.impl.business.asr.viewModel.a r101 = this.f244029e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "msg");
        pd6.b r102 = pd6.c.f528682a;
        IKMPLoggerService r103 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r103 == null) goto L6;
        r103.m1(r100, r101.f244038a);
        return;
    }

    public final void l3(String r100) {
        com.bytedance.flow_audio.impl.business.asr.viewModel.a r101 = this.f244029e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "msg");
        pd6.b r102 = pd6.c.f528682a;
        IKMPLoggerService r103 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r103 == null) goto L6;
        r103.logWarn(r100, r101.f244038a);
        return;
    }

    public final void n3(FlowVoiceInputStatus r100) {
        FlowVoiceInputStatus r101 = this.f244036l;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.f244036l = r100;
        h3("voice input status changed: " + r101 + " -> " + r100);
        Iterator<T> r102 = this.f244031g.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((lw5.g) r102.next()).H();
        goto L7
    }

    public final void z0(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        BuildersKt.launch$default(this.f244030f, null, null, new VoiceInputViewModel$launchLifecycleEvent$1(r100, null), 3, null);
    }

    public static final void k0(VoiceInputViewModel r100, VoiceInputStopReason r101) {
        FlowVoiceInputStatus r102 = r100.f244036l;
        String r103 = "";
        String r104 = null;
        if (r102 != FlowVoiceInputStatus.Started) goto L5;
    L13:
        jw5.a r105 = r100.f244032h;
        StringBuilder r106 = new StringBuilder("stop voice input locked: reason=");
        r106.append(r101);
        r106.append(" taskId=");
        if (r105 == null) goto L16;
        String r107 = r105.getTaskId();
    L17:
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r106.append(r107);
        r100.h3(r106.toString());
        int r108 = b.f244037a[r101.ordinal()];
        if (r108 != 1) goto L22;
        if (r105 == null) goto L36;
        r105.stop();
    L36:
        lw5.d r109 = r100.f244033i;
        if (r109 == null) goto L39;
        r109.cancel();
    L39:
        r100.f244033i = null;
        r100.f244032h = null;
        Intrinsics.checkNotNullParameter(CollectionsKt.emptyList(), "meters");
        Iterator<T> r110 = r100.f244031g.iterator();
    L41:
        if (r110.hasNext() == false) goto L43;
        ((lw5.g) r110.next()).B2();
        goto L41
    L43:
        Iterator<T> r111 = r100.f244031g.iterator();
    L45:
        if (r111.hasNext() == false) goto L47;
        ((lw5.g) r111.next()).S2();
        goto L45
    L47:
        r100.n3(FlowVoiceInputStatus.Idle);
        StringBuilder r112 = new StringBuilder("stop voice input finished: reason=");
        r112.append(r101);
        r112.append(" taskId=");
        if (r105 == null) goto L50;
        r104 = r105.getTaskId();
    L50:
        if (r104 == null) goto L53;
        r103 = r104;
    L53:
        r112.append(r103);
        r100.h3(r112.toString());
        return;
    L22:
        if (r108 != 2) goto L24;
        if (r105 == null) goto L36;
        r105.Q1(FlowAsrCancelReason.USER);
        goto L36
    L24:
        if (r108 != 3) goto L26;
        if (r105 == null) goto L36;
        r105.Q1(FlowAsrCancelReason.UNKNOWN);
        goto L36
    L26:
        if (r108 == 4) goto L36;
        throw new NoWhenBranchMatchedException();
    L16:
        r107 = null;
        goto L17
    L5:
        if (r102 == FlowVoiceInputStatus.Starting) goto L13;
        StringBuilder r113 = new StringBuilder("stop voice input ignored: reason=");
        r113.append(r101);
        r113.append(" status=");
        r113.append(r100.f244036l);
        r113.append(" taskId=");
        jw5.a r114 = r100.f244032h;
        if (r114 == null) goto L9;
        r104 = r114.getTaskId();
    L9:
        if (r104 == null) goto L12;
        r103 = r104;
    L12:
        r113.append(r103);
        r100.h3(r113.toString());
    }

    @Override // jw5.b
    public final void A0(jw5.a r100, FlowAsrCancelReason r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "reason");
        z0(new VoiceInputViewModel$asrSessionDidCancel$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void K1(jw5.a r100, rw5.d r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "data");
        z0(new VoiceInputViewModel$asrSessionDidReceiveAudioData$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void R2(jw5.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidResumeRecording$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void S(jw5.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidFinishRecording$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void T(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidFinish$1(this, r100, r101, null));
    }

    @Override // lw5.e
    public final void V2(boolean r100, boolean r101) {
        z0(new VoiceInputViewModel$setActive$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void b0(jw5.a r100, FlowAsrSessionState r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "state");
        h3("asr state changed: taskId=" + r100.getTaskId() + " state=" + r101);
    }

    @Override // jw5.b
    public final void e0(jw5.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        z0(new VoiceInputViewModel$asrSessionDidPauseRecording$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void f1(jw5.a r100, hw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "error");
        z0(new VoiceInputViewModel$asrSessionDidFail$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void j(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
        z0(new VoiceInputViewModel$asrSessionDidReceiveStreamResult$1(this, r100, r101, null));
    }

    @Override // jw5.b
    public final void q1(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
        z0(new VoiceInputViewModel$asrSessionDidReceiveResult$1(this, r100, r101, null));
    }

    public VoiceInputViewModel(String r100, boolean r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "audioScene");
        this.f244026b = r100;
        this.f244027c = r101;
        this.f244028d = r102;
        this.f244029e = new com.bytedance.flow_audio.impl.business.asr.viewModel.a();
        this.f244030f = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f244031g = CollectionsKt.emptyList();
        this.f244036l = FlowVoiceInputStatus.Idle;
        Intrinsics.checkNotNullParameter(CollectionsKt.emptyList(), "meters");
    }

    public static final void u(VoiceInputViewModel r100, String r101, KMPFlowAudioSceneASRReplyEndReason r110) {
        r100.getClass();
        r100.h3("broadcast asr wait reply end: scene=" + r100.f244026b + " sessionId=" + r101 + " reason=" + r110);
        IKMPFlowAudioSceneService r102 = xw5.d.f565229a;
        if (r102 == null) goto L6;
        r102.s(new xw5.g(KMPFlowAudioSceneBroadcastEventType.ASR_WAIT_REPLY_END, r100.f244026b, r101, r110, 996));
        return;
    }
}
