package uc3;

import com.bytedance.android.shopping.deepfeed.data.api.CouponData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Luc3/c;", "", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", "data", "Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.code;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.msg;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CouponData r107 = this.data;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCouponStatus(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public final CouponData a() {
        return this.data;
    }
}
