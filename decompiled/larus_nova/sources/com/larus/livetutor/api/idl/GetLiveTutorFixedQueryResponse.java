package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0013\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00108\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003J~\u0010:\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\nHÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006B"}, d2 = {"Lcom/larus/livetutor/api/idl/GetLiveTutorFixedQueryResponse;", "Ljava/io/Serializable;", "fixedQueryList", "", "Lcom/larus/livetutor/api/idl/FixedQuery;", "nextCursorId", "", "hasMore", "", "recId", "", "fixedQueryTabList", "Lcom/larus/livetutor/api/idl/FixedQueryTab;", "enableHomepageAsr", "flashCardEntrance", "Lcom/larus/livetutor/api/idl/FlashCardEntrance;", "statusInfo", "Lcom/larus/livetutor/api/idl/StatusInfo;", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lcom/larus/livetutor/api/idl/FlashCardEntrance;Lcom/larus/livetutor/api/idl/StatusInfo;)V", "getFixedQueryList", "()Ljava/util/List;", "setFixedQueryList", "(Ljava/util/List;)V", "getNextCursorId", "()Ljava/lang/Long;", "setNextCursorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "getFixedQueryTabList", "setFixedQueryTabList", "getEnableHomepageAsr", "setEnableHomepageAsr", "getFlashCardEntrance", "()Lcom/larus/livetutor/api/idl/FlashCardEntrance;", "setFlashCardEntrance", "(Lcom/larus/livetutor/api/idl/FlashCardEntrance;)V", "getStatusInfo", "()Lcom/larus/livetutor/api/idl/StatusInfo;", "setStatusInfo", "(Lcom/larus/livetutor/api/idl/StatusInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lcom/larus/livetutor/api/idl/FlashCardEntrance;Lcom/larus/livetutor/api/idl/StatusInfo;)Lcom/larus/livetutor/api/idl/GetLiveTutorFixedQueryResponse;", "equals", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetLiveTutorFixedQueryResponse implements Serializable {

    @SerializedName("enable_homepage_asr")
    private Boolean enableHomepageAsr;

    @SerializedName("fixed_query_list")
    private List<FixedQuery> fixedQueryList;

    @SerializedName("fixed_query_tab_list")
    private List<FixedQueryTab> fixedQueryTabList;

    @SerializedName("flash_card_entrance")
    private FlashCardEntrance flashCardEntrance;

    @SerializedName("has_more")
    private Boolean hasMore;

    @SerializedName("next_cursor_id")
    private Long nextCursorId;

    @SerializedName("rec_id")
    private String recId;

    @SerializedName("status_info")
    private StatusInfo statusInfo;

    public GetLiveTutorFixedQueryResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetLiveTutorFixedQueryResponse copy$default(GetLiveTutorFixedQueryResponse r100, List r110, Long r111, Boolean r112, String r113, List r114, Boolean r115, FlashCardEntrance r116, StatusInfo r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        List r101 = r100.fixedQueryList;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = r100.nextCursorId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r103 = r100.hasMore;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.recId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        List r105 = r100.fixedQueryTabList;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Boolean r106 = r100.enableHomepageAsr;
    L27:
        if ((r118 & 64) == 0) goto L29;
        FlashCardEntrance r107 = r100.flashCardEntrance;
    L31:
        if ((r118 & 128) == 0) goto L33;
        StatusInfo r108 = r100.statusInfo;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
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

    public final List<FixedQuery> component1() {
        return this.fixedQueryList;
    }

    public final Long component2() {
        return this.nextCursorId;
    }

    public final Boolean component3() {
        return this.hasMore;
    }

    public final String component4() {
        return this.recId;
    }

    public final List<FixedQueryTab> component5() {
        return this.fixedQueryTabList;
    }

    public final Boolean component6() {
        return this.enableHomepageAsr;
    }

    public final FlashCardEntrance component7() {
        return this.flashCardEntrance;
    }

    public final StatusInfo component8() {
        return this.statusInfo;
    }

    public final GetLiveTutorFixedQueryResponse copy(List<FixedQuery> r110, Long r111, Boolean r112, String r113, List<FixedQueryTab> r114, Boolean r115, FlashCardEntrance r116, StatusInfo r117) {
        return new GetLiveTutorFixedQueryResponse(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetLiveTutorFixedQueryResponse) == true) goto L8;
        return false;
    L8:
        GetLiveTutorFixedQueryResponse r101 = (GetLiveTutorFixedQueryResponse) r100;
        if (Intrinsics.areEqual(this.fixedQueryList, r101.fixedQueryList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nextCursorId, r101.nextCursorId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recId, r101.recId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fixedQueryTabList, r101.fixedQueryTabList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enableHomepageAsr, r101.enableHomepageAsr) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.flashCardEntrance, r101.flashCardEntrance) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.statusInfo, r101.statusInfo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        List<FixedQuery> r100 = this.fixedQueryList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.nextCursorId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hasMore;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.recId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<FixedQueryTab> r113 = this.fixedQueryTabList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.enableHomepageAsr;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        FlashCardEntrance r119 = this.flashCardEntrance;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        StatusInfo r122 = this.statusInfo;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "GetLiveTutorFixedQueryResponse(fixedQueryList=" + this.fixedQueryList + ", nextCursorId=" + this.nextCursorId + ", hasMore=" + this.hasMore + ", recId=" + this.recId + ", fixedQueryTabList=" + this.fixedQueryTabList + ", enableHomepageAsr=" + this.enableHomepageAsr + ", flashCardEntrance=" + this.flashCardEntrance + ", statusInfo=" + this.statusInfo + ')';
    }

    public final Boolean getEnableHomepageAsr() {
        return this.enableHomepageAsr;
    }

    public final List<FixedQuery> getFixedQueryList() {
        return this.fixedQueryList;
    }

    public final List<FixedQueryTab> getFixedQueryTabList() {
        return this.fixedQueryTabList;
    }

    public final FlashCardEntrance getFlashCardEntrance() {
        return this.flashCardEntrance;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final Long getNextCursorId() {
        return this.nextCursorId;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final void setEnableHomepageAsr(Boolean r100) {
        this.enableHomepageAsr = r100;
    }

    public final void setFixedQueryList(List<FixedQuery> r100) {
        this.fixedQueryList = r100;
    }

    public final void setFixedQueryTabList(List<FixedQueryTab> r100) {
        this.fixedQueryTabList = r100;
    }

    public final void setFlashCardEntrance(FlashCardEntrance r100) {
        this.flashCardEntrance = r100;
    }

    public final void setHasMore(Boolean r100) {
        this.hasMore = r100;
    }

    public final void setNextCursorId(Long r100) {
        this.nextCursorId = r100;
    }

    public final void setRecId(String r100) {
        this.recId = r100;
    }

    public final void setStatusInfo(StatusInfo r100) {
        this.statusInfo = r100;
    }

    public GetLiveTutorFixedQueryResponse(List<FixedQuery> r100, Long r101, Boolean r102, String r103, List<FixedQueryTab> r104, Boolean r105, FlashCardEntrance r106, StatusInfo r107) {
        this.fixedQueryList = r100;
        this.nextCursorId = r101;
        this.hasMore = r102;
        this.recId = r103;
        this.fixedQueryTabList = r104;
        this.enableHomepageAsr = r105;
        this.flashCardEntrance = r106;
        this.statusInfo = r107;
    }

    public /* synthetic */ GetLiveTutorFixedQueryResponse(List r110, Long r111, Boolean r112, String r113, List r114, Boolean r115, FlashCardEntrance r116, StatusInfo r117, int r118, DefaultConstructorMarker r119) {
        StatusInfo r100 = null;
        if ((r118 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Boolean r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        FlashCardEntrance r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
