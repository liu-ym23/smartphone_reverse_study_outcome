package com.ss.android.ugc.aweme.trade.goods.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/TripGoodsDetailPreloadStrategy;", "", "", "", "schemes", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "schemasV2", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class TripGoodsDetailPreloadStrategy {

    @SerializedName("schemasV2")
    private final String[] schemasV2;

    @SerializedName("schemes")
    private final String[] schemes;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TripGoodsDetailPreloadStrategy) == true) goto L8;
        return false;
    L8:
        TripGoodsDetailPreloadStrategy r101 = (TripGoodsDetailPreloadStrategy) r100;
        if (Intrinsics.areEqual(this.schemes, r101.schemes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemasV2, r101.schemasV2) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String[] r100 = this.schemes;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.schemasV2;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public final String toString() {
        return "TripGoodsDetailPreloadStrategy(schemes=" + Arrays.toString(this.schemes) + ", schemasV2=" + Arrays.toString(this.schemasV2) + ')';
    }

    public TripGoodsDetailPreloadStrategy() {
        this.schemes = null;
        this.schemasV2 = null;
    }

    public final String[] a() {
        return this.schemasV2;
    }

    public final String[] b() {
        return this.schemes;
    }
}
