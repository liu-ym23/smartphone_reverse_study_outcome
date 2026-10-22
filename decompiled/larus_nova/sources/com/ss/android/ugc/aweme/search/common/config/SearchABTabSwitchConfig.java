package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchABTabSwitchConfig;", "", "enable", "", "ecSearchHasTabOpen", "", "", "(ZLjava/util/List;)V", "getEcSearchHasTabOpen", "()Ljava/util/List;", "getEnable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchABTabSwitchConfig {

    @SerializedName("search_ab_tab_white")
    private final List<String> ecSearchHasTabOpen;

    @SerializedName("search_ab_tab_enable")
    private final boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchABTabSwitchConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchABTabSwitchConfig copy$default(SearchABTabSwitchConfig r100, boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.ecSearchHasTabOpen;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.ecSearchHasTabOpen;
    }

    public final SearchABTabSwitchConfig copy(boolean r100, List<String> r101) {
        return new SearchABTabSwitchConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchABTabSwitchConfig) == false) goto L10;
        SearchABTabSwitchConfig r101 = (SearchABTabSwitchConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ecSearchHasTabOpen, r101.ecSearchHasTabOpen) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.ecSearchHasTabOpen;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "SearchABTabSwitchConfig(enable=" + this.enable + ", ecSearchHasTabOpen=" + this.ecSearchHasTabOpen + ")";
    }

    public final List<String> getEcSearchHasTabOpen() {
        return this.ecSearchHasTabOpen;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public SearchABTabSwitchConfig(boolean r100, List<String> r101) {
        this.enable = r100;
        this.ecSearchHasTabOpen = r101;
    }

    public /* synthetic */ SearchABTabSwitchConfig(boolean r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.mutableListOf(new String[]{"xtab_homepage__homepage_top_tab.video_search_product_card__mallpage_search"});
    L8:
        this(r100, r101);
    }
}
