package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedPlayerError.values().length];
        a = r0;
        r0[LiveWrappedPlayerError.OK.ordinal()] = 1;
        r0[LiveWrappedPlayerError.FORMAT_NOT_SUPPORT.ordinal()] = 2;
        r0[LiveWrappedPlayerError.INVALID_PATH.ordinal()] = 3;
        r0[LiveWrappedPlayerError.INVALID_STATE.ordinal()] = 4;
        r0[LiveWrappedPlayerError.INVALID_POSITION.ordinal()] = 5;
        r0[LiveWrappedPlayerError.INVALID_VOLUME.ordinal()] = 6;
        r0[LiveWrappedPlayerError.INVALID_PITCH.ordinal()] = 7;
        r0[LiveWrappedPlayerError.INVALID_AUDIO_TRACK_INDEX.ordinal()] = 8;
        r0[LiveWrappedPlayerError.INVALID_PLAYBACK_SPEED.ordinal()] = 9;
        r0[LiveWrappedPlayerError.INVALID_EFFECT_ID.ordinal()] = 10;
        r0[LiveWrappedPlayerError.ERROR_CURRENTLY_PLAYING.ordinal()] = 11;
    }
}
