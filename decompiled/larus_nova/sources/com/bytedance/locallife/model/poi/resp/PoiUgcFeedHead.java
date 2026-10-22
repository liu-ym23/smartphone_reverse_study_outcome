package com.bytedance.locallife.model.poi.resp;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001HBÃ\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bE\u0010FJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\t\u0010\r\u001a\u00020\u0002HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÅ\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00022\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010#\u001a\u00020\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0002HÖ\u0001J\u0013\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b1\u00100R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b2\u00100R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u00105R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u00108R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b9\u00108R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b:\u00100R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b;\u00108R\u001c\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b<\u00105R\u001c\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b=\u00105R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b>\u00105R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010.\u001a\u0004\b?\u00100R\u001c\u0010$\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010%\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u00103\u001a\u0004\bC\u00105R\u001c\u0010&\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u00103\u001a\u0004\bD\u00105¨\u0006I"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedHead;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcTag;", "component5", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcImpression;", "component6", "component7", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "component8", "component9", "component10", "component11", "component12", "Lcom/bytedance/locallife/model/poi/resp/ScoreModule;", "component13", "component14", "component15", "recommendLevel", "visitedCount", "effectiveTagRatesCount", "recommendedScore", PromotionProductPrivilegesStruct.TAGS, "impressions", "showImpressions", "userAvatars", "rulesUrl", "loadMoreTextTopRight", "loadMoreTextBottom", "validCount", "scoreModule", "headerModuleTitle", "mobParams", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getRecommendLevel", "()I", "getVisitedCount", "getEffectiveTagRatesCount", "Ljava/lang/String;", "getRecommendedScore", "()Ljava/lang/String;", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "getImpressions", "getShowImpressions", "getUserAvatars", "getRulesUrl", "getLoadMoreTextTopRight", "getLoadMoreTextBottom", "getValidCount", "Lcom/bytedance/locallife/model/poi/resp/ScoreModule;", "getScoreModule", "()Lcom/bytedance/locallife/model/poi/resp/ScoreModule;", "getHeaderModuleTitle", "getMobParams", "<init>", "(IIILjava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/locallife/model/poi/resp/ScoreModule;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiUgcFeedHead implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("effective_tag_rates_count")
    private final int effectiveTagRatesCount;

    @SerializedName("header_module_title")
    private final String headerModuleTitle;

    @SerializedName("impressions")
    private final List<PoiUgcImpression> impressions;

    @SerializedName("load_more_text_bottom")
    private final String loadMoreTextBottom;

    @SerializedName("load_more_text_top_right")
    private final String loadMoreTextTopRight;

    @SerializedName("mob_params")
    private final String mobParams;

    @SerializedName("recommended_level")
    private final int recommendLevel;

    @SerializedName("recommended_score")
    private final String recommendedScore;

    @SerializedName("recommended_score_rules_page_redirect_url")
    private final String rulesUrl;

    @SerializedName("score_module")
    private final ScoreModule scoreModule;

    @SerializedName("show_impressions")
    private final int showImpressions;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<PoiUgcTag> tags;

    @SerializedName("user_avatars")
    private final List<PoiImageUrlModel> userAvatars;

    @SerializedName("valid_count")
    private final int validCount;

    @SerializedName("visited_count")
    private final int visitedCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PoiUgcFeedHead() {
        this(0, 0, 0, null, null, null, 0, null, null, null, null, 0, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiUgcFeedHead copy$default(PoiUgcFeedHead r110, int r111, int r112, int r113, String r210, List r211, List r212, int r213, List r214, String r215, String r216, String r217, int r218, ScoreModule r219, String r310, String r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        int r100 = r110.recommendLevel;
    L7:
        if ((r312 & 2) == 0) goto L9;
        int r101 = r110.visitedCount;
    L11:
        if ((r312 & 4) == 0) goto L13;
        int r102 = r110.effectiveTagRatesCount;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.recommendedScore;
    L19:
        if ((r312 & 16) == 0) goto L21;
        List r104 = r110.tags;
    L23:
        if ((r312 & 32) == 0) goto L25;
        List r105 = r110.impressions;
    L27:
        if ((r312 & 64) == 0) goto L29;
        int r106 = r110.showImpressions;
    L31:
        if ((r312 & 128) == 0) goto L33;
        List r107 = r110.userAvatars;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r114 = r110.rulesUrl;
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r115 = r110.loadMoreTextTopRight;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r116 = r110.loadMoreTextBottom;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        int r117 = r110.validCount;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        ScoreModule r118 = r110.scoreModule;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r119 = r110.headerModuleTitle;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        String r108 = r110.mobParams;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
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

    public final int component1() {
        return this.recommendLevel;
    }

    public final String component10() {
        return this.loadMoreTextTopRight;
    }

    public final String component11() {
        return this.loadMoreTextBottom;
    }

    public final int component12() {
        return this.validCount;
    }

    public final ScoreModule component13() {
        return this.scoreModule;
    }

    public final String component14() {
        return this.headerModuleTitle;
    }

    public final String component15() {
        return this.mobParams;
    }

    public final int component2() {
        return this.visitedCount;
    }

    public final int component3() {
        return this.effectiveTagRatesCount;
    }

    public final String component4() {
        return this.recommendedScore;
    }

    public final List<PoiUgcTag> component5() {
        return this.tags;
    }

    public final List<PoiUgcImpression> component6() {
        return this.impressions;
    }

    public final int component7() {
        return this.showImpressions;
    }

    public final List<PoiImageUrlModel> component8() {
        return this.userAvatars;
    }

    public final String component9() {
        return this.rulesUrl;
    }

    public final PoiUgcFeedHead copy(int r110, int r111, int r210, String r211, List<PoiUgcTag> r212, List<PoiUgcImpression> r213, int r214, List<PoiImageUrlModel> r215, String r216, String r217, String r218, int r219, ScoreModule r310, String r311, String r312) {
        return new PoiUgcFeedHead(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcFeedHead) == true) goto L8;
        return false;
    L8:
        PoiUgcFeedHead r101 = (PoiUgcFeedHead) r100;
        if (this.recommendLevel == r101.recommendLevel) goto L12;
        return false;
    L12:
        if (this.visitedCount == r101.visitedCount) goto L15;
        return false;
    L15:
        if (this.effectiveTagRatesCount == r101.effectiveTagRatesCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendedScore, r101.recommendedScore) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.impressions, r101.impressions) == true) goto L27;
        return false;
    L27:
        if (this.showImpressions == r101.showImpressions) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userAvatars, r101.userAvatars) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.rulesUrl, r101.rulesUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.loadMoreTextTopRight, r101.loadMoreTextTopRight) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.loadMoreTextBottom, r101.loadMoreTextBottom) == true) goto L42;
        return false;
    L42:
        if (this.validCount == r101.validCount) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.scoreModule, r101.scoreModule) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.headerModuleTitle, r101.headerModuleTitle) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.mobParams, r101.mobParams) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.recommendLevel * 31) + this.visitedCount) * 31) + this.effectiveTagRatesCount) * 31;
        String r101 = this.recommendedScore;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<PoiUgcTag> r105 = this.tags;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<PoiUgcImpression> r108 = this.impressions;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.showImpressions) * 31;
        List<PoiImageUrlModel> r111 = this.userAvatars;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.rulesUrl;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.loadMoreTextTopRight;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.loadMoreTextBottom;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((r119 + r121) * 31) + this.validCount) * 31;
        ScoreModule r123 = this.scoreModule;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.headerModuleTitle;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.mobParams;
        if (r129 == null) goto L43;
        r102 = r129.hashCode();
    L43:
        return r128 + r102;
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiUgcFeedHead(recommendLevel=" + this.recommendLevel + ", visitedCount=" + this.visitedCount + ", effectiveTagRatesCount=" + this.effectiveTagRatesCount + ", recommendedScore=" + this.recommendedScore + ", tags=" + this.tags + ", impressions=" + this.impressions + ", showImpressions=" + this.showImpressions + ", userAvatars=" + this.userAvatars + ", rulesUrl=" + this.rulesUrl + ", loadMoreTextTopRight=" + this.loadMoreTextTopRight + ", loadMoreTextBottom=" + this.loadMoreTextBottom + ", validCount=" + this.validCount + ", scoreModule=" + this.scoreModule + ", headerModuleTitle=" + this.headerModuleTitle + ", mobParams=" + this.mobParams + ')';
    }

    public final int getEffectiveTagRatesCount() {
        return this.effectiveTagRatesCount;
    }

    public final String getHeaderModuleTitle() {
        return this.headerModuleTitle;
    }

    public final List<PoiUgcImpression> getImpressions() {
        return this.impressions;
    }

    public final String getLoadMoreTextBottom() {
        return this.loadMoreTextBottom;
    }

    public final String getLoadMoreTextTopRight() {
        return this.loadMoreTextTopRight;
    }

    public final String getMobParams() {
        return this.mobParams;
    }

    public final int getRecommendLevel() {
        return this.recommendLevel;
    }

    public final String getRecommendedScore() {
        return this.recommendedScore;
    }

    public final String getRulesUrl() {
        return this.rulesUrl;
    }

    public final ScoreModule getScoreModule() {
        return this.scoreModule;
    }

    public final int getShowImpressions() {
        return this.showImpressions;
    }

    public final List<PoiUgcTag> getTags() {
        return this.tags;
    }

    public final List<PoiImageUrlModel> getUserAvatars() {
        return this.userAvatars;
    }

    public final int getValidCount() {
        return this.validCount;
    }

    public final int getVisitedCount() {
        return this.visitedCount;
    }

    public PoiUgcFeedHead(int r100, int r101, int r102, String r103, List<PoiUgcTag> r104, List<PoiUgcImpression> r105, int r106, List<PoiImageUrlModel> r107, String r108, String r110, String r111, int r112, ScoreModule r113, String r114, String r115) {
        this.recommendLevel = r100;
        this.visitedCount = r101;
        this.effectiveTagRatesCount = r102;
        this.recommendedScore = r103;
        this.tags = r104;
        this.impressions = r105;
        this.showImpressions = r106;
        this.userAvatars = r107;
        this.rulesUrl = r108;
        this.loadMoreTextTopRight = r110;
        this.loadMoreTextBottom = r111;
        this.validCount = r112;
        this.scoreModule = r113;
        this.headerModuleTitle = r114;
        this.mobParams = r115;
    }

    public /* synthetic */ PoiUgcFeedHead(int r110, int r111, int r112, String r210, List r211, List r212, int r213, List r214, String r215, String r216, String r217, int r218, ScoreModule r219, String r310, String r311, int r312, DefaultConstructorMarker r313) {
        if ((r312 & 1) == 0) goto L5;
        int r100 = 1;
    L6:
        int r101 = 0;
        if ((r312 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r312 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r312 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r312 & 128) == 0) goto L33;
        List r113 = null;
    L34:
        String r114 = "";
        if ((r312 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r116 = "";
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r117 = "";
    L47:
        if ((r312 & 2048) != 0) goto L51;
        r101 = r218;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        ScoreModule r118 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        String r108 = null;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r114 = r311;
    L62:
        this(r100, r102, r103, r104, r105, r106, r107, r113, r115, r116, r117, r101, r118, r108, r114);
        return;
    L57:
        r108 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L34
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
