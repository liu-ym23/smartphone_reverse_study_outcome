package com.bytedance.locallife.poi.newdetail.component;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001c\u0010'\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$R\u001c\u0010-\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0013\u001a\u0004\b.\u0010\u0015R\u001c\u0010/\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b0\u0010$R\u001c\u00101\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b2\u0010\u0015R\u001c\u00103\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$R\"\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\u001e\u001a\u0004\b<\u0010 R\u001a\u0010=\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\t\u001a\u0004\b>\u0010\u000bR\"\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u00108\u001a\u0004\bA\u0010:R\u001c\u0010C\u001a\u0004\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/t;", "", "", "type", "I", "getType", "()I", "", "showHeadImage", "Z", OfficeSDKRequestTag.KEY_NEW_USER, "()Z", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "headImageStartOffset", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "d", "()Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "", "lynxUrl", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "Lcom/google/gson/JsonObject;", "lynxData", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", "bottomBarParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "showTripNativeHeadImage", "Ljava/lang/Integer;", "p", "()Ljava/lang/Integer;", "headImageTagOpt", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "showAlbumText", "m", "showShareIcon", "o", "showMoreIconOnly", "getShowMoreIconOnly", "showMultiPager", "getShowMultiPager", "anchorPagerType", "getAnchorPagerType", "shouldForceShow", "l", "poiPageLayoutStyle", ce.f26395j, "poiEnableCorner", RXScreenCaptureService.KEY_INDEX, "", "Lcom/ss/android/ugc/aweme/poi/model/AlbumTabListModel;", "photoTabList", "Ljava/util/List;", "h", "()Ljava/util/List;", "poiUiEnhanceContentStyle", ce.f26396k, "useContentContainer", "q", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/i;", "contentTabList", "b", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "crushPoiRank", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "c", "()Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("anchor_pager_type")
    private final String anchorPagerType;

    @SerializedName("album_bottom_bar_params")
    private final JsonObject bottomBarParams;

    @SerializedName("tab_list")
    private final List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> contentTabList;

    @SerializedName("crush_poi_rank")
    private final com.bytedance.locallife.poi.newdetail.widget.contentplayer.b crushPoiRank;

    @SerializedName("head_image_start_offset")
    private final PoiDistanceModel headImageStartOffset;

    @SerializedName("head_image_tag_opt")
    private final Boolean headImageTagOpt;

    @SerializedName("lynx_data")
    private final JsonObject lynxData;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("photo_page_tab_list")
    private final List<AlbumTabListModel> photoTabList;

    @SerializedName("poi_enable_corner")
    private final Boolean poiEnableCorner;

    @SerializedName("poi_page_layout_style")
    private final String poiPageLayoutStyle;

    @SerializedName("poi_ui_enhance_content_style")
    private final Integer poiUiEnhanceContentStyle;

    @SerializedName("should_force_show")
    private final Boolean shouldForceShow;

    @SerializedName("show_album_text")
    private final Boolean showAlbumText;

    @SerializedName("show_head_image")
    private final boolean showHeadImage;

    @SerializedName("show_more_icon_only")
    private final Boolean showMoreIconOnly;

    @SerializedName("show_multi_pager")
    private final Boolean showMultiPager;

    @SerializedName("show_share_icon")
    private final Boolean showShareIcon;

    @SerializedName("show_trip_native_head_image")
    private final Integer showTripNativeHeadImage;

    @SerializedName("type")
    private final int type;

    @SerializedName("use_content_container")
    private final boolean useContentContainer;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.showHeadImage == r101.showHeadImage) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headImageStartOffset, r101.headImageStartOffset) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bottomBarParams, r101.bottomBarParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.showTripNativeHeadImage, r101.showTripNativeHeadImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.headImageTagOpt, r101.headImageTagOpt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showAlbumText, r101.showAlbumText) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.showShareIcon, r101.showShareIcon) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.showMoreIconOnly, r101.showMoreIconOnly) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.showMultiPager, r101.showMultiPager) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.anchorPagerType, r101.anchorPagerType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.shouldForceShow, r101.shouldForceShow) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.poiPageLayoutStyle, r101.poiPageLayoutStyle) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.poiEnableCorner, r101.poiEnableCorner) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.photoTabList, r101.photoTabList) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.poiUiEnhanceContentStyle, r101.poiUiEnhanceContentStyle) == true) goto L63;
        return false;
    L63:
        if (this.useContentContainer == r101.useContentContainer) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.contentTabList, r101.contentTabList) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.crushPoiRank, r101.crushPoiRank) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        int r101 = 1231;
        if (this.showHeadImage == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        PoiDistanceModel r104 = this.headImageStartOffset;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.lynxUrl;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        JsonObject r111 = this.lynxData;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        JsonObject r114 = this.bottomBarParams;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.showTripNativeHeadImage;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.headImageTagOpt;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Boolean r123 = this.showAlbumText;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Boolean r126 = this.showShareIcon;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Boolean r129 = this.showMoreIconOnly;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Boolean r132 = this.showMultiPager;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.anchorPagerType;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        Boolean r138 = this.shouldForceShow;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        String r141 = this.poiPageLayoutStyle;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        Boolean r144 = this.poiEnableCorner;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        List<AlbumTabListModel> r147 = this.photoTabList;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        Integer r150 = this.poiUiEnhanceContentStyle;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (r149 + r151) * 31;
        if (this.useContentContainer == true) goto L74;
        r101 = 1237;
    L74:
        int r153 = (r152 + r101) * 31;
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r154 = this.contentTabList;
        if (r154 != null) goto L77;
        int r155 = 0;
    L78:
        int r156 = (r153 + r155) * 31;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r157 = this.crushPoiRank;
        if (r157 == null) goto L83;
        r105 = r157.hashCode();
    L83:
        return r156 + r105;
    L77:
        r155 = r154.hashCode();
        goto L78
    L69:
        r151 = r150.hashCode();
        goto L70
    L65:
        r148 = r147.hashCode();
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
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
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PoiQuickPageHeadImageData(type=" + this.type + ", showHeadImage=" + this.showHeadImage + ", headImageStartOffset=" + this.headImageStartOffset + ", lynxUrl=" + this.lynxUrl + ", lynxData=" + this.lynxData + ", bottomBarParams=" + this.bottomBarParams + ", showTripNativeHeadImage=" + this.showTripNativeHeadImage + ", headImageTagOpt=" + this.headImageTagOpt + ", showAlbumText=" + this.showAlbumText + ", showShareIcon=" + this.showShareIcon + ", showMoreIconOnly=" + this.showMoreIconOnly + ", showMultiPager=" + this.showMultiPager + ", anchorPagerType=" + this.anchorPagerType + ", shouldForceShow=" + this.shouldForceShow + ", poiPageLayoutStyle=" + this.poiPageLayoutStyle + ", poiEnableCorner=" + this.poiEnableCorner + ", photoTabList=" + this.photoTabList + ", poiUiEnhanceContentStyle=" + this.poiUiEnhanceContentStyle + ", useContentContainer=" + this.useContentContainer + ", contentTabList=" + this.contentTabList + ", crushPoiRank=" + this.crushPoiRank + ')';
    }

    public t() {
        Boolean r100 = Boolean.FALSE;
        Boolean r101 = Boolean.TRUE;
        this.type = 0;
        this.showHeadImage = true;
        this.headImageStartOffset = null;
        this.lynxUrl = null;
        this.lynxData = null;
        this.bottomBarParams = null;
        this.showTripNativeHeadImage = null;
        this.headImageTagOpt = r100;
        this.showAlbumText = r100;
        this.showShareIcon = r100;
        this.showMoreIconOnly = r100;
        this.showMultiPager = r100;
        this.anchorPagerType = "photo";
        this.shouldForceShow = r100;
        this.poiPageLayoutStyle = "0";
        this.poiEnableCorner = r101;
        this.photoTabList = null;
        this.poiUiEnhanceContentStyle = 0;
        this.useContentContainer = false;
        this.contentTabList = null;
        this.crushPoiRank = null;
    }

    public final JsonObject a() {
        return this.bottomBarParams;
    }

    public final List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> b() {
        return this.contentTabList;
    }

    public final com.bytedance.locallife.poi.newdetail.widget.contentplayer.b c() {
        return this.crushPoiRank;
    }

    public final PoiDistanceModel d() {
        return this.headImageStartOffset;
    }

    public final Boolean e() {
        return this.headImageTagOpt;
    }

    public final JsonObject f() {
        return this.lynxData;
    }

    public final String g() {
        return this.lynxUrl;
    }

    public final int getType() {
        return this.type;
    }

    public final List<AlbumTabListModel> h() {
        return this.photoTabList;
    }

    public final Boolean i() {
        return this.poiEnableCorner;
    }

    public final String j() {
        return this.poiPageLayoutStyle;
    }

    public final Integer k() {
        return this.poiUiEnhanceContentStyle;
    }

    public final Boolean l() {
        return this.shouldForceShow;
    }

    public final Boolean m() {
        return this.showAlbumText;
    }

    public final boolean n() {
        return this.showHeadImage;
    }

    public final Boolean o() {
        return this.showShareIcon;
    }

    public final Integer p() {
        return this.showTripNativeHeadImage;
    }

    public final boolean q() {
        return this.useContentContainer;
    }
}
