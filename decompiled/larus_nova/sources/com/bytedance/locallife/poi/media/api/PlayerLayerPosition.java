package com.bytedance.locallife.poi.media.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/poi/media/api/PlayerLayerPosition;", "", "", "position", "I", "getPosition", "()I", "POSITION_VERY_BOTTOM", "POSITION_INFO", "POSITION_TOOLBAR", "POSITION_RIGHT_OPERATION", "POSITION_LOADING", "POSITION_STICKY_HEADER", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PlayerLayerPosition extends Enum<PlayerLayerPosition> {
    public static final PlayerLayerPosition POSITION_INFO = null;
    public static final PlayerLayerPosition POSITION_LOADING = null;
    public static final PlayerLayerPosition POSITION_RIGHT_OPERATION = null;
    public static final PlayerLayerPosition POSITION_STICKY_HEADER = null;
    public static final PlayerLayerPosition POSITION_TOOLBAR = null;
    public static final PlayerLayerPosition POSITION_VERY_BOTTOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerLayerPosition[] f262663a = null;
    private final int position;

    public static PlayerLayerPosition valueOf(String r100) {
        return (PlayerLayerPosition) a.a(PlayerLayerPosition.class, r100);
    }

    public static PlayerLayerPosition[] values() {
        return (PlayerLayerPosition[]) f262663a.clone();
    }

    static {
        PlayerLayerPosition r100 = new PlayerLayerPosition("POSITION_VERY_BOTTOM", 0, 0);
        POSITION_VERY_BOTTOM = r100;
        PlayerLayerPosition r101 = new PlayerLayerPosition("POSITION_INFO", 1, 1);
        POSITION_INFO = r101;
        PlayerLayerPosition r102 = new PlayerLayerPosition("POSITION_TOOLBAR", 2, 2);
        POSITION_TOOLBAR = r102;
        PlayerLayerPosition r103 = new PlayerLayerPosition("POSITION_RIGHT_OPERATION", 3, 3);
        POSITION_RIGHT_OPERATION = r103;
        PlayerLayerPosition r104 = new PlayerLayerPosition("POSITION_LOADING", 4, 4);
        POSITION_LOADING = r104;
        PlayerLayerPosition r105 = new PlayerLayerPosition("POSITION_STICKY_HEADER", 5, 5);
        POSITION_STICKY_HEADER = r105;
        f262663a = new PlayerLayerPosition[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getPosition() {
        return this.position;
    }

    public PlayerLayerPosition(String r100, int r101, int r102) {
        super(r100, r101);
        this.position = r102;
    }
}
