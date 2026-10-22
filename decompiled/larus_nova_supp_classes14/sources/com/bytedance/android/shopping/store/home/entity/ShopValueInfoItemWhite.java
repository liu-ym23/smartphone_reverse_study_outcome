package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\b\u0086\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u0099\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010¢\u0006\u0004\bF\u0010GJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010HÆ\u0003J¢\u0001\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0002HÖ\u0001J\u0013\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010(R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00104\u001a\u0004\b9\u00106\"\u0004\b:\u00108R$\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R$\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010)\u001a\u0004\b=\u0010+\"\u0004\b>\u0010-R$\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010)\u001a\u0004\b?\u0010+\"\u0004\b@\u0010-R2\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItemWhite;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "component3", "component4", "component5", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component6", "component7", "component8", "component9", "component10", "", "component11", "itemType", "valueText", "valueTextColor", "desc", "descTextColor", "descRightIcon", "icon", "url", "showEventName", "clickEventName", "eventParams", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItemWhite;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getItemType", "setItemType", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getValueText", "()Ljava/lang/String;", "setValueText", "(Ljava/lang/String;)V", "getValueTextColor", "setValueTextColor", "getDesc", "setDesc", "getDescTextColor", "setDescTextColor", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDescRightIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setDescRightIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getIcon", "setIcon", "getUrl", "setUrl", "getShowEventName", "setShowEventName", "getClickEventName", "setClickEventName", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopValueInfoItemWhite implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 3;

    @SerializedName("click_event_name")
    private String clickEventName;

    @SerializedName("desc")
    private String desc;

    @SerializedName("desc_right_icon")
    private ECUrlModel descRightIcon;

    @SerializedName("desc_text_color")
    private String descTextColor;

    @SerializedName("common_event_params")
    private Map<String, String> eventParams;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("item_type")
    private Integer itemType;

    @SerializedName("show_event_name")
    private String showEventName;

    @SerializedName("url")
    private String url;

    @SerializedName("value_text")
    private String valueText;

    @SerializedName("value_text_color")
    private String valueTextColor;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShopValueInfoItemWhite() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopValueInfoItemWhite copy$default(ShopValueInfoItemWhite r12, Integer r13, String r14, String r15, String r16, String r17, ECUrlModel r18, ECUrlModel r19, String r20, String r21, String r22, Map r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        Integer r2 = r12.itemType;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.valueText;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.valueTextColor;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.desc;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.descTextColor;
    L23:
        if ((r24 & 32) == 0) goto L25;
        ECUrlModel r7 = r12.descRightIcon;
    L27:
        if ((r24 & 64) == 0) goto L29;
        ECUrlModel r8 = r12.icon;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.url;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.showEventName;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.clickEventName;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Map r1 = r12.eventParams;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final Integer component1() {
        return this.itemType;
    }

    public final String component10() {
        return this.clickEventName;
    }

    public final Map<String, String> component11() {
        return this.eventParams;
    }

    public final String component2() {
        return this.valueText;
    }

    public final String component3() {
        return this.valueTextColor;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.descTextColor;
    }

    public final ECUrlModel component6() {
        return this.descRightIcon;
    }

    public final ECUrlModel component7() {
        return this.icon;
    }

    public final String component8() {
        return this.url;
    }

    public final String component9() {
        return this.showEventName;
    }

    public final ShopValueInfoItemWhite copy(Integer r14, String r15, String r16, String r17, String r18, ECUrlModel r19, ECUrlModel r20, String r21, String r22, String r23, Map<String, String> r24) {
        return new ShopValueInfoItemWhite(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopValueInfoItemWhite) == false) goto L28;
        ShopValueInfoItemWhite r4 = (ShopValueInfoItemWhite) r3;
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.valueText, r4.valueText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.valueTextColor, r4.valueTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.descTextColor, r4.descTextColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.descRightIcon, r4.descRightIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.showEventName, r4.showEventName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clickEventName, r4.clickEventName) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.eventParams, r4.eventParams) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.itemType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.valueText;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.valueTextColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.desc;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.descTextColor;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECUrlModel r16 = this.descRightIcon;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        ECUrlModel r19 = this.icon;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.url;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.showEventName;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.clickEventName;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Map<String, String> r31 = this.eventParams;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ShopValueInfoItemWhite(itemType=" + this.itemType + ", valueText=" + this.valueText + ", valueTextColor=" + this.valueTextColor + ", desc=" + this.desc + ", descTextColor=" + this.descTextColor + ", descRightIcon=" + this.descRightIcon + ", icon=" + this.icon + ", url=" + this.url + ", showEventName=" + this.showEventName + ", clickEventName=" + this.clickEventName + ", eventParams=" + this.eventParams + ")";
    }

    public final String getClickEventName() {
        return this.clickEventName;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ECUrlModel getDescRightIcon() {
        return this.descRightIcon;
    }

    public final String getDescTextColor() {
        return this.descTextColor;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getValueText() {
        return this.valueText;
    }

    public final String getValueTextColor() {
        return this.valueTextColor;
    }

    public final void setClickEventName(String r1) {
        this.clickEventName = r1;
    }

    public final void setDesc(String r1) {
        this.desc = r1;
    }

    public final void setDescRightIcon(ECUrlModel r1) {
        this.descRightIcon = r1;
    }

    public final void setDescTextColor(String r1) {
        this.descTextColor = r1;
    }

    public final void setEventParams(Map<String, String> r1) {
        this.eventParams = r1;
    }

    public final void setIcon(ECUrlModel r1) {
        this.icon = r1;
    }

    public final void setItemType(Integer r1) {
        this.itemType = r1;
    }

    public final void setShowEventName(String r1) {
        this.showEventName = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setValueText(String r1) {
        this.valueText = r1;
    }

    public final void setValueTextColor(String r1) {
        this.valueTextColor = r1;
    }

    public ShopValueInfoItemWhite(Integer r1, String r2, String r3, String r4, String r5, ECUrlModel r6, ECUrlModel r7, String r8, String r9, String r10, Map<String, String> r11) {
        this.itemType = r1;
        this.valueText = r2;
        this.valueTextColor = r3;
        this.desc = r4;
        this.descTextColor = r5;
        this.descRightIcon = r6;
        this.icon = r7;
        this.url = r8;
        this.showEventName = r9;
        this.clickEventName = r10;
        this.eventParams = r11;
    }

    public /* synthetic */ ShopValueInfoItemWhite(Integer r13, String r14, String r15, String r16, String r17, ECUrlModel r18, ECUrlModel r19, String r20, String r21, String r22, Map r23, int r24, DefaultConstructorMarker r25) {
        Map r2 = null;
        if ((r24 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        ECUrlModel r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        ECUrlModel r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
