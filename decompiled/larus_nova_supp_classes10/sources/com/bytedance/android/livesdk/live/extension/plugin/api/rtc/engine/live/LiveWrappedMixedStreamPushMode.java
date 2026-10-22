package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamPushMode;", "", "", "<set-?>", "value", "I", "getValue", "()I", "ON_STREAM", "ON_START_REQUEST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamPushMode extends Enum<LiveWrappedMixedStreamPushMode> {
    public static final LiveWrappedMixedStreamPushMode ON_START_REQUEST = null;
    public static final LiveWrappedMixedStreamPushMode ON_STREAM = null;
    public static final /* synthetic */ LiveWrappedMixedStreamPushMode[] a = null;
    private int value;

    static {
        LiveWrappedMixedStreamPushMode r1 = new LiveWrappedMixedStreamPushMode("ON_STREAM", 0, 0);
        ON_STREAM = r1;
        LiveWrappedMixedStreamPushMode r2 = new LiveWrappedMixedStreamPushMode("ON_START_REQUEST", 1, 1);
        ON_START_REQUEST = r2;
        a = new LiveWrappedMixedStreamPushMode[]{r1, r2};
    }

    public static LiveWrappedMixedStreamPushMode valueOf(String r1) {
        return (LiveWrappedMixedStreamPushMode) a.a(LiveWrappedMixedStreamPushMode.class, r1);
    }

    public static LiveWrappedMixedStreamPushMode[] values() {
        return (LiveWrappedMixedStreamPushMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamPushMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
