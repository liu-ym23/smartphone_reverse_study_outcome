package com.ss.android.ugc.aweme.discover.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import com.ss.android.ugc.aweme.search.common.ab.ECSearchExperiment;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\"\u001a\u00020\u001a\u0012\u001e\b\u0002\u0010'\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050&\u0018\u00010%\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00100\u001a\u00020\u001a\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010A\u001a\u00020\u000f\u0012\u0018\b\u0002\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010%\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bK\u0010LJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0000H\u0016R$\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R8\u0010'\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\"\u00100\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R$\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\n\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR*\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b<\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0011\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015R2\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010(\u001a\u0004\bF\u0010*\"\u0004\bG\u0010,R$\u0010H\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\n\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000e¨\u0006M"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityDynamicPatch;", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "", "useWaterfallRawData", "useSingleRawData", "", "data", "updateOriginSingleRawData", "clone", "originSingleRawData", "Ljava/lang/String;", "getOriginSingleRawData", "()Ljava/lang/String;", "setOriginSingleRawData", "(Ljava/lang/String;)V", "", "f", "Z", "isTopSectionView", "()Z", "setTopSectionView", "(Z)V", ce.f26391f, "getHasSideBar", "setHasSideBar", "hasSideBar", "", "h", "I", "getSubBoardWidth", "()I", "setSubBoardWidth", "(I)V", "subBoardWidth", "awemeIndex", "getAwemeIndex", "setAwemeIndex", "", "", "queryAndPidListMap", "Ljava/util/Map;", "getQueryAndPidListMap", "()Ljava/util/Map;", "setQueryAndPidListMap", "(Ljava/util/Map;)V", "waterfallLayoutSchema", "getWaterfallLayoutSchema", "setWaterfallLayoutSchema", "filteredInVideoDetail", "getFilteredInVideoDetail", "setFilteredInVideoDetail", "waterfallLayoutRawData", "getWaterfallLayoutRawData", "setWaterfallLayoutRawData", "preloadImage", "Ljava/util/List;", "getPreloadImage", "()Ljava/util/List;", "setPreloadImage", "(Ljava/util/List;)V", "isDowngrade", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setDowngrade", "(Ljava/lang/Boolean;)V", "enableCeiling", "getEnableCeiling", "setEnableCeiling", "", "ecAiSearchSessionContext", "getEcAiSearchSessionContext", "setEcAiSearchSessionContext", "waterfallLayoutSchemaSingle", "getWaterfallLayoutSchemaSingle", "setWaterfallLayoutSchemaSingle", "<init>", "(ILjava/util/Map;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/Boolean;ZLjava/util/Map;Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityDynamicPatch extends DynamicPatch {

    @SerializedName("aweme_index")
    private int awemeIndex;

    @SerializedName("ec_ai_search_session_context")
    private Map<String, ? extends Object> ecAiSearchSessionContext;

    @SerializedName("enable_ceiling")
    private boolean enableCeiling;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient boolean f450498f;

    @SerializedName("filtered_in_video_detail")
    private int filteredInVideoDetail;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient boolean f450499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f450500h;

    @SerializedName("is_downgrade")
    private Boolean isDowngrade;
    private String originSingleRawData;

    @SerializedName("preload_image")
    private List<String> preloadImage;

    @SerializedName("query_and_pid_list")
    private Map<String, ? extends List<String>> queryAndPidListMap;

    @SerializedName("waterfall_layout_raw_data")
    private String waterfallLayoutRawData;

    @SerializedName("waterfall_layout_schema")
    private String waterfallLayoutSchema;
    private String waterfallLayoutSchemaSingle;

    public SearchCommodityDynamicPatch() {
        this(0, null, null, 0, null, null, null, false, null, null, 1023, null);
    }

    public final void useSingleRawData() {
        String r100 = this.originSingleRawData;
        if (r100 != null) goto L6;
        this.originSingleRawData = this.rawData;
        return;
    L6:
        if (r100 == null) goto L9;
        this.rawData = r100;
        return;
    }

    public final void useWaterfallRawData() {
        if (this.originSingleRawData != null) goto L6;
        this.originSingleRawData = this.rawData;
    L6:
        if (ECSearchExperiment.h() == false) goto L20;
        String r100 = this.waterfallLayoutRawData;
        if (r100 == null) goto L24;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == true) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L25;
        this.rawData = r100;
        return;
    L25:
        return;
    L12:
        if ((!Intrinsics.areEqual(r100, "null")) == false) goto L14;
    L24:
        return;
    L20:
        String r102 = this.waterfallLayoutRawData;
        if (r102 == null) goto L27;
        this.rawData = r102;
        return;
    }

    @Override // com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch
    public SearchCommodityDynamicPatch clone() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        return (SearchCommodityDynamicPatch) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.discover.model.SearchCommodityDynamicPatch");
    }

    public final int getAwemeIndex() {
        return this.awemeIndex;
    }

    public final Map<String, Object> getEcAiSearchSessionContext() {
        return this.ecAiSearchSessionContext;
    }

    public final boolean getEnableCeiling() {
        return this.enableCeiling;
    }

    public final int getFilteredInVideoDetail() {
        return this.filteredInVideoDetail;
    }

    public final boolean getHasSideBar() {
        return this.f450499g;
    }

    public final String getOriginSingleRawData() {
        return this.originSingleRawData;
    }

    public final List<String> getPreloadImage() {
        return this.preloadImage;
    }

    public final Map<String, List<String>> getQueryAndPidListMap() {
        return this.queryAndPidListMap;
    }

    public final int getSubBoardWidth() {
        return this.f450500h;
    }

    public final String getWaterfallLayoutRawData() {
        return this.waterfallLayoutRawData;
    }

    public final String getWaterfallLayoutSchema() {
        return this.waterfallLayoutSchema;
    }

    public final String getWaterfallLayoutSchemaSingle() {
        return this.waterfallLayoutSchemaSingle;
    }

    public final Boolean isDowngrade() {
        return this.isDowngrade;
    }

    public final boolean isTopSectionView() {
        return this.f450498f;
    }

    @Override // com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    public final void setAwemeIndex(int r100) {
        this.awemeIndex = r100;
    }

    public final void setDowngrade(Boolean r100) {
        this.isDowngrade = r100;
    }

    public final void setEcAiSearchSessionContext(Map<String, ? extends Object> r100) {
        this.ecAiSearchSessionContext = r100;
    }

    public final void setEnableCeiling(boolean r100) {
        this.enableCeiling = r100;
    }

    public final void setFilteredInVideoDetail(int r100) {
        this.filteredInVideoDetail = r100;
    }

    public final void setHasSideBar(boolean r100) {
        this.f450499g = r100;
    }

    public final void setOriginSingleRawData(String r100) {
        this.originSingleRawData = r100;
    }

    public final void setPreloadImage(List<String> r100) {
        this.preloadImage = r100;
    }

    public final void setQueryAndPidListMap(Map<String, ? extends List<String>> r100) {
        this.queryAndPidListMap = r100;
    }

    public final void setSubBoardWidth(int r100) {
        this.f450500h = r100;
    }

    public final void setTopSectionView(boolean r100) {
        this.f450498f = r100;
    }

    public final void setWaterfallLayoutRawData(String r100) {
        this.waterfallLayoutRawData = r100;
    }

    public final void setWaterfallLayoutSchema(String r100) {
        this.waterfallLayoutSchema = r100;
    }

    public final void setWaterfallLayoutSchemaSingle(String r100) {
        this.waterfallLayoutSchemaSingle = r100;
    }

    public final void updateOriginSingleRawData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.originSingleRawData = r100;
    }

    public SearchCommodityDynamicPatch(int r100, Map<String, ? extends List<String>> r101, String r102, int r103, String r104, List<String> r105, Boolean r106, boolean r107, Map<String, ? extends Object> r108, String r110) {
        this.awemeIndex = r100;
        this.queryAndPidListMap = r101;
        this.waterfallLayoutSchema = r102;
        this.filteredInVideoDetail = r103;
        this.waterfallLayoutRawData = r104;
        this.preloadImage = r105;
        this.isDowngrade = r106;
        this.enableCeiling = r107;
        this.ecAiSearchSessionContext = r108;
        this.waterfallLayoutSchemaSingle = r110;
    }

    public /* synthetic */ SearchCommodityDynamicPatch(int r110, Map r111, String r112, int r113, String r114, List r115, Boolean r116, boolean r117, Map r210, String r211, int r212, DefaultConstructorMarker r213) {
        boolean r100 = false;
        if ((r212 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = null;
        if ((r212 & 2) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r107 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Boolean r108 = Boolean.FALSE;
    L31:
        if ((r212 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Map r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r102 = r211;
    L42:
        this(r101, r103, r104, r105, r106, r107, r108, r100, r118, r102);
        return;
    L37:
        r118 = r210;
        goto L39
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
