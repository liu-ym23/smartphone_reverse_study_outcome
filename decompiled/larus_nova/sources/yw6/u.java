package yw6;

import com.amap.api.col.s.ce;
import com.bytedance.locallife.common.adapter.JsonToStringAdapter;
import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR$\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b&\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u0010\u0018R\u001c\u00108\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b=\u0010\fR\u001c\u0010>\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010\u0018¨\u0006@"}, d2 = {"Lyw6/u;", "", "", "Lcom/bytedance/locallife/host/share/a;", "buttons", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/String;", "backgroundColor", "b", "titleContentStyle", "o", "Lyw6/p;", "titleTabs", "p", "", "forceBottomElevator", "Ljava/lang/Boolean;", ce.f26391f, "()Ljava/lang/Boolean;", "adjustContentHeight", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "iconDisplayType", "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", "Lyw6/s;", "viewInfo", "Lyw6/s;", "q", "()Lyw6/s;", "sharePanelRequestParams", "l", "Lyw6/g;", "couponShareBubbleInfo", "Lyw6/g;", "e", "()Lyw6/g;", "Lyw6/h;", "couponShareTagInfo", "Lyw6/h;", "f", "()Lyw6/h;", "Lyw6/v;", "marketingShareInfo", "Lyw6/v;", RXScreenCaptureService.KEY_INDEX, "()Lyw6/v;", "tabMode", "m", "multiSkuInfo", "Ljava/lang/Object;", ce.f26395j, "()Ljava/lang/Object;", "multiSkuTabUrl", ce.f26396k, "canFoldButtonShow", "d", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("adjust_content_height")
    private final Boolean adjustContentHeight;

    @SerializedName("backgroundColor")
    private final String backgroundColor;

    @SerializedName("btns")
    private final List<com.bytedance.locallife.host.share.a> buttons;

    @SerializedName("can_fold_button_show")
    private final Boolean canFoldButtonShow;

    @SerializedName("share_bubble_info")
    private final g couponShareBubbleInfo;

    @SerializedName("share_tag_info")
    private final h couponShareTagInfo;

    @SerializedName("force_bottom_elevator")
    private final Boolean forceBottomElevator;

    @SerializedName("gd_half_screen_stable_btn")
    private final Integer iconDisplayType;

    @SerializedName("marketing_share_info")
    private final v marketingShareInfo;

    @SerializedName("multiSkuInfo")
    private final Object multiSkuInfo;

    @SerializedName("multiSkuTabUrl")
    private final String multiSkuTabUrl;

    @SerializedName("share_panel_request_params")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String sharePanelRequestParams;

    @SerializedName("tabMode")
    private final Boolean tabMode;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_content_style")
    private final String titleContentStyle;

    @SerializedName("title_tabs")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final List<p> titleTabs;

    @SerializedName("view_info")
    private final s viewInfo;

    public u() {
        Boolean r100 = Boolean.FALSE;
        this.buttons = null;
        this.title = null;
        this.backgroundColor = null;
        this.titleContentStyle = null;
        this.titleTabs = null;
        this.forceBottomElevator = null;
        this.adjustContentHeight = null;
        this.iconDisplayType = 0;
        this.viewInfo = null;
        this.sharePanelRequestParams = null;
        this.couponShareBubbleInfo = null;
        this.couponShareTagInfo = null;
        this.marketingShareInfo = null;
        this.tabMode = r100;
        this.multiSkuInfo = null;
        this.multiSkuTabUrl = null;
        this.canFoldButtonShow = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.buttons, r101.buttons) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleContentStyle, r101.titleContentStyle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.titleTabs, r101.titleTabs) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.forceBottomElevator, r101.forceBottomElevator) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.adjustContentHeight, r101.adjustContentHeight) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconDisplayType, r101.iconDisplayType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.viewInfo, r101.viewInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sharePanelRequestParams, r101.sharePanelRequestParams) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.couponShareBubbleInfo, r101.couponShareBubbleInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.couponShareTagInfo, r101.couponShareTagInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.marketingShareInfo, r101.marketingShareInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tabMode, r101.tabMode) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.multiSkuInfo, r101.multiSkuInfo) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.multiSkuTabUrl, r101.multiSkuTabUrl) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.canFoldButtonShow, r101.canFoldButtonShow) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        List<com.bytedance.locallife.host.share.a> r100 = this.buttons;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.backgroundColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.titleContentStyle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<p> r113 = this.titleTabs;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.forceBottomElevator;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.adjustContentHeight;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.iconDisplayType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        s r125 = this.viewInfo;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.sharePanelRequestParams;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        g r131 = this.couponShareBubbleInfo;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        h r134 = this.couponShareTagInfo;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        v r137 = this.marketingShareInfo;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.tabMode;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Object r143 = this.multiSkuInfo;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.multiSkuTabUrl;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.canFoldButtonShow;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
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
        return "HeaderData(buttons=" + this.buttons + ", title=" + this.title + ", backgroundColor=" + this.backgroundColor + ", titleContentStyle=" + this.titleContentStyle + ", titleTabs=" + this.titleTabs + ", forceBottomElevator=" + this.forceBottomElevator + ", adjustContentHeight=" + this.adjustContentHeight + ", iconDisplayType=" + this.iconDisplayType + ", viewInfo=" + this.viewInfo + ", sharePanelRequestParams=" + this.sharePanelRequestParams + ", couponShareBubbleInfo=" + this.couponShareBubbleInfo + ", couponShareTagInfo=" + this.couponShareTagInfo + ", marketingShareInfo=" + this.marketingShareInfo + ", tabMode=" + this.tabMode + ", multiSkuInfo=" + this.multiSkuInfo + ", multiSkuTabUrl=" + this.multiSkuTabUrl + ", canFoldButtonShow=" + this.canFoldButtonShow + ')';
    }

    public final Boolean a() {
        return this.adjustContentHeight;
    }

    public final String b() {
        return this.backgroundColor;
    }

    public final List<com.bytedance.locallife.host.share.a> c() {
        return this.buttons;
    }

    public final Boolean d() {
        return this.canFoldButtonShow;
    }

    public final g e() {
        return this.couponShareBubbleInfo;
    }

    public final h f() {
        return this.couponShareTagInfo;
    }

    public final Boolean g() {
        return this.forceBottomElevator;
    }

    public final Integer h() {
        return this.iconDisplayType;
    }

    public final v i() {
        return this.marketingShareInfo;
    }

    public final Object j() {
        return this.multiSkuInfo;
    }

    public final String k() {
        return this.multiSkuTabUrl;
    }

    public final String l() {
        return this.sharePanelRequestParams;
    }

    public final Boolean m() {
        return this.tabMode;
    }

    public final String n() {
        return this.title;
    }

    public final String o() {
        return this.titleContentStyle;
    }

    public final List<p> p() {
        return this.titleTabs;
    }

    public final s q() {
        return this.viewInfo;
    }
}
