package com.bytedance.locallife.model.poi.resp;

import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcBottomBarIconStruct;", "Ljava/io/Serializable;", "type", "", "text", "", "iconImageUrl", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "jumpUrl", "(ILjava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;)V", "getIconImageUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getJumpUrl", "()Ljava/lang/String;", "getText", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiUgcBottomBarIconStruct implements Serializable {

    @SerializedName("icon_image_url")
    private final PoiImageUrlModel iconImageUrl;

    @SerializedName(ITiktokService.ResponseConstants.REDIRECT_URL)
    private final String jumpUrl;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final int type;

    public PoiUgcBottomBarIconStruct() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ PoiUgcBottomBarIconStruct copy$default(PoiUgcBottomBarIconStruct r100, int r101, String r102, PoiImageUrlModel r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.iconImageUrl;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.jumpUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final PoiImageUrlModel component3() {
        return this.iconImageUrl;
    }

    public final String component4() {
        return this.jumpUrl;
    }

    public final PoiUgcBottomBarIconStruct copy(int r100, String r101, PoiImageUrlModel r102, String r103) {
        return new PoiUgcBottomBarIconStruct(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcBottomBarIconStruct) == true) goto L8;
        return false;
    L8:
        PoiUgcBottomBarIconStruct r101 = (PoiUgcBottomBarIconStruct) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconImageUrl, r101.iconImageUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.text;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        PoiImageUrlModel r105 = this.iconImageUrl;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.jumpUrl;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiUgcBottomBarIconStruct(type=" + this.type + ", text=" + this.text + ", iconImageUrl=" + this.iconImageUrl + ", jumpUrl=" + this.jumpUrl + ')';
    }

    public final PoiImageUrlModel getIconImageUrl() {
        return this.iconImageUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public PoiUgcBottomBarIconStruct(int r100, String r101, PoiImageUrlModel r102, String r103) {
        this.type = r100;
        this.text = r101;
        this.iconImageUrl = r102;
        this.jumpUrl = r103;
    }

    public /* synthetic */ PoiUgcBottomBarIconStruct(int r100, String r101, PoiImageUrlModel r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
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
