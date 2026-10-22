package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/download/model/MusicType;", "", "MIDI", "MV", "FULL_TRACK", "ACCOMPANIMENT_TRACK", "LYRIC", "EFFECT", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicType extends Enum<MusicType> {
    public static final MusicType ACCOMPANIMENT_TRACK = null;
    public static final MusicType EFFECT = null;
    public static final MusicType FULL_TRACK = null;
    public static final MusicType LYRIC = null;
    public static final MusicType MIDI = null;
    public static final MusicType MV = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicType[] f255943a = null;

    static {
        MusicType r100 = new MusicType("MIDI", 0);
        MIDI = r100;
        MusicType r101 = new MusicType("MV", 1);
        MV = r101;
        MusicType r102 = new MusicType("FULL_TRACK", 2);
        FULL_TRACK = r102;
        MusicType r103 = new MusicType("ACCOMPANIMENT_TRACK", 3);
        ACCOMPANIMENT_TRACK = r103;
        MusicType r104 = new MusicType("LYRIC", 4);
        LYRIC = r104;
        MusicType r105 = new MusicType("EFFECT", 5);
        EFFECT = r105;
        f255943a = new MusicType[]{r100, r101, r102, r103, r104, r105};
    }

    public static MusicType valueOf(String r100) {
        return (MusicType) r27.a.a(MusicType.class, r100);
    }

    public static MusicType[] values() {
        return (MusicType[]) f255943a.clone();
    }

    public MusicType(String r100, int r101) {
        super(r100, r101);
    }
}
