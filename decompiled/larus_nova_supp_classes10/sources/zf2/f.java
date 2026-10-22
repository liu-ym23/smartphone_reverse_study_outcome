package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public final LiveWrappedAudioSampleRate a;
    public final LiveWrappedAudioChannel b;
    public final int c;

    public final String toString() {
        return "AudioFormat{sampleRate='" + this.a + "', channel='" + this.b + "', samplesPerCall=" + this.c + '}';
    }

    public f(LiveWrappedAudioSampleRate r2, LiveWrappedAudioChannel r3) {
        Intrinsics.checkNotNullParameter(r2, "sampleRate");
        Intrinsics.checkNotNullParameter(r3, "channel");
        this.a = LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_AUTO;
        this.b = LiveWrappedAudioChannel.AUDIO_CHANNEL_AUTO;
        this.a = r2;
        this.b = r3;
        this.c = 0;
    }
}
