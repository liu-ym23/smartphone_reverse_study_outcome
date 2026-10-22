package com.bytedance.ies.xelement.defaultimpl.player.engine.api.player;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/player/LoadingState;", "", "LOAD_STATE_PLAYABLE", "LOAD_STATE_STALLED", "LOAD_STATE_ERROR", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum LoadingState extends Enum<LoadingState> {
    public static final LoadingState LOAD_STATE_ERROR = null;
    public static final LoadingState LOAD_STATE_PLAYABLE = null;
    public static final LoadingState LOAD_STATE_STALLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadingState[] f249866a = null;

    public static LoadingState valueOf(String r100) {
        return (LoadingState) a.a(LoadingState.class, r100);
    }

    public static LoadingState[] values() {
        return (LoadingState[]) f249866a.clone();
    }

    static {
        LoadingState r100 = new LoadingState("LOAD_STATE_PLAYABLE", 0);
        LOAD_STATE_PLAYABLE = r100;
        LoadingState r101 = new LoadingState("LOAD_STATE_STALLED", 1);
        LOAD_STATE_STALLED = r101;
        LoadingState r102 = new LoadingState("LOAD_STATE_ERROR", 2);
        LOAD_STATE_ERROR = r102;
        f249866a = new LoadingState[]{r100, r101, r102};
    }

    public LoadingState(String r100, int r101) {
        super(r100, r101);
    }
}
