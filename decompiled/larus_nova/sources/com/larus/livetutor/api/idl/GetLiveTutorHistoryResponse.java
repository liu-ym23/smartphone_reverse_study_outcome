package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003JZ\u0010(\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryResponse;", "Ljava/io/Serializable;", "liveTutorList", "", "Lcom/larus/livetutor/api/idl/LiveTutorRecord;", "hasMore", "", "nextCursorId", "", "flashCardList", "Lcom/larus/livetutor/api/idl/FlashCardRecord;", "statusInfo", "Lcom/larus/livetutor/api/idl/StatusInfo;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Lcom/larus/livetutor/api/idl/StatusInfo;)V", "getLiveTutorList", "()Ljava/util/List;", "setLiveTutorList", "(Ljava/util/List;)V", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNextCursorId", "()Ljava/lang/Long;", "setNextCursorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFlashCardList", "setFlashCardList", "getStatusInfo", "()Lcom/larus/livetutor/api/idl/StatusInfo;", "setStatusInfo", "(Lcom/larus/livetutor/api/idl/StatusInfo;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Lcom/larus/livetutor/api/idl/StatusInfo;)Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryResponse;", "equals", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetLiveTutorHistoryResponse implements Serializable {

    @SerializedName("flash_card_list")
    private List<FlashCardRecord> flashCardList;

    @SerializedName("hasMore")
    private Boolean hasMore;

    @SerializedName("live_tutor_list")
    private List<LiveTutorRecord> liveTutorList;

    @SerializedName("next_cursor_id")
    private Long nextCursorId;

    @SerializedName("status_info")
    private StatusInfo statusInfo;

    public GetLiveTutorHistoryResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetLiveTutorHistoryResponse copy$default(GetLiveTutorHistoryResponse r100, List r101, Boolean r102, Long r103, List r104, StatusInfo r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.liveTutorList;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.hasMore;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.nextCursorId;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.flashCardList;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.statusInfo;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<LiveTutorRecord> component1() {
        return this.liveTutorList;
    }

    public final Boolean component2() {
        return this.hasMore;
    }

    public final Long component3() {
        return this.nextCursorId;
    }

    public final List<FlashCardRecord> component4() {
        return this.flashCardList;
    }

    public final StatusInfo component5() {
        return this.statusInfo;
    }

    public final GetLiveTutorHistoryResponse copy(List<LiveTutorRecord> r100, Boolean r101, Long r110, List<FlashCardRecord> r111, StatusInfo r112) {
        return new GetLiveTutorHistoryResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetLiveTutorHistoryResponse) == true) goto L8;
        return false;
    L8:
        GetLiveTutorHistoryResponse r101 = (GetLiveTutorHistoryResponse) r100;
        if (Intrinsics.areEqual(this.liveTutorList, r101.liveTutorList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nextCursorId, r101.nextCursorId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flashCardList, r101.flashCardList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.statusInfo, r101.statusInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<LiveTutorRecord> r100 = this.liveTutorList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasMore;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.nextCursorId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<FlashCardRecord> r110 = this.flashCardList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        StatusInfo r113 = this.statusInfo;
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
        return "GetLiveTutorHistoryResponse(liveTutorList=" + this.liveTutorList + ", hasMore=" + this.hasMore + ", nextCursorId=" + this.nextCursorId + ", flashCardList=" + this.flashCardList + ", statusInfo=" + this.statusInfo + ')';
    }

    public final List<FlashCardRecord> getFlashCardList() {
        return this.flashCardList;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<LiveTutorRecord> getLiveTutorList() {
        return this.liveTutorList;
    }

    public final Long getNextCursorId() {
        return this.nextCursorId;
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final void setFlashCardList(List<FlashCardRecord> r100) {
        this.flashCardList = r100;
    }

    public final void setHasMore(Boolean r100) {
        this.hasMore = r100;
    }

    public final void setLiveTutorList(List<LiveTutorRecord> r100) {
        this.liveTutorList = r100;
    }

    public final void setNextCursorId(Long r100) {
        this.nextCursorId = r100;
    }

    public final void setStatusInfo(StatusInfo r100) {
        this.statusInfo = r100;
    }

    public GetLiveTutorHistoryResponse(List<LiveTutorRecord> r100, Boolean r101, Long r102, List<FlashCardRecord> r103, StatusInfo r104) {
        this.liveTutorList = r100;
        this.hasMore = r101;
        this.nextCursorId = r102;
        this.flashCardList = r103;
        this.statusInfo = r104;
    }

    public /* synthetic */ GetLiveTutorHistoryResponse(List r100, Boolean r101, Long r102, List r103, StatusInfo r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        Boolean r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        Long r106 = null;
    L14:
        if ((r110 & 8) == 0) goto L16;
        List r107 = null;
    L18:
        if ((r110 & 16) == 0) goto L20;
        StatusInfo r113 = null;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
