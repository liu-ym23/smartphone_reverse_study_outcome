package com.bytedance.locallife.dito.performance;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/dito/performance/e;", "", "", "count", "J", "b", "()J", "d", "(J)V", ChameleonOpenTracker.ParamKey.COST, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    private long cost;

    @SerializedName("count")
    private long count;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.count == r101.count) goto L12;
        return false;
    L12:
        if (this.cost == r101.cost) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.count;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.cost;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ActionHandlerTimingInfoStat(count=" + this.count + ", cost=" + this.cost + ')';
    }

    public final long a() {
        return this.cost;
    }

    public final long b() {
        return this.count;
    }

    public e(int r100) {
        this.count = 0;
        this.cost = 0;
    }

    public final void c(long r100) {
        this.cost = r100;
    }

    public final void d(long r100) {
        this.count = r100;
    }
}
