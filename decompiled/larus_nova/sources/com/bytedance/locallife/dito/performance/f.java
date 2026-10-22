package com.bytedance.locallife.dito.performance;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/dito/performance/f;", "", "", "times", "J", "b", "()J", "d", "(J)V", "totalCost", "c", "e", "", "", "Lcom/bytedance/locallife/dito/performance/e;", "handlerTimingInfoStatMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("handler_timing")
    private final Map<String, e> handlerTimingInfoStatMap;

    @SerializedName("times")
    private long times;

    @SerializedName("total_cost")
    private long totalCost;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.times == r101.times) goto L12;
        return false;
    L12:
        if (this.totalCost == r101.totalCost) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.times;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.totalCost;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ActionTimingInfoStat(times=" + this.times + ", totalCost=" + this.totalCost + ')';
    }

    public final Map<String, e> a() {
        return this.handlerTimingInfoStatMap;
    }

    public final long b() {
        return this.times;
    }

    public final long c() {
        return this.totalCost;
    }

    public f(int r100) {
        this.times = 0;
        this.totalCost = 0;
        this.handlerTimingInfoStatMap = new LinkedHashMap();
    }

    public final void d(long r100) {
        this.times = r100;
    }

    public final void e(long r100) {
        this.totalCost = r100;
    }
}
