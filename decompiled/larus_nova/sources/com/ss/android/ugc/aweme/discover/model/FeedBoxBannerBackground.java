package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerBackground;", "Ljava/io/Serializable;", "singleBackgroundImg", "Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "doubleBackgroundImg", "backgroundColor", "", "backgroundGradientColor", "Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "(Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundGradientColor", "()Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "getDoubleBackgroundImg", "()Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "getSingleBackgroundImg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedBoxBannerBackground implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("background_gradient_color")
    private final ECGradientStruct backgroundGradientColor;

    @SerializedName("double_background_img")
    private final UrlStruct doubleBackgroundImg;

    @SerializedName("single_background_img")
    private final UrlStruct singleBackgroundImg;

    public FeedBoxBannerBackground() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FeedBoxBannerBackground copy$default(FeedBoxBannerBackground r100, UrlStruct r101, UrlStruct r102, String r103, ECGradientStruct r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.singleBackgroundImg;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.doubleBackgroundImg;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.backgroundColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.backgroundGradientColor;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final UrlStruct component1() {
        return this.singleBackgroundImg;
    }

    public final UrlStruct component2() {
        return this.doubleBackgroundImg;
    }

    public final String component3() {
        return this.backgroundColor;
    }

    public final ECGradientStruct component4() {
        return this.backgroundGradientColor;
    }

    public final FeedBoxBannerBackground copy(UrlStruct r100, UrlStruct r101, String r102, ECGradientStruct r103) {
        return new FeedBoxBannerBackground(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FeedBoxBannerBackground) == false) goto L14;
        FeedBoxBannerBackground r101 = (FeedBoxBannerBackground) r100;
        if (Intrinsics.areEqual(this.singleBackgroundImg, r101.singleBackgroundImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.doubleBackgroundImg, r101.doubleBackgroundImg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundGradientColor, r101.backgroundGradientColor) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        UrlStruct r100 = this.singleBackgroundImg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UrlStruct r104 = this.doubleBackgroundImg;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.backgroundColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECGradientStruct r110 = this.backgroundGradientColor;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "FeedBoxBannerBackground(singleBackgroundImg=" + this.singleBackgroundImg + ", doubleBackgroundImg=" + this.doubleBackgroundImg + ", backgroundColor=" + this.backgroundColor + ", backgroundGradientColor=" + this.backgroundGradientColor + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ECGradientStruct getBackgroundGradientColor() {
        return this.backgroundGradientColor;
    }

    public final UrlStruct getDoubleBackgroundImg() {
        return this.doubleBackgroundImg;
    }

    public final UrlStruct getSingleBackgroundImg() {
        return this.singleBackgroundImg;
    }

    public FeedBoxBannerBackground(UrlStruct r100, UrlStruct r101, String r102, ECGradientStruct r103) {
        this.singleBackgroundImg = r100;
        this.doubleBackgroundImg = r101;
        this.backgroundColor = r102;
        this.backgroundGradientColor = r103;
    }

    public /* synthetic */ FeedBoxBannerBackground(UrlStruct r100, UrlStruct r101, String r102, ECGradientStruct r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
