package com.bytedance.helios.api.consumer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/helios/api/consumer/OperatePairs;", "", "originKey", "", "originValue", "changedKey", "changedValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChangedKey", "()Ljava/lang/String;", "getChangedValue", "getOriginKey", "getOriginValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 1, 16})
public final class OperatePairs {
    private final String changedKey;
    private final String changedValue;
    private final String originKey;
    private final String originValue;

    public OperatePairs() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OperatePairs copy$default(OperatePairs r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.originKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.originValue;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.changedKey;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.changedValue;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.originKey;
    }

    public final String component2() {
        return this.originValue;
    }

    public final String component3() {
        return this.changedKey;
    }

    public final String component4() {
        return this.changedValue;
    }

    public final OperatePairs copy(String r100, String r101, String r102, String r103) {
        return new OperatePairs(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OperatePairs) == false) goto L14;
        OperatePairs r101 = (OperatePairs) r100;
        if (Intrinsics.areEqual(this.originKey, r101.originKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originValue, r101.originValue) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.changedKey, r101.changedKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.changedValue, r101.changedValue) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.originKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.originValue;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.changedKey;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.changedValue;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "OperatePairs(originKey=" + this.originKey + ", originValue=" + this.originValue + ", changedKey=" + this.changedKey + ", changedValue=" + this.changedValue + ")";
    }

    public final String getChangedKey() {
        return this.changedKey;
    }

    public final String getChangedValue() {
        return this.changedValue;
    }

    public final String getOriginKey() {
        return this.originKey;
    }

    public final String getOriginValue() {
        return this.originValue;
    }

    public OperatePairs(String r100, String r101, String r102, String r103) {
        this.originKey = r100;
        this.originValue = r101;
        this.changedKey = r102;
        this.changedValue = r103;
    }

    public /* synthetic */ OperatePairs(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
