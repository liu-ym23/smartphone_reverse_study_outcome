package com.bytedance.locallife.poi.media.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/poi/media/api/PlayState;", "", "PLAY_STATE_UNKNOWN", "PLAY_STATE_PLAYING", "PLAY_STATE_PAUSED", "PLAY_STATE_STOPPED", "PLAY_STATE_ERROR", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PlayState extends Enum<PlayState> {
    public static final PlayState PLAY_STATE_ERROR = null;
    public static final PlayState PLAY_STATE_PAUSED = null;
    public static final PlayState PLAY_STATE_PLAYING = null;
    public static final PlayState PLAY_STATE_STOPPED = null;
    public static final PlayState PLAY_STATE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayState[] f262662a = null;

    public static PlayState valueOf(String r100) {
        return (PlayState) a.a(PlayState.class, r100);
    }

    public static PlayState[] values() {
        return (PlayState[]) f262662a.clone();
    }

    static {
        PlayState r100 = new PlayState("PLAY_STATE_UNKNOWN", 0);
        PLAY_STATE_UNKNOWN = r100;
        PlayState r101 = new PlayState("PLAY_STATE_PLAYING", 1);
        PLAY_STATE_PLAYING = r101;
        PlayState r102 = new PlayState("PLAY_STATE_PAUSED", 2);
        PLAY_STATE_PAUSED = r102;
        PlayState r103 = new PlayState("PLAY_STATE_STOPPED", 3);
        PLAY_STATE_STOPPED = r103;
        PlayState r104 = new PlayState("PLAY_STATE_ERROR", 4);
        PLAY_STATE_ERROR = r104;
        f262662a = new PlayState[]{r100, r101, r102, r103, r104};
    }

    public PlayState(String r100, int r101) {
        super(r100, r101);
    }
}
