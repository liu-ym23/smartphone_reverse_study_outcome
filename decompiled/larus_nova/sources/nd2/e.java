package nd2;

import com.bytedance.livesdk.ktvcommon.download.model.MusicType;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f518764a = null;

    static {
        int[] r100 = new int[MusicType.values().length];
        f518764a = r100;
        r100[MusicType.FULL_TRACK.ordinal()] = 1;
        r100[MusicType.MIDI.ordinal()] = 2;
        r100[MusicType.LYRIC.ordinal()] = 3;
        r100[MusicType.ACCOMPANIMENT_TRACK.ordinal()] = 4;
    }
}
