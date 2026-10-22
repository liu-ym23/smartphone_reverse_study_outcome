package gz5;

import com.apm.lite.runtime.ConfigManager;
import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R \u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013¨\u0006("}, d2 = {"Lgz5/t;", "", "", "enabled", "Z", "getEnabled", "()Z", "", "beforeDelayInterval", "J", "getBeforeDelayInterval", "()J", "afterDelayInterval", "getAfterDelayInterval", "", "Lgz5/d;", "allowNetworkIdConfigs", "Ljava/util/List;", "getAllowNetworkIdConfigs", "()Ljava/util/List;", "Lgz5/b;", "allowNetworkApiConfigs", "getAllowNetworkApiConfigs", "blockNetworkApiConfigs", "getBlockNetworkApiConfigs", "Lgz5/c;", "allowNetworkApmConfigs", "getAllowNetworkApmConfigs", "blockNetworkApmConfigs", "getBlockNetworkApmConfigs", "pairCacheInterval", "getPairCacheInterval", "", "costTimeSampleRate", "D", "getCostTimeSampleRate", "()D", "", "reportBlockList", "getReportBlockList", "api_release"}, k = 1, mv = {1, 4, 0})
public final class t {

    @SerializedName("after_delay_interval")
    private final long afterDelayInterval;

    @SerializedName("allow_network_api_configs")
    private final List<b> allowNetworkApiConfigs;

    @SerializedName("allow_network_apm_configs")
    private final List<c> allowNetworkApmConfigs;

    @SerializedName("allow_network_id_configs")
    private final List<d> allowNetworkIdConfigs;

    @SerializedName("before_delay_interval")
    private final long beforeDelayInterval;

    @SerializedName("block_network_api_configs")
    private final List<b> blockNetworkApiConfigs;

    @SerializedName("block_network_apm_configs")
    private final List<c> blockNetworkApmConfigs;

    @SerializedName("cost_time_sample_rate")
    private final double costTimeSampleRate;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("pair_cache_interval")
    private final long pairCacheInterval;

    @SerializedName("report_block_list")
    private final List<String> reportBlockList;

    public t() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L28;
        t r101 = (t) r100;
        if (this.enabled == r101.enabled) goto L8;
        return false;
    L8:
        if (this.beforeDelayInterval == r101.beforeDelayInterval) goto L10;
        return false;
    L10:
        if (this.afterDelayInterval == r101.afterDelayInterval) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.allowNetworkIdConfigs, r101.allowNetworkIdConfigs) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.allowNetworkApiConfigs, r101.allowNetworkApiConfigs) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.blockNetworkApiConfigs, r101.blockNetworkApiConfigs) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.allowNetworkApmConfigs, r101.allowNetworkApmConfigs) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.blockNetworkApmConfigs, r101.blockNetworkApmConfigs) == true) goto L22;
        return false;
    L22:
        if (this.pairCacheInterval == r101.pairCacheInterval) goto L24;
        return false;
    L24:
        if (Double.compare(this.costTimeSampleRate, r101.costTimeSampleRate) == 0) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.reportBlockList, r101.reportBlockList) == true) goto L43;
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
        boolean r100 = this.enabled;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.beforeDelayInterval;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.afterDelayInterval;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        List<d> r106 = this.allowNetworkIdConfigs;
        int r107 = 0;
        if (r106 == null) goto L8;
        int r108 = r106.hashCode();
    L9:
        int r109 = (r105 + r108) * 31;
        List<b> r110 = this.allowNetworkApiConfigs;
        if (r110 == null) goto L12;
        int r111 = r110.hashCode();
    L13:
        int r112 = (r109 + r111) * 31;
        List<b> r113 = this.blockNetworkApiConfigs;
        if (r113 == null) goto L16;
        int r114 = r113.hashCode();
    L17:
        int r115 = (r112 + r114) * 31;
        List<c> r116 = this.allowNetworkApmConfigs;
        if (r116 == null) goto L20;
        int r117 = r116.hashCode();
    L21:
        int r118 = (r115 + r117) * 31;
        List<c> r119 = this.blockNetworkApmConfigs;
        if (r119 == null) goto L24;
        int r120 = r119.hashCode();
    L25:
        long r121 = this.pairCacheInterval;
        int r122 = (((r118 + r120) * 31) + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = Double.doubleToLongBits(this.costTimeSampleRate);
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        List<String> r125 = this.reportBlockList;
        if (r125 == null) goto L29;
        r107 = r125.hashCode();
    L29:
        return r124 + r107;
    L24:
        r120 = 0;
        goto L25
    L20:
        r117 = 0;
        goto L21
    L16:
        r114 = 0;
        goto L17
    L12:
        r111 = 0;
        goto L13
    L8:
        r108 = 0;
        goto L9
    }

    public final String toString() {
        return "NetworkConfig(enabled=" + this.enabled + ", beforeDelayInterval=" + this.beforeDelayInterval + ", afterDelayInterval=" + this.afterDelayInterval + ", allowNetworkIdConfigs=" + this.allowNetworkIdConfigs + ", allowNetworkApiConfigs=" + this.allowNetworkApiConfigs + ", blockNetworkApiConfigs=" + this.blockNetworkApiConfigs + ", allowNetworkApmConfigs=" + this.allowNetworkApmConfigs + ", blockNetworkApmConfigs=" + this.blockNetworkApmConfigs + ", pairCacheInterval=" + this.pairCacheInterval + ", costTimeSampleRate=" + this.costTimeSampleRate + ", reportBlockList=" + this.reportBlockList + ")";
    }

    public t(Object r110) {
        List<d> r111 = CollectionsKt.listOf(new d(SetsKt.setOf(new Integer[]{400401, 400402, 400500, 400501}), "before"));
        List<b> r100 = CollectionsKt.listOf(new b(SetsKt.setOf(new String[]{"/api/checkLogSensitiveWords/", "/service/2/app_log_test/", "/service/2/app_log/", "/monitor/collect/batch/", ConfigManager.FILE_UPLOAD_URL_SUFFIX, ConfigManager.EXCEPTION_URL_SUFFIX, "/monitor/collect/c/code_coverage", "/tfe/api/request_combine/v1/", "/tiktok/v1/kids/settings/"}), 5));
        List<b> r101 = CollectionsKt.emptyList();
        List<c> r102 = CollectionsKt.listOf(new c(SetsKt.setOf(new String[]{"pns_network", UploadTypeInf.API_ALL, "sky_eye_apm_log"}), 5));
        List<c> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.listOf("Cookie");
        this.enabled = false;
        this.beforeDelayInterval = 0;
        this.afterDelayInterval = 0;
        this.allowNetworkIdConfigs = r111;
        this.allowNetworkApiConfigs = r100;
        this.blockNetworkApiConfigs = r101;
        this.allowNetworkApmConfigs = r102;
        this.blockNetworkApmConfigs = r103;
        this.pairCacheInterval = 1000;
        this.costTimeSampleRate = 1.0E-4d;
        this.reportBlockList = r104;
    }
}
