package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioReportMode;", "", "", "value", "", "toString", "I", "Companion", "a", "AUDIO_REPORT_MODE_NORMAL", "AUDIO_REPORT_MODE_DISCONNECT", "AUDIO_REPORT_MODE_RESET", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioReportMode extends Enum<LiveWrappedAudioReportMode> {
    public static final LiveWrappedAudioReportMode AUDIO_REPORT_MODE_DISCONNECT = null;
    public static final LiveWrappedAudioReportMode AUDIO_REPORT_MODE_NORMAL = null;
    public static final LiveWrappedAudioReportMode AUDIO_REPORT_MODE_RESET = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioReportMode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioReportMode$a] */
    static {
        LiveWrappedAudioReportMode r1 = new LiveWrappedAudioReportMode("AUDIO_REPORT_MODE_NORMAL", 0, 0);
        AUDIO_REPORT_MODE_NORMAL = r1;
        LiveWrappedAudioReportMode r2 = new LiveWrappedAudioReportMode("AUDIO_REPORT_MODE_DISCONNECT", 1, 1);
        AUDIO_REPORT_MODE_DISCONNECT = r2;
        LiveWrappedAudioReportMode r3 = new LiveWrappedAudioReportMode("AUDIO_REPORT_MODE_RESET", 2, 2);
        AUDIO_REPORT_MODE_RESET = r3;
        a = new LiveWrappedAudioReportMode[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedAudioReportMode valueOf(String r1) {
        return (LiveWrappedAudioReportMode) r27.a.a(LiveWrappedAudioReportMode.class, r1);
    }

    public static LiveWrappedAudioReportMode[] values() {
        return (LiveWrappedAudioReportMode[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = l.a[ordinal()];
        if (r0 != 1) goto L5;
        return "AUDIO_REPORT_MODE_NORMAL";
    L5:
        if (r0 != 2) goto L7;
        return "AUDIO_REPORT_MODE_DISCONNECT";
    L7:
        if (r0 == 3) goto L9;
        return "";
    L9:
        return "AUDIO_REPORT_MODE_RESET";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioReportMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
