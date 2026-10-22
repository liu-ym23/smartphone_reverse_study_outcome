package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jz\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b-\u0010\u0018¨\u0006>"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "", "targetImgUrl", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "sloganDisable", "", "arrowStyle", "", "layoutAdaptType", "arrowHeadImgUrl", "arrowNockImgUrl", "richArrowSettingsStruct", "Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;", "topSloganType", "topSlogan", "Lcom/bytedance/locallife/groupon/struct/TopSloganStruct;", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/TopSloganStruct;)V", "getArrowHeadImgUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "setArrowHeadImgUrl", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "getArrowNockImgUrl", "setArrowNockImgUrl", "getArrowStyle", "()Ljava/lang/Integer;", "setArrowStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isCanShowSlogan", "()Ljava/lang/Boolean;", "setCanShowSlogan", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLayoutAdaptType", "setLayoutAdaptType", "getRichArrowSettingsStruct", "()Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;", "setRichArrowSettingsStruct", "(Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;)V", "getSloganDisable", "setSloganDisable", "getTargetImgUrl", "setTargetImgUrl", "getTopSlogan", "()Lcom/bytedance/locallife/groupon/struct/TopSloganStruct;", "getTopSloganType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/TopSloganStruct;)Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "equals", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ArrowStyleConfigStruct {

    @SerializedName("arrow_head_img_url")
    private UrlModel arrowHeadImgUrl;

    @SerializedName("arrow_nock_img_url")
    private UrlModel arrowNockImgUrl;

    @SerializedName("arrow_style")
    private Integer arrowStyle;
    private Boolean isCanShowSlogan;

    @SerializedName("layout_adapt_type")
    private Integer layoutAdaptType;

    @SerializedName("rich_arrow_settings")
    private RichArrowSettingsStruct richArrowSettingsStruct;

    @SerializedName("slogan_disable")
    private Boolean sloganDisable;

    @SerializedName("target_img_url")
    private UrlModel targetImgUrl;

    @SerializedName("top_slogan")
    private final TopSloganStruct topSlogan;

    @SerializedName("top_slogan_type")
    private final Integer topSloganType;

    public ArrowStyleConfigStruct() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ArrowStyleConfigStruct copy$default(ArrowStyleConfigStruct r110, UrlModel r111, Boolean r112, Integer r113, Integer r114, UrlModel r115, UrlModel r116, RichArrowSettingsStruct r117, Integer r118, TopSloganStruct r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        UrlModel r100 = r110.targetImgUrl;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Boolean r101 = r110.sloganDisable;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.arrowStyle;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.layoutAdaptType;
    L19:
        if ((r210 & 16) == 0) goto L21;
        UrlModel r104 = r110.arrowHeadImgUrl;
    L23:
        if ((r210 & 32) == 0) goto L25;
        UrlModel r105 = r110.arrowNockImgUrl;
    L27:
        if ((r210 & 64) == 0) goto L29;
        RichArrowSettingsStruct r106 = r110.richArrowSettingsStruct;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.topSloganType;
    L35:
        if ((r210 & 256) == 0) goto L37;
        TopSloganStruct r108 = r110.topSlogan;
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

    public final UrlModel component1() {
        return this.targetImgUrl;
    }

    public final Boolean component2() {
        return this.sloganDisable;
    }

    public final Integer component3() {
        return this.arrowStyle;
    }

    public final Integer component4() {
        return this.layoutAdaptType;
    }

    public final UrlModel component5() {
        return this.arrowHeadImgUrl;
    }

    public final UrlModel component6() {
        return this.arrowNockImgUrl;
    }

    public final RichArrowSettingsStruct component7() {
        return this.richArrowSettingsStruct;
    }

    public final Integer component8() {
        return this.topSloganType;
    }

    public final TopSloganStruct component9() {
        return this.topSlogan;
    }

    public final ArrowStyleConfigStruct copy(UrlModel r110, Boolean r111, Integer r112, Integer r113, UrlModel r114, UrlModel r115, RichArrowSettingsStruct r116, Integer r117, TopSloganStruct r210) {
        return new ArrowStyleConfigStruct(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArrowStyleConfigStruct) == true) goto L8;
        return false;
    L8:
        ArrowStyleConfigStruct r101 = (ArrowStyleConfigStruct) r100;
        if (Intrinsics.areEqual(this.targetImgUrl, r101.targetImgUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sloganDisable, r101.sloganDisable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.arrowStyle, r101.arrowStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.layoutAdaptType, r101.layoutAdaptType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.arrowHeadImgUrl, r101.arrowHeadImgUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.arrowNockImgUrl, r101.arrowNockImgUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.richArrowSettingsStruct, r101.richArrowSettingsStruct) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topSloganType, r101.topSloganType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.topSlogan, r101.topSlogan) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        UrlModel r100 = this.targetImgUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.sloganDisable;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.arrowStyle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.layoutAdaptType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        UrlModel r113 = this.arrowHeadImgUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        UrlModel r116 = this.arrowNockImgUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        RichArrowSettingsStruct r119 = this.richArrowSettingsStruct;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.topSloganType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        TopSloganStruct r125 = this.topSlogan;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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

    public String toString() {
        return "ArrowStyleConfigStruct(targetImgUrl=" + this.targetImgUrl + ", sloganDisable=" + this.sloganDisable + ", arrowStyle=" + this.arrowStyle + ", layoutAdaptType=" + this.layoutAdaptType + ", arrowHeadImgUrl=" + this.arrowHeadImgUrl + ", arrowNockImgUrl=" + this.arrowNockImgUrl + ", richArrowSettingsStruct=" + this.richArrowSettingsStruct + ", topSloganType=" + this.topSloganType + ", topSlogan=" + this.topSlogan + ')';
    }

    public final UrlModel getArrowHeadImgUrl() {
        return this.arrowHeadImgUrl;
    }

    public final UrlModel getArrowNockImgUrl() {
        return this.arrowNockImgUrl;
    }

    public final Integer getArrowStyle() {
        return this.arrowStyle;
    }

    public final Integer getLayoutAdaptType() {
        return this.layoutAdaptType;
    }

    public final RichArrowSettingsStruct getRichArrowSettingsStruct() {
        return this.richArrowSettingsStruct;
    }

    public final Boolean getSloganDisable() {
        return this.sloganDisable;
    }

    public final UrlModel getTargetImgUrl() {
        return this.targetImgUrl;
    }

    public final TopSloganStruct getTopSlogan() {
        return this.topSlogan;
    }

    public final Integer getTopSloganType() {
        return this.topSloganType;
    }

    public final Boolean isCanShowSlogan() {
        return this.isCanShowSlogan;
    }

    public final void setArrowHeadImgUrl(UrlModel r100) {
        this.arrowHeadImgUrl = r100;
    }

    public final void setArrowNockImgUrl(UrlModel r100) {
        this.arrowNockImgUrl = r100;
    }

    public final void setArrowStyle(Integer r100) {
        this.arrowStyle = r100;
    }

    public final void setCanShowSlogan(Boolean r100) {
        this.isCanShowSlogan = r100;
    }

    public final void setLayoutAdaptType(Integer r100) {
        this.layoutAdaptType = r100;
    }

    public final void setRichArrowSettingsStruct(RichArrowSettingsStruct r100) {
        this.richArrowSettingsStruct = r100;
    }

    public final void setSloganDisable(Boolean r100) {
        this.sloganDisable = r100;
    }

    public final void setTargetImgUrl(UrlModel r100) {
        this.targetImgUrl = r100;
    }

    public ArrowStyleConfigStruct(UrlModel r100, Boolean r101, Integer r102, Integer r103, UrlModel r104, UrlModel r105, RichArrowSettingsStruct r106, Integer r107, TopSloganStruct r108) {
        this.targetImgUrl = r100;
        this.sloganDisable = r101;
        this.arrowStyle = r102;
        this.layoutAdaptType = r103;
        this.arrowHeadImgUrl = r104;
        this.arrowNockImgUrl = r105;
        this.richArrowSettingsStruct = r106;
        this.topSloganType = r107;
        this.topSlogan = r108;
    }

    public /* synthetic */ ArrowStyleConfigStruct(UrlModel r110, Boolean r111, Integer r112, Integer r113, UrlModel r114, UrlModel r115, RichArrowSettingsStruct r116, Integer r117, TopSloganStruct r118, int r210, DefaultConstructorMarker r211) {
        TopSloganStruct r100 = null;
        if ((r210 & 1) == 0) goto L5;
        UrlModel r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Boolean r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r104 = 0;
    L19:
        if ((r210 & 16) == 0) goto L21;
        UrlModel r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        UrlModel r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        RichArrowSettingsStruct r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r108 = null;
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
