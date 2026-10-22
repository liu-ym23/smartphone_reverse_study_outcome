package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.lark.pb.basic.v1.Command;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPushTerminated;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import iub.k;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes37.dex */
public final class MmSoftwareCurrentRecordingStateHandler extends f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f434540o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingAudioService f434543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingUploadService f434544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingStatesSyncService f434545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f434546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f434547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f434548i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile MinutesRecordingStartResponse f434549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f434550k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DoubaoBizInfo f434551l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f434552m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f434553n;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $recordingSession;
        int label;
        final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MmSoftwareCurrentRecordingStateHandler f434554a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MmRecordingSession f434555b;

            public a(MmSoftwareCurrentRecordingStateHandler r100, MmRecordingSession r101) {
                this.f434554a = r100;
                this.f434555b = r101;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                MinutesRecordingPushTerminated r102 = (MinutesRecordingPushTerminated) r100;
                lvb.a.e(this.f434554a.f434541b, "pushTerminated, push meetingId: " + r102.session_id + ", current: " + this.f434555b.f434119w.f526982a);
                if (Intrinsics.areEqual(r102.session_id, this.f434555b.f434119w.f526982a) == false) goto L6;
                this.f434555b.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.MEETING_PUSH_TERMINATED));
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(MmSoftwareCurrentRecordingStateHandler r100, MmRecordingSession r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$recordingSession = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$recordingSession, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            d1 r103 = this.this$0.f434542c.Q().b(Command.MINUTES_RECORDING_PUSH_TERMINATED, MinutesRecordingPushTerminated.class);
            a r104 = new a(this.this$0, this.$recordingSession);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class Companion {
        public Companion() {
        }

        public final Object a(Function1<? super Continuation<? super String>, ? extends Object> r100, Function1<? super Throwable, Unit> r101, Continuation<? super String> r102) {
            if ((r102 instanceof MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1) == false) goto L7;
            MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1 r103 = (MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L16;
            if (r107 != 1) goto L15;
            r101 = (Function1) r103.L$0;
            ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
        L20:
            return (String) r105;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r105);
            r103.L$0 = r101;     // Catch: Throwable -> L22
            r103.label = 1;     // Catch: Throwable -> L22
            r105 = r100.invoke(r103);     // Catch: Throwable -> L22
            if (r105 != r106) goto L20;
            return r106;
        L22:
            th = move-exception;
            if ((th instanceof CancellationException) == true) goto L27;
            r101.invoke(th);
            return null;
        L27:
            throw th;
        L7:
            r103 = new MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1(this, r102);
            goto L8
        }
    }

    static {
        f434540o = new Companion();
    }

    public static String f() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isLarkApp() == false) goto L5;
        String r100 = UIHelper.getString(R.string.Lark_Notifications_MinutesRecording_Title);
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        String r101 = UIHelper.getString(R.string.LarkCCM_DoubaoVC_RecordingSummary_Tab);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public MmSoftwareCurrentRecordingStateHandler(final MmRecordingSession r110) {
        Intrinsics.checkNotNullParameter(r110, "recordingSession");
        super(r110);
        this.f434541b = "MmCurrentRecordingHandler";
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100 = r110.f434098b;
        this.f434542c = r100;
        MmRecordingAudioService r101 = r110.a();
        if (r101 == null) goto L39;
        this.f434543d = r101;
        this.f434544e = r110.k();
        this.f434545f = r110.i();
        this.f434546g = LazyKt.lazy(new MmSoftwareCurrentRecordingStateHandler$networkService$2(this));
        this.f434547h = LazyKt.lazy(new MmSoftwareCurrentRecordingStateHandler$meetingCreateFailureHandler$2(this));
        int r102 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.f433800a;
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r103 = r100.getFeatureService();
        k r104 = r110.f434102f;
        DoubaoBizInfo r105 = null;
        if (r104 == null) goto L7;
        MmRecordingSource r106 = r104.f495846a;
    L8:
        Intrinsics.checkNotNullParameter(r103, "featureService");
        if (r106 != null) goto L11;
        int r107 = -1;
    L12:
        boolean r108 = false;
        if (r107 != 1) goto L15;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == true) goto L22;
    L24:
        this.f434552m = r108;
        this.f434553n = new a(new MmSoftwareCurrentRecordingStateHandler$phoneStateHelper$1(this, r110));
        BuildersKt.launch$default(r110.f434118v, null, null, new AnonymousClass1(this, r110, null), 3, null);
        k r111 = this.f434594a.f434102f;
        if (r111 == null) goto L28;
        Map<String, Object> r112 = r111.f495847b;
        if (r112 == null) goto L28;
    L29:
        Object r113 = r112.get("doubao_biz_info");
        if ((r113 instanceof String) == false) goto L32;
        String r114 = (String) r113;
    L33:
        if (r114 != null) goto L35;
        lvb.a.b("MmCurrentRecordingHandler", "buildDoubaoBizInfo, doubaoBizInfoJson is null");
    L36:
        this.f434551l = r105;
        return;
    L35:
        Gson r115 = e0.f444707a;
        r105 = (DoubaoBizInfo) e0.a(r114, DoubaoBizInfo.class);
        lvb.a.e("MmCurrentRecordingHandler", "buildDoubaoBizInfo, " + r105);
        goto L36
    L32:
        r114 = null;
    L28:
        r112 = MapsKt.emptyMap();
        goto L29
    L22:
        if (r103.h(MmOfficeSdkFeature.RecordingStartForegroundService) == false) goto L24;
        r108 = true;
        goto L24
    L15:
        if (r107 == 2) goto L19;
        if (r107 == 3) goto L19;
        r109 = false;
        goto L20
    L11:
        r107 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a.f433801a[r106.ordinal()];
        goto L12
    L7:
        r106 = null;
        goto L8
    L39:
        throw new IllegalStateException("audioService required for software recording session");
    }

    public static final void d(MmSoftwareCurrentRecordingStateHandler r100, String r101) {
        Job r102 = r100.f434548i;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        r100.f434548i = BuildersKt.launch$default(r100.f434594a.f434117u, null, null, new MmSoftwareCurrentRecordingStateHandler$startUpload$1(r100, r101, null), 3, null);
    }

    public static final Object e(MmSoftwareCurrentRecordingStateHandler r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1) == false) goto L7;
        MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1 r102 = (MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1) r101;
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
        int r110 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.f435421n;
        r107.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.j(r109, r108, "record");
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r111 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.f435421n;
        MmRecordingSession r112 = r100.f434594a;
        String r113 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.a(r112.f434097a, r112.f434102f);
        if (r113 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r114 = r100.f434542c.N();
        MmRecordingSession r115 = r100.f434594a;
        r102.L$0 = r113;
        r102.L$1 = r114;
        r102.label = 1;
        Object r116 = r115.r(r102);
        if (r116 == r105) goto L23;
        r108 = r113;
        r104 = r116;
        r107 = r114;
        goto L20
    L23:
        return r105;
    L7:
        r102 = new MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1(r100, r101);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r111) {
        Intrinsics.checkNotNullParameter(r110, "oldState");
        Intrinsics.checkNotNullParameter(r111, "newState");
        lvb.a.e(this.f434541b, "onStateChanged: " + r110 + " -> " + r111);
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C5181c r100 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C5181c.f434646c;
        MmRecordingSource r101 = null;
        if (Intrinsics.areEqual(r111, r100) == false) goto L9;
        if (this.f434552m == false) goto L7;
        String r102 = f();
        String r112 = UIHelper.getString(R.string.View_Doubao_Recording_StartingRecordTranscribe_Desc);
        MinutesForegroundService.ForegroundServiceType r113 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r112, "content");
        Intrinsics.checkNotNullParameter(r113, "foregroundServiceType");
        MinutesForegroundService.Companion r114 = MinutesForegroundService.f434224h;
        MinutesForegroundService.Companion.h(LarkContext.getApplication(), this.f434542c.A(), null, r102, r112, true, 76);
    L7:
        this.f434543d.k();
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.f434655c) == false) goto L11;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmSoftwareCurrentRecordingStateHandler$onStateChanged$1(this, null), 3, null);
        return;
    L11:
        boolean r103 = true;
        boolean r104 = false;
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.f434654c) == false) goto L26;
        this.f434543d.l();
        k r105 = this.f434594a.f434102f;
        if (r105 == null) goto L17;
        r101 = r105.f495846a;
    L17:
        if (r101 == MmRecordingSource.FEISHU) goto L20;
        r103 = false;
    L20:
        if (r103 == false) goto L22;
        this.f434553n.b();
    L22:
        String r106 = f();
        String r107 = UIHelper.getString(R.string.MMWeb_G_Recording);
        MinutesForegroundService.ForegroundServiceType r108 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r106, "title");
        Intrinsics.checkNotNullParameter(r107, "content");
        Intrinsics.checkNotNullParameter(r108, "foregroundServiceType");
        MinutesForegroundService.Companion r109 = MinutesForegroundService.f434224h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r106, r107, this.f434542c.A(), null, 112);
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L70;
        this.f434545f.F(r111);
        return;
    L70:
        return;
    L26:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L29;
        this.f434543d.m();
        String r115 = f();
        String r116 = UIHelper.getString(R.string.MMWeb_G_RecordingPaused);
        MinutesForegroundService.ForegroundServiceType r117 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r115, "title");
        Intrinsics.checkNotNullParameter(r116, "content");
        Intrinsics.checkNotNullParameter(r117, "foregroundServiceType");
        MinutesForegroundService.Companion r118 = MinutesForegroundService.f434224h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r115, r116, this.f434542c.A(), null, 112);
        this.f434545f.F(r111);
        return;
    L29:
        if ((r111 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L44;
        k r119 = this.f434594a.f434102f;
        if (r119 == null) goto L33;
        MmRecordingSource r120 = r119.f495846a;
    L35:
        if (r120 != MmRecordingSource.FEISHU) goto L37;
        r104 = true;
    L37:
        if (r104 == false) goto L39;
        this.f434553n.c();
    L39:
        MmRecordingRepo r121 = this.f434594a.f();
        if (r121 == null) goto L42;
        r121.f();
    L42:
        this.f434543d.h();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareCurrentRecordingStateHandler$leaveMeeting$1(this, null), 3, null);
        CoroutineScopeKt.cancel$default(this.f434594a.f434118v, null, 1, null);
        this.f434545f.F(r111);
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareCurrentRecordingStateHandler$onStateChanged$2(this, null), 3, null);
        return;
    L33:
        r120 = null;
        goto L35
    L44:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.f434652c) == false) goto L58;
        MmRecordingSession r122 = this.f434594a;
        final ovb.b r123 = r122.f434119w;
        if (r122.v() == false) goto L49;
        r103 = this.f434545f.t();
    L52:
        MmSoftwareCurrentRecordingStateHandler$onStateChanged$3 r124 = new MmSoftwareCurrentRecordingStateHandler$onStateChanged$3(this.f434544e);
        Function0<Unit> r125 = new MmSoftwareCurrentRecordingStateHandler$onStateChanged$4(this, r123);
        Intrinsics.checkNotNullParameter(r124, "onReady");
        Intrinsics.checkNotNullParameter(r125, "onRecover");
        if (r103 == false) goto L55;
        r124.invoke();
    L56:
        String r126 = UIHelper.getString(R.string.LarkCCM_DoubaoVC_RecordingSummary_Tab);
        String r127 = UIHelper.getString(R.string.MMWeb_DoubaoVC_GeneratingMinutes_Desc);
        MinutesForegroundService.ForegroundServiceType r128 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r126, "title");
        Intrinsics.checkNotNullParameter(r127, "content");
        Intrinsics.checkNotNullParameter(r128, "foregroundServiceType");
        MinutesForegroundService.Companion r129 = MinutesForegroundService.f434224h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r126, r127, this.f434542c.A(), null, 112);
        return;
    L55:
        r125.invoke();
        goto L56
    L49:
        if (r123.f526985d.length() > 0) goto L52;
        r103 = false;
        goto L52
    L58:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.f434657c) == false) goto L61;
        this.f434544e.k();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareCurrentRecordingStateHandler$onStateChanged$5(this, null), 3, null);
        return;
    L61:
        if ((r111 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L63;
        return;
    L63:
        if (this.f434552m == true) goto L65;
        return;
    L65:
        if (Intrinsics.areEqual(r110, r100) == false) goto L78;
        lvb.a.e(this.f434541b, "recording start failed, stop starting foreground service");
        this.f434542c.A().g();
        return;
    }

    public static final Object c(MmSoftwareCurrentRecordingStateHandler r100, MinutesRecordingStartResponse r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1) == false) goto L7;
        MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1 r103 = (MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L21
        Object r108 = ((Result) r105).m9458unboximpl();     // Catch: Throwable -> L21
    L34:
    L23:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        lvb.a.b(r100.f434541b, "audioService init failed: " + r109);
        r100.f434594a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
        return Boxing.boxBoolean(false);
    L26:
        if (((Boolean) r108).booleanValue() == true) goto L28;
        lvb.a.b(r100.f434541b, "audioService init failed: result is false");
        r100.f434594a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
        return Boxing.boxBoolean(false);
    L28:
        lvb.a.e(r100.f434541b, "audioService init success");
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r110 = r100.f434594a.g();
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.f434655c) == true) goto L31;
        lvb.a.e(r100.f434541b, "skip join room, current state=" + r110);
        return Boxing.boxBoolean(false);
    L31:
        MmRecordingAudioService r111 = r100.f434543d;
        lvb.a.e(r111.f434322e, "[joinChannel] start");
        r111.f434341x.g(r111.f434337t);
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        if (r101 != null) goto L18;
        lvb.a.b(r100.f434541b, "audioService init failed: recording start response is null");
        r100.f434594a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.RTC_INIT_FAILED));
        return Boxing.boxBoolean(false);
    L18:
        MmRecordingAudioService r112 = r100.f434543d;     // Catch: Throwable -> L21
        r103.label = 1;     // Catch: Throwable -> L21
        r108 = r112.f(r101, r103);     // Catch: Throwable -> L21
        if (r108 != r106) goto L34;
        return r106;
    L21:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new MmSoftwareCurrentRecordingStateHandler$initRtcAndJoinRoom$1(r100, r102);
        goto L8
    }
}
