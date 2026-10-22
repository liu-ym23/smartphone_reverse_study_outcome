package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/BtmInfo;", "", "c", "", "d", "w", "btmInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;)V", "getBtmInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "setBtmInfo", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;)V", "getC", "()Ljava/lang/String;", "setC", "(Ljava/lang/String;)V", "getD", "setD", "getW", "setW", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BtmInfo {
    private BtmData btmInfo;
    private String c;
    private String d;
    private String w;

    public BtmInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ BtmInfo copy$default(BtmInfo r0, String r1, String r2, String r3, BtmData r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.c;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.d;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.w;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.btmInfo;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.c;
    }

    public final String component2() {
        return this.d;
    }

    public final String component3() {
        return this.w;
    }

    public final BtmData component4() {
        return this.btmInfo;
    }

    public final BtmInfo copy(String r2, String r3, String r4, BtmData r5) {
        return new BtmInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BtmInfo) == false) goto L14;
        BtmInfo r4 = (BtmInfo) r3;
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.w, r4.w) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmInfo, r4.btmInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.d;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.w;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        BtmData r10 = this.btmInfo;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "BtmInfo(c=" + this.c + ", d=" + this.d + ", w=" + this.w + ", btmInfo=" + this.btmInfo + ")";
    }

    public final BtmData getBtmInfo() {
        return this.btmInfo;
    }

    public final String getC() {
        return this.c;
    }

    public final String getD() {
        return this.d;
    }

    public final String getW() {
        return this.w;
    }

    public final void setBtmInfo(BtmData r1) {
        this.btmInfo = r1;
    }

    public final void setC(String r1) {
        this.c = r1;
    }

    public final void setD(String r1) {
        this.d = r1;
    }

    public final void setW(String r1) {
        this.w = r1;
    }

    public BtmInfo(String r1, String r2, String r3, BtmData r4) {
        this.c = r1;
        this.d = r2;
        this.w = r3;
        this.btmInfo = r4;
    }

    public /* synthetic */ BtmInfo(String r2, String r3, String r4, BtmData r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
