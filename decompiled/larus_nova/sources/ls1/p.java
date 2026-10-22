package ls1;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lls1/p;", "", "", "predictEnable", "Z", "getPredictEnable", "()Z", "setPredictEnable", "(Z)V", "", "predictMode", "I", "getPredictMode", "()I", "setPredictMode", "(I)V", "reportEnable", "getReportEnable", "setReportEnable", "", "reportThreshold", FaceService.girlLabel, "getReportThreshold", "()F", "setReportThreshold", "(F)V", "predictInterval", "getPredictInterval", "setPredictInterval", "appLogRunEventEnable", "getAppLogRunEventEnable", "setAppLogRunEventEnable", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("applog_run_event_enable")
    private boolean appLogRunEventEnable;

    @SerializedName("predict_enable")
    private boolean predictEnable;

    @SerializedName("predict_interval")
    private float predictInterval;

    @SerializedName("predict_mode")
    private int predictMode;

    @SerializedName("report_enable")
    private boolean reportEnable;

    @SerializedName("report_threshold")
    private float reportThreshold;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public p() {
        this.predictMode = 1;
        this.reportThreshold = 0.01f;
        this.predictInterval = 5.0f;
    }
}
