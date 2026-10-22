package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/ProduceFreq;", "Ljava/io/Serializable;", "id", "", "action", "strategy", "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "maxStoreNum", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getAction", "()Ljava/lang/String;", "getId", "getMaxStoreNum", "()I", "getStrategy", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProduceFreq implements Serializable {

    @SerializedName("action")
    private final String action;

    @SerializedName("id")
    private final String id;

    @SerializedName("max_store_num")
    private final int maxStoreNum;

    @SerializedName("strategy")
    private final List<FreqStrategy> strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProduceFreq copy$default(ProduceFreq r0, String r1, String r2, List r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.action;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.strategy;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.maxStoreNum;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.action;
    }

    public final List<FreqStrategy> component3() {
        return this.strategy;
    }

    public final int component4() {
        return this.maxStoreNum;
    }

    public final ProduceFreq copy(String r2, String r3, List<FreqStrategy> r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        return new ProduceFreq(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProduceFreq) == false) goto L14;
        ProduceFreq r4 = (ProduceFreq) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r4.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r4.strategy) == true) goto L12;
        return false;
    L12:
        if (this.maxStoreNum == r4.maxStoreNum) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.action;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<FreqStrategy> r7 = this.strategy;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + this.maxStoreNum;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ProduceFreq(id=" + this.id + ", action=" + this.action + ", strategy=" + this.strategy + ", maxStoreNum=" + this.maxStoreNum + ")";
    }

    public final String getAction() {
        return this.action;
    }

    public final String getId() {
        return this.id;
    }

    public final int getMaxStoreNum() {
        return this.maxStoreNum;
    }

    public final List<FreqStrategy> getStrategy() {
        return this.strategy;
    }

    public ProduceFreq(String r2, String r3, List<FreqStrategy> r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        this.id = r2;
        this.action = r3;
        this.strategy = r4;
        this.maxStoreNum = r5;
    }

    public /* synthetic */ ProduceFreq(String r2, String r3, List r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 100;
    L11:
        this(r2, r3, r4, r5);
    }
}
