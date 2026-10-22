package ls1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lls1/a;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "captureImageIntervalMs", "I", "getCaptureImageIntervalMs", "()I", "setCaptureImageIntervalMs", "(I)V", "enableDodgeEcomLiveCapture", "getEnableDodgeEcomLiveCapture", "setEnableDodgeEcomLiveCapture", "", "dodgeEcomLiveCaptureInterval", "J", "getDodgeEcomLiveCaptureInterval", "()J", "setDodgeEcomLiveCaptureInterval", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("capture_image_interval")
    private int captureImageIntervalMs;

    @SerializedName("dodge_ecom_live_capture_interval")
    private long dodgeEcomLiveCaptureInterval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_dodge_ecom_live_capture")
    private boolean enableDodgeEcomLiveCapture;

    public a() {
        this.enable = true;
        this.captureImageIntervalMs = 500;
        this.enableDodgeEcomLiveCapture = true;
        this.dodgeEcomLiveCaptureInterval = 10000;
    }
}
