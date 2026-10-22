package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/BtmPositionResult;", "", "btm", "", "extra", "", "bcm", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;)V", "getBcm", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "setBcm", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;)V", "getBtm", "()Ljava/lang/String;", "setBtm", "(Ljava/lang/String;)V", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BtmPositionResult {
    private Bcm bcm;
    private String btm;
    private Map<String, ? extends Object> extra;

    public BtmPositionResult() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BtmPositionResult copy$default(BtmPositionResult r0, String r1, Map r2, Bcm r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.btm;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.extra;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.bcm;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.btm;
    }

    public final Map<String, Object> component2() {
        return this.extra;
    }

    public final Bcm component3() {
        return this.bcm;
    }

    public final BtmPositionResult copy(String r2, Map<String, ? extends Object> r3, Bcm r4) {
        return new BtmPositionResult(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BtmPositionResult) == false) goto L12;
        BtmPositionResult r4 = (BtmPositionResult) r3;
        if (Intrinsics.areEqual(this.btm, r4.btm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bcm, r4.bcm) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.btm;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, ? extends Object> r4 = this.extra;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Bcm r7 = this.bcm;
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
        return "BtmPositionResult(btm=" + this.btm + ", extra=" + this.extra + ", bcm=" + this.bcm + ")";
    }

    public final Bcm getBcm() {
        return this.bcm;
    }

    public final String getBtm() {
        return this.btm;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setBcm(Bcm r1) {
        this.bcm = r1;
    }

    public final void setBtm(String r1) {
        this.btm = r1;
    }

    public final void setExtra(Map<String, ? extends Object> r1) {
        this.extra = r1;
    }

    public BtmPositionResult(String r1, Map<String, ? extends Object> r2, Bcm r3) {
        this.btm = r1;
        this.extra = r2;
        this.bcm = r3;
    }

    public /* synthetic */ BtmPositionResult(String r2, Map r3, Bcm r4, int r5, DefaultConstructorMarker r6) {
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
