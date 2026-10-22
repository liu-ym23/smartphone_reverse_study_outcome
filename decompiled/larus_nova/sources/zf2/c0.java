package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571697a = null;

    static {
        int[] r100 = new int[LiveWrappedPlayerState.values().length];
        f571697a = r100;
        r100[LiveWrappedPlayerState.IDLE.ordinal()] = 1;
        r100[LiveWrappedPlayerState.PRELOADED.ordinal()] = 2;
        r100[LiveWrappedPlayerState.OPENED.ordinal()] = 3;
        r100[LiveWrappedPlayerState.PLAYING.ordinal()] = 4;
        r100[LiveWrappedPlayerState.PAUSED.ordinal()] = 5;
        r100[LiveWrappedPlayerState.STOPPED.ordinal()] = 6;
        r100[LiveWrappedPlayerState.FAILED.ordinal()] = 7;
        r100[LiveWrappedPlayerState.FINISHED.ordinal()] = 8;
        r100[LiveWrappedPlayerState.LOOP_FINISHED.ordinal()] = 9;
    }
}
