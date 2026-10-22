package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "", "", "priceType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "showPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m;", "countDown", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n0;", "showText", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n0;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "breathingLightPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "getBreathingLightPrice", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroPrice {

    @SerializedName("breathing_light_price")
    private final j breathingLightPrice;

    @SerializedName("count_down")
    private final m countDown;

    @SerializedName("price_type")
    private final Integer priceType;

    @SerializedName("show_price")
    private final m0 showPrice;

    @SerializedName("show_text")
    private final n0 showText;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice$Companion$IntroPriceType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroPriceType {
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof IntroPrice) == false) goto L16;
        IntroPrice r4 = (IntroPrice) r3;
        if (Intrinsics.areEqual(this.priceType, r4.priceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showPrice, r4.showPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.countDown, r4.countDown) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showText, r4.showText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.breathingLightPrice, r4.breathingLightPrice) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.priceType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        m0 r4 = this.showPrice;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        m r7 = this.countDown;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        n0 r10 = this.showText;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        j r13 = this.breathingLightPrice;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
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
        return "IntroPrice(priceType=" + this.priceType + ", showPrice=" + this.showPrice + ", countDown=" + this.countDown + ", showText=" + this.showText + ", breathingLightPrice=" + this.breathingLightPrice + ")";
    }

    public IntroPrice() {
        this.priceType = null;
        this.showPrice = null;
        this.countDown = null;
        this.showText = null;
        this.breathingLightPrice = null;
    }

    public final m a() {
        return this.countDown;
    }

    public final Integer b() {
        return this.priceType;
    }

    public final m0 c() {
        return this.showPrice;
    }

    public final n0 d() {
        return this.showText;
    }
}
