package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/k;", "", "", "dividerLineDesc", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "coiDisplayAB", "I", "getCoiDisplayAB", "()I", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("coi_display_strategy")
    private final int coiDisplayAB;

    @SerializedName("divide_line_desc")
    private final String dividerLineDesc;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.dividerLineDesc, r101.dividerLineDesc) == true) goto L12;
        return false;
    L12:
        if (this.coiDisplayAB == r101.coiDisplayAB) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.dividerLineDesc.hashCode() * 31) + this.coiDisplayAB;
    }

    public final String toString() {
        return "PoiCoiHeaderData(dividerLineDesc=" + this.dividerLineDesc + ", coiDisplayAB=" + this.coiDisplayAB + ')';
    }

    public final String a() {
        return this.dividerLineDesc;
    }
}
