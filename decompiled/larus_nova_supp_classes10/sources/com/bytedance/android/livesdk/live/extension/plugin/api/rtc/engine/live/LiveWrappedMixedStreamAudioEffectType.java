package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamAudioEffectType;", "", "", "value", "", "toString", LocationMonitorConst.TYPE, "I", "MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE", "MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamAudioEffectType extends Enum<LiveWrappedMixedStreamAudioEffectType> {
    public static final LiveWrappedMixedStreamAudioEffectType MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE = null;
    public static final LiveWrappedMixedStreamAudioEffectType MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE = null;
    public static final /* synthetic */ LiveWrappedMixedStreamAudioEffectType[] a = null;
    private final int type;

    static {
        LiveWrappedMixedStreamAudioEffectType r1 = new LiveWrappedMixedStreamAudioEffectType("MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE", 0, 0);
        MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE = r1;
        LiveWrappedMixedStreamAudioEffectType r2 = new LiveWrappedMixedStreamAudioEffectType("MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE", 1, 1);
        MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE = r2;
        a = new LiveWrappedMixedStreamAudioEffectType[]{r1, r2};
    }

    public static LiveWrappedMixedStreamAudioEffectType valueOf(String r1) {
        return (LiveWrappedMixedStreamAudioEffectType) a.a(LiveWrappedMixedStreamAudioEffectType.class, r1);
    }

    public static LiveWrappedMixedStreamAudioEffectType[] values() {
        return (LiveWrappedMixedStreamAudioEffectType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this.type != 0) goto L6;
        return "MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE";
    L6:
        return "MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE";
    }

    public final int value() {
        return this.type;
    }

    public LiveWrappedMixedStreamAudioEffectType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
