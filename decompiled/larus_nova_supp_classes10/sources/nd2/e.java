package nd2;

import com.bytedance.livesdk.ktvcommon.download.model.MusicType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MusicType.values().length];
        a = r0;
        r0[MusicType.FULL_TRACK.ordinal()] = 1;
        r0[MusicType.MIDI.ordinal()] = 2;
        r0[MusicType.LYRIC.ordinal()] = 3;
        r0[MusicType.ACCOMPANIMENT_TRACK.ordinal()] = 4;
    }
}
