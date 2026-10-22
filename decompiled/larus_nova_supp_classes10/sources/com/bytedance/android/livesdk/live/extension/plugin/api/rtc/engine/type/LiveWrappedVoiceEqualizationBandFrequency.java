package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedVoiceEqualizationBandFrequency;", "", "", "value", "I", "Companion", "a", "VOICE_EQUALIZATION_BAND_FREQUENCY_31", "VOICE_EQUALIZATION_BAND_FREQUENCY_62", "VOICE_EQUALIZATION_BAND_FREQUENCY_125", "VOICE_EQUALIZATION_BAND_FREQUENCY_250", "VOICE_EQUALIZATION_BAND_FREQUENCY_500", "VOICE_EQUALIZATION_BAND_FREQUENCY_1K", "VOICE_EQUALIZATION_BAND_FREQUENCY_2K", "VOICE_EQUALIZATION_BAND_FREQUENCY_4K", "VOICE_EQUALIZATION_BAND_FREQUENCY_8K", "VOICE_EQUALIZATION_BAND_FREQUENCY_16K", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVoiceEqualizationBandFrequency extends Enum<LiveWrappedVoiceEqualizationBandFrequency> {
    public static final a Companion = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_125 = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_16K = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_1K = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_250 = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_2K = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_31 = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_4K = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_500 = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_62 = null;
    public static final LiveWrappedVoiceEqualizationBandFrequency VOICE_EQUALIZATION_BAND_FREQUENCY_8K = null;
    public static final /* synthetic */ LiveWrappedVoiceEqualizationBandFrequency[] a = null;
    private final int value;

    public static LiveWrappedVoiceEqualizationBandFrequency valueOf(String r1) {
        return (LiveWrappedVoiceEqualizationBandFrequency) r27.a.a(LiveWrappedVoiceEqualizationBandFrequency.class, r1);
    }

    public static LiveWrappedVoiceEqualizationBandFrequency[] values() {
        return (LiveWrappedVoiceEqualizationBandFrequency[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedVoiceEqualizationBandFrequency$a] */
    static {
        LiveWrappedVoiceEqualizationBandFrequency r1 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_31", 0, 0);
        VOICE_EQUALIZATION_BAND_FREQUENCY_31 = r1;
        LiveWrappedVoiceEqualizationBandFrequency r2 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_62", 1, 1);
        VOICE_EQUALIZATION_BAND_FREQUENCY_62 = r2;
        LiveWrappedVoiceEqualizationBandFrequency r3 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_125", 2, 2);
        VOICE_EQUALIZATION_BAND_FREQUENCY_125 = r3;
        LiveWrappedVoiceEqualizationBandFrequency r4 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_250", 3, 3);
        VOICE_EQUALIZATION_BAND_FREQUENCY_250 = r4;
        LiveWrappedVoiceEqualizationBandFrequency r5 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_500", 4, 4);
        VOICE_EQUALIZATION_BAND_FREQUENCY_500 = r5;
        LiveWrappedVoiceEqualizationBandFrequency r6 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_1K", 5, 5);
        VOICE_EQUALIZATION_BAND_FREQUENCY_1K = r6;
        LiveWrappedVoiceEqualizationBandFrequency r7 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_2K", 6, 6);
        VOICE_EQUALIZATION_BAND_FREQUENCY_2K = r7;
        LiveWrappedVoiceEqualizationBandFrequency r8 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_4K", 7, 7);
        VOICE_EQUALIZATION_BAND_FREQUENCY_4K = r8;
        LiveWrappedVoiceEqualizationBandFrequency r9 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_8K", 8, 8);
        VOICE_EQUALIZATION_BAND_FREQUENCY_8K = r9;
        LiveWrappedVoiceEqualizationBandFrequency r10 = new LiveWrappedVoiceEqualizationBandFrequency("VOICE_EQUALIZATION_BAND_FREQUENCY_16K", 9, 9);
        VOICE_EQUALIZATION_BAND_FREQUENCY_16K = r10;
        a = new LiveWrappedVoiceEqualizationBandFrequency[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVoiceEqualizationBandFrequency(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
