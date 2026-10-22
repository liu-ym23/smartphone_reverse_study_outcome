package com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/queue/PlayMode;", "", "SEQUENCE", "LIST_LOOP", "SINGLE_LOOP", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum PlayMode extends Enum<PlayMode> {
    public static final PlayMode LIST_LOOP = null;
    public static final PlayMode SEQUENCE = null;
    public static final PlayMode SINGLE_LOOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayMode[] f249870a = null;

    public static PlayMode valueOf(String r100) {
        return (PlayMode) r27.a.a(PlayMode.class, r100);
    }

    public static PlayMode[] values() {
        return (PlayMode[]) f249870a.clone();
    }

    static {
        PlayMode r100 = new PlayMode("SEQUENCE", 0);
        SEQUENCE = r100;
        PlayMode r101 = new PlayMode("LIST_LOOP", 1);
        LIST_LOOP = r101;
        PlayMode r102 = new PlayMode("SINGLE_LOOP", 2);
        SINGLE_LOOP = r102;
        f249870a = new PlayMode[]{r100, r101, r102};
    }

    public PlayMode(String r100, int r101) {
        super(r100, r101);
    }
}
