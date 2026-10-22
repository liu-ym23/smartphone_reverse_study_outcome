package com.larus.livetutor.api.idl;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0006HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\f\u0010(\"\u0004\b)\u0010*R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\u000e\u0010(\"\u0004\b,\u0010*R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016¨\u0006D"}, d2 = {"Lcom/larus/livetutor/api/idl/Image;", "Ljava/io/Serializable;", "imageUri", "", "imageUrl", "width", "", "height", SubInfo.KEY_FORMAT, "largeUrl", "middleUrl", "smallUrl", "isDynamic", "", "isSigned", ThumbGlideUrl.SOURCE_TEMPLATE, "imageBase64", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getImageUri", "()Ljava/lang/String;", "setImageUri", "(Ljava/lang/String;)V", "getImageUrl", "setImageUrl", "getWidth", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeight", "setHeight", "getFormat", "setFormat", "getLargeUrl", "setLargeUrl", "getMiddleUrl", "setMiddleUrl", "getSmallUrl", "setSmallUrl", "()Ljava/lang/Boolean;", "setDynamic", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setSigned", "getTemplate", "setTemplate", "getImageBase64", "setImageBase64", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/Image;", "equals", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Image implements Serializable {

    @SerializedName(SubInfo.KEY_FORMAT)
    private String format;

    @SerializedName("height")
    private Integer height;

    @SerializedName("image_base64")
    private String imageBase64;

    @SerializedName("image_uri")
    private String imageUri;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("is_dynamic")
    private Boolean isDynamic;

    @SerializedName("is_signed")
    private Boolean isSigned;

    @SerializedName("large_url")
    private String largeUrl;

    @SerializedName("middle_url")
    private String middleUrl;

    @SerializedName("small_url")
    private String smallUrl;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private String template;

    @SerializedName("width")
    private Integer width;

    public Image() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ Image copy$default(Image r110, String r111, String r112, Integer r113, Integer r114, String r115, String r116, String r210, String r211, Boolean r212, Boolean r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.imageUri;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.imageUrl;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Integer r102 = r110.width;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r103 = r110.height;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.format;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.largeUrl;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.middleUrl;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.smallUrl;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Boolean r117 = r110.isDynamic;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r118 = r110.isSigned;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.template;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.imageBase64;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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
        return this.imageUri;
    }

    public final Boolean component10() {
        return this.isSigned;
    }

    public final String component11() {
        return this.template;
    }

    public final String component12() {
        return this.imageBase64;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final String component5() {
        return this.format;
    }

    public final String component6() {
        return this.largeUrl;
    }

    public final String component7() {
        return this.middleUrl;
    }

    public final String component8() {
        return this.smallUrl;
    }

    public final Boolean component9() {
        return this.isDynamic;
    }

    public final Image copy(String r110, String r111, Integer r112, Integer r113, String r114, String r210, String r211, String r212, Boolean r213, Boolean r214, String r215, String r216) {
        return new Image(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Image) == true) goto L8;
        return false;
    L8:
        Image r101 = (Image) r100;
        if (Intrinsics.areEqual(this.imageUri, r101.imageUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.largeUrl, r101.largeUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.middleUrl, r101.middleUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.smallUrl, r101.smallUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isDynamic, r101.isDynamic) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isSigned, r101.isSigned) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.imageBase64, r101.imageBase64) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.imageUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.imageUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.width;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.height;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.format;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.largeUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.middleUrl;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.smallUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.isDynamic;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isSigned;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.template;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.imageBase64;
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

    public String toString() {
        return "Image(imageUri=" + this.imageUri + ", imageUrl=" + this.imageUrl + ", width=" + this.width + ", height=" + this.height + ", format=" + this.format + ", largeUrl=" + this.largeUrl + ", middleUrl=" + this.middleUrl + ", smallUrl=" + this.smallUrl + ", isDynamic=" + this.isDynamic + ", isSigned=" + this.isSigned + ", template=" + this.template + ", imageBase64=" + this.imageBase64 + ')';
    }

    public final String getFormat() {
        return this.format;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getLargeUrl() {
        return this.largeUrl;
    }

    public final String getMiddleUrl() {
        return this.middleUrl;
    }

    public final String getSmallUrl() {
        return this.smallUrl;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean isDynamic() {
        return this.isDynamic;
    }

    public final Boolean isSigned() {
        return this.isSigned;
    }

    public final void setDynamic(Boolean r100) {
        this.isDynamic = r100;
    }

    public final void setFormat(String r100) {
        this.format = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setImageBase64(String r100) {
        this.imageBase64 = r100;
    }

    public final void setImageUri(String r100) {
        this.imageUri = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setLargeUrl(String r100) {
        this.largeUrl = r100;
    }

    public final void setMiddleUrl(String r100) {
        this.middleUrl = r100;
    }

    public final void setSigned(Boolean r100) {
        this.isSigned = r100;
    }

    public final void setSmallUrl(String r100) {
        this.smallUrl = r100;
    }

    public final void setTemplate(String r100) {
        this.template = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public Image(String r100, String r101, Integer r102, Integer r103, String r104, String r105, String r106, String r107, Boolean r108, Boolean r110, String r111, String r112) {
        this.imageUri = r100;
        this.imageUrl = r101;
        this.width = r102;
        this.height = r103;
        this.format = r104;
        this.largeUrl = r105;
        this.middleUrl = r106;
        this.smallUrl = r107;
        this.isDynamic = r108;
        this.isSigned = r110;
        this.template = r111;
        this.imageBase64 = r112;
    }

    public /* synthetic */ Image(String r110, String r111, Integer r112, Integer r113, String r114, String r115, String r210, String r211, Boolean r212, Boolean r213, String r214, String r215, int r216, DefaultConstructorMarker r217) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Boolean r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
