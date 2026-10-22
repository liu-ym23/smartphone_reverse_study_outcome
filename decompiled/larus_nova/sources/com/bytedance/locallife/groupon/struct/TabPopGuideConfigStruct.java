package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/TabPopGuideConfigStruct;", "Ljava/io/Serializable;", "id", "", "scene", "", "targetImgUrl", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "ArrowImgUrl", "(Ljava/lang/String;ILcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "getArrowImgUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getId", "()Ljava/lang/String;", "getScene", "()I", "getTargetImgUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TabPopGuideConfigStruct implements Serializable {

    @SerializedName("arrow_img_url")
    private final UrlModel ArrowImgUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f258840id;

    @SerializedName("scene")
    private final int scene;

    @SerializedName("target_img_url")
    private final UrlModel targetImgUrl;

    public TabPopGuideConfigStruct() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ TabPopGuideConfigStruct copy$default(TabPopGuideConfigStruct r100, String r101, int r102, UrlModel r103, UrlModel r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f258840id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.scene;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.targetImgUrl;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ArrowImgUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f258840id;
    }

    public final int component2() {
        return this.scene;
    }

    public final UrlModel component3() {
        return this.targetImgUrl;
    }

    public final UrlModel component4() {
        return this.ArrowImgUrl;
    }

    public final TabPopGuideConfigStruct copy(String r100, int r101, UrlModel r102, UrlModel r103) {
        return new TabPopGuideConfigStruct(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabPopGuideConfigStruct) == true) goto L8;
        return false;
    L8:
        TabPopGuideConfigStruct r101 = (TabPopGuideConfigStruct) r100;
        if (Intrinsics.areEqual(this.f258840id, r101.f258840id) == true) goto L12;
        return false;
    L12:
        if (this.scene == r101.scene) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetImgUrl, r101.targetImgUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ArrowImgUrl, r101.ArrowImgUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.f258840id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.scene) * 31;
        UrlModel r104 = this.targetImgUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UrlModel r107 = this.ArrowImgUrl;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TabPopGuideConfigStruct(id=" + this.f258840id + ", scene=" + this.scene + ", targetImgUrl=" + this.targetImgUrl + ", ArrowImgUrl=" + this.ArrowImgUrl + ')';
    }

    public final UrlModel getArrowImgUrl() {
        return this.ArrowImgUrl;
    }

    public final String getId() {
        return this.f258840id;
    }

    public final int getScene() {
        return this.scene;
    }

    public final UrlModel getTargetImgUrl() {
        return this.targetImgUrl;
    }

    public TabPopGuideConfigStruct(String r100, int r101, UrlModel r102, UrlModel r103) {
        this.f258840id = r100;
        this.scene = r101;
        this.targetImgUrl = r102;
        this.ArrowImgUrl = r103;
    }

    public /* synthetic */ TabPopGuideConfigStruct(String r100, int r101, UrlModel r102, UrlModel r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = -1;
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
