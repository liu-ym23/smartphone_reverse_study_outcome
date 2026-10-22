package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a¨\u0006,"}, d2 = {"Lcom/larus/livetutor/api/idl/UserAsrEndMsg;", "Ljava/io/Serializable;", "tutorId", "", "tutorRoundId", "tutorPartId", "partInTutorIdx", "asrContent", "", "clientUuid", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getTutorId", "()Ljava/lang/Long;", "setTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTutorRoundId", "setTutorRoundId", "getTutorPartId", "setTutorPartId", "getPartInTutorIdx", "setPartInTutorIdx", "getAsrContent", "()Ljava/lang/String;", "setAsrContent", "(Ljava/lang/String;)V", "getClientUuid", "setClientUuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/UserAsrEndMsg;", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserAsrEndMsg implements Serializable {

    @SerializedName("asr_content")
    private String asrContent;

    @SerializedName("client_uuid")
    private String clientUuid;

    @SerializedName("part_in_tutor_idx")
    private Long partInTutorIdx;

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("tutor_part_id")
    private Long tutorPartId;

    @SerializedName("tutor_round_id")
    private Long tutorRoundId;

    public UserAsrEndMsg() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UserAsrEndMsg copy$default(UserAsrEndMsg r100, Long r101, Long r102, Long r103, Long r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.tutorId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.tutorRoundId;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.tutorPartId;
    L11:
        Long r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.partInTutorIdx;
    L14:
        Long r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.asrContent;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.clientUuid;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.tutorId;
    }

    public final Long component2() {
        return this.tutorRoundId;
    }

    public final Long component3() {
        return this.tutorPartId;
    }

    public final Long component4() {
        return this.partInTutorIdx;
    }

    public final String component5() {
        return this.asrContent;
    }

    public final String component6() {
        return this.clientUuid;
    }

    public final UserAsrEndMsg copy(Long r100, Long r110, Long r111, Long r112, String r113, String r114) {
        return new UserAsrEndMsg(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserAsrEndMsg) == true) goto L8;
        return false;
    L8:
        UserAsrEndMsg r101 = (UserAsrEndMsg) r100;
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tutorRoundId, r101.tutorRoundId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tutorPartId, r101.tutorPartId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.partInTutorIdx, r101.partInTutorIdx) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.asrContent, r101.asrContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clientUuid, r101.clientUuid) == true) goto L26;
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
        Long r104 = this.tutorRoundId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.tutorPartId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.partInTutorIdx;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.asrContent;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.clientUuid;
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
        return "UserAsrEndMsg(tutorId=" + this.tutorId + ", tutorRoundId=" + this.tutorRoundId + ", tutorPartId=" + this.tutorPartId + ", partInTutorIdx=" + this.partInTutorIdx + ", asrContent=" + this.asrContent + ", clientUuid=" + this.clientUuid + ')';
    }

    public final String getAsrContent() {
        return this.asrContent;
    }

    public final String getClientUuid() {
        return this.clientUuid;
    }

    public final Long getPartInTutorIdx() {
        return this.partInTutorIdx;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final Long getTutorPartId() {
        return this.tutorPartId;
    }

    public final Long getTutorRoundId() {
        return this.tutorRoundId;
    }

    public final void setAsrContent(String r100) {
        this.asrContent = r100;
    }

    public final void setClientUuid(String r100) {
        this.clientUuid = r100;
    }

    public final void setPartInTutorIdx(Long r100) {
        this.partInTutorIdx = r100;
    }

    public final void setTutorId(Long r100) {
        this.tutorId = r100;
    }

    public final void setTutorPartId(Long r100) {
        this.tutorPartId = r100;
    }

    public final void setTutorRoundId(Long r100) {
        this.tutorRoundId = r100;
    }

    public UserAsrEndMsg(Long r100, Long r101, Long r102, Long r103, String r104, String r105) {
        this.tutorId = r100;
        this.tutorRoundId = r101;
        this.tutorPartId = r102;
        this.partInTutorIdx = r103;
        this.asrContent = r104;
        this.clientUuid = r105;
    }

    public /* synthetic */ UserAsrEndMsg(Long r100, Long r101, Long r102, Long r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
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
        Long r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
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
