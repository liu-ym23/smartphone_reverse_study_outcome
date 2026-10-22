package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationAecPolicy;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.j;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.SIBizScene;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.UpdateSISettingRequest;
import com.ss.android.lark.pb.videochat.UpdateSISettingResponse;
import iub.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jvb.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes37.dex */
public final class MmStandaloneAIInterpretationRepo extends MviRepository {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f435094t = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingSession f435095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f435097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Deferred<g> f435098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f435099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f435100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f435101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f435102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f435103r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f435104s;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r110, String r111, MmRecordingSource r112, boolean r113, Continuation<? super Result<String>> r114) {
            if ((r114 instanceof MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1) == false) goto L7;
            MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1 r100 = (MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1) r114;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            ResultKt.throwOnFailure(r102);
            return ((Result) r102).m9458unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            MmRecordingUpdateStatus r105 = MmRecordingUpdateStatus.SET_SIMULTANEOUS_SAVE_ARTIFACT;
            Boolean r115 = Boxing.boxBoolean(r113);
            if (r112 != null) goto L17;
        L19:
            boolean r116 = false;
        L20:
            h r106 = new h(r111, r105, r112, r115, null, r116);
            r100.label = 1;
            Object r107 = r110.c(String.class, r106, r100);
            if (r107 != r103) goto L24;
            return r103;
        L24:
            return r107;
        L17:
            if (r112.usesRecordingApiByDefault() != true) goto L19;
            r116 = true;
        L7:
            r100 = new MmStandaloneAIInterpretationRepo$Companion$sendSaveArtifactStatusRequest$1(this, r114);
            goto L8
        }
    }

    static {
        f435094t = new Companion();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final Object a() {
        return new b(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e s() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e) this.f435099n.getValue();
    }

    public final a t() {
        return (a) this.f435104s.getValue();
    }

    public final e u() {
        return (e) this.f435103r.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f435097l;
    }

    public static c x(UpdateSISettingResponse.SILanguage r100) {
        if (r100 == null) goto L5;
        String r101 = r100.mlanguage;
    L6:
        if (r100 == null) goto L8;
        String r102 = r100.mdescription_i18n;
    L9:
        boolean r103 = true;
        if (r101 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L26;
        if (r102 != null) goto L19;
    L22:
        if (r103 == false) goto L25;
        return null;
    L25:
        return new c(r101, r102);
    L19:
        if (StringsKt.isBlank(r102) == true) goto L22;
        r103 = false;
        goto L22
    L26:
        return null;
    L12:
        if (StringsKt.isBlank(r101) == true) goto L15;
        r104 = false;
        goto L16
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public static String y(c r100) {
        String r101 = r100.f435126a;
        String r102 = null;
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
    L12:
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L8:
        if (StringsKt.startsWith$default(r101, "ai_", false, 2, null) == true) goto L11;
        r101 = "ai_".concat(r101);
    L11:
        r102 = r101;
        goto L12
    }

    public MmStandaloneAIInterpretationRepo(MmRecordingSession r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "mmUccApi");
        this.f435095j = r100;
        this.f435096k = r101;
        this.f435097l = "MmStandaloneAIInterpretationRepo";
        this.f435099n = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$localStorage$2(this));
        this.f435100o = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$rtcActionApplier$2(this));
        this.f435101p = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$quotaDialogHandler$2(this));
        this.f435103r = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$rtcApplyCoordinator$2(this));
        this.f435104s = LazyKt.lazy(new MmStandaloneAIInterpretationRepo$opt$2(this));
    }

    public static final void l(MmStandaloneAIInterpretationRepo r100, String r101) {
        r100.f435102q = null;
        e r102 = r100.u();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "source");
        r102.f435138g = null;
        r102.f435139h = null;
        boolean r103 = false;
        r102.f435140i = false;
        r102.f435142k = true;
        int r104 = l.f434781a;
        j r105 = new j(false, CollectionsKt.listOf(PullConfiguration.PROCESS_NAME_MAIN), true, MmAIInterpretationAecPolicy.RESTORE);
        r102.f435133b.invoke(Boolean.valueOf(r105.f434776c));
        if (r102.f435137f == false) goto L5;
        boolean r106 = r102.f435136e.invoke(r105, r101).booleanValue();
    L7:
        if (r102.f435137f == true) goto L9;
        boolean r107 = false;
    L10:
        if (r106 == true) goto L12;
        if (r107 == true) goto L12;
    L13:
        lvb.a.e(r100.f435097l, "[applyStandaloneAIInterpretationDisabledRtcPolicy] source=" + r101 + ", rtcInitialized=" + r100.u().f435137f + ", applied=" + r103);
        return;
    L12:
        r103 = true;
        goto L13
    L9:
        int r108 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.h.f434768a;
        r107 = r102.c(100);
        goto L10
    L5:
        r106 = false;
        goto L7
    }

    public static final d m(MmStandaloneAIInterpretationRepo r100, String r101, String r102) {
        Boolean r103 = null;
        if (r101 == null) goto L7;
        r100.getClass();
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
    L8:
        if (r101 != null) goto L10;
        lvb.a.b(r100.f435097l, "[applyStandaloneAIInterpretationEnabledRtcPolicy] skip empty targetChannel, source=".concat(r102));
        return r100.u().d(null, r102);
    L10:
        d r104 = r100.u().d(r101, r102);
        String r105 = r100.f435097l;
        StringBuilder r106 = new StringBuilder("[applyStandaloneAIInterpretationEnabledRtcPolicy] source=");
        r106.append(r102);
        r106.append(", channel=");
        r106.append(r101);
        r106.append(", actualMuted=");
        r106.append(r104.f435129a);
        r106.append(", changeToOrigin=");
        r106.append(r104.f435131c);
        r106.append(", playbackMuted=");
        MmRecordingAudioService r107 = r100.f435095j.a();
        if (r107 == null) goto L13;
        r103 = Boolean.valueOf(r107.f434336s);
    L13:
        r106.append(r103);
        r106.append(", rtcInitialized=");
        r106.append(r100.u().f435137f);
        r106.append(", applied=");
        r106.append(r104.f435130b);
        lvb.a.e(r105, r106.toString());
        return r104;
    L7:
        r101 = null;
        goto L8
    }

    public static final Object n(MmStandaloneAIInterpretationRepo r100, Function1 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1 r103 = (MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1) r102;
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
        ResultKt.throwOnFailure(r105);
    L23:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
    L19:
        r103.label = 2;
        r105 = ((Deferred) r105).await(r103);
        if (r105 != r106) goto L23;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1 r108 = new MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1(r100, r101, null);
        r103.label = 1;
        r105 = r100.f433819e.b(r108, r103);
        if (r105 != r106) goto L19;
        return r106;
    L7:
        r103 = new MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1(r100, r102);
        goto L8
    }

    public static final Object o(MmStandaloneAIInterpretationRepo r100, String r101, b r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1 r104 = (MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
        Object r109 = ((Result) r106).m9458unboximpl();
    L41:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L45;
        lvb.a.b(r100.f435097l, "[resolveSpokenLanguageBeforeSwitch] failed: " + r110);
    L45:
        if (Result.m9455isFailureimpl(r109) == false) goto L47;
        r109 = null;
    L47:
        GetLiveRecordingSettingResponse r111 = (GetLiveRecordingSettingResponse) r109;
        if (r111 == null) goto L65;
        GetLiveRecordingSettingResponse.SubtitleLanguage r112 = r111.mspoken_language;
        if (r112 == null) goto L65;
        String r113 = r112.mlanguage;
        if (r113 != null) goto L54;
    L57:
        boolean r114 = true;
    L59:
        if ((!r114) == true) goto L62;
        r112 = null;
    L62:
        if (r112 == null) goto L65;
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(r112.mlanguage, r112.mdescription_i18n);
    L54:
        if (StringsKt.isBlank(r113) == true) goto L57;
        r114 = false;
    L65:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        MmStandaloneAIInterpretationRootRepo r115 = r100.f435095j.h();
        if (r115 == null) goto L30;
        MmRecordingLanguageRepo r116 = r115.l();
        if (r116 == null) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r117 = r116.l();
        if (r117 == null) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r118 = r117.m();
        if (r118 == null) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r119 = r118.f435297c;
        if (r119 == null) goto L30;
        if ((!StringsKt.isBlank(r119.f435304a)) == true) goto L28;
        r119 = null;
    L28:
        if (r119 == null) goto L30;
        return r119;
    L30:
        c r120 = r102.f435121f;
        if (r120 != null) goto L33;
    L38:
        MmRecordingNetHelper r121 = r100.f435096k.G();
        r104.label = 1;
        r109 = r121.f(r101, r104);
        if (r109 != r107) goto L41;
        return r107;
    L33:
        if ((!StringsKt.isBlank(r120.f435126a)) == true) goto L36;
        r120 = null;
    L36:
        if (r120 == null) goto L38;
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(r120.f435126a, r120.f435127b);
    L7:
        r104 = new MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1(r100, r103);
        goto L8
    }

    public static final Object q(MmStandaloneAIInterpretationRepo r100, String r101, boolean r102, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1 r103 = (MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1 r105 = r103;
        Object r111 = r105.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r105.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r111);
        Object r108 = ((Result) r111).m9458unboximpl();
    L27:
        return r108;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        if (StringsKt.isBlank(r101) == false) goto L18;
        lvb.a.b(r100.f435097l, "[sendSaveArtifactStatusRequest] skip, recordingId is blank");
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("recordingId is blank")));
    L18:
        MmRecordingSession r112 = r100.f435095j;
        ovb.b r113 = r112.f434119w;
        k r114 = r112.f434102f;
        if (r114 == null) goto L22;
        MmRecordingSource r115 = r114.f495846a;
        if (r115 == null) goto L22;
    L25:
        MmRecordingSource r116 = r115;
        lvb.a.e(r100.f435097l, "[sendSaveArtifactStatusRequest] request, recordingId=" + r101 + ", saveArtifactType=" + r102 + ", source=" + r116);
        Companion r117 = f435094t;
        MmMockAwareRequestService r118 = r100.f435096k.M();
        r105.label = 1;
        r108 = r117.a(r118, r101, r116, r102, r105);
        if (r108 != r106) goto L27;
        return r106;
    L22:
        r115 = r100.s().r(r101);
        if (r115 != null) goto L25;
        r115 = r100.s().r(r113.f526982a);
    L7:
        r103 = new MmStandaloneAIInterpretationRepo$sendSaveArtifactStatusRequest$1(r100, r110);
        goto L8
    }

    public final Object v(String r100, boolean r101, c r102, Continuation<? super g> r110) {
        if ((r110 instanceof MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1 r103 = (MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r101 = r103.Z$0;
        r102 = (c) r103.L$0;
        ResultKt.throwOnFailure(r111);
        Object r107 = ((Result) r111).m9458unboximpl();
    L17:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r107);
        if (r112 != null) goto L20;
        g r108 = (g) r107;
        lvb.a.e(this.f435097l, "[sendSwitchTargetLanguageRequest] result, enabled=" + r101 + ", status=" + r108.f435146b + ", accepted=" + r108.a() + ", channel=" + r108.f435145a + ", language=" + r102.f435126a);
        return r108;
    L20:
        lvb.a.b(this.f435097l, "[sendSwitchTargetLanguageRequest] failed, enabled=" + r101 + ": " + r112);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        lvb.a.e(this.f435097l, "[sendSwitchTargetLanguageRequest] meetingId=" + r100 + ", enabled=" + r101 + ", language=" + r102.f435126a);
        r103.L$0 = r102;
        r103.Z$0 = r101;
        r103.label = 1;
        r107 = w(r100, r101, r102, r103);
        if (r107 != r105) goto L17;
        return r105;
    L7:
        r103 = new MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1(this, r110);
        goto L8
    }

    public final Object w(String r210, boolean r211, c r212, Continuation<? super Result<g>> r213) {
        if ((r213 instanceof MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1 r100 = (MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        String r110 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        boolean r106 = r100.Z$0;
        c r107 = (c) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r108 = ((Result) r102).m9458unboximpl();
    L66:
        boolean r109 = Result.m9456isSuccessimpl(r108);
        Object r111 = r108;
        if (r109 == false) goto L112;
        UpdateSISettingResponse r112 = (UpdateSISettingResponse) r108;
        String r113 = r112.mchannel;
        if (r113 != null) goto L71;
        r113 = "";
    L71:
        String r114 = r113;
        int r115 = r112.mstatus.getValue();
        List<UpdateSISettingResponse.SILanguage> r116 = r112.msupport_spoken_lans;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L73:
        if (r118.hasNext() == false) goto L77;
        c r119 = x((UpdateSISettingResponse.SILanguage) r118.next());
        if (r119 == null) goto L73;
        r117.add(r119);
        goto L73
    L77:
        List<UpdateSISettingResponse.SILanguage> r120 = r112.msupport_lans;
        ArrayList r121 = new ArrayList();
        Iterator<T> r122 = r120.iterator();
    L79:
        if (r122.hasNext() == false) goto L83;
        c r123 = x((UpdateSISettingResponse.SILanguage) r122.next());
        if (r123 == null) goto L79;
        r121.add(r123);
        goto L79
    L83:
        Map<String, UpdateSISettingResponse.StringList> r124 = r112.msupport_spoken_translate_map_lans;
        LinkedHashMap r125 = new LinkedHashMap(MapsKt.mapCapacity(r124.size()));
        Iterator<T> r126 = r124.entrySet().iterator();
    L85:
        if (r126.hasNext() == false) goto L87;
        Map.Entry r127 = (Map.Entry) r126.next();
        r125.put(r127.getKey(), ((UpdateSISettingResponse.StringList) r127.getValue()).mvalues);
        goto L85
    L87:
        Map<String, UpdateSISettingResponse.StringList> r128 = r112.msupport_translate_spoken_map_lans;
        LinkedHashMap r129 = new LinkedHashMap(MapsKt.mapCapacity(r128.size()));
        Iterator<T> r130 = r128.entrySet().iterator();
    L89:
        if (r130.hasNext() == false) goto L91;
        Map.Entry r131 = (Map.Entry) r130.next();
        r129.put(r131.getKey(), ((UpdateSISettingResponse.StringList) r131.getValue()).mvalues);
        goto L89
    L91:
        UpdateSISettingResponse.SILanguage r132 = r112.mhighlight_spoken_lang;
        if (r132 == null) goto L94;
        c r133 = x(r132);
    L95:
        UpdateSISettingResponse.SILanguage r134 = r112.mhighlight_lang;
        if (r134 == null) goto L98;
        c r135 = x(r134);
    L99:
        g r136 = new g(r114, r115, r117, r121, r125, r129, r133, r135);
        String r137 = this.f435097l;
        StringBuilder r138 = new StringBuilder("[sendUpdateSettingRequest] status=");
        r138.append(r136.f435146b);
        r138.append(", channel=");
        r138.append(r136.f435145a);
        r138.append(", enabled=");
        r138.append(r106);
        r138.append(", language=");
        if (r107 == null) goto L102;
        String r139 = r107.f435126a;
    L103:
        r138.append(r139);
        r138.append(", highlightSpoken=");
        c r140 = r136.f435151g;
        if (r140 == null) goto L106;
        String r141 = r140.f435126a;
    L107:
        r138.append(r141);
        r138.append(", highlight=");
        c r142 = r136.f435152h;
        if (r142 == null) goto L110;
        r110 = r142.f435126a;
    L110:
        r138.append(r110);
        r138.append(", spokenSize=");
        r138.append(r136.f435147c.size());
        r138.append(", targetSize=");
        r138.append(r136.f435148d.size());
        r138.append(", spokenToTargetKeys=");
        r138.append(r136.f435149e.size());
        r138.append(", targetToSpokenKeys=");
        r138.append(r136.f435150f.size());
        lvb.a.e(r137, r138.toString());
        r111 = r136;
        goto L112
    L106:
        r141 = null;
        goto L107
    L102:
        r139 = null;
        goto L103
    L98:
        r135 = null;
        goto L99
    L94:
        r133 = null;
    L112:
        return Result.m9449constructorimpl(r111);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r143 = this.f435097l;
        StringBuilder r144 = new StringBuilder("[sendUpdateSettingRequest] request, meetingId=");
        r144.append(r210);
        r144.append(", enabled=");
        r144.append(r211);
        r144.append(", targetLang=");
        if (r212 == null) goto L17;
        String r145 = r212.f435126a;
    L18:
        r144.append(r145);
        lvb.a.e(r143, r144.toString());
        UpdateSISettingRequest.Builder r146 = new UpdateSISettingRequest.Builder().meeting_id(r210).turn_on(Boxing.boxBoolean(r211)).biz_scene(SIBizScene.INDEPENDENT);
        if (r211 == false) goto L55;
        String r147 = this.f435095j.f434119w.f526984c;
        if (StringsKt.isBlank(r147) == false) goto L23;
        r147 = s().u(r210);
    L23:
        k r148 = this.f435095j.f434102f;
        if (r148 == null) goto L28;
        MmRecordingSource r149 = r148.f495846a;
        if (r149 == null) goto L28;
    L37:
        if (r149 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L55;
        String r150 = this.f435095j.f434119w.f526984c;
        if (StringsKt.isBlank(r150) == false) goto L41;
        r150 = s().u(r210);
    L41:
        DoubaoBizInfo r151 = this.f435095j.c();
        if (r151 != null) goto L45;
        r151 = s().h(r210);
    L45:
        if (StringsKt.isBlank(r150) == true) goto L49;
        if (r151 == null) goto L49;
        r146.record_id(r150).doubao_bizinfo(new com.ss.android.lark.pb.videochat.DoubaoBizInfo.Builder().user_id(r151.getUserId()).conversation_id(r151.getConversationId()).message_id(r151.getMessageId()).reply_message_id(r151.getReplyMessageId()).biz_id(r151.getBizId()).app_id(r151.getAppId()).tenant_id(r151.getTenantId()).device_id(r151.getDeviceId()).recording_id(r151.getRecordingId()).build());
    L49:
        String r152 = this.f435097l;
        StringBuilder r153 = new StringBuilder("[sendUpdateSettingRequest] skip incomplete doubao request, hasRecordingId=");
        r153.append(!StringsKt.isBlank(r150));
        r153.append(", hasDoubaoBizInfo=");
        if (r151 != null) goto L53;
        r105 = false;
    L53:
        r153.append(r105);
        lvb.a.b(r152, r153.toString());
        Result.Companion r154 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("incomplete doubao standalone interpretation context")));
    L28:
        if ((!StringsKt.isBlank(r147)) == true) goto L31;
        r147 = null;
    L31:
        if (r147 == null) goto L33;
        r149 = s().r(r147);
    L34:
        if (r149 != null) goto L37;
        r149 = s().r(r210);
        goto L37
    L33:
        r149 = null;
    L55:
        if (r212 == null) goto L62;
        String r155 = y(r212);
        if ((!StringsKt.isBlank(r155)) == true) goto L60;
        r155 = null;
    L60:
        if (r155 == null) goto L62;
        r146.target_lang(r155);
    L62:
        UpdateSISettingRequest r156 = r146.build();
        MmMockAwareRequestService r157 = this.f435096k.M();
        Command r158 = Command.UPDATE_MEETING_SI_SETTING;
        Intrinsics.checkNotNull(r156);
        r100.L$0 = r212;
        r100.Z$0 = r211;
        r100.label = 1;
        Object r159 = r157.a(r158, UpdateSISettingResponse.class, r156, r100);
        if (r159 != r103) goto L65;
        return r103;
    L65:
        r108 = r159;
        r106 = r211;
        r107 = r212;
        goto L66
    L17:
        r145 = null;
    L7:
        r100 = new MmStandaloneAIInterpretationRepo$sendUpdateSettingRequest$1(this, r213);
        goto L8
    }

    public static final Object r(MmStandaloneAIInterpretationRepo r110, String r111, boolean r112, c r113, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof MmStandaloneAIInterpretationRepo$updateSetting$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$updateSetting$1 r100 = (MmStandaloneAIInterpretationRepo$updateSetting$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmStandaloneAIInterpretationRepo$updateSetting$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r106 = null;
        if (r105 == 0) goto L19;
        if (r105 == 1) goto L18;
        if (r105 == 2) goto L17;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        ResultKt.throwOnFailure(r103);
    L64:
        return null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        g r107 = (g) r102.L$0;
        ResultKt.throwOnFailure(r103);
        return r107;
    L18:
        boolean r108 = r102.Z$0;
        c r109 = (c) r102.L$0;
        ResultKt.throwOnFailure(r103);
        Object r114 = ((Result) r103).m9458unboximpl();
        boolean r115 = r108;
    L35:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r114);
        if (r116 != null) goto L60;
        g r117 = (g) r114;
        if (r117.a() == false) goto L52;
        c r118 = r117.f435152h;
        if (r118 != null) goto L42;
        c r119 = r109;
    L43:
        String r120 = r110.f435097l;
        StringBuilder r121 = new StringBuilder("[updateSetting] accepted, enabled=");
        r121.append(r115);
        r121.append(", status=");
        r121.append(r117.f435146b);
        r121.append(", channel=");
        r121.append(r117.f435145a);
        r121.append(", language=");
        if (r119 == null) goto L46;
        r106 = r119.f435126a;
    L46:
        r121.append(r106);
        r121.append(", spokenSize=");
        r121.append(r117.f435147c.size());
        r121.append(", targetSize=");
        r121.append(r117.f435148d.size());
        r121.append(", spokenToTargetKeys=");
        r121.append(r117.f435149e.size());
        r121.append(", targetToSpokenKeys=");
        r121.append(r117.f435150f.size());
        lvb.a.e(r120, r121.toString());
        r102.L$0 = r117;
        r102.label = 2;
        Object r122 = r110.f433819e.b(new MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2(r110, r115, r117, r119, null), r102);
        if (r122 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        r122 = Unit.INSTANCE;
    L50:
        if (r122 != r104) goto L66;
        return r104;
    L66:
        return r117;
    L42:
        r119 = r118;
        goto L43
    L52:
        String r123 = r110.f435097l;
        StringBuilder r124 = new StringBuilder("[updateSetting] business failed, status=");
        r124.append(r117.f435146b);
        r124.append(", channel=");
        r124.append(r117.f435145a);
        r124.append(", language=");
        if (r109 == null) goto L55;
        String r125 = r109.f435126a;
    L56:
        r124.append(r125);
        lvb.a.b(r123, r124.toString());
        b r126 = b.b((b) r110.h(), null, "update_failed", 511);
        r102.L$0 = r117;
        r102.label = 3;
        if (r110.b(r126, r102) != r104) goto L66;
        return r104;
    L55:
        r125 = null;
        goto L56
    L60:
        lvb.a.b(r110.f435097l, "[updateSetting] failed: " + r116);
        b r127 = b.b((b) r110.h(), null, "update_failed", 511);
        r102.L$0 = null;
        r102.label = 4;
        if (r110.b(r127, r102) != r104) goto L64;
        return r104;
    L19:
        ResultKt.throwOnFailure(r103);
        String r128 = r110.f435097l;
        StringBuilder r129 = new StringBuilder("[updateSetting] start, enabled=");
        r129.append(r112);
        r129.append(", meetingId=");
        r129.append(r111);
        r129.append(", language=");
        if (r113 == null) goto L22;
        String r130 = r113.f435126a;
    L23:
        r129.append(r130);
        lvb.a.e(r128, r129.toString());
        b r131 = (b) r110.h();
        String r132 = r110.f435097l;
        StringBuilder r133 = new StringBuilder("[updateSetting] local before request, enabled=");
        r133.append(r131.f435116a);
        r133.append(", active=");
        c r134 = r131.f435124i;
        if (r134 == null) goto L26;
        String r135 = r134.f435126a;
    L27:
        r133.append(r135);
        r133.append(", selected=");
        c r136 = r131.f435122g;
        if (r136 == null) goto L30;
        String r137 = r136.f435126a;
    L31:
        r133.append(r137);
        lvb.a.e(r132, r133.toString());
        r102.L$0 = r113;
        r102.Z$0 = r112;
        r102.label = 1;
        Object r138 = r110.w(r111, r112, r113, r102);
        if (r138 == r104) goto L67;
        r115 = r112;
        r109 = r113;
        r114 = r138;
        goto L35
    L67:
        return r104;
    L30:
        r137 = null;
        goto L31
    L26:
        r135 = null;
        goto L27
    L22:
        r130 = null;
    L7:
        r100 = new MmStandaloneAIInterpretationRepo$updateSetting$1(r110, r210);
        goto L8
    }

    public static final Object p(MmStandaloneAIInterpretationRepo r110, String r111, c r112, c r210, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r211, Continuation r212) {
        r110.getClass();
        if ((r212 instanceof MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1) == false) goto L7;
        MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1 r100 = (MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        int r106 = r100.I$2;
        int r107 = r100.I$1;
        int r108 = r100.I$0;
        ResultKt.throwOnFailure(r102);
    L71:
        int r109 = r106;
        int r113 = r108;
        int r114 = r107;
    L72:
        String r115 = r110.f435097l;
        StringBuilder r116 = new StringBuilder("[rollbackLanguageSwitch] closeAccepted=");
        if (r113 == 0) goto L75;
        boolean r117 = true;
    L76:
        r116.append(r117);
        r116.append(", sourceAccepted=");
        if (r114 == 0) goto L79;
        boolean r118 = true;
    L80:
        r116.append(r118);
        r116.append(", targetAccepted=");
        if (r109 == 0) goto L83;
        boolean r119 = true;
    L84:
        r116.append(r119);
        lvb.a.e(r115, r116.toString());
        if (r113 == 0) goto L90;
        if (r114 == 0) goto L90;
        if (r109 == 0) goto L90;
        r105 = true;
    L90:
        return Boxing.boxBoolean(r105);
    L83:
        r119 = false;
        goto L84
    L79:
        r118 = false;
        goto L80
    L75:
        r117 = false;
        goto L76
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r120 = r100.I$1;
        int r121 = r100.I$0;
        ResultKt.throwOnFailure(r102);
        r114 = r120;
        r113 = r121;
    L55:
        g r122 = (g) r102;
        if (r122 != null) goto L58;
    L60:
        r109 = 0;
    L61:
        if (r122 != null) goto L63;
    L65:
        boolean r123 = false;
    L66:
        if (r123 == false) goto L72;
        MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2 r124 = new MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$2(r110, r122, null);
        r100.I$0 = r113;
        r100.I$1 = r114;
        r100.I$2 = r109;
        r100.label = 4;
        if (r110.f433819e.b(r124, r100) == r103) goto L95;
        r108 = r113;
        r107 = r114;
        r106 = r109;
        goto L71
    L95:
        return r103;
    L63:
        if (r122.a() != true) goto L65;
        r123 = true;
        goto L66
    L58:
        if (r122.a() != true) goto L60;
        r109 = 1;
        goto L61
    L18:
        r113 = r100.I$0;
        c r125 = (c) r100.L$1;
        String r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r127 = ((Result) r102).m9458unboximpl();
    L34:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 == null) goto L38;
        lvb.a.b(r110.f435097l, "[rollbackLanguageSwitch] source failed: " + r128);
    L38:
        if (Result.m9455isFailureimpl(r127) == false) goto L40;
        r127 = null;
    L40:
        UpdateLiveRecordingSettingResponse r129 = (UpdateLiveRecordingSettingResponse) r127;
        if (r129 == null) goto L43;
        UpdateLiveRecordingSettingResponse.Status r130 = r129.mstatus;
    L45:
        if (r130 != UpdateLiveRecordingSettingResponse.Status.SUCCESS) goto L47;
        int r131 = 1;
    L49:
        if (r110.f435095j.g().a() == true) goto L51;
        lvb.a.e(r110.f435097l, "[rollbackLanguageSwitch] skip enabling old language, session ended");
        return Boxing.boxBoolean(false);
    L51:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.I$0 = r113;
        r100.I$1 = r131;
        r100.label = 3;
        Object r132 = r110.v(r126, true, r125, r100);
        if (r132 == r103) goto L94;
        r114 = r131;
        r102 = r132;
        goto L55
    L94:
        return r103;
    L47:
        r131 = 0;
        goto L49
    L43:
        r130 = null;
        goto L45
    L19:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r133 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r100.L$2;
        c r134 = (c) r100.L$1;
        String r135 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r136 = r102;
        c r137 = r134;
    L24:
        g r138 = (g) r136;
        if (r138 != null) goto L27;
    L29:
        int r139 = 0;
    L30:
        MmRecordingNetHelper r140 = r110.f435096k.G();
        r100.L$0 = r135;
        r100.L$1 = r137;
        r100.L$2 = null;
        r100.I$0 = r139;
        r100.label = 2;
        Object r141 = r140.e(r135, r133, r100);
        if (r141 == r103) goto L93;
        r126 = r135;
        c r142 = r137;
        r127 = r141;
        r113 = r139;
        r125 = r142;
        goto L34
    L93:
        return r103;
    L27:
        if (r138.a() != true) goto L29;
        r139 = 1;
        goto L30
    L20:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r111;
        r137 = r210;
        r100.L$1 = r137;
        r100.L$2 = r211;
        r100.label = 1;
        Object r143 = r110.v(r111, false, r112, r100);
        if (r143 == r103) goto L92;
        r135 = r111;
        r133 = r211;
        r136 = r143;
        goto L24
    L92:
        return r103;
    L7:
        r100 = new MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1(r110, r212);
        goto L8
    }
}
