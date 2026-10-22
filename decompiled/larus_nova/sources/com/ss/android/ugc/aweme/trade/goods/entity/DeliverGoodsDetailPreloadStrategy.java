package com.ss.android.ugc.aweme.trade.goods.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/DeliverGoodsDetailPreloadStrategy;", "", "", "preGoodsDetail", "Z", "getPreGoodsDetail", "()Z", "withinGoodsDetail", "getWithinGoodsDetail", "", "", "schemes", "[Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()[Ljava/lang/String;", "preSchemes", "getPreSchemes", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class DeliverGoodsDetailPreloadStrategy {

    @SerializedName("pre_goods_detail")
    private final boolean preGoodsDetail;

    @SerializedName("pre_schemes")
    private final String[] preSchemes;

    @SerializedName("schemes")
    private final String[] schemes;

    @SerializedName("within_goods_detail")
    private final boolean withinGoodsDetail;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeliverGoodsDetailPreloadStrategy) == true) goto L8;
        return false;
    L8:
        DeliverGoodsDetailPreloadStrategy r101 = (DeliverGoodsDetailPreloadStrategy) r100;
        if (this.preGoodsDetail == r101.preGoodsDetail) goto L12;
        return false;
    L12:
        if (this.withinGoodsDetail == r101.withinGoodsDetail) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schemes, r101.schemes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preSchemes, r101.preSchemes) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.preGoodsDetail == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.withinGoodsDetail == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String[] r104 = this.schemes;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        String[] r108 = this.preSchemes;
        if (r108 == null) goto L19;
        r105 = Arrays.hashCode(r108);
    L19:
        return r107 + r105;
    L13:
        r106 = Arrays.hashCode(r104);
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeliverGoodsDetailPreloadStrategy(preGoodsDetail=" + this.preGoodsDetail + ", withinGoodsDetail=" + this.withinGoodsDetail + ", schemes=" + Arrays.toString(this.schemes) + ", preSchemes=" + Arrays.toString(this.preSchemes) + ')';
    }

    public DeliverGoodsDetailPreloadStrategy() {
        this.preGoodsDetail = false;
        this.withinGoodsDetail = false;
        this.schemes = null;
        this.preSchemes = null;
    }

    public final String[] a() {
        return this.schemes;
    }
}
