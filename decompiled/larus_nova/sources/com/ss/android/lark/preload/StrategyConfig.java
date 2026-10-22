package com.ss.android.lark.preload;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "preload_strategy_config")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/preload/StrategyConfig;", "", "bizFrequencyDisableValue", "", "hitRateDisableValue", "<init>", "(DD)V", "getBizFrequencyDisableValue", "()D", "getHitRateDisableValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StrategyConfig {

    @SerializedName("biz_frequency_disable_value")
    private final double bizFrequencyDisableValue;

    @SerializedName("hit_rate_disable_value")
    private final double hitRateDisableValue;

    public StrategyConfig() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }

    public static /* synthetic */ StrategyConfig copy$default(StrategyConfig r100, double r101, double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bizFrequencyDisableValue;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hitRateDisableValue;
    L9:
        return r100.copy(r101, r102);
    }

    public final double component1() {
        return this.bizFrequencyDisableValue;
    }

    public final double component2() {
        return this.hitRateDisableValue;
    }

    public final StrategyConfig copy(double r100, double r101) {
        return new StrategyConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StrategyConfig) == true) goto L8;
        return false;
    L8:
        StrategyConfig r101 = (StrategyConfig) r100;
        if (Double.compare(this.bizFrequencyDisableValue, r101.bizFrequencyDisableValue) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.hitRateDisableValue, r101.hitRateDisableValue) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.bizFrequencyDisableValue);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.hitRateDisableValue);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "StrategyConfig(bizFrequencyDisableValue=" + this.bizFrequencyDisableValue + ", hitRateDisableValue=" + this.hitRateDisableValue + ')';
    }

    public final double getBizFrequencyDisableValue() {
        return this.bizFrequencyDisableValue;
    }

    public final double getHitRateDisableValue() {
        return this.hitRateDisableValue;
    }

    public StrategyConfig(double r100, double r101) {
        this.bizFrequencyDisableValue = r100;
        this.hitRateDisableValue = r101;
    }

    public /* synthetic */ StrategyConfig(double r100, double r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -1.0d;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = -1.0d;
    L8:
        this(r100, r101);
    }
}
