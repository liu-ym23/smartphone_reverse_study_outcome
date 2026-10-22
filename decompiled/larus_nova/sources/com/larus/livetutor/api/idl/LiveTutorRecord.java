package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/livetutor/api/idl/LiveTutorRecord;", "Ljava/io/Serializable;", "tutorId", "", "createdTime", "tutorSearchContent", "Lcom/larus/livetutor/api/idl/TutorSearchContent;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/TutorSearchContent;)V", "getTutorId", "()Ljava/lang/Long;", "setTutorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCreatedTime", "setCreatedTime", "getTutorSearchContent", "()Lcom/larus/livetutor/api/idl/TutorSearchContent;", "setTutorSearchContent", "(Lcom/larus/livetutor/api/idl/TutorSearchContent;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/TutorSearchContent;)Lcom/larus/livetutor/api/idl/LiveTutorRecord;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorRecord implements Serializable {

    @SerializedName("created_time")
    private Long createdTime;

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("tutor_search_content")
    private TutorSearchContent tutorSearchContent;

    public LiveTutorRecord() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LiveTutorRecord copy$default(LiveTutorRecord r100, Long r101, Long r102, TutorSearchContent r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tutorId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.createdTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tutorSearchContent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.tutorId;
    }

    public final Long component2() {
        return this.createdTime;
    }

    public final TutorSearchContent component3() {
        return this.tutorSearchContent;
    }

    public final LiveTutorRecord copy(Long r100, Long r101, TutorSearchContent r102) {
        return new LiveTutorRecord(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorRecord) == true) goto L8;
        return false;
    L8:
        LiveTutorRecord r101 = (LiveTutorRecord) r100;
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.createdTime, r101.createdTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tutorSearchContent, r101.tutorSearchContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.tutorId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.createdTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        TutorSearchContent r107 = this.tutorSearchContent;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LiveTutorRecord(tutorId=" + this.tutorId + ", createdTime=" + this.createdTime + ", tutorSearchContent=" + this.tutorSearchContent + ')';
    }

    public final Long getCreatedTime() {
        return this.createdTime;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final TutorSearchContent getTutorSearchContent() {
        return this.tutorSearchContent;
    }

    public final void setCreatedTime(Long r100) {
        this.createdTime = r100;
    }

    public final void setTutorId(Long r100) {
        this.tutorId = r100;
    }

    public final void setTutorSearchContent(TutorSearchContent r100) {
        this.tutorSearchContent = r100;
    }

    public LiveTutorRecord(Long r100, Long r101, TutorSearchContent r102) {
        this.tutorId = r100;
        this.createdTime = r101;
        this.tutorSearchContent = r102;
    }

    public /* synthetic */ LiveTutorRecord(Long r100, Long r101, TutorSearchContent r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0L;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
