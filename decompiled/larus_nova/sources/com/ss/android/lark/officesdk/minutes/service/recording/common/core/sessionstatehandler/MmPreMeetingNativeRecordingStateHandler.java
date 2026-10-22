package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingAudioCaptureMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.vfs.VFSFile;
import iub.j;
import iub.k;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class MmPreMeetingNativeRecordingStateHandler extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f434512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingAudioService f434515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingUploadService f434516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmRecordingStatesSyncService f434517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f434518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f434519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f434520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f434521k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f434522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public iub.a<j, ? super MmRecordingError> f434523m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f434524n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f434525o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f434526p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f434527q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f434528r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DoubaoBizInfo f434529s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public MinutesRecordingStartResponse f434530t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f434531u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f434532v;

    public final void j() {
        if (this.f434522l == false) goto L6;
        lvb.a.e(this.f434513c, "[createMeetingAsync] ignored, already creating");
        return;
    L6:
        this.f434527q = true;
        this.f434522l = true;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1(this, null), 3, null);
    }

    public final void l() {
        Job r100 = this.f434521k;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        lvb.a.e(this.f434513c, "[registerTerminatedPushIfNeeded] already registered");
        return;
    L10:
        this.f434521k = BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$registerTerminatedPushIfNeeded$1(this, null), 3, null);
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void n() {
        ovb.b r100 = this.f434594a.f434119w;
        String r101 = r100.f526988g;
        if (StringsKt.isBlank(r101) == false) goto L6;
        lvb.a.h(this.f434513c, "[offlineIndex] skip, sessionKey is blank");
        return;
    L6:
        Long r102 = Long.valueOf(r100.f526983b);
        if (r102.longValue() <= 0) goto L9;
        boolean r103 = true;
    L10:
        String r104 = null;
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L16;
        long r105 = r102.longValue();
    L17:
        k r106 = this.f434594a.f434102f;
        if (r106 == null) goto L28;
        Map<String, Object> r107 = r106.f495847b;
        if (r107 == null) goto L28;
        Object r108 = r107.get("hardware_device_id");
        if (r108 == null) goto L28;
        String r109 = r108.toString();
        if (r109 == null) goto L28;
        if ((!StringsKt.isBlank(r109)) == false) goto L28;
        r104 = r109;
    L28:
        if (r104 != null) goto L30;
        r104 = "";
    L30:
        this.f434517g.w(r101, r105, r104);
        k r110 = this.f434594a.f434102f;
        if (r110 == null) goto L36;
        MmRecordingSource r111 = r110.f495846a;
        if (r111 == null) goto L37;
        this.f434517g.A(r101, r111);
        return;
    L37:
        return;
    L36:
        return;
    L16:
        r105 = System.currentTimeMillis();
        goto L17
    L9:
        r103 = false;
        goto L10
    }

    public MmPreMeetingNativeRecordingStateHandler(MmRecordingSession r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingSession");
        super(r100);
        this.f434512b = true;
        this.f434513c = "MmPreMeetingNativeHandler";
        this.f434514d = r100.f434098b;
        this.f434515e = r100.a();
        this.f434516f = r100.k();
        this.f434517g = r100.i();
        this.f434518h = LazyKt.lazy(new MmPreMeetingNativeRecordingStateHandler$networkService$2(this));
        this.f434519i = LazyKt.lazy(new MmPreMeetingNativeRecordingStateHandler$onlinePreChecker$2(this));
        k r101 = r100.f434102f;
        DoubaoBizInfo r102 = null;
        if (r101 == null) goto L5;
        MmRecordingCreateMode r103 = r101.f495851f;
    L7:
        if (r103 != MmRecordingCreateMode.OFFLINE_LOCAL) goto L9;
        boolean r104 = true;
    L10:
        this.f434531u = r104;
        if (r104 == true) goto L16;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a() == false) goto L16;
        this.f434531u = true;
        lvb.a.h("MmPreMeetingNativeHandler", "[offlineMode] enabled_by_fallback reason=no_network_at_init");
    L19:
        if (this.f434531u == true) goto L21;
        l();
    L21:
        k r105 = this.f434594a.f434102f;
        if (r105 == null) goto L25;
        Map<String, Object> r106 = r105.f495847b;
        if (r106 == null) goto L25;
    L26:
        Object r107 = r106.get("doubao_biz_info");
        if ((r107 instanceof String) == false) goto L29;
        String r108 = (String) r107;
    L30:
        if (r108 != null) goto L32;
        lvb.a.b("MmPreMeetingNativeHandler", "buildDoubaoBizInfo, doubaoBizInfoJson is null");
    L33:
        this.f434529s = r102;
        return;
    L32:
        Gson r109 = e0.f444707a;
        r102 = (DoubaoBizInfo) e0.a(r108, DoubaoBizInfo.class);
        lvb.a.e("MmPreMeetingNativeHandler", "buildDoubaoBizInfo, " + r102);
        goto L33
    L29:
        r108 = null;
    L25:
        r106 = MapsKt.emptyMap();
    L16:
        if (this.f434531u == false) goto L19;
        lvb.a.e("MmPreMeetingNativeHandler", "[offlineMode] enabled_by_context");
        goto L19
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public final Object i(Continuation<? super Unit> r100) {
        if ((r100 instanceof MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1 r101 = (MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        boolean r107 = r101.Z$0;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L38:
        boolean r109 = ((Boolean) r103).booleanValue();
        lvb.a.e(this.f434513c, "[cleanupUnboundOfflineLocalPartsIfNeeded] sessionKey=" + r108 + ", isD1204=" + r107 + ", deleted=" + r109);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        ovb.b r110 = (ovb.b) r103;
        String r111 = r110.f526988g;
        String r112 = r110.f526982a;
        if (StringsKt.isBlank(r111) == false) goto L22;
    L40:
        lvb.a.e(this.f434513c, "[cleanupUnboundOfflineLocalPartsIfNeeded] skip, sessionKey=" + r111 + ", meetingId=" + r112);
        return Unit.INSTANCE;
    L22:
        if ((!StringsKt.isBlank(r112)) == true) goto L40;
        MmRecordFileHelper.f434037a.getClass();
        Intrinsics.checkNotNullParameter(r111, "recordingId");
        boolean r113 = StringsKt.startsWith$default(r111, "native_local_", false, 2, null);
        k r114 = this.f434594a.f434102f;
        if (r114 != null) goto L27;
    L29:
        r106 = false;
    L30:
        if (r113 == true) goto L34;
        if (r106 == true) goto L34;
        lvb.a.e(this.f434513c, "[cleanupUnboundOfflineLocalPartsIfNeeded] skip unsupported sessionKey=".concat(r111));
        return Unit.INSTANCE;
    L34:
        String r115 = this.f434514d.getCurrentUserId();
        r101.L$0 = r111;
        r101.Z$0 = r106;
        r101.label = 2;
        r103 = MmRecordFileHelper.c(r115, r111, r101);
        if (r103 != r104) goto L37;
        return r104;
    L37:
        r108 = r111;
        r107 = r106;
        goto L38
    L27:
        if (r114.f495846a != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L29;
    L16:
        ResultKt.throwOnFailure(r103);
        MmRecordingSession r116 = this.f434594a;
        r101.label = 1;
        r103 = r116.r(r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1(this, r100);
        goto L8
    }

    public final MmRecordingAudioService k(String r100) {
        MmRecordingAudioService r101 = this.f434515e;
        if (r101 != null) goto L9;
        lvb.a.b(this.f434513c, "audioService is null, terminate session. from=" + r100);
        if (this.f434524n == true) goto L7;
        this.f434524n = true;
        this.f434594a.m(MmRecordingError.InternalError.INSTANCE);
        this.f434594a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.OTHERS));
    L7:
        return null;
    L9:
        return r101;
    }

    public static final void c(MmPreMeetingNativeRecordingStateHandler r100, MmRecordingError r101) {
        lvb.a.b(r100.f434513c, "[consumeRetryError] error=" + r101 + ", pendingRetryCallback=" + r100.f434523m);
        iub.a<j, ? super MmRecordingError> r102 = r100.f434523m;
        if (r102 == null) goto L5;
        r102.a(r101);
    L5:
        r100.f434523m = null;
        r100.f434526p = false;
    }

    public static final Object d(MmPreMeetingNativeRecordingStateHandler r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1 r102 = (MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        String r107 = (String) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L34:
        if (((Boolean) r104).booleanValue() == false) goto L41;
        lvb.a.e(r100.f434513c, "[copyRecordingDirToMeetingIdIfNeeded] success, save source session mapping, meetingId=" + r107 + ", sessionKey=" + r108);
        r100.f434517g.C(r107, r108);
        r100.f434517g.z(r108, r107);
        k r109 = r100.f434594a.f434102f;
        if (r109 == null) goto L40;
        MmRecordingSource r110 = r109.f495846a;
        if (r110 == null) goto L40;
        r100.f434517g.A(r107, r110);
        r100.f434517g.A(r108, r110);
    L40:
        r100.f434517g.B(r107, r100.f434594a.f434099c);
    L46:
        return Unit.INSTANCE;
    L41:
        lvb.a.b(r100.f434513c, "[copyRecordingDirToMeetingIdIfNeeded] failed, sessionKey=" + r108 + ", meetingId=" + r107);
        goto L46
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L19:
        ovb.b r111 = (ovb.b) r104;
        String r112 = r111.f526988g;
        String r113 = r111.f526982a;
        if (StringsKt.isBlank(r112) == false) goto L22;
    L43:
        lvb.a.e(r100.f434513c, "[copyRecordingDirToMeetingIdIfNeeded] skip, sessionKey=" + r112 + ", meetingId=" + r113);
        return Unit.INSTANCE;
    L22:
        if (StringsKt.isBlank(r113) == true) goto L43;
        if (Intrinsics.areEqual(r112, r113) == true) goto L43;
        if (r100.f434525o == false) goto L29;
        lvb.a.e(r100.f434513c, "[copyRecordingDirToMeetingIdIfNeeded] skip, part dir already switched, sessionKey=" + r112 + ", meetingId=" + r113);
        return Unit.INSTANCE;
    L29:
        lvb.a.e(r100.f434513c, "[copyRecordingDirToMeetingIdIfNeeded] start, sessionKey=" + r112 + ", meetingId=" + r113);
        MmRecordFileHelper r114 = MmRecordFileHelper.f434037a;
        String r115 = r100.f434514d.getCurrentUserId();
        r102.L$0 = r112;
        r102.L$1 = r113;
        r102.label = 2;
        r114.getClass();
        Object r116 = MmRecordFileHelper.a(r115, r112, r113, r102);
        if (r116 == r105) goto L48;
        r107 = r113;
        r104 = r116;
        r108 = r112;
        goto L34
    L48:
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        MmRecordingSession r117 = r100.f434594a;
        r102.label = 1;
        r104 = r117.r(r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new MmPreMeetingNativeRecordingStateHandler$copyRecordingDirToMeetingIdIfNeeded$1(r100, r101);
        goto L8
    }

    public static final void h(MmPreMeetingNativeRecordingStateHandler r100, String r101) {
        Job r102 = r100.f434520j;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        r100.f434520j = BuildersKt.launch$default(r100.f434594a.f434117u, null, null, new MmPreMeetingNativeRecordingStateHandler$startUpload$1(r100, r101, null), 3, null);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r111) {
        Intrinsics.checkNotNullParameter(r110, "oldState");
        Intrinsics.checkNotNullParameter(r111, "newState");
        lvb.a.e(this.f434513c, "onStateChanged: " + r110 + " -> " + r111 + ", isOfflineMode=" + this.f434531u);
        StringBuilder r100 = new StringBuilder("onStateChanged:");
        r100.append(r111);
        MmRecordingAudioService r101 = k(r100.toString());
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C5181c.f434646c) == false) goto L9;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.f434653c) == false) goto L11;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1(this, null), 3, null);
        return;
    L11:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e r102 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.f434648c;
        if (Intrinsics.areEqual(r111, r102) == false) goto L20;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$startLocalRecording$1(this, null), 3, null);
        if (this.f434531u == false) goto L16;
        n();
    L16:
        this.f434594a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.f434636a);
        if (this.f434531u == true) goto L117;
        j();
        return;
    L117:
        return;
    L20:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.f434649c) == false) goto L25;
        if (this.f434531u == true) goto L119;
        j();
        return;
    L119:
        return;
    L25:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.f434654c) == false) goto L40;
        if (Intrinsics.areEqual(r110, r102) == false) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.f434647c) == false) goto L32;
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$1(r101, this, null), 3, null);
        return;
    L32:
        if (o(r101, "Recording:" + r110) == true) goto L35;
        return;
    L35:
        if (this.f434531u == false) goto L37;
        return;
    L37:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L124;
        this.f434517g.F(r111);
        return;
    L124:
        return;
    L40:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.f434651c) == false) goto L44;
        r101.m();
        if (this.f434531u == true) goto L126;
        this.f434517g.F(r111);
        return;
    L126:
        return;
    L44:
        boolean r103 = false;
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.f434647c) == false) goto L58;
        lvb.a.e(r101.f434322e, "[interruptRtcTransmission]");
        MmExternalAudioCapturePipeline r112 = r101.F;
        if (r112 == null) goto L56;
        lvb.a.e("MmExternalAudioCapturePipeline", "detachRtcInput");
        r112.h();
        Object r113 = r112.f434280m;
        monitor-enter(r113);
        r112.f434279l = null;     // Catch: Throwable -> L53
        r112.f434285r = new byte[0];     // Catch: Throwable -> L53
        r112.f434286s.clear();     // Catch: Throwable -> L53
        r112.f434287t = 0;     // Catch: Throwable -> L53
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r113);
    L53:
        th = move-exception;
        throw th;
    L56:
        r101.f434341x.h();
        r101.f434341x.d();
        r101.f434343z = false;
        r101.f434342y = null;
        return;
    L58:
        if ((r111 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L88;
        MmRecordingRepo r115 = this.f434594a.f();
        if (r115 == null) goto L62;
        r115.f();
    L62:
        ovb.b r116 = this.f434594a.f434119w;
        if (r116.f526989h == true) goto L65;
    L67:
        boolean r117 = false;
    L68:
        if (r117 == false) goto L70;
    L78:
        r101.h();
    L79:
        if (r117 == false) goto L81;
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmPreMeetingNativeRecordingStateHandler$leaveMeetingIfNeeded$1(this, null), 3, null);
    L81:
        CoroutineScopeKt.cancel$default(this.f434594a.f434118v, null, 1, null);
        if (r117 == false) goto L84;
        this.f434517g.F(r111);
    L84:
        if (r117 == true) goto L86;
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$2(r101, this, null), 3, null);
        return;
    L86:
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$3(r101, this, null), 3, null);
        return;
    L70:
        if (this.f434527q == true) goto L78;
        if (r101.f434320c == MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE) goto L74;
        lvb.a.h(r101.f434322e, "[stopExternalAudioSourceCaptureForEnd] skip, not external audio source mode");
        goto L79
    L74:
        MmExternalAudioCapturePipeline r104 = r101.F;
        if (r104 == null) goto L77;
        r104.g();
    L77:
        r101.F = null;
        r101.f434328k.setValue(0);
        lvb.a.e(r101.f434322e, "[stopExternalAudioSourceCaptureForEnd] pure offline external audio source mode");
        goto L79
    L65:
        if ((!StringsKt.isBlank(r116.f526982a)) == false) goto L67;
        r117 = true;
        goto L68
    L88:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.f434652c) == false) goto L108;
        if (this.f434531u == true) goto L131;
        ovb.b r118 = this.f434594a.f434119w;
        if (r118.f526982a.length() != 0) goto L94;
        boolean r119 = true;
    L95:
        if (r119 == false) goto L99;
        lvb.a.h(this.f434513c, "[postProcessing] skip upload identity recovery because meetingId is empty");
        return;
    L99:
        if (this.f434594a.v() == false) goto L102;
        r103 = this.f434517g.t();
    L104:
        if (r103 == false) goto L106;
        this.f434516f.d();
        return;
    L106:
        lvb.a.h(this.f434513c, "[postProcessing] upload identity not ready, recover record object, meetingId=" + r118.f526982a);
        this.f434517g.h(r118.f526982a, this.f434529s);
        return;
    L102:
        if (r118.f526985d.length() <= 0) goto L104;
        r103 = true;
        goto L104
    L94:
        r119 = false;
        goto L95
    L131:
        return;
    L108:
        if (Intrinsics.areEqual(r111, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.f434657c) == true) goto L110;
        return;
    L110:
        if (this.f434531u == true) goto L135;
        this.f434516f.k();
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmPreMeetingNativeRecordingStateHandler$onStateChanged$4(this, null), 3, null);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void b(String r110, iub.a<j, ? super MmRecordingError> r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        MmRecordingSession r100 = this.f434594a;
        ovb.b r101 = r100.f434119w;
        if (r100.f434097a == RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L6;
        r111.a(MmRecordingError.TypeDisMatch.INSTANCE);
        return;
    L6:
        boolean r102 = false;
        if (r110 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L31;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Gson r105 = e0.f444707a;     // Catch: Throwable -> L17
        Object r112 = Result.m9449constructorimpl((DoubaoBizInfo) e0.a(r110, DoubaoBizInfo.class));     // Catch: Throwable -> L17
    L19:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r112);
        if (r106 == null) goto L23;
        lvb.a.h(this.f434513c, "[retryCreateRecording] parse doubaoBizInfo json failed, err=" + r106.getMessage());
    L23:
        if (Result.m9455isFailureimpl(r112) == false) goto L25;
        r112 = null;
    L25:
        DoubaoBizInfo r113 = (DoubaoBizInfo) r112;
        if (r113 == null) goto L31;
        DoubaoBizInfo r114 = r113.withHostAppVersion();
        if (r114 == null) goto L31;
        this.f434529s = r114;
        lvb.a.e(this.f434513c, "[retryCreateRecording] rebuild doubaoBizInfo from json");
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        if (r101.f526989h == false) goto L33;
    L62:
        BuildersKt.launch$default(this.f434594a.f434118v, null, null, new MmPreMeetingNativeRecordingStateHandler$retryCreateRecording$4(this, r101, r111, null), 3, null);
        return;
    L33:
        if (r101.f526982a.length() <= 0) goto L35;
        boolean r115 = true;
    L36:
        if (r115 == true) goto L62;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r116 = this.f434594a.g();
        if ((r116 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L41;
    L60:
        lvb.a.h(this.f434513c, "[retryCreateRecording] invalid state=" + r116);
        r111.a(MmRecordingError.StateError.INSTANCE);
        return;
    L41:
        if ((r116 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == true) goto L60;
        if (Intrinsics.areEqual(r116, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.f434657c) == true) goto L60;
        if (this.f434522l == false) goto L50;
        lvb.a.h(this.f434513c, "[retryCreateRecording] ignored, already creating meeting");
        r111.a(MmRecordingError.StateError.INSTANCE);
        return;
    L50:
        if (this.f434531u == true) goto L52;
        r102 = true;
    L56:
        if (r102 == true) goto L58;
        return;
    L58:
        this.f434523m = r111;
        this.f434526p = true;
        j();
        return;
    L52:
        pvb.a r117 = (pvb.a) this.f434519i.getValue();
        k r108 = this.f434594a.f434102f;
        if (r108 == null) goto L56;
        r102 = r117.a(r108, r111);
        goto L56
    L35:
        r115 = false;
        goto L36
    L9:
        if (r110.length() == 0) goto L12;
        r103 = false;
        goto L14
    }

    public final boolean o(MmRecordingAudioService r100, String r101) {
        if (r100.l() == false) goto L6;
        return true;
    L6:
        lvb.a.b(this.f434513c, "[startAudioCaptureOrTerminate] failed, from=" + r101);
        this.f434594a.m(MmRecordingError.InternalError.INSTANCE);
        this.f434594a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.OTHERS));
        return false;
    }

    public final Object p(MmRecordingAudioService r310, Continuation<? super Boolean> r311) {
        if ((r311 instanceof MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1 r100 = (MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r104 = r100.J$0;
        VFSFile r105 = (VFSFile) r100.L$2;
        String r106 = (String) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L89:
        this.f434517g.x(r107);
        lvb.a.e(this.f434513c, "[offlineUpload] submitted, sessionKey=" + r107 + ", taskId=" + ((String) r102) + ", path=" + r106 + ", size=" + r105.length() + ", durationMs=" + r104);
        return Boxing.boxBoolean(true);
    L13:
        long r108 = r100.J$2;
        long r109 = r100.J$1;
        long r110 = r100.J$0;
        VFSFile r111 = (VFSFile) r100.L$2;
        String r112 = (String) r100.L$1;
        String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L84:
        String r114 = (String) r102;
    L85:
        long r210 = r109;
        r106 = r112;
        int r115 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.a.f434177a;
        String r116 = r113;
        eub.f r117 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.a.a(r116, r114, r106, r111.length(), r110, r210);
        MmMinutesFileUploadSessionManager r118 = this.f434514d.F();
        r100.L$0 = r113;
        r100.L$1 = r106;
        r100.L$2 = r111;
        r100.J$0 = r108;
        r100.label = 6;
        r102 = r118.H(r117, r100);
        if (r102 != r103) goto L88;
        return r103;
    L88:
        r104 = r108;
        r105 = r111;
        r107 = r113;
        goto L89
    L14:
        long r119 = r100.J$2;
        long r120 = r100.J$1;
        long r121 = r100.J$0;
        String r122 = (String) r100.L$1;
        String r123 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r124 = r122;
    L63:
        boolean r125 = ((Boolean) r102).booleanValue();
        VFSFile r126 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r124);
        lvb.a.e(this.f434513c, "[offlineUpload] assemble full audio, sessionKey=" + r123 + ", assembled=" + r125 + ", exists=" + r126.exists() + ", size=" + r126.length());
        r108 = r119;
        r109 = r120;
        r110 = r121;
        r113 = r123;
        r112 = r124;
        r111 = r126;
    L65:
        if (r111.exists() == true) goto L67;
    L91:
        lvb.a.h(this.f434513c, "[offlineUpload] skip, audio file unavailable, sessionKey=" + r113 + ", path=" + r112);
        return Boxing.boxBoolean(false);
    L67:
        if (r111.length() <= 0) goto L91;
        k r127 = this.f434594a.f434102f;
        if (r127 == null) goto L76;
        Map<String, Object> r128 = r127.f495847b;
        if (r128 == null) goto L76;
        Object r129 = r128.get("hardware_device_id");
        if (r129 == null) goto L76;
        r114 = r129.toString();
    L77:
        if (r114 != null) goto L80;
        r114 = "";
    L80:
        if (StringsKt.isBlank(r114) == false) goto L85;
        MmRecordingStatesSyncService r130 = this.f434517g;
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r111;
        r100.J$0 = r110;
        r100.J$1 = r109;
        r100.J$2 = r108;
        r100.label = 5;
        r102 = r130.n(r113, r100);
        if (r102 != r103) goto L84;
        return r103;
    L76:
        r114 = null;
        goto L77
    L15:
        long r131 = r100.J$2;
        long r132 = r100.J$1;
        long r133 = r100.J$0;
        String r134 = (String) r100.L$1;
        MmRecordingAudioService r135 = (MmRecordingAudioService) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r136 = r102;
        MmRecordingAudioService r137 = r135;
        r123 = r134;
        r120 = r132;
        r121 = r133;
        r119 = r131;
    L50:
        r124 = (String) r136;
        if (StringsKt.isBlank(r124) == false) goto L54;
        lvb.a.h(this.f434513c, "[offlineUpload] skip, audioPath is blank, sessionKey=" + r123);
        return Boxing.boxBoolean(false);
    L54:
        VFSFile r138 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r124);
        if (r138.exists() == true) goto L57;
    L60:
        r100.L$0 = r123;
        r100.L$1 = r124;
        r100.J$0 = r121;
        r100.J$1 = r120;
        r100.J$2 = r119;
        r100.label = 4;
        r102 = r137.d().b(r137.f434319b.getCurrentUserId(), r123, r124, r100);
        if (r102 != r103) goto L63;
        return r103;
    L57:
        if (r138.length() <= 0) goto L60;
        long r211 = r120;
        r113 = r123;
        r112 = r124;
        r111 = r138;
        r109 = r211;
        r108 = r119;
        r110 = r121;
        goto L65
    L16:
        String r139 = (String) r100.L$1;
        MmRecordingAudioService r140 = (MmRecordingAudioService) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L41:
        Long r141 = (Long) ((Map) r102).get(r139);
        if (r141 == null) goto L44;
        long r142 = r141.longValue();
    L45:
        MmRecordingAudioService r143 = r140;
        String r144 = r139;
    L46:
        long r145 = System.currentTimeMillis();
        String r146 = r144;
        long r147 = RangesKt.coerceAtLeast(r145 - r142, 1000);
        r100.L$0 = r143;
        r100.L$1 = r146;
        r100.J$0 = r142;
        r100.J$1 = r145;
        r100.J$2 = r147;
        r100.label = 3;
        r136 = m(r143, r146, r100);
        if (r136 != r103) goto L49;
        return r103;
    L49:
        r123 = r146;
        r137 = r143;
        r120 = r145;
        r119 = r147;
        r121 = r142;
        goto L50
    L44:
        r142 = System.currentTimeMillis();
        goto L45
    L17:
        MmRecordingAudioService r148 = (MmRecordingAudioService) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L21:
        ovb.b r149 = (ovb.b) r102;
        r144 = r149.f526988g;
        if (StringsKt.isBlank(r144) == false) goto L25;
        r144 = this.f434594a.e();
    L25:
        if (StringsKt.isBlank(r144) == false) goto L28;
        lvb.a.h(this.f434513c, "[offlineUpload] skip, sessionKey is blank");
        return Boxing.boxBoolean(false);
    L28:
        Long r150 = Boxing.boxLong(r149.f526983b);
        if (r150.longValue() <= 0) goto L31;
        boolean r151 = true;
    L32:
        if (r151 == true) goto L35;
        r150 = null;
    L35:
        if (r150 == null) goto L37;
        r142 = r150.longValue();
        r143 = r148;
        goto L46
    L37:
        MmRecordingStatesSyncService r152 = this.f434517g;
        r100.L$0 = r148;
        r100.L$1 = r144;
        r100.label = 2;
        r102 = r152.o(r100);
        if (r102 != r103) goto L40;
        return r103;
    L40:
        String r212 = r144;
        r140 = r148;
        r139 = r212;
        goto L41
    L31:
        r151 = false;
        goto L32
    L18:
        ResultKt.throwOnFailure(r102);
        MmRecordingSession r153 = this.f434594a;
        r148 = r310;
        r100.L$0 = r148;
        r100.label = 1;
        r102 = r153.r(r100);
        if (r102 != r103) goto L21;
        return r103;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1(this, r311);
        goto L8
    }

    public static final Object f(MmPreMeetingNativeRecordingStateHandler r100, MmRecordingAudioService r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1 r102 = (MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L46:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
    L40:
        if (((Boolean) r111).booleanValue() == false) goto L44;
        r102.label = 3;
        if (r100.i(r102) != r104) goto L46;
        return r104;
    L44:
        lvb.a.h(r100.f434513c, "[offlineUpload] keep offline files, submit failed, recordingId=" + r100.f434594a.e());
        goto L46
    L17:
        ResultKt.throwOnFailure(r111);
    L47:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r111);
        k r112 = r100.f434594a.f434102f;
        boolean r106 = false;
        if (r112 != null) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L36;
        if (r112 == null) goto L31;
        MmRecordingSource r108 = r112.f495846a;
        if (r108 == null) goto L31;
        if (r108.shouldRetainOfflineRecordingParts() != true) goto L31;
        r106 = true;
    L31:
        if (r106 == true) goto L47;
        r102.label = 1;
        if (r100.i(r102) != r104) goto L47;
        return r104;
    L36:
        r102.label = 2;
        r111 = r100.p(r101, r102);
        if (r111 != r104) goto L40;
        return r104;
    L21:
        if (r112.f495846a != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L23;
        r107 = true;
    L7:
        r102 = new MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1(r100, r110);
        goto L8
    }

    public static final Object g(MmPreMeetingNativeRecordingStateHandler r100, MinutesRecordingStartResponse r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1 r103 = (MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L21:
        if (Result.m9456isSuccessimpl(r108) == false) goto L23;
        ((Boolean) r108).booleanValue();
        lvb.a.e(r100.f434513c, "audioService update RTC config and switch to RTC mode success");
    L23:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L27;
        lvb.a.b(r100.f434513c, "audioService update RTC config failed: " + r109);
    L27:
        return Boxing.boxBoolean(Result.m9456isSuccessimpl(r108));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MmRecordingAudioService r110 = r100.k("initRtcWithMeeting");
        if (r110 == null) goto L28;
        r103.label = 1;
        r108 = r110.r(r101, r103);
        if (r108 != r106) goto L21;
        return r106;
    L28:
        return Boxing.boxBoolean(false);
    L7:
        r103 = new MmPreMeetingNativeRecordingStateHandler$initRtcWithMeeting$1(r100, r102);
        goto L8
    }

    public final Object m(MmRecordingAudioService r100, String r101, Continuation<? super String> r102) {
        if ((r102 instanceof MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1) == false) goto L7;
        MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1 r103 = (MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (MmRecordingAudioService) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        CharSequence r108 = (CharSequence) r105;
        if (StringsKt.isBlank(r108) == false) goto L24;
        String r109 = r100.e();
        if (r109 != null) goto L23;
        r109 = "";
    L23:
        return r109;
    L24:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MmRecordingStatesSyncService r110 = this.f434517g;
        r103.L$0 = r100;
        r103.label = 1;
        r105 = r110.m(r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new MmPreMeetingNativeRecordingStateHandler$resolveOfflineLocalAudioPath$1(this, r102);
        goto L8
    }

    public static final void e(MmPreMeetingNativeRecordingStateHandler r100, MmRecordingUploadTask r101, Set r102, String r103) {
        r100.getClass();
        if (r102.add(r101.f434499a) == true) goto L5;
        lvb.a.e(r100.f434513c, "[startUpload] skip duplicated segment, source:" + r103 + ", segIndex:" + r101.f434500b + ", path:" + r101.f434499a);
        return;
    L5:
        lvb.a.e(r100.f434513c, "[startUpload] enqueue segment, source:" + r103 + ", segIndex:" + r101.f434500b + ", path:" + r101.f434499a);
        r100.f434594a.k().c(r101);
    }
}
