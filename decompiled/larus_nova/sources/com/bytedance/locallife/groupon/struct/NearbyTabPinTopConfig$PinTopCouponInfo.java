package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bD\u0010EJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jp\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b%\u0010$R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b)\u0010$R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b,\u0010$R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b-\u0010$R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\"\u001a\u0004\b6\u0010$\"\u0004\b7\u00108R\u0014\u0010:\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010$R\u0014\u0010<\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010$R\u0014\u0010>\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010$R\u0014\u0010A\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010C\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00102¨\u0006F"}, d2 = {"com/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$PinTopCouponInfo", "", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "component1", "", "component2", "component3", "Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;", "component4", "component5", "", "component6", "()Ljava/lang/Integer;", "component7", "component8", "imageUrl", "pinTopText", "highLightText", "couponInfo", "actionText", "showTime", "id", "closeActionText", "Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$PinTopCouponInfo;", "copy", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$PinTopCouponInfo;", "toString", "hashCode", "other", "", "equals", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getImageUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "Ljava/lang/String;", "getPinTopText", "()Ljava/lang/String;", "getHighLightText", "Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;", "getCouponInfo", "()Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;", "getActionText", "Ljava/lang/Integer;", "getShowTime", "getId", "getCloseActionText", "Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "type", "Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "getType", "()Lcom/bytedance/locallife/groupon/struct/TopGuideType;", "setType", "(Lcom/bytedance/locallife/groupon/struct/TopGuideType;)V", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "setActionType", "(Ljava/lang/String;)V", "getScene", "scene", "getComponentId", "componentId", "getText", "text", "getPriority", "()I", "priority", "getGuideType", "guideType", "<init>", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class NearbyTabPinTopConfig$PinTopCouponInfo {

    @SerializedName("action_text")
    private final String actionText;
    private String actionType;

    @SerializedName("close_action_text")
    private final String closeActionText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_INFO)
    private final NearbyTabPinTopConfig$CouponInfo couponInfo;

    @SerializedName("highlight_text")
    private final String highLightText;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("component_id")
    private final String f258834id;

    @SerializedName("image_url")
    private final UrlModel imageUrl;

    @SerializedName("pintop_text")
    private final String pinTopText;

    @SerializedName("show_time")
    private final Integer showTime;
    private TopGuideType type;

    public NearbyTabPinTopConfig$PinTopCouponInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ NearbyTabPinTopConfig$PinTopCouponInfo copy$default(NearbyTabPinTopConfig$PinTopCouponInfo r100, UrlModel r110, String r111, String r112, NearbyTabPinTopConfig$CouponInfo r113, String r114, Integer r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        UrlModel r101 = r100.imageUrl;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.pinTopText;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.highLightText;
    L15:
        if ((r118 & 8) == 0) goto L17;
        NearbyTabPinTopConfig$CouponInfo r104 = r100.couponInfo;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.actionText;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = r100.showTime;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.f258834id;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.closeActionText;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final UrlModel component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.pinTopText;
    }

    public final String component3() {
        return this.highLightText;
    }

    public final NearbyTabPinTopConfig$CouponInfo component4() {
        return this.couponInfo;
    }

    public final String component5() {
        return this.actionText;
    }

    public final Integer component6() {
        return this.showTime;
    }

    public final String component7() {
        return this.f258834id;
    }

    public final String component8() {
        return this.closeActionText;
    }

    public final NearbyTabPinTopConfig$PinTopCouponInfo copy(UrlModel r110, String r111, String r112, NearbyTabPinTopConfig$CouponInfo r113, String r114, Integer r115, String r116, String r117) {
        return new NearbyTabPinTopConfig$PinTopCouponInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyTabPinTopConfig$PinTopCouponInfo) == true) goto L8;
        return false;
    L8:
        NearbyTabPinTopConfig$PinTopCouponInfo r101 = (NearbyTabPinTopConfig$PinTopCouponInfo) r100;
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pinTopText, r101.pinTopText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.highLightText, r101.highLightText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.couponInfo, r101.couponInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionText, r101.actionText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showTime, r101.showTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f258834id, r101.f258834id) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.closeActionText, r101.closeActionText) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int getPriority() {
        return 5;
    }

    public String getScene() {
        return "pintop_dialog";
    }

    public int hashCode() {
        UrlModel r100 = this.imageUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pinTopText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.highLightText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        NearbyTabPinTopConfig$CouponInfo r110 = this.couponInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.actionText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.showTime;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f258834id;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.closeActionText;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "PinTopCouponInfo(imageUrl=" + this.imageUrl + ", pinTopText=" + this.pinTopText + ", highLightText=" + this.highLightText + ", couponInfo=" + this.couponInfo + ", actionText=" + this.actionText + ", showTime=" + this.showTime + ", id=" + this.f258834id + ", closeActionText=" + this.closeActionText + ')';
    }

    public String getComponentId() {
        String r100 = this.f258834id;
        Intrinsics.checkNotNullParameter("", "default");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public String getText() {
        String r100 = this.pinTopText;
        Intrinsics.checkNotNullParameter("", "default");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "";
    }

    public final String getActionText() {
        return this.actionText;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getCloseActionText() {
        return this.closeActionText;
    }

    public final NearbyTabPinTopConfig$CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public TopGuideType getGuideType() {
        return this.type;
    }

    public final String getHighLightText() {
        return this.highLightText;
    }

    public final String getId() {
        return this.f258834id;
    }

    public final UrlModel getImageUrl() {
        return this.imageUrl;
    }

    public final String getPinTopText() {
        return this.pinTopText;
    }

    public final Integer getShowTime() {
        return this.showTime;
    }

    public final TopGuideType getType() {
        return this.type;
    }

    public final void setActionType(String r100) {
        this.actionType = r100;
    }

    public final void setType(TopGuideType r100) {
        this.type = r100;
    }

    public NearbyTabPinTopConfig$PinTopCouponInfo(UrlModel r100, String r101, String r102, NearbyTabPinTopConfig$CouponInfo r103, String r104, Integer r105, String r106, String r107) {
        this.imageUrl = r100;
        this.pinTopText = r101;
        this.highLightText = r102;
        this.couponInfo = r103;
        this.actionText = r104;
        this.showTime = r105;
        this.f258834id = r106;
        this.closeActionText = r107;
    }

    public /* synthetic */ NearbyTabPinTopConfig$PinTopCouponInfo(UrlModel r110, String r111, String r112, NearbyTabPinTopConfig$CouponInfo r113, String r114, Integer r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        UrlModel r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        NearbyTabPinTopConfig$CouponInfo r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
