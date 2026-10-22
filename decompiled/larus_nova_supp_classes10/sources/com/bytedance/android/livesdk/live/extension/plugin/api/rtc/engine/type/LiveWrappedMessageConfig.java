package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedMessageConfig;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", "a", "RELIABLE_ORDERED", "UNRELIABLE_ORDERED", "UNRELIABLE_UNORDERED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMessageConfig extends Enum<LiveWrappedMessageConfig> {
    public static final a Companion = null;
    public static final LiveWrappedMessageConfig RELIABLE_ORDERED = null;
    public static final LiveWrappedMessageConfig UNRELIABLE_ORDERED = null;
    public static final LiveWrappedMessageConfig UNRELIABLE_UNORDERED = null;
    public static final /* synthetic */ LiveWrappedMessageConfig[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMessageConfig$a] */
    static {
        LiveWrappedMessageConfig r1 = new LiveWrappedMessageConfig("RELIABLE_ORDERED", 0, 0);
        RELIABLE_ORDERED = r1;
        LiveWrappedMessageConfig r2 = new LiveWrappedMessageConfig("UNRELIABLE_ORDERED", 1, 1);
        UNRELIABLE_ORDERED = r2;
        LiveWrappedMessageConfig r3 = new LiveWrappedMessageConfig("UNRELIABLE_UNORDERED", 2, 2);
        UNRELIABLE_UNORDERED = r3;
        a = new LiveWrappedMessageConfig[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedMessageConfig valueOf(String r1) {
        return (LiveWrappedMessageConfig) r27.a.a(LiveWrappedMessageConfig.class, r1);
    }

    public static LiveWrappedMessageConfig[] values() {
        return (LiveWrappedMessageConfig[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LiveWrappedMessageConfig(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
