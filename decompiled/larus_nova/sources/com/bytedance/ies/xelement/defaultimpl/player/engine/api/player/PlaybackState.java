package com.bytedance.ies.xelement.defaultimpl.player.engine.api.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/player/PlaybackState;", "", "", "isPlayingState", "PLAYBACK_STATE_START", "PLAYBACK_STATE_PLAYING", "PLAYBACK_STATE_PAUSED", "PLAYBACK_STATE_STOPPED", "PLAYBACK_STATE_ERROR", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum PlaybackState extends Enum<PlaybackState> {
    public static final PlaybackState PLAYBACK_STATE_ERROR = null;
    public static final PlaybackState PLAYBACK_STATE_PAUSED = null;
    public static final PlaybackState PLAYBACK_STATE_PLAYING = null;
    public static final PlaybackState PLAYBACK_STATE_START = null;
    public static final PlaybackState PLAYBACK_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlaybackState[] f249867a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249868a = null;

        static {
            int[] r100 = new int[PlaybackState.values().length];
            r100[PlaybackState.PLAYBACK_STATE_START.ordinal()] = 1;
            r100[PlaybackState.PLAYBACK_STATE_PLAYING.ordinal()] = 2;
            f249868a = r100;
        }
    }

    public static PlaybackState valueOf(String r100) {
        return (PlaybackState) r27.a.a(PlaybackState.class, r100);
    }

    public static PlaybackState[] values() {
        return (PlaybackState[]) f249867a.clone();
    }

    static {
        PlaybackState r100 = new PlaybackState("PLAYBACK_STATE_START", 0);
        PLAYBACK_STATE_START = r100;
        PlaybackState r101 = new PlaybackState("PLAYBACK_STATE_PLAYING", 1);
        PLAYBACK_STATE_PLAYING = r101;
        PlaybackState r102 = new PlaybackState("PLAYBACK_STATE_PAUSED", 2);
        PLAYBACK_STATE_PAUSED = r102;
        PlaybackState r103 = new PlaybackState("PLAYBACK_STATE_STOPPED", 3);
        PLAYBACK_STATE_STOPPED = r103;
        PlaybackState r104 = new PlaybackState("PLAYBACK_STATE_ERROR", 4);
        PLAYBACK_STATE_ERROR = r104;
        f249867a = new PlaybackState[]{r100, r101, r102, r103, r104};
    }

    public final boolean isPlayingState() {
        int r100 = a.f249868a[ordinal()];
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L9;
        return false;
    L9:
        return true;
    }

    public PlaybackState(String r100, int r101) {
        super(r100, r101);
    }
}
