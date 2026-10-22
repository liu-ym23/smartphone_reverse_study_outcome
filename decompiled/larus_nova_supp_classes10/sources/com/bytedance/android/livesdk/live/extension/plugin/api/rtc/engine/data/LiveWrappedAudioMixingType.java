package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioMixingType;", "", "", "value", "", "toString", "I", "Companion", "a", "AUDIO_MIXING_TYPE_PLAYOUT", "AUDIO_MIXING_TYPE_PUBLISH", "AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioMixingType extends Enum<LiveWrappedAudioMixingType> {
    public static final LiveWrappedAudioMixingType AUDIO_MIXING_TYPE_PLAYOUT = null;
    public static final LiveWrappedAudioMixingType AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH = null;
    public static final LiveWrappedAudioMixingType AUDIO_MIXING_TYPE_PUBLISH = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioMixingType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioMixingType$a] */
    static {
        LiveWrappedAudioMixingType r1 = new LiveWrappedAudioMixingType("AUDIO_MIXING_TYPE_PLAYOUT", 0, 0);
        AUDIO_MIXING_TYPE_PLAYOUT = r1;
        LiveWrappedAudioMixingType r2 = new LiveWrappedAudioMixingType("AUDIO_MIXING_TYPE_PUBLISH", 1, 1);
        AUDIO_MIXING_TYPE_PUBLISH = r2;
        LiveWrappedAudioMixingType r3 = new LiveWrappedAudioMixingType("AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH", 2, 2);
        AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH = r3;
        a = new LiveWrappedAudioMixingType[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedAudioMixingType valueOf(String r1) {
        return (LiveWrappedAudioMixingType) r27.a.a(LiveWrappedAudioMixingType.class, r1);
    }

    public static LiveWrappedAudioMixingType[] values() {
        return (LiveWrappedAudioMixingType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = h.a[ordinal()];
        if (r0 != 1) goto L5;
        return "AUDIO_MIXING_TYPE_PLAYOUT";
    L5:
        if (r0 != 2) goto L7;
        return "AUDIO_MIXING_TYPE_PUBLISH";
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioMixingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
