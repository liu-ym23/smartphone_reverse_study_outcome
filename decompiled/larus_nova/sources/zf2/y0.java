package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571753a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNPushStateChangeReason.values().length];
        f571753a = r100;
        r100[LiveWrappedWTNPushStateChangeReason.PushSuccess.ordinal()] = 1;
        r100[LiveWrappedWTNPushStateChangeReason.StartPush.ordinal()] = 2;
        r100[LiveWrappedWTNPushStateChangeReason.StopPush.ordinal()] = 3;
        r100[LiveWrappedWTNPushStateChangeReason.InRetry.ordinal()] = 4;
        r100[LiveWrappedWTNPushStateChangeReason.RetryFail.ordinal()] = 5;
        r100[LiveWrappedWTNPushStateChangeReason.NoPushPermission.ordinal()] = 6;
        r100[LiveWrappedWTNPushStateChangeReason.StreamPushByOther.ordinal()] = 7;
        r100[LiveWrappedWTNPushStateChangeReason.Internal.ordinal()] = 8;
    }
}
