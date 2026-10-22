package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioMixingDualMonoMode;", "", "", "value", "", "toString", "I", "Companion", "a", "AUDIO_MIXING_DUAL_MONO_MODE_AUTO", "AUDIO_MIXING_DUAL_MONO_MODE_L", "AUDIO_MIXING_DUAL_MONO_MODE_R", "AUDIO_MIXING_DUAL_MONO_MODE_MIX", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioMixingDualMonoMode extends Enum<LiveWrappedAudioMixingDualMonoMode> {
    public static final LiveWrappedAudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_AUTO = null;
    public static final LiveWrappedAudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_L = null;
    public static final LiveWrappedAudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_MIX = null;
    public static final LiveWrappedAudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_R = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioMixingDualMonoMode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioMixingDualMonoMode$a] */
    static {
        LiveWrappedAudioMixingDualMonoMode r1 = new LiveWrappedAudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_AUTO", 0, 0);
        AUDIO_MIXING_DUAL_MONO_MODE_AUTO = r1;
        LiveWrappedAudioMixingDualMonoMode r2 = new LiveWrappedAudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_L", 1, 1);
        AUDIO_MIXING_DUAL_MONO_MODE_L = r2;
        LiveWrappedAudioMixingDualMonoMode r3 = new LiveWrappedAudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_R", 2, 2);
        AUDIO_MIXING_DUAL_MONO_MODE_R = r3;
        LiveWrappedAudioMixingDualMonoMode r4 = new LiveWrappedAudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_MIX", 3, 3);
        AUDIO_MIXING_DUAL_MONO_MODE_MIX = r4;
        a = new LiveWrappedAudioMixingDualMonoMode[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedAudioMixingDualMonoMode valueOf(String r1) {
        return (LiveWrappedAudioMixingDualMonoMode) r27.a.a(LiveWrappedAudioMixingDualMonoMode.class, r1);
    }

    public static LiveWrappedAudioMixingDualMonoMode[] values() {
        return (LiveWrappedAudioMixingDualMonoMode[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = g.a[ordinal()];
        if (r0 != 1) goto L5;
        return "AUDIO_MIXING_DUAL_MONO_MODE_AUTO";
    L5:
        if (r0 != 2) goto L7;
        return "AUDIO_MIXING_DUAL_MONO_MODE_L";
    L7:
        if (r0 != 3) goto L9;
        return "AUDIO_MIXING_DUAL_MONO_MODE_R";
    L9:
        if (r0 == 4) goto L11;
        return "";
    L11:
        return "AUDIO_MIXING_DUAL_MONO_MODE_MIX";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioMixingDualMonoMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
