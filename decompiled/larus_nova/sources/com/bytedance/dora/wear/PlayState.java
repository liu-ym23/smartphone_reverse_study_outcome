package com.bytedance.dora.wear;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum PlayState extends Enum<PlayState> {
    public static final PlayState NO_ACTION = null;
    public static final PlayState PAUSE = null;
    public static final PlayState PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayState[] f204667a = null;

    static {
        PlayState r100 = new PlayState("NO_ACTION", 0);
        NO_ACTION = r100;
        PlayState r101 = new PlayState(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1);
        PLAY = r101;
        PlayState r102 = new PlayState("PAUSE", 2);
        PAUSE = r102;
        f204667a = new PlayState[]{r100, r101, r102};
    }

    public static PlayState[] values() {
        return (PlayState[]) f204667a.clone();
    }

    public static PlayState valueOf(String r100) {
        return (PlayState) a.a(PlayState.class, r100);
    }

    public PlayState(String r100, int r101) {
        super(r100, r101);
    }
}
