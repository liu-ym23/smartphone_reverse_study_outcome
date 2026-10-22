package com.ss.android.ugc.aweme.trade.goods.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailPreloadStrategy;", "", "", "lruMaxSize", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "", "activities", "[Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()[Ljava/lang/String;", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailPreloadStrategy {

    @SerializedName("activities")
    private final String[] activities;

    @SerializedName("lru_max_size")
    private final Integer lruMaxSize;

    public GoodsDetailPreloadStrategy() {
        this.lruMaxSize = 1;
        this.activities = new String[0];
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GoodsDetailPreloadStrategy) == true) goto L8;
        return false;
    L8:
        GoodsDetailPreloadStrategy r101 = (GoodsDetailPreloadStrategy) r100;
        if (Intrinsics.areEqual(this.lruMaxSize, r101.lruMaxSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activities, r101.activities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.lruMaxSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.activities;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GoodsDetailPreloadStrategy(lruMaxSize=" + this.lruMaxSize + ", activities=" + Arrays.toString(this.activities) + ')';
    }

    public final String[] a() {
        return this.activities;
    }

    public final Integer b() {
        return this.lruMaxSize;
    }
}
