package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0015Jz\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u000bHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006/"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/AIGuideInfo;", "Ljava/io/Serializable;", "summaryText", "", "summaryColor", "guideText", "guideTextColor", "Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "leftIconUrl", "rightIconUrl", "imageType", "", "rewriteQuery", "hasPointer", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getGuideText", "()Ljava/lang/String;", "getGuideTextColor", "()Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "getHasPointer", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLeftIconUrl", "getRewriteQuery", "getRightIconUrl", "getSummaryColor", "getSummaryText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ss/android/ugc/aweme/discover/model/AIGuideInfo;", "equals", "other", "", "hashCode", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AIGuideInfo implements Serializable {

    @SerializedName("guide_text")
    private final String guideText;

    @SerializedName("guide_text_color")
    private final ECGradientStruct guideTextColor;

    @SerializedName("has_ai_guide_pointer")
    private final Boolean hasPointer;

    @SerializedName("image_type")
    private final Integer imageType;

    @SerializedName("left_icon_url")
    private final String leftIconUrl;

    @SerializedName("ai_rewrite_query")
    private final String rewriteQuery;

    @SerializedName("right_icon_url")
    private final String rightIconUrl;

    @SerializedName("summary_color")
    private final String summaryColor;

    @SerializedName("summary_text")
    private final String summaryText;

    public AIGuideInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ AIGuideInfo copy$default(AIGuideInfo r110, String r111, String r112, String r113, ECGradientStruct r114, String r115, String r116, Integer r117, String r118, Boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.summaryText;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.summaryColor;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.guideText;
    L15:
        if ((r210 & 8) == 0) goto L17;
        ECGradientStruct r103 = r110.guideTextColor;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.leftIconUrl;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.rightIconUrl;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Integer r106 = r110.imageType;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.rewriteQuery;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Boolean r108 = r110.hasPointer;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
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

    public final String component1() {
        return this.summaryText;
    }

    public final String component2() {
        return this.summaryColor;
    }

    public final String component3() {
        return this.guideText;
    }

    public final ECGradientStruct component4() {
        return this.guideTextColor;
    }

    public final String component5() {
        return this.leftIconUrl;
    }

    public final String component6() {
        return this.rightIconUrl;
    }

    public final Integer component7() {
        return this.imageType;
    }

    public final String component8() {
        return this.rewriteQuery;
    }

    public final Boolean component9() {
        return this.hasPointer;
    }

    public final AIGuideInfo copy(String r110, String r111, String r112, ECGradientStruct r113, String r114, String r115, Integer r116, String r117, Boolean r210) {
        return new AIGuideInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIGuideInfo) == false) goto L24;
        AIGuideInfo r101 = (AIGuideInfo) r100;
        if (Intrinsics.areEqual(this.summaryText, r101.summaryText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.summaryColor, r101.summaryColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.guideText, r101.guideText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideTextColor, r101.guideTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.leftIconUrl, r101.leftIconUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rightIconUrl, r101.rightIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageType, r101.imageType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rewriteQuery, r101.rewriteQuery) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.hasPointer, r101.hasPointer) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.summaryText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.summaryColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.guideText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECGradientStruct r110 = this.guideTextColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.leftIconUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.rightIconUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.imageType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.rewriteQuery;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.hasPointer;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AIGuideInfo(summaryText=" + this.summaryText + ", summaryColor=" + this.summaryColor + ", guideText=" + this.guideText + ", guideTextColor=" + this.guideTextColor + ", leftIconUrl=" + this.leftIconUrl + ", rightIconUrl=" + this.rightIconUrl + ", imageType=" + this.imageType + ", rewriteQuery=" + this.rewriteQuery + ", hasPointer=" + this.hasPointer + ")";
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final ECGradientStruct getGuideTextColor() {
        return this.guideTextColor;
    }

    public final Boolean getHasPointer() {
        return this.hasPointer;
    }

    public final Integer getImageType() {
        return this.imageType;
    }

    public final String getLeftIconUrl() {
        return this.leftIconUrl;
    }

    public final String getRewriteQuery() {
        return this.rewriteQuery;
    }

    public final String getRightIconUrl() {
        return this.rightIconUrl;
    }

    public final String getSummaryColor() {
        return this.summaryColor;
    }

    public final String getSummaryText() {
        return this.summaryText;
    }

    public AIGuideInfo(String r100, String r101, String r102, ECGradientStruct r103, String r104, String r105, Integer r106, String r107, Boolean r108) {
        this.summaryText = r100;
        this.summaryColor = r101;
        this.guideText = r102;
        this.guideTextColor = r103;
        this.leftIconUrl = r104;
        this.rightIconUrl = r105;
        this.imageType = r106;
        this.rewriteQuery = r107;
        this.hasPointer = r108;
    }

    public /* synthetic */ AIGuideInfo(String r110, String r111, String r112, ECGradientStruct r113, String r114, String r115, Integer r116, String r117, Boolean r118, int r210, DefaultConstructorMarker r211) {
        Boolean r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        ECGradientStruct r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
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
}
