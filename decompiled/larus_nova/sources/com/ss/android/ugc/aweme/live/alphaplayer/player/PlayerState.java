package com.ss.android.ugc.aweme.live.alphaplayer.player;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PlayerState extends Enum<PlayerState> {
    public static final PlayerState NOT_PREPARED = null;
    public static final PlayerState PAUSED = null;
    public static final PlayerState PREPARED = null;
    public static final PlayerState RELEASE = null;
    public static final PlayerState STARTED = null;
    public static final PlayerState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerState[] f451200a = null;

    static {
        PlayerState r100 = new PlayerState("NOT_PREPARED", 0);
        NOT_PREPARED = r100;
        PlayerState r101 = new PlayerState("PREPARED", 1);
        PREPARED = r101;
        PlayerState r102 = new PlayerState("STARTED", 2);
        STARTED = r102;
        PlayerState r103 = new PlayerState("PAUSED", 3);
        PAUSED = r103;
        PlayerState r104 = new PlayerState("STOPPED", 4);
        STOPPED = r104;
        PlayerState r105 = new PlayerState("RELEASE", 5);
        RELEASE = r105;
        f451200a = new PlayerState[]{r100, r101, r102, r103, r104, r105};
    }

    public static PlayerState[] values() {
        return (PlayerState[]) f451200a.clone();
    }

    public static PlayerState valueOf(String r100) {
        return (PlayerState) a.a(PlayerState.class, r100);
    }

    public PlayerState(String r100, int r101) {
        super(r100, r101);
    }
}
