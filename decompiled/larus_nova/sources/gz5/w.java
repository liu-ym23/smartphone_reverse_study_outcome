package gz5;

import androidx.camera.video.AudioStats;
import com.amap.api.col.s.ce;
import com.bytedance.helios.api.config.ApiSampleRateConfig;
import com.bytedance.helios.api.config.DefaultSampleRateConfig;
import com.bytedance.helios.api.config.ResourceSampleRateConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"¨\u0006&"}, d2 = {"Lgz5/w;", "", "", "enableMonitor", "Z", "f", "()Z", "", "appOpsConfig", "D", "c", "()D", "autoStartConfig", "d", "appExitConfig", "b", "exceptionConfig", "h", "exceptionAlogConfig", ce.f26391f, "strictModeConfig", ce.f26396k, "localAPMConfig", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "defaultLowPriorityConfig", "Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "e", "()Lcom/bytedance/helios/api/config/DefaultSampleRateConfig;", "", "Lcom/bytedance/helios/api/config/ResourceSampleRateConfig;", "resourceMediumPriorityConfigs", "Ljava/util/List;", ce.f26395j, "()Ljava/util/List;", "Lcom/bytedance/helios/api/config/ApiSampleRateConfig;", "apiHighPriorityConfigs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "api_release"}, k = 1, mv = {1, 4, 0})
public final class w {

    @SerializedName("api_high_priority_configs")
    private final List<ApiSampleRateConfig> apiHighPriorityConfigs;

    @SerializedName("app_exit_config")
    private final double appExitConfig;

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
    private final List<ResourceSampleRateConfig> resourceMediumPriorityConfigs;

    @SerializedName("strict_mode_config")
    private final double strictModeConfig;

    public w() {
        this(false, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w) == false) goto L28;
        w r101 = (w) r100;
        if (this.enableMonitor == r101.enableMonitor) goto L8;
        return false;
    L8:
        if (Double.compare(this.appOpsConfig, r101.appOpsConfig) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.autoStartConfig, r101.autoStartConfig) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.appExitConfig, r101.appExitConfig) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.exceptionConfig, r101.exceptionConfig) == 0) goto L16;
        return false;
    L16:
        if (Double.compare(this.exceptionAlogConfig, r101.exceptionAlogConfig) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.strictModeConfig, r101.strictModeConfig) == 0) goto L20;
        return false;
    L20:
        if (Double.compare(this.localAPMConfig, r101.localAPMConfig) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.defaultLowPriorityConfig, r101.defaultLowPriorityConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceMediumPriorityConfigs, r101.resourceMediumPriorityConfigs) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.apiHighPriorityConfigs, r101.apiHighPriorityConfigs) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    public final int hashCode() {
        boolean r100 = this.enableMonitor;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = Double.doubleToLongBits(this.appOpsConfig);
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.autoStartConfig);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.appExitConfig);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.exceptionConfig);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.exceptionAlogConfig);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = Double.doubleToLongBits(this.strictModeConfig);
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = Double.doubleToLongBits(this.localAPMConfig);
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        DefaultSampleRateConfig r116 = this.defaultLowPriorityConfig;
        int r117 = 0;
        if (r116 == null) goto L8;
        int r118 = r116.hashCode();
    L9:
        int r119 = (r115 + r118) * 31;
        List<ResourceSampleRateConfig> r120 = this.resourceMediumPriorityConfigs;
        if (r120 == null) goto L12;
        int r121 = r120.hashCode();
    L13:
        int r122 = (r119 + r121) * 31;
        List<ApiSampleRateConfig> r123 = this.apiHighPriorityConfigs;
        if (r123 == null) goto L17;
        r117 = r123.hashCode();
    L17:
        return r122 + r117;
    L12:
        r121 = 0;
        goto L13
    L8:
        r118 = 0;
        goto L9
    }

    public final String toString() {
        return "SampleRateConfig(enableMonitor=" + this.enableMonitor + ", appOpsConfig=" + this.appOpsConfig + ", autoStartConfig=" + this.autoStartConfig + ", appExitConfig=" + this.appExitConfig + ", exceptionConfig=" + this.exceptionConfig + ", exceptionAlogConfig=" + this.exceptionAlogConfig + ", strictModeConfig=" + this.strictModeConfig + ", localAPMConfig=" + this.localAPMConfig + ", defaultLowPriorityConfig=" + this.defaultLowPriorityConfig + ", resourceMediumPriorityConfigs=" + this.resourceMediumPriorityConfigs + ", apiHighPriorityConfigs=" + this.apiHighPriorityConfigs + ")";
    }

    public final List<ApiSampleRateConfig> a() {
        return this.apiHighPriorityConfigs;
    }

    public final double b() {
        return this.appExitConfig;
    }

    public final double c() {
        return this.appOpsConfig;
    }

    public final double d() {
        return this.autoStartConfig;
    }

    public final DefaultSampleRateConfig e() {
        return this.defaultLowPriorityConfig;
    }

    public final boolean f() {
        return this.enableMonitor;
    }

    public final double g() {
        return this.exceptionAlogConfig;
    }

    public final double h() {
        return this.exceptionConfig;
    }

    public final double i() {
        return this.localAPMConfig;
    }

    public final List<ResourceSampleRateConfig> j() {
        return this.resourceMediumPriorityConfigs;
    }

    public final double k() {
        return this.strictModeConfig;
    }

    public w(boolean r310, double r311, double r312, double r313, double r314, double r410, DefaultSampleRateConfig r411, List r412, List r413, int r414) {
        if ((r414 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r414 & 2) == 0) goto L9;
        double r101 = 1.0E-5d;
    L11:
        if ((r414 & 4) == 0) goto L13;
        double r102 = 1.0E-4d;
    L15:
        if ((r414 & 8) == 0) goto L17;
        double r110 = 1.0E-4d;
    L18:
        double r111 = 0.1d;
        if ((r414 & 16) == 0) goto L21;
        double r103 = 0.1d;
    L23:
        if ((r414 & 32) == 0) goto L25;
        double r112 = 0.1d;
    L27:
        if ((r414 & 64) != 0) goto L31;
        r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L31:
        if ((r414 & 128) == 0) goto L33;
        double r113 = 1.0E-4d;
    L35:
        if ((r414 & 256) == 0) goto L37;
        DefaultSampleRateConfig r104 = new DefaultSampleRateConfig(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);
    L38:
        DefaultSampleRateConfig r114 = r104;
        if ((r414 & 512) == 0) goto L41;
        List r105 = CollectionsKt.emptyList();
    L43:
        if ((r414 & 1024) == 0) goto L45;
        List r106 = CollectionsKt.emptyList();
    L46:
        this.enableMonitor = r100;
        this.appOpsConfig = r101;
        this.autoStartConfig = r102;
        this.appExitConfig = r110;
        this.exceptionConfig = r103;
        this.exceptionAlogConfig = r112;
        this.strictModeConfig = r111;
        this.localAPMConfig = r113;
        this.defaultLowPriorityConfig = r114;
        this.resourceMediumPriorityConfigs = r105;
        this.apiHighPriorityConfigs = r106;
        return;
    L45:
        r106 = r413;
        goto L46
    L41:
        r105 = r412;
        goto L43
    L37:
        r104 = r411;
        goto L38
    L33:
        r113 = r410;
        goto L35
    L25:
        r112 = r314;
        goto L27
    L21:
        r103 = r313;
        goto L23
    L17:
        r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L18
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
