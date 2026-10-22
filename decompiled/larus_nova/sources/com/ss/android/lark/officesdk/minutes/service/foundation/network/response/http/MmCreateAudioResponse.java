package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lvb.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010)\"\u0004\b0\u0010+R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;", "Ljava/io/Serializable;", "objectToken", "", "meetingId", "topic", DyPayConstant.KEY_START_TIME, "", "stopTime", "duration", "canAudioCreateRetry", "", "finalAudioType", "", "isForceSaveAudio", "forceSaveReason", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "benefitCenterUrl", "recordingId", "associatedIds", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZIZLjava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;)V", "getObjectToken", "()Ljava/lang/String;", "setObjectToken", "(Ljava/lang/String;)V", "getMeetingId", "setMeetingId", "getTopic", "setTopic", "getStartTime", "()J", "setStartTime", "(J)V", "getStopTime", "setStopTime", "getDuration", "setDuration", "getCanAudioCreateRetry", "()Z", "setCanAudioCreateRetry", "(Z)V", "getFinalAudioType", "()I", "setFinalAudioType", "(I)V", "setForceSaveAudio", "getForceSaveReason", "setForceSaveReason", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "setUnavailableReason", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;)V", "getBenefitCenterUrl", "setBenefitCenterUrl", "getRecordingId", "setRecordingId", "getAssociatedIds", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;", "setAssociatedIds", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;)V", "normalizeObjectToken", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmCreateAudioResponse implements Serializable {

    @SerializedName("associated_ids")
    private MmAssociatedIds associatedIds;

    @SerializedName("benefit_center_url")
    private String benefitCenterUrl;

    @SerializedName("can_retry")
    private boolean canAudioCreateRetry;
    private long duration;

    @SerializedName("final_audio_type")
    private int finalAudioType;

    @SerializedName("force_save_reason")
    private String forceSaveReason;

    @SerializedName("is_force_save")
    private boolean isForceSaveAudio;

    @SerializedName("meeting_id")
    private String meetingId;

    @SerializedName("object_token")
    private String objectToken;

    @SerializedName("recording_id")
    private String recordingId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName(ILoadStallMonitor.STOP_TIME)
    private long stopTime;
    private String topic;

    @SerializedName("unavailable_reason")
    private d unavailableReason;

    public MmCreateAudioResponse() {
        this(null, null, null, 0, 0, 0, false, 0, false, null, null, null, null, null, 16383, null);
    }

    public final void normalizeObjectToken() {
        MmAssociatedIds r100 = this.associatedIds;
        if (r100 == null) goto L17;
        String r101 = r100.getObjectToken();
        if (r101 == null) goto L17;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L17;
        if (r102.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
    L18:
        this.objectToken = r102;
        return;
    L11:
        r103 = false;
    L17:
        r102 = this.objectToken;
        goto L18
    }

    public String toString() {
        return "MmCreateAudioResponse(objectToken='" + a.d(this.objectToken) + "', recordingId='" + this.recordingId + "', meetingId='" + this.meetingId + "', topic='" + this.topic + "', startTime=" + this.startTime + ", stopTime=" + this.stopTime + ", duration=" + this.duration + ", canAudioCreateRetry=" + this.canAudioCreateRetry + ", finalAudioType=" + this.finalAudioType + ", isForceSaveAudio=" + this.isForceSaveAudio + ", forceSaveReason=" + this.forceSaveReason + ')';
    }

    public final MmAssociatedIds getAssociatedIds() {
        return this.associatedIds;
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final boolean getCanAudioCreateRetry() {
        return this.canAudioCreateRetry;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getFinalAudioType() {
        return this.finalAudioType;
    }

    public final String getForceSaveReason() {
        return this.forceSaveReason;
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final String getObjectToken() {
        return this.objectToken;
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getStopTime() {
        return this.stopTime;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final d getUnavailableReason() {
        return this.unavailableReason;
    }

    public final boolean isForceSaveAudio() {
        return this.isForceSaveAudio;
    }

    public final void setAssociatedIds(MmAssociatedIds r100) {
        this.associatedIds = r100;
    }

    public final void setBenefitCenterUrl(String r100) {
        this.benefitCenterUrl = r100;
    }

    public final void setCanAudioCreateRetry(boolean r100) {
        this.canAudioCreateRetry = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setFinalAudioType(int r100) {
        this.finalAudioType = r100;
    }

    public final void setForceSaveAudio(boolean r100) {
        this.isForceSaveAudio = r100;
    }

    public final void setForceSaveReason(String r100) {
        this.forceSaveReason = r100;
    }

    public final void setMeetingId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.meetingId = r100;
    }

    public final void setObjectToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.objectToken = r100;
    }

    public final void setRecordingId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordingId = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setStopTime(long r100) {
        this.stopTime = r100;
    }

    public final void setTopic(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.topic = r100;
    }

    public final void setUnavailableReason(d r100) {
        this.unavailableReason = r100;
    }

    public MmCreateAudioResponse(String r100, String r101, String r102, long r110, long r111, long r112, boolean r113, int r114, boolean r115, String r116, d r210, String r211, String r212, MmAssociatedIds r213) {
        Intrinsics.checkNotNullParameter(r100, "objectToken");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "topic");
        Intrinsics.checkNotNullParameter(r212, "recordingId");
        this.objectToken = r100;
        this.meetingId = r101;
        this.topic = r102;
        this.startTime = r110;
        this.stopTime = r111;
        this.duration = r112;
        this.canAudioCreateRetry = r113;
        this.finalAudioType = r114;
        this.isForceSaveAudio = r115;
        this.forceSaveReason = r116;
        this.unavailableReason = r210;
        this.benefitCenterUrl = r211;
        this.recordingId = r212;
        this.associatedIds = r213;
    }

    public /* synthetic */ MmCreateAudioResponse(String r110, String r111, String r210, long r211, long r212, long r213, boolean r214, int r215, boolean r216, String r310, d r311, String r312, String r313, MmAssociatedIds r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = "";
    L14:
        long r103 = 0;
        if ((r315 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r315 & 16) == 0) goto L21;
        long r112 = 0;
    L23:
        if ((r315 & 32) != 0) goto L26;
        r103 = r213;
    L26:
        boolean r113 = false;
        if ((r315 & 64) == 0) goto L29;
        boolean r105 = false;
    L31:
        if ((r315 & 128) == 0) goto L33;
        int r114 = 0;
    L35:
        if ((r315 & 256) != 0) goto L39;
        r113 = r216;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        d r116 = null;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r106 = null;
    L50:
        String r117 = r106;
        if ((r315 & 4096) == 0) goto L53;
        String r107 = "";
    L55:
        if ((r315 & 8192) == 0) goto L57;
        MmAssociatedIds r108 = null;
    L58:
        this(r100, r101, r102, r104, r112, r103, r105, r114, r113, r115, r116, r117, r107, r108);
        return;
    L57:
        r108 = r314;
        goto L58
    L53:
        r107 = r313;
        goto L55
    L49:
        r106 = r312;
        goto L50
    L45:
        r116 = r311;
        goto L47
    L41:
        r115 = r310;
        goto L43
    L33:
        r114 = r215;
        goto L35
    L29:
        r105 = r214;
        goto L31
    L21:
        r112 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
