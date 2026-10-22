package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lls1/t;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "maxConcurrentTasks", "I", "getMaxConcurrentTasks", "()I", "maxQueueSize", "getMaxQueueSize", "maxTextCount", "getMaxTextCount", "enableDynamicSkip", "getEnableDynamicSkip", "", "", "", "devicePerfThresholds", "Ljava/util/Map;", "getDevicePerfThresholds", "()Ljava/util/Map;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("device_performance_thresholds")
    private final Map<String, Double> devicePerfThresholds;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_dynamic_skip")
    private final boolean enableDynamicSkip;

    @SerializedName("max_current_tasks")
    private final int maxConcurrentTasks;

    @SerializedName("max_queue_size")
    private final int maxQueueSize;

    @SerializedName("max_text_count")
    private final int maxTextCount;

    public t() {
        this.maxConcurrentTasks = 1;
        this.maxQueueSize = 1;
        this.maxTextCount = 1;
        this.enableDynamicSkip = true;
        this.devicePerfThresholds = new HashMap();
    }
}
