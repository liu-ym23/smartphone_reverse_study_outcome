package com.bytedance.locallife.groupon.api.toptools.model;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/model/EntranceConfig;", "", "image", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "textColor", "", "imageDark", "textColorDark", "imageMode", "textFont", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getImageDark", "getImageMode", "()Ljava/lang/String;", "getTextColor", "getTextColorDark", "getTextFont", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class EntranceConfig {

    @SerializedName("image")
    private final UrlModel image;

    @SerializedName("image_dark")
    private final UrlModel imageDark;

    @SerializedName("image_mode")
    private final String imageMode;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("text_color_dark")
    private final String textColorDark;

    @SerializedName("text_font")
    private final String textFont;

    public EntranceConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ EntranceConfig copy$default(EntranceConfig r100, UrlModel r101, String r102, UrlModel r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.image;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.imageDark;
    L11:
        UrlModel r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.textColorDark;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.imageMode;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.textFont;
    L20:
        UrlModel r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final UrlModel component1() {
        return this.image;
    }

    public final String component2() {
        return this.textColor;
    }

    public final UrlModel component3() {
        return this.imageDark;
    }

    public final String component4() {
        return this.textColorDark;
    }

    public final String component5() {
        return this.imageMode;
    }

    public final String component6() {
        return this.textFont;
    }

    public final EntranceConfig copy(UrlModel r100, String r110, UrlModel r111, String r112, String r113, String r114) {
        return new EntranceConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EntranceConfig) == true) goto L8;
        return false;
    L8:
        EntranceConfig r101 = (EntranceConfig) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageDark, r101.imageDark) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textColorDark, r101.textColorDark) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageMode, r101.imageMode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textFont, r101.textFont) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        UrlModel r100 = this.image;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UrlModel r107 = this.imageDark;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.textColorDark;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.imageMode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.textFont;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "EntranceConfig(image=" + this.image + ", textColor=" + this.textColor + ", imageDark=" + this.imageDark + ", textColorDark=" + this.textColorDark + ", imageMode=" + this.imageMode + ", textFont=" + this.textFont + ')';
    }

    public final UrlModel getImage() {
        return this.image;
    }

    public final UrlModel getImageDark() {
        return this.imageDark;
    }

    public final String getImageMode() {
        return this.imageMode;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextColorDark() {
        return this.textColorDark;
    }

    public final String getTextFont() {
        return this.textFont;
    }

    public EntranceConfig(UrlModel r100, String r101, UrlModel r102, String r103, String r104, String r105) {
        this.image = r100;
        this.textColor = r101;
        this.imageDark = r102;
        this.textColorDark = r103;
        this.imageMode = r104;
        this.textFont = r105;
    }

    public /* synthetic */ EntranceConfig(UrlModel r100, String r101, UrlModel r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        UrlModel r104 = null;
        if ((r112 & 1) == 0) goto L5;
        UrlModel r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r112 & 4) != 0) goto L15;
        r104 = r102;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        r110 = "black";
    L21:
        String r107 = r110;
        if ((r112 & 32) == 0) goto L24;
        String r115 = "";
    L25:
        this(r114, r105, r104, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
    L17:
        r106 = r103;
        goto L19
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
