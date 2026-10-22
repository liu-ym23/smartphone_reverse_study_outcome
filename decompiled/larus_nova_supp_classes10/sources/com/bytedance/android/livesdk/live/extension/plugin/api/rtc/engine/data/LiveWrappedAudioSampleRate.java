package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import zf2.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioSampleRate;", "", "", "value", "", "toString", "I", "Companion", "a", "AUDIO_SAMPLE_RATE_AUTO", "AUDIO_SAMPLE_RATE_8000", "AUDIO_SAMPLE_RATE_11025", "AUDIO_SAMPLE_RATE_16000", "AUDIO_SAMPLE_RATE_22050", "AUDIO_SAMPLE_RATE_24000", "AUDIO_SAMPLE_RATE_32000", "AUDIO_SAMPLE_RATE_44100", "AUDIO_SAMPLE_RATE_48000", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioSampleRate extends Enum<LiveWrappedAudioSampleRate> {
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_11025 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_16000 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_22050 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_24000 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_32000 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_44100 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_48000 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_8000 = null;
    public static final LiveWrappedAudioSampleRate AUDIO_SAMPLE_RATE_AUTO = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioSampleRate[] a = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    public static LiveWrappedAudioSampleRate valueOf(String r1) {
        return (LiveWrappedAudioSampleRate) r27.a.a(LiveWrappedAudioSampleRate.class, r1);
    }

    public static LiveWrappedAudioSampleRate[] values() {
        return (LiveWrappedAudioSampleRate[]) a.clone();
    }

    static {
        LiveWrappedAudioSampleRate r1 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_AUTO", 0, -1);
        AUDIO_SAMPLE_RATE_AUTO = r1;
        LiveWrappedAudioSampleRate r2 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_8000", 1, 8000);
        AUDIO_SAMPLE_RATE_8000 = r2;
        LiveWrappedAudioSampleRate r3 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_11025", 2, 11025);
        AUDIO_SAMPLE_RATE_11025 = r3;
        LiveWrappedAudioSampleRate r4 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_16000", 3, 16000);
        AUDIO_SAMPLE_RATE_16000 = r4;
        LiveWrappedAudioSampleRate r5 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_22050", 4, 22050);
        AUDIO_SAMPLE_RATE_22050 = r5;
        LiveWrappedAudioSampleRate r6 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_24000", 5, 24000);
        AUDIO_SAMPLE_RATE_24000 = r6;
        LiveWrappedAudioSampleRate r7 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_32000", 6, 32000);
        AUDIO_SAMPLE_RATE_32000 = r7;
        LiveWrappedAudioSampleRate r8 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_44100", 7, 44100);
        AUDIO_SAMPLE_RATE_44100 = r8;
        LiveWrappedAudioSampleRate r9 = new LiveWrappedAudioSampleRate("AUDIO_SAMPLE_RATE_48000", 8, 48000);
        AUDIO_SAMPLE_RATE_48000 = r9;
        a = new LiveWrappedAudioSampleRate[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(n.a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kAudioSampleRate48000";
    L6:
        return "kAudioSampleRate44100";
    L7:
        return "kAudioSampleRate32000";
    L8:
        return "kAudioSampleRate24000";
    L9:
        return "kAudioSampleRate22050";
    L10:
        return "kAudioSampleRate16000";
    L11:
        return "kAudioSampleRate11025";
    L12:
        return "kAudioSampleRate8000";
    L13:
        return "kAudioSampleRateAuto";
    }

    public final int value() {
        return this.value;
    }

    @JvmStatic
    public static final LiveWrappedAudioSampleRate fromId(int r5) {
        Companion.getClass();
        LiveWrappedAudioSampleRate[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        LiveWrappedAudioSampleRate r3 = r0[r2];
        if (r3.value() == r5) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r3;
    L9:
        return AUDIO_SAMPLE_RATE_AUTO;
    }

    public LiveWrappedAudioSampleRate(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
