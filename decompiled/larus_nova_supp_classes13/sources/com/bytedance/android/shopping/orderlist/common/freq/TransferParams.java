package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/TransferParams;", "Ljava/io/Serializable;", "serverStore", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "freqLimitID", "", "strategy", "", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;Ljava/lang/String;Ljava/util/List;)V", "getFreqLimitID", "()Ljava/lang/String;", "getServerStore", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "getStrategy", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransferParams implements Serializable {

    @SerializedName("freq_limit_id")
    private final String freqLimitID;

    @SerializedName("freq_server_store")
    private final FreqStorage serverStore;

    @SerializedName("strategy")
    private final List<FreqStrategy> strategy;

    public TransferParams() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransferParams copy$default(TransferParams r0, FreqStorage r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.serverStore;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.freqLimitID;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.strategy;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final FreqStorage component1() {
        return this.serverStore;
    }

    public final String component2() {
        return this.freqLimitID;
    }

    public final List<FreqStrategy> component3() {
        return this.strategy;
    }

    public final TransferParams copy(FreqStorage r2, String r3, List<FreqStrategy> r4) {
        return new TransferParams(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TransferParams) == false) goto L12;
        TransferParams r4 = (TransferParams) r3;
        if (Intrinsics.areEqual(this.serverStore, r4.serverStore) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.freqLimitID, r4.freqLimitID) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r4.strategy) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        FreqStorage r0 = this.serverStore;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.freqLimitID;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<FreqStrategy> r7 = this.strategy;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TransferParams(serverStore=" + this.serverStore + ", freqLimitID=" + this.freqLimitID + ", strategy=" + this.strategy + ")";
    }

    public final String getFreqLimitID() {
        return this.freqLimitID;
    }

    public final FreqStorage getServerStore() {
        return this.serverStore;
    }

    public final List<FreqStrategy> getStrategy() {
        return this.strategy;
    }

    public TransferParams(FreqStorage r1, String r2, List<FreqStrategy> r3) {
        this.serverStore = r1;
        this.freqLimitID = r2;
        this.strategy = r3;
    }

    public /* synthetic */ TransferParams(FreqStorage r2, String r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
