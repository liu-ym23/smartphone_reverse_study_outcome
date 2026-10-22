package com.bytedance.android.shopping.order.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "Ljava/io/Serializable;", "amount", "", "couponName", "", "threshold", "useRange", "endTime", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAmount", "()J", "getCouponName", "()Ljava/lang/String;", "getEndTime", "getThreshold", "getUseRange", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponInfo implements Serializable {

    @SerializedName("amount")
    private final long amount;

    @SerializedName("coupon_name")
    private final String couponName;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("threshold")
    private final String threshold;

    @SerializedName("use_range")
    private final String useRange;

    public CouponInfo() {
        this(0, null, null, null, 0, 31, null);
    }

    public final long getAmount() {
        return this.amount;
    }

    public final String getCouponName() {
        return this.couponName;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getThreshold() {
        return this.threshold;
    }

    public final String getUseRange() {
        return this.useRange;
    }

    public CouponInfo(long r1, String r3, String r4, String r5, long r6) {
        this.amount = r1;
        this.couponName = r3;
        this.threshold = r4;
        this.useRange = r5;
        this.endTime = r6;
    }

    public /* synthetic */ CouponInfo(long r7, String r9, String r10, String r11, long r12, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        long r2 = 0;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r16 = "";
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r14 & 16) == 0) goto L21;
        long r13 = 0;
    L22:
        this(r2, r16, r4, r5, r13);
        return;
    L21:
        r13 = r12;
        goto L22
    L17:
        r5 = r11;
        goto L19
    L13:
        r4 = r10;
        goto L15
    L9:
        r16 = r9;
        goto L11
    L5:
        r2 = r7;
        goto L7
    }
}
