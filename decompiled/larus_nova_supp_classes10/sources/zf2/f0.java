package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishStateChangeReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class f0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedPublishStateChangeReason.values().length];
        a = r0;
        r0[LiveWrappedPublishStateChangeReason.PUBLISH.ordinal()] = 1;
        r0[LiveWrappedPublishStateChangeReason.UNPUBLISH.ordinal()] = 2;
        r0[LiveWrappedPublishStateChangeReason.NO_PUBLISH_PERMISSION.ordinal()] = 3;
        r0[LiveWrappedPublishStateChangeReason.OVER_STREAM_PUBLISH_LIMIT.ordinal()] = 4;
        r0[LiveWrappedPublishStateChangeReason.MULTIROOM_UNPUBLISH_FAILED.ordinal()] = 5;
        r0[LiveWrappedPublishStateChangeReason.PUBLISH_STREAM_FAILED.ordinal()] = 6;
        r0[LiveWrappedPublishStateChangeReason.PUBLISH_STREAM_FORBIDEN.ordinal()] = 7;
        r0[LiveWrappedPublishStateChangeReason.USER_IN_PUBLISH.ordinal()] = 8;
    }
}
