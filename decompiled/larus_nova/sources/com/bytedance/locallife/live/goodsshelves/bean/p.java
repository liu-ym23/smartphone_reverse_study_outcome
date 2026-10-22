package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000bR\u001c\u0010#\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016R\u001c\u0010%\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b&\u0010\u000bR(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/p;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "needKeep", "Ljava/lang/Boolean;", "getNeedKeep", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/s;", "content", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "backgroundColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "borderColor", "getBorderColor", "paddingLeft", "getPaddingLeft", "paddingRight", "getPaddingRight", "paddingTop", "getPaddingTop", "paddingBottom", "getPaddingBottom", "needTapTracking", "getNeedTapTracking", "linkUrl", "getLinkUrl", "skipOverflowContent", "c", "", "trackingParams", "Ljava/util/Map;", "getTrackingParams", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("content")
    private final List<s> content;

    @SerializedName("link_url")
    private final String linkUrl;

    @SerializedName("need_keep")
    private final Boolean needKeep;

    @SerializedName("need_tap_tracking")
    private final Boolean needTapTracking;

    @SerializedName("padding_bottom")
    private final Integer paddingBottom;

    @SerializedName("padding_left")
    private final Integer paddingLeft;

    @SerializedName("padding_right")
    private final Integer paddingRight;

    @SerializedName("padding_top")
    private final Integer paddingTop;

    @SerializedName("skip_overflow_content")
    private final Boolean skipOverflowContent;

    @SerializedName("tracking_params")
    private final Map<String, String> trackingParams;

    @SerializedName("type")
    private final Integer type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needKeep, r101.needKeep) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.paddingLeft, r101.paddingLeft) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.paddingRight, r101.paddingRight) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.paddingTop, r101.paddingTop) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.paddingBottom, r101.paddingBottom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.needTapTracking, r101.needTapTracking) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.linkUrl, r101.linkUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.skipOverflowContent, r101.skipOverflowContent) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.trackingParams, r101.trackingParams) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.needKeep;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<s> r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.backgroundColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.borderColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.paddingLeft;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.paddingRight;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.paddingTop;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.paddingBottom;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.needTapTracking;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.linkUrl;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.skipOverflowContent;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Map<String, String> r137 = this.trackingParams;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
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
        return "LiveLifeBFFCardLabelInfo(type=" + this.type + ", needKeep=" + this.needKeep + ", content=" + this.content + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", needTapTracking=" + this.needTapTracking + ", linkUrl=" + this.linkUrl + ", skipOverflowContent=" + this.skipOverflowContent + ", trackingParams=" + this.trackingParams + ')';
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final List<s> b() {
        return this.content;
    }

    public final Boolean c() {
        return this.skipOverflowContent;
    }

    public final Integer getType() {
        return this.type;
    }
}
