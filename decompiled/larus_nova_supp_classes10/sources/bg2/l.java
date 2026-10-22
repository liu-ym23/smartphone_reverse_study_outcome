package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamTaskErrorCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedMixedStreamTaskErrorCode.values().length];
        a = r0;
        r0[LiveWrappedMixedStreamTaskErrorCode.OK.ordinal()] = 1;
        r0[LiveWrappedMixedStreamTaskErrorCode.BASE.ordinal()] = 2;
        r0[LiveWrappedMixedStreamTaskErrorCode.TIMEOUT.ordinal()] = 3;
        r0[LiveWrappedMixedStreamTaskErrorCode.INVALID_PARAM_BY_SERVER.ordinal()] = 4;
        r0[LiveWrappedMixedStreamTaskErrorCode.SUB_TIMEOUT_BY_SERVER.ordinal()] = 5;
        r0[LiveWrappedMixedStreamTaskErrorCode.INVALID_STATE_BY_SERVER.ordinal()] = 6;
        r0[LiveWrappedMixedStreamTaskErrorCode.AUTHENTICATION_BY_CDN.ordinal()] = 7;
        r0[LiveWrappedMixedStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 8;
        r0[LiveWrappedMixedStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 9;
        r0[LiveWrappedMixedStreamTaskErrorCode.MIX_IMAGE_FAIL.ordinal()] = 10;
        r0[LiveWrappedMixedStreamTaskErrorCode.STREAM_SYNC_WORSE.ordinal()] = 11;
        r0[LiveWrappedMixedStreamTaskErrorCode.PUSH_WTN_FAILED.ordinal()] = 12;
        r0[LiveWrappedMixedStreamTaskErrorCode.MAX.ordinal()] = 13;
    }
}
