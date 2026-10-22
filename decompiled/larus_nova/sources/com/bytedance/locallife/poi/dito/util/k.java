package com.bytedance.locallife.poi.dito.util;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/poi/dito/util/k;", "", "", "", "fullViewList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "halfViewList", "b", "", "lazyTime", "J", "c", "()J", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
final class k {

    @SerializedName("full_lazy_view_list")
    private final List<String> fullViewList;

    @SerializedName("half_lazy_view_list")
    private final List<String> halfViewList;

    @SerializedName("lazy_max_time")
    private final long lazyTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.fullViewList, r101.fullViewList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.halfViewList, r101.halfViewList) == true) goto L15;
        return false;
    L15:
        if (this.lazyTime == r101.lazyTime) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.fullViewList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.halfViewList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        long r106 = this.lazyTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiViewLazyLoadConfig(fullViewList=" + this.fullViewList + ", halfViewList=" + this.halfViewList + ", lazyTime=" + this.lazyTime + ')';
    }

    public k() {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        this.fullViewList = r100;
        this.halfViewList = r101;
        this.lazyTime = 3000;
    }

    public final List<String> a() {
        return this.fullViewList;
    }

    public final List<String> b() {
        return this.halfViewList;
    }

    public final long c() {
        return this.lazyTime;
    }
}
