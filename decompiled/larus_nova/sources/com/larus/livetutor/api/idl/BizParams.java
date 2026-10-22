package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016JV\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0006\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018¨\u0006/"}, d2 = {"Lcom/larus/livetutor/api/idl/BizParams;", "Ljava/io/Serializable;", "bizAppId", "", "bizScenes", "robotId", "isNewQuestionResult", "", "liveTutorV2Params", "Lcom/larus/livetutor/api/idl/LiveTutorV2Params;", "allowStream", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/larus/livetutor/api/idl/LiveTutorV2Params;Ljava/lang/Boolean;)V", "getBizAppId", "()Ljava/lang/Long;", "setBizAppId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBizScenes", "setBizScenes", "getRobotId", "setRobotId", "()Ljava/lang/Boolean;", "setNewQuestionResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLiveTutorV2Params", "()Lcom/larus/livetutor/api/idl/LiveTutorV2Params;", "setLiveTutorV2Params", "(Lcom/larus/livetutor/api/idl/LiveTutorV2Params;)V", "getAllowStream", "setAllowStream", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/larus/livetutor/api/idl/LiveTutorV2Params;Ljava/lang/Boolean;)Lcom/larus/livetutor/api/idl/BizParams;", "equals", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BizParams implements Serializable {

    @SerializedName("allow_stream")
    private Boolean allowStream;

    @SerializedName("biz_app_id")
    private Long bizAppId;

    @SerializedName("biz_scenes")
    private Long bizScenes;

    @SerializedName("is_new_question_result")
    private Boolean isNewQuestionResult;

    @SerializedName("live_tutor_v2_params")
    private LiveTutorV2Params liveTutorV2Params;

    @SerializedName("robot_id")
    private Long robotId;

    public BizParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ BizParams copy$default(BizParams r100, Long r101, Long r102, Long r103, Boolean r104, LiveTutorV2Params r105, Boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.bizAppId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.bizScenes;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.robotId;
    L11:
        Long r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isNewQuestionResult;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.liveTutorV2Params;
    L17:
        LiveTutorV2Params r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.allowStream;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.bizAppId;
    }

    public final Long component2() {
        return this.bizScenes;
    }

    public final Long component3() {
        return this.robotId;
    }

    public final Boolean component4() {
        return this.isNewQuestionResult;
    }

    public final LiveTutorV2Params component5() {
        return this.liveTutorV2Params;
    }

    public final Boolean component6() {
        return this.allowStream;
    }

    public final BizParams copy(Long r100, Long r110, Long r111, Boolean r112, LiveTutorV2Params r113, Boolean r114) {
        return new BizParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BizParams) == true) goto L8;
        return false;
    L8:
        BizParams r101 = (BizParams) r100;
        if (Intrinsics.areEqual(this.bizAppId, r101.bizAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizScenes, r101.bizScenes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.robotId, r101.robotId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isNewQuestionResult, r101.isNewQuestionResult) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.liveTutorV2Params, r101.liveTutorV2Params) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.allowStream, r101.allowStream) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.bizAppId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.bizScenes;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.robotId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isNewQuestionResult;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        LiveTutorV2Params r113 = this.liveTutorV2Params;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.allowStream;
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
        return "BizParams(bizAppId=" + this.bizAppId + ", bizScenes=" + this.bizScenes + ", robotId=" + this.robotId + ", isNewQuestionResult=" + this.isNewQuestionResult + ", liveTutorV2Params=" + this.liveTutorV2Params + ", allowStream=" + this.allowStream + ')';
    }

    public final Boolean getAllowStream() {
        return this.allowStream;
    }

    public final Long getBizAppId() {
        return this.bizAppId;
    }

    public final Long getBizScenes() {
        return this.bizScenes;
    }

    public final LiveTutorV2Params getLiveTutorV2Params() {
        return this.liveTutorV2Params;
    }

    public final Long getRobotId() {
        return this.robotId;
    }

    public final Boolean isNewQuestionResult() {
        return this.isNewQuestionResult;
    }

    public final void setAllowStream(Boolean r100) {
        this.allowStream = r100;
    }

    public final void setBizAppId(Long r100) {
        this.bizAppId = r100;
    }

    public final void setBizScenes(Long r100) {
        this.bizScenes = r100;
    }

    public final void setLiveTutorV2Params(LiveTutorV2Params r100) {
        this.liveTutorV2Params = r100;
    }

    public final void setNewQuestionResult(Boolean r100) {
        this.isNewQuestionResult = r100;
    }

    public final void setRobotId(Long r100) {
        this.robotId = r100;
    }

    public BizParams(Long r100, Long r101, Long r102, Boolean r103, LiveTutorV2Params r104, Boolean r105) {
        this.bizAppId = r100;
        this.bizScenes = r101;
        this.robotId = r102;
        this.isNewQuestionResult = r103;
        this.liveTutorV2Params = r104;
        this.allowStream = r105;
    }

    public /* synthetic */ BizParams(Long r100, Long r101, Long r102, Boolean r103, LiveTutorV2Params r110, Boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Long r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Long r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Long r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Boolean r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        LiveTutorV2Params r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Boolean r115 = null;
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
