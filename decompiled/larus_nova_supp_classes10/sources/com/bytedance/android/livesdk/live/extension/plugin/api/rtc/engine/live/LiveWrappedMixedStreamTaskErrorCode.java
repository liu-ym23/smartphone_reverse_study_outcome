package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import bg2.l;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamTaskErrorCode;", "", "", "value", "", "toString", "I", "Companion", "a", "OK", "BASE", "TIMEOUT", "INVALID_PARAM_BY_SERVER", "SUB_TIMEOUT_BY_SERVER", "INVALID_STATE_BY_SERVER", "AUTHENTICATION_BY_CDN", "UNKNOWN_BY_SERVER", "SIGNAL_REQUEST_TIMEOUT", "MIX_IMAGE_FAIL", "STREAM_SYNC_WORSE", "PUSH_WTN_FAILED", "MAX", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamTaskErrorCode extends Enum<LiveWrappedMixedStreamTaskErrorCode> {
    public static final LiveWrappedMixedStreamTaskErrorCode AUTHENTICATION_BY_CDN = null;
    public static final LiveWrappedMixedStreamTaskErrorCode BASE = null;
    public static final a Companion = null;
    public static final LiveWrappedMixedStreamTaskErrorCode INVALID_PARAM_BY_SERVER = null;
    public static final LiveWrappedMixedStreamTaskErrorCode INVALID_STATE_BY_SERVER = null;
    public static final LiveWrappedMixedStreamTaskErrorCode MAX = null;
    public static final LiveWrappedMixedStreamTaskErrorCode MIX_IMAGE_FAIL = null;
    public static final LiveWrappedMixedStreamTaskErrorCode OK = null;
    public static final LiveWrappedMixedStreamTaskErrorCode PUSH_WTN_FAILED = null;
    public static final LiveWrappedMixedStreamTaskErrorCode SIGNAL_REQUEST_TIMEOUT = null;
    public static final LiveWrappedMixedStreamTaskErrorCode STREAM_SYNC_WORSE = null;
    public static final LiveWrappedMixedStreamTaskErrorCode SUB_TIMEOUT_BY_SERVER = null;
    public static final LiveWrappedMixedStreamTaskErrorCode TIMEOUT = null;
    public static final LiveWrappedMixedStreamTaskErrorCode UNKNOWN_BY_SERVER = null;
    public static final /* synthetic */ LiveWrappedMixedStreamTaskErrorCode[] a = null;
    private int value;

    public static LiveWrappedMixedStreamTaskErrorCode valueOf(String r1) {
        return (LiveWrappedMixedStreamTaskErrorCode) r27.a.a(LiveWrappedMixedStreamTaskErrorCode.class, r1);
    }

    public static LiveWrappedMixedStreamTaskErrorCode[] values() {
        return (LiveWrappedMixedStreamTaskErrorCode[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamTaskErrorCode$a] */
    static {
        LiveWrappedMixedStreamTaskErrorCode r1 = new LiveWrappedMixedStreamTaskErrorCode("OK", 0, 0);
        OK = r1;
        LiveWrappedMixedStreamTaskErrorCode r2 = new LiveWrappedMixedStreamTaskErrorCode("BASE", 1, 1090);
        BASE = r2;
        LiveWrappedMixedStreamTaskErrorCode r3 = new LiveWrappedMixedStreamTaskErrorCode("TIMEOUT", 2, 1091);
        TIMEOUT = r3;
        LiveWrappedMixedStreamTaskErrorCode r4 = new LiveWrappedMixedStreamTaskErrorCode("INVALID_PARAM_BY_SERVER", 3, 1092);
        INVALID_PARAM_BY_SERVER = r4;
        LiveWrappedMixedStreamTaskErrorCode r5 = new LiveWrappedMixedStreamTaskErrorCode("SUB_TIMEOUT_BY_SERVER", 4, 1093);
        SUB_TIMEOUT_BY_SERVER = r5;
        LiveWrappedMixedStreamTaskErrorCode r6 = new LiveWrappedMixedStreamTaskErrorCode("INVALID_STATE_BY_SERVER", 5, 1094);
        INVALID_STATE_BY_SERVER = r6;
        LiveWrappedMixedStreamTaskErrorCode r7 = new LiveWrappedMixedStreamTaskErrorCode("AUTHENTICATION_BY_CDN", 6, 1095);
        AUTHENTICATION_BY_CDN = r7;
        LiveWrappedMixedStreamTaskErrorCode r8 = new LiveWrappedMixedStreamTaskErrorCode("UNKNOWN_BY_SERVER", 7, 1096);
        UNKNOWN_BY_SERVER = r8;
        LiveWrappedMixedStreamTaskErrorCode r9 = new LiveWrappedMixedStreamTaskErrorCode("SIGNAL_REQUEST_TIMEOUT", 8, 1097);
        SIGNAL_REQUEST_TIMEOUT = r9;
        LiveWrappedMixedStreamTaskErrorCode r10 = new LiveWrappedMixedStreamTaskErrorCode("MIX_IMAGE_FAIL", 9, 1098);
        MIX_IMAGE_FAIL = r10;
        LiveWrappedMixedStreamTaskErrorCode r11 = new LiveWrappedMixedStreamTaskErrorCode("STREAM_SYNC_WORSE", 10, 1099);
        STREAM_SYNC_WORSE = r11;
        LiveWrappedMixedStreamTaskErrorCode r12 = new LiveWrappedMixedStreamTaskErrorCode("PUSH_WTN_FAILED", 11, 1195);
        PUSH_WTN_FAILED = r12;
        LiveWrappedMixedStreamTaskErrorCode r13 = new LiveWrappedMixedStreamTaskErrorCode("MAX", 12, 1199);
        MAX = r13;
        a = new LiveWrappedMixedStreamTaskErrorCode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(l.a[ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "MAX";
    L6:
        return "PUSH_WTN_FAILED";
    L7:
        return "STREAM_SYNC_WORSE";
    L8:
        return "MIX_IMAGE_FAIL";
    L9:
        return "SIGNAL_REQUEST_TIMEOUT";
    L10:
        return "UNKNOWN_BY_SERVER";
    L11:
        return "AUTHENTICATION_BY_CDN";
    L12:
        return "INVALID_STATE_BY_SERVER";
    L13:
        return "SUB_TIMEOUT_BY_SERVER";
    L14:
        return "INVALID_PARAM_BY_SERVER";
    L15:
        return "TIMEOUT";
    L16:
        return "BASE";
    L17:
        return "OK";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedMixedStreamTaskErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
