package com.ss.android.ugc.aweme.trade.goods.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/trade/goods/entity/GoodsDetailLynxTimingReportConfig;", "", "", "", "nodeWhiteList", "[Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()[Ljava/lang/String;", "", "samplingRate", "I", "b", "()I", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailLynxTimingReportConfig {

    @SerializedName("node_white_list")
    private final String[] nodeWhiteList;

    @SerializedName("samplingRate")
    private final int samplingRate;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GoodsDetailLynxTimingReportConfig) == true) goto L8;
        return false;
    L8:
        GoodsDetailLynxTimingReportConfig r101 = (GoodsDetailLynxTimingReportConfig) r100;
        if (Intrinsics.areEqual(this.nodeWhiteList, r101.nodeWhiteList) == true) goto L12;
        return false;
    L12:
        if (this.samplingRate == r101.samplingRate) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String[] r100 = this.nodeWhiteList;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.samplingRate;
    L5:
        r101 = Arrays.hashCode(r100);
        goto L7
    }

    public final String toString() {
        return "GoodsDetailLynxTimingReportConfig(nodeWhiteList=" + Arrays.toString(this.nodeWhiteList) + ", samplingRate=" + this.samplingRate + ')';
    }

    public GoodsDetailLynxTimingReportConfig() {
        this.nodeWhiteList = null;
        this.samplingRate = 0;
    }

    public final String[] a() {
        return this.nodeWhiteList;
    }

    public final int b() {
        return this.samplingRate;
    }
}
