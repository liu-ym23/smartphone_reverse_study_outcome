package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J¥\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0010HÖ\u0001J\t\u00107\u001a\u00020\rHÖ\u0001R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018¨\u00068"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchTabIndexRollbackSwitchConfig;", "", "enable", "", "searchHideDefaultTab", "openPreloadOnGoodsTab", "openReloadOnGoodsTab", "whenSwitchTabCanRelease", "mobTabSwitchOpen", "ecSearchVhPreloadTask", "ecSearchNeedMutliTab", "ecSearchHasTabOpen", "", "", "ecSearchTabCanScroll", "ecSearchTabCanScrollFromPageType", "", "prefetchRollbackSwitch", "repairTabCreationSwitch", "ecSearchHistoricalWordOneClick", "(ZZZZZZZZLjava/util/List;ZLjava/util/List;ZZZ)V", "getEcSearchHasTabOpen", "()Ljava/util/List;", "getEcSearchHistoricalWordOneClick", "()Z", "getEcSearchNeedMutliTab", "getEcSearchTabCanScroll", "getEcSearchTabCanScrollFromPageType", "getEcSearchVhPreloadTask", "getEnable", "getMobTabSwitchOpen", "getOpenPreloadOnGoodsTab", "getOpenReloadOnGoodsTab", "getPrefetchRollbackSwitch", "getRepairTabCreationSwitch", "getSearchHideDefaultTab", "getWhenSwitchTabCanRelease", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchTabIndexRollbackSwitchConfig {

    @SerializedName("ec_search_has_tab")
    private final List<String> ecSearchHasTabOpen;

    @SerializedName("ec_search_historical_word_one_click")
    private final boolean ecSearchHistoricalWordOneClick;

    @SerializedName("ec_search_need_mutli_tab")
    private final boolean ecSearchNeedMutliTab;

    @SerializedName("ec_search_tab_can_scroll")
    private final boolean ecSearchTabCanScroll;

    @SerializedName("ec_search_tab_can_scroll_from_page_type")
    private final List<Integer> ecSearchTabCanScrollFromPageType;

    @SerializedName("ec_search_vh_preload_task")
    private final boolean ecSearchVhPreloadTask;

    @SerializedName("search_tab_index_rollback_enable")
    private final boolean enable;

    @SerializedName("mob_tab_switch_open")
    private final boolean mobTabSwitchOpen;

    @SerializedName("open_preload_on_goods_tab")
    private final boolean openPreloadOnGoodsTab;

    @SerializedName("open_reload_on_goods_tab")
    private final boolean openReloadOnGoodsTab;

    @SerializedName("prefetch_rollback_switch")
    private final boolean prefetchRollbackSwitch;

    @SerializedName("repair_tab_creation_switch")
    private final boolean repairTabCreationSwitch;

    @SerializedName("search_hide_default_tab")
    private final boolean searchHideDefaultTab;

    @SerializedName("when_switch_tab_can_release")
    private final boolean whenSwitchTabCanRelease;

    public SearchTabIndexRollbackSwitchConfig() {
        this(false, false, false, false, false, false, false, false, null, false, null, false, false, false, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchTabIndexRollbackSwitchConfig copy$default(SearchTabIndexRollbackSwitchConfig r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r210, boolean r211, boolean r212, boolean r213, List r214, boolean r215, List r216, boolean r217, boolean r218, boolean r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        boolean r100 = r110.enable;
    L7:
        if ((r310 & 2) == 0) goto L9;
        boolean r101 = r110.searchHideDefaultTab;
    L11:
        if ((r310 & 4) == 0) goto L13;
        boolean r102 = r110.openPreloadOnGoodsTab;
    L15:
        if ((r310 & 8) == 0) goto L17;
        boolean r103 = r110.openReloadOnGoodsTab;
    L19:
        if ((r310 & 16) == 0) goto L21;
        boolean r104 = r110.whenSwitchTabCanRelease;
    L23:
        if ((r310 & 32) == 0) goto L25;
        boolean r105 = r110.mobTabSwitchOpen;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r106 = r110.ecSearchVhPreloadTask;
    L31:
        if ((r310 & 128) == 0) goto L33;
        boolean r107 = r110.ecSearchNeedMutliTab;
    L35:
        if ((r310 & 256) == 0) goto L37;
        List r115 = r110.ecSearchHasTabOpen;
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r116 = r110.ecSearchTabCanScroll;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        List r117 = r110.ecSearchTabCanScrollFromPageType;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        boolean r118 = r110.prefetchRollbackSwitch;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        boolean r119 = r110.repairTabCreationSwitch;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        boolean r108 = r110.ecSearchHistoricalWordOneClick;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final boolean component1() {
        return this.enable;
    }

    public final boolean component10() {
        return this.ecSearchTabCanScroll;
    }

    public final List<Integer> component11() {
        return this.ecSearchTabCanScrollFromPageType;
    }

    public final boolean component12() {
        return this.prefetchRollbackSwitch;
    }

    public final boolean component13() {
        return this.repairTabCreationSwitch;
    }

    public final boolean component14() {
        return this.ecSearchHistoricalWordOneClick;
    }

    public final boolean component2() {
        return this.searchHideDefaultTab;
    }

    public final boolean component3() {
        return this.openPreloadOnGoodsTab;
    }

    public final boolean component4() {
        return this.openReloadOnGoodsTab;
    }

    public final boolean component5() {
        return this.whenSwitchTabCanRelease;
    }

    public final boolean component6() {
        return this.mobTabSwitchOpen;
    }

    public final boolean component7() {
        return this.ecSearchVhPreloadTask;
    }

    public final boolean component8() {
        return this.ecSearchNeedMutliTab;
    }

    public final List<String> component9() {
        return this.ecSearchHasTabOpen;
    }

    public final SearchTabIndexRollbackSwitchConfig copy(boolean r110, boolean r111, boolean r112, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, List<String> r215, boolean r216, List<Integer> r217, boolean r218, boolean r219, boolean r310) {
        return new SearchTabIndexRollbackSwitchConfig(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchTabIndexRollbackSwitchConfig) == false) goto L34;
        SearchTabIndexRollbackSwitchConfig r101 = (SearchTabIndexRollbackSwitchConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.searchHideDefaultTab == r101.searchHideDefaultTab) goto L10;
        return false;
    L10:
        if (this.openPreloadOnGoodsTab == r101.openPreloadOnGoodsTab) goto L12;
        return false;
    L12:
        if (this.openReloadOnGoodsTab == r101.openReloadOnGoodsTab) goto L14;
        return false;
    L14:
        if (this.whenSwitchTabCanRelease == r101.whenSwitchTabCanRelease) goto L16;
        return false;
    L16:
        if (this.mobTabSwitchOpen == r101.mobTabSwitchOpen) goto L18;
        return false;
    L18:
        if (this.ecSearchVhPreloadTask == r101.ecSearchVhPreloadTask) goto L20;
        return false;
    L20:
        if (this.ecSearchNeedMutliTab == r101.ecSearchNeedMutliTab) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ecSearchHasTabOpen, r101.ecSearchHasTabOpen) == true) goto L24;
        return false;
    L24:
        if (this.ecSearchTabCanScroll == r101.ecSearchTabCanScroll) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.ecSearchTabCanScrollFromPageType, r101.ecSearchTabCanScrollFromPageType) == true) goto L28;
        return false;
    L28:
        if (this.prefetchRollbackSwitch == r101.prefetchRollbackSwitch) goto L30;
        return false;
    L30:
        if (this.repairTabCreationSwitch == r101.repairTabCreationSwitch) goto L32;
        return false;
    L32:
        if (this.ecSearchHistoricalWordOneClick == r101.ecSearchHistoricalWordOneClick) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.searchHideDefaultTab;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.openPreloadOnGoodsTab;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.openReloadOnGoodsTab;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.whenSwitchTabCanRelease;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.mobTabSwitchOpen;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.ecSearchVhPreloadTask;
        ?? r120 = r119;
        if (r119 == false) goto L23;
        r120 = 1;
    L23:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.ecSearchNeedMutliTab;
        ?? r123 = r122;
        if (r122 == false) goto L26;
        r123 = 1;
    L26:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.ecSearchHasTabOpen;
        int r126 = 0;
        if (r125 == null) goto L29;
        int r127 = r125.hashCode();
    L30:
        int r128 = (r124 + r127) * 31;
        boolean r129 = this.ecSearchTabCanScroll;
        ?? r130 = r129;
        if (r129 == false) goto L33;
        r130 = 1;
    L33:
        int r131 = (r128 + r130) * 31;
        List<Integer> r132 = this.ecSearchTabCanScrollFromPageType;
        if (r132 == null) goto L36;
        r126 = r132.hashCode();
    L36:
        int r133 = (r131 + r126) * 31;
        boolean r134 = this.prefetchRollbackSwitch;
        ?? r135 = r134;
        if (r134 == false) goto L39;
        r135 = 1;
    L39:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.repairTabCreationSwitch;
        ?? r138 = r137;
        if (r137 == false) goto L42;
        r138 = 1;
    L42:
        int r139 = (r136 + r138) * 31;
        boolean r140 = this.ecSearchHistoricalWordOneClick;
        if (r140 == true) goto L47;
        r101 = r140;
    L47:
        return r139 + r101;
    L29:
        r127 = 0;
        goto L30
    }

    public String toString() {
        return "SearchTabIndexRollbackSwitchConfig(enable=" + this.enable + ", searchHideDefaultTab=" + this.searchHideDefaultTab + ", openPreloadOnGoodsTab=" + this.openPreloadOnGoodsTab + ", openReloadOnGoodsTab=" + this.openReloadOnGoodsTab + ", whenSwitchTabCanRelease=" + this.whenSwitchTabCanRelease + ", mobTabSwitchOpen=" + this.mobTabSwitchOpen + ", ecSearchVhPreloadTask=" + this.ecSearchVhPreloadTask + ", ecSearchNeedMutliTab=" + this.ecSearchNeedMutliTab + ", ecSearchHasTabOpen=" + this.ecSearchHasTabOpen + ", ecSearchTabCanScroll=" + this.ecSearchTabCanScroll + ", ecSearchTabCanScrollFromPageType=" + this.ecSearchTabCanScrollFromPageType + ", prefetchRollbackSwitch=" + this.prefetchRollbackSwitch + ", repairTabCreationSwitch=" + this.repairTabCreationSwitch + ", ecSearchHistoricalWordOneClick=" + this.ecSearchHistoricalWordOneClick + ")";
    }

    public final List<String> getEcSearchHasTabOpen() {
        return this.ecSearchHasTabOpen;
    }

    public final boolean getEcSearchHistoricalWordOneClick() {
        return this.ecSearchHistoricalWordOneClick;
    }

    public final boolean getEcSearchNeedMutliTab() {
        return this.ecSearchNeedMutliTab;
    }

    public final boolean getEcSearchTabCanScroll() {
        return this.ecSearchTabCanScroll;
    }

    public final List<Integer> getEcSearchTabCanScrollFromPageType() {
        return this.ecSearchTabCanScrollFromPageType;
    }

    public final boolean getEcSearchVhPreloadTask() {
        return this.ecSearchVhPreloadTask;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getMobTabSwitchOpen() {
        return this.mobTabSwitchOpen;
    }

    public final boolean getOpenPreloadOnGoodsTab() {
        return this.openPreloadOnGoodsTab;
    }

    public final boolean getOpenReloadOnGoodsTab() {
        return this.openReloadOnGoodsTab;
    }

    public final boolean getPrefetchRollbackSwitch() {
        return this.prefetchRollbackSwitch;
    }

    public final boolean getRepairTabCreationSwitch() {
        return this.repairTabCreationSwitch;
    }

    public final boolean getSearchHideDefaultTab() {
        return this.searchHideDefaultTab;
    }

    public final boolean getWhenSwitchTabCanRelease() {
        return this.whenSwitchTabCanRelease;
    }

    public SearchTabIndexRollbackSwitchConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, List<String> r108, boolean r110, List<Integer> r111, boolean r112, boolean r113, boolean r114) {
        this.enable = r100;
        this.searchHideDefaultTab = r101;
        this.openPreloadOnGoodsTab = r102;
        this.openReloadOnGoodsTab = r103;
        this.whenSwitchTabCanRelease = r104;
        this.mobTabSwitchOpen = r105;
        this.ecSearchVhPreloadTask = r106;
        this.ecSearchNeedMutliTab = r107;
        this.ecSearchHasTabOpen = r108;
        this.ecSearchTabCanScroll = r110;
        this.ecSearchTabCanScrollFromPageType = r111;
        this.prefetchRollbackSwitch = r112;
        this.repairTabCreationSwitch = r113;
        this.ecSearchHistoricalWordOneClick = r114;
    }

    public /* synthetic */ SearchTabIndexRollbackSwitchConfig(boolean r110, boolean r111, boolean r112, boolean r113, boolean r210, boolean r211, boolean r212, boolean r213, List r214, boolean r215, List r216, boolean r217, boolean r218, boolean r219, int r310, DefaultConstructorMarker r311) {
        boolean r100 = true;
        if ((r310 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r310 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r310 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r310 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r310 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r310 & 32) == 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r107 = true;
    L31:
        if ((r310 & 128) == 0) goto L33;
        boolean r108 = true;
    L35:
        if ((r310 & 256) == 0) goto L37;
        List r114 = new ArrayList();
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r115 = true;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        List r116 = new ArrayList();
    L47:
        if ((r310 & 2048) == 0) goto L49;
        boolean r117 = true;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        boolean r118 = true;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
