package com.bytedance.locallife.live.goodsshelves.bean;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/f;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "buttonText", "Lcom/bytedance/locallife/live/goodsshelves/bean/x;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "", "bgColor", "Ljava/lang/String;", "getBgColor", "()Ljava/lang/String;", "schema", "getSchema", "", "clickable", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "clickToast", "b", GXTemplateKey.STYLE_OPACITY, "d", "hasCoin", "getHasCoin", "coinText", "getCoinText", "", "takeoutSelectedCount", "Ljava/lang/Integer;", "getTakeoutSelectedCount", "()Ljava/lang/Integer;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/Long;", "getActionType", "()Ljava/lang/Long;", "jumpType", "getJumpType", "", "extraParams", "Ljava/util/Map;", "getExtraParams", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("action_type")
    private final Long actionType;

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("button_text")
    private final x buttonText;

    @SerializedName("click_toast")
    private final String clickToast;

    @SerializedName("clickable")
    private final Boolean clickable;

    @SerializedName("coin_text")
    private final x coinText;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("has_coin")
    private final Boolean hasCoin;

    @SerializedName("jump_type")
    private final Integer jumpType;

    @SerializedName(GXTemplateKey.STYLE_OPACITY)
    private final String opacity;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("takeout_selected_count")
    private final Integer takeoutSelectedCount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickable, r101.clickable) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickToast, r101.clickToast) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.opacity, r101.opacity) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hasCoin, r101.hasCoin) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.coinText, r101.coinText) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.takeoutSelectedCount, r101.takeoutSelectedCount) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.jumpType, r101.jumpType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        x r100 = this.buttonText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.clickable;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.clickToast;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.opacity;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.hasCoin;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        x r122 = this.coinText;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.takeoutSelectedCount;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.actionType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.jumpType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, String> r134 = this.extraParams;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
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
        return "LiveLifeBFFCardActionArea(buttonText=" + this.buttonText + ", bgColor=" + this.bgColor + ", schema=" + this.schema + ", clickable=" + this.clickable + ", clickToast=" + this.clickToast + ", opacity=" + this.opacity + ", hasCoin=" + this.hasCoin + ", coinText=" + this.coinText + ", takeoutSelectedCount=" + this.takeoutSelectedCount + ", actionType=" + this.actionType + ", jumpType=" + this.jumpType + ", extraParams=" + this.extraParams + ')';
    }

    public final x a() {
        return this.buttonText;
    }

    public final String b() {
        return this.clickToast;
    }

    public final Boolean c() {
        return this.clickable;
    }

    public final String d() {
        return this.opacity;
    }
}
