package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioPropertiesMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioReportMode;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveWrappedAudioReportMode f571722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveWrappedAudioPropertiesMode f571723e;

    public final String toString() {
        return "AudioPropertiesConfig{interval='" + this.f571719a + "'enable_spectrum='" + this.f571720b + "'enable_vad='" + this.f571721c + "'local_main_report_mode='" + this.f571722d + "'audio_report_mode='" + String.valueOf(this.f571723e) + "'enable_voice_pitch='false'}";
    }

    public j(int r100) {
        this.f571722d = LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        LiveWrappedAudioPropertiesMode r101 = LiveWrappedAudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.f571723e = r101;
        this.f571719a = r100;
        this.f571720b = false;
        this.f571721c = false;
        this.f571723e = r101;
    }
}
