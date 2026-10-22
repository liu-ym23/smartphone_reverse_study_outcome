package com.bytedance.ies.xelement.defaultimpl.player.engine.api.player;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/player/SeekState;", "", "SEEKING", "SEEK_SUCCESS", "SEEK_FAILED", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum SeekState extends Enum<SeekState> {
    public static final SeekState SEEKING = null;
    public static final SeekState SEEK_FAILED = null;
    public static final SeekState SEEK_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeekState[] f249869a = null;

    public static SeekState valueOf(String r100) {
        return (SeekState) a.a(SeekState.class, r100);
    }

    public static SeekState[] values() {
        return (SeekState[]) f249869a.clone();
    }

    static {
        SeekState r100 = new SeekState("SEEKING", 0);
        SEEKING = r100;
        SeekState r101 = new SeekState("SEEK_SUCCESS", 1);
        SEEK_SUCCESS = r101;
        SeekState r102 = new SeekState("SEEK_FAILED", 2);
        SEEK_FAILED = r102;
        f249869a = new SeekState[]{r100, r101, r102};
    }

    public SeekState(String r100, int r101) {
        super(r100, r101);
    }
}
