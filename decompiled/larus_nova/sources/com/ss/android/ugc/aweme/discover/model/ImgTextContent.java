package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003Ju\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u000eHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006."}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ImgTextContent;", "Ljava/io/Serializable;", "singleColumnBannerImg", "Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "doubleColumnBannerImg", "background", "Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerBackground;", "icon", "Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;", "iconTail", "mainTitle", "subTitle", "button", "bannerSchema", "", "(Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerBackground;Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;Ljava/lang/String;)V", "getBackground", "()Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerBackground;", "getBannerSchema", "()Ljava/lang/String;", "getButton", "()Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;", "getDoubleColumnBannerImg", "()Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "getIcon", "getIconTail", "getMainTitle", "getSingleColumnBannerImg", "getSubTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImgTextContent implements Serializable {

    @SerializedName("background")
    private final FeedBoxBannerBackground background;

    @SerializedName("banner_schema")
    private final String bannerSchema;

    @SerializedName("button")
    private final BannerTagStruct button;

    @SerializedName("double_column_banner_img")
    private final UrlStruct doubleColumnBannerImg;

    @SerializedName("icon")
    private final BannerTagStruct icon;

    @SerializedName("icon_tail")
    private final BannerTagStruct iconTail;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    private final BannerTagStruct mainTitle;

    @SerializedName("single_column_banner_img")
    private final UrlStruct singleColumnBannerImg;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final BannerTagStruct subTitle;

    public ImgTextContent() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ImgTextContent copy$default(ImgTextContent r110, UrlStruct r111, UrlStruct r112, FeedBoxBannerBackground r113, BannerTagStruct r114, BannerTagStruct r115, BannerTagStruct r116, BannerTagStruct r117, BannerTagStruct r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        UrlStruct r100 = r110.singleColumnBannerImg;
    L7:
        if ((r210 & 2) == 0) goto L9;
        UrlStruct r101 = r110.doubleColumnBannerImg;
    L11:
        if ((r210 & 4) == 0) goto L13;
        FeedBoxBannerBackground r102 = r110.background;
    L15:
        if ((r210 & 8) == 0) goto L17;
        BannerTagStruct r103 = r110.icon;
    L19:
        if ((r210 & 16) == 0) goto L21;
        BannerTagStruct r104 = r110.iconTail;
    L23:
        if ((r210 & 32) == 0) goto L25;
        BannerTagStruct r105 = r110.mainTitle;
    L27:
        if ((r210 & 64) == 0) goto L29;
        BannerTagStruct r106 = r110.subTitle;
    L31:
        if ((r210 & 128) == 0) goto L33;
        BannerTagStruct r107 = r110.button;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.bannerSchema;
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

    public final UrlStruct component1() {
        return this.singleColumnBannerImg;
    }

    public final UrlStruct component2() {
        return this.doubleColumnBannerImg;
    }

    public final FeedBoxBannerBackground component3() {
        return this.background;
    }

    public final BannerTagStruct component4() {
        return this.icon;
    }

    public final BannerTagStruct component5() {
        return this.iconTail;
    }

    public final BannerTagStruct component6() {
        return this.mainTitle;
    }

    public final BannerTagStruct component7() {
        return this.subTitle;
    }

    public final BannerTagStruct component8() {
        return this.button;
    }

    public final String component9() {
        return this.bannerSchema;
    }

    public final ImgTextContent copy(UrlStruct r110, UrlStruct r111, FeedBoxBannerBackground r112, BannerTagStruct r113, BannerTagStruct r114, BannerTagStruct r115, BannerTagStruct r116, BannerTagStruct r117, String r210) {
        return new ImgTextContent(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImgTextContent) == false) goto L24;
        ImgTextContent r101 = (ImgTextContent) r100;
        if (Intrinsics.areEqual(this.singleColumnBannerImg, r101.singleColumnBannerImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.doubleColumnBannerImg, r101.doubleColumnBannerImg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.iconTail, r101.iconTail) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bannerSchema, r101.bannerSchema) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        UrlStruct r100 = this.singleColumnBannerImg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UrlStruct r104 = this.doubleColumnBannerImg;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FeedBoxBannerBackground r107 = this.background;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        BannerTagStruct r110 = this.icon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        BannerTagStruct r113 = this.iconTail;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        BannerTagStruct r116 = this.mainTitle;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        BannerTagStruct r119 = this.subTitle;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        BannerTagStruct r122 = this.button;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.bannerSchema;
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
        return "ImgTextContent(singleColumnBannerImg=" + this.singleColumnBannerImg + ", doubleColumnBannerImg=" + this.doubleColumnBannerImg + ", background=" + this.background + ", icon=" + this.icon + ", iconTail=" + this.iconTail + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", button=" + this.button + ", bannerSchema=" + this.bannerSchema + ")";
    }

    public final FeedBoxBannerBackground getBackground() {
        return this.background;
    }

    public final String getBannerSchema() {
        return this.bannerSchema;
    }

    public final BannerTagStruct getButton() {
        return this.button;
    }

    public final UrlStruct getDoubleColumnBannerImg() {
        return this.doubleColumnBannerImg;
    }

    public final BannerTagStruct getIcon() {
        return this.icon;
    }

    public final BannerTagStruct getIconTail() {
        return this.iconTail;
    }

    public final BannerTagStruct getMainTitle() {
        return this.mainTitle;
    }

    public final UrlStruct getSingleColumnBannerImg() {
        return this.singleColumnBannerImg;
    }

    public final BannerTagStruct getSubTitle() {
        return this.subTitle;
    }

    public ImgTextContent(UrlStruct r100, UrlStruct r101, FeedBoxBannerBackground r102, BannerTagStruct r103, BannerTagStruct r104, BannerTagStruct r105, BannerTagStruct r106, BannerTagStruct r107, String r108) {
        this.singleColumnBannerImg = r100;
        this.doubleColumnBannerImg = r101;
        this.background = r102;
        this.icon = r103;
        this.iconTail = r104;
        this.mainTitle = r105;
        this.subTitle = r106;
        this.button = r107;
        this.bannerSchema = r108;
    }

    public /* synthetic */ ImgTextContent(UrlStruct r110, UrlStruct r111, FeedBoxBannerBackground r112, BannerTagStruct r113, BannerTagStruct r114, BannerTagStruct r115, BannerTagStruct r116, BannerTagStruct r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        UrlStruct r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        UrlStruct r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        FeedBoxBannerBackground r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        BannerTagStruct r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        BannerTagStruct r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        BannerTagStruct r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        BannerTagStruct r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        BannerTagStruct r108 = null;
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
