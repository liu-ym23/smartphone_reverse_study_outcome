package com.bytedance.timon_monitor_impl.settings;

import androidx.camera.video.AudioStats;
import com.bytedance.helios.api.config.DefaultSampleRateConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Jc\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/bytedance/timon_monitor_impl/settings/SampleRateConfigV2;", "", "enableMonitor", "", "appOpsConfig", "", "autoStartConfig", "exceptionConfig", "exceptionAlogConfig", "localAPMConfig", "defaultLowPriorityConfig", "Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "resourceMediumPriorityConfigs", "Lcom/bytedance/timon_monitor_impl/settings/CustomSampleRateConfig;", "apiHighPriorityConfigs", "(ZDDDDDLcom/bytedance/helios/api/config/DefaultSampleRateConfig;Lcom/bytedance/timon_monitor_impl/settings/CustomSampleRateConfig;Lcom/bytedance/timon_monitor_impl/settings/CustomSampleRateConfig;)V", "getApiHighPriorityConfigs", "()Lcom/bytedance/timon_monitor_impl/settings/CustomSampleRateConfig;", "getAppOpsConfig", "()D", "getAutoStartConfig", "getDefaultLowPriorityConfig", "()Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "getEnableMonitor", "()Z", "getExceptionAlogConfig", "getExceptionConfig", "getLocalAPMConfig", "getResourceMediumPriorityConfigs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "timon-monitor-impl_release"}, k = 1, mv = {1, 1, 16})
public final class SampleRateConfigV2 {

    @SerializedName("api_high_priority_configs")
    private final CustomSampleRateConfig apiHighPriorityConfigs;

    @SerializedName("app_ops_config")
    private final double appOpsConfig;

    @SerializedName("auto_start_config")
    private final double autoStartConfig;

    @SerializedName("default_low_priority_config")
    private final DefaultSampleRateConfig defaultLowPriorityConfig;

    @SerializedName(DownloadSettingKeys.ENABLE_MONITOR)
    private final boolean enableMonitor;

    @SerializedName("exception_alog_config")
    private final double exceptionAlogConfig;

    @SerializedName("exception_config")
    private final double exceptionConfig;

    @SerializedName("local_apm_config")
    private final double localAPMConfig;

    @SerializedName("resource_medium_priority_configs")
    private final CustomSampleRateConfig resourceMediumPriorityConfigs;

    public SampleRateConfigV2() {
        this(false, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, 511, null);
    }

