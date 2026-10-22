package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class c0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedPlayerState.values().length];
        a = r0;
        r0[LiveWrappedPlayerState.IDLE.ordinal()] = 1;
        r0[LiveWrappedPlayerState.PRELOADED.ordinal()] = 2;
        r0[LiveWrappedPlayerState.OPENED.ordinal()] = 3;
        r0[LiveWrappedPlayerState.PLAYING.ordinal()] = 4;
        r0[LiveWrappedPlayerState.PAUSED.ordinal()] = 5;
        r0[LiveWrappedPlayerState.STOPPED.ordinal()] = 6;
        r0[LiveWrappedPlayerState.FAILED.ordinal()] = 7;
        r0[LiveWrappedPlayerState.FINISHED.ordinal()] = 8;
        r0[LiveWrappedPlayerState.LOOP_FINISHED.ordinal()] = 9;
    }
}
