package qv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u0013HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0019HÆ\u0003J¹\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0005HÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0016\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006K"}, d2 = {"Lcom/larus/settings/provider/perf/PerfOptConfig;", "", "sliverCrashEnable", "", "sliverCrashUserSample", "", "sliverAllThreadEnable", "sliverSample", "sliverANREnable", "sliverLaunchEnable", "sliverNativeEnable", "sliverJavaEnable", "sliverBatteryEnable", "sliverBatteryUserSample", "sliverTemperatureThreshold", "", "sliverCpuBackSpeedThreshold", "sliverCpuForeSpeedThreshold", "reportDuration", "", "imageDiskCacheConfig", "Lcom/larus/settings/provider/perf/ImageDiskCacheConfig;", "bdTrackerPerfConfig", "Lcom/larus/settings/provider/perf/BDTrackerPerfConfig;", "memoryCollectConfig", "Lcom/larus/settings/provider/perf/MemoryCollectConfig;", "<init>", "(ZIZIZZZZZIFFFJLcom/larus/settings/provider/perf/ImageDiskCacheConfig;Lcom/larus/settings/provider/perf/BDTrackerPerfConfig;Lcom/larus/settings/provider/perf/MemoryCollectConfig;)V", "getSliverCrashEnable", "()Z", "getSliverCrashUserSample", "()I", "getSliverAllThreadEnable", "getSliverSample", "getSliverANREnable", "getSliverLaunchEnable", "getSliverNativeEnable", "getSliverJavaEnable", "getSliverBatteryEnable", "getSliverBatteryUserSample", "getSliverTemperatureThreshold", "()F", "getSliverCpuBackSpeedThreshold", "getSliverCpuForeSpeedThreshold", "getReportDuration", "()J", "getImageDiskCacheConfig", "()Lcom/larus/settings/provider/perf/ImageDiskCacheConfig;", "getBdTrackerPerfConfig", "()Lcom/larus/settings/provider/perf/BDTrackerPerfConfig;", "getMemoryCollectConfig", "()Lcom/larus/settings/provider/perf/MemoryCollectConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName("bd_tracker_perf_config")
    private final a bdTrackerPerfConfig;

    @SerializedName("image_disk_cache_config")
    private final n imageDiskCacheConfig;

    @SerializedName("memory_collect_config")
    private final o memoryCollectConfig;

    @SerializedName("f_sliver_cpu_report_duration")
    private final long reportDuration;

    @SerializedName("f_sliver_anr_enable")
    private final boolean sliverANREnable;

    @SerializedName("f_sliver_all_thread_enable")
    private final boolean sliverAllThreadEnable;

    @SerializedName("f_sliver_battery_enable")
    private final boolean sliverBatteryEnable;

    @SerializedName("f_sliver_battery_user_sample")
    private final int sliverBatteryUserSample;

    @SerializedName("f_sliver_cpu_back_speed_threshold")
    private final float sliverCpuBackSpeedThreshold;

    @SerializedName("f_sliver_cpu_fore_speed_threshold")
    private final float sliverCpuForeSpeedThreshold;

    @SerializedName("f_sliver_crash_enable")
    private final boolean sliverCrashEnable;

    @SerializedName("f_sliver_crash_user_sample")
    private final int sliverCrashUserSample;

    @SerializedName("f_sliver_java_enable")
    private final boolean sliverJavaEnable;

    @SerializedName("f_sliver_launch_enable")
    private final boolean sliverLaunchEnable;

    @SerializedName("f_sliver_native_enable")
    private final boolean sliverNativeEnable;

    @SerializedName("f_sliver_sample")
    private final int sliverSample;

    @SerializedName("f_sliver_temperature_threshold")
    private final float sliverTemperatureThreshold;

    public r() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.sliverCrashEnable == r101.sliverCrashEnable) goto L12;
        return false;
    L12:
        if (this.sliverCrashUserSample == r101.sliverCrashUserSample) goto L15;
        return false;
    L15:
        if (this.sliverAllThreadEnable == r101.sliverAllThreadEnable) goto L18;
        return false;
    L18:
        if (this.sliverSample == r101.sliverSample) goto L21;
        return false;
    L21:
        if (this.sliverANREnable == r101.sliverANREnable) goto L24;
        return false;
    L24:
        if (this.sliverLaunchEnable == r101.sliverLaunchEnable) goto L27;
        return false;
    L27:
        if (this.sliverNativeEnable == r101.sliverNativeEnable) goto L30;
        return false;
    L30:
        if (this.sliverJavaEnable == r101.sliverJavaEnable) goto L33;
        return false;
    L33:
        if (this.sliverBatteryEnable == r101.sliverBatteryEnable) goto L36;
        return false;
    L36:
        if (this.sliverBatteryUserSample == r101.sliverBatteryUserSample) goto L39;
        return false;
    L39:
        if (Float.compare(this.sliverTemperatureThreshold, r101.sliverTemperatureThreshold) == 0) goto L42;
        return false;
    L42:
        if (Float.compare(this.sliverCpuBackSpeedThreshold, r101.sliverCpuBackSpeedThreshold) == 0) goto L45;
        return false;
    L45:
        if (Float.compare(this.sliverCpuForeSpeedThreshold, r101.sliverCpuForeSpeedThreshold) == 0) goto L48;
        return false;
    L48:
        if (this.reportDuration == r101.reportDuration) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.imageDiskCacheConfig, r101.imageDiskCacheConfig) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.bdTrackerPerfConfig, r101.bdTrackerPerfConfig) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.memoryCollectConfig, r101.memoryCollectConfig) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.sliverCrashEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.sliverCrashUserSample) * 31;
        if (this.sliverAllThreadEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.sliverSample) * 31;
        if (this.sliverANREnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.sliverLaunchEnable == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.sliverNativeEnable == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.sliverJavaEnable == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.sliverBatteryEnable == true) goto L30;
        r100 = 1237;
    L30:
        int r113 = (((((((((r112 + r100) * 31) + this.sliverBatteryUserSample) * 31) + Float.floatToIntBits(this.sliverTemperatureThreshold)) * 31) + Float.floatToIntBits(this.sliverCpuBackSpeedThreshold)) * 31) + Float.floatToIntBits(this.sliverCpuForeSpeedThreshold)) * 31;
        long r114 = this.reportDuration;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        n r116 = this.imageDiskCacheConfig;
        int r117 = 0;
        if (r116 != null) goto L33;
        int r118 = 0;
    L34:
        int r119 = (r115 + r118) * 31;
        a r120 = this.bdTrackerPerfConfig;
        if (r120 != null) goto L37;
        int r121 = 0;
    L38:
        int r122 = (r119 + r121) * 31;
        o r123 = this.memoryCollectConfig;
        if (r123 == null) goto L43;
        r117 = r123.hashCode();
    L43:
        return r122 + r117;
    L37:
        r121 = r120.hashCode();
        goto L38
    L33:
        r118 = r116.hashCode();
        goto L34
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PerfOptConfig(sliverCrashEnable=" + this.sliverCrashEnable + ", sliverCrashUserSample=" + this.sliverCrashUserSample + ", sliverAllThreadEnable=" + this.sliverAllThreadEnable + ", sliverSample=" + this.sliverSample + ", sliverANREnable=" + this.sliverANREnable + ", sliverLaunchEnable=" + this.sliverLaunchEnable + ", sliverNativeEnable=" + this.sliverNativeEnable + ", sliverJavaEnable=" + this.sliverJavaEnable + ", sliverBatteryEnable=" + this.sliverBatteryEnable + ", sliverBatteryUserSample=" + this.sliverBatteryUserSample + ", sliverTemperatureThreshold=" + this.sliverTemperatureThreshold + ", sliverCpuBackSpeedThreshold=" + this.sliverCpuBackSpeedThreshold + ", sliverCpuForeSpeedThreshold=" + this.sliverCpuForeSpeedThreshold + ", reportDuration=" + this.reportDuration + ", imageDiskCacheConfig=" + this.imageDiskCacheConfig + ", bdTrackerPerfConfig=" + this.bdTrackerPerfConfig + ", memoryCollectConfig=" + this.memoryCollectConfig + ')';
    }

    public final a a() {
        return this.bdTrackerPerfConfig;
    }

    public final n b() {
        return this.imageDiskCacheConfig;
    }

    public final o c() {
        return this.memoryCollectConfig;
    }

    public r(int r100) {
        o r101 = new o(0);
        this.sliverCrashEnable = false;
        this.sliverCrashUserSample = -1;
        this.sliverAllThreadEnable = false;
        this.sliverSample = 25;
        this.sliverANREnable = true;
        this.sliverLaunchEnable = true;
        this.sliverNativeEnable = true;
        this.sliverJavaEnable = true;
        this.sliverBatteryEnable = false;
        this.sliverBatteryUserSample = -1;
        this.sliverTemperatureThreshold = -1.0f;
        this.sliverCpuBackSpeedThreshold = -1.0f;
        this.sliverCpuForeSpeedThreshold = -1.0f;
        this.reportDuration = 3600000;
        this.imageDiskCacheConfig = null;
        this.bdTrackerPerfConfig = null;
        this.memoryCollectConfig = r101;
    }
}
