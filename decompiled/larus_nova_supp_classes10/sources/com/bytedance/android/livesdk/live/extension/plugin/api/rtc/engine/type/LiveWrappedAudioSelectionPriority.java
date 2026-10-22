package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioSelectionPriority;", "", "", "value", "I", "Companion", "a", "AUDIO_SELECTION_PRIORITY_NORMAL", "AUDIO_SELECTION_PRIORITY_HIGIH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioSelectionPriority extends Enum<LiveWrappedAudioSelectionPriority> {
    public static final LiveWrappedAudioSelectionPriority AUDIO_SELECTION_PRIORITY_HIGIH = null;
    public static final LiveWrappedAudioSelectionPriority AUDIO_SELECTION_PRIORITY_NORMAL = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioSelectionPriority[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioSelectionPriority$a] */
    static {
        LiveWrappedAudioSelectionPriority r1 = new LiveWrappedAudioSelectionPriority("AUDIO_SELECTION_PRIORITY_NORMAL", 0, 0);
        AUDIO_SELECTION_PRIORITY_NORMAL = r1;
        LiveWrappedAudioSelectionPriority r2 = new LiveWrappedAudioSelectionPriority("AUDIO_SELECTION_PRIORITY_HIGIH", 1, 1);
        AUDIO_SELECTION_PRIORITY_HIGIH = r2;
        a = new LiveWrappedAudioSelectionPriority[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedAudioSelectionPriority valueOf(String r1) {
        return (LiveWrappedAudioSelectionPriority) r27.a.a(LiveWrappedAudioSelectionPriority.class, r1);
    }

    public static LiveWrappedAudioSelectionPriority[] values() {
        return (LiveWrappedAudioSelectionPriority[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioSelectionPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
