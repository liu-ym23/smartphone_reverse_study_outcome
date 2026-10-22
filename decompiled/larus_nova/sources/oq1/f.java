package oq1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Loq1/f;", "", "", "videoDefaultResolutionWifi", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setVideoDefaultResolutionWifi", "(Ljava/lang/String;)V", "videoDefaultResolutionNet", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setVideoDefaultResolutionNet", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("video_default_resolution_net")
    private String videoDefaultResolutionNet;

    @SerializedName("video_default_resolution_wifi")
    private String videoDefaultResolutionWifi;

    public f() {
        this.videoDefaultResolutionWifi = "720p";
        this.videoDefaultResolutionNet = "720p";
    }

    public final String a() {
        return this.videoDefaultResolutionNet;
    }

    public final String b() {
        return this.videoDefaultResolutionWifi;
    }
}
