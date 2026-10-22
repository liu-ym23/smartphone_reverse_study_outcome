package com.ss.ttvideoengine.configcenter;

/* JADX INFO: loaded from: classes34.dex */
public class PlayerConfigItem extends ConfigItem {
    public static final int STAGE_NONE = -1;
    public static final int STAGE_PLAYER_CREATE = 0;
    public static final int STAGE_PLAYER_REUSE = 1;
    protected int batchExecuteStage;

    public PlayerConfigItem(int r100, Object r101, int r102) {
        super(r100, r101, 0, r102, 1);
        this.batchExecuteStage = 0;
    }

    public PlayerConfigItem(int r100, Object r101, int r102, int r110) {
        super(r100, r101, 0, r102, 1);
        this.batchExecuteStage = r110;
    }
}
