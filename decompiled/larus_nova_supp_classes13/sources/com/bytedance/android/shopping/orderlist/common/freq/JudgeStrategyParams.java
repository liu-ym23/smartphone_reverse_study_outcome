package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/JudgeStrategyParams;", "Ljava/io/Serializable;", "singleFreqCache", "Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "id", "", "strategy", "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "freqTime", "", "(Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;Ljava/lang/String;Ljava/util/List;J)V", "getFreqTime", "()J", "getId", "()Ljava/lang/String;", "getSingleFreqCache", "()Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "getStrategy", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JudgeStrategyParams implements Serializable {

    @SerializedName("freq_time")
    private final long freqTime;

    @SerializedName("id")
    private final String id;

    @SerializedName("single_cache")
    private final SingleFreqCache singleFreqCache;

    @SerializedName("strategy")
    private final List<FreqStrategy> strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JudgeStrategyParams copy$default(JudgeStrategyParams r3, SingleFreqCache r4, String r5, List r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.singleFreqCache;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.id;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.strategy;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.freqTime;
    L14:
        SingleFreqCache r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final SingleFreqCache component1() {
        return this.singleFreqCache;
    }

    public final String component2() {
        return this.id;
    }

    public final List<FreqStrategy> component3() {
        return this.strategy;
    }

    public final long component4() {
        return this.freqTime;
    }

    public final JudgeStrategyParams copy(SingleFreqCache r8, String r9, List<FreqStrategy> r10, long r11) {
        return new JudgeStrategyParams(r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof JudgeStrategyParams) == false) goto L14;
        JudgeStrategyParams r6 = (JudgeStrategyParams) r5;
        if (Intrinsics.areEqual(this.singleFreqCache, r6.singleFreqCache) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L10;
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
        SingleFreqCache r0 = this.singleFreqCache;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<FreqStrategy> r7 = this.strategy;
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
        return "JudgeStrategyParams(singleFreqCache=" + this.singleFreqCache + ", id=" + this.id + ", strategy=" + this.strategy + ", freqTime=" + this.freqTime + ")";
    }

    public final long getFreqTime() {
        return this.freqTime;
    }

    public final String getId() {
        return this.id;
    }

    public final SingleFreqCache getSingleFreqCache() {
        return this.singleFreqCache;
    }

    public final List<FreqStrategy> getStrategy() {
        return this.strategy;
    }

    public JudgeStrategyParams(SingleFreqCache r1, String r2, List<FreqStrategy> r3, long r4) {
        this.singleFreqCache = r1;
        this.id = r2;
        this.strategy = r3;
        this.freqTime = r4;
    }

    public /* synthetic */ JudgeStrategyParams(SingleFreqCache r8, String r9, List r10, long r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        SingleFreqCache r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        List r4 = null;
    L14:
        this(r2, r3, r4, r11);
        return;
    L13:
        r4 = r10;
        goto L14
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
