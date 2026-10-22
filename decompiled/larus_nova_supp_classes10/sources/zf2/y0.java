package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushStateChangeReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class y0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNPushStateChangeReason.values().length];
        a = r0;
        r0[LiveWrappedWTNPushStateChangeReason.PushSuccess.ordinal()] = 1;
        r0[LiveWrappedWTNPushStateChangeReason.StartPush.ordinal()] = 2;
        r0[LiveWrappedWTNPushStateChangeReason.StopPush.ordinal()] = 3;
        r0[LiveWrappedWTNPushStateChangeReason.InRetry.ordinal()] = 4;
        r0[LiveWrappedWTNPushStateChangeReason.RetryFail.ordinal()] = 5;
        r0[LiveWrappedWTNPushStateChangeReason.NoPushPermission.ordinal()] = 6;
        r0[LiveWrappedWTNPushStateChangeReason.StreamPushByOther.ordinal()] = 7;
        r0[LiveWrappedWTNPushStateChangeReason.Internal.ordinal()] = 8;
    }
}
