package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSubscribeStateChangeReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class q0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedSubscribeStateChangeReason.values().length];
        a = r0;
        r0[LiveWrappedSubscribeStateChangeReason.SUBSCRIBE.ordinal()] = 1;
        r0[LiveWrappedSubscribeStateChangeReason.UNSUBSCRIBE.ordinal()] = 2;
        r0[LiveWrappedSubscribeStateChangeReason.REMOTE_PUBLISH.ordinal()] = 3;
        r0[LiveWrappedSubscribeStateChangeReason.REMOTE_UNPUBLISH.ordinal()] = 4;
        r0[LiveWrappedSubscribeStateChangeReason.STREAM_FAILED_5XX.ordinal()] = 5;
        r0[LiveWrappedSubscribeStateChangeReason.STREAM_FAILED_404.ordinal()] = 6;
        r0[LiveWrappedSubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_LIMIT.ordinal()] = 7;
        r0[LiveWrappedSubscribeStateChangeReason.NO_SUBSCRIBE_PERMISSION.ordinal()] = 8;
    }
}