    public static /* synthetic */ SampleRateConfigV2 copy$default(SampleRateConfigV2 r110, boolean r111, double r112, double r113, double r210, double r211, double r212, DefaultSampleRateConfig r213, CustomSampleRateConfig r214, CustomSampleRateConfig r215, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        boolean r100 = r110.enableMonitor;
    L7:
        if ((r310 & 2) == 0) goto L9;
        double r101 = r110.appOpsConfig;
    L11:
        if ((r310 & 4) == 0) goto L13;
        double r102 = r110.autoStartConfig;
    L15:
        if ((r310 & 8) == 0) goto L17;
        double r103 = r110.exceptionConfig;
    L19:
        if ((r310 & 16) == 0) goto L21;
        double r104 = r110.exceptionAlogConfig;
    L23:
        if ((r310 & 32) == 0) goto L25;
        double r114 = r110.localAPMConfig;
    L27:
        if ((r310 & 64) == 0) goto L29;
        DefaultSampleRateConfig r115 = r110.defaultLowPriorityConfig;
    L31:
        if ((r310 & 128) == 0) goto L33;
        CustomSampleRateConfig r116 = r110.resourceMediumPriorityConfigs;
    L35:
        if ((r310 & 256) == 0) goto L37;
        CustomSampleRateConfig r105 = r110.apiHighPriorityConfigs;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r114, r115, r116, r105);
    L37:
        r105 = r215;
        goto L39
    L33:
        r116 = r214;
        goto L35
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.enableMonitor;
    }

    public final double component2() {
        return this.appOpsConfig;
    }

    public final double component3() {
        return this.autoStartConfig;
    }

    public final double component4() {
        return this.exceptionConfig;
    }

    public final double component5() {
        return this.exceptionAlogConfig;
    }

    public final double component6() {
        return this.localAPMConfig;
    }

    public final DefaultSampleRateConfig component7() {
        return this.defaultLowPriorityConfig;
    }

    public final CustomSampleRateConfig component8() {
        return this.resourceMediumPriorityConfigs;
    }

    public final CustomSampleRateConfig component9() {
        return this.apiHighPriorityConfigs;
    }

    public final SampleRateConfigV2 copy(boolean r110, double r111, double r210, double r211, double r212, double r213, DefaultSampleRateConfig r214, CustomSampleRateConfig r215, CustomSampleRateConfig r310) {
        return new SampleRateConfigV2(r110, r111, r210, r211, r212, r213, r214, r215, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SampleRateConfigV2) == false) goto L24;
        SampleRateConfigV2 r101 = (SampleRateConfigV2) r100;
        if (this.enableMonitor == r101.enableMonitor) goto L8;
        return false;
    L8:
        if (Double.compare(this.appOpsConfig, r101.appOpsConfig) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.autoStartConfig, r101.autoStartConfig) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.exceptionConfig, r101.exceptionConfig) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.exceptionAlogConfig, r101.exceptionAlogConfig) == 0) goto L16;
        return false;
    L16:
        if (Double.compare(this.localAPMConfig, r101.localAPMConfig) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultLowPriorityConfig, r101.defaultLowPriorityConfig) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.resourceMediumPriorityConfigs, r101.resourceMediumPriorityConfigs) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.apiHighPriorityConfigs, r101.apiHighPriorityConfigs) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public int hashCode() {
        boolean r100 = this.enableMonitor;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = Double.doubleToLongBits(this.appOpsConfig);
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.autoStartConfig);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.exceptionConfig);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.exceptionAlogConfig);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.localAPMConfig);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        DefaultSampleRateConfig r112 = this.defaultLowPriorityConfig;
        int r113 = 0;
        if (r112 == null) goto L8;
        int r114 = r112.hashCode();
    L9:
        int r115 = (r111 + r114) * 31;
        CustomSampleRateConfig r116 = this.resourceMediumPriorityConfigs;
        if (r116 == null) goto L12;
        int r117 = r116.hashCode();
    L13:
        int r118 = (r115 + r117) * 31;
        CustomSampleRateConfig r119 = this.apiHighPriorityConfigs;
        if (r119 == null) goto L17;
        r113 = r119.hashCode();
    L17:
        return r118 + r113;
    L12:
        r117 = 0;
        goto L13
    L8:
        r114 = 0;
        goto L9
    }

    public String toString() {
        return "SampleRateConfigV2(enableMonitor=" + this.enableMonitor + ", appOpsConfig=" + this.appOpsConfig + ", autoStartConfig=" + this.autoStartConfig + ", exceptionConfig=" + this.exceptionConfig + ", exceptionAlogConfig=" + this.exceptionAlogConfig + ", localAPMConfig=" + this.localAPMConfig + ", defaultLowPriorityConfig=" + this.defaultLowPriorityConfig + ", resourceMediumPriorityConfigs=" + this.resourceMediumPriorityConfigs + ", apiHighPriorityConfigs=" + this.apiHighPriorityConfigs + ")";
    }

    public final CustomSampleRateConfig getApiHighPriorityConfigs() {
        return this.apiHighPriorityConfigs;
    }

    public final double getAppOpsConfig() {
        return this.appOpsConfig;
    }

    public final double getAutoStartConfig() {
        return this.autoStartConfig;
    }

    public final DefaultSampleRateConfig getDefaultLowPriorityConfig() {
        return this.defaultLowPriorityConfig;
    }

    public final boolean getEnableMonitor() {
        return this.enableMonitor;
    }

    public final double getExceptionAlogConfig() {
        return this.exceptionAlogConfig;
    }

    public final double getExceptionConfig() {
        return this.exceptionConfig;
    }

    public final double getLocalAPMConfig() {
        return this.localAPMConfig;
    }

    public final CustomSampleRateConfig getResourceMediumPriorityConfigs() {
        return this.resourceMediumPriorityConfigs;
    }

    public SampleRateConfigV2(boolean r100, double r101, double r102, double r103, double r104, double r110, DefaultSampleRateConfig r111, CustomSampleRateConfig r112, CustomSampleRateConfig r113) {
        this.enableMonitor = r100;
        this.appOpsConfig = r101;
        this.autoStartConfig = r102;
        this.exceptionConfig = r103;
        this.exceptionAlogConfig = r104;
        this.localAPMConfig = r110;
        this.defaultLowPriorityConfig = r111;
        this.resourceMediumPriorityConfigs = r112;
        this.apiHighPriorityConfigs = r113;
    }

    public /* synthetic */ SampleRateConfigV2(boolean r210, double r211, double r310, double r311, double r312, double r313, DefaultSampleRateConfig r314, CustomSampleRateConfig r315, CustomSampleRateConfig r410, int r411, DefaultConstructorMarker r412) {
        if ((r411 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r411 & 2) == 0) goto L9;
        double r101 = 1.0E-5d;
    L11:
        if ((r411 & 4) == 0) goto L13;
        double r102 = 1.0E-4d;
    L14:
        double r103 = 0.1d;
        if ((r411 & 8) == 0) goto L17;
        double r104 = 0.1d;
    L19:
        if ((r411 & 16) != 0) goto L23;
        r103 = r312;
    L23:
        if ((r411 & 32) == 0) goto L25;
        double r110 = 0.001d;
    L27:
        if ((r411 & 64) == 0) goto L29;
        DefaultSampleRateConfig r105 = new DefaultSampleRateConfig(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);
    L31:
        if ((r411 & 128) == 0) goto L33;
        CustomSampleRateConfig r111 = new CustomSampleRateConfig(null, null, null, null, 15, null);
    L35:
        if ((r411 & 256) == 0) goto L37;
        CustomSampleRateConfig r106 = new CustomSampleRateConfig(null, null, null, null, 15, null);
    L38:
        this(r100, r101, r102, r104, r103, r110, r105, r111, r106);
        return;
    L37:
        r106 = r410;
        goto L38
    L33:
        r111 = r315;
        goto L35
    L29:
        r105 = r314;
        goto L31
    L25:
        r110 = r313;
        goto L27
    L17:
        r104 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
