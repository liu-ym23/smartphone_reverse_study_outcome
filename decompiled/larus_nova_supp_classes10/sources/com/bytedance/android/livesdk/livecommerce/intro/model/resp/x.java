package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/x;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "countDownBg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCountDownBg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "openPriceBg", "getOpenPriceBg", "priceConfetti", "getPriceConfetti", "buyButtonFlash", "getBuyButtonFlash", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("buy_button_flash")
    private final ECUrlModel buyButtonFlash;

    @SerializedName("count_down_bg")
    private final ECUrlModel countDownBg;

    @SerializedName("open_price_bg")
    private final ECUrlModel openPriceBg;

    @SerializedName("price_confetti")
    private final ECUrlModel priceConfetti;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof x) == false) goto L14;
        x r4 = (x) r3;
        if (Intrinsics.areEqual(this.countDownBg, r4.countDownBg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.openPriceBg, r4.openPriceBg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceConfetti, r4.priceConfetti) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buyButtonFlash, r4.buyButtonFlash) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.countDownBg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.openPriceBg;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.priceConfetti;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.buyButtonFlash;
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
        return "IntroOpenPriceAnimResources(countDownBg=" + this.countDownBg + ", openPriceBg=" + this.openPriceBg + ", priceConfetti=" + this.priceConfetti + ", buyButtonFlash=" + this.buyButtonFlash + ")";
    }

    public x() {
        this.countDownBg = null;
        this.openPriceBg = null;
        this.priceConfetti = null;
        this.buyButtonFlash = null;
    }
}
