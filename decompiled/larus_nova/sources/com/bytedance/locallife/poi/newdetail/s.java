package com.bytedance.locallife.poi.newdetail;

import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/s;", "", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "moduleTitleIcon", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getModuleTitleIcon", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "", "descFontSize", "I", "getDescFontSize", "()I", "", "impressionSelectedBackgroundColor", "Ljava/lang/String;", "getImpressionSelectedBackgroundColor", "()Ljava/lang/String;", "foldedButtonBackgroundColor", "getFoldedButtonBackgroundColor", "ugcBottomBarBorderColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "moreIconUrl", "getMoreIconUrl", "likeIconFace", "getLikeIconFace", "likeIconFinger", "getLikeIconFinger", "likeLottieFace", "getLikeLottieFace", "likeLottieFinger", "getLikeLottieFinger", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("desc_font_size")
    private final int descFontSize;

    @SerializedName("folded_button_background_color")
    private final String foldedButtonBackgroundColor;

    @SerializedName("impression_selected_background_color")
    private final String impressionSelectedBackgroundColor;

    @SerializedName("like_icon_face")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final PoiImageUrlModel likeIconFace;

    @SerializedName("like_icon_finger")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final PoiImageUrlModel likeIconFinger;

    @SerializedName("like_lottie_face")
    private final String likeLottieFace;

    @SerializedName("like_lottie_finger")
    private final String likeLottieFinger;

    @SerializedName("module_title_icon")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final PoiImageUrlModel moduleTitleIcon;

    @SerializedName("more_icon_url")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final PoiImageUrlModel moreIconUrl;

    @SerializedName("ugc_bottom_bar_border_color")
    private final String ugcBottomBarBorderColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.moduleTitleIcon, r101.moduleTitleIcon) == true) goto L12;
        return false;
    L12:
        if (this.descFontSize == r101.descFontSize) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.impressionSelectedBackgroundColor, r101.impressionSelectedBackgroundColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.foldedButtonBackgroundColor, r101.foldedButtonBackgroundColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ugcBottomBarBorderColor, r101.ugcBottomBarBorderColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.moreIconUrl, r101.moreIconUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.likeIconFace, r101.likeIconFace) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.likeIconFinger, r101.likeIconFinger) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.likeLottieFace, r101.likeLottieFace) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.likeLottieFinger, r101.likeLottieFinger) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        PoiImageUrlModel r100 = this.moduleTitleIcon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.descFontSize) * 31;
        String r104 = this.impressionSelectedBackgroundColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.foldedButtonBackgroundColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.ugcBottomBarBorderColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PoiImageUrlModel r113 = this.moreIconUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PoiImageUrlModel r116 = this.likeIconFace;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        PoiImageUrlModel r119 = this.likeIconFinger;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.likeLottieFace;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.likeLottieFinger;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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

    public final String toString() {
        return "UgcModuleSkinConfig(moduleTitleIcon=" + this.moduleTitleIcon + ", descFontSize=" + this.descFontSize + ", impressionSelectedBackgroundColor=" + this.impressionSelectedBackgroundColor + ", foldedButtonBackgroundColor=" + this.foldedButtonBackgroundColor + ", ugcBottomBarBorderColor=" + this.ugcBottomBarBorderColor + ", moreIconUrl=" + this.moreIconUrl + ", likeIconFace=" + this.likeIconFace + ", likeIconFinger=" + this.likeIconFinger + ", likeLottieFace=" + this.likeLottieFace + ", likeLottieFinger=" + this.likeLottieFinger + ')';
    }

    public s() {
        this.moduleTitleIcon = null;
        this.descFontSize = 0;
        this.impressionSelectedBackgroundColor = "";
        this.foldedButtonBackgroundColor = "";
        this.ugcBottomBarBorderColor = "";
        this.moreIconUrl = null;
        this.likeIconFace = null;
        this.likeIconFinger = null;
        this.likeLottieFace = "";
        this.likeLottieFinger = "";
    }

    public final String a() {
        return this.ugcBottomBarBorderColor;
    }
}
