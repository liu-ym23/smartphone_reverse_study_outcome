package tv;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Ltv/c;", "", "", "enableRTCMulti", "Z", "getEnableRTCMulti", "()Z", "muteAudioPlayback", "getMuteAudioPlayback", "enableAudioFrame", "getEnableAudioFrame", "enableVideoFrame", "getEnableVideoFrame", "enableExternalRender", "getEnableExternalRender", "enablePureCheck", "getEnablePureCheck", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("enable_audio_frame")
    private final boolean enableAudioFrame;

    @SerializedName("enable_external_render")
    private final boolean enableExternalRender;

    @SerializedName("enable_pure_check")
    private final boolean enablePureCheck;

    @SerializedName("enable_rtc_multi")
    private final boolean enableRTCMulti;

    @SerializedName("enable_video_frame")
    private final boolean enableVideoFrame;

    @SerializedName("mute_audio_play_back")
    private final boolean muteAudioPlayback;

    public final String toString() {
        return "Config(enableRTCMulti=" + this.enableRTCMulti + ", muteAudioPlayback=" + this.muteAudioPlayback + ", enableAudioFrame=" + this.enableAudioFrame + ", enableVideoFrame=" + this.enableVideoFrame + ", enableExternalRender=" + this.enableExternalRender + ", enablePureCheck=" + this.enablePureCheck + ")";
    }

    public c() {
        this.enableRTCMulti = false;
        this.muteAudioPlayback = false;
        this.enableAudioFrame = false;
        this.enableVideoFrame = false;
        this.enableExternalRender = false;
        this.enablePureCheck = false;
    }
}
