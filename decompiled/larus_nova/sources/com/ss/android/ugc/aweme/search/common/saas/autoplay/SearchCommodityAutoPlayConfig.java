package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J¢\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0011HÖ\u0001J\t\u0010E\u001a\u00020\u000eHÖ\u0001R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010%R\u001e\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010-R\u001e\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!¨\u0006F"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchCommodityAutoPlayConfig;", "", "focusAreaTop", "", "focusAreaBottom", "rollInAreaPercent", "rollOutAreaPercent", "autoPlaySession", "", "rightFirstVerticalVariant", "videoPlaySession", "livePlaySession", "whiteList", "", "", "singleCoumnCardActiveRatio", "isSearchResultMuted", "", "filterCardType", "activeDisplayRatio", "(FFFFJFJJLjava/util/List;FILjava/util/List;Ljava/lang/Float;)V", "getActiveDisplayRatio", "()Ljava/lang/Float;", "setActiveDisplayRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getAutoPlaySession", "()J", "setAutoPlaySession", "(J)V", "getFilterCardType", "()Ljava/util/List;", "setFilterCardType", "(Ljava/util/List;)V", "getFocusAreaBottom", "()F", "getFocusAreaTop", "()I", "getLivePlaySession", "setLivePlaySession", "getRightFirstVerticalVariant", "getRollInAreaPercent", "getRollOutAreaPercent", "getSingleCoumnCardActiveRatio", "setSingleCoumnCardActiveRatio", "(F)V", "getVideoPlaySession", "setVideoPlaySession", "getWhiteList", "setWhiteList", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(FFFFJFJJLjava/util/List;FILjava/util/List;Ljava/lang/Float;)Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchCommodityAutoPlayConfig;", "equals", "", "other", "hashCode", "toString", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchCommodityAutoPlayConfig {

    @SerializedName("active_display_ratio")
    private Float activeDisplayRatio;

    @SerializedName("auto_play_session")
    private long autoPlaySession;

    @SerializedName("filter_card_type")
    private List<String> filterCardType;

    @SerializedName("focus_area_bottom")
    private final float focusAreaBottom;

    @SerializedName("focus_area_top")
    private final float focusAreaTop;

    @SerializedName("is_search_result_muted")
    private final int isSearchResultMuted;

    @SerializedName("live_play_session")
    private long livePlaySession;

    @SerializedName("right_first_vertical_variant")
    private final float rightFirstVerticalVariant;

    @SerializedName("roll_in_area_percent")
    private final float rollInAreaPercent;

    @SerializedName("roll_out_area_percent")
    private final float rollOutAreaPercent;

    @SerializedName("single_column_card_active_ratio")
    private float singleCoumnCardActiveRatio;

    @SerializedName("video_play_session")
    private long videoPlaySession;

    @SerializedName("has_video_static_card_whitelist")
    private List<String> whiteList;

    public SearchCommodityAutoPlayConfig() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, 0, null, 0.0f, 0, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchCommodityAutoPlayConfig copy$default(SearchCommodityAutoPlayConfig r110, float r111, float r112, float r113, float r210, long r211, float r212, long r213, long r214, List r215, float r216, int r310, List r311, Float r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        float r100 = r110.focusAreaTop;
    L7:
        if ((r313 & 2) == 0) goto L9;
        float r101 = r110.focusAreaBottom;
    L11:
        if ((r313 & 4) == 0) goto L13;
        float r102 = r110.rollInAreaPercent;
    L15:
        if ((r313 & 8) == 0) goto L17;
        float r103 = r110.rollOutAreaPercent;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r104 = r110.autoPlaySession;
    L23:
        if ((r313 & 32) == 0) goto L25;
        float r105 = r110.rightFirstVerticalVariant;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r106 = r110.videoPlaySession;
    L31:
        if ((r313 & 128) == 0) goto L33;
        long r114 = r110.livePlaySession;
    L35:
        if ((r313 & 256) == 0) goto L37;
        List r115 = r110.whiteList;
    L39:
        if ((r313 & 512) == 0) goto L41;
        float r116 = r110.singleCoumnCardActiveRatio;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        int r117 = r110.isSearchResultMuted;
    L46:
        int r315 = r117;
        if ((r313 & 2048) == 0) goto L49;
        List r118 = r110.filterCardType;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        Float r107 = r110.activeDisplayRatio;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r116, r315, r118, r107);
    L53:
        r107 = r312;
        goto L55
    L49:
        r118 = r311;
        goto L51
    L45:
        r117 = r310;
        goto L46
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
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

    public final float component1() {
        return this.focusAreaTop;
    }

    public final float component10() {
        return this.singleCoumnCardActiveRatio;
    }

    public final int component11() {
        return this.isSearchResultMuted;
    }

    public final List<String> component12() {
        return this.filterCardType;
    }

    public final Float component13() {
        return this.activeDisplayRatio;
    }

    public final float component2() {
        return this.focusAreaBottom;
    }

    public final float component3() {
        return this.rollInAreaPercent;
    }

    public final float component4() {
        return this.rollOutAreaPercent;
    }

    public final long component5() {
        return this.autoPlaySession;
    }

    public final float component6() {
        return this.rightFirstVerticalVariant;
    }

    public final long component7() {
        return this.videoPlaySession;
    }

    public final long component8() {
        return this.livePlaySession;
    }

    public final List<String> component9() {
        return this.whiteList;
    }

    public final SearchCommodityAutoPlayConfig copy(float r110, float r210, float r211, float r212, long r213, float r214, long r215, long r216, List<String> r310, float r311, int r312, List<String> r313, Float r314) {
        return new SearchCommodityAutoPlayConfig(r110, r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchCommodityAutoPlayConfig) == true) goto L8;
        return false;
    L8:
        SearchCommodityAutoPlayConfig r101 = (SearchCommodityAutoPlayConfig) r100;
        if (Float.compare(this.focusAreaTop, r101.focusAreaTop) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.focusAreaBottom, r101.focusAreaBottom) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.rollInAreaPercent, r101.rollInAreaPercent) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.rollOutAreaPercent, r101.rollOutAreaPercent) == 0) goto L21;
        return false;
    L21:
        if (this.autoPlaySession == r101.autoPlaySession) goto L24;
        return false;
    L24:
        if (Float.compare(this.rightFirstVerticalVariant, r101.rightFirstVerticalVariant) == 0) goto L27;
        return false;
    L27:
        if (this.videoPlaySession == r101.videoPlaySession) goto L30;
        return false;
    L30:
        if (this.livePlaySession == r101.livePlaySession) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.whiteList, r101.whiteList) == true) goto L36;
        return false;
    L36:
        if (Float.compare(this.singleCoumnCardActiveRatio, r101.singleCoumnCardActiveRatio) == 0) goto L39;
        return false;
    L39:
        if (this.isSearchResultMuted == r101.isSearchResultMuted) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.filterCardType, r101.filterCardType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.activeDisplayRatio, r101.activeDisplayRatio) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((Float.floatToIntBits(this.focusAreaTop) * 31) + Float.floatToIntBits(this.focusAreaBottom)) * 31) + Float.floatToIntBits(this.rollInAreaPercent)) * 31) + Float.floatToIntBits(this.rollOutAreaPercent)) * 31;
        long r101 = this.autoPlaySession;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Float.floatToIntBits(this.rightFirstVerticalVariant)) * 31;
        long r103 = this.videoPlaySession;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.livePlaySession;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        List<String> r107 = this.whiteList;
        int r108 = 0;
        if (r107 != null) goto L5;
        int r109 = 0;
    L6:
        int r110 = (((((r106 + r109) * 31) + Float.floatToIntBits(this.singleCoumnCardActiveRatio)) * 31) + this.isSearchResultMuted) * 31;
        List<String> r111 = this.filterCardType;
        if (r111 != null) goto L9;
        int r112 = 0;
    L10:
        int r113 = (r110 + r112) * 31;
        Float r114 = this.activeDisplayRatio;
        if (r114 == null) goto L15;
        r108 = r114.hashCode();
    L15:
        return r113 + r108;
    L9:
        r112 = r111.hashCode();
        goto L10
    L5:
        r109 = r107.hashCode();
        goto L6
    }

    public String toString() {
        return "SearchCommodityAutoPlayConfig(focusAreaTop=" + this.focusAreaTop + ", focusAreaBottom=" + this.focusAreaBottom + ", rollInAreaPercent=" + this.rollInAreaPercent + ", rollOutAreaPercent=" + this.rollOutAreaPercent + ", autoPlaySession=" + this.autoPlaySession + ", rightFirstVerticalVariant=" + this.rightFirstVerticalVariant + ", videoPlaySession=" + this.videoPlaySession + ", livePlaySession=" + this.livePlaySession + ", whiteList=" + this.whiteList + ", singleCoumnCardActiveRatio=" + this.singleCoumnCardActiveRatio + ", isSearchResultMuted=" + this.isSearchResultMuted + ", filterCardType=" + this.filterCardType + ", activeDisplayRatio=" + this.activeDisplayRatio + ')';
    }

    public final Float getActiveDisplayRatio() {
        return this.activeDisplayRatio;
    }

    public final long getAutoPlaySession() {
        return this.autoPlaySession;
    }

    public final List<String> getFilterCardType() {
        return this.filterCardType;
    }

    public final float getFocusAreaBottom() {
        return this.focusAreaBottom;
    }

    public final float getFocusAreaTop() {
        return this.focusAreaTop;
    }

    public final long getLivePlaySession() {
        return this.livePlaySession;
    }

    public final float getRightFirstVerticalVariant() {
        return this.rightFirstVerticalVariant;
    }

    public final float getRollInAreaPercent() {
        return this.rollInAreaPercent;
    }

    public final float getRollOutAreaPercent() {
        return this.rollOutAreaPercent;
    }

    public final float getSingleCoumnCardActiveRatio() {
        return this.singleCoumnCardActiveRatio;
    }

    public final long getVideoPlaySession() {
        return this.videoPlaySession;
    }

    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    public final int isSearchResultMuted() {
        return this.isSearchResultMuted;
    }

    public final void setActiveDisplayRatio(Float r100) {
        this.activeDisplayRatio = r100;
    }

    public final void setAutoPlaySession(long r100) {
        this.autoPlaySession = r100;
    }

    public final void setFilterCardType(List<String> r100) {
        this.filterCardType = r100;
    }

    public final void setLivePlaySession(long r100) {
        this.livePlaySession = r100;
    }

    public final void setSingleCoumnCardActiveRatio(float r100) {
        this.singleCoumnCardActiveRatio = r100;
    }

    public final void setVideoPlaySession(long r100) {
        this.videoPlaySession = r100;
    }

    public final void setWhiteList(List<String> r100) {
        this.whiteList = r100;
    }

    public SearchCommodityAutoPlayConfig(float r100, float r101, float r102, float r103, long r104, float r110, long r111, long r112, List<String> r113, float r114, int r115, List<String> r116, Float r117) {
        this.focusAreaTop = r100;
        this.focusAreaBottom = r101;
        this.rollInAreaPercent = r102;
        this.rollOutAreaPercent = r103;
        this.autoPlaySession = r104;
        this.rightFirstVerticalVariant = r110;
        this.videoPlaySession = r111;
        this.livePlaySession = r112;
        this.whiteList = r113;
        this.singleCoumnCardActiveRatio = r114;
        this.isSearchResultMuted = r115;
        this.filterCardType = r116;
        this.activeDisplayRatio = r117;
    }

    public /* synthetic */ SearchCommodityAutoPlayConfig(float r110, float r111, float r112, float r210, long r211, float r212, long r213, long r214, List r215, float r216, int r310, List r311, Float r312, int r313, DefaultConstructorMarker r314) {
        float r100 = 0.0f;
        if ((r313 & 1) == 0) goto L5;
        float r101 = 0.0f;
    L7:
        if ((r313 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        float r102 = 0.7f;
        if ((r313 & 4) == 0) goto L13;
        float r103 = 0.7f;
    L15:
        if ((r313 & 8) != 0) goto L19;
        r102 = r210;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r104 = 5000;
    L23:
        if ((r313 & 32) == 0) goto L25;
        float r105 = 10.0f;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r106 = r104;
    L31:
        if ((r313 & 128) == 0) goto L33;
        long r113 = r104;
    L35:
        if ((r313 & 256) == 0) goto L37;
        List r114 = CollectionsKt.listOf("toutiao_article");
    L39:
        if ((r313 & 512) == 0) goto L41;
        float r115 = 0.5f;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        int r116 = 1;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        List r117 = CollectionsKt.emptyList();
    L51:
        if ((r313 & 4096) == 0) goto L53;
        Float r107 = null;
    L54:
        this(r101, r100, r103, r102, r104, r105, r106, r113, r114, r115, r116, r117, r107);
        return;
    L53:
        r107 = r312;
        goto L54
    L49:
        r117 = r311;
        goto L51
    L45:
        r116 = r310;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
