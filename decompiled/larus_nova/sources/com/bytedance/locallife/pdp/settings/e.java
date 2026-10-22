package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/e;", "", "", "preloadGoodsDetail", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "", "schemes", "Ljava/util/List;", "b", "()Ljava/util/List;", "v2Schemas", "c", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("preload_goods_detail")
    private final Boolean preloadGoodsDetail;

    @SerializedName("schemes")
    private final List<String> schemes;

    @SerializedName("v2Schemas")
    private final List<String> v2Schemas;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.preloadGoodsDetail, r101.preloadGoodsDetail) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemes, r101.schemes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.v2Schemas, r101.v2Schemas) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.preloadGoodsDetail;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.schemes;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.v2Schemas;
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

    public final String toString() {
        return "ComprehensiveLynxPreload(preloadGoodsDetail=" + this.preloadGoodsDetail + ", schemes=" + this.schemes + ", v2Schemas=" + this.v2Schemas + ')';
    }

    public e() {
        this.preloadGoodsDetail = null;
        this.schemes = null;
        this.v2Schemas = null;
    }

    public final Boolean a() {
        return this.preloadGoodsDetail;
    }

    public final List<String> b() {
        return this.schemes;
    }

    public final List<String> c() {
        return this.v2Schemas;
    }
}
