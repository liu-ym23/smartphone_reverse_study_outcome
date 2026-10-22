package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R(\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001aR\"\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00109\u001a\u0004\u0018\u0001088\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010>\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010C\u001a\u0004\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010H\u001a\u0004\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010M\u001a\u0004\u0018\u00010L8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR(\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010\u0018\u001a\u0004\bR\u0010\u001aR\"\u0010S\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u00105\u001a\u0004\bT\u00107R\u001c\u0010V\u001a\u0004\u0018\u00010U8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001c\u0010[\u001a\u0004\u0018\u00010Z8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001c\u0010`\u001a\u0004\u0018\u00010_8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR(\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010\u0018\u001a\u0004\be\u0010\u001aR4\u0010f\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u0018\u001a\u0004\bg\u0010\u001a¨\u0006h"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/i0;", "", "", "index", "Ljava/lang/String;", "getIndex", "()Ljava/lang/String;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "Lcom/bytedance/locallife/live/goodsshelves/bean/g;", "cardBasic", "Lcom/bytedance/locallife/live/goodsshelves/bean/g;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/g;", "Lcom/bytedance/locallife/live/goodsshelves/bean/e0;", "title", "Lcom/bytedance/locallife/live/goodsshelves/bean/e0;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/locallife/live/goodsshelves/bean/e0;", "", "subtitle", "Ljava/util/Map;", "l", "()Ljava/util/Map;", "Lcom/bytedance/locallife/live/goodsshelves/bean/d0;", "soldCount", "Lcom/bytedance/locallife/live/goodsshelves/bean/d0;", ce.f26396k, "()Lcom/bytedance/locallife/live/goodsshelves/bean/d0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/o;", "image", "Lcom/bytedance/locallife/live/goodsshelves/bean/o;", "e", "()Lcom/bytedance/locallife/live/goodsshelves/bean/o;", "Lcom/bytedance/locallife/live/goodsshelves/bean/f;", "actionArea", "Lcom/bytedance/locallife/live/goodsshelves/bean/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/f;", "Lcom/bytedance/locallife/live/goodsshelves/bean/r;", "marketing", "Lcom/bytedance/locallife/live/goodsshelves/bean/r;", "h", "()Lcom/bytedance/locallife/live/goodsshelves/bean/r;", "Lcom/bytedance/locallife/live/goodsshelves/bean/n;", "group", "d", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/p;", "labels", "Ljava/util/List;", "f", "()Ljava/util/List;", "Lcom/bytedance/locallife/live/goodsshelves/bean/q;", "lottery", "Lcom/bytedance/locallife/live/goodsshelves/bean/q;", ce.f26391f, "()Lcom/bytedance/locallife/live/goodsshelves/bean/q;", "Lcom/bytedance/locallife/live/goodsshelves/bean/c0;", "shoppingCart", "Lcom/bytedance/locallife/live/goodsshelves/bean/c0;", "getShoppingCart", "()Lcom/bytedance/locallife/live/goodsshelves/bean/c0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/j;", "detail", "Lcom/bytedance/locallife/live/goodsshelves/bean/j;", "getDetail", "()Lcom/bytedance/locallife/live/goodsshelves/bean/j;", "Lcom/bytedance/locallife/live/goodsshelves/bean/z;", "sellingAtmosInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/z;", "getSellingAtmosInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/z;", "Lcom/bytedance/locallife/live/goodsshelves/bean/m;", ContainerPosition.FOOTER, "Lcom/bytedance/locallife/live/goodsshelves/bean/m;", "getFooter", "()Lcom/bytedance/locallife/live/goodsshelves/bean/m;", "tabTitle", "m", "sellingPointLabels", ce.f26395j, "Lcom/bytedance/locallife/live/goodsshelves/bean/u;", "previewModule", "Lcom/bytedance/locallife/live/goodsshelves/bean/u;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/locallife/live/goodsshelves/bean/u;", "Lcom/bytedance/locallife/live/goodsshelves/bean/b0;", "sessionInfo", "Lcom/bytedance/locallife/live/goodsshelves/bean/b0;", "getSessionInfo", "()Lcom/bytedance/locallife/live/goodsshelves/bean/b0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/k;", "extraParams", "Lcom/bytedance/locallife/live/goodsshelves/bean/k;", "c", "()Lcom/bytedance/locallife/live/goodsshelves/bean/k;", "trackingParams", "o", "tabTrackingParams", "getTabTrackingParams", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("action_area")
    private final f actionArea;

    @SerializedName("card_basic")
    private final g cardBasic;

    @SerializedName("detail")
    private final j detail;

    @SerializedName("extra_params")
    private final k extraParams;

    @SerializedName(ContainerPosition.FOOTER)
    private final m footer;

    @SerializedName("group")
    private final Map<String, n> group;

    @SerializedName("image")
    private final o image;

    @SerializedName("index")
    private final String index;

    @SerializedName("labels")
    private final List<p> labels;

    @SerializedName("lottery")
    private final q lottery;

    @SerializedName("marketing")
    private final r marketing;

    @SerializedName("preview_module")
    private final u previewModule;

    @SerializedName("selling_atmos_info")
    private final z sellingAtmosInfo;

    @SerializedName("selling_point_labels")
    private final List<p> sellingPointLabels;

    @SerializedName("session_info")
    private final b0 sessionInfo;

    @SerializedName("shopping_cart")
    private final c0 shoppingCart;

    @SerializedName("sold_count")
    private final d0 soldCount;

    @SerializedName("subtitle")
    private final Map<String, e0> subtitle;

    @SerializedName("tab_title")
    private final Map<String, e0> tabTitle;

    @SerializedName("tab_tracking_params")
    private final Map<String, Map<String, String>> tabTrackingParams;

    @SerializedName("title")
    private final e0 title;

    @SerializedName("tracking_params")
    private final Map<String, String> trackingParams;

    @SerializedName("type")
    private final Integer type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardBasic, r101.cardBasic) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.soldCount, r101.soldCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.actionArea, r101.actionArea) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.marketing, r101.marketing) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.group, r101.group) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.labels, r101.labels) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.lottery, r101.lottery) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.shoppingCart, r101.shoppingCart) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.detail, r101.detail) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sellingAtmosInfo, r101.sellingAtmosInfo) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.footer, r101.footer) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.tabTitle, r101.tabTitle) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sellingPointLabels, r101.sellingPointLabels) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.previewModule, r101.previewModule) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.sessionInfo, r101.sessionInfo) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.tabTrackingParams, r101.tabTrackingParams) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        String r100 = this.index;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.cardBasic;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        e0 r110 = this.title;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, e0> r113 = this.subtitle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        d0 r116 = this.soldCount;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        o r119 = this.image;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        f r122 = this.actionArea;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        r r125 = this.marketing;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, n> r128 = this.group;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<p> r131 = this.labels;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        q r134 = this.lottery;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        c0 r137 = this.shoppingCart;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        j r140 = this.detail;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        z r143 = this.sellingAtmosInfo;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        m r146 = this.footer;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Map<String, e0> r149 = this.tabTitle;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        List<p> r152 = this.sellingPointLabels;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        u r155 = this.previewModule;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        b0 r158 = this.sessionInfo;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        k r161 = this.extraParams;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        Map<String, String> r164 = this.trackingParams;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        Map<String, Map<String, String>> r167 = this.tabTrackingParams;
        if (r167 == null) goto L95;
        r101 = r167.hashCode();
    L95:
        return r166 + r101;
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
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
        return "LiveLocalLifeBFFCardData(index=" + this.index + ", type=" + this.type + ", cardBasic=" + this.cardBasic + ", title=" + this.title + ", subtitle=" + this.subtitle + ", soldCount=" + this.soldCount + ", image=" + this.image + ", actionArea=" + this.actionArea + ", marketing=" + this.marketing + ", group=" + this.group + ", labels=" + this.labels + ", lottery=" + this.lottery + ", shoppingCart=" + this.shoppingCart + ", detail=" + this.detail + ", sellingAtmosInfo=" + this.sellingAtmosInfo + ", footer=" + this.footer + ", tabTitle=" + this.tabTitle + ", sellingPointLabels=" + this.sellingPointLabels + ", previewModule=" + this.previewModule + ", sessionInfo=" + this.sessionInfo + ", extraParams=" + this.extraParams + ", trackingParams=" + this.trackingParams + ", tabTrackingParams=" + this.tabTrackingParams + ')';
    }

    public final f a() {
        return this.actionArea;
    }

    public final g b() {
        return this.cardBasic;
    }

    public final k c() {
        return this.extraParams;
    }

    public final Map<String, n> d() {
        return this.group;
    }

    public final o e() {
        return this.image;
    }

    public final List<p> f() {
        return this.labels;
    }

    public final q g() {
        return this.lottery;
    }

    public final Integer getType() {
        return this.type;
    }

    public final r h() {
        return this.marketing;
    }

    public final u i() {
        return this.previewModule;
    }

    public final List<p> j() {
        return this.sellingPointLabels;
    }

    public final d0 k() {
        return this.soldCount;
    }

    public final Map<String, e0> l() {
        return this.subtitle;
    }

    public final Map<String, e0> m() {
        return this.tabTitle;
    }

    public final e0 n() {
        return this.title;
    }

    public final Map<String, String> o() {
        return this.trackingParams;
    }
}
