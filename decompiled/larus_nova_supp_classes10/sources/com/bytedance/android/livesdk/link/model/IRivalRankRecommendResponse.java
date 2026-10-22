package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001wR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\b\u001a\u0004\b(\u0010 R\u001c\u0010.\u001a\u0004\u0018\u00010*8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010,R\u001c\u00103\u001a\u0004\u0018\u00010/8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u00101R\u001a\u00106\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\b\u001a\u0004\b4\u0010 R\u001a\u0010;\u001a\u0002078&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\b\u001a\u0004\b8\u00109R\u001a\u0010>\u001a\u0002078&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\b\u001a\u0004\b<\u00109R:\u0010E\u001a\"\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@\u0018\u00010?j\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@\u0018\u0001`A8&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010\b\u001a\u0004\bB\u0010CR\"\u0010J\u001a\u0002078&@&X§\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\b\u001a\u0004\bF\u00109\"\u0004\bG\u0010HR\"\u0010P\u001a\u00020@8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bO\u0010\b\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR6\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020R\u0018\u00010Qj\n\u0012\u0004\u0012\u00020R\u0018\u0001`S8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\b\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Z\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b]\u0010\b\u001a\u0004\bZ\u0010 \"\u0004\b[\u0010\\R\"\u0010a\u001a\u00020@8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\b\u001a\u0004\b^\u0010L\"\u0004\b_\u0010NR\"\u0010h\u001a\u00020b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bg\u0010\b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010i\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\bj\u0010\b\u001a\u0004\bi\u0010 R\u001c\u0010o\u001a\u0004\u0018\u00010k8&X§\u0004¢\u0006\f\u0012\u0004\bn\u0010\b\u001a\u0004\bl\u0010mR\u001c\u0010t\u001a\u0004\u0018\u00010p8&X§\u0004¢\u0006\f\u0012\u0004\bs\u0010\b\u001a\u0004\bq\u0010rR\u001a\u0010u\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\bv\u0010\b\u001a\u0004\bu\u0010 ¨\u0006x"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalRankRecommendResponse;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/s2;", "getTabRivals", "()Lcom/bytedance/android/livesdk/link/model/s2;", "setTabRivals", "(Lcom/bytedance/android/livesdk/link/model/s2;)V", "getTabRivals$annotations", "()V", "tabRivals", "Lcom/bytedance/android/livesdk/link/model/l8;", "getSearchBar", "()Lcom/bytedance/android/livesdk/link/model/l8;", "getSearchBar$annotations", "searchBar", "Lcom/bytedance/android/livesdk/link/model/m8;", "getTipBar", "()Lcom/bytedance/android/livesdk/link/model/m8;", "getTipBar$annotations", "tipBar", "", "getSkinType", "()I", "getSkinType$annotations", "skinType", "Lcom/bytedance/android/livesdk/link/model/ITopTip;", "getTopTip", "()Lcom/bytedance/android/livesdk/link/model/ITopTip;", "getTopTip$annotations", "topTip", "", "getAcceptPrecisionMatch", "()Z", "getAcceptPrecisionMatch$annotations", "acceptPrecisionMatch", "Lcom/bytedance/android/livesdk/link/model/n7;", "getPanelBanner", "()Lcom/bytedance/android/livesdk/link/model/n7;", "getPanelBanner$annotations", "panelBanner", "isNewAnchor", "isNewAnchor$annotations", "Lcom/bytedance/android/livesdk/link/model/v7;", "getCommonBanner", "()Lcom/bytedance/android/livesdk/link/model/v7;", "getCommonBanner$annotations", "commonBanner", "Lcom/bytedance/android/livesdk/link/model/j8;", "getAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/j8;", "getAutoMatchInfo$annotations", "autoMatchInfo", "getDisplayMultiMatch", "getDisplayMultiMatch$annotations", "displayMultiMatch", "", "getTabLocate", "()J", "getTabLocate$annotations", "tabLocate", "getDurationTime", "getDurationTime$annotations", "durationTime", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getListAbValueMap", "()Ljava/util/Map;", "getListAbValueMap$annotations", "listAbValueMap", "getLoadType", "setLoadType", "(J)V", "getLoadType$annotations", "loadType", "getMultiBrawlInfo", "()Ljava/lang/String;", "setMultiBrawlInfo", "(Ljava/lang/String;)V", "getMultiBrawlInfo$annotations", "multiBrawlInfo", "", "Lcom/bytedance/android/livesdk/link/model/y7;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSubTabs", "()Ljava/util/List;", "setSubTabs", "(Ljava/util/List;)V", "getSubTabs$annotations", "subTabs", "isNewPkAnchor", "setNewPkAnchor", "(Z)V", "isNewPkAnchor$annotations", "getPkSeasonInfo", "setPkSeasonInfo", "getPkSeasonInfo$annotations", "pkSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/u8;", "getRivalsExtra", "()Lcom/bytedance/android/livesdk/link/model/u8;", "setRivalsExtra", "(Lcom/bytedance/android/livesdk/link/model/u8;)V", "getRivalsExtra$annotations", "rivalsExtra", "isUnReadReserveRecord", "isUnReadReserveRecord$annotations", "Lcom/bytedance/android/livesdk/link/model/s8;", "getRankSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/s8;", "getRankSeasonInfo$annotations", "rankSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/r8;", "getPopInfo", "()Lcom/bytedance/android/livesdk/link/model/r8;", "getPopInfo$annotations", "popInfo", "isOpenAutoFindPeople", "isOpenAutoFindPeople$annotations", "LoadType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRivalRankRecommendResponse extends vh7.c<IRivalRankRecommendResponse> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalRankRecommendResponse$LoadType;", "", "All", "Other", "OnlyRecommendRivals", "OnlyFollowRivals", "OnlyFlexActivity", "OnlyCommonPanel", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType All = null;
        public static final LoadType OnlyCommonPanel = null;
        public static final LoadType OnlyFlexActivity = null;
        public static final LoadType OnlyFollowRivals = null;
        public static final LoadType OnlyRecommendRivals = null;
        public static final LoadType Other = null;
        public static final /* synthetic */ LoadType[] a = null;

        static {
            LoadType r1 = new LoadType("All", 0);
            All = r1;
            LoadType r2 = new LoadType("Other", 1);
            Other = r2;
            LoadType r3 = new LoadType("OnlyRecommendRivals", 2);
            OnlyRecommendRivals = r3;
            LoadType r4 = new LoadType("OnlyFollowRivals", 3);
            OnlyFollowRivals = r4;
            LoadType r5 = new LoadType("OnlyFlexActivity", 4);
            OnlyFlexActivity = r5;
            LoadType r6 = new LoadType("OnlyCommonPanel", 5);
            OnlyCommonPanel = r6;
            a = new LoadType[]{r1, r2, r3, r4, r5, r6};
        }

        public static LoadType valueOf(String r1) {
            return (LoadType) r27.a.a(LoadType.class, r1);
        }

        public static LoadType[] values() {
            return (LoadType[]) a.clone();
        }

        public LoadType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "accept_precision_match")
    boolean getAcceptPrecisionMatch();

    @FieldName(name = "match_info")
    j8 getAutoMatchInfo();

    @FieldName(name = "common_banner")
    v7 getCommonBanner();

    @FieldName(name = "display_multi_match")
    boolean getDisplayMultiMatch();

    @FieldName(name = "duration_time")
    long getDurationTime();

    @FieldName(name = "ab_test_value_map")
    Map<String, String> getListAbValueMap();

    @FieldName(name = "load_type")
    long getLoadType();

    @FieldName(name = "multi_brawl_info")
    String getMultiBrawlInfo();

    @FieldName(name = "panel_banner")
    n7 getPanelBanner();

    @FieldName(name = "pk_season_info")
    String getPkSeasonInfo();

    @FieldName(name = "popup_info")
    r8 getPopInfo();

    @FieldName(name = "rank_season_info")
    s8 getRankSeasonInfo();

    @FieldName(name = "rivals_extra")
    u8 getRivalsExtra();

    @FieldName(name = "search_bar")
    l8 getSearchBar();

    @FieldName(name = "skin_type")
    int getSkinType();

    @FieldName(name = "pk_sub_tabs")
    List<y7> getSubTabs();

    @FieldName(name = "tab_locate")
    long getTabLocate();

    @FieldName(name = "rivals")
    s2 getTabRivals();

    @FieldName(name = "tip_bar")
    m8 getTipBar();

    @FieldName(name = "top_tip")
    ITopTip getTopTip();

    @FieldName(name = "is_new_anchor")
    boolean isNewAnchor();

    @FieldName(name = "is_new_pk_anchor")
    boolean isNewPkAnchor();

    @FieldName(name = "is_open_auto_start_find_people")
    boolean isOpenAutoFindPeople();

    @FieldName(name = "is_unread_reserve_record")
    boolean isUnReadReserveRecord();

    @FieldName(name = "load_type#setter")
    void setLoadType(long r1);

    @FieldName(name = "multi_brawl_info#setter")
    void setMultiBrawlInfo(String r1);

    @FieldName(name = "is_new_pk_anchor#setter")
    void setNewPkAnchor(boolean r1);

    @FieldName(name = "pk_season_info#setter")
    void setPkSeasonInfo(String r1);

    @FieldName(name = "rivals_extra#setter")
    void setRivalsExtra(u8 r1);

    @FieldName(name = "pk_sub_tabs#setter")
    void setSubTabs(List<? extends y7> r1);

    @FieldName(name = "rivals#setter")
    void setTabRivals(s2 r1);
}
