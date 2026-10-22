package ls1;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b=\u0010>R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010R\u001a\u00102\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\u0010R\u001a\u00105\u001a\u0002048\u0006X\u0087D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010R\u001a\u0010;\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b;\u0010\u000e\u001a\u0004\b<\u0010\u0010¨\u0006?"}, d2 = {"Lls1/u;", "", "", "enableDynamicSkip", "Z", "getEnableDynamicSkip", "()Z", "setEnableDynamicSkip", "(Z)V", "enableSimilarImageSkip", "getEnableSimilarImageSkip", "setEnableSimilarImageSkip", "", "imageHashTolerance", "I", "getImageHashTolerance", "()I", "setImageHashTolerance", "(I)V", "", "", "", "devicePerfThresholds", "Ljava/util/Map;", "getDevicePerfThresholds", "()Ljava/util/Map;", "pitayaAbParams", "getPitayaAbParams", "setPitayaAbParams", "(Ljava/util/Map;)V", "enable", "getEnable", "setEnable", "enableSaveImage", "getEnableSaveImage", "predictIntervalMs", "getPredictIntervalMs", "setPredictIntervalMs", "", "liveModeList", "Ljava/util/List;", "getLiveModeList", "()Ljava/util/List;", "setLiveModeList", "(Ljava/util/List;)V", "enableReleaseResource", "getEnableReleaseResource", "setEnableReleaseResource", "imageHeight", "getImageHeight", "imageWidth", "getImageWidth", "", "imageCompressRate", FaceService.girlLabel, "getImageCompressRate", "()F", "maxConcurrentDetectTasks", "getMaxConcurrentDetectTasks", "maxDetectQueueSize", "getMaxDetectQueueSize", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("device_performance_thresholds")
    private final Map<String, Double> devicePerfThresholds;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_dynamic_skip_task")
    private boolean enableDynamicSkip;

    @SerializedName("enable_release_resource")
    private boolean enableReleaseResource;

    @SerializedName("enable_save_image")
    private final boolean enableSaveImage;

    @SerializedName("enable_similar_image_skip_task")
    private boolean enableSimilarImageSkip;

    @SerializedName("image_compress_rate")
    private final float imageCompressRate;

    @SerializedName("image_hash_tolerance")
    private int imageHashTolerance;

    @SerializedName("image_height")
    private final int imageHeight;

    @SerializedName("image_width")
    private final int imageWidth;

    @SerializedName("live_type")
    private List<String> liveModeList;

    @SerializedName("max_concurrent_detect_tasks")
    private final int maxConcurrentDetectTasks;

    @SerializedName("max_detect_queue_size")
    private final int maxDetectQueueSize;

    @SerializedName("pitaya_ab_params")
    private Map<String, ? extends Object> pitayaAbParams;

    @SerializedName("predict_interval")
    private int predictIntervalMs;

    public u() {
        this.imageHashTolerance = 5;
        this.devicePerfThresholds = new HashMap();
        this.pitayaAbParams = new HashMap();
        this.predictIntervalMs = 2000;
        this.liveModeList = CollectionsKt.arrayListOf(new String[]{"video_live"});
        this.enableReleaseResource = true;
        this.imageHeight = 640;
        this.imageWidth = 360;
        this.imageCompressRate = 0.9f;
        this.maxConcurrentDetectTasks = 1;
        this.maxDetectQueueSize = 2;
    }
}
