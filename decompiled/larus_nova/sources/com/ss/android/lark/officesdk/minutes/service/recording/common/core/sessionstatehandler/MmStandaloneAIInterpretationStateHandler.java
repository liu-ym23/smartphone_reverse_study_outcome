package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.q;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStopRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStopResponse;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes37.dex */
public final class MmStandaloneAIInterpretationStateHandler extends f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f434565l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingAudioService f434568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingStatesSyncService f434569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f434570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f434571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f434572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f434573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f434574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a f434575k;

    public static final class a {
        public a() {
        }

        public final Object a(final b1 r100, Continuation r101) {
            if ((r101 instanceof MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1) == false) goto L7;
            MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1 r102 = (MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            String r107 = null;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            ResultKt.throwOnFailure(r104);
        L17:
            MmCreateAudioResponse r108 = (MmCreateAudioResponse) r104;
            if (r108 == null) goto L20;
            r107 = r108.getRecordingId();
        L20:
            if (r107 != null) goto L23;
            return "";
        L23:
            return r107;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            Flow<MmCreateAudioResponse> r109 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$$inlined$map$1(r100);
            MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3 r110 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3(null);
            r102.label = 1;
            r104 = kotlinx.coroutines.flow.e.t(r109, r110, r102);
            if (r104 != r105) goto L17;
            return r105;
        L7:
            r102 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$1(this, r101);
            goto L8
        }
    }

    static {
        f434565l = new a();
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c h() {
        MmStandaloneAIInterpretationRootRepo r100 = this.f434594a.h();
        String r101 = null;
        if (r100 == null) goto L15;
        MmStandaloneAIInterpretationRepo r102 = r100.a();
        if (r102 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r103 = r102.t();
        if (r103 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.b r104 = r103.m();
        if (r104 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r105 = r104.f435124i;
        if (r105 == null) goto L15;
        if ((!StringsKt.isBlank(r105.f435126a)) == false) goto L15;
    L16:
        if (r105 == null) goto L18;
        return r105;
    L18:
        k r106 = this.f434594a.f434102f;
        if (r106 == null) goto L28;
        String r107 = r106.f495850e;
        if (r107 == null) goto L28;
        if ((!StringsKt.isBlank(r107)) == true) goto L26;
        r107 = null;
    L26:
        if (r107 == null) goto L28;
    L37:
        r101 = r107;
    L39:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c(r101, r101);
    L28:
        k r108 = this.f434594a.f434102f;
        if (r108 == null) goto L35;
        String r109 = r108.f495849d;
        if (r109 == null) goto L35;
        if ((!StringsKt.isBlank(r109)) == false) goto L35;
        r101 = r109;
    L35:
        if (r101 != null) goto L39;
        r107 = "en_us";
    L15:
        r105 = null;
        goto L16
    }

    public MmStandaloneAIInterpretationStateHandler(MmRecordingSession r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingSession");
        super(r100);
        this.f434566b = "MmStandaloneAIInterpretationHandler";
        this.f434567c = r100.f434098b;
        MmRecordingAudioService r101 = r100.a();
        if (r101 == null) goto L7;
        this.f434568d = r101;
        this.f434569e = r100.i();
        this.f434570f = LazyKt.lazy(new MmStandaloneAIInterpretationStateHandler$networkService$2(this));
        this.f434571g = LazyKt.lazy(new MmStandaloneAIInterpretationStateHandler$standaloneTracker$2(this));
        this.f434572h = LazyKt.lazy(new MmStandaloneAIInterpretationStateHandler$meetingCreateFailureHandler$2(this));
        this.f434575k = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a(new MmStandaloneAIInterpretationStateHandler$phoneStateHelper$1(this));
        return;
    L7:
        throw new IllegalStateException("audioService required for standalone AI interpretation session");
    }

    public final Object g(Continuation<? super Unit> r100) {
        if ((r100 instanceof MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1 r101 = (MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L23:
        if (Result.m9456isSuccessimpl(r106) == false) goto L25;
        lvb.a.e(this.f434566b, "[leaveMeeting] success " + ((MinutesRecordingStopResponse) r106));
    L25:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L29;
        lvb.a.b(this.f434566b, "[leaveMeeting] failed " + r107);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        String r108 = ((ovb.b) r103).f526982a;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r109 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.f434570f.getValue();
        Command r110 = Command.MINUTES_RECORDING_STOP;
        MinutesRecordingStopRequest r111 = new MinutesRecordingStopRequest.Builder().session_id(r108).build();
        r101.label = 2;
        r106 = r109.b(r110, MinutesRecordingStopResponse.class, r111, r101);
        if (r106 != r104) goto L23;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        MmRecordingSession r112 = this.f434594a;
        r101.label = 1;
        r103 = r112.r(r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new MmStandaloneAIInterpretationStateHandler$leaveMeetingSync$1(this, r100);
        goto L8
    }

    public final void j(String r100) {
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r101 = this.f434567c.N();
        String r102 = this.f434594a.e();
        MmRecordingSession r103 = this.f434594a;
        int r104 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.f435421n;
        r101.k(r103, r103.f434119w.f526987f);
        r101.e(r102);
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r100, r102) == true) goto L15;
        r101.f(r100);
        return;
    L15:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r105 = false;
        goto L9
    }

    public static final Object e(MmStandaloneAIInterpretationStateHandler r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1 r102 = (MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r107 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        MmRecordingCommonParam r109 = ((ovb.b) r104).f526987f;
        r107.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.j(r109, r108, "independent_si");
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r110 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.f435421n;
        MmRecordingSession r111 = r100.f434594a;
        String r112 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.a(r111.f434097a, r111.f434102f);
        if (r112 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r113 = r100.f434567c.N();
        MmRecordingSession r114 = r100.f434594a;
        r102.L$0 = r112;
        r102.L$1 = r113;
        r102.label = 1;
        Object r115 = r114.r(r102);
        if (r115 == r105) goto L23;
        r108 = r112;
        r104 = r115;
        r107 = r113;
        goto L20
    L23:
        return r105;
    L7:
        r102 = new MmStandaloneAIInterpretationStateHandler$trackRecordUploadMinutesCreateStatus$1(r100, r101);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r111) {
        Intrinsics.checkNotNullParameter(r110, "oldState");
        Intrinsics.checkNotNullParameter(r111, "newState");
        String r100 = this.f434566b;
        StringBuilder r101 = new StringBuilder("onStateChanged: ");
        r101.append(r110);
        r101.append(" -> ");
        r101.append(r111);
        r101.append(", recordingId=");
        r101.append(lvb.a.d(this.f434594a.e()));
        r101.append(", source=");
        k r102 = this.f434594a.f434102f;
        MmRecordingSource r103 = null;
        if (r102 == null) goto L5;
        MmRecordingSource r104 = r102.f495846a;
    L6:
        r101.append(r104);
        lvb.a.e(r100, r101.toString());
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C5181c.f434646c) == false) goto L9;
        this.f434568d.k();
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1(this, null), 3, null);
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l r105 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.f434655c;
        if (Intrinsics.areEqual(r111, r105) == false) goto L12;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$1(this, null), 3, null);
        return;
    L12:
        boolean r106 = true;
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.f434654c) == false) goto L31;
        this.f434568d.l();
        this.f434575k.b();
        if (Intrinsics.areEqual(r110, r105) == false) goto L27;
        q r107 = (q) this.f434571g.getValue();
        MmRecordingSession r108 = this.f434594a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        k r109 = r108.f434102f;
        if (r109 == null) goto L20;
        MmRecordingSource r112 = r109.f495846a;
        if (r112 == null) goto L20;
    L22:
        if (r112 == MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L25;
        r106 = false;
    L25:
        if (r106 == false) goto L27;
        r107.b(r108, "start_record");
    L20:
        r112 = r108.j().getSource();
    L27:
        String r113 = UIHelper.getString(R.string.MMWeb_AIInterpret_AILiveTrans_Text);
        MinutesForegroundService.ForegroundServiceType r114 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r113, "title");
        Intrinsics.checkNotNullParameter("", "content");
        Intrinsics.checkNotNullParameter(r114, "foregroundServiceType");
        MinutesForegroundService.Companion r115 = MinutesForegroundService.f434224h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r113, "", this.f434567c.A(), r114, 96);
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L55;
        this.f434569e.F(r111);
        return;
    L55:
        return;
    L31:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L34;
        this.f434568d.m();
        this.f434569e.F(r111);
        return;
    L34:
        if ((r111 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L37;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r116 = h();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$2(this, null), 3, null);
        this.f434575k.c();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretation$1(this, r116, null), 3, null);
        this.f434568d.h();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmStandaloneAIInterpretationStateHandler$leaveMeeting$1(this, null), 3, null);
        CoroutineScopeKt.cancel$default(this.f434594a.f434118v, null, 1, null);
        this.f434569e.F(r111);
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$3(this, null), 3, null);
        return;
    L37:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.f434652c) == false) goto L50;
        k r117 = this.f434594a.f434102f;
        if (r117 == null) goto L42;
        r103 = r117.f495846a;
    L42:
        if (r103 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L44;
        int r118 = R.string.LarkVC_Recording_AiTransRecordGen_Button;
    L45:
        String r119 = UIHelper.getString(r118);
        MinutesForegroundService.ForegroundServiceType r120 = MinutesForegroundService.ForegroundServiceType.DATA_SYNC;
        Intrinsics.checkNotNullParameter(r119, "title");
        Intrinsics.checkNotNullParameter("", "content");
        Intrinsics.checkNotNullParameter(r120, "foregroundServiceType");
        MinutesForegroundService.Companion r121 = MinutesForegroundService.f434224h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r119, "", this.f434567c.A(), r120, 96);
        boolean r122 = this.f434569e.t();
        MmStandaloneAIInterpretationStateHandler$onStateChanged$4 r123 = new MmStandaloneAIInterpretationStateHandler$onStateChanged$4(this.f434594a.k());
        Function0<Unit> r124 = new MmStandaloneAIInterpretationStateHandler$onStateChanged$5(this);
        Intrinsics.checkNotNullParameter(r123, "onReady");
        Intrinsics.checkNotNullParameter(r124, "onRecover");
        if (r122 == false) goto L48;
        r123.invoke();
        return;
    L48:
        r124.invoke();
        return;
    L44:
        r118 = R.string.MMWeb_AIInterpret_AITransRecordGen_Text;
        goto L45
    L50:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.f434657c) == false) goto L61;
        this.f434594a.k().k();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmStandaloneAIInterpretationStateHandler$onStateChanged$6(this, null), 3, null);
        return;
    L61:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final Object i(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1 r101 = (MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        String r105 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        r100 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L32:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g r112 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g) r111;
    L34:
        String r106 = this.f434566b;
        StringBuilder r107 = new StringBuilder("[stopIndependentAIInterpretation] result, status=");
        if (r112 == null) goto L37;
        Integer r108 = Boxing.boxInt(r112.f435146b);
    L38:
        r107.append(r108);
        r107.append(", accepted=");
        if (r112 == null) goto L41;
        Boolean r109 = Boxing.boxBoolean(r112.a());
    L42:
        r107.append(r109);
        r107.append(", channel=");
        if (r112 == null) goto L45;
        r105 = r112.f435145a;
    L45:
        r107.append(r105);
        r107.append(", target=");
        r107.append(r100.f435126a);
        lvb.a.e(r106, r107.toString());
        return Unit.INSTANCE;
    L41:
        r109 = null;
        goto L42
    L37:
        r108 = null;
        goto L38
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L19:
        String r113 = ((ovb.b) r111).f526982a;
        if (StringsKt.isBlank(r113) == false) goto L23;
        lvb.a.h(this.f434566b, "[stopIndependentAIInterpretation] skip, meetingId is blank");
        return Unit.INSTANCE;
    L23:
        lvb.a.e(this.f434566b, "[stopIndependentAIInterpretation] start, meetingId=" + lvb.a.d(r113) + ", target=" + r100.f435126a);
        MmStandaloneAIInterpretationRootRepo r114 = this.f434594a.h();
        if (r114 == null) goto L33;
        MmStandaloneAIInterpretationRepo r115 = r114.a();
        if (r115 == null) goto L33;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r116 = r115.t();
        if (r116 == null) goto L33;
        r101.L$0 = r100;
        r101.label = 2;
        r111 = r116.f0(r113, r100, r101);
        if (r111 != r103) goto L32;
        return r103;
    L33:
        r112 = null;
        goto L34
    L16:
        ResultKt.throwOnFailure(r111);
        MmRecordingSession r117 = this.f434594a;
        r101.L$0 = r100;
        r101.label = 1;
        r111 = r117.r(r101);
        if (r111 != r103) goto L19;
        return r103;
    L7:
        r101 = new MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1(this, r110);
        goto L8
    }

    public static final Object c(MmStandaloneAIInterpretationStateHandler r100, MinutesRecordingStartResponse r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1 r103 = (MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L16;
        if (r107 != 3) goto L15;
        ResultKt.throwOnFailure(r105);
    L46:
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
    L45:
        return Boxing.boxBoolean(false);
    L17:
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L21:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L28;
        lvb.a.b(r100.f434566b, "audioService init failed: " + r109);
        TerminateReason r110 = TerminateReason.RTC_INIT_FAILED;
        r103.label = 2;
        if (r100.f(r110, true, r103) != r106) goto L45;
        return r106;
    L28:
        if (Result.m9455isFailureimpl(r108) == false) goto L31;
        r108 = null;
    L31:
        if (Intrinsics.areEqual(r108, Boxing.boxBoolean(true)) == true) goto L36;
        lvb.a.b(r100.f434566b, "[initRtcAndStartJoinRoom] audioService init returned false");
        TerminateReason r111 = TerminateReason.RTC_INIT_FAILED;
        r103.label = 3;
        if (r100.f(r111, true, r103) != r106) goto L46;
        return r106;
    L36:
        MmStandaloneAIInterpretationRootRepo r112 = r100.f434594a.h();
        if (r112 == null) goto L43;
        MmStandaloneAIInterpretationRepo r113 = r112.a();
        if (r113 == null) goto L43;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r114 = r113.t();
        if (r114 == null) goto L43;
        r114.J0();
    L43:
        MmRecordingAudioService r115 = r100.f434568d;
        lvb.a.e(r115.f434322e, "[joinChannel] start");
        r115.f434341x.g(r115.f434337t);
        return Boxing.boxBoolean(true);
    L18:
        ResultKt.throwOnFailure(r105);
        MmRecordingAudioService r116 = r100.f434568d;
        r103.label = 1;
        r108 = r116.f(r101, r103);
        if (r108 != r106) goto L21;
        return r106;
    L7:
        r103 = new MmStandaloneAIInterpretationStateHandler$initRtcAndStartJoinRoom$1(r100, r102);
        goto L8
    }

    public static final Object d(MmStandaloneAIInterpretationStateHandler r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1 r103 = (MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        String r109 = null;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L23:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g r110 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.g) r105;
    L25:
        String r111 = r100.f434566b;
        StringBuilder r112 = new StringBuilder("[startIndependentAIInterpretation] result, status=");
        if (r110 == null) goto L28;
        Integer r113 = Boxing.boxInt(r110.f435146b);
    L29:
        r112.append(r113);
        r112.append(", accepted=");
        if (r110 == null) goto L32;
        Boolean r114 = Boxing.boxBoolean(r110.a());
    L33:
        r112.append(r114);
        r112.append(", channel=");
        if (r110 == null) goto L36;
        String r115 = r110.f435145a;
    L37:
        r112.append(r115);
        r112.append(", target=");
        if (r110 == null) goto L42;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r116 = r110.f435152h;
        if (r116 == null) goto L42;
        r109 = r116.f435126a;
    L42:
        r112.append(r109);
        lvb.a.e(r111, r112.toString());
        if (r110 != null) goto L45;
    L47:
        boolean r117 = false;
    L48:
        if (r117 == true) goto L58;
        if (r110 != null) goto L51;
    L53:
        boolean r118 = false;
    L54:
        if (r118 == true) goto L58;
        r108 = false;
        goto L58
    L51:
        if (r110.f435146b != 2) goto L53;
        r118 = true;
    L58:
        return Boxing.boxBoolean(r108);
    L45:
        if (r110.f435146b != 1) goto L47;
        r117 = true;
        goto L48
    L36:
        r115 = null;
        goto L37
    L32:
        r114 = null;
        goto L33
    L28:
        r113 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        lvb.a.e(r100.f434566b, "[startIndependentAIInterpretation] start, meetingId=" + lvb.a.d(r101));
        MmStandaloneAIInterpretationRootRepo r119 = r100.f434594a.h();
        if (r119 == null) goto L24;
        MmStandaloneAIInterpretationRepo r120 = r119.a();
        if (r120 == null) goto L24;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r121 = r120.t();
        if (r121 == null) goto L24;
        r103.label = 1;
        r105 = r121.c0(r101, null, r103);
        if (r105 != r106) goto L23;
        return r106;
    L24:
        r110 = null;
    L7:
        r103 = new MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1(r100, r102);
        goto L8
    }

    public final Object f(TerminateReason r100, boolean r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1) == false) goto L7;
        MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1 r103 = (MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        r100 = (TerminateReason) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        this.f434594a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(r100));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (TerminateReason) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L21:
        this.f434568d.h();
        r103.L$0 = r100;
        r103.label = 2;
        if (g(r103) != r106) goto L24;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        if (r101 == false) goto L21;
        r103.L$0 = r100;
        r103.label = 1;
        if (i(h(), r103) != r106) goto L21;
        return r106;
    L7:
        r103 = new MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1(this, r102);
        goto L8
    }
}
