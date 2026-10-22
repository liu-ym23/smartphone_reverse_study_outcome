package com.larus.platform.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0086\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00062"}, d2 = {"Lcom/larus/platform/model/SKUInfo;", "Ljava/io/Serializable;", "id", "", "name", "currency", "amount", "", "discount", "Lcom/larus/platform/model/SKUDiscountInfo;", AppConstants.BUNDLE_TIP, "buttonText", "buttonTipText", "periodName", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/larus/platform/model/SKUDiscountInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCurrency", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDiscount", "()Lcom/larus/platform/model/SKUDiscountInfo;", "getTip", "getButtonText", "getButtonTipText", "getPeriodName", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/larus/platform/model/SKUDiscountInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/SKUInfo;", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SKUInfo implements Serializable {

    @SerializedName("amount")
    private final Double amount;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("button_tip_text")
    private final String buttonTipText;

    @SerializedName("currency")
    private final String currency;

    @SerializedName("discount")
    private final SKUDiscountInfo discount;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f365486id;

    @SerializedName("name")
    private final String name;

    @SerializedName("period_name")
    private final String periodName;

    @SerializedName(AppConstants.BUNDLE_TIP)
    private final String tip;

    @SerializedName("version")
    private final String version;

    public SKUInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ SKUInfo copy$default(SKUInfo r110, String r111, String r112, String r113, Double r114, SKUDiscountInfo r115, String r116, String r117, String r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.f365486id;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.currency;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Double r103 = r110.amount;
    L19:
        if ((r212 & 16) == 0) goto L21;
        SKUDiscountInfo r104 = r110.discount;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.tip;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.buttonText;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.buttonTipText;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.periodName;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.version;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    public final String component1() {
        return this.f365486id;
    }

    public final String component10() {
        return this.version;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.currency;
    }

    public final Double component4() {
        return this.amount;
    }

    public final SKUDiscountInfo component5() {
        return this.discount;
    }

    public final String component6() {
        return this.tip;
    }

    public final String component7() {
        return this.buttonText;
    }

    public final String component8() {
        return this.buttonTipText;
    }

    public final String component9() {
        return this.periodName;
    }

    public final SKUInfo copy(String r110, String r111, String r112, Double r113, SKUDiscountInfo r114, String r115, String r116, String r210, String r211, String r212) {
        return new SKUInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SKUInfo) == true) goto L8;
        return false;
    L8:
        SKUInfo r101 = (SKUInfo) r100;
        if (Intrinsics.areEqual(this.f365486id, r101.f365486id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currency, r101.currency) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.discount, r101.discount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tip, r101.tip) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buttonTipText, r101.buttonTipText) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.periodName, r101.periodName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.f365486id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currency;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.amount;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        SKUDiscountInfo r113 = this.discount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.tip;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.buttonText;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.buttonTipText;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.periodName;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.version;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
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

    public String toString() {
        return "SKUInfo(id=" + this.f365486id + ", name=" + this.name + ", currency=" + this.currency + ", amount=" + this.amount + ", discount=" + this.discount + ", tip=" + this.tip + ", buttonText=" + this.buttonText + ", buttonTipText=" + this.buttonTipText + ", periodName=" + this.periodName + ", version=" + this.version + ')';
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonTipText() {
        return this.buttonTipText;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final SKUDiscountInfo getDiscount() {
        return this.discount;
    }

    public final String getId() {
        return this.f365486id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPeriodName() {
        return this.periodName;
    }

    public final String getTip() {
        return this.tip;
    }

    public final String getVersion() {
        return this.version;
    }

    public SKUInfo(String r100, String r101, String r102, Double r103, SKUDiscountInfo r104, String r105, String r106, String r107, String r108, String r110) {
        this.f365486id = r100;
        this.name = r101;
        this.currency = r102;
        this.amount = r103;
        this.discount = r104;
        this.tip = r105;
        this.buttonText = r106;
        this.buttonTipText = r107;
        this.periodName = r108;
        this.version = r110;
    }

    public /* synthetic */ SKUInfo(String r110, String r111, String r112, Double r113, SKUDiscountInfo r114, String r115, String r116, String r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Double r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        SKUDiscountInfo r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
