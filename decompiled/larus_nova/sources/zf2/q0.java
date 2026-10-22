package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSubscribeStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571742a = null;

    static {
        int[] r100 = new int[LiveWrappedSubscribeStateChangeReason.values().length];
        f571742a = r100;
        r100[LiveWrappedSubscribeStateChangeReason.SUBSCRIBE.ordinal()] = 1;
        r100[LiveWrappedSubscribeStateChangeReason.UNSUBSCRIBE.ordinal()] = 2;
        r100[LiveWrappedSubscribeStateChangeReason.REMOTE_PUBLISH.ordinal()] = 3;
        r100[LiveWrappedSubscribeStateChangeReason.REMOTE_UNPUBLISH.ordinal()] = 4;
        r100[LiveWrappedSubscribeStateChangeReason.STREAM_FAILED_5XX.ordinal()] = 5;
        r100[LiveWrappedSubscribeStateChangeReason.STREAM_FAILED_404.ordinal()] = 6;
        r100[LiveWrappedSubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_LIMIT.ordinal()] = 7;
        r100[LiveWrappedSubscribeStateChangeReason.NO_SUBSCRIBE_PERMISSION.ordinal()] = 8;
    }
}
