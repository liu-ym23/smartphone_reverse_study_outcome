package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class b0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedPlayerEvent.values().length];
        a = r0;
        r0[LiveWrappedPlayerEvent.SELECT_AUDIO_TRACK_BEGIN.ordinal()] = 1;
        r0[LiveWrappedPlayerEvent.SELECT_AUDIO_TRACK_COMPLETED.ordinal()] = 2;
        r0[LiveWrappedPlayerEvent.SELECT_AUDIO_TRACK_FAILED.ordinal()] = 3;
        r0[LiveWrappedPlayerEvent.SEEK_BEGIN.ordinal()] = 4;
        r0[LiveWrappedPlayerEvent.SEEK_COMPLETED.ordinal()] = 5;
        r0[LiveWrappedPlayerEvent.SEEK_FAILED.ordinal()] = 6;
    }
}
