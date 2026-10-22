package com.bytedance.locallife.poi.newdetail;

import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/c;", "", "", "primaryColor", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "textInverseColor", "getTextInverseColor", LynxResourceModule.FONT_TYPE, "e", "boldFont", "c", "", "cardBorderRadius", "I", "d", "()I", "backgroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "backgroundTexture", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "b", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "buttonBorderRadius", "getButtonBorderRadius", "imagePlaceholderColor", "getImagePlaceholderColor", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("background_texture_url")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final PoiImageUrlModel backgroundTexture;

    @SerializedName("bold_font")
    private final String boldFont;

    @SerializedName("button_border_radius")
    private final int buttonBorderRadius;

    @SerializedName("card_border_radius")
    private final int cardBorderRadius;

    @SerializedName(LynxResourceModule.FONT_TYPE)
    private final String font;

    @SerializedName("image_placeholder_color")
    private final String imagePlaceholderColor;

    @SerializedName("primary_color")
    private final String primaryColor;

    @SerializedName("text_inverse_color")
    private final String textInverseColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.primaryColor, r101.primaryColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textInverseColor, r101.textInverseColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.font, r101.font) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.boldFont, r101.boldFont) == true) goto L21;
        return false;
    L21:
        if (this.cardBorderRadius == r101.cardBorderRadius) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundTexture, r101.backgroundTexture) == true) goto L30;
        return false;
    L30:
        if (this.buttonBorderRadius == r101.buttonBorderRadius) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imagePlaceholderColor, r101.imagePlaceholderColor) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.primaryColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.textInverseColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.font;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.boldFont;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.cardBorderRadius) * 31;
        String r113 = this.backgroundColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PoiImageUrlModel r116 = this.backgroundTexture;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((r115 + r117) * 31) + this.buttonBorderRadius) * 31;
        String r119 = this.imagePlaceholderColor;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "PageSkinConfig(primaryColor=" + this.primaryColor + ", textInverseColor=" + this.textInverseColor + ", font=" + this.font + ", boldFont=" + this.boldFont + ", cardBorderRadius=" + this.cardBorderRadius + ", backgroundColor=" + this.backgroundColor + ", backgroundTexture=" + this.backgroundTexture + ", buttonBorderRadius=" + this.buttonBorderRadius + ", imagePlaceholderColor=" + this.imagePlaceholderColor + ')';
    }

    public c() {
        this.primaryColor = "";
        this.textInverseColor = "";
        this.font = "";
        this.boldFont = "";
        this.cardBorderRadius = -1;
        this.backgroundColor = "";
        this.backgroundTexture = null;
        this.buttonBorderRadius = -1;
        this.imagePlaceholderColor = "";
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final PoiImageUrlModel b() {
        return this.backgroundTexture;
    }

    public final String c() {
        return this.boldFont;
    }

    public final int d() {
        return this.cardBorderRadius;
    }

    public final String e() {
        return this.font;
    }

    public final String f() {
        return this.primaryColor;
    }
}
