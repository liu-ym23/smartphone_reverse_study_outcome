package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioPropertiesMode;", "", "", "value", "", "toString", "I", "Companion", "a", "AUDIO_PROPERTIES_MODE_MICROPHONE", "AUDIO_PROPERTIES_MODE_AUDIOMIXING", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioPropertiesMode extends Enum<LiveWrappedAudioPropertiesMode> {
    public static final LiveWrappedAudioPropertiesMode AUDIO_PROPERTIES_MODE_AUDIOMIXING = null;
    public static final LiveWrappedAudioPropertiesMode AUDIO_PROPERTIES_MODE_MICROPHONE = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioPropertiesMode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioPropertiesMode$a] */
    static {
        LiveWrappedAudioPropertiesMode r1 = new LiveWrappedAudioPropertiesMode("AUDIO_PROPERTIES_MODE_MICROPHONE", 0, 0);
        AUDIO_PROPERTIES_MODE_MICROPHONE = r1;
        LiveWrappedAudioPropertiesMode r2 = new LiveWrappedAudioPropertiesMode("AUDIO_PROPERTIES_MODE_AUDIOMIXING", 1, 1);
        AUDIO_PROPERTIES_MODE_AUDIOMIXING = r2;
        a = new LiveWrappedAudioPropertiesMode[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedAudioPropertiesMode valueOf(String r1) {
        return (LiveWrappedAudioPropertiesMode) r27.a.a(LiveWrappedAudioPropertiesMode.class, r1);
    }

    public static LiveWrappedAudioPropertiesMode[] values() {
        return (LiveWrappedAudioPropertiesMode[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = k.a[ordinal()];
        if (r0 != 1) goto L5;
        return "AUDIO_PROPERTIES_MODE_MICROPHONE";
    L5:
        if (r0 != 2) goto L10;
        return "AUDIO_PROPERTIES_MODE_AUDIOMIXING";
    L10:
        return "AUDIO_PROPERTIES_MODE_MICROPHONE";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioPropertiesMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
