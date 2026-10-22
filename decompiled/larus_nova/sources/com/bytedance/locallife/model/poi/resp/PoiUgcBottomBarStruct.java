package com.bytedance.locallife.model.poi.resp;

import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcBottomBarStruct;", "Ljava/io/Serializable;", IconList.ELEM_NAME, "", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcBottomBarIconStruct;", "backgroundImageUrl", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "backgroundDarkImageUrl", "title", "", "hasUserRated", "", "(Ljava/util/List;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Z)V", "getBackgroundDarkImageUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getBackgroundImageUrl", "getHasUserRated", "()Z", "getIconList", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiUgcBottomBarStruct implements Serializable {

    @SerializedName("background_image_dark_theme_url")
    private final PoiImageUrlModel backgroundDarkImageUrl;

    @SerializedName("background_image_url")
    private final PoiImageUrlModel backgroundImageUrl;

    @SerializedName("has_user_rated")
    private final boolean hasUserRated;

    @SerializedName("icons")
    private final List<PoiUgcBottomBarIconStruct> iconList;

    @SerializedName("title")
    private final String title;

    public PoiUgcBottomBarStruct() {
        this(null, null, null, null, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiUgcBottomBarStruct copy$default(PoiUgcBottomBarStruct r100, List r101, PoiImageUrlModel r102, PoiImageUrlModel r103, String r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.iconList;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.backgroundImageUrl;
    L8:
        PoiImageUrlModel r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.backgroundDarkImageUrl;
    L11:
        PoiImageUrlModel r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.hasUserRated;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<PoiUgcBottomBarIconStruct> component1() {
        return this.iconList;
    }

    public final PoiImageUrlModel component2() {
        return this.backgroundImageUrl;
    }

    public final PoiImageUrlModel component3() {
        return this.backgroundDarkImageUrl;
    }

    public final String component4() {
        return this.title;
    }

    public final boolean component5() {
        return this.hasUserRated;
    }

    public final PoiUgcBottomBarStruct copy(List<PoiUgcBottomBarIconStruct> r100, PoiImageUrlModel r101, PoiImageUrlModel r110, String r111, boolean r112) {
        return new PoiUgcBottomBarStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcBottomBarStruct) == true) goto L8;
        return false;
    L8:
        PoiUgcBottomBarStruct r101 = (PoiUgcBottomBarStruct) r100;
        if (Intrinsics.areEqual(this.iconList, r101.iconList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundImageUrl, r101.backgroundImageUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundDarkImageUrl, r101.backgroundDarkImageUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (this.hasUserRated == r101.hasUserRated) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<PoiUgcBottomBarIconStruct> r100 = this.iconList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiImageUrlModel r104 = this.backgroundImageUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PoiImageUrlModel r107 = this.backgroundDarkImageUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.hasUserRated == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
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
        return "PoiUgcBottomBarStruct(iconList=" + this.iconList + ", backgroundImageUrl=" + this.backgroundImageUrl + ", backgroundDarkImageUrl=" + this.backgroundDarkImageUrl + ", title=" + this.title + ", hasUserRated=" + this.hasUserRated + ')';
    }

    public final PoiImageUrlModel getBackgroundDarkImageUrl() {
        return this.backgroundDarkImageUrl;
    }

    public final PoiImageUrlModel getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    public final boolean getHasUserRated() {
        return this.hasUserRated;
    }

    public final List<PoiUgcBottomBarIconStruct> getIconList() {
        return this.iconList;
    }

    public final String getTitle() {
        return this.title;
    }

    public PoiUgcBottomBarStruct(List<PoiUgcBottomBarIconStruct> r100, PoiImageUrlModel r101, PoiImageUrlModel r102, String r103, boolean r104) {
        this.iconList = r100;
        this.backgroundImageUrl = r101;
        this.backgroundDarkImageUrl = r102;
        this.title = r103;
        this.hasUserRated = r104;
    }

    public /* synthetic */ PoiUgcBottomBarStruct(List r100, PoiImageUrlModel r101, PoiImageUrlModel r102, String r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L5;
        List r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        PoiImageUrlModel r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        PoiImageUrlModel r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        boolean r109 = false;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
