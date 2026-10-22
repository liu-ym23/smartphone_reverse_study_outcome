package com.bytedance.locallife.poi.dito.poi.component;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u001c\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R\"\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000bR\"\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u00103R\u001c\u0010<\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/n;", "", "", "type", "I", "getType", "()I", "", "shouldAddGradient", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", "showHeadImage", "l", "", "lynxUrl", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lcom/google/gson/JsonObject;", "lynxData", "Lcom/google/gson/JsonObject;", "e", "()Lcom/google/gson/JsonObject;", "bottomBarParams", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tripHeadImageExpandOpt", "Ljava/lang/Integer;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/Integer;", "headImageTagOpt", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "showAlbumText", ce.f26396k, "showShareIcon", "m", "showMoreIconOnly", "getShowMoreIconOnly", "showMultiPager", "getShowMultiPager", "anchorPagerType", "getAnchorPagerType", "shouldForceShow", ce.f26395j, "", "Lcom/ss/android/ugc/aweme/poi/model/AlbumTabListModel;", "photoTabList", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "poiUiEnhanceContentStyle", "h", "useContentContainer", "o", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/i;", "contentTabList", "b", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "crushPoiRank", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "c", "()Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/b;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("anchor_pager_type")
    private final String anchorPagerType;

    @SerializedName("album_bottom_bar_params")
    private final JsonObject bottomBarParams;

    @SerializedName("tab_list")
    private final List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> contentTabList;

    @SerializedName("crush_poi_rank")
    private final com.bytedance.locallife.poi.newdetail.widget.contentplayer.b crushPoiRank;

    @SerializedName("head_image_tag_opt")
    private final Boolean headImageTagOpt;

    @SerializedName("lynx_data")
    private final JsonObject lynxData;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("photo_page_tab_list")
    private final List<AlbumTabListModel> photoTabList;

    @SerializedName("poi_ui_enhance_content_style")
    private final Integer poiUiEnhanceContentStyle;

    @SerializedName("should_add_gradient")
    private final boolean shouldAddGradient;

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

    @SerializedName("trip_head_image_expand_opt")
    private final Integer tripHeadImageExpandOpt;

    @SerializedName("type")
    private final int type;

    @SerializedName("use_content_container")
    private final boolean useContentContainer;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.shouldAddGradient == r101.shouldAddGradient) goto L15;
        return false;
    L15:
        if (this.showHeadImage == r101.showHeadImage) goto L18;
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
        if (Intrinsics.areEqual(this.tripHeadImageExpandOpt, r101.tripHeadImageExpandOpt) == true) goto L30;
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
        if (Intrinsics.areEqual(this.photoTabList, r101.photoTabList) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.poiUiEnhanceContentStyle, r101.poiUiEnhanceContentStyle) == true) goto L57;
        return false;
    L57:
        if (this.useContentContainer == r101.useContentContainer) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.contentTabList, r101.contentTabList) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.crushPoiRank, r101.crushPoiRank) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        int r101 = 1231;
        if (this.shouldAddGradient == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.showHeadImage == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.lynxUrl;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        JsonObject r110 = this.lynxData;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        JsonObject r113 = this.bottomBarParams;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.tripHeadImageExpandOpt;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.headImageTagOpt;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.showAlbumText;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.showShareIcon;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.showMoreIconOnly;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.showMultiPager;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.anchorPagerType;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.shouldForceShow;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<AlbumTabListModel> r140 = this.photoTabList;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.poiUiEnhanceContentStyle;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        if (this.useContentContainer == true) goto L66;
        r101 = 1237;
    L66:
        int r146 = (r145 + r101) * 31;
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r147 = this.contentTabList;
        if (r147 != null) goto L69;
        int r148 = 0;
    L70:
        int r149 = (r146 + r148) * 31;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r150 = this.crushPoiRank;
        if (r150 == null) goto L75;
        r107 = r150.hashCode();
    L75:
        return r149 + r107;
    L69:
        r148 = r147.hashCode();
        goto L70
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PoiHeadImageData(type=" + this.type + ", shouldAddGradient=" + this.shouldAddGradient + ", showHeadImage=" + this.showHeadImage + ", lynxUrl=" + this.lynxUrl + ", lynxData=" + this.lynxData + ", bottomBarParams=" + this.bottomBarParams + ", tripHeadImageExpandOpt=" + this.tripHeadImageExpandOpt + ", headImageTagOpt=" + this.headImageTagOpt + ", showAlbumText=" + this.showAlbumText + ", showShareIcon=" + this.showShareIcon + ", showMoreIconOnly=" + this.showMoreIconOnly + ", showMultiPager=" + this.showMultiPager + ", anchorPagerType=" + this.anchorPagerType + ", shouldForceShow=" + this.shouldForceShow + ", photoTabList=" + this.photoTabList + ", poiUiEnhanceContentStyle=" + this.poiUiEnhanceContentStyle + ", useContentContainer=" + this.useContentContainer + ", contentTabList=" + this.contentTabList + ", crushPoiRank=" + this.crushPoiRank + ')';
    }

    public n() {
        Boolean r100 = Boolean.FALSE;
        this.type = 0;
        this.shouldAddGradient = false;
        this.showHeadImage = true;
        this.lynxUrl = null;
        this.lynxData = null;
        this.bottomBarParams = null;
        this.tripHeadImageExpandOpt = null;
        this.headImageTagOpt = r100;
        this.showAlbumText = r100;
        this.showShareIcon = r100;
        this.showMoreIconOnly = r100;
        this.showMultiPager = r100;
        this.anchorPagerType = "photo";
        this.shouldForceShow = r100;
        this.photoTabList = null;
        this.poiUiEnhanceContentStyle = 1;
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

    public final Boolean d() {
        return this.headImageTagOpt;
    }

    public final JsonObject e() {
        return this.lynxData;
    }

    public final String f() {
        return this.lynxUrl;
    }

    public final List<AlbumTabListModel> g() {
        return this.photoTabList;
    }

    public final int getType() {
        return this.type;
    }

    public final Integer h() {
        return this.poiUiEnhanceContentStyle;
    }

    public final boolean i() {
        return this.shouldAddGradient;
    }

    public final Boolean j() {
        return this.shouldForceShow;
    }

    public final Boolean k() {
        return this.showAlbumText;
    }

    public final boolean l() {
        return this.showHeadImage;
    }

    public final Boolean m() {
        return this.showShareIcon;
    }

    public final Integer n() {
        return this.tripHeadImageExpandOpt;
    }

    public final boolean o() {
        return this.useContentContainer;
    }
}
