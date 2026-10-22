package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/larus/livetutor/api/idl/LiveTutorCallInfo;", "Ljava/io/Serializable;", "tutorId", "", "defaultLoadingStep", "", "firstRoundStatus", "feedbackStatus", "consumeStatus", "tutorUserSetting", "Lcom/larus/livetutor/api/idl/UserSetting;", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/UserSetting;)V", "getTutorId", "()Ljava/lang/Long;", "setTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDefaultLoadingStep", "()Ljava/lang/Integer;", "setDefaultLoadingStep", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFirstRoundStatus", "setFirstRoundStatus", "getFeedbackStatus", "setFeedbackStatus", "getConsumeStatus", "setConsumeStatus", "getTutorUserSetting", "()Lcom/larus/livetutor/api/idl/UserSetting;", "setTutorUserSetting", "(Lcom/larus/livetutor/api/idl/UserSetting;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/UserSetting;)Lcom/larus/livetutor/api/idl/LiveTutorCallInfo;", "equals", "", "other", "", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorCallInfo implements Serializable {

    @SerializedName("consume_status")
    private Integer consumeStatus;

    @SerializedName("default_loading_step")
    private Integer defaultLoadingStep;

    @SerializedName("feedback_status")
    private Integer feedbackStatus;

    @SerializedName("first_round_status")
    private Integer firstRoundStatus;

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("tutor_user_setting")
    private UserSetting tutorUserSetting;

    public LiveTutorCallInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LiveTutorCallInfo copy$default(LiveTutorCallInfo r100, Long r101, Integer r102, Integer r103, Integer r104, Integer r105, UserSetting r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.tutorId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.defaultLoadingStep;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.firstRoundStatus;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.feedbackStatus;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.consumeStatus;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.tutorUserSetting;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.tutorId;
    }

    public final Integer component2() {
        return this.defaultLoadingStep;
    }

    public final Integer component3() {
        return this.firstRoundStatus;
    }

    public final Integer component4() {
        return this.feedbackStatus;
    }

    public final Integer component5() {
        return this.consumeStatus;
    }

    public final UserSetting component6() {
        return this.tutorUserSetting;
    }

    public final LiveTutorCallInfo copy(Long r100, Integer r110, Integer r111, Integer r112, Integer r113, UserSetting r114) {
        return new LiveTutorCallInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorCallInfo) == true) goto L8;
        return false;
    L8:
        LiveTutorCallInfo r101 = (LiveTutorCallInfo) r100;
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultLoadingStep, r101.defaultLoadingStep) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.firstRoundStatus, r101.firstRoundStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedbackStatus, r101.feedbackStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.consumeStatus, r101.consumeStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tutorUserSetting, r101.tutorUserSetting) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.tutorId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.defaultLoadingStep;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.firstRoundStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.feedbackStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.consumeStatus;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        UserSetting r116 = this.tutorUserSetting;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LiveTutorCallInfo(tutorId=" + this.tutorId + ", defaultLoadingStep=" + this.defaultLoadingStep + ", firstRoundStatus=" + this.firstRoundStatus + ", feedbackStatus=" + this.feedbackStatus + ", consumeStatus=" + this.consumeStatus + ", tutorUserSetting=" + this.tutorUserSetting + ')';
    }

    public final Integer getConsumeStatus() {
        return this.consumeStatus;
    }

    public final Integer getDefaultLoadingStep() {
        return this.defaultLoadingStep;
    }

    public final Integer getFeedbackStatus() {
        return this.feedbackStatus;
    }

    public final Integer getFirstRoundStatus() {
        return this.firstRoundStatus;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final UserSetting getTutorUserSetting() {
        return this.tutorUserSetting;
    }

    public final void setConsumeStatus(Integer r100) {
        this.consumeStatus = r100;
    }

    public final void setDefaultLoadingStep(Integer r100) {
        this.defaultLoadingStep = r100;
    }

    public final void setFeedbackStatus(Integer r100) {
        this.feedbackStatus = r100;
    }

    public final void setFirstRoundStatus(Integer r100) {
        this.firstRoundStatus = r100;
    }

    public final void setTutorId(Long r100) {
        this.tutorId = r100;
    }

    public final void setTutorUserSetting(UserSetting r100) {
        this.tutorUserSetting = r100;
    }

    public LiveTutorCallInfo(Long r100, Integer r101, Integer r102, Integer r103, Integer r104, UserSetting r105) {
        this.tutorId = r100;
        this.defaultLoadingStep = r101;
        this.firstRoundStatus = r102;
        this.feedbackStatus = r103;
        this.consumeStatus = r104;
        this.tutorUserSetting = r105;
    }

    public /* synthetic */ LiveTutorCallInfo(Long r100, Integer r101, Integer r102, Integer r103, Integer r110, UserSetting r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Long r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        UserSetting r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
