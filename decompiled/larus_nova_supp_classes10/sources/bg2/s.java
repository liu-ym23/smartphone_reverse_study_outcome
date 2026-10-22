package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskErrorCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class s {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedSingleStreamTaskErrorCode.values().length];
        a = r0;
        r0[LiveWrappedSingleStreamTaskErrorCode.OK.ordinal()] = 1;
        r0[LiveWrappedSingleStreamTaskErrorCode.BASE.ordinal()] = 2;
        r0[LiveWrappedSingleStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 3;
        r0[LiveWrappedSingleStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 4;
    }
}
