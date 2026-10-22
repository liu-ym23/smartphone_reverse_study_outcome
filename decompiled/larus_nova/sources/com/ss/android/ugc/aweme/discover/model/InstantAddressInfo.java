package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u000bHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u00066"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/InstantAddressInfo;", "Ljava/io/Serializable;", "text", "", "backgroundColor", "textColor", "buttonText", "buttonSchema", "buttonTextColor", "iconUrl", "showAddress", "", "addressSource", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAddressSource", "()Ljava/lang/String;", "setAddressSource", "(Ljava/lang/String;)V", "getBackgroundColor", "setBackgroundColor", "getButtonSchema", "setButtonSchema", "getButtonText", "setButtonText", "getButtonTextColor", "setButtonTextColor", "getIconUrl", "setIconUrl", "getShowAddress", "()Ljava/lang/Integer;", "setShowAddress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getText", "setText", "getTextColor", "setTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/discover/model/InstantAddressInfo;", "equals", "", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InstantAddressInfo implements Serializable {

    @SerializedName("address_source")
    private String addressSource;

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("button_schema")
    private String buttonSchema;

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("button_text_color")
    private String buttonTextColor;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("show_address")
    private Integer showAddress;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    public InstantAddressInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ InstantAddressInfo copy$default(InstantAddressInfo r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, Integer r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.text;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.backgroundColor;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.textColor;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.buttonText;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.buttonSchema;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.buttonTextColor;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.iconUrl;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.showAddress;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.addressSource;
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
        return this.text;
    }

    public final String component2() {
        return this.backgroundColor;
    }

    public final String component3() {
        return this.textColor;
    }

    public final String component4() {
        return this.buttonText;
    }

    public final String component5() {
        return this.buttonSchema;
    }

    public final String component6() {
        return this.buttonTextColor;
    }

    public final String component7() {
        return this.iconUrl;
    }

    public final Integer component8() {
        return this.showAddress;
    }

    public final String component9() {
        return this.addressSource;
    }

    public final InstantAddressInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r117, String r210) {
        return new InstantAddressInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InstantAddressInfo) == false) goto L24;
        InstantAddressInfo r101 = (InstantAddressInfo) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buttonSchema, r101.buttonSchema) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.buttonTextColor, r101.buttonTextColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.showAddress, r101.showAddress) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.addressSource, r101.addressSource) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.backgroundColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.buttonText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.buttonSchema;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.buttonTextColor;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.iconUrl;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.showAddress;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.addressSource;
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
        return "InstantAddressInfo(text=" + this.text + ", backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ", buttonText=" + this.buttonText + ", buttonSchema=" + this.buttonSchema + ", buttonTextColor=" + this.buttonTextColor + ", iconUrl=" + this.iconUrl + ", showAddress=" + this.showAddress + ", addressSource=" + this.addressSource + ")";
    }

    public final String getAddressSource() {
        return this.addressSource;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getButtonSchema() {
        return this.buttonSchema;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Integer getShowAddress() {
        return this.showAddress;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setAddressSource(String r100) {
        this.addressSource = r100;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setButtonSchema(String r100) {
        this.buttonSchema = r100;
    }

    public final void setButtonText(String r100) {
        this.buttonText = r100;
    }

    public final void setButtonTextColor(String r100) {
        this.buttonTextColor = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setShowAddress(Integer r100) {
        this.showAddress = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public InstantAddressInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107, String r108) {
        this.text = r100;
        this.backgroundColor = r101;
        this.textColor = r102;
        this.buttonText = r103;
        this.buttonSchema = r104;
        this.buttonTextColor = r105;
        this.iconUrl = r106;
        this.showAddress = r107;
        this.addressSource = r108;
    }

    public /* synthetic */ InstantAddressInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r117, String r118, int r210, DefaultConstructorMarker r211) {
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
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
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
