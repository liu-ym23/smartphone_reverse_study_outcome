package com.larus.livetutor.impl.home.data;

import com.larus.livetutor.api.idl.FixedQuery;
import com.larus.livetutor.api.idl.FlashCardEntrance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GB\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u00105\u001a\u00020\u000eJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003J\t\u0010>\u001a\u00020\u0012HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007HÆ\u0003J\u0088\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u000e2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010'R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001b¨\u0006H"}, d2 = {"Lcom/larus/livetutor/impl/home/data/LiveTutorFeedData;", "", "tabId", "", "title", "", "fixedQueryList", "", "Lcom/larus/livetutor/api/idl/FixedQuery;", "flashCardEntrance", "Lcom/larus/livetutor/api/idl/FlashCardEntrance;", "nextCursorId", "recId", "hasMore", "", "loadingState", "Lcom/larus/livetutor/impl/home/data/LoadingState;", "loadMoreState", "Lcom/larus/livetutor/impl/home/data/LoadMoreState;", "exposedQueryList", "<init>", "(JLjava/lang/String;Ljava/util/List;Lcom/larus/livetutor/api/idl/FlashCardEntrance;Ljava/lang/Long;Ljava/lang/String;ZLcom/larus/livetutor/impl/home/data/LoadingState;Lcom/larus/livetutor/impl/home/data/LoadMoreState;Ljava/util/List;)V", "getTabId", "()J", "getTitle", "()Ljava/lang/String;", "getFixedQueryList", "()Ljava/util/List;", "getFlashCardEntrance", "()Lcom/larus/livetutor/api/idl/FlashCardEntrance;", "setFlashCardEntrance", "(Lcom/larus/livetutor/api/idl/FlashCardEntrance;)V", "getNextCursorId", "()Ljava/lang/Long;", "setNextCursorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRecId", "setRecId", "(Ljava/lang/String;)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLoadingState", "()Lcom/larus/livetutor/impl/home/data/LoadingState;", "setLoadingState", "(Lcom/larus/livetutor/impl/home/data/LoadingState;)V", "getLoadMoreState", "()Lcom/larus/livetutor/impl/home/data/LoadMoreState;", "setLoadMoreState", "(Lcom/larus/livetutor/impl/home/data/LoadMoreState;)V", "getExposedQueryList", "preCheckCanLoadMore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JLjava/lang/String;Ljava/util/List;Lcom/larus/livetutor/api/idl/FlashCardEntrance;Ljava/lang/Long;Ljava/lang/String;ZLcom/larus/livetutor/impl/home/data/LoadingState;Lcom/larus/livetutor/impl/home/data/LoadMoreState;Ljava/util/List;)Lcom/larus/livetutor/impl/home/data/LiveTutorFeedData;", "equals", "other", "hashCode", "", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorFeedData {
    public static final long ALL_TAB_ID = 0;
    public static final a Companion = null;
    public static final long DEFAULT_TAB_ID = -1;
    private final List<String> exposedQueryList;
    private final List<FixedQuery> fixedQueryList;
    private FlashCardEntrance flashCardEntrance;
    private boolean hasMore;
    private LoadMoreState loadMoreState;
    private LoadingState loadingState;
    private Long nextCursorId;
    private String recId;
    private final long tabId;
    private final String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveTutorFeedData copy$default(LiveTutorFeedData r110, long r111, String r112, List r113, FlashCardEntrance r114, Long r115, String r116, boolean r210, LoadingState r211, LoadMoreState r212, List r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = r110.tabId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r102 = r110.fixedQueryList;
    L15:
        if ((r214 & 8) == 0) goto L17;
        FlashCardEntrance r103 = r110.flashCardEntrance;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Long r104 = r110.nextCursorId;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.recId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        boolean r106 = r110.hasMore;
    L31:
        if ((r214 & 128) == 0) goto L33;
        LoadingState r117 = r110.loadingState;
    L35:
        if ((r214 & 256) == 0) goto L37;
        LoadMoreState r118 = r110.loadMoreState;
    L39:
        if ((r214 & 512) == 0) goto L41;
        List r107 = r110.exposedQueryList;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
    L41:
        r107 = r213;
        goto L43
    L37:
        r118 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.tabId;
    }

    public final List<String> component10() {
        return this.exposedQueryList;
    }

    public final String component2() {
        return this.title;
    }

    public final List<FixedQuery> component3() {
        return this.fixedQueryList;
    }

    public final FlashCardEntrance component4() {
        return this.flashCardEntrance;
    }

    public final Long component5() {
        return this.nextCursorId;
    }

    public final String component6() {
        return this.recId;
    }

    public final boolean component7() {
        return this.hasMore;
    }

    public final LoadingState component8() {
        return this.loadingState;
    }

    public final LoadMoreState component9() {
        return this.loadMoreState;
    }

    public final LiveTutorFeedData copy(long r110, String r111, List<FixedQuery> r112, FlashCardEntrance r113, Long r114, String r210, boolean r211, LoadingState r212, LoadMoreState r213, List<String> r214) {
        Intrinsics.checkNotNullParameter(r112, "fixedQueryList");
        Intrinsics.checkNotNullParameter(r212, "loadingState");
        Intrinsics.checkNotNullParameter(r213, "loadMoreState");
        Intrinsics.checkNotNullParameter(r214, "exposedQueryList");
        return new LiveTutorFeedData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorFeedData) == true) goto L8;
        return false;
    L8:
        LiveTutorFeedData r101 = (LiveTutorFeedData) r100;
        if (this.tabId == r101.tabId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fixedQueryList, r101.fixedQueryList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flashCardEntrance, r101.flashCardEntrance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextCursorId, r101.nextCursorId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recId, r101.recId) == true) goto L27;
        return false;
    L27:
        if (this.hasMore == r101.hasMore) goto L30;
        return false;
    L30:
        if (this.loadingState == r101.loadingState) goto L33;
        return false;
    L33:
        if (this.loadMoreState == r101.loadMoreState) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.exposedQueryList, r101.exposedQueryList) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        long r100 = this.tabId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.title;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (((r101 + r104) * 31) + this.fixedQueryList.hashCode()) * 31;
        FlashCardEntrance r106 = this.flashCardEntrance;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.nextCursorId;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.recId;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        int r113 = (r111 + r103) * 31;
        if (this.hasMore == false) goto L21;
        int r114 = 1231;
    L23:
        return ((((((r113 + r114) * 31) + this.loadingState.hashCode()) * 31) + this.loadMoreState.hashCode()) * 31) + this.exposedQueryList.hashCode();
    L21:
        r114 = 1237;
        goto L23
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "LiveTutorFeedData(tabId=" + this.tabId + ", title=" + this.title + ", fixedQueryList=" + this.fixedQueryList + ", flashCardEntrance=" + this.flashCardEntrance + ", nextCursorId=" + this.nextCursorId + ", recId=" + this.recId + ", hasMore=" + this.hasMore + ", loadingState=" + this.loadingState + ", loadMoreState=" + this.loadMoreState + ", exposedQueryList=" + this.exposedQueryList + ')';
    }

    public final boolean preCheckCanLoadMore() {
        if (this.hasMore == true) goto L5;
    L11:
        return false;
    L5:
        if (this.loadingState == LoadingState.Loading) goto L11;
        LoadMoreState r100 = this.loadMoreState;
        if (r100 == LoadMoreState.Loading) goto L11;
        if (r100 == LoadMoreState.Error) goto L11;
        return true;
    }

    public final List<String> getExposedQueryList() {
        return this.exposedQueryList;
    }

    public final List<FixedQuery> getFixedQueryList() {
        return this.fixedQueryList;
    }

    public final FlashCardEntrance getFlashCardEntrance() {
        return this.flashCardEntrance;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final LoadMoreState getLoadMoreState() {
        return this.loadMoreState;
    }

    public final LoadingState getLoadingState() {
        return this.loadingState;
    }

    public final Long getNextCursorId() {
        return this.nextCursorId;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final long getTabId() {
        return this.tabId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setFlashCardEntrance(FlashCardEntrance r100) {
        this.flashCardEntrance = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setLoadMoreState(LoadMoreState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadMoreState = r100;
    }

    public final void setLoadingState(LoadingState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadingState = r100;
    }

    public final void setNextCursorId(Long r100) {
        this.nextCursorId = r100;
    }

    public final void setRecId(String r100) {
        this.recId = r100;
    }

    public LiveTutorFeedData(long r100, String r101, List<FixedQuery> r102, FlashCardEntrance r103, Long r104, String r105, boolean r106, LoadingState r110, LoadMoreState r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r102, "fixedQueryList");
        Intrinsics.checkNotNullParameter(r110, "loadingState");
        Intrinsics.checkNotNullParameter(r111, "loadMoreState");
        Intrinsics.checkNotNullParameter(r112, "exposedQueryList");
        this.tabId = r100;
        this.title = r101;
        this.fixedQueryList = r102;
        this.flashCardEntrance = r103;
        this.nextCursorId = r104;
        this.recId = r105;
        this.hasMore = r106;
        this.loadingState = r110;
        this.loadMoreState = r111;
        this.exposedQueryList = r112;
    }

    public /* synthetic */ LiveTutorFeedData(long r110, String r111, List r112, FlashCardEntrance r113, Long r210, String r211, boolean r212, LoadingState r213, LoadMoreState r214, List r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 2) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r216 & 4) == 0) goto L9;
        List r101 = new ArrayList();
    L11:
        if ((r216 & 8) == 0) goto L13;
        FlashCardEntrance r102 = null;
    L15:
        if ((r216 & 16) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r216 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r216 & 64) == 0) goto L25;
        boolean r114 = true;
    L27:
        if ((r216 & 128) == 0) goto L29;
        LoadingState r115 = LoadingState.Init;
    L31:
        if ((r216 & 256) == 0) goto L33;
        LoadMoreState r116 = LoadMoreState.Success;
    L35:
        if ((r216 & 512) == 0) goto L37;
        List r117 = new ArrayList();
    L38:
        this(r110, r100, r101, r102, r103, r104, r114, r115, r116, r117);
        return;
    L37:
        r117 = r215;
        goto L38
    L33:
        r116 = r214;
        goto L35
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
