package ym0;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u0019\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r¨\u0006\u001d"}, d2 = {"Lym0/a;", "", "", ShortVideoSegments.KEY_CAMERA_ID, "J", "b", "()J", "streamId", "f", "", "switchingText", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "switchSuccessToast", ce.f26391f, "", "cameraScene", "I", "c", "()I", "cameraType", "d", "animationUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "logPb", "e", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("animation_url")
    private final String animationUrl;

    @SerializedName(VSConstants.VS_CAMERA_ID)
    private final long cameraId;

    @SerializedName("camera_scene")
    private final int cameraScene;

    @SerializedName("camera_type")
    private final int cameraType;

    @SerializedName("log_pb")
    private final String logPb;

    @SerializedName("stream_id")
    private final long streamId;

    @SerializedName("switch_succ_toast")
    private final String switchSuccessToast;

    @SerializedName("loading_text")
    private final String switchingText;

    public final String toString() {
        return "CameraInfo(cameraId=" + this.cameraId + ", streamId=" + this.streamId + ", switchingText=" + this.switchingText + ", switchSuccessToast=" + this.switchSuccessToast + ", cameraScene=" + this.cameraScene + ", cameraType=" + this.cameraType + ", animationUrl=" + this.animationUrl + ",logPb=" + this.logPb + ')';
    }

    public a() {
        this.logPb = "";
    }

    public final String a() {
        return this.animationUrl;
    }

    public final long b() {
        return this.cameraId;
    }

    public final int c() {
        return this.cameraScene;
    }

    public final int d() {
        return this.cameraType;
    }

    public final String e() {
        return this.logPb;
    }

    public final long f() {
        return this.streamId;
    }

    public final String g() {
        return this.switchSuccessToast;
    }

    public final String h() {
        return this.switchingText;
    }
}
