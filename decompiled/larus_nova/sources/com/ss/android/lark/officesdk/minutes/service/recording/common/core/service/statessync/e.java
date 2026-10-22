package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingRoute;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.e0;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f434463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f434464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f434465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set<String> f434466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f434467g;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getNativeLocalBoundMeetingMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getPendingUploadCompletedSyncMeetingIds$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<Set<? extends String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getRecordingAudioPathMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends TypeToken<Map<String, ? extends String>> {
        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getStandaloneAIInterpretationRecordingIdMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C5172e extends TypeToken<Map<String, ? extends String>> {
        public C5172e() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$loadOfflineRecordingIndex$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends TypeToken<Map<String, Long>> {
        public f() {
        }
    }

    static {
    }

    public final Map<String, Long> x() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((Map) e0.b(this.f434461a.H().getString("minutes_recording_v2_offline_index_key", null), new f().getType()));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        lvb.a.b(this.f434462b, "[offlineIndex] load failed, err=" + r103.getMessage());
    L11:
        if (Result.m9455isFailureimpl(r102) == true) goto L14;
        r100 = r102;
    L14:
        Map<String, Long> r104 = (Map) r100;
        if (r104 == null) goto L17;
        return r104;
    L17:
        return new LinkedHashMap();
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Map<String, String> j() {
        if (this.f434465e != null) goto L8;
        Type r100 = new b().getType();
        Map<String, String> r101 = (Map) e0.b(this.f434461a.H().getString("minutes_recording_v2_native_local_bound_map_prefix", null), r100);
        if (r101 != null) goto L7;
        r101 = new HashMap();
    L7:
        this.f434465e = r101;
    L8:
        Map<String, String> r102 = this.f434465e;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return MapsKt.emptyMap();
    }

    public final Map<String, Long> m() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(MapsKt.toMap(x()));     // Catch: Throwable -> L4
    L6:
        Map r102 = MapsKt.emptyMap();
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return (Map) r101;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final Set<String> n() {
        if (this.f434466f != null) goto L19;
        Type r100 = new c().getType();
        String r101 = this.f434461a.H().getString("minutes_recording_v2_pending_upload_completed_sync_prefix", null);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Set r103 = (Set) e0.b(r101, r100);     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        Object r104 = CollectionsKt.toMutableSet(r103);     // Catch: Throwable -> L12
        if (r104 == null) goto L9;
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        lvb.a.b(this.f434462b, "[pendingUploadCompletedSync] parse failed, localCache:" + r101 + ", error:" + r106);
        this.f434461a.H().remove("minutes_recording_v2_pending_upload_completed_sync_prefix");
        r105 = new HashSet();
    L18:
        this.f434466f = (Set) r105;
    L9:
        r104 = new HashSet();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        Set<String> r108 = this.f434466f;
        if (r108 != null) goto L22;
        r108 = SetsKt.emptySet();
    L22:
        lvb.a.e(this.f434462b, "[pendingUploadCompletedSync] get, meetingIds:" + r108);
        return r108;
    }

    public final Map<String, String> p() {
        if (this.f434464d != null) goto L8;
        Type r100 = new d().getType();
        Map<String, String> r101 = (Map) e0.b(this.f434461a.H().getString("minutes_recording_v2_audio_path_map_prefix", null), r100);
        if (r101 != null) goto L7;
        r101 = new HashMap();
    L7:
        this.f434464d = r101;
    L8:
        Map<String, String> r102 = this.f434464d;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return MapsKt.emptyMap();
    }

    public final Map<String, String> v() {
        if (this.f434467g != null) goto L8;
        Type r100 = new C5172e().getType();
        Map<String, String> r101 = (Map) e0.b(this.f434461a.H().getString("minutes_recording_v2_standalone_ai_interpretation_recording_id_map_prefix", null), r100);
        if (r101 != null) goto L7;
        r101 = new HashMap();
    L7:
        this.f434467g = r101;
    L8:
        Map<String, String> r102 = this.f434467g;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return MapsKt.emptyMap();
    }

    public e(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        this.f434461a = r100;
        this.f434462b = "MmRecordingStatesLocalStorage";
    }

    public final void A(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        if (this.f434463c != null) goto L6;
        this.f434463c = new HashMap();     // Catch: Throwable -> L12
    L6:
        Map<String, String> r102 = this.f434463c;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.putAll(r100);     // Catch: Throwable -> L12
        lvb.a.e(this.f434462b, "putMeetingIdTokenMapping, meetingId2TokenMap:" + r102);     // Catch: Throwable -> L12
        this.f434461a.H().putString("minutes_recording_v2_meeting_map_prefix", e0.c(r102));     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L12
        return;
    L9:
        r103 = null;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void B(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionKey");
        if (StringsKt.isBlank(r100) == false) goto L21;
        return;
    L21:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Map<String, Long> r102 = x();     // Catch: Throwable -> L18
        if (r102.remove(r100) == null) goto L8;
        y(r102);     // Catch: Throwable -> L18
        lvb.a.e(this.f434462b, "[offlineIndex] remove, sessionKey:" + r100);     // Catch: Throwable -> L18
    L8:
        Intrinsics.checkNotNullParameter(r100, "sessionKey");     // Catch: Throwable -> L18
        if (StringsKt.isBlank(r100) == true) goto L13;
        this.f434461a.H().remove("minutes_recording_v2_offline_audio_path_" + r100);     // Catch: Throwable -> L18
    L13:
        if (StringsKt.isBlank(r100) == true) goto L16;
        this.f434461a.H().remove("minutes_recording_v2_offline_hardware_device_id_".concat(r100));     // Catch: Throwable -> L18
    L16:
        d(r100);     // Catch: Throwable -> L18
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        lvb.a.e(this.f434462b, "clearDoubaoBizInfo, meetingId:" + r100);
        this.f434461a.H().remove("minutes_recording_v2_doubao_biz_info_prefix" + r100);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        if (StringsKt.isBlank(r100) == false) goto L13;
        return;
    L13:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Set<String> r102 = CollectionsKt.toMutableSet(n());     // Catch: Throwable -> L7
        r102.remove(r100);     // Catch: Throwable -> L7
        this.f434466f = r102;     // Catch: Throwable -> L7
        lvb.a.e(this.f434462b, "[pendingUploadCompletedSync] clear, meetingId:" + r100 + ", meetingIds:" + r102);     // Catch: Throwable -> L7
        this.f434461a.H().putString("minutes_recording_v2_pending_upload_completed_sync_prefix", e0.c(r102));     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        lvb.a.b(this.f434462b, "[pendingUploadCompletedSync] clear failed, meetingId:" + r100 + ", error:" + r104);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (StringsKt.isBlank(r100) == false) goto L10;
        return;
    L10:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Map<String, String> r102 = MapsKt.toMutableMap(p());     // Catch: Throwable -> L7
        r102.remove(r100);     // Catch: Throwable -> L7
        this.f434464d = r102;     // Catch: Throwable -> L7
        lvb.a.e(this.f434462b, "[recordingAudioPath] clear, recordingId:" + r100);     // Catch: Throwable -> L7
        this.f434461a.H().putString("minutes_recording_v2_audio_path_map_prefix", e0.c(r102));     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        lvb.a.e(this.f434462b, "[recordingSource] clear, meetingId:" + r100);
        this.f434461a.H().remove("minutes_recording_v2_source_prefix" + r100);
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        lvb.a.e(this.f434462b, "[recordingTraceId] clear, recordingId:" + r100);
        this.f434461a.H().remove("minutes_recording_v2_trace_id_prefix" + r100);
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        if (StringsKt.isBlank(r100) == false) goto L13;
        return;
    L13:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Map<String, String> r102 = MapsKt.toMutableMap(v());     // Catch: Throwable -> L7
        r102.remove(r100);     // Catch: Throwable -> L7
        this.f434467g = r102;     // Catch: Throwable -> L7
        lvb.a.e(this.f434462b, "[standaloneAIInterpretationRecordingId] clear, meetingId:" + r100);     // Catch: Throwable -> L7
        this.f434461a.H().putString("minutes_recording_v2_standalone_ai_interpretation_recording_id_map_prefix", e0.c(r102));     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        lvb.a.b(this.f434462b, "[standaloneAIInterpretationRecordingId] clear failed, meetingId:" + r100 + ", error:" + r104);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        lvb.a.e(this.f434462b, "[standaloneAIInterpretationSaveArtifact] clear, recordingId:".concat(r100));
        this.f434461a.H().remove("minutes_recording_v2_standalone_ai_interpretation_save_artifact_prefix".concat(r100));
    }

    public final DoubaoBizInfo h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        String r103 = this.f434461a.H().getString("minutes_recording_v2_doubao_biz_info_prefix" + r100, null);     // Catch: Throwable -> L8
        if (r103 != null) goto L6;
        return null;
    L6:
        Gson r104 = e0.f444707a;     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl((DoubaoBizInfo) e0.a(r103, DoubaoBizInfo.class));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        return (DoubaoBizInfo) r101;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final String i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionKey");
        String r101 = j().get(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        lvb.a.e(this.f434462b, "[nativeLocalBoundMeeting] get, sessionKey:" + r100 + ", meetingId:" + r101);
        return r101;
    }

    public final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionKey");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return "";
    L5:
        String r101 = this.f434461a.H().getString("minutes_recording_v2_offline_audio_path_" + r100, null);
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public final String l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionKey");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return "";
    L5:
        String r101 = this.f434461a.H().getString("minutes_recording_v2_offline_hardware_device_id_" + r100, null);
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public final String o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        String r101 = p().get(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        lvb.a.e(this.f434462b, "[recordingAudioPath] get, recordingId:" + r100 + ", audioFilePath:" + r101);
        return r101;
    }

    public final MmRecordingRoute q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        String r101 = this.f434461a.H().getString("minutes_recording_v2_route_prefix".concat(r100), null);
        MmRecordingRoute.Companion.getClass();
        MmRecordingRoute[] r102 = MmRecordingRoute.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        MmRecordingRoute r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getStorageValue(), r101) == true) goto L8;
        r104 = r104 + 1;
        goto L3
    L8:
        return r105;
    L11:
        return null;
    }

    public final MmRecordingSource r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        MmRecordingSource r101 = null;
        Object r102 = null;
        String r103 = this.f434461a.H().getString("minutes_recording_v2_source_prefix" + r100, null);
        if (r103 != null) goto L15;
    L13:
        lvb.a.e(this.f434462b, "[recordingSource] get, meetingId:" + r100 + ", source:" + r101);
        return r101;
    L15:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L6
        Object r105 = Result.m9449constructorimpl(MmRecordingSource.valueOf(r103));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r105) == true) goto L12;
        r102 = r105;
    L12:
        r101 = (MmRecordingSource) r102;
    L6:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final String s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        String r101 = "";
        if (StringsKt.isBlank(r100) == false) goto L5;
        return "";
    L5:
        String r102 = this.f434461a.H().getString("minutes_recording_v2_trace_id_prefix".concat(r100), null);
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        lvb.a.e(this.f434462b, "[recordingTraceId] get, recordingId:" + r100 + ", traceId:" + r101);
        return r101;
    }

    public final String t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        String r101 = this.f434461a.H().getString("minutes_recording_v2_source_session_key_prefix" + r100, null);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        lvb.a.e(this.f434462b, "[sourceSessionKey] get, meetingId:" + r100 + ", sessionKey:" + r101);
        return r101;
    }

    public final String u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        String r101 = "";
        if (StringsKt.isBlank(r100) == false) goto L5;
        return "";
    L5:
        String r102 = v().get(r100);
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        lvb.a.e(this.f434462b, "[standaloneAIInterpretationRecordingId] get, meetingId:" + r100 + ", recordingId:" + r101);
        return r101;
    }

    public final boolean w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        boolean r101 = this.f434461a.H().getBoolean("minutes_recording_v2_standalone_ai_interpretation_save_artifact_prefix" + r100, false);
        lvb.a.e(this.f434462b, "[standaloneAIInterpretationSaveArtifact] get, recordingId:" + r100 + ", saveArtifact:" + r101);
        return r101;
    }

    public final void y(Map<String, Long> r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        this.f434461a.H().putString("minutes_recording_v2_offline_index_key", e0.c(r100));     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        lvb.a.b(this.f434462b, "[offlineIndex] persist failed, err=" + r103.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void C(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "audioFilePath");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, String> r103 = MapsKt.toMutableMap(p());     // Catch: Throwable -> L9
        r103.put(r100, r101);     // Catch: Throwable -> L9
        this.f434464d = r103;     // Catch: Throwable -> L9
        lvb.a.e(this.f434462b, "[recordingAudioPath] save, recordingId:" + r100 + ", audioFilePath:" + r101);     // Catch: Throwable -> L9
        this.f434461a.H().putString("minutes_recording_v2_audio_path_map_prefix", e0.c(r103));     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L18;
        lvb.a.b(this.f434462b, "[recordingAudioPath] save failed, recordingId:" + r100 + ", error:" + r105);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void D(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L10;
        lvb.a.e(this.f434462b, "[recordingTraceId] save, recordingId:" + r100 + ", traceId:" + r101);
        KVRepo r102 = this.f434461a.H();
        StringBuilder r103 = new StringBuilder("minutes_recording_v2_trace_id_prefix");
        r103.append(r100);
        r102.putString(r103.toString(), r101);
        return;
    }

    public final void E(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        Intrinsics.checkNotNullParameter(r101, "sessionKey");
        lvb.a.e(this.f434462b, "[sourceSessionKey] save, meetingId:" + r100 + ", sessionKey:" + r101);
        KVRepo r102 = this.f434461a.H();
        StringBuilder r103 = new StringBuilder("minutes_recording_v2_source_session_key_prefix");
        r103.append(r100);
        r102.putString(r103.toString(), r101);
    }

    public final void F(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        lvb.a.e(this.f434462b, "[standaloneAIInterpretationSaveArtifact] save, recordingId:" + r100 + ", saveArtifact:" + r101);
        KVRepo r102 = this.f434461a.H();
        StringBuilder r103 = new StringBuilder("minutes_recording_v2_standalone_ai_interpretation_save_artifact_prefix");
        r103.append(r100);
        r102.putBoolean(r103.toString(), r101);
    }

    public final void z(String r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r101) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f434461a.H().putInt("minutes_recording_v2_local_state_" + r100, r101.f434644a);
    }
}
