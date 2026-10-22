package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014Jb\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0007\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\"\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u00065"}, d2 = {"Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;", "Ljava/io/Serializable;", "totalText", "", "tutorPartId", "", "sentenceIdx", "isFull", "", "subtitleType", "", "partInTutorIdx", "tutorRoundId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getTotalText", "()Ljava/lang/String;", "setTotalText", "(Ljava/lang/String;)V", "getTutorPartId", "()Ljava/lang/Long;", "setTutorPartId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSentenceIdx", "setSentenceIdx", "()Ljava/lang/Boolean;", "setFull", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSubtitleType", "()Ljava/lang/Integer;", "setSubtitleType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPartInTutorIdx", "setPartInTutorIdx", "getTutorRoundId", "setTutorRoundId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;", "equals", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorSubtitle implements Serializable {

    @SerializedName("is_full")
    private Boolean isFull;

    @SerializedName("part_in_tutor_idx")
    private Long partInTutorIdx;

    @SerializedName("sentence_idx")
    private Long sentenceIdx;

    @SerializedName("subtitle_type")
    private Integer subtitleType;

    @SerializedName("total_text")
    private String totalText;

    @SerializedName("tutor_part_id")
    private Long tutorPartId;

    @SerializedName("tutor_round_id")
    private Long tutorRoundId;

    public LiveTutorSubtitle() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ LiveTutorSubtitle copy$default(LiveTutorSubtitle r100, String r101, Long r102, Long r103, Boolean r104, Integer r110, Long r111, Long r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.totalText;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.tutorPartId;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.sentenceIdx;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isFull;
    L14:
        Boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.subtitleType;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.partInTutorIdx;
    L20:
        Long r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.tutorRoundId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.totalText;
    }

    public final Long component2() {
        return this.tutorPartId;
    }

    public final Long component3() {
        return this.sentenceIdx;
    }

    public final Boolean component4() {
        return this.isFull;
    }

    public final Integer component5() {
        return this.subtitleType;
    }

    public final Long component6() {
        return this.partInTutorIdx;
    }

    public final Long component7() {
        return this.tutorRoundId;
    }

    public final LiveTutorSubtitle copy(String r110, Long r111, Long r112, Boolean r113, Integer r114, Long r115, Long r116) {
        return new LiveTutorSubtitle(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorSubtitle) == true) goto L8;
        return false;
    L8:
        LiveTutorSubtitle r101 = (LiveTutorSubtitle) r100;
        if (Intrinsics.areEqual(this.totalText, r101.totalText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tutorPartId, r101.tutorPartId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sentenceIdx, r101.sentenceIdx) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFull, r101.isFull) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subtitleType, r101.subtitleType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.partInTutorIdx, r101.partInTutorIdx) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tutorRoundId, r101.tutorRoundId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.totalText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.tutorPartId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.sentenceIdx;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isFull;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.subtitleType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.partInTutorIdx;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.tutorRoundId;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "LiveTutorSubtitle(totalText=" + this.totalText + ", tutorPartId=" + this.tutorPartId + ", sentenceIdx=" + this.sentenceIdx + ", isFull=" + this.isFull + ", subtitleType=" + this.subtitleType + ", partInTutorIdx=" + this.partInTutorIdx + ", tutorRoundId=" + this.tutorRoundId + ')';
    }

    public final Long getPartInTutorIdx() {
        return this.partInTutorIdx;
    }

    public final Long getSentenceIdx() {
        return this.sentenceIdx;
    }

    public final Integer getSubtitleType() {
        return this.subtitleType;
    }

    public final String getTotalText() {
        return this.totalText;
    }

    public final Long getTutorPartId() {
        return this.tutorPartId;
    }

    public final Long getTutorRoundId() {
        return this.tutorRoundId;
    }

    public final Boolean isFull() {
        return this.isFull;
    }

    public final void setFull(Boolean r100) {
        this.isFull = r100;
    }

    public final void setPartInTutorIdx(Long r100) {
        this.partInTutorIdx = r100;
    }

    public final void setSentenceIdx(Long r100) {
        this.sentenceIdx = r100;
    }

    public final void setSubtitleType(Integer r100) {
        this.subtitleType = r100;
    }

    public final void setTotalText(String r100) {
        this.totalText = r100;
    }

    public final void setTutorPartId(Long r100) {
        this.tutorPartId = r100;
    }

    public final void setTutorRoundId(Long r100) {
        this.tutorRoundId = r100;
    }

    public LiveTutorSubtitle(String r100, Long r101, Long r102, Boolean r103, Integer r104, Long r105, Long r106) {
        this.totalText = r100;
        this.tutorPartId = r101;
        this.sentenceIdx = r102;
        this.isFull = r103;
        this.subtitleType = r104;
        this.partInTutorIdx = r105;
        this.tutorRoundId = r106;
    }

    public /* synthetic */ LiveTutorSubtitle(String r100, Long r101, Long r102, Boolean r110, Integer r111, Long r112, Long r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Long r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Long r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Long r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Long r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
