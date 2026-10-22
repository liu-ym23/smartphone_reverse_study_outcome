package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamTaskEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class m {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedMixedStreamTaskEvent.values().length];
        a = r0;
        r0[LiveWrappedMixedStreamTaskEvent.BASE.ordinal()] = 1;
        r0[LiveWrappedMixedStreamTaskEvent.START_SUCCESS.ordinal()] = 2;
        r0[LiveWrappedMixedStreamTaskEvent.START_FAILED.ordinal()] = 3;
        r0[LiveWrappedMixedStreamTaskEvent.UPDATE_SUCCESS.ordinal()] = 4;
        r0[LiveWrappedMixedStreamTaskEvent.UPDATE_FAILED.ordinal()] = 5;
        r0[LiveWrappedMixedStreamTaskEvent.STOP_SUCCESS.ordinal()] = 6;
        r0[LiveWrappedMixedStreamTaskEvent.STOP_FAILED.ordinal()] = 7;
        r0[LiveWrappedMixedStreamTaskEvent.WARNING.ordinal()] = 8;
    }
}
