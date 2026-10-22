package com.bytedance.android.shopping.orderlist.common.freq;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/JudgeStrategyResult;", "Ljava/io/Serializable;", "key", "", "value", "Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JudgeStrategyResult implements Serializable {
    private final String key;
    private final SingleFreqCache value;

    public static /* synthetic */ JudgeStrategyResult copy$default(JudgeStrategyResult r0, String r1, SingleFreqCache r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.value;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.key;
    }

    public final SingleFreqCache component2() {
        return this.value;
    }

    public final JudgeStrategyResult copy(String r2, SingleFreqCache r3) {
        return new JudgeStrategyResult(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof JudgeStrategyResult) == false) goto L10;
        JudgeStrategyResult r4 = (JudgeStrategyResult) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.value, r4.value) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        SingleFreqCache r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "JudgeStrategyResult(key=" + this.key + ", value=" + this.value + ")";
    }

    public final String getKey() {
        return this.key;
    }

    public final SingleFreqCache getValue() {
        return this.value;
    }

    public JudgeStrategyResult(String r1, SingleFreqCache r2) {
        this.key = r1;
        this.value = r2;
    }
}
