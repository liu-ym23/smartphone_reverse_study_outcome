package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006&"}, d2 = {"Lcom/larus/livetutor/api/idl/UserAsrStartMsg;", "Ljava/io/Serializable;", "tutorId", "", "tutorRoundId", "interruptedTutorPartId", "asrTutorPartId", "partInTutorIdx", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getTutorId", "()Ljava/lang/Long;", "setTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTutorRoundId", "setTutorRoundId", "getInterruptedTutorPartId", "setInterruptedTutorPartId", "getAsrTutorPartId", "setAsrTutorPartId", "getPartInTutorIdx", "setPartInTutorIdx", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/UserAsrStartMsg;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserAsrStartMsg implements Serializable {

    @SerializedName("asr_tutor_part_id")
    private Long asrTutorPartId;

    @SerializedName("interrupted_tutor_part_id")
    private Long interruptedTutorPartId;

    @SerializedName("part_in_tutor_idx")
    private Long partInTutorIdx;

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("tutor_round_id")
    private Long tutorRoundId;

    public UserAsrStartMsg() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ UserAsrStartMsg copy$default(UserAsrStartMsg r100, Long r101, Long r102, Long r103, Long r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.tutorId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.tutorRoundId;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.interruptedTutorPartId;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.asrTutorPartId;
    L14:
        Long r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.partInTutorIdx;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.tutorId;
    }

    public final Long component2() {
        return this.tutorRoundId;
    }

    public final Long component3() {
        return this.interruptedTutorPartId;
    }

    public final Long component4() {
        return this.asrTutorPartId;
    }

    public final Long component5() {
        return this.partInTutorIdx;
    }

    public final UserAsrStartMsg copy(Long r100, Long r101, Long r110, Long r111, Long r112) {
        return new UserAsrStartMsg(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserAsrStartMsg) == true) goto L8;
        return false;
    L8:
        UserAsrStartMsg r101 = (UserAsrStartMsg) r100;
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tutorRoundId, r101.tutorRoundId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interruptedTutorPartId, r101.interruptedTutorPartId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asrTutorPartId, r101.asrTutorPartId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.partInTutorIdx, r101.partInTutorIdx) == true) goto L23;
        return false;
    L23:
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
        Long r107 = this.interruptedTutorPartId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.asrTutorPartId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.partInTutorIdx;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "UserAsrStartMsg(tutorId=" + this.tutorId + ", tutorRoundId=" + this.tutorRoundId + ", interruptedTutorPartId=" + this.interruptedTutorPartId + ", asrTutorPartId=" + this.asrTutorPartId + ", partInTutorIdx=" + this.partInTutorIdx + ')';
    }

    public final Long getAsrTutorPartId() {
        return this.asrTutorPartId;
    }

    public final Long getInterruptedTutorPartId() {
        return this.interruptedTutorPartId;
    }

    public final Long getPartInTutorIdx() {
        return this.partInTutorIdx;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final Long getTutorRoundId() {
        return this.tutorRoundId;
    }

    public final void setAsrTutorPartId(Long r100) {
        this.asrTutorPartId = r100;
    }

    public final void setInterruptedTutorPartId(Long r100) {
        this.interruptedTutorPartId = r100;
    }

    public final void setPartInTutorIdx(Long r100) {
        this.partInTutorIdx = r100;
    }

    public final void setTutorId(Long r100) {
        this.tutorId = r100;
    }

    public final void setTutorRoundId(Long r100) {
        this.tutorRoundId = r100;
    }

    public UserAsrStartMsg(Long r100, Long r101, Long r102, Long r103, Long r104) {
        this.tutorId = r100;
        this.tutorRoundId = r101;
        this.interruptedTutorPartId = r102;
        this.asrTutorPartId = r103;
        this.partInTutorIdx = r104;
    }

    public /* synthetic */ UserAsrStartMsg(Long r100, Long r101, Long r102, Long r103, Long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Long r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Long r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
