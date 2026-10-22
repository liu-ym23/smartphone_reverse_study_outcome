package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/api/VideoEngineState;", "", "<init>", "(Ljava/lang/String;I)V", "LOAD_STATE_STALLED", "LOAD_STATE_ERROR", "PLAYBACK_STATE_PLAYING", "PLAYBACK_STATE_PAUSED", "PLAYBACK_STATE_STOPPED", "PLAYBACK_STATE_ERROR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoEngineState extends Enum<VideoEngineState> {
    public static final VideoEngineState LOAD_STATE_ERROR = null;
    public static final VideoEngineState LOAD_STATE_STALLED = null;
    public static final VideoEngineState PLAYBACK_STATE_ERROR = null;
    public static final VideoEngineState PLAYBACK_STATE_PAUSED = null;
    public static final VideoEngineState PLAYBACK_STATE_PLAYING = null;
    public static final VideoEngineState PLAYBACK_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoEngineState[] f364859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364860b = null;

    public static EnumEntries<VideoEngineState> getEntries() {
        return f364860b;
    }

    static {
        VideoEngineState r100 = new VideoEngineState("LOAD_STATE_STALLED", 0);
        LOAD_STATE_STALLED = r100;
        VideoEngineState r101 = new VideoEngineState("LOAD_STATE_ERROR", 1);
        LOAD_STATE_ERROR = r101;
        VideoEngineState r102 = new VideoEngineState("PLAYBACK_STATE_PLAYING", 2);
        PLAYBACK_STATE_PLAYING = r102;
        VideoEngineState r103 = new VideoEngineState("PLAYBACK_STATE_PAUSED", 3);
        PLAYBACK_STATE_PAUSED = r103;
        VideoEngineState r104 = new VideoEngineState("PLAYBACK_STATE_STOPPED", 4);
        PLAYBACK_STATE_STOPPED = r104;
        VideoEngineState r105 = new VideoEngineState("PLAYBACK_STATE_ERROR", 5);
        PLAYBACK_STATE_ERROR = r105;
        VideoEngineState[] r110 = {r100, r101, r102, r103, r104, r105};
        f364859a = r110;
        f364860b = EnumEntriesKt.enumEntries(r110);
    }

    public static VideoEngineState[] values() {
        return (VideoEngineState[]) f364859a.clone();
    }

    public static VideoEngineState valueOf(String r100) {
        return (VideoEngineState) r27.a.a(VideoEngineState.class, r100);
    }

    public VideoEngineState(String r100, int r101) {
        super(r100, r101);
    }
}
