package com.larus.common.location.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00061"}, d2 = {"Lcom/larus/common/location/impl/settings/FlowLocationConfig;", "", "coldLaunchUpdateCount", "", "hotLaunchUpdateCount", "launchUpdateCacheIntervalSeconds", "vuiAwakeUpdateCacheIntervalSeconds", "pollingStartIntervalSeconds", "pollingEndIntervalSeconds", "pollingReduceFrequencyCount", "pollingReduceFrequencyStartIntervalSeconds", "pollingReduceFrequencyEndIntervalSeconds", "doraGPollingIntervalSeconds", "doraGTriggerIntervalSeconds", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getColdLaunchUpdateCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHotLaunchUpdateCount", "getLaunchUpdateCacheIntervalSeconds", "getVuiAwakeUpdateCacheIntervalSeconds", "getPollingStartIntervalSeconds", "getPollingEndIntervalSeconds", "getPollingReduceFrequencyCount", "getPollingReduceFrequencyStartIntervalSeconds", "getPollingReduceFrequencyEndIntervalSeconds", "getDoraGPollingIntervalSeconds", "getDoraGTriggerIntervalSeconds", "isValid", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/common/location/impl/settings/FlowLocationConfig;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("cold_update_count")
    private final Integer coldLaunchUpdateCount;

    @SerializedName("dora_g_polling_interval")
    private final Integer doraGPollingIntervalSeconds;

    @SerializedName("dora_g_trigger_interval")
    private final Integer doraGTriggerIntervalSeconds;

    @SerializedName("hot_update_count")
    private final Integer hotLaunchUpdateCount;

    @SerializedName("update_cache_interval")
    private final Integer launchUpdateCacheIntervalSeconds;

    @SerializedName("polling_end_interval")
    private final Integer pollingEndIntervalSeconds;

    @SerializedName("polling_reduce_frequency_count")
    private final Integer pollingReduceFrequencyCount;

    @SerializedName("polling_reduce_frequency_end_interval")
    private final Integer pollingReduceFrequencyEndIntervalSeconds;

    @SerializedName("polling_reduce_frequency_start_interval")
    private final Integer pollingReduceFrequencyStartIntervalSeconds;

    @SerializedName("polling_start_interval")
    private final Integer pollingStartIntervalSeconds;

    @SerializedName("awaken_update_cache_interval")
    private final Integer vuiAwakeUpdateCacheIntervalSeconds;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.coldLaunchUpdateCount, r101.coldLaunchUpdateCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hotLaunchUpdateCount, r101.hotLaunchUpdateCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.launchUpdateCacheIntervalSeconds, r101.launchUpdateCacheIntervalSeconds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.vuiAwakeUpdateCacheIntervalSeconds, r101.vuiAwakeUpdateCacheIntervalSeconds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pollingStartIntervalSeconds, r101.pollingStartIntervalSeconds) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pollingEndIntervalSeconds, r101.pollingEndIntervalSeconds) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pollingReduceFrequencyCount, r101.pollingReduceFrequencyCount) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pollingReduceFrequencyStartIntervalSeconds, r101.pollingReduceFrequencyStartIntervalSeconds) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.pollingReduceFrequencyEndIntervalSeconds, r101.pollingReduceFrequencyEndIntervalSeconds) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.doraGPollingIntervalSeconds, r101.doraGPollingIntervalSeconds) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.doraGTriggerIntervalSeconds, r101.doraGTriggerIntervalSeconds) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.coldLaunchUpdateCount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.hotLaunchUpdateCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.launchUpdateCacheIntervalSeconds;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.vuiAwakeUpdateCacheIntervalSeconds;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.pollingStartIntervalSeconds;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.pollingEndIntervalSeconds;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.pollingReduceFrequencyCount;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.pollingReduceFrequencyStartIntervalSeconds;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.pollingReduceFrequencyEndIntervalSeconds;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.doraGPollingIntervalSeconds;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.doraGTriggerIntervalSeconds;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLocationConfig(coldLaunchUpdateCount=" + this.coldLaunchUpdateCount + ", hotLaunchUpdateCount=" + this.hotLaunchUpdateCount + ", launchUpdateCacheIntervalSeconds=" + this.launchUpdateCacheIntervalSeconds + ", vuiAwakeUpdateCacheIntervalSeconds=" + this.vuiAwakeUpdateCacheIntervalSeconds + ", pollingStartIntervalSeconds=" + this.pollingStartIntervalSeconds + ", pollingEndIntervalSeconds=" + this.pollingEndIntervalSeconds + ", pollingReduceFrequencyCount=" + this.pollingReduceFrequencyCount + ", pollingReduceFrequencyStartIntervalSeconds=" + this.pollingReduceFrequencyStartIntervalSeconds + ", pollingReduceFrequencyEndIntervalSeconds=" + this.pollingReduceFrequencyEndIntervalSeconds + ", doraGPollingIntervalSeconds=" + this.doraGPollingIntervalSeconds + ", doraGTriggerIntervalSeconds=" + this.doraGTriggerIntervalSeconds + ')';
    }

    public final boolean l() {
        if (this.coldLaunchUpdateCount != null) goto L5;
    L21:
        return false;
    L5:
        if (this.hotLaunchUpdateCount == null) goto L21;
        if (this.pollingStartIntervalSeconds == null) goto L21;
        if (this.pollingEndIntervalSeconds == null) goto L21;
        if (this.pollingReduceFrequencyCount == null) goto L21;
        if (this.pollingReduceFrequencyStartIntervalSeconds == null) goto L21;
        if (this.pollingReduceFrequencyEndIntervalSeconds == null) goto L21;
        if (this.launchUpdateCacheIntervalSeconds == null) goto L21;
        if (this.vuiAwakeUpdateCacheIntervalSeconds == null) goto L21;
        return true;
    }

    public final Integer a() {
        return this.coldLaunchUpdateCount;
    }

    public final Integer b() {
        return this.doraGPollingIntervalSeconds;
    }

    public final Integer c() {
        return this.doraGTriggerIntervalSeconds;
    }

    public final Integer d() {
        return this.hotLaunchUpdateCount;
    }

    public final Integer e() {
        return this.launchUpdateCacheIntervalSeconds;
    }

    public final Integer f() {
        return this.pollingEndIntervalSeconds;
    }

    public final Integer g() {
        return this.pollingReduceFrequencyCount;
    }

    public final Integer h() {
        return this.pollingReduceFrequencyEndIntervalSeconds;
    }

    public final Integer i() {
        return this.pollingReduceFrequencyStartIntervalSeconds;
    }

    public final Integer j() {
        return this.pollingStartIntervalSeconds;
    }

    public final Integer k() {
        return this.vuiAwakeUpdateCacheIntervalSeconds;
    }

    public a(int r110) {
        this.coldLaunchUpdateCount = 0;
        this.hotLaunchUpdateCount = 0;
        this.launchUpdateCacheIntervalSeconds = 600;
        this.vuiAwakeUpdateCacheIntervalSeconds = 60;
        this.pollingStartIntervalSeconds = 600;
        this.pollingEndIntervalSeconds = 900;
        this.pollingReduceFrequencyCount = 1000;
        this.pollingReduceFrequencyStartIntervalSeconds = 600;
        this.pollingReduceFrequencyEndIntervalSeconds = 900;
        this.doraGPollingIntervalSeconds = 180;
        this.doraGTriggerIntervalSeconds = 30;
    }
}
