package com.bytedance.android.shopping.ligo.container.event;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;", "Ljava/io/Serializable;", "target", "", "addCartStartTime", "", "addCartSuccessTime", "productInfo", "Lcom/bytedance/android/shopping/ligo/container/event/AddCartProductInfoData;", "(Ljava/lang/String;JJLcom/bytedance/android/shopping/ligo/container/event/AddCartProductInfoData;)V", "getAddCartStartTime", "()J", "getAddCartSuccessTime", "getProductInfo", "()Lcom/bytedance/android/shopping/ligo/container/event/AddCartProductInfoData;", "getTarget", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddCartExtraData implements Serializable {

    @SerializedName("operation_start_time")
    private final long addCartStartTime;

    @SerializedName("cart_add_end_time")
    private final long addCartSuccessTime;

    @SerializedName("product_info")
    private final AddCartProductInfoData productInfo;

    @SerializedName("target")
    private final String target;

    public static /* synthetic */ AddCartExtraData copy$default(AddCartExtraData r4, String r5, long r6, long r8, AddCartProductInfoData r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.target;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.addCartStartTime;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.addCartSuccessTime;
    L11:
        long r2 = r8;
        if ((r11 & 8) == 0) goto L14;
        r10 = r4.productInfo;
    L14:
        String r7 = r5;
        return r4.copy(r7, r0, r2, r10);
    }

    public final String component1() {
        return this.target;
    }

    public final long component2() {
        return this.addCartStartTime;
    }

    public final long component3() {
        return this.addCartSuccessTime;
    }

    public final AddCartProductInfoData component4() {
        return this.productInfo;
    }

    public final AddCartExtraData copy(String r9, long r10, long r12, AddCartProductInfoData r14) {
        return new AddCartExtraData(r9, r10, r12, r14);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof AddCartExtraData) == false) goto L14;
        AddCartExtraData r7 = (AddCartExtraData) r6;
        if (Intrinsics.areEqual(this.target, r7.target) == true) goto L8;
        return false;
    L8:
        if (this.addCartStartTime == r7.addCartStartTime) goto L10;
        return false;
    L10:
        if (this.addCartSuccessTime == r7.addCartSuccessTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productInfo, r7.productInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.target;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.addCartStartTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.addCartSuccessTime;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        AddCartProductInfoData r7 = this.productInfo;
        if (r7 == null) goto L10;
        r1 = r7.hashCode();
    L10:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AddCartExtraData(target=" + this.target + ", addCartStartTime=" + this.addCartStartTime + ", addCartSuccessTime=" + this.addCartSuccessTime + ", productInfo=" + this.productInfo + ")";
    }

    public final long getAddCartStartTime() {
        return this.addCartStartTime;
    }

    public final long getAddCartSuccessTime() {
        return this.addCartSuccessTime;
    }

    public final AddCartProductInfoData getProductInfo() {
        return this.productInfo;
    }

    public final String getTarget() {
        return this.target;
    }

    public AddCartExtraData(String r1, long r2, long r4, AddCartProductInfoData r6) {
        this.target = r1;
        this.addCartStartTime = r2;
        this.addCartSuccessTime = r4;
        this.productInfo = r6;
    }
}
