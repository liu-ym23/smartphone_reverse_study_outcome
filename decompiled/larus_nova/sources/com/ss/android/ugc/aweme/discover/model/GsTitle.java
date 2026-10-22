package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsTitle;", "Ljava/io/Serializable;", "name", "", "selectedIcon", "selectedTextColor", "unselectedTextColor", "prefixIcon", "prefixIconV2", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "selectedBackgroundGradientColor", "Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "unselectedBackgroundGradientColor", "unselectedBorderColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPrefixIcon", "getPrefixIconV2", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getSelectedBackgroundGradientColor", "()Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "getSelectedIcon", "getSelectedTextColor", "getUnselectedBackgroundGradientColor", "getUnselectedBorderColor", "getUnselectedTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GsTitle implements Serializable {

    @SerializedName("name")
    private final String name;

    @SerializedName("prefix_icon")
    private final String prefixIcon;

    @SerializedName("prefix_icon_v2")
    private final UrlModel prefixIconV2;

    @SerializedName("selected_background_gradient_color")
    private final ECGradientStruct selectedBackgroundGradientColor;

    @SerializedName("selected_icon")
    private final String selectedIcon;

    @SerializedName("selected_text_color")
    private final String selectedTextColor;

    @SerializedName("unselected_background_gradient_color")
    private final ECGradientStruct unselectedBackgroundGradientColor;

    @SerializedName("unselected_border_color")
    private final String unselectedBorderColor;

    @SerializedName("unselected_text_color")
    private final String unselectedTextColor;

    public GsTitle() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ GsTitle copy$default(GsTitle r110, String r111, String r112, String r113, String r114, String r115, UrlModel r116, ECGradientStruct r117, ECGradientStruct r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.selectedIcon;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.selectedTextColor;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.unselectedTextColor;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.prefixIcon;
    L23:
        if ((r210 & 32) == 0) goto L25;
        UrlModel r105 = r110.prefixIconV2;
    L27:
        if ((r210 & 64) == 0) goto L29;
        ECGradientStruct r106 = r110.selectedBackgroundGradientColor;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ECGradientStruct r107 = r110.unselectedBackgroundGradientColor;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.unselectedBorderColor;
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

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.selectedIcon;
    }

    public final String component3() {
        return this.selectedTextColor;
    }

    public final String component4() {
        return this.unselectedTextColor;
    }

    public final String component5() {
        return this.prefixIcon;
    }

    public final UrlModel component6() {
        return this.prefixIconV2;
    }

    public final ECGradientStruct component7() {
        return this.selectedBackgroundGradientColor;
    }

    public final ECGradientStruct component8() {
        return this.unselectedBackgroundGradientColor;
    }

    public final String component9() {
        return this.unselectedBorderColor;
    }

    public final GsTitle copy(String r110, String r111, String r112, String r113, String r114, UrlModel r115, ECGradientStruct r116, ECGradientStruct r117, String r210) {
        return new GsTitle(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GsTitle) == false) goto L24;
        GsTitle r101 = (GsTitle) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.selectedIcon, r101.selectedIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.selectedTextColor, r101.selectedTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unselectedTextColor, r101.unselectedTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.prefixIcon, r101.prefixIcon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.prefixIconV2, r101.prefixIconV2) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedBackgroundGradientColor, r101.selectedBackgroundGradientColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.unselectedBackgroundGradientColor, r101.unselectedBackgroundGradientColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.unselectedBorderColor, r101.unselectedBorderColor) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.selectedIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.selectedTextColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.unselectedTextColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.prefixIcon;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        UrlModel r116 = this.prefixIconV2;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ECGradientStruct r119 = this.selectedBackgroundGradientColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECGradientStruct r122 = this.unselectedBackgroundGradientColor;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.unselectedBorderColor;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GsTitle(name=" + this.name + ", selectedIcon=" + this.selectedIcon + ", selectedTextColor=" + this.selectedTextColor + ", unselectedTextColor=" + this.unselectedTextColor + ", prefixIcon=" + this.prefixIcon + ", prefixIconV2=" + this.prefixIconV2 + ", selectedBackgroundGradientColor=" + this.selectedBackgroundGradientColor + ", unselectedBackgroundGradientColor=" + this.unselectedBackgroundGradientColor + ", unselectedBorderColor=" + this.unselectedBorderColor + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrefixIcon() {
        return this.prefixIcon;
    }

    public final UrlModel getPrefixIconV2() {
        return this.prefixIconV2;
    }

    public final ECGradientStruct getSelectedBackgroundGradientColor() {
        return this.selectedBackgroundGradientColor;
    }

    public final String getSelectedIcon() {
        return this.selectedIcon;
    }

    public final String getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final ECGradientStruct getUnselectedBackgroundGradientColor() {
        return this.unselectedBackgroundGradientColor;
    }

    public final String getUnselectedBorderColor() {
        return this.unselectedBorderColor;
    }

    public final String getUnselectedTextColor() {
        return this.unselectedTextColor;
    }

    public GsTitle(String r100, String r101, String r102, String r103, String r104, UrlModel r105, ECGradientStruct r106, ECGradientStruct r107, String r108) {
        this.name = r100;
        this.selectedIcon = r101;
        this.selectedTextColor = r102;
        this.unselectedTextColor = r103;
        this.prefixIcon = r104;
        this.prefixIconV2 = r105;
        this.selectedBackgroundGradientColor = r106;
        this.unselectedBackgroundGradientColor = r107;
        this.unselectedBorderColor = r108;
    }

    public /* synthetic */ GsTitle(String r110, String r111, String r112, String r113, String r114, UrlModel r115, ECGradientStruct r116, ECGradientStruct r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        UrlModel r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        ECGradientStruct r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ECGradientStruct r108 = null;
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
