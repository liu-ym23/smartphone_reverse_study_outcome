package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$¨\u0006-"}, d2 = {"Lrc/o;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "appLogEnable", "getAppLogEnable", "setAppLogEnable", "slardarMonitorEnable", "getSlardarMonitorEnable", "setSlardarMonitorEnable", "", "", "events", "Ljava/util/List;", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "Lrc/p;", "patterns", "getPatterns", "setPatterns", "globalWhiteParams", "getGlobalWhiteParams", "setGlobalWhiteParams", "", "maxStoreCountEachPage", "I", "getMaxStoreCountEachPage", "()I", "setMaxStoreCountEachPage", "(I)V", "maxMatchCount", "getMaxMatchCount", "setMaxMatchCount", "maxAppLogCount", "getMaxAppLogCount", "setMaxAppLogCount", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class o {

    @SerializedName("app_log_enable")
    private boolean appLogEnable;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("events")
    private List<String> events;

    @SerializedName("global_white_params")
    private List<String> globalWhiteParams;

    @SerializedName("max_app_log_count")
    private int maxAppLogCount;

    @SerializedName("max_match_count")
    private int maxMatchCount;

    @SerializedName("max_store_count_each_page")
    private int maxStoreCountEachPage;

    @SerializedName("patterns")
    private List<p> patterns;

    @SerializedName("slardar_monitor_enable")
    private boolean slardarMonitorEnable;

    public o() {
        this.appLogEnable = true;
        this.slardarMonitorEnable = true;
        this.events = new ArrayList();
        this.patterns = new ArrayList();
        this.globalWhiteParams = new ArrayList();
        this.maxStoreCountEachPage = 200;
        this.maxMatchCount = 50;
        this.maxAppLogCount = 5;
    }
}
