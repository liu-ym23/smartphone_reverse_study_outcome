package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioCodecType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioProfile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public LiveWrappedMixedStreamAudioCodecType a;
    public int b;
    public int c;
    public int d;
    public LiveWrappedMixedStreamAudioProfile e;

    public final String toString() {
        return "LiveWrappedMixedStreamAudioConfig{audioProfile='" + this.e + "', channels=" + this.d + ", sampleRate=" + this.c + ", bitrate=" + this.b + ", audioCodec=" + this.a + '}';
    }

    public c() {
        this.a = LiveWrappedMixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
        this.b = 64;
        this.c = 48000;
        this.d = 2;
        this.e = LiveWrappedMixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
    }
}
