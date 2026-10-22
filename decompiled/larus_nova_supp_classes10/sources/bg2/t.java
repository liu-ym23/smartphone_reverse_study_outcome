package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedSingleStreamTaskEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class t {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedSingleStreamTaskEvent.values().length];
        a = r0;
        r0[LiveWrappedSingleStreamTaskEvent.BASE.ordinal()] = 1;
        r0[LiveWrappedSingleStreamTaskEvent.START_SUCCESS.ordinal()] = 2;
        r0[LiveWrappedSingleStreamTaskEvent.START_FAILED.ordinal()] = 3;
        r0[LiveWrappedSingleStreamTaskEvent.STOP_SUCCESS.ordinal()] = 4;
        r0[LiveWrappedSingleStreamTaskEvent.STOP_FAILED.ordinal()] = 5;
        r0[LiveWrappedSingleStreamTaskEvent.WARNING.ordinal()] = 6;
    }
}
