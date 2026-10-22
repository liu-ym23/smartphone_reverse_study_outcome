package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/BannerTagStruct;", "Ljava/io/Serializable;", "text", "", "textColor", n.KEY_ICON_IMG, "Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "backgroundColor", "backgroundGradientColor", "Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundGradientColor", "()Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "getIconImg", "()Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "getText", "getTextColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerTagStruct implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("background_gradient_color")
    private final ECGradientStruct backgroundGradientColor;

    @SerializedName("icon_img")
    private final UrlStruct iconImg;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public BannerTagStruct() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BannerTagStruct copy$default(BannerTagStruct r100, String r101, String r102, UrlStruct r103, String r104, ECGradientStruct r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.iconImg;
    L11:
        UrlStruct r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.backgroundColor;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.backgroundGradientColor;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.textColor;
    }

    public final UrlStruct component3() {
        return this.iconImg;
    }

    public final String component4() {
        return this.backgroundColor;
    }

    public final ECGradientStruct component5() {
        return this.backgroundGradientColor;
    }

    public final BannerTagStruct copy(String r100, String r101, UrlStruct r110, String r111, ECGradientStruct r112) {
        return new BannerTagStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BannerTagStruct) == false) goto L16;
        BannerTagStruct r101 = (BannerTagStruct) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.iconImg, r101.iconImg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundGradientColor, r101.backgroundGradientColor) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        UrlStruct r107 = this.iconImg;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.backgroundColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECGradientStruct r113 = this.backgroundGradientColor;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "BannerTagStruct(text=" + this.text + ", textColor=" + this.textColor + ", iconImg=" + this.iconImg + ", backgroundColor=" + this.backgroundColor + ", backgroundGradientColor=" + this.backgroundGradientColor + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ECGradientStruct getBackgroundGradientColor() {
        return this.backgroundGradientColor;
    }

    public final UrlStruct getIconImg() {
        return this.iconImg;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public BannerTagStruct(String r100, String r101, UrlStruct r102, String r103, ECGradientStruct r104) {
        this.text = r100;
        this.textColor = r101;
        this.iconImg = r102;
        this.backgroundColor = r103;
        this.backgroundGradientColor = r104;
    }

    public /* synthetic */ BannerTagStruct(String r100, String r101, UrlStruct r102, String r103, ECGradientStruct r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        UrlStruct r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        ECGradientStruct r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
