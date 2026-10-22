package uc3;

import com.bytedance.android.shopping.deepfeed.data.api.CouponData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Luc3/c;", "", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", "data", "Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", "a", "()Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    private final CouponData data;

    @SerializedName("msg")
    private final String msg;

    public c() {
        this.code = -1;
        this.msg = "";
        this.data = null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.code, r4.code) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r4.msg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.code;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.msg;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        CouponData r7 = this.data;
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

    public final String toString() {
        return "DeepFeedCouponStatus(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public final CouponData a() {
        return this.data;
    }
}
