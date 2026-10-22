package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioPropertiesMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioReportMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final LiveWrappedAudioReportMode d;
    public final LiveWrappedAudioPropertiesMode e;

    public final String toString() {
        return "AudioPropertiesConfig{interval='" + this.a + "'enable_spectrum='" + this.b + "'enable_vad='" + this.c + "'local_main_report_mode='" + this.d + "'audio_report_mode='" + String.valueOf(this.e) + "'enable_voice_pitch='false'}";
    }

    public j(int r2) {
        this.d = LiveWrappedAudioReportMode.AUDIO_REPORT_MODE_NORMAL;
        LiveWrappedAudioPropertiesMode r0 = LiveWrappedAudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE;
        this.e = r0;
        this.a = r2;
        this.b = false;
        this.c = false;
        this.e = r0;
    }
}
