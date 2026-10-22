package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001aR\"\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010&\u001a\u0004\b2\u0010(R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00107\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010&\u001a\u0004\b8\u0010(¨\u00069"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/n;", "", "", "brandType", "Ljava/lang/Integer;", "getBrandType", "()Ljava/lang/Integer;", "groupOrder", ce.f26391f, "groupCount", "f", "expGroupOrder", "e", "expGroupCount", "d", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "brandName", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "brandSubName", "c", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "brandIcon", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "", "hasGroup", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "brandV2Title", "getBrandV2Title", "brandV2Avatar", "getBrandV2Avatar", "", "brandV2JumpUrl", "Ljava/lang/String;", "getBrandV2JumpUrl", "()Ljava/lang/String;", "brandV2StarIcon", "getBrandV2StarIcon", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/g0;", "brandV2StarAndText", "Ljava/util/List;", "getBrandV2StarAndText", "()Ljava/util/List;", "brandV2MarketingInfo", "getBrandV2MarketingInfo", "brandV2StarCountTextSize", "getBrandV2StarCountTextSize", "brandIconTopMargin", "getBrandIconTopMargin", "brandIconBorderColor", "getBrandIconBorderColor", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("brand_icon")
    private final t brandIcon;

    @SerializedName("brand_icon_border_color")
    private final String brandIconBorderColor;

    @SerializedName("brand_icon_top_margin")
    private final Integer brandIconTopMargin;

    @SerializedName("brand_name")
    private final x brandName;

    @SerializedName("brand_subname")
    private final x brandSubName;

    @SerializedName("brand_type")
    private final Integer brandType;

    @SerializedName("brand_v2_avatar")
    private final t brandV2Avatar;

    @SerializedName("brand_v2_jump_url")
    private final String brandV2JumpUrl;

    @SerializedName("brand_v2_marketing_info")
    private final String brandV2MarketingInfo;

    @SerializedName("brand_v2_star_and_text")
    private final List<g0> brandV2StarAndText;

    @SerializedName("brand_v2_star_count_text_size")
    private final Integer brandV2StarCountTextSize;

    @SerializedName("brand_v2_star_icon")
    private final t brandV2StarIcon;

    @SerializedName("brand_v2_title")
    private final x brandV2Title;

    @SerializedName("exp_group_count")
    private final Integer expGroupCount;

    @SerializedName("exp_group_order")
    private final Integer expGroupOrder;

    @SerializedName("group_count")
    private final Integer groupCount;

    @SerializedName("group_order")
    private final Integer groupOrder;

    @SerializedName("has_group")
    private final Boolean hasGroup;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.brandType, r101.brandType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupOrder, r101.groupOrder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.groupCount, r101.groupCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expGroupOrder, r101.expGroupOrder) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.expGroupCount, r101.expGroupCount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.brandName, r101.brandName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.brandSubName, r101.brandSubName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.brandIcon, r101.brandIcon) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.hasGroup, r101.hasGroup) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.brandV2Title, r101.brandV2Title) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.brandV2Avatar, r101.brandV2Avatar) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.brandV2JumpUrl, r101.brandV2JumpUrl) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.brandV2StarIcon, r101.brandV2StarIcon) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.brandV2StarAndText, r101.brandV2StarAndText) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.brandV2MarketingInfo, r101.brandV2MarketingInfo) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.brandV2StarCountTextSize, r101.brandV2StarCountTextSize) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.brandIconTopMargin, r101.brandIconTopMargin) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.brandIconBorderColor, r101.brandIconBorderColor) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.brandType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.groupOrder;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.groupCount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.expGroupOrder;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.expGroupCount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        x r116 = this.brandName;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        x r119 = this.brandSubName;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        t r122 = this.brandIcon;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.hasGroup;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        x r128 = this.brandV2Title;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        t r131 = this.brandV2Avatar;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.brandV2JumpUrl;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        t r137 = this.brandV2StarIcon;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<g0> r140 = this.brandV2StarAndText;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.brandV2MarketingInfo;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.brandV2StarCountTextSize;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.brandIconTopMargin;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.brandIconBorderColor;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return r151 + r101;
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
        return "LiveLifeBFFCardGroupInfo(brandType=" + this.brandType + ", groupOrder=" + this.groupOrder + ", groupCount=" + this.groupCount + ", expGroupOrder=" + this.expGroupOrder + ", expGroupCount=" + this.expGroupCount + ", brandName=" + this.brandName + ", brandSubName=" + this.brandSubName + ", brandIcon=" + this.brandIcon + ", hasGroup=" + this.hasGroup + ", brandV2Title=" + this.brandV2Title + ", brandV2Avatar=" + this.brandV2Avatar + ", brandV2JumpUrl=" + this.brandV2JumpUrl + ", brandV2StarIcon=" + this.brandV2StarIcon + ", brandV2StarAndText=" + this.brandV2StarAndText + ", brandV2MarketingInfo=" + this.brandV2MarketingInfo + ", brandV2StarCountTextSize=" + this.brandV2StarCountTextSize + ", brandIconTopMargin=" + this.brandIconTopMargin + ", brandIconBorderColor=" + this.brandIconBorderColor + ')';
    }

    public final t a() {
        return this.brandIcon;
    }

    public final x b() {
        return this.brandName;
    }

    public final x c() {
        return this.brandSubName;
    }

    public final Integer d() {
        return this.expGroupCount;
    }

    public final Integer e() {
        return this.expGroupOrder;
    }

    public final Integer f() {
        return this.groupCount;
    }

    public final Integer g() {
        return this.groupOrder;
    }

    public final Boolean h() {
        return this.hasGroup;
    }
}
