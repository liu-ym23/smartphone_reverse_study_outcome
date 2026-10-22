package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.utils.y;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010%\u001a\u00020\u0006J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003Jy\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u000e\u0010!\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\u0013¨\u0006@"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/core/MmRecordingCommonParam;", "Ljava/io/Serializable;", "token", "", "recordId", "isHardware", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "meetingId", "userId", "recordingTraceId", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "tenantId", "vcRecordingId", InteractConst.WAKEUP_SESSION_TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getRecordId", "()Z", "getEntrance", "getMeetingId", "getUserId", "getRecordingTraceId", "getSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "getTenantId", "getVcRecordingId", "getSessionType", "encryptedUserId", "getEncryptedUserId", "encryptedTenantId", "createSourceForTracker", "trackerRecordId", "getTrackerRecordId", "isValid", "withRecordingIdReady", "recordingId", "asTrackerParams", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/core/MmRecordingTrackerParams;", "asRecordingDevTrackerParams", "putCommonParamsTo", "Lorg/json/JSONObject;", "jsonObject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingCommonParam implements Serializable {
    private final String createSourceForTracker;
    private final String encryptedTenantId;
    private final String encryptedUserId;
    private final String entrance;
    private final boolean isHardware;
    private final String meetingId;
    private final String recordId;
    private final String recordingTraceId;
    private final String sessionType;
    private final MmRecordingSource source;
    private final String tenantId;
    private final String token;
    private final String userId;
    private final String vcRecordingId;

    public MmRecordingCommonParam() {
        this(null, null, false, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ MmRecordingCommonParam copy$default(MmRecordingCommonParam r110, String r111, String r112, boolean r113, String r114, String r115, String r116, String r117, MmRecordingSource r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.token;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.recordId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r102 = r110.isHardware;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.entrance;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.meetingId;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.userId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.recordingTraceId;
    L31:
        if ((r214 & 128) == 0) goto L33;
        MmRecordingSource r107 = r110.source;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.tenantId;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.vcRecordingId;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.sessionType;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.token;
    }

    public final String component10() {
        return this.vcRecordingId;
    }

    public final String component11() {
        return this.sessionType;
    }

    public final String component2() {
        return this.recordId;
    }

    public final boolean component3() {
        return this.isHardware;
    }

    public final String component4() {
        return this.entrance;
    }

    public final String component5() {
        return this.meetingId;
    }

    public final String component6() {
        return this.userId;
    }

    public final String component7() {
        return this.recordingTraceId;
    }

    public final MmRecordingSource component8() {
        return this.source;
    }

    public final String component9() {
        return this.tenantId;
    }

    public final MmRecordingCommonParam copy(String r110, String r111, boolean r112, String r113, String r114, String r115, String r210, MmRecordingSource r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r111, "recordId");
        Intrinsics.checkNotNullParameter(r113, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r114, "meetingId");
        Intrinsics.checkNotNullParameter(r115, "userId");
        Intrinsics.checkNotNullParameter(r210, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r212, "tenantId");
        Intrinsics.checkNotNullParameter(r213, "vcRecordingId");
        Intrinsics.checkNotNullParameter(r214, InteractConst.WAKEUP_SESSION_TYPE);
        return new MmRecordingCommonParam(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordingCommonParam) == true) goto L8;
        return false;
    L8:
        MmRecordingCommonParam r101 = (MmRecordingCommonParam) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recordId, r101.recordId) == true) goto L15;
        return false;
    L15:
        if (this.isHardware == r101.isHardware) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entrance, r101.entrance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.meetingId, r101.meetingId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.recordingTraceId, r101.recordingTraceId) == true) goto L30;
        return false;
    L30:
        if (this.source == r101.source) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.vcRecordingId, r101.vcRecordingId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sessionType, r101.sessionType) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.token.hashCode() * 31) + this.recordId.hashCode()) * 31;
        if (this.isHardware == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((((((r100 + r101) * 31) + this.entrance.hashCode()) * 31) + this.meetingId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.recordingTraceId.hashCode()) * 31;
        MmRecordingSource r103 = this.source;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((((((r102 + r104) * 31) + this.tenantId.hashCode()) * 31) + this.vcRecordingId.hashCode()) * 31) + this.sessionType.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "MmRecordingCommonParam(token=" + this.token + ", recordId=" + this.recordId + ", isHardware=" + this.isHardware + ", entrance=" + this.entrance + ", meetingId=" + this.meetingId + ", userId=" + this.userId + ", recordingTraceId=" + this.recordingTraceId + ", source=" + this.source + ", tenantId=" + this.tenantId + ", vcRecordingId=" + this.vcRecordingId + ", sessionType=" + this.sessionType + ')';
    }

    public final d asRecordingDevTrackerParams() {
        if (Intrinsics.areEqual(this.sessionType, "STANDALONE_AI_INTERPRETATION") == true) goto L13;
        MmRecordingSource r100 = this.source;
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.isStandaloneAIInterpretationSource() != true) goto L9;
    L10:
        if (r101 == true) goto L13;
        String r102 = "record";
    L14:
        d r103 = asTrackerParams();
        r103.e("scene", r102);
        return r103;
    L9:
        r101 = false;
    L13:
        r102 = "independent_si";
        goto L14
    }

    public final d asTrackerParams() {
        d r100 = new d();
        r100.e("token", this.token);
        r100.e("record_id", getTrackerRecordId());
        r100.e("vc_recording_id", this.vcRecordingId);
        r100.e("recording_trace_id", this.recordingTraceId);
        r100.e("lark_user_unique_id", this.encryptedUserId);
        r100.e("is_hardware", String.valueOf(this.isHardware));
        r100.e("conference_id", this.meetingId);
        r100.e("create_app", this.createSourceForTracker);
        r100.e("session_type", this.sessionType);
        MmRecordingSource r101 = this.source;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isFeishuHost() != true) goto L7;
    L8:
        if (r102 == true) goto L10;
        r100.e("tenant_id", this.encryptedTenantId);
    L10:
        return r100;
    L7:
        r102 = false;
        goto L8
    }

    public final String getTrackerRecordId() {
        if (this.isHardware == false) goto L6;
        return this.recordId;
    L6:
        return this.meetingId;
    }

    public final boolean isValid() {
        if (this.meetingId.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public final String getEntrance() {
        return this.entrance;
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getRecordingTraceId() {
        return this.recordingTraceId;
    }

    public final String getSessionType() {
        return this.sessionType;
    }

    public final MmRecordingSource getSource() {
        return this.source;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVcRecordingId() {
        return this.vcRecordingId;
    }

    public final boolean isHardware() {
        return this.isHardware;
    }

    public final JSONObject putCommonParamsTo(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        r100.put("token", this.token);     // Catch: Throwable -> L15
        r100.put("record_id", getTrackerRecordId());     // Catch: Throwable -> L15
        r100.put("vc_recording_id", this.vcRecordingId);     // Catch: Throwable -> L15
        r100.put("recording_trace_id", this.recordingTraceId);     // Catch: Throwable -> L15
        r100.put("is_hardware", String.valueOf(this.isHardware));     // Catch: Throwable -> L15
        r100.put("lark_user_unique_id", this.encryptedUserId);     // Catch: Throwable -> L15
        r100.put("conference_id", this.meetingId);     // Catch: Throwable -> L15
        r100.put("create_app", this.createSourceForTracker);     // Catch: Throwable -> L15
        r100.put("session_type", this.sessionType);     // Catch: Throwable -> L15
        MmRecordingSource r103 = this.source;     // Catch: Throwable -> L15
        boolean r104 = false;
        if (r103 != null) goto L6;
    L8:
        if (r104 == true) goto L10;
        r100.put("tenant_id", this.encryptedTenantId);     // Catch: Throwable -> L15
    L10:
        if (r101 == null) goto L12;
        JSONObject r105 = r100.put("source", r101);     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L17:
        return r100;
    L12:
        r105 = null;
        goto L13
    L6:
        if (r103.isFeishuHost() != true) goto L8;
        r104 = true;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final MmRecordingCommonParam withRecordingIdReady(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "recordingId");
        Intrinsics.checkNotNullParameter(r111, "meetingId");
        return copy$default(this, null, null, false, null, r111, null, null, null, null, r110, null, 1519, null);
    }

    public static /* synthetic */ JSONObject putCommonParamsTo$default(MmRecordingCommonParam r100, JSONObject r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.putCommonParamsTo(r101, r102);
    }

    public static /* synthetic */ MmRecordingCommonParam withRecordingIdReady$default(MmRecordingCommonParam r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r100.meetingId;
    L6:
        return r100.withRecordingIdReady(r101, r102);
    }

    public MmRecordingCommonParam(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106, MmRecordingSource r107, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "recordId");
        Intrinsics.checkNotNullParameter(r103, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r104, "meetingId");
        Intrinsics.checkNotNullParameter(r105, "userId");
        Intrinsics.checkNotNullParameter(r106, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r110, "tenantId");
        Intrinsics.checkNotNullParameter(r111, "vcRecordingId");
        Intrinsics.checkNotNullParameter(r112, InteractConst.WAKEUP_SESSION_TYPE);
        this.token = r100;
        this.recordId = r101;
        this.isHardware = r102;
        this.entrance = r103;
        this.meetingId = r104;
        this.userId = r105;
        this.recordingTraceId = r106;
        this.source = r107;
        this.tenantId = r110;
        this.vcRecordingId = r111;
        this.sessionType = r112;
        this.encryptedUserId = y.b(r105);
        this.encryptedTenantId = y.b(r110);
        if (r107 == null) goto L6;
        String r108 = r107.toTrackSource();
        if (r108 == null) goto L6;
    L7:
        this.createSourceForTracker = r108;
        return;
    L6:
        r108 = "";
        goto L7
    }

    public /* synthetic */ MmRecordingCommonParam(String r110, String r111, boolean r112, String r113, String r114, String r115, String r116, MmRecordingSource r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = "";
        if ((r214 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r214 & 128) == 0) goto L33;
        MmRecordingSource r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = "";
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = "";
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
