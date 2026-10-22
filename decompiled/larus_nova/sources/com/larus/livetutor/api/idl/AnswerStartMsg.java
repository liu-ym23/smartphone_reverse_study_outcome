package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/larus/livetutor/api/idl/AnswerStartMsg;", "Ljava/io/Serializable;", "tutorId", "", "tutorRoundId", "tutorPartId", "partInTutorIdx", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getTutorId", "()Ljava/lang/Long;", "setTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTutorRoundId", "setTutorRoundId", "getTutorPartId", "setTutorPartId", "getPartInTutorIdx", "setPartInTutorIdx", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/AnswerStartMsg;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnswerStartMsg implements Serializable {

    @SerializedName("part_in_tutor_idx")
    private Long partInTutorIdx;

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("tutor_part_id")
    private Long tutorPartId;

    @SerializedName("tutor_round_id")
    private Long tutorRoundId;

    public AnswerStartMsg() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AnswerStartMsg copy$default(AnswerStartMsg r100, Long r101, Long r102, Long r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.tutorId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.tutorRoundId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.tutorPartId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.partInTutorIdx;
    L15:
        return r100.copy(r101, r102, r103, r104);
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

    public final AnswerStartMsg copy(Long r100, Long r101, Long r102, Long r103) {
        return new AnswerStartMsg(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnswerStartMsg) == true) goto L8;
        return false;
    L8:
        AnswerStartMsg r101 = (AnswerStartMsg) r100;
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tutorRoundId, r101.tutorRoundId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tutorPartId, r101.tutorPartId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.partInTutorIdx, r101.partInTutorIdx) == true) goto L20;
        return false;
    L20:
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
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "AnswerStartMsg(tutorId=" + this.tutorId + ", tutorRoundId=" + this.tutorRoundId + ", tutorPartId=" + this.tutorPartId + ", partInTutorIdx=" + this.partInTutorIdx + ')';
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

    public AnswerStartMsg(Long r100, Long r101, Long r102, Long r103) {
        this.tutorId = r100;
        this.tutorRoundId = r101;
        this.tutorPartId = r102;
        this.partInTutorIdx = r103;
    }

    public /* synthetic */ AnswerStartMsg(Long r100, Long r101, Long r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
