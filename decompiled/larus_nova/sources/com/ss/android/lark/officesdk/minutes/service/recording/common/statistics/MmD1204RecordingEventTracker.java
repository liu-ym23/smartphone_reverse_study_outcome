package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwarePlaybackState;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.y;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmD1204RecordingEventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f435396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.a f435397c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f435398a = 0;

        static {
            int[] r100 = new int[HardwarePlaybackState.values().length];
            r100[HardwarePlaybackState.SYS_CALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            r100[HardwarePlaybackState.APP_CALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L22:
            r100[HardwarePlaybackState.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            r100[HardwarePlaybackState.IDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L18:
            r100[HardwarePlaybackState.OTHER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
    }

    public MmD1204RecordingEventTracker(MinutesUCCImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "userContext");
        this.f435395a = r100;
        this.f435396b = kotlinx.coroutines.sync.b.a();
        this.f435397c = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.a(r100);
    }

    public static boolean f(JSONObject r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Statistics.sendEvent("vc_hardware_audio_feature_status", r100);     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L9;
        lvb.a.b("MmD1204RecordingEventTracker", "[sendAudioFeatureStatus] failed, error=" + r103);
    L9:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r104;
    L13:
        return ((Boolean) r102).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void e(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r210) {
        if (r210.f435407h == false) goto L55;
        boolean r100 = true;
        boolean r101 = false;
        if ((!StringsKt.isBlank(r210.f435401b)) == true) goto L7;
    L11:
        r100 = false;
    L12:
        if (r100 == false) goto L56;
        String r102 = r210.f435403d;
        HardwareRecordSource[] r103 = HardwareRecordSource.values();
        int r104 = r103.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L20;
        HardwareRecordSource r106 = r103[r105];
        if (Intrinsics.areEqual(r106.getTrackValue(), r102) == true) goto L22;
        r105 = r105 + 1;
    L22:
        if (StringsKt.isBlank(r210.f435402c) == true) goto L50;
        if (r106 == null) goto L50;
        String r107 = r210.f435401b;
        String r110 = r210.f435400a;
        String r108 = r210.f435402c;
        String r109 = r210.f435408i;
        if (StringsKt.isBlank(r107) == false) goto L28;
    L45:
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: recording_identity_missing");
    L46:
        lvb.a.e("MmD1204RecordingEventTracker", "[reportOnlineIfReady] report finished, keyHash=" + r210.f435400a.hashCode() + ", source=" + r106.getTrackValue() + ", reported=" + r101);
        if (r101 == false) goto L54;
        this.f435397c.c(r210.f435400a);
        return;
    L54:
        return;
    L28:
        if (StringsKt.isBlank(r110) == true) goto L45;
        if (StringsKt.isBlank(r109) == true) goto L45;
        MmRecordingCommonParam r111 = this.f435395a.N().b(r107);
        if (r111 != null) goto L36;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: track_context_missing");
        goto L46
    L36:
        if (r111.isValid() == true) goto L39;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: track_context_invalid");
        goto L46
    L39:
        if (StringsKt.isBlank(r111.getToken()) == false) goto L41;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: legacy_recording_identity_missing");
        goto L46
    L41:
        JSONObject r112 = a(r110, r108, r106.getTrackValue(), "earphone");
        if (r112 == null) goto L46;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r113 = MmRecordingCommonParam.copy$default(r111, null, r110, true, null, null, null, null, MmRecordingSource.FEISHU_HARDWARE_D1204, null, null, null, 1913, null).asTrackerParams();
        r113.f(r112);
        JSONObject r114 = r113.a();
        lvb.a.e("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] report, source=" + r106.getTrackValue() + ", hasRecordId=true, hasConferenceId=true, hasToken=true, vcRecordingIdEmpty=true");
        r101 = f(r114);
    L50:
        lvb.a.e("MmD1204RecordingEventTracker", "[reportOnlineIfReady] skip: recording_source_missing");
        return;
    L20:
        r106 = null;
        goto L22
    L56:
        return;
    L7:
        if ((!StringsKt.isBlank(r210.f435408i)) == false) goto L11;
        if (r210.f435409j == false) goto L11;
    }

    public final Object b(String r100, String r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof MmD1204RecordingEventTracker$clear$1) == false) goto L7;
        MmD1204RecordingEventTracker$clear$1 r103 = (MmD1204RecordingEventTracker$clear$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r103.L$2;
        r101 = (String) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
        kotlinx.coroutines.sync.a r110 = r108;
        r100 = r109;
    L27:
        this.f435397c.c(r100);     // Catch: Throwable -> L24
        lvb.a.e("MmD1204RecordingEventTracker", "[clear] keyHash=" + r100.hashCode() + ", reason=" + r101);     // Catch: Throwable -> L24
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r110.unlock(null);
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (StringsKt.isBlank(r100) == true) goto L17;
        r110 = this.f435396b;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.L$2 = r110;
        r103.label = 1;
        if (r110.a(null, r103) != r106) goto L27;
        return r106;
    L17:
        return Unit.INSTANCE;
    L7:
        r103 = new MmD1204RecordingEventTracker$clear$1(this, r102);
        goto L8
    }

    public final Object c(String r210, String r211, Continuation<? super Unit> r212) {
        if ((r212 instanceof MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1) == false) goto L7;
        MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1 r100 = (MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r100.L$2;
        String r106 = (String) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L74:
    L33:
        th = move-exception;
        r105.unlock(null);
        throw th;
    L20:
        if (StringsKt.isBlank(r107) == false) goto L22;
    L66:
        lvb.a.h("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: offline_identity_missing");     // Catch: Throwable -> L33
    L67:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r105.unlock(null);
        return Unit.INSTANCE;
    L22:
        if (StringsKt.isBlank(r106) == true) goto L66;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r110 = this.f435397c.a(r107);     // Catch: Throwable -> L33
        if (r110 != null) goto L27;
        lvb.a.e("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: legacy_metadata_missing");     // Catch: Throwable -> L33
        goto L67
    L27:
        String r109 = r110.f435403d;     // Catch: Throwable -> L33
        HardwareRecordSource[] r111 = HardwareRecordSource.values();     // Catch: Throwable -> L33
        int r112 = r111.length;     // Catch: Throwable -> L33
        int r113 = 0;
    L28:
        if (r113 >= r112) goto L35;
        HardwareRecordSource r114 = r111[r113];     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(r114.getTrackValue(), r109) == true) goto L31;
        r113 = r113 + 1;     // Catch: Throwable -> L33
        goto L28
    L31:
        HardwareRecordSource r213 = r114;
    L37:
        if (r110.f435407h == true) goto L39;
    L65:
        this.f435397c.c(r107);     // Catch: Throwable -> L33
        lvb.a.e("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: recording_source_missing");     // Catch: Throwable -> L33
        goto L67
    L39:
        if (StringsKt.isBlank(r110.f435402c) == true) goto L65;
        if (r213 == null) goto L65;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L44
        Object r116 = Result.m9449constructorimpl(y.b(r106));     // Catch: Throwable -> L44
    L46:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L33
        if (r117 == null) goto L50;
        lvb.a.b("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: token_encrypt_failed, error=" + r117);     // Catch: Throwable -> L33
    L50:
        if (Result.m9455isFailureimpl(r116) == false) goto L52;
        r116 = null;
    L52:
        String r118 = (String) r116;     // Catch: Throwable -> L33
        if (r118 != null) goto L55;
        r118 = "";
    L55:
        String r119 = r118;
        if (StringsKt.isBlank(r119) == true) goto L67;
        String r120 = r107;
        boolean r121 = g(new MmRecordingCommonParam(r119, r107, true, "FEISHU_HARDWARE_D1204", "", r110.f435405f, r110.f435404e, MmRecordingSource.FEISHU_HARDWARE_D1204, r110.f435406g, null, null, ISmModel.VERSION_0600, null), r120, r110.f435402c, r213.getTrackValue(), "earphone", true);     // Catch: Throwable -> L33
        StringBuilder r122 = new StringBuilder("[onOfflineUploadSucceeded] report finished, keyHash=");     // Catch: Throwable -> L33
        r122.append(r107.hashCode());     // Catch: Throwable -> L33
        r122.append(", source=");     // Catch: Throwable -> L33
        r122.append(r213.getTrackValue());     // Catch: Throwable -> L33
        r122.append(", reported=");     // Catch: Throwable -> L33
        if (r121 == false) goto L61;
        boolean r123 = true;
    L62:
        r122.append(r123);     // Catch: Throwable -> L33
        lvb.a.e("MmD1204RecordingEventTracker", r122.toString());     // Catch: Throwable -> L33
        if (r121 == false) goto L67;
        this.f435397c.c(r107);     // Catch: Throwable -> L33
        goto L67
    L61:
        r123 = false;
        goto L62
    L44:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L33
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L46
    L35:
        r213 = null;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        MutexImpl r125 = this.f435396b;
        r100.L$0 = r210;
        r100.L$1 = r211;
        r100.L$2 = r125;
        r100.label = 1;
        if (r125.a(null, r100) != r103) goto L17;
        return r103;
    L17:
        r105 = r125;
        r107 = r210;
        r106 = r211;
    L7:
        r100 = new MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1(this, r212);
        goto L8
    }

    public static JSONObject a(String r100, String r101, String r102, String r103) {
        if (StringsKt.isBlank(r101) == false) goto L7;
        lvb.a.h("MmD1204RecordingEventTracker", "[buildAudioFeatureStatusParams] skip: device_id_invalid");
        return null;
    L7:
        if (StringsKt.startsWith$default(r101, "anker_d1204_", false, 2, null) == true) goto L25;
        r101 = "anker_d1204_" + r101;
    L25:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(y.b(r101));     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        lvb.a.b("MmD1204RecordingEventTracker", "[buildAudioFeatureStatusParams] skip: encrypt_failed, error=" + r106);
    L18:
        if (Result.m9455isFailureimpl(r105) == false) goto L20;
        r105 = "";
    L20:
        String r107 = (String) r105;
        Intrinsics.checkNotNull(r107);
        if (StringsKt.isBlank(r107) == false) goto L23;
        return null;
    L23:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r108 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r108.e("record_id", r100);
        r108.e("vc_recording_id", "");
        r108.e("hardware_device_id", r107);
        r108.e("hardware_device_type", "D1204");
        r108.e("record_device", r103);
        r108.e("recording_source", r102);
        return r108.a();
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final Object d(String r110, String r210, String r211, String r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof MmD1204RecordingEventTracker$onOnlineTokenReady$1) == false) goto L7;
        MmD1204RecordingEventTracker$onOnlineTokenReady$1 r100 = (MmD1204RecordingEventTracker$onOnlineTokenReady$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r100.L$4;
        String r106 = (String) r100.L$3;
        String r107 = (String) r100.L$2;
        String r108 = (String) r100.L$1;
        String r109 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r111 = r106;
        String r112 = r107;
    L39:
    L36:
        th = move-exception;
        r105.unlock(null);
        throw th;
    L20:
        if (StringsKt.isBlank(r109) == false) goto L22;
    L32:
        lvb.a.h("MmD1204RecordingEventTracker", "[onOnlineTokenReady] skip: online_identity_missing");     // Catch: Throwable -> L36
    L33:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L36
        r105.unlock(null);
        return Unit.INSTANCE;
    L22:
        if (StringsKt.isBlank(r108) == true) goto L32;
        if (StringsKt.isBlank(r112) == true) goto L32;
        if (StringsKt.isBlank(r111) == true) goto L32;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r114 = this.f435397c.a(r109);     // Catch: Throwable -> L36
        if (r114 != null) goto L31;
        r114 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b(r109, 1022);     // Catch: Throwable -> L36
    L31:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r115 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b.a(r114, r108, null, null, null, null, null, false, r112, true, 253);     // Catch: Throwable -> L36
        this.f435397c.b(r115);     // Catch: Throwable -> L36
        lvb.a.e("MmD1204RecordingEventTracker", "[onOnlineTokenReady] online signal saved, keyHash=" + r109.hashCode() + ", hardwareStarted=" + r115.f435407h);     // Catch: Throwable -> L36
        e(r115);     // Catch: Throwable -> L36
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        MutexImpl r116 = this.f435396b;
        r100.L$0 = r110;
        r108 = r210;
        r100.L$1 = r108;
        r100.L$2 = r211;
        r111 = r212;
        r100.L$3 = r111;
        r100.L$4 = r116;
        r100.label = 1;
        if (r116.a(null, r100) != r103) goto L17;
        return r103;
    L17:
        r105 = r116;
        r109 = r110;
        r112 = r211;
    L7:
        r100 = new MmD1204RecordingEventTracker$onOnlineTokenReady$1(this, r213);
        goto L8
    }

    public static boolean g(MmRecordingCommonParam r100, String r101, String r102, String r103, String r104, boolean r105) {
        if (StringsKt.isBlank(r101) == false) goto L6;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOffline] skip: recording_identity_missing");
        return false;
    L6:
        JSONObject r106 = a(r101, r102, r103, r104);
        if (r106 != null) goto L9;
        return false;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r107 = r100.asTrackerParams();
        r107.f(r106);
        JSONObject r108 = r107.a();
        lvb.a.e("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOffline] report, source=" + r103 + ", recordDevice=" + r104 + ", hasRecordId=true, hasToken=" + r105 + ", conferenceIdEmpty=true, vcRecordingIdEmpty=true");
        return f(r108);
    }
}
