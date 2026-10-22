package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedVoiceChangerType;", "", "", "value", "I", "Companion", "a", "VOICE_CHANGER_ORIGINAL", "VOICE_CHANGER_GIANT", "VOICE_CHANGER_CHIPMUNK", "VOICE_CHANGER_MINIONST", "VOICE_CHANGER_VIBRATO", "VOICE_CHANGER_ROBOT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVoiceChangerType extends Enum<LiveWrappedVoiceChangerType> {
    public static final a Companion = null;
    public static final LiveWrappedVoiceChangerType VOICE_CHANGER_CHIPMUNK = null;
    public static final LiveWrappedVoiceChangerType VOICE_CHANGER_GIANT = null;
    public static final LiveWrappedVoiceChangerType VOICE_CHANGER_MINIONST = null;
    public static final LiveWrappedVoiceChangerType VOICE_CHANGER_ORIGINAL = null;
    public static final LiveWrappedVoiceChangerType VOICE_CHANGER_ROBOT = null;
    public static final LiveWrappedVoiceChangerType VOICE_CHANGER_VIBRATO = null;
    public static final /* synthetic */ LiveWrappedVoiceChangerType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedVoiceChangerType$a] */
    static {
        LiveWrappedVoiceChangerType r1 = new LiveWrappedVoiceChangerType("VOICE_CHANGER_ORIGINAL", 0, 0);
        VOICE_CHANGER_ORIGINAL = r1;
        LiveWrappedVoiceChangerType r2 = new LiveWrappedVoiceChangerType("VOICE_CHANGER_GIANT", 1, 1);
        VOICE_CHANGER_GIANT = r2;
        LiveWrappedVoiceChangerType r3 = new LiveWrappedVoiceChangerType("VOICE_CHANGER_CHIPMUNK", 2, 2);
        VOICE_CHANGER_CHIPMUNK = r3;
        LiveWrappedVoiceChangerType r4 = new LiveWrappedVoiceChangerType("VOICE_CHANGER_MINIONST", 3, 3);
        VOICE_CHANGER_MINIONST = r4;
        LiveWrappedVoiceChangerType r5 = new LiveWrappedVoiceChangerType("VOICE_CHANGER_VIBRATO", 4, 4);
        VOICE_CHANGER_VIBRATO = r5;
        LiveWrappedVoiceChangerType r6 = new LiveWrappedVoiceChangerType("VOICE_CHANGER_ROBOT", 5, 5);
        VOICE_CHANGER_ROBOT = r6;
        a = new LiveWrappedVoiceChangerType[]{r1, r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static LiveWrappedVoiceChangerType valueOf(String r1) {
        return (LiveWrappedVoiceChangerType) r27.a.a(LiveWrappedVoiceChangerType.class, r1);
    }

    public static LiveWrappedVoiceChangerType[] values() {
        return (LiveWrappedVoiceChangerType[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVoiceChangerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
