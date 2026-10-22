package com.bytedance.locallife.host.share;

import com.amap.api.col.s.ce;
import com.bytedance.ee.bear.document.share.ShareItem;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00103\u001a\u0002028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u0002028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u00106¨\u0006@"}, d2 = {"Lcom/bytedance/locallife/host/share/a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "url", "p", "innerUrl", ce.f26391f, "commandShareParams", "e", "Lcom/bytedance/locallife/host/share/ImExtraParams;", "imExtraParams", "Lcom/bytedance/locallife/host/share/ImExtraParams;", "f", "()Lcom/bytedance/locallife/host/share/ImExtraParams;", "setImExtraParams", "(Lcom/bytedance/locallife/host/share/ImExtraParams;)V", "shareTitle", OfficeSDKRequestTag.KEY_NEW_USER, ShareItem.SHARE_IMAGE, "m", "", "isCollected", "Ljava/lang/Boolean;", "q", "()Ljava/lang/Boolean;", "collectPopLinkUrl", "getCollectPopLinkUrl", "collectPopLinkText", "c", "collectPopText", "d", "aweType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "linkShareDesc", "h", "reportUrl", ce.f26395j, "searchEntryStyle", ce.f26396k, "searchSchemaPrefix", "l", "Lcom/bytedance/locallife/host/share/QrCodeShareInfo;", "qrCodeShareInfo", "Lcom/bytedance/locallife/host/share/QrCodeShareInfo;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/locallife/host/share/QrCodeShareInfo;", "", "unifyPoiGoodsShareAb", "I", "getUnifyPoiGoodsShareAb", "()I", "Lcom/bytedance/locallife/host/share/CollectExtraParams;", "collectExtraParams", "Lcom/bytedance/locallife/host/share/CollectExtraParams;", "b", "()Lcom/bytedance/locallife/host/share/CollectExtraParams;", "setCollectExtraParams", "(Lcom/bytedance/locallife/host/share/CollectExtraParams;)V", "showSearchButtonInX", "o", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("awe_type")
    private final String aweType;

    @SerializedName("collect_extra")
    private CollectExtraParams collectExtraParams;

    @SerializedName("collectPopLinkText")
    private final String collectPopLinkText;

    @SerializedName("collectPopLinkUrl")
    private final String collectPopLinkUrl;

    @SerializedName("collectPopText")
    private final String collectPopText;

    @SerializedName("command_share_params")
    private final String commandShareParams;

    @SerializedName("im_extra")
    private ImExtraParams imExtraParams;

    @SerializedName("innerUrl")
    private final String innerUrl;

    @SerializedName("isCollected")
    private final Boolean isCollected;

    @SerializedName("link_share_desc")
    private final String linkShareDesc;

    @SerializedName("qrcode_share_info")
    private final QrCodeShareInfo qrCodeShareInfo;

    @SerializedName("report_url")
    private final String reportUrl;

    @SerializedName("search_entry_style")
    private final String searchEntryStyle;

    @SerializedName("search_schema_prefix")
    private final String searchSchemaPrefix;

    @SerializedName(ShareItem.SHARE_IMAGE)
    private final String shareImage;

    @SerializedName("shareTitle")
    private final String shareTitle;

    @SerializedName("show_search_icon_in_x")
    private final int showSearchButtonInX;

    @SerializedName("type")
    private final String type;

    @SerializedName("unify_poi_goods_share_ab")
    private final int unifyPoiGoodsShareAb;

    @SerializedName("url")
    private final String url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.innerUrl, r101.innerUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.commandShareParams, r101.commandShareParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imExtraParams, r101.imExtraParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shareTitle, r101.shareTitle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.shareImage, r101.shareImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isCollected, r101.isCollected) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.collectPopLinkUrl, r101.collectPopLinkUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.collectPopLinkText, r101.collectPopLinkText) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.collectPopText, r101.collectPopText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.aweType, r101.aweType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.linkShareDesc, r101.linkShareDesc) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.reportUrl, r101.reportUrl) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.searchEntryStyle, r101.searchEntryStyle) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.searchSchemaPrefix, r101.searchSchemaPrefix) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.qrCodeShareInfo, r101.qrCodeShareInfo) == true) goto L60;
        return false;
    L60:
        if (this.unifyPoiGoodsShareAb == r101.unifyPoiGoodsShareAb) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.collectExtraParams, r101.collectExtraParams) == true) goto L66;
        return false;
    L66:
        if (this.showSearchButtonInX == r101.showSearchButtonInX) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.innerUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.commandShareParams;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ImExtraParams r113 = this.imExtraParams;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.shareTitle;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.shareImage;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.isCollected;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.collectPopLinkUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.collectPopLinkText;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.collectPopText;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.aweType;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.linkShareDesc;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.reportUrl;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.searchEntryStyle;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.searchSchemaPrefix;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        QrCodeShareInfo r149 = this.qrCodeShareInfo;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (((r148 + r150) * 31) + this.unifyPoiGoodsShareAb) * 31;
        CollectExtraParams r152 = this.collectExtraParams;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return ((r151 + r101) * 31) + this.showSearchButtonInX;
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
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
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HeaderButtonInfo(type=" + this.type + ", url=" + this.url + ", innerUrl=" + this.innerUrl + ", commandShareParams=" + this.commandShareParams + ", imExtraParams=" + this.imExtraParams + ", shareTitle=" + this.shareTitle + ", shareImage=" + this.shareImage + ", isCollected=" + this.isCollected + ", collectPopLinkUrl=" + this.collectPopLinkUrl + ", collectPopLinkText=" + this.collectPopLinkText + ", collectPopText=" + this.collectPopText + ", aweType=" + this.aweType + ", linkShareDesc=" + this.linkShareDesc + ", reportUrl=" + this.reportUrl + ", searchEntryStyle=" + this.searchEntryStyle + ", searchSchemaPrefix=" + this.searchSchemaPrefix + ", qrCodeShareInfo=" + this.qrCodeShareInfo + ", unifyPoiGoodsShareAb=" + this.unifyPoiGoodsShareAb + ", collectExtraParams=" + this.collectExtraParams + ", showSearchButtonInX=" + this.showSearchButtonInX + ')';
    }

    public a() {
        this.type = null;
        this.url = null;
        this.innerUrl = null;
        this.commandShareParams = null;
        this.imExtraParams = null;
        this.shareTitle = null;
        this.shareImage = null;
        this.isCollected = null;
        this.collectPopLinkUrl = null;
        this.collectPopLinkText = null;
        this.collectPopText = null;
        this.aweType = null;
        this.linkShareDesc = null;
        this.reportUrl = null;
        this.searchEntryStyle = null;
        this.searchSchemaPrefix = null;
        this.qrCodeShareInfo = null;
        this.unifyPoiGoodsShareAb = 0;
        this.collectExtraParams = null;
        this.showSearchButtonInX = 0;
    }

    public final String a() {
        return this.aweType;
    }

    public final CollectExtraParams b() {
        return this.collectExtraParams;
    }

    public final String c() {
        return this.collectPopLinkText;
    }

    public final String d() {
        return this.collectPopText;
    }

    public final String e() {
        return this.commandShareParams;
    }

    public final ImExtraParams f() {
        return this.imExtraParams;
    }

    public final String g() {
        return this.innerUrl;
    }

    public final String getType() {
        return this.type;
    }

    public final String h() {
        return this.linkShareDesc;
    }

    public final QrCodeShareInfo i() {
        return this.qrCodeShareInfo;
    }

    public final String j() {
        return this.reportUrl;
    }

    public final String k() {
        return this.searchEntryStyle;
    }

    public final String l() {
        return this.searchSchemaPrefix;
    }

    public final String m() {
        return this.shareImage;
    }

    public final String n() {
        return this.shareTitle;
    }

    public final int o() {
        return this.showSearchButtonInX;
    }

    public final String p() {
        return this.url;
    }

    public final Boolean q() {
        return this.isCollected;
    }
}
