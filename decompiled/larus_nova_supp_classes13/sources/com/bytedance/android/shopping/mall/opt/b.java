package com.bytedance.android.shopping.mall.opt;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/b;", "", "", "count", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "dispersed", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "dispersedInterval", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "offset", "d", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("count")
    private final Integer count;

    @SerializedName("dispersed")
    private final Boolean dispersed;

    @SerializedName("dispersed_interval")
    private final Long dispersedInterval;

    @SerializedName("offset")
    private final Integer offset;

    public b() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.count, r4.count) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dispersed, r4.dispersed) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dispersedInterval, r4.dispersedInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offset, r4.offset) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.count;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.dispersed;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.dispersedInterval;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.offset;
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

    public final String toString() {
        return "ECMallFeedPreBindOnLoadMoreSuccessPageConfig(count=" + this.count + ", dispersed=" + this.dispersed + ", dispersedInterval=" + this.dispersedInterval + ", offset=" + this.offset + ")";
    }

    public final Integer a() {
        return this.count;
    }

    public final Boolean b() {
        return this.dispersed;
    }

    public final Long c() {
        return this.dispersedInterval;
    }

    public final Integer d() {
        return this.offset;
    }

    public b(Integer r1, Boolean r2, Long r3, Integer r4) {
        this.count = r1;
        this.dispersed = r2;
        this.dispersedInterval = r3;
        this.offset = r4;
    }
}
