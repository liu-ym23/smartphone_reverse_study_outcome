package com.larksuite.component.card.component.image;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u009e\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u000bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0019R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u00067"}, d2 = {"Lcom/larksuite/component/card/component/image/ImageContentProps;", "", "imageId", "", "resId", "tintColor", "cropType", "isTranslateElement", "", "forcePreview", "originWidth", "", "originHeight", "disableLongImageTag", ECPromotion.TRANSPARENT_BOTTON_ICON, "disableTap", "loadingStyle", "preview", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/Integer;ZZZLjava/lang/String;Z)V", "getImageId", "()Ljava/lang/String;", "getResId", "getTintColor", "getCropType", "()Z", "getForcePreview", "getOriginWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOriginHeight", "getDisableLongImageTag", "getTransparent", "getDisableTap", "getLoadingStyle", "getPreview", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/Integer;ZZZLjava/lang/String;Z)Lcom/larksuite/component/card/component/image/ImageContentProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("crop_type")
    private final String cropType;

    @SerializedName("disableLongImageTag")
    private final boolean disableLongImageTag;

    @SerializedName("disableTap")
    private final boolean disableTap;

    @SerializedName("forcePreview")
    private final boolean forcePreview;

    @SerializedName("image_id")
    private final String imageId;

    @SerializedName("isTranslateElement")
    private final boolean isTranslateElement;

    @SerializedName("loadingStyle")
    private final String loadingStyle;

    @SerializedName("originHeight")
    private final Integer originHeight;

    @SerializedName("originWidth")
    private final Integer originWidth;

    @SerializedName("preview")
    private final boolean preview;

    @SerializedName("res_id")
    private final String resId;

    @SerializedName("tint_color")
    private final String tintColor;

    @SerializedName(ECPromotion.TRANSPARENT_BOTTON_ICON)
    private final boolean transparent;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.imageId, r101.imageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resId, r101.resId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tintColor, r101.tintColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cropType, r101.cropType) == true) goto L21;
        return false;
    L21:
        if (this.isTranslateElement == r101.isTranslateElement) goto L24;
        return false;
    L24:
        if (this.forcePreview == r101.forcePreview) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.originWidth, r101.originWidth) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originHeight, r101.originHeight) == true) goto L33;
        return false;
    L33:
        if (this.disableLongImageTag == r101.disableLongImageTag) goto L36;
        return false;
    L36:
        if (this.transparent == r101.transparent) goto L39;
        return false;
    L39:
        if (this.disableTap == r101.disableTap) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.loadingStyle, r101.loadingStyle) == true) goto L45;
        return false;
    L45:
        if (this.preview == r101.preview) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.imageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.resId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tintColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cropType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        int r113 = 1231;
        if (this.isTranslateElement == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.forcePreview == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        Integer r118 = this.originWidth;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.originHeight;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        if (this.disableLongImageTag == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (r123 + r124) * 31;
        if (this.transparent == false) goto L41;
        int r126 = 1231;
    L42:
        int r127 = (r125 + r126) * 31;
        if (this.disableTap == false) goto L45;
        int r128 = 1231;
    L46:
        int r129 = (r127 + r128) * 31;
        String r130 = this.loadingStyle;
        if (r130 == null) goto L50;
        r101 = r130.hashCode();
    L50:
        int r131 = (r129 + r101) * 31;
        if (this.preview == true) goto L55;
        r113 = 1237;
    L55:
        return r131 + r113;
    L45:
        r128 = 1237;
        goto L46
    L41:
        r126 = 1237;
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
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
        return "ImageContentProps(imageId=" + this.imageId + ", resId=" + this.resId + ", tintColor=" + this.tintColor + ", cropType=" + this.cropType + ", isTranslateElement=" + this.isTranslateElement + ", forcePreview=" + this.forcePreview + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", disableLongImageTag=" + this.disableLongImageTag + ", transparent=" + this.transparent + ", disableTap=" + this.disableTap + ", loadingStyle=" + this.loadingStyle + ", preview=" + this.preview + ')';
    }

    public final String a() {
        return this.cropType;
    }

    public final boolean b() {
        return this.disableLongImageTag;
    }

    public final boolean c() {
        return this.disableTap;
    }

    public final boolean d() {
        return this.forcePreview;
    }

    public final String e() {
        return this.imageId;
    }

    public final String f() {
        return this.loadingStyle;
    }

    public final Integer g() {
        return this.originHeight;
    }

    public final Integer h() {
        return this.originWidth;
    }

    public final boolean i() {
        return this.preview;
    }

    public final String j() {
        return this.resId;
    }

    public final String k() {
        return this.tintColor;
    }

    public final boolean l() {
        return this.transparent;
    }

    public final boolean m() {
        return this.isTranslateElement;
    }

    public /* synthetic */ a(int r110) {
        this(null, null, null, null, false, false, null, null, true, true, true, null, false);
    }

    public a(String r100, String r101, String r102, String r103, boolean r104, boolean r105, Integer r106, Integer r107, boolean r108, boolean r110, boolean r111, String r112, boolean r113) {
        this.imageId = r100;
        this.resId = r101;
        this.tintColor = r102;
        this.cropType = r103;
        this.isTranslateElement = r104;
        this.forcePreview = r105;
        this.originWidth = r106;
        this.originHeight = r107;
        this.disableLongImageTag = r108;
        this.transparent = r110;
        this.disableTap = r111;
        this.loadingStyle = r112;
        this.preview = r113;
    }
}
