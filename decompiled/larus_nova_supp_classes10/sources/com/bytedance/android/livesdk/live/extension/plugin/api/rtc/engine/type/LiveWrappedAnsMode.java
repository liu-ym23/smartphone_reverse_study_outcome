package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAnsMode;", "", "", "value", "I", "Companion", "a", "ANS_MODE_DISABLE", "ANS_MODE_LOW", "ANS_MODE_MEDIUM", "ANS_MODE_HIGH", "ANS_MODE_AUTOMATIC", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAnsMode extends Enum<LiveWrappedAnsMode> {
    public static final LiveWrappedAnsMode ANS_MODE_AUTOMATIC = null;
    public static final LiveWrappedAnsMode ANS_MODE_DISABLE = null;
    public static final LiveWrappedAnsMode ANS_MODE_HIGH = null;
    public static final LiveWrappedAnsMode ANS_MODE_LOW = null;
    public static final LiveWrappedAnsMode ANS_MODE_MEDIUM = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAnsMode[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAnsMode$a] */
    static {
        LiveWrappedAnsMode r1 = new LiveWrappedAnsMode("ANS_MODE_DISABLE", 0, 0);
        ANS_MODE_DISABLE = r1;
        LiveWrappedAnsMode r2 = new LiveWrappedAnsMode("ANS_MODE_LOW", 1, 1);
        ANS_MODE_LOW = r2;
        LiveWrappedAnsMode r3 = new LiveWrappedAnsMode("ANS_MODE_MEDIUM", 2, 2);
        ANS_MODE_MEDIUM = r3;
        LiveWrappedAnsMode r4 = new LiveWrappedAnsMode("ANS_MODE_HIGH", 3, 3);
        ANS_MODE_HIGH = r4;
        LiveWrappedAnsMode r5 = new LiveWrappedAnsMode("ANS_MODE_AUTOMATIC", 4, 4);
        ANS_MODE_AUTOMATIC = r5;
        a = new LiveWrappedAnsMode[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedAnsMode valueOf(String r1) {
        return (LiveWrappedAnsMode) r27.a.a(LiveWrappedAnsMode.class, r1);
    }

    public static LiveWrappedAnsMode[] values() {
        return (LiveWrappedAnsMode[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAnsMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
