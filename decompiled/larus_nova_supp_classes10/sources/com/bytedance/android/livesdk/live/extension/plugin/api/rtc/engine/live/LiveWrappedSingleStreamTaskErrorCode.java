package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import bg2.s;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedSingleStreamTaskErrorCode;", "", "", "value", "", "toString", "I", "Companion", "a", "OK", "BASE", "UNKNOWN_BY_SERVER", "SIGNAL_REQUEST_TIMEOUT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSingleStreamTaskErrorCode extends Enum<LiveWrappedSingleStreamTaskErrorCode> {
    public static final LiveWrappedSingleStreamTaskErrorCode BASE = null;
    public static final a Companion = null;
    public static final LiveWrappedSingleStreamTaskErrorCode OK = null;
    public static final LiveWrappedSingleStreamTaskErrorCode SIGNAL_REQUEST_TIMEOUT = null;
    public static final LiveWrappedSingleStreamTaskErrorCode UNKNOWN_BY_SERVER = null;
    public static final /* synthetic */ LiveWrappedSingleStreamTaskErrorCode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskErrorCode$a] */
    static {
        LiveWrappedSingleStreamTaskErrorCode r1 = new LiveWrappedSingleStreamTaskErrorCode("OK", 0, 0);
        OK = r1;
        LiveWrappedSingleStreamTaskErrorCode r2 = new LiveWrappedSingleStreamTaskErrorCode("BASE", 1, 1090);
        BASE = r2;
        LiveWrappedSingleStreamTaskErrorCode r3 = new LiveWrappedSingleStreamTaskErrorCode("UNKNOWN_BY_SERVER", 2, 1091);
        UNKNOWN_BY_SERVER = r3;
        LiveWrappedSingleStreamTaskErrorCode r4 = new LiveWrappedSingleStreamTaskErrorCode("SIGNAL_REQUEST_TIMEOUT", 3, 1092);
        SIGNAL_REQUEST_TIMEOUT = r4;
        a = new LiveWrappedSingleStreamTaskErrorCode[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedSingleStreamTaskErrorCode valueOf(String r1) {
        return (LiveWrappedSingleStreamTaskErrorCode) r27.a.a(LiveWrappedSingleStreamTaskErrorCode.class, r1);
    }

    public static LiveWrappedSingleStreamTaskErrorCode[] values() {
        return (LiveWrappedSingleStreamTaskErrorCode[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = s.a[ordinal()];
        if (r0 != 1) goto L5;
        return "OK";
    L5:
        if (r0 != 2) goto L7;
        return "BASE";
    L7:
        if (r0 != 3) goto L9;
        return "UNKNOWN_BY_SERVER";
    L9:
        if (r0 == 4) goto L11;
        return "";
    L11:
        return "SIGNAL_REQUEST_TIMEOUT";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSingleStreamTaskErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
