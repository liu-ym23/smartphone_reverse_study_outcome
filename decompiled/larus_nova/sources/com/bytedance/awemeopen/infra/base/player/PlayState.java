package com.bytedance.awemeopen.infra.base.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/player/PlayState;", "", "STATE_RESET", "STATE_PREPARE", "STATE_PREPARED", "STATE_START", "STATE_RESUME", "STATE_PAUSE", "STATE_STOP", "STATE_RELEASE", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final enum PlayState extends Enum<PlayState> {
    public static final PlayState STATE_PAUSE = null;
    public static final PlayState STATE_PREPARE = null;
    public static final PlayState STATE_PREPARED = null;
    public static final PlayState STATE_RELEASE = null;
    public static final PlayState STATE_RESET = null;
    public static final PlayState STATE_RESUME = null;
    public static final PlayState STATE_START = null;
    public static final PlayState STATE_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayState[] f198732a = null;

    public static PlayState valueOf(String r100) {
        return (PlayState) r27.a.a(PlayState.class, r100);
    }

    public static PlayState[] values() {
        return (PlayState[]) f198732a.clone();
    }

    static {
        PlayState r100 = new PlayState("STATE_RESET", 0);
        STATE_RESET = r100;
        PlayState r101 = new PlayState("STATE_PREPARE", 1);
        STATE_PREPARE = r101;
        PlayState r102 = new PlayState("STATE_PREPARED", 2);
        STATE_PREPARED = r102;
        PlayState r103 = new PlayState("STATE_START", 3);
        STATE_START = r103;
        PlayState r104 = new PlayState("STATE_RESUME", 4);
        STATE_RESUME = r104;
        PlayState r105 = new PlayState("STATE_PAUSE", 5);
        STATE_PAUSE = r105;
        PlayState r110 = new PlayState("STATE_STOP", 6);
        STATE_STOP = r110;
        PlayState r111 = new PlayState("STATE_RELEASE", 7);
        STATE_RELEASE = r111;
        f198732a = new PlayState[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public PlayState(String r100, int r101) {
        super(r100, r101);
    }
}
