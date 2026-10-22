package w26;

import com.amap.api.col.s.ce;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0018\"B\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087D¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000eR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lw26/h;", "", "", "logSwitch", "Z", "f", "()Z", "setLogSwitch", "(Z)V", "", "", "eventBlackList", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "setEventBlackList", "([Ljava/lang/String;)V", "eventWhiteList", "d", "setEventWhiteList", "urlWhiteList", "h", "setUrlWhiteList", "channelWhiteList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setChannelWhiteList", "", "matchRules", "Ljava/util/Map;", "getMatchRules", "()Ljava/util/Map;", "setMatchRules", "(Ljava/util/Map;)V", "containerABConfig", "b", "setContainerABConfig", "jsSdkDisallowList", "e", "webSSPReport", RXScreenCaptureService.KEY_INDEX, "setWebSSPReport", "webSSPResourceInfoReport", ce.f26395j, "setWebSSPResourceInfoReport", "Lw26/h$b;", "offlineConfigV2", "Lw26/h$b;", ce.f26391f, "()Lw26/h$b;", "setOfflineConfigV2", "(Lw26/h$b;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f558033a = null;

    @SerializedName("channel_whitelist")
    private String[] channelWhiteList;

    @SerializedName("container_ab_config")
    private Map<String, String> containerABConfig;

    @SerializedName("event_blacklist")
    private String[] eventBlackList;

    @SerializedName("event_whitelist")
    private String[] eventWhiteList;

    @SerializedName("jssdk_disallow_list")
    private final String[] jsSdkDisallowList;

    @SerializedName("log_switch")
    private boolean logSwitch;

    @SerializedName("match_rules")
    private Map<String, String> matchRules;

    @SerializedName("offline_config_v2")
    private b offlineConfigV2;

    @SerializedName("url_whitelist")
    private String[] urlWhiteList;

    @SerializedName("web_ssp_report")
    private boolean webSSPReport;

    @SerializedName("web_ssp_resource_info_report")
    private boolean webSSPResourceInfoReport;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lw26/h$b;", "", "", OperationName.OPERATION_OFFLINE_AVAILABLE, "Z", "c", "()Z", "setOffline", "(Z)V", "", "", "commonEventTypeAllowList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setCommonEventTypeAllowList", "(Ljava/util/List;)V", "customEventNameAllowList", "b", "setCustomEventNameAllowList", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("common_event_type_allow_list")
        private List<String> commonEventTypeAllowList;

        @SerializedName("custom_event_name_allow_list")
        private List<String> customEventNameAllowList;

        @SerializedName(OperationName.OPERATION_OFFLINE_AVAILABLE)
        private boolean offline;

        public b() {
            this.commonEventTypeAllowList = new ArrayList();
            this.customEventNameAllowList = new ArrayList();
        }

        public final List<String> a() {
            return this.commonEventTypeAllowList;
        }

        public final List<String> b() {
            return this.customEventNameAllowList;
        }

        public final boolean c() {
            return this.offline;
        }
    }

    static {
        f558033a = new h();
    }

    public h() {
        this.logSwitch = true;
        this.eventBlackList = new String[0];
        this.eventWhiteList = new String[0];
        this.urlWhiteList = new String[0];
        this.channelWhiteList = new String[0];
        this.matchRules = new LinkedHashMap();
        this.containerABConfig = new LinkedHashMap();
        this.jsSdkDisallowList = new String[0];
        this.webSSPReport = true;
        this.webSSPResourceInfoReport = true;
        this.offlineConfigV2 = new b();
    }

    public final String[] a() {
        return this.channelWhiteList;
    }

    public final Map<String, String> b() {
        return this.containerABConfig;
    }

    public final String[] c() {
        return this.eventBlackList;
    }

    public final String[] d() {
        return this.eventWhiteList;
    }

    public final String[] e() {
        return this.jsSdkDisallowList;
    }

    public final boolean f() {
        return this.logSwitch;
    }

    public final b g() {
        return this.offlineConfigV2;
    }

    public final String[] h() {
        return this.urlWhiteList;
    }

    public final boolean i() {
        return this.webSSPReport;
    }

    public final boolean j() {
        return this.webSSPResourceInfoReport;
    }
}
