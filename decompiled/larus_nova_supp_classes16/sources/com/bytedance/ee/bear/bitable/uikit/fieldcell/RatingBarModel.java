package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/RatingBarModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "rate", "", "maxRate", "minRate", "symbol", "", "<init>", "(Ljava/lang/Integer;IILjava/lang/String;)V", "getRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxRate", "()I", "getMinRate", "getSymbol", "()Ljava/lang/String;", "isEmptyValue", "", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;IILjava/lang/String;)Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/RatingBarModel;", "equals", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RatingBarModel implements h0, NonProguard {
    private final int maxRate;
    private final int minRate;
    private final Integer rate;
    private final String symbol;

    public static /* synthetic */ RatingBarModel copy$default(RatingBarModel r0, Integer r1, int r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.rate;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.maxRate;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.minRate;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.symbol;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.rate;
    }

    public final int component2() {
        return this.maxRate;
    }

    public final int component3() {
        return this.minRate;
    }

    public final String component4() {
        return this.symbol;
    }

    public final RatingBarModel copy(Integer r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "symbol");
        return new RatingBarModel(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RatingBarModel) == true) goto L8;
        return false;
    L8:
        RatingBarModel r6 = (RatingBarModel) r5;
        if (Intrinsics.areEqual(this.rate, r6.rate) == true) goto L12;
        return false;
    L12:
        if (this.maxRate == r6.maxRate) goto L15;
        return false;
    L15:
        if (this.minRate == r6.minRate) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.symbol, r6.symbol) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.rate;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((r1 * 31) + this.maxRate) * 31) + this.minRate) * 31) + this.symbol.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        return false;
    }

    public String toString() {
        return "RatingBarModel(rate=" + this.rate + ", maxRate=" + this.maxRate + ", minRate=" + this.minRate + ", symbol=" + this.symbol + ')';
    }

    public final int getMaxRate() {
        return this.maxRate;
    }

    public final int getMinRate() {
        return this.minRate;
    }

    public final Integer getRate() {
        return this.rate;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public RatingBarModel(Integer r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "symbol");
        this.rate = r2;
        this.maxRate = r3;
        this.minRate = r4;
        this.symbol = r5;
    }
}
