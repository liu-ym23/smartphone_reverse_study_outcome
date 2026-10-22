package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedPlayerEvent;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571694a = null;

    static {
        int[] r100 = new int[LiveWrappedPlayerEvent.values().length];
        f571694a = r100;
        r100[LiveWrappedPlayerEvent.SELECT_AUDIO_TRACK_BEGIN.ordinal()] = 1;
        r100[LiveWrappedPlayerEvent.SELECT_AUDIO_TRACK_COMPLETED.ordinal()] = 2;
        r100[LiveWrappedPlayerEvent.SELECT_AUDIO_TRACK_FAILED.ordinal()] = 3;
        r100[LiveWrappedPlayerEvent.SEEK_BEGIN.ordinal()] = 4;
        r100[LiveWrappedPlayerEvent.SEEK_COMPLETED.ordinal()] = 5;
        r100[LiveWrappedPlayerEvent.SEEK_FAILED.ordinal()] = 6;
    }
}
