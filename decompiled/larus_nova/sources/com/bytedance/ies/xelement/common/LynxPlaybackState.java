package com.bytedance.ies.xelement.common;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xelement/common/LynxPlaybackState;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "PLAYBACK_STATE_START", "PLAYBACK_STATE_PLAYING", "PLAYBACK_STATE_PAUSED", "PLAYBACK_STATE_STOPPED", "PLAYBACK_STATE_ENDED", "PLAYBACK_STATE_ERROR", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final enum LynxPlaybackState extends Enum<LynxPlaybackState> {
    public static final LynxPlaybackState PLAYBACK_STATE_ENDED = null;
    public static final LynxPlaybackState PLAYBACK_STATE_ERROR = null;
    public static final LynxPlaybackState PLAYBACK_STATE_PAUSED = null;
    public static final LynxPlaybackState PLAYBACK_STATE_PLAYING = null;
    public static final LynxPlaybackState PLAYBACK_STATE_START = null;
    public static final LynxPlaybackState PLAYBACK_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxPlaybackState[] f249860a = null;
    private final String desc;

    public static LynxPlaybackState valueOf(String r100) {
        return (LynxPlaybackState) a.a(LynxPlaybackState.class, r100);
    }

    public static LynxPlaybackState[] values() {
        return (LynxPlaybackState[]) f249860a.clone();
    }

    static {
        LynxPlaybackState r100 = new LynxPlaybackState("PLAYBACK_STATE_START", 0, "start");
        PLAYBACK_STATE_START = r100;
        LynxPlaybackState r101 = new LynxPlaybackState("PLAYBACK_STATE_PLAYING", 1, "play");
        PLAYBACK_STATE_PLAYING = r101;
        LynxPlaybackState r102 = new LynxPlaybackState("PLAYBACK_STATE_PAUSED", 2, "pause");
        PLAYBACK_STATE_PAUSED = r102;
        LynxPlaybackState r103 = new LynxPlaybackState("PLAYBACK_STATE_STOPPED", 3, "stop");
        PLAYBACK_STATE_STOPPED = r103;
        LynxPlaybackState r104 = new LynxPlaybackState("PLAYBACK_STATE_ENDED", 4, "ended");
        PLAYBACK_STATE_ENDED = r104;
        LynxPlaybackState r105 = new LynxPlaybackState("PLAYBACK_STATE_ERROR", 5, "error");
        PLAYBACK_STATE_ERROR = r105;
        f249860a = new LynxPlaybackState[]{r100, r101, r102, r103, r104, r105};
    }

    public final String getDesc() {
        return this.desc;
    }

    public LynxPlaybackState(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
