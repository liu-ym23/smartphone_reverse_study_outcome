package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ColorIcon;", "Ljava/io/Serializable;", "imageSet", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "faviconUrl", "", "themeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getImageSet", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "getFaviconUrl", "()Ljava/lang/String;", "getThemeColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorIcon implements Serializable {
    private final String faviconUrl;
    private final ImageSet imageSet;
    private final ThemeColor themeColor;
    private final UDIcon udIcon;

    public static /* synthetic */ ColorIcon copy$default(ColorIcon r100, ImageSet r101, String r102, ThemeColor r103, UDIcon r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.imageSet;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.faviconUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.themeColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.udIcon;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ImageSet component1() {
        return this.imageSet;
    }

    public final String component2() {
        return this.faviconUrl;
    }

    public final ThemeColor component3() {
        return this.themeColor;
    }

    public final UDIcon component4() {
        return this.udIcon;
    }

    public final ColorIcon copy(ImageSet r100, String r101, ThemeColor r102, UDIcon r103) {
        return new ColorIcon(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ColorIcon) == true) goto L8;
        return false;
    L8:
        ColorIcon r101 = (ColorIcon) r100;
        if (Intrinsics.areEqual(this.imageSet, r101.imageSet) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.faviconUrl, r101.faviconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.themeColor, r101.themeColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.udIcon, r101.udIcon) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        ImageSet r100 = this.imageSet;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.faviconUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ThemeColor r107 = this.themeColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UDIcon r110 = this.udIcon;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ColorIcon(imageSet=" + this.imageSet + ", faviconUrl=" + this.faviconUrl + ", themeColor=" + this.themeColor + ", udIcon=" + this.udIcon + ')';
    }

    public final String getFaviconUrl() {
        return this.faviconUrl;
    }

    public final ImageSet getImageSet() {
        return this.imageSet;
    }

    public final ThemeColor getThemeColor() {
        return this.themeColor;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public ColorIcon(ImageSet r100, String r101, ThemeColor r102, UDIcon r103) {
        this.imageSet = r100;
        this.faviconUrl = r101;
        this.themeColor = r102;
        this.udIcon = r103;
    }
}
