package gz5;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.helios.api.config.AnchorInfoModel;
import com.bytedance.helios.api.config.ApiStatistics;
import com.bytedance.helios.api.config.RuleInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001oR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R \u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R \u0010/\u001a\b\u0012\u0004\u0012\u00020.0&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R \u00102\u001a\b\u0012\u0004\u0012\u0002010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+R \u00104\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b5\u0010+R\u001a\u00107\u001a\u0002068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\u0016\u001a\u0004\b<\u0010\u0018R\u001a\u0010>\u001a\u00020=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR \u0010H\u001a\b\u0012\u0004\u0012\u00020G0&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010)\u001a\u0004\bI\u0010+R \u0010J\u001a\b\u0012\u0004\u0012\u00020\u00190&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010)\u001a\u0004\bK\u0010+R\u001a\u0010M\u001a\u00020L8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bR\u0010\u000bR\u001a\u0010T\u001a\u00020S8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010\t\u001a\u0004\bY\u0010\u000bR\u001a\u0010Z\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010\u0006R \u0010]\u001a\b\u0012\u0004\u0012\u00020\u00020\\8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001a\u0010b\u001a\u00020a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\bg\u0010\u000bR \u0010h\u001a\b\u0012\u0004\u0012\u00020\u00020\\8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010^\u001a\u0004\bi\u0010`R\u001a\u0010k\u001a\u00020j8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n¨\u0006p"}, d2 = {"Lgz5/y;", "", "", "version", "Ljava/lang/String;", "B", "()Ljava/lang/String;", "", "enabled", "Z", OfficeSDKRequestTag.KEY_NEW_USER, "()Z", "alogEnabled", "c", "permissionCheck", BaseSwitches.V, "permissionCheck$annotations", "()V", "permissionCheckReport", "w", "", "alogDuration", "J", "b", "()J", "", "alogLevel", "I", "d", "()I", "setAlogLevel", "(I)V", "optimizeTimon", "u", "setOptimizeTimon", "(Z)V", "apiTimeOutDuration", "h", "", "Lcom/bytedance/helios/api/config/AnchorInfoModel;", "anchorConfigs", "Ljava/util/List;", "e", "()Ljava/util/List;", "testEnvChannels", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Lcom/bytedance/helios/api/config/RuleInfo;", "ruleInfoList", "x", "Lgz5/p;", "frequencyConfigs", "q", "interestedAppOps", "s", "Lgz5/w;", "sampleRateConfig", "Lgz5/w;", "y", "()Lgz5/w;", "backgroundFreezeDuration", ce.f26395j, "Lgz5/e;", "apiConfig", "Lgz5/e;", "f", "()Lgz5/e;", "Lgz5/g;", "binderConfig", "Lgz5/g;", ce.f26396k, "()Lgz5/g;", "Lcom/bytedance/helios/api/config/ApiStatistics;", "apiStatisticsConfigs", ce.f26391f, "interceptIgnoreApiIds", "r", "Lgz5/m;", "crpConfig", "Lgz5/m;", "l", "()Lgz5/m;", "appOpsIgnoreKnownApi", RXScreenCaptureService.KEY_INDEX, "Lgz5/n;", "customAnchor", "Lgz5/n;", "getCustomAnchor", "()Lgz5/n;", "useBizUserRegionSwitch", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "engineType", "o", "", "errorWarningTypes", "Ljava/util/Set;", "p", "()Ljava/util/Set;", "Lgz5/j;", "cacheConfig", "Lgz5/j;", "getCacheConfig", "()Lgz5/j;", "enableParameterChecker", "m", "checkAppScenes", "getCheckAppScenes", "Lgz5/t;", "networkConfig", "Lgz5/t;", "t", "()Lgz5/t;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "api_release"}, k = 1, mv = {1, 4, 0})
public final class y {

    @SerializedName("alog_duration")
    private final long alogDuration;

    @SerializedName("alog_enabled")
    private final boolean alogEnabled;

    @SerializedName("alog_level")
    private int alogLevel;

    @SerializedName("anchor_configs")
    private final List<AnchorInfoModel> anchorConfigs;

    @SerializedName("api_config")
    private final e apiConfig;

    @SerializedName("api_statistics_configs")
    private final List<ApiStatistics> apiStatisticsConfigs;

    @SerializedName("api_time_out_duration")
    private final long apiTimeOutDuration;

    @SerializedName("appops_ignore_known_api")
    private final boolean appOpsIgnoreKnownApi;

    @SerializedName("background_freeze_duration")
    private final long backgroundFreezeDuration;

    @SerializedName("binder_config")
    private final g binderConfig;

    @SerializedName("cache_config")
    private final j cacheConfig;

    @SerializedName("check_app_scenes")
    private final Set<String> checkAppScenes;

    @SerializedName("crp_config")
    private final m crpConfig;

    @SerializedName("CustomAnchor")
    private final n customAnchor;

    @SerializedName("enable_parameter_checker")
    private final boolean enableParameterChecker;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("engine_type")
    private final String engineType;

    @SerializedName("error_warning_types")
    private final Set<String> errorWarningTypes;

    @SerializedName("frequency_configs")
    private final List<p> frequencyConfigs;

    @SerializedName("intercept_ignore_api_ids")
    private final List<Integer> interceptIgnoreApiIds;

    @SerializedName("interested_appops")
    private final List<String> interestedAppOps;

    @SerializedName("network_config")
    private final t networkConfig;

    @SerializedName("optimize_timon")
    private boolean optimizeTimon;

    @SerializedName("permission_check")
    private final boolean permissionCheck;

    @SerializedName("permission_check_report")
    private final boolean permissionCheckReport;

    @SerializedName("rule_info_list")
    private final List<RuleInfo> ruleInfoList;

    @SerializedName("sample_rate_config")
    private final w sampleRateConfig;

    @SerializedName("test_env_channels")
    private final List<String> testEnvChannels;

    @SerializedName("use_biz_user_region_switch")
    private final boolean useBizUserRegionSwitch;

    @SerializedName("version")
    private final String version;

    public static final class a {
    }

    static {
    }

    public y() {
        this(null, false, false, false, false, 0, 0, false, 0, null, null, null, null, null, null, 0, null, null, null, null, false, null, false, null, null, null, false, null, 1073741823);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L66;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
        return false;
    L8:
        if (this.enabled == r101.enabled) goto L10;
        return false;
    L10:
        if (this.alogEnabled == r101.alogEnabled) goto L12;
        return false;
    L12:
        if (this.permissionCheck == r101.permissionCheck) goto L14;
        return false;
    L14:
        if (this.permissionCheckReport == r101.permissionCheckReport) goto L16;
        return false;
    L16:
        if (this.alogDuration == r101.alogDuration) goto L18;
        return false;
    L18:
        if (this.alogLevel == r101.alogLevel) goto L20;
        return false;
    L20:
        if (this.optimizeTimon == r101.optimizeTimon) goto L22;
        return false;
    L22:
        if (this.apiTimeOutDuration == r101.apiTimeOutDuration) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.anchorConfigs, r101.anchorConfigs) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.testEnvChannels, r101.testEnvChannels) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.ruleInfoList, r101.ruleInfoList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.frequencyConfigs, r101.frequencyConfigs) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.interestedAppOps, r101.interestedAppOps) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.sampleRateConfig, r101.sampleRateConfig) == true) goto L36;
        return false;
    L36:
        if (this.backgroundFreezeDuration == r101.backgroundFreezeDuration) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.apiConfig, r101.apiConfig) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.binderConfig, r101.binderConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.apiStatisticsConfigs, r101.apiStatisticsConfigs) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.interceptIgnoreApiIds, r101.interceptIgnoreApiIds) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.crpConfig, r101.crpConfig) == true) goto L48;
        return false;
    L48:
        if (this.appOpsIgnoreKnownApi == r101.appOpsIgnoreKnownApi) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.customAnchor, r101.customAnchor) == true) goto L52;
        return false;
    L52:
        if (this.useBizUserRegionSwitch == r101.useBizUserRegionSwitch) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.engineType, r101.engineType) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.errorWarningTypes, r101.errorWarningTypes) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.cacheConfig, r101.cacheConfig) == true) goto L60;
        return false;
    L60:
        if (this.enableParameterChecker == r101.enableParameterChecker) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.checkAppScenes, r101.checkAppScenes) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.networkConfig, r101.networkConfig) == true) goto L100;
        return false;
    L100:
        return true;
    L66:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    public final int hashCode() {
        String r100 = this.version;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.enabled;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.alogEnabled;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.permissionCheck;
        ?? r112 = r111;
        if (r111 == false) goto L15;
        r112 = 1;
    L15:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.permissionCheckReport;
        ?? r115 = r114;
        if (r114 == false) goto L18;
        r115 = 1;
    L18:
        long r116 = this.alogDuration;
        int r117 = (((((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.alogLevel) * 31;
        boolean r118 = this.optimizeTimon;
        ?? r119 = r118;
        if (r118 == false) goto L21;
        r119 = 1;
    L21:
        int r120 = (r117 + r119) * 31;
        long r121 = this.apiTimeOutDuration;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        List<AnchorInfoModel> r123 = this.anchorConfigs;
        if (r123 == null) goto L24;
        int r124 = r123.hashCode();
    L25:
        int r125 = (r122 + r124) * 31;
        List<String> r126 = this.testEnvChannels;
        if (r126 == null) goto L28;
        int r127 = r126.hashCode();
    L29:
        int r128 = (r125 + r127) * 31;
        List<RuleInfo> r129 = this.ruleInfoList;
        if (r129 == null) goto L32;
        int r130 = r129.hashCode();
    L33:
        int r131 = (r128 + r130) * 31;
        List<p> r132 = this.frequencyConfigs;
        if (r132 == null) goto L36;
        int r133 = r132.hashCode();
    L37:
        int r134 = (r131 + r133) * 31;
        List<String> r135 = this.interestedAppOps;
        if (r135 == null) goto L40;
        int r136 = r135.hashCode();
    L41:
        int r137 = (r134 + r136) * 31;
        w r138 = this.sampleRateConfig;
        if (r138 == null) goto L44;
        int r139 = r138.hashCode();
    L45:
        int r140 = (r137 + r139) * 31;
        long r141 = this.backgroundFreezeDuration;
        int r142 = (r140 + ((int) (r141 ^ (r141 >>> 32)))) * 31;
        e r143 = this.apiConfig;
        if (r143 == null) goto L48;
        int r144 = r143.hashCode();
    L49:
        int r145 = (r142 + r144) * 31;
        g r146 = this.binderConfig;
        if (r146 == null) goto L52;
        int r147 = r146.hashCode();
    L53:
        int r148 = (r145 + r147) * 31;
        List<ApiStatistics> r149 = this.apiStatisticsConfigs;
        if (r149 == null) goto L56;
        int r150 = r149.hashCode();
    L57:
        int r151 = (r148 + r150) * 31;
        List<Integer> r152 = this.interceptIgnoreApiIds;
        if (r152 == null) goto L60;
        int r153 = r152.hashCode();
    L61:
        int r154 = (r151 + r153) * 31;
        m r155 = this.crpConfig;
        if (r155 == null) goto L64;
        int r156 = r155.hashCode();
    L65:
        int r157 = (r154 + r156) * 31;
        boolean r158 = this.appOpsIgnoreKnownApi;
        ?? r159 = r158;
        if (r158 == false) goto L68;
        r159 = 1;
    L68:
        int r160 = (r157 + r159) * 31;
        n r161 = this.customAnchor;
        if (r161 == null) goto L71;
        int r162 = r161.hashCode();
    L72:
        int r163 = (r160 + r162) * 31;
        boolean r164 = this.useBizUserRegionSwitch;
        ?? r165 = r164;
        if (r164 == false) goto L75;
        r165 = 1;
    L75:
        int r166 = (r163 + r165) * 31;
        String r167 = this.engineType;
        if (r167 == null) goto L78;
        int r168 = r167.hashCode();
    L79:
        int r169 = (r166 + r168) * 31;
        Set<String> r170 = this.errorWarningTypes;
        if (r170 == null) goto L82;
        int r171 = r170.hashCode();
    L83:
        int r172 = (r169 + r171) * 31;
        j r173 = this.cacheConfig;
        if (r173 == null) goto L86;
        int r174 = r173.hashCode();
    L87:
        int r175 = (r172 + r174) * 31;
        boolean r176 = this.enableParameterChecker;
        if (r176 == true) goto L91;
        r105 = r176;
    L91:
        int r177 = (r175 + r105) * 31;
        Set<String> r178 = this.checkAppScenes;
        if (r178 == null) goto L94;
        int r179 = r178.hashCode();
    L95:
        int r180 = (r177 + r179) * 31;
        t r181 = this.networkConfig;
        if (r181 == null) goto L99;
        r101 = r181.hashCode();
    L99:
        return r180 + r101;
    L94:
        r179 = 0;
        goto L95
    L86:
        r174 = 0;
        goto L87
    L82:
        r171 = 0;
        goto L83
    L78:
        r168 = 0;
        goto L79
    L71:
        r162 = 0;
        goto L72
    L64:
        r156 = 0;
        goto L65
    L60:
        r153 = 0;
        goto L61
    L56:
        r150 = 0;
        goto L57
    L52:
        r147 = 0;
        goto L53
    L48:
        r144 = 0;
        goto L49
    L44:
        r139 = 0;
        goto L45
    L40:
        r136 = 0;
        goto L41
    L36:
        r133 = 0;
        goto L37
    L32:
        r130 = 0;
        goto L33
    L28:
        r127 = 0;
        goto L29
    L24:
        r124 = 0;
        goto L25
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EnvSettings(enabled=" + this.enabled + ", alogEnabled=" + this.alogEnabled + ", , alogDuration=" + this.alogDuration + ", apiTimeOutDuration=" + this.apiTimeOutDuration + ", backgroundFreezeDuration=" + this.backgroundFreezeDuration + ", testEnvChannels=" + this.testEnvChannels + ", interestedAppOps=" + this.interestedAppOps + ", appOpsIgnoreKnownApi=" + this.appOpsIgnoreKnownApi + ", sampleRateConfig=" + this.sampleRateConfig + ", ruleInfoList=" + this.ruleInfoList + ", frequencyConfigs=" + this.frequencyConfigs + ", anchorConfigs=" + this.anchorConfigs + ", apiConfig=" + this.apiConfig + ", crpConfig=" + this.crpConfig + ", appOpsIgnoreKnownApi=" + this.appOpsIgnoreKnownApi + ", binderConfig=" + this.binderConfig + ", apiStatistics=" + this.apiStatisticsConfigs + ", customAnchor=" + this.customAnchor + ", useBizUserRegionSwitch=" + this.useBizUserRegionSwitch + ", engineType=" + this.engineType + ", errorWarningTypes=" + this.errorWarningTypes + ", apiConfig=" + this.apiConfig + ", networkConfig=" + this.networkConfig + ")";
    }

    public final boolean A() {
        return this.useBizUserRegionSwitch;
    }

    public final String B() {
        return this.version;
    }

    public final long b() {
        return this.alogDuration;
    }

    public final boolean c() {
        return this.alogEnabled;
    }

    public final int d() {
        return this.alogLevel;
    }

    public final List<AnchorInfoModel> e() {
        return this.anchorConfigs;
    }

    public final e f() {
        return this.apiConfig;
    }

    public final List<ApiStatistics> g() {
        return this.apiStatisticsConfigs;
    }

    public final long h() {
        return this.apiTimeOutDuration;
    }

    public final boolean i() {
        return this.appOpsIgnoreKnownApi;
    }

    public final long j() {
        return this.backgroundFreezeDuration;
    }

    public final g k() {
        return this.binderConfig;
    }

    public final m l() {
        return this.crpConfig;
    }

    public final boolean m() {
        return this.enableParameterChecker;
    }

    public final boolean n() {
        return this.enabled;
    }

    public final String o() {
        return this.engineType;
    }

    public final Set<String> p() {
        return this.errorWarningTypes;
    }

    public final List<p> q() {
        return this.frequencyConfigs;
    }

    public final List<Integer> r() {
        return this.interceptIgnoreApiIds;
    }

    public final List<String> s() {
        return this.interestedAppOps;
    }

    public final t t() {
        return this.networkConfig;
    }

    public final boolean u() {
        return this.optimizeTimon;
    }

    public final boolean v() {
        return this.permissionCheck;
    }

    public final boolean w() {
        return this.permissionCheckReport;
    }

    public final List<RuleInfo> x() {
        return this.ruleInfoList;
    }

    public final w y() {
        return this.sampleRateConfig;
    }

    public final List<String> z() {
        return this.testEnvChannels;
    }

    public static y a(y r310, String r311, boolean r410, boolean r411, e r412, g r413, t r414) {
        boolean r100 = r310.enabled;
        boolean r101 = r310.alogEnabled;
        long r102 = r310.alogDuration;
        int r103 = r310.alogLevel;
        boolean r104 = r310.optimizeTimon;
        long r110 = r310.apiTimeOutDuration;
        List<AnchorInfoModel> r111 = r310.anchorConfigs;
        List<String> r112 = r310.testEnvChannels;
        List<RuleInfo> r113 = r310.ruleInfoList;
        List<p> r114 = r310.frequencyConfigs;
        List<String> r105 = r310.interestedAppOps;
        w r106 = r310.sampleRateConfig;
        long r115 = r310.backgroundFreezeDuration;
        List<ApiStatistics> r107 = r310.apiStatisticsConfigs;
        List<Integer> r116 = r310.interceptIgnoreApiIds;
        m r117 = r310.crpConfig;
        boolean r118 = r310.appOpsIgnoreKnownApi;
        n r119 = r310.customAnchor;
        boolean r120 = r310.useBizUserRegionSwitch;
        String r121 = r310.engineType;
        Set<String> r122 = r310.errorWarningTypes;
        j r123 = r310.cacheConfig;
        boolean r124 = r310.enableParameterChecker;
        Set<String> r125 = r310.checkAppScenes;
        r310.getClass();
        return new y(r311, r100, r101, r410, r411, r102, r103, r104, r110, r111, r112, r113, r114, r105, r106, r115, r412, r413, r107, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r414);
    }

    public /* synthetic */ y(String r310, boolean r311, boolean r312, boolean r410, boolean r411, long r412, int r413, boolean r414, long r415, List r416, List r417, List r510, List r511, List r512, w r513, long r514, e r515, g r516, List r517, m r518, boolean r610, n r611, boolean r612, String r613, Set r614, j r615, boolean r616, t r617, int r618) {
        if ((r618 & 1) == 0) goto L5;
        String r100 = "default";
    L7:
        if ((r618 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r618 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r618 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r618 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r618 & 32) == 0) goto L25;
        long r110 = TimeUnit.HOURS.toMillis(2);
    L27:
        if ((r618 & 64) == 0) goto L29;
        int r105 = 1;
    L31:
        if ((r618 & 128) == 0) goto L33;
        boolean r111 = false;
    L35:
        if ((r618 & 256) == 0) goto L37;
        long r112 = TimeUnit.SECONDS.toMillis(6);
    L39:
        if ((r618 & 512) == 0) goto L41;
        List r113 = CollectionsKt.emptyList();
    L43:
        if ((r618 & 1024) == 0) goto L45;
        List r114 = CollectionsKt.listOf(new String[]{"snpqa_permission_test", "tools_autotest", "local_test", "autotest", "monkey", "qtp"});
    L47:
        if ((r618 & 2048) == 0) goto L49;
        List r115 = new ArrayList();
    L51:
        if ((r618 & 4096) == 0) goto L53;
        List r116 = CollectionsKt.emptyList();
    L55:
        if ((r618 & 8192) == 0) goto L57;
        List r117 = CollectionsKt.emptyList();
    L59:
        if ((r618 & 16384) == 0) goto L61;
        w r210 = new w(false, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, 2047);
    L63:
        if ((32768 & r618) == 0) goto L65;
        long r211 = TimeUnit.SECONDS.toMillis(2);
    L67:
        if ((65536 & r618) == 0) goto L69;
        e r212 = new e(null);
    L71:
        if ((131072 & r618) == 0) goto L73;
        g r213 = new g(null);
    L75:
        if ((262144 & r618) == 0) goto L77;
        List r214 = CollectionsKt.emptyList();
    L79:
        if ((524288 & r618) == 0) goto L81;
        List r215 = CollectionsKt.emptyList();
    L83:
        if ((1048576 & r618) == 0) goto L85;
        m r216 = new m(0);
    L87:
        if ((2097152 & r618) == 0) goto L89;
        boolean r217 = false;
    L91:
        if ((4194304 & r618) == 0) goto L93;
        n r218 = new n(0);
    L95:
        if ((8388608 & r618) == 0) goto L97;
        boolean r313 = false;
    L99:
        if ((16777216 & r618) == 0) goto L101;
        String r314 = "rule_engine";
    L103:
        if ((33554432 & r618) == 0) goto L105;
        Set r315 = SetsKt.mutableSetOf(new String[]{"pair_not_close", "pair_delay_close", "CustomAnchor", "no_permission"});
    L107:
        if ((67108864 & r618) == 0) goto L109;
        j r316 = new j(null);
    L111:
        if ((134217728 & r618) == 0) goto L113;
        boolean r317 = false;
    L115:
        if ((268435456 & r618) == 0) goto L117;
        LinkedHashSet r318 = new LinkedHashSet();
    L119:
        if ((r618 & 536870912) == 0) goto L121;
        t r106 = new t(null);
    L122:
        this(r100, r101, r102, r103, r104, r110, r105, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r313, r314, r315, r316, r317, r318, r106);
        return;
    L121:
        r106 = r617;
        goto L122
    L117:
        r318 = null;
        goto L119
    L113:
        r317 = r616;
        goto L115
    L109:
        r316 = r615;
        goto L111
    L105:
        r315 = r614;
        goto L107
    L101:
        r314 = r613;
        goto L103
    L97:
        r313 = r612;
        goto L99
    L93:
        r218 = r611;
        goto L95
    L89:
        r217 = r610;
        goto L91
    L85:
        r216 = r518;
        goto L87
    L81:
        r215 = null;
        goto L83
    L77:
        r214 = r517;
        goto L79
    L73:
        r213 = r516;
        goto L75
    L69:
        r212 = r515;
        goto L71
    L65:
        r211 = r514;
        goto L67
    L61:
        r210 = r513;
        goto L63
    L57:
        r117 = r512;
        goto L59
    L53:
        r116 = r511;
        goto L55
    L49:
        r115 = r510;
        goto L51
    L45:
        r114 = r417;
        goto L47
    L41:
        r113 = r416;
        goto L43
    L37:
        r112 = r415;
        goto L39
    L33:
        r111 = r414;
        goto L35
    L29:
        r105 = r413;
        goto L31
    L25:
        r110 = r412;
        goto L27
    L21:
        r104 = r411;
        goto L23
    L17:
        r103 = r410;
        goto L19
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

    public y(String r100, boolean r101, boolean r102, boolean r103, boolean r104, long r105, int r110, boolean r111, long r112, List<AnchorInfoModel> r113, List<String> r114, List<RuleInfo> r115, List<p> r116, List<String> r117, w r210, long r211, e r212, g r213, List<ApiStatistics> r214, List<Integer> r215, m r216, boolean r217, n r218, boolean r310, String r311, Set<String> r312, j r313, boolean r314, Set<String> r315, t r316) {
        this.version = r100;
        this.enabled = r101;
        this.alogEnabled = r102;
        this.permissionCheck = r103;
        this.permissionCheckReport = r104;
        this.alogDuration = r105;
        this.alogLevel = r110;
        this.optimizeTimon = r111;
        this.apiTimeOutDuration = r112;
        this.anchorConfigs = r113;
        this.testEnvChannels = r114;
        this.ruleInfoList = r115;
        this.frequencyConfigs = r116;
        this.interestedAppOps = r117;
        this.sampleRateConfig = r210;
        this.backgroundFreezeDuration = r211;
        this.apiConfig = r212;
        this.binderConfig = r213;
        this.apiStatisticsConfigs = r214;
        this.interceptIgnoreApiIds = r215;
        this.crpConfig = r216;
        this.appOpsIgnoreKnownApi = r217;
        this.customAnchor = r218;
        this.useBizUserRegionSwitch = r310;
        this.engineType = r311;
        this.errorWarningTypes = r312;
        this.cacheConfig = r313;
        this.enableParameterChecker = r314;
        this.checkAppScenes = r315;
        this.networkConfig = r316;
    }
}
