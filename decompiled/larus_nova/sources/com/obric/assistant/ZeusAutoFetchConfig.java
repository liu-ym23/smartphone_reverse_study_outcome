package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006*"}, d2 = {"Lcom/obric/assistant/ZeusAutoFetchConfig;", "", "useNetworkIntercept", "", "autoFetchTimeIntervalMillis", "", "fetchTimeThrottleMillis", "enableSubProcessWakeMain", "subProcessWakeMainIntervalMillis", "subProcessMainSuccessRequestExpireIntervalMillis", "dex2oatBootGuardMillis", "subProcessWakeMainMinCheckDelayMillis", "subProcessWakeMainMaxCheckDelayMillis", "<init>", "(ZJJZJJJJJ)V", "getUseNetworkIntercept", "()Z", "getAutoFetchTimeIntervalMillis", "()J", "getFetchTimeThrottleMillis", "getEnableSubProcessWakeMain", "getSubProcessWakeMainIntervalMillis", "getSubProcessMainSuccessRequestExpireIntervalMillis", "getDex2oatBootGuardMillis", "getSubProcessWakeMainMinCheckDelayMillis", "getSubProcessWakeMainMaxCheckDelayMillis", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusAutoFetchConfig {

    @SerializedName("auto_fetch_time_interval_millis")
    private final long autoFetchTimeIntervalMillis;

    @SerializedName("dex2oat_boot_guard_millis")
    private final long dex2oatBootGuardMillis;

    @SerializedName("enable_sub_process_wake_main")
    private final boolean enableSubProcessWakeMain;

    @SerializedName("fetch_time_throttle_millis")
    private final long fetchTimeThrottleMillis;

    @SerializedName("sub_process_main_success_request_expire_interval_millis")
    private final long subProcessMainSuccessRequestExpireIntervalMillis;

    @SerializedName("sub_process_wake_main_interval_millis")
    private final long subProcessWakeMainIntervalMillis;

    @SerializedName("sub_process_wake_main_max_check_delay_millis")
    private final long subProcessWakeMainMaxCheckDelayMillis;

    @SerializedName("sub_process_wake_main_min_check_delay_millis")
    private final long subProcessWakeMainMinCheckDelayMillis;

    @SerializedName("use_network_intercept")
    private final boolean useNetworkIntercept;

    public ZeusAutoFetchConfig() {
        this(false, 0, 0, false, 0, 0, 0, 0, 0, 511, null);
    }

    public static /* synthetic */ ZeusAutoFetchConfig copy$default(ZeusAutoFetchConfig r110, boolean r111, long r112, long r210, boolean r211, long r212, long r213, long r214, long r215, long r310, int r311, Object r312) {
        if ((r311 & 1) == 0) goto L5;
        boolean r100 = r110.useNetworkIntercept;
    L7:
        if ((r311 & 2) == 0) goto L9;
        long r101 = r110.autoFetchTimeIntervalMillis;
    L11:
        if ((r311 & 4) == 0) goto L13;
        long r102 = r110.fetchTimeThrottleMillis;
    L15:
        if ((r311 & 8) == 0) goto L17;
        boolean r103 = r110.enableSubProcessWakeMain;
    L19:
        if ((r311 & 16) == 0) goto L21;
        long r104 = r110.subProcessWakeMainIntervalMillis;
    L23:
        if ((r311 & 32) == 0) goto L25;
        long r113 = r110.subProcessMainSuccessRequestExpireIntervalMillis;
    L27:
        if ((r311 & 64) == 0) goto L29;
        long r114 = r110.dex2oatBootGuardMillis;
    L31:
        if ((r311 & 128) == 0) goto L33;
        long r115 = r110.subProcessWakeMainMinCheckDelayMillis;
    L34:
        long r216 = r115;
        if ((r311 & 256) == 0) goto L37;
        long r116 = r110.subProcessWakeMainMaxCheckDelayMillis;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r216, r116);
    L37:
        r116 = r310;
        goto L39
    L33:
        r115 = r215;
        goto L34
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.useNetworkIntercept;
    }

    public final long component2() {
        return this.autoFetchTimeIntervalMillis;
    }

    public final long component3() {
        return this.fetchTimeThrottleMillis;
    }

    public final boolean component4() {
        return this.enableSubProcessWakeMain;
    }

    public final long component5() {
        return this.subProcessWakeMainIntervalMillis;
    }

    public final long component6() {
        return this.subProcessMainSuccessRequestExpireIntervalMillis;
    }

    public final long component7() {
        return this.dex2oatBootGuardMillis;
    }

    public final long component8() {
        return this.subProcessWakeMainMinCheckDelayMillis;
    }

    public final long component9() {
        return this.subProcessWakeMainMaxCheckDelayMillis;
    }

    public final ZeusAutoFetchConfig copy(boolean r110, long r210, long r211, boolean r212, long r213, long r214, long r215, long r310, long r311) {
        return new ZeusAutoFetchConfig(r110, r210, r211, r212, r213, r214, r215, r310, r311);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZeusAutoFetchConfig) == true) goto L8;
        return false;
    L8:
        ZeusAutoFetchConfig r101 = (ZeusAutoFetchConfig) r100;
        if (this.useNetworkIntercept == r101.useNetworkIntercept) goto L12;
        return false;
    L12:
        if (this.autoFetchTimeIntervalMillis == r101.autoFetchTimeIntervalMillis) goto L15;
        return false;
    L15:
        if (this.fetchTimeThrottleMillis == r101.fetchTimeThrottleMillis) goto L18;
        return false;
    L18:
        if (this.enableSubProcessWakeMain == r101.enableSubProcessWakeMain) goto L21;
        return false;
    L21:
        if (this.subProcessWakeMainIntervalMillis == r101.subProcessWakeMainIntervalMillis) goto L24;
        return false;
    L24:
        if (this.subProcessMainSuccessRequestExpireIntervalMillis == r101.subProcessMainSuccessRequestExpireIntervalMillis) goto L27;
        return false;
    L27:
        if (this.dex2oatBootGuardMillis == r101.dex2oatBootGuardMillis) goto L30;
        return false;
    L30:
        if (this.subProcessWakeMainMinCheckDelayMillis == r101.subProcessWakeMainMinCheckDelayMillis) goto L33;
        return false;
    L33:
        if (this.subProcessWakeMainMaxCheckDelayMillis == r101.subProcessWakeMainMaxCheckDelayMillis) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.useNetworkIntercept == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.autoFetchTimeIntervalMillis;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.fetchTimeThrottleMillis;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.enableSubProcessWakeMain == true) goto L10;
        r100 = 1237;
    L10:
        int r106 = (r105 + r100) * 31;
        long r107 = this.subProcessWakeMainIntervalMillis;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.subProcessMainSuccessRequestExpireIntervalMillis;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.dex2oatBootGuardMillis;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.subProcessWakeMainMinCheckDelayMillis;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.subProcessWakeMainMaxCheckDelayMillis;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ZeusAutoFetchConfig(useNetworkIntercept=" + this.useNetworkIntercept + ", autoFetchTimeIntervalMillis=" + this.autoFetchTimeIntervalMillis + ", fetchTimeThrottleMillis=" + this.fetchTimeThrottleMillis + ", enableSubProcessWakeMain=" + this.enableSubProcessWakeMain + ", subProcessWakeMainIntervalMillis=" + this.subProcessWakeMainIntervalMillis + ", subProcessMainSuccessRequestExpireIntervalMillis=" + this.subProcessMainSuccessRequestExpireIntervalMillis + ", dex2oatBootGuardMillis=" + this.dex2oatBootGuardMillis + ", subProcessWakeMainMinCheckDelayMillis=" + this.subProcessWakeMainMinCheckDelayMillis + ", subProcessWakeMainMaxCheckDelayMillis=" + this.subProcessWakeMainMaxCheckDelayMillis + ')';
    }

    public final long getAutoFetchTimeIntervalMillis() {
        return this.autoFetchTimeIntervalMillis;
    }

    public final long getDex2oatBootGuardMillis() {
        return this.dex2oatBootGuardMillis;
    }

    public final boolean getEnableSubProcessWakeMain() {
        return this.enableSubProcessWakeMain;
    }

    public final long getFetchTimeThrottleMillis() {
        return this.fetchTimeThrottleMillis;
    }

    public final long getSubProcessMainSuccessRequestExpireIntervalMillis() {
        return this.subProcessMainSuccessRequestExpireIntervalMillis;
    }

    public final long getSubProcessWakeMainIntervalMillis() {
        return this.subProcessWakeMainIntervalMillis;
    }

    public final long getSubProcessWakeMainMaxCheckDelayMillis() {
        return this.subProcessWakeMainMaxCheckDelayMillis;
    }

    public final long getSubProcessWakeMainMinCheckDelayMillis() {
        return this.subProcessWakeMainMinCheckDelayMillis;
    }

    public final boolean getUseNetworkIntercept() {
        return this.useNetworkIntercept;
    }

    public ZeusAutoFetchConfig(boolean r100, long r101, long r102, boolean r103, long r110, long r111, long r112, long r113, long r114) {
        this.useNetworkIntercept = r100;
        this.autoFetchTimeIntervalMillis = r101;
        this.fetchTimeThrottleMillis = r102;
        this.enableSubProcessWakeMain = r103;
        this.subProcessWakeMainIntervalMillis = r110;
        this.subProcessMainSuccessRequestExpireIntervalMillis = r111;
        this.dex2oatBootGuardMillis = r112;
        this.subProcessWakeMainMinCheckDelayMillis = r113;
        this.subProcessWakeMainMaxCheckDelayMillis = r114;
    }

    public /* synthetic */ ZeusAutoFetchConfig(boolean r110, long r210, long r211, boolean r212, long r213, long r214, long r215, long r310, long r311, int r312, DefaultConstructorMarker r313) {
        boolean r100 = false;
        if ((r312 & 1) == 0) goto L5;
        boolean r101 = false;
    L6:
        long r102 = 3600000;
        if ((r312 & 2) == 0) goto L9;
        long r103 = 3600000;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r104 = 3600000;
    L15:
        if ((r312 & 8) != 0) goto L19;
        r100 = r212;
    L19:
        if ((r312 & 16) == 0) goto L21;
        long r111 = 3600000;
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r112 = 10800000;
    L26:
        long r113 = 900000;
        if ((r312 & 64) == 0) goto L29;
        long r114 = 900000;
    L31:
        if ((r312 & 128) != 0) goto L35;
        r113 = r310;
    L35:
        if ((r312 & 256) != 0) goto L38;
        r102 = r311;
    L38:
        this(r101, r103, r104, r100, r111, r112, r114, r113, r102);
        return;
    L29:
        r114 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L26
    L21:
        r111 = r213;
        goto L23
    L13:
        r104 = r211;
        goto L15
    L9:
        r103 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
