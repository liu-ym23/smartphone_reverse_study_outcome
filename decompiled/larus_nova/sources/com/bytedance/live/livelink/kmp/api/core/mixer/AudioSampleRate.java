package com.bytedance.live.livelink.kmp.api.core.mixer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/AudioSampleRate;", "", "SAMPLE_RATE_16K", "SAMPLE_RATE_32K", "SAMPLE_RATE_44K", "SAMPLE_RATE_48K", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioSampleRate extends Enum<AudioSampleRate> {
    public static final AudioSampleRate SAMPLE_RATE_16K = null;
    public static final AudioSampleRate SAMPLE_RATE_32K = null;
    public static final AudioSampleRate SAMPLE_RATE_44K = null;
    public static final AudioSampleRate SAMPLE_RATE_48K = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioSampleRate[] f255232a = null;

    static {
        AudioSampleRate r100 = new AudioSampleRate("SAMPLE_RATE_16K", 0);
        SAMPLE_RATE_16K = r100;
        AudioSampleRate r101 = new AudioSampleRate("SAMPLE_RATE_32K", 1);
        SAMPLE_RATE_32K = r101;
        AudioSampleRate r102 = new AudioSampleRate("SAMPLE_RATE_44K", 2);
        SAMPLE_RATE_44K = r102;
        AudioSampleRate r103 = new AudioSampleRate("SAMPLE_RATE_48K", 3);
        SAMPLE_RATE_48K = r103;
        f255232a = new AudioSampleRate[]{r100, r101, r102, r103};
    }

    public static AudioSampleRate valueOf(String r100) {
        return (AudioSampleRate) a.a(AudioSampleRate.class, r100);
    }

    public static AudioSampleRate[] values() {
        return (AudioSampleRate[]) f255232a.clone();
    }

    public AudioSampleRate(String r100, int r101) {
        super(r100, r101);
    }
}
