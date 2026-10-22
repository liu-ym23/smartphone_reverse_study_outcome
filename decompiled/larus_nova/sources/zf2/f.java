package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedAudioSampleRate f571711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveWrappedAudioChannel f571712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571713c;

    public final String toString() {
        return "AudioFormat{sampleRate='" + this.f571711a + "', channel='" + this.f571712b + "', samplesPerCall=" + this.f571713c + '}';
    }

    public f(LiveWrappedAudioSampleRate r100, LiveWrappedAudioChannel r101) {
        Intrinsics.checkNotNullParameter(r100, "sampleRate");
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f571711a = LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_AUTO;
        this.f571712b = LiveWrappedAudioChannel.AUDIO_CHANNEL_AUTO;
        this.f571711a = r100;
        this.f571712b = r101;
        this.f571713c = 0;
    }
}
