package com.bytedance.android.shopping.order.dto;

import cg3.b;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/MotivateInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "toCommentOrder", "Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "getToCommentOrder", "()Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "", "ret", "J", "getRet", "()J", "typ", "getTyp", "amount", "getAmount", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "type", "getType", "rulePage", "getRulePage", "Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "additionalCouponInfo", "Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "getAdditionalCouponInfo", "()Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "couponInfo", "getCouponInfo", "Lcg3/b;", "action", "Lcg3/b;", "getAction", "()Lcg3/b;", "<init>", "(Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;JJJLjava/lang/String;JLjava/lang/String;Lcom/bytedance/android/shopping/order/dto/CouponInfo;Lcom/bytedance/android/shopping/order/dto/CouponInfo;Lcg3/b;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MotivateInfo implements Serializable {

    @SerializedName("action")
    private final b action;

    @SerializedName("additional_coupon_info")
    private final CouponInfo additionalCouponInfo;

    @SerializedName("amount")
    private final long amount;

    @SerializedName("coupon_info")
    private final CouponInfo couponInfo;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("ret")
    private final long ret;

    @SerializedName("rule_page")
    private final String rulePage;

    @SerializedName("to_comment_order")
    private final ToCommentOrder toCommentOrder;

    @SerializedName("typ")
    private final long typ;

    @SerializedName("type")
    private final long type;

    public MotivateInfo() {
        this(null, 0, 0, 0, null, 0, null, null, null, null, 1023, null);
    }

    public final b getAction() {
        return this.action;
    }

    public final CouponInfo getAdditionalCouponInfo() {
        return this.additionalCouponInfo;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final long getRet() {
        return this.ret;
    }

    public final String getRulePage() {
        return this.rulePage;
    }

    public final ToCommentOrder getToCommentOrder() {
        return this.toCommentOrder;
    }

    public final long getTyp() {
        return this.typ;
    }

    public final long getType() {
        return this.type;
    }

    public MotivateInfo(ToCommentOrder r1, long r2, long r4, long r6, String r8, long r9, String r11, CouponInfo r12, CouponInfo r13, b r14) {
        this.toCommentOrder = r1;
        this.ret = r2;
        this.typ = r4;
        this.amount = r6;
        this.desc = r8;
        this.type = r9;
        this.rulePage = r11;
        this.additionalCouponInfo = r12;
        this.couponInfo = r13;
        this.action = r14;
    }

    public /* synthetic */ MotivateInfo(ToCommentOrder r16, long r17, long r19, long r21, String r23, long r24, String r26, CouponInfo r27, CouponInfo r28, b r29, int r30, DefaultConstructorMarker r31) {
        b r2 = null;
        if ((r30 & 1) == 0) goto L5;
        ToCommentOrder r1 = null;
    L6:
        long r4 = 0;
        if ((r30 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r10 = 0;
    L18:
        String r12 = "";
        if ((r30 & 16) == 0) goto L21;
        String r3 = "";
    L23:
        if ((r30 & 32) != 0) goto L27;
        r4 = r24;
    L27:
        if ((r30 & 64) != 0) goto L31;
        r12 = r26;
    L31:
        if ((r30 & 128) == 0) goto L33;
        CouponInfo r13 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        CouponInfo r14 = null;
    L39:
        if ((r30 & 512) != 0) goto L42;
        r2 = r29;
    L42:
        this(r1, r6, r8, r10, r3, r4, r12, r13, r14, r2);
        return;
    L37:
        r14 = r28;
        goto L39
    L33:
        r13 = r27;
        goto L35
    L21:
        r3 = r23;
        goto L23
    L17:
        r10 = r21;
        goto L18
    L13:
        r8 = r19;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L6
    }
}
