package nu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/settings/provider/dora/DoraGRTCConfig;", "", "<init>", "()V", "doraGRtcEnabled", "", "getDoraGRtcEnabled", "()Z", "setDoraGRtcEnabled", "(Z)V", "doraGUploadImageByRTC", "getDoraGUploadImageByRTC", "setDoraGUploadImageByRTC", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("dora_g_rtc_enabled")
    private boolean doraGRtcEnabled;

    @SerializedName("upload_file_by_rtc")
    private boolean doraGUploadImageByRTC;

    public i() {
    }

    public final boolean a() {
        return this.doraGRtcEnabled;
    }

    public final boolean b() {
        return this.doraGUploadImageByRTC;
    }
}
