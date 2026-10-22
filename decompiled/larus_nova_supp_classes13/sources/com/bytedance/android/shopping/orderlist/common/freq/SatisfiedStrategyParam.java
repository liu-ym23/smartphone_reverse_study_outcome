package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/SatisfiedStrategyParam;", "Ljava/io/Serializable;", "cacheData", "", "", "", "", "key", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActions;", "strategy", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "freqTime", "(Ljava/util/Map;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActions;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;J)V", "getCacheData", "()Ljava/util/Map;", "getFreqTime", "()J", "getKey", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActions;", "getStrategy", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SatisfiedStrategyParam implements Serializable {

    @SerializedName("cache_data")
    private final Map<String, List<Long>> cacheData;

    @SerializedName("freq_time")
    private final long freqTime;

    @SerializedName("key")
    private final FreqActions key;

    @SerializedName("strategy_item")
    private final FreqStrategy strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SatisfiedStrategyParam copy$default(SatisfiedStrategyParam r3, Map r4, FreqActions r5, FreqStrategy r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.cacheData;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.key;
    L8:
        FreqActions r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.strategy;
    L11:
        FreqStrategy r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.freqTime;
    L14:
        Map r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final Map<String, List<Long>> component1() {
        return this.cacheData;
    }

    public final FreqActions component2() {
        return this.key;
    }

    public final FreqStrategy component3() {
        return this.strategy;
    }

    public final long component4() {
        return this.freqTime;
    }

    public final SatisfiedStrategyParam copy(Map<String, List<Long>> r8, FreqActions r9, FreqStrategy r10, long r11) {
        Intrinsics.checkNotNullParameter(r9, "key");
        return new SatisfiedStrategyParam(r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof SatisfiedStrategyParam) == false) goto L14;
        SatisfiedStrategyParam r6 = (SatisfiedStrategyParam) r5;
        if (Intrinsics.areEqual(this.cacheData, r6.cacheData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r6.strategy) == true) goto L12;
        return false;
    L12:
        if (this.freqTime == r6.freqTime) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Map<String, List<Long>> r0 = this.cacheData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        FreqActions r4 = this.key;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        FreqStrategy r7 = this.strategy;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        long r9 = this.freqTime;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SatisfiedStrategyParam(cacheData=" + this.cacheData + ", key=" + this.key + ", strategy=" + this.strategy + ", freqTime=" + this.freqTime + ")";
    }

    public final Map<String, List<Long>> getCacheData() {
        return this.cacheData;
    }

    public final long getFreqTime() {
        return this.freqTime;
    }

    public final FreqActions getKey() {
        return this.key;
    }

    public final FreqStrategy getStrategy() {
        return this.strategy;
    }

    public SatisfiedStrategyParam(Map<String, List<Long>> r2, FreqActions r3, FreqStrategy r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        this.cacheData = r2;
        this.key = r3;
        this.strategy = r4;
        this.freqTime = r5;
    }

    public /* synthetic */ SatisfiedStrategyParam(Map r8, FreqActions r9, FreqStrategy r10, long r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        Map r2 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        FreqStrategy r4 = null;
    L10:
        this(r2, r9, r4, r11);
        return;
    L9:
        r4 = r10;
        goto L10
    L5:
        r2 = r8;
        goto L7
    }
}
