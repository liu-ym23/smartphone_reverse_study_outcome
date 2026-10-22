package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/k;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/m;", "poiItemExtStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/m;", "setPoiItemExtStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/m;)V", "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/l;", "indirectPoiInfos", "Ljava/util/List;", "getIndirectPoiInfos", "()Ljava/util/List;", "setIndirectPoiInfos", "(Ljava/util/List;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class k {

    @SerializedName("indirect_poi_list")
    private List<l> indirectPoiInfos;

    @SerializedName("item_ext")
    private m poiItemExtStruct;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.poiItemExtStruct, r101.poiItemExtStruct) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.indirectPoiInfos, r101.indirectPoiInfos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        m r100 = this.poiItemExtStruct;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<l> r104 = this.indirectPoiInfos;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiExtJsonStruct(poiItemExtStruct=" + this.poiItemExtStruct + ", indirectPoiInfos=" + this.indirectPoiInfos + ')';
    }

    public k() {
        this.poiItemExtStruct = null;
        this.indirectPoiInfos = null;
    }

    public final m a() {
        return this.poiItemExtStruct;
    }
}
