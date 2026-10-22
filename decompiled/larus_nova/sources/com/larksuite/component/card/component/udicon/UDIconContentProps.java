package com.larksuite.component.card.component.udicon;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JT\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "", "token", "", "color", "customColor", "imageId", "isTranslateElement", "", "iconSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)V", "getToken", "()Ljava/lang/String;", "getColor", "getCustomColor", "getImageId", "()Z", "getIconSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDIconContentProps {

    @SerializedName("color")
    private final String color;

    @SerializedName("customColor")
    private final String customColor;

    @SerializedName("iconSize")
    private final Integer iconSize;

    @SerializedName("imageID")
    private final String imageId;

    @SerializedName("isTranslateElement")
    private final boolean isTranslateElement;

    @SerializedName("token")
    private final String token;

    public UDIconContentProps() {
        this(null, null, null, null, false, null, 63, null);
    }

    public static /* synthetic */ UDIconContentProps copy$default(UDIconContentProps r100, String r101, String r102, String r103, String r104, boolean r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.color;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.customColor;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.imageId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isTranslateElement;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.iconSize;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.color;
    }

    public final String component3() {
        return this.customColor;
    }

    public final String component4() {
        return this.imageId;
    }

    public final boolean component5() {
        return this.isTranslateElement;
    }

    public final Integer component6() {
        return this.iconSize;
    }

    public final UDIconContentProps copy(String r100, String r110, String r111, String r112, boolean r113, Integer r114) {
        return new UDIconContentProps(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UDIconContentProps) == true) goto L8;
        return false;
    L8:
        UDIconContentProps r101 = (UDIconContentProps) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customColor, r101.customColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageId, r101.imageId) == true) goto L21;
        return false;
    L21:
        if (this.isTranslateElement == r101.isTranslateElement) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconSize, r101.iconSize) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.color;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.customColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imageId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.isTranslateElement == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        Integer r115 = this.iconSize;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
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
        return "UDIconContentProps(token=" + this.token + ", color=" + this.color + ", customColor=" + this.customColor + ", imageId=" + this.imageId + ", isTranslateElement=" + this.isTranslateElement + ", iconSize=" + this.iconSize + ')';
    }

    public final String getColor() {
        return this.color;
    }

    public final String getCustomColor() {
        return this.customColor;
    }

    public final Integer getIconSize() {
        return this.iconSize;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean isTranslateElement() {
        return this.isTranslateElement;
    }

    public UDIconContentProps(String r100, String r101, String r102, String r103, boolean r104, Integer r105) {
        this.token = r100;
        this.color = r101;
        this.customColor = r102;
        this.imageId = r103;
        this.isTranslateElement = r104;
        this.iconSize = r105;
    }

    public /* synthetic */ UDIconContentProps(String r100, String r101, String r102, String r103, boolean r104, Integer r110, int r111, DefaultConstructorMarker r112) {
        String r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r108 = false;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = 0;
    L25:
        this(r113, r106, r107, r105, r108, r110);
        return;
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
