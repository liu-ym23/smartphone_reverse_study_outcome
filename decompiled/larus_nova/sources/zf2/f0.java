package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPublishStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571714a = null;

    static {
        int[] r100 = new int[LiveWrappedPublishStateChangeReason.values().length];
        f571714a = r100;
        r100[LiveWrappedPublishStateChangeReason.PUBLISH.ordinal()] = 1;
        r100[LiveWrappedPublishStateChangeReason.UNPUBLISH.ordinal()] = 2;
        r100[LiveWrappedPublishStateChangeReason.NO_PUBLISH_PERMISSION.ordinal()] = 3;
        r100[LiveWrappedPublishStateChangeReason.OVER_STREAM_PUBLISH_LIMIT.ordinal()] = 4;
        r100[LiveWrappedPublishStateChangeReason.MULTIROOM_UNPUBLISH_FAILED.ordinal()] = 5;
        r100[LiveWrappedPublishStateChangeReason.PUBLISH_STREAM_FAILED.ordinal()] = 6;
        r100[LiveWrappedPublishStateChangeReason.PUBLISH_STREAM_FORBIDEN.ordinal()] = 7;
        r100[LiveWrappedPublishStateChangeReason.USER_IN_PUBLISH.ordinal()] = 8;
    }
}
