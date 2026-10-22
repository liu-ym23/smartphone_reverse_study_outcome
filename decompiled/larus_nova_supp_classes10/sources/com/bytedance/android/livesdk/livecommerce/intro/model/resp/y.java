package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/y;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a0;", "countDown", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a0;", "getCountDown", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/z;", "price", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/z;", "getPrice", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/z;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/x;", "animResources", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/x;", "getAnimResources", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/x;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("anim_resources")
    private final x animResources;

    @SerializedName("count_down")
    private final a0 countDown;

    @SerializedName("price")
    private final z price;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y) == false) goto L12;
        y r4 = (y) r3;
        if (Intrinsics.areEqual(this.countDown, r4.countDown) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.animResources, r4.animResources) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        a0 r0 = this.countDown;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        z r4 = this.price;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        x r7 = this.animResources;
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
        return "IntroOpenPriceAnimation(countDown=" + this.countDown + ", price=" + this.price + ", animResources=" + this.animResources + ")";
    }

    public y() {
        this.countDown = null;
        this.price = null;
        this.animResources = null;
    }
}
