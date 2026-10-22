package com.bytedance.ies.bullet.deprecate.fake;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/deprecate/fake/ContainerBidParam;", "", "bid", "", "(Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ContainerBidParam {
    private final String bid;

    public static /* synthetic */ ContainerBidParam copy$default(ContainerBidParam r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.bid;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.bid;
    }

    public final ContainerBidParam copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        return new ContainerBidParam(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContainerBidParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.bid, ((ContainerBidParam) r100).bid) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.bid.hashCode();
    }

    public String toString() {
        return "ContainerBidParam(bid=" + this.bid + ')';
    }

    public final String getBid() {
        return this.bid;
    }

    public ContainerBidParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.bid = r100;
    }
}
