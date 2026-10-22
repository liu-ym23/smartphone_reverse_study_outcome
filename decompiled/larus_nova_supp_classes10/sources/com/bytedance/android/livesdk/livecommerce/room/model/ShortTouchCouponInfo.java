package com.bytedance.android.livesdk.livecommerce.room.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/ShortTouchCouponInfo;", "Ljava/io/Serializable;", "", "applyType", "I", "getApplyType", "()I", "<init>", "(I)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchCouponInfo implements Serializable {
    public static final a Companion = null;
    public static final int NOT_NEED_AUTO_APPLY_COUPON = 1;

    @SerializedName("ecom_list_apply_type")
    private final int applyType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShortTouchCouponInfo() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final int getApplyType() {
        return this.applyType;
    }

    public ShortTouchCouponInfo(int r1) {
        this.applyType = r1;
    }

    public /* synthetic */ ShortTouchCouponInfo(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 1;
    L5:
        this(r1);
    }
}
