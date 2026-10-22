package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedPerformanceAlarmMode;", "", "", "value", "I", "Companion", "a", "NORMAL", "SIMULCAST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPerformanceAlarmMode extends Enum<LiveWrappedPerformanceAlarmMode> {
    public static final a Companion = null;
    public static final LiveWrappedPerformanceAlarmMode NORMAL = null;
    public static final LiveWrappedPerformanceAlarmMode SIMULCAST = null;
    public static final /* synthetic */ LiveWrappedPerformanceAlarmMode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedPerformanceAlarmMode$a] */
    static {
        LiveWrappedPerformanceAlarmMode r1 = new LiveWrappedPerformanceAlarmMode("NORMAL", 0, 0);
        NORMAL = r1;
        LiveWrappedPerformanceAlarmMode r2 = new LiveWrappedPerformanceAlarmMode("SIMULCAST", 1, 1);
        SIMULCAST = r2;
        a = new LiveWrappedPerformanceAlarmMode[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedPerformanceAlarmMode valueOf(String r1) {
        return (LiveWrappedPerformanceAlarmMode) r27.a.a(LiveWrappedPerformanceAlarmMode.class, r1);
    }

    public static LiveWrappedPerformanceAlarmMode[] values() {
        return (LiveWrappedPerformanceAlarmMode[]) a.clone();
    }

    public LiveWrappedPerformanceAlarmMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
