package z93;

import com.google.gson.annotations.SerializedName;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lz93/d;", "Lz93/e;", "", "useIdle", "I", "getUseIdle", "()I", "", "loadImmediateDelayTime", "Ljava/lang/Long;", "getLoadImmediateDelayTime", "()Ljava/lang/Long;", "", "invalidBySchema", "Z", "getInvalidBySchema", "()Z", "", "", "invalidByStr", "Ljava/util/List;", "getInvalidByStr", "()Ljava/util/List;", "preloadInWorkThread", "getPreloadInWorkThread", "preloadModelOnly", "getPreloadModelOnly", "", "threadStrategy", "Ljava/util/Map;", "getThreadStrategy", "()Ljava/util/Map;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends e {

    @SerializedName("invalid_by_schema")
    private final boolean invalidBySchema;

    @SerializedName("invalid_schema_contains_str")
    private final List<String> invalidByStr;

    @SerializedName("load_delay_time")
    private final Long loadImmediateDelayTime;

    @SerializedName("preload_in_work_thread")
    private final boolean preloadInWorkThread;

    @SerializedName("preload_model_only")
    private final boolean preloadModelOnly;

    @SerializedName("thread_strategy")
    private final Map<String, Integer> threadStrategy;

    @SerializedName("use_idle")
    private final int useIdle;

    public d() {
        super(null, 0, null, null, null, null, null, null, ISmModel.VERSION_0300);
        this.useIdle = 0;
        this.loadImmediateDelayTime = null;
        this.invalidBySchema = true;
        this.invalidByStr = null;
        this.preloadInWorkThread = false;
        this.preloadModelOnly = false;
        this.threadStrategy = null;
    }
}
