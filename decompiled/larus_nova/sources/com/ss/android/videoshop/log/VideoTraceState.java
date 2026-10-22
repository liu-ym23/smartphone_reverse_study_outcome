package com.ss.android.videoshop.log;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoTraceState extends Enum<VideoTraceState> {
    public static final VideoTraceState CONTROLLER_CREATE_ENGINE = null;
    public static final VideoTraceState CONTROLLER_DO_ENGINE_PLAY = null;
    public static final VideoTraceState CONTROLLER_ENGINE_PREPARE = null;
    public static final VideoTraceState CONTROLLER_INTERCEPT_DO_PLAY = null;
    public static final VideoTraceState CONTROLLER_INTERCEPT_INIT_PLAY = null;
    public static final VideoTraceState CONTROLLER_INTERCEPT_PREPARE_PLAY = null;
    public static final VideoTraceState CONTROLLER_LOAD_STATE_ERROR = null;
    public static final VideoTraceState CONTROLLER_LOAD_STATE_PLAYABLE = null;
    public static final VideoTraceState CONTROLLER_LOAD_STATE_STALLED = null;
    public static final VideoTraceState CONTROLLER_ON_ERROR = null;
    public static final VideoTraceState CONTROLLER_ON_PREPARE = null;
    public static final VideoTraceState CONTROLLER_ON_PREPARED = null;
    public static final VideoTraceState CONTROLLER_ON_RENDER_START = null;
    public static final VideoTraceState CONTROLLER_ON_STATUS_EXCEPTION = null;
    public static final VideoTraceState CONTROLLER_PAUSE = null;
    public static final VideoTraceState CONTROLLER_PLAY = null;
    public static final VideoTraceState CONTROLLER_PLAY_STATE_ERROR = null;
    public static final VideoTraceState CONTROLLER_PLAY_STATE_PAUSED = null;
    public static final VideoTraceState CONTROLLER_PLAY_STATE_PLAYING = null;
    public static final VideoTraceState CONTROLLER_PLAY_STATE_STOPPED = null;
    public static final VideoTraceState CONTROLLER_PREPARE = null;
    public static final VideoTraceState CONTROLLER_RELEASE = null;
    public static final VideoTraceState CONTROLLER_RELEASE_ENGINE_WHEN_ERR = null;
    public static final VideoTraceState CONTROLLER_SEEK = null;
    public static final VideoTraceState CONTROLLER_SEEK_COMPLETE = null;
    public static final VideoTraceState CONTROLLER_SET_PARAMS_AND_PLAY = null;
    public static final VideoTraceState LAYER_HOST_PLAY = null;
    public static final VideoTraceState LAYER_HOST_RELEASE_LAST = null;
    public static final VideoTraceState SURFACE_AVAILABLE = null;
    public static final VideoTraceState TEXTURE_SIZE = null;
    public static final VideoTraceState VIDEO_PATCH_DO_PLAY = null;
    public static final VideoTraceState VIDEO_PATCH_PLAY_INTERNAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoTraceState[] f455980a = null;

    static {
        VideoTraceState r100 = new VideoTraceState("LAYER_HOST_PLAY", 0);
        LAYER_HOST_PLAY = r100;
        VideoTraceState r101 = new VideoTraceState("LAYER_HOST_RELEASE_LAST", 1);
        LAYER_HOST_RELEASE_LAST = r101;
        VideoTraceState r102 = new VideoTraceState("VIDEO_PATCH_PLAY_INTERNAL", 2);
        VIDEO_PATCH_PLAY_INTERNAL = r102;
        VideoTraceState r103 = new VideoTraceState("SURFACE_AVAILABLE", 3);
        SURFACE_AVAILABLE = r103;
        VideoTraceState r104 = new VideoTraceState("VIDEO_PATCH_DO_PLAY", 4);
        VIDEO_PATCH_DO_PLAY = r104;
        VideoTraceState r105 = new VideoTraceState("CONTROLLER_PREPARE", 5);
        CONTROLLER_PREPARE = r105;
        VideoTraceState r110 = new VideoTraceState("CONTROLLER_PLAY", 6);
        CONTROLLER_PLAY = r110;
        VideoTraceState r111 = new VideoTraceState("CONTROLLER_RELEASE_ENGINE_WHEN_ERR", 7);
        CONTROLLER_RELEASE_ENGINE_WHEN_ERR = r111;
        VideoTraceState r112 = new VideoTraceState("CONTROLLER_CREATE_ENGINE", 8);
        CONTROLLER_CREATE_ENGINE = r112;
        VideoTraceState r113 = new VideoTraceState("CONTROLLER_ENGINE_PREPARE", 9);
        CONTROLLER_ENGINE_PREPARE = r113;
        VideoTraceState r114 = new VideoTraceState("CONTROLLER_INTERCEPT_INIT_PLAY", 10);
        CONTROLLER_INTERCEPT_INIT_PLAY = r114;
        VideoTraceState r115 = new VideoTraceState("CONTROLLER_INTERCEPT_PREPARE_PLAY", 11);
        CONTROLLER_INTERCEPT_PREPARE_PLAY = r115;
        VideoTraceState r106 = new VideoTraceState("CONTROLLER_SET_PARAMS_AND_PLAY", 12);
        CONTROLLER_SET_PARAMS_AND_PLAY = r106;
        VideoTraceState r107 = new VideoTraceState("CONTROLLER_INTERCEPT_DO_PLAY", 13);
        CONTROLLER_INTERCEPT_DO_PLAY = r107;
        VideoTraceState r108 = new VideoTraceState("CONTROLLER_DO_ENGINE_PLAY", 14);
        CONTROLLER_DO_ENGINE_PLAY = r108;
        VideoTraceState r109 = new VideoTraceState("CONTROLLER_ON_PREPARE", 15);
        CONTROLLER_ON_PREPARE = r109;
        VideoTraceState r116 = new VideoTraceState("CONTROLLER_ON_PREPARED", 16);
        CONTROLLER_ON_PREPARED = r116;
        VideoTraceState r117 = new VideoTraceState("CONTROLLER_ON_RENDER_START", 17);
        CONTROLLER_ON_RENDER_START = r117;
        VideoTraceState r118 = new VideoTraceState("CONTROLLER_PLAY_STATE_PLAYING", 18);
        CONTROLLER_PLAY_STATE_PLAYING = r118;
        VideoTraceState r119 = new VideoTraceState("CONTROLLER_PLAY_STATE_ERROR", 19);
        CONTROLLER_PLAY_STATE_ERROR = r119;
        VideoTraceState r120 = new VideoTraceState("CONTROLLER_PLAY_STATE_STOPPED", 20);
        CONTROLLER_PLAY_STATE_STOPPED = r120;
        VideoTraceState r121 = new VideoTraceState("CONTROLLER_PLAY_STATE_PAUSED", 21);
        CONTROLLER_PLAY_STATE_PAUSED = r121;
        VideoTraceState r122 = new VideoTraceState("CONTROLLER_LOAD_STATE_PLAYABLE", 22);
        CONTROLLER_LOAD_STATE_PLAYABLE = r122;
        VideoTraceState r123 = new VideoTraceState("CONTROLLER_LOAD_STATE_STALLED", 23);
        CONTROLLER_LOAD_STATE_STALLED = r123;
        VideoTraceState r124 = new VideoTraceState("CONTROLLER_LOAD_STATE_ERROR", 24);
        CONTROLLER_LOAD_STATE_ERROR = r124;
        VideoTraceState r125 = new VideoTraceState("CONTROLLER_ON_ERROR", 25);
        CONTROLLER_ON_ERROR = r125;
        VideoTraceState r126 = new VideoTraceState("CONTROLLER_ON_STATUS_EXCEPTION", 26);
        CONTROLLER_ON_STATUS_EXCEPTION = r126;
        VideoTraceState r127 = new VideoTraceState("CONTROLLER_PAUSE", 27);
        CONTROLLER_PAUSE = r127;
        VideoTraceState r128 = new VideoTraceState("CONTROLLER_SEEK", 28);
        CONTROLLER_SEEK = r128;
        VideoTraceState r129 = new VideoTraceState("CONTROLLER_SEEK_COMPLETE", 29);
        CONTROLLER_SEEK_COMPLETE = r129;
        VideoTraceState r130 = new VideoTraceState("CONTROLLER_RELEASE", 30);
        CONTROLLER_RELEASE = r130;
        VideoTraceState r131 = new VideoTraceState("TEXTURE_SIZE", 31);
        TEXTURE_SIZE = r131;
        f455980a = new VideoTraceState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
    }

    public static VideoTraceState[] values() {
        return (VideoTraceState[]) f455980a.clone();
    }

    public static VideoTraceState valueOf(String r100) {
        return (VideoTraceState) a.a(VideoTraceState.class, r100);
    }

    public VideoTraceState(String r100, int r101) {
        super(r100, r101);
    }
}
