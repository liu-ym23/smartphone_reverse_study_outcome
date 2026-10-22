package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "", "NOT_PREPARED", "PREPARED", "STARTED", "PAUSED", "STOPPED", "RELEASE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerState extends Enum<PlayerState> {
    public static final PlayerState NOT_PREPARED = null;
    public static final PlayerState PAUSED = null;
    public static final PlayerState PREPARED = null;
    public static final PlayerState RELEASE = null;
    public static final PlayerState STARTED = null;
    public static final PlayerState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerState[] f396586a = null;

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
        f396586a = new PlayerState[]{r100, r101, r102, r103, r104, r105};
    }

    public static PlayerState valueOf(String r100) {
        return (PlayerState) a.a(PlayerState.class, r100);
    }

    public static PlayerState[] values() {
        return (PlayerState[]) f396586a.clone();
    }

    public PlayerState(String r100, int r101) {
        super(r100, r101);
    }
}
