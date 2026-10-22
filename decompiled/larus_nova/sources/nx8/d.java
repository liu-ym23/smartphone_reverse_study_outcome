package nx8;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0000R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/EduCustomConfig;", "", "imageCompressQuality", "", "cloudDetectionTimeoutMs", "", "localOrientationSwitcher", "imageReportSampleRate", "", "<init>", "(IJIF)V", "getImageCompressQuality", "()I", "setImageCompressQuality", "(I)V", "getCloudDetectionTimeoutMs", "()J", "setCloudDetectionTimeoutMs", "(J)V", "getLocalOrientationSwitcher", "setLocalOrientationSwitcher", "getImageReportSampleRate", "()F", "setImageReportSampleRate", "(F)V", "update", "", "other", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("cloud_detection_timeout_ms")
    private long cloudDetectionTimeoutMs;

    @SerializedName(FrescoMonitorConst.IMAGE_QUALITY)
    private int imageCompressQuality;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT)
    private float imageReportSampleRate;

    @SerializedName("local_orientation_switch")
    private int localOrientationSwitcher;

    public d() {
        this(0);
    }

    public final long a() {
        return this.cloudDetectionTimeoutMs;
    }

    public final int b() {
        return this.imageCompressQuality;
    }

    public /* synthetic */ d(int r100) {
        this(70, 800, 1, 0.0f);
    }

    public final void update(d r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = r100.imageCompressQuality;
        boolean r102 = false;
        if (1 <= r101) goto L5;
    L7:
        if (r102 == false) goto L9;
        this.imageCompressQuality = r101;
    L9:
        long r103 = r100.cloudDetectionTimeoutMs;
        if (r103 <= 0) goto L12;
        this.cloudDetectionTimeoutMs = r103;
    L12:
        this.localOrientationSwitcher = r100.localOrientationSwitcher;
        this.imageReportSampleRate = r100.imageReportSampleRate;
        return;
    L5:
        if (r101 >= 101) goto L7;
        r102 = true;
        goto L7
    }

    public d(int r100, long r101, int r102, float r103) {
        this.imageCompressQuality = r100;
        this.cloudDetectionTimeoutMs = r101;
        this.localOrientationSwitcher = r102;
        this.imageReportSampleRate = r103;
    }
}
