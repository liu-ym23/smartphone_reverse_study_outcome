package com.bytedance.locallife.dito.common.view;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/dito/common/view/b;", "", "", "hasMore", "Z", "c", "()Z", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "preLoadTag", ce.f26391f, "", "preLoadCount", "I", "f", "()I", "poiLoadingMode", "d", "backgroundColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "poiSkinMode", "e", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("poi_loading_mode")
    private final int poiLoadingMode;

    @SerializedName("poi_skin_mode")
    private final int poiSkinMode;

    @SerializedName("trigger_preload_remain_count")
    private final int preLoadCount;

    @SerializedName("preload_target_node_tag")
    private final String preLoadTag;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.hasMore == r101.hasMore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.preLoadTag, r101.preLoadTag) == true) goto L18;
        return false;
    L18:
        if (this.preLoadCount == r101.preLoadCount) goto L21;
        return false;
    L21:
        if (this.poiLoadingMode == r101.poiLoadingMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L27;
        return false;
    L27:
        if (this.poiSkinMode == r101.poiSkinMode) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.hasMore == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.desc;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.preLoadTag;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((((r105 + r107) * 31) + this.preLoadCount) * 31) + this.poiLoadingMode) * 31;
        String r109 = this.backgroundColor;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return ((r108 + r103) * 31) + this.poiSkinMode;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DitoLoadMoreData(hasMore=" + this.hasMore + ", desc=" + this.desc + ", preLoadTag=" + this.preLoadTag + ", preLoadCount=" + this.preLoadCount + ", poiLoadingMode=" + this.poiLoadingMode + ", backgroundColor=" + this.backgroundColor + ", poiSkinMode=" + this.poiSkinMode + ')';
    }

    public b() {
        this.hasMore = true;
        this.desc = null;
        this.preLoadTag = null;
        this.preLoadCount = 0;
        this.poiLoadingMode = 0;
        this.backgroundColor = null;
        this.poiSkinMode = 0;
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final String b() {
        return this.desc;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final int d() {
        return this.poiLoadingMode;
    }

    public final int e() {
        return this.poiSkinMode;
    }

    public final int f() {
        return this.preLoadCount;
    }

    public final String g() {
        return this.preLoadTag;
    }
}
