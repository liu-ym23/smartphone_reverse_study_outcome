package com.larus.platform.model.mainbot;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/mainbot/ECommerceProductCardPreloadConfig;", "", "productCardPreloadGroup", "", "productCardPreloadThrottleInterval", "", "productCardPreloadMaxCardCount", "<init>", "(IDI)V", "getProductCardPreloadGroup", "()I", "getProductCardPreloadThrottleInterval", "()D", "getProductCardPreloadMaxCardCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECommerceProductCardPreloadConfig {

    @SerializedName("product_card_preload_group")
    private final int productCardPreloadGroup;

    @SerializedName("product_card_preload_max_card_count")
    private final int productCardPreloadMaxCardCount;

    @SerializedName("product_card_preload_throttle_interval")
    private final double productCardPreloadThrottleInterval;

    public ECommerceProductCardPreloadConfig() {
        this(0, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, null);
    }

    public static /* synthetic */ ECommerceProductCardPreloadConfig copy$default(ECommerceProductCardPreloadConfig r100, int r101, double r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.productCardPreloadGroup;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.productCardPreloadThrottleInterval;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.productCardPreloadMaxCardCount;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.productCardPreloadGroup;
    }

    public final double component2() {
        return this.productCardPreloadThrottleInterval;
    }

    public final int component3() {
        return this.productCardPreloadMaxCardCount;
    }

    public final ECommerceProductCardPreloadConfig copy(int r100, double r101, int r102) {
        return new ECommerceProductCardPreloadConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ECommerceProductCardPreloadConfig) == true) goto L8;
        return false;
    L8:
        ECommerceProductCardPreloadConfig r101 = (ECommerceProductCardPreloadConfig) r100;
        if (this.productCardPreloadGroup == r101.productCardPreloadGroup) goto L12;
        return false;
    L12:
        if (Double.compare(this.productCardPreloadThrottleInterval, r101.productCardPreloadThrottleInterval) == 0) goto L15;
        return false;
    L15:
        if (this.productCardPreloadMaxCardCount == r101.productCardPreloadMaxCardCount) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.productCardPreloadGroup * 31;
        long r101 = Double.doubleToLongBits(this.productCardPreloadThrottleInterval);
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.productCardPreloadMaxCardCount;
    }

    public String toString() {
        return "ECommerceProductCardPreloadConfig(productCardPreloadGroup=" + this.productCardPreloadGroup + ", productCardPreloadThrottleInterval=" + this.productCardPreloadThrottleInterval + ", productCardPreloadMaxCardCount=" + this.productCardPreloadMaxCardCount + ')';
    }

    public final int getProductCardPreloadGroup() {
        return this.productCardPreloadGroup;
    }

    public final int getProductCardPreloadMaxCardCount() {
        return this.productCardPreloadMaxCardCount;
    }

    public final double getProductCardPreloadThrottleInterval() {
        return this.productCardPreloadThrottleInterval;
    }

    public ECommerceProductCardPreloadConfig(int r100, double r101, int r102) {
        this.productCardPreloadGroup = r100;
        this.productCardPreloadThrottleInterval = r101;
        this.productCardPreloadMaxCardCount = r102;
    }

    public /* synthetic */ ECommerceProductCardPreloadConfig(int r100, double r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 60.0d;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 5;
    L11:
        this(r100, r101, r102);
    }
}
