package t5;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/settings/provider/ResourcesManagerConfig;", "", "<init>", "()V", "packageDownloadType", "", "getPackageDownloadType", "()I", "geckoHostVersion", "getGeckoHostVersion", "requestWhiteList", "", "", "getRequestWhiteList", "()Ljava/util/List;", "customDownloadPackageList", "getCustomDownloadPackageList", "firstAppPackageList", "getFirstAppPackageList", "updateInterval", "", "getUpdateInterval", "()J", "offlineFileVersion", "getOfflineFileVersion", "forceUpdateChannel", "getForceUpdateChannel", "workerOptimized", "getWorkerOptimized", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("custom_download_package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> customDownloadPackageList;

    @SerializedName("first_application_package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> firstAppPackageList;

    @SerializedName("force_update_channel")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> forceUpdateChannel;

    @SerializedName("gecko_host_version")
    private final int geckoHostVersion;

    @SerializedName("offline_file_version")
    private final int offlineFileVersion;

    @SerializedName("package_download_type")
    private final int packageDownloadType;

    @SerializedName("request_white_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> requestWhiteList;

    @SerializedName("update_interval")
    private final long updateInterval;

    @SerializedName("worker_optimized")
    private final int workerOptimized;

    public p() {
        this.requestWhiteList = CollectionsKt.listOf(new String[]{"https://api.coze.cn/open_api/v2/chat", "https://api.coze.cn/v3/chat", "https://api.coze.cn/v1/workflow/run", "https://api.coze.cn/v1/workflow/stream_run", "https://www.coze.cn/api/card_builder/agent/api_trigger", "https://www.coze.cn/api/card_builder/agent/coze_api_trigger", "https://bot-open-api.bytedance.net/v1/workflow/run", "https://bots.bytedance.net/api/card_builder/agent/api_trigger"});
        this.customDownloadPackageList = CollectionsKt.listOf(new String[]{"com.flow.calendar", "com.flow.remind.o", "com.obric.map", "com.obric.news", "com.obric.exchange", "com.doubao.react-lynx-template", "com.flow.music.auth", "db_1JOlsY6", "db_1GFLTGc"});
        this.firstAppPackageList = CollectionsKt.listOf(new String[]{"com.flow.calendar", "com.flow.remind.o", "com.obric.map", "com.obric.news", "com.obric.exchange"});
        this.updateInterval = 300000;
        this.offlineFileVersion = 1;
        this.forceUpdateChannel = CollectionsKt.listOf(new String[]{"com_flow_music_auth", "com_flow_podcast", "com_flow_music", "com_flow_news", "com_flow_news_knowledge_graph", "com_flow_locallife", "com_flow_locallife_home", "com_flow_remind", "com_flow_note", "com_flow_shorthand", "com_flow_lotus"});
        this.workerOptimized = 1;
    }

    public final List<String> a() {
        return this.customDownloadPackageList;
    }

    public final List<String> b() {
        return this.firstAppPackageList;
    }

    public final List<String> c() {
        return this.forceUpdateChannel;
    }

    public final int d() {
        return this.geckoHostVersion;
    }

    public final int e() {
        return this.offlineFileVersion;
    }

    public final int f() {
        return this.packageDownloadType;
    }

    public final List<String> g() {
        return this.requestWhiteList;
    }

    public final long h() {
        return this.updateInterval;
    }

    public final int i() {
        return this.workerOptimized;
    }
}
