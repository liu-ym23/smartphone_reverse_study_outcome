package com.ss.android.ugc.aweme.poi.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/AutoScrollConfig;", "", "", "highDelayTime", "J", "b", "()J", "mediumDelayTime", "d", "lowDelayTime", "c", "defaultDelayTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class AutoScrollConfig {

    @SerializedName("default_delay_time")
    private final long defaultDelayTime;

    @SerializedName("high_delay_time")
    private final long highDelayTime;

    @SerializedName("low_delay_time")
    private final long lowDelayTime;

    @SerializedName("medium_delay_time")
    private final long mediumDelayTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoScrollConfig) == true) goto L8;
        return false;
    L8:
        AutoScrollConfig r101 = (AutoScrollConfig) r100;
        if (this.highDelayTime == r101.highDelayTime) goto L12;
        return false;
    L12:
        if (this.mediumDelayTime == r101.mediumDelayTime) goto L15;
        return false;
    L15:
        if (this.lowDelayTime == r101.lowDelayTime) goto L18;
        return false;
    L18:
        if (this.defaultDelayTime == r101.defaultDelayTime) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.highDelayTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.mediumDelayTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.lowDelayTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.defaultDelayTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "AutoScrollConfig(highDelayTime=" + this.highDelayTime + ", mediumDelayTime=" + this.mediumDelayTime + ", lowDelayTime=" + this.lowDelayTime + ", defaultDelayTime=" + this.defaultDelayTime + ')';
    }

    public AutoScrollConfig() {
        this.highDelayTime = 500;
        this.mediumDelayTime = 700;
        this.lowDelayTime = 900;
        this.defaultDelayTime = 700;
    }

    public final long a() {
        return this.defaultDelayTime;
    }

    public final long b() {
        return this.highDelayTime;
    }

    public final long c() {
        return this.lowDelayTime;
    }

    public final long d() {
        return this.mediumDelayTime;
    }
}
