package com.ss.android.videoshop.controller;

import android.util.SparseArray;
import com.bytedance.android.live.broadcast.api.monitor.LiveStreamCodeMonitor$OnInfoType;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AsyncVideoMsg extends Enum<AsyncVideoMsg> {
    public static final AsyncVideoMsg BUFFERING_UPDATE = null;
    public static final AsyncVideoMsg BUFFER_COUNT = null;
    public static final AsyncVideoMsg BUFFER_END = null;
    public static final AsyncVideoMsg BUFFER_START = null;
    public static final AsyncVideoMsg ERROR = null;
    public static final AsyncVideoMsg EXEC_COMMAND = null;
    public static final AsyncVideoMsg FETCH_VIDEO_MODEL = null;
    public static final AsyncVideoMsg FULLSCREEN = null;
    public static final AsyncVideoMsg INIT_PLAY = null;
    public static final AsyncVideoMsg INTERCEPT_FULLSCREEN = null;
    public static final AsyncVideoMsg LOAD_STATE_CHANGED = null;
    public static final AsyncVideoMsg PAUSE = null;
    public static final AsyncVideoMsg PLAY = null;
    public static final AsyncVideoMsg PLAYBACK_STATE_CHANGED = null;
    public static final AsyncVideoMsg PLAY_START = null;
    public static final AsyncVideoMsg PREPARE = null;
    public static final AsyncVideoMsg PREPARED = null;
    public static final AsyncVideoMsg PRE_FULLSCREEN = null;
    public static final AsyncVideoMsg PRE_VIDEO_SEEK = null;
    public static final AsyncVideoMsg RELEASE = null;
    public static final AsyncVideoMsg RENDER_SEEK_COMPLETE = null;
    public static final AsyncVideoMsg RENDER_START = null;
    public static final AsyncVideoMsg REPLAY = null;
    public static final AsyncVideoMsg RESOLUTION_CHANGED = null;
    public static final AsyncVideoMsg RETRY = null;
    public static final AsyncVideoMsg SEEK = null;
    public static final AsyncVideoMsg SEEK_COMPLETE = null;
    public static final AsyncVideoMsg SEEK_START = null;
    public static final AsyncVideoMsg STREAM_BITRATE_CHANGED = null;
    public static final AsyncVideoMsg STREAM_CHANGED = null;
    public static final AsyncVideoMsg UPDATE_PROGRESS = null;
    public static final AsyncVideoMsg UPDATE_VIDEO_SIZE = null;
    public static final AsyncVideoMsg VIDEO_COMPLETED = null;
    public static final AsyncVideoMsg VIDEO_PAUSE = null;
    public static final AsyncVideoMsg VIDEO_PLAY = null;
    public static final AsyncVideoMsg VIDEO_PRE_COMPLETED = null;
    public static final AsyncVideoMsg VIDEO_PRE_RELEASE = null;
    public static final AsyncVideoMsg VIDEO_RELEASED = null;
    public static final AsyncVideoMsg VIDEO_SIZE_CHANGED = null;
    public static final AsyncVideoMsg VIDEO_STATUS_EXCEPTION = null;
    public static final AsyncVideoMsg VIDEO_THREAD_QUIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<AsyncVideoMsg> f455972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AsyncVideoMsg[] f455973b = null;
    private int what;

    static {
        AsyncVideoMsg r100 = new AsyncVideoMsg(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0, 101);
        PLAY = r100;
        AsyncVideoMsg r101 = new AsyncVideoMsg("PAUSE", 1, 102);
        PAUSE = r101;
        AsyncVideoMsg r102 = new AsyncVideoMsg("RELEASE", 2, 103);
        RELEASE = r102;
        AsyncVideoMsg r103 = new AsyncVideoMsg("SEEK", 3, 104);
        SEEK = r103;
        AsyncVideoMsg r104 = new AsyncVideoMsg("UPDATE_PROGRESS", 4, 201);
        UPDATE_PROGRESS = r104;
        AsyncVideoMsg r105 = new AsyncVideoMsg("VIDEO_SIZE_CHANGED", 5, 202);
        VIDEO_SIZE_CHANGED = r105;
        AsyncVideoMsg r110 = new AsyncVideoMsg("INIT_PLAY", 6, 203);
        INIT_PLAY = r110;
        AsyncVideoMsg r111 = new AsyncVideoMsg("PLAY_START", 7, 204);
        PLAY_START = r111;
        AsyncVideoMsg r112 = new AsyncVideoMsg("FETCH_VIDEO_MODEL", 8, 205);
        FETCH_VIDEO_MODEL = r112;
        AsyncVideoMsg r113 = new AsyncVideoMsg("PREPARE", 9, 206);
        PREPARE = r113;
        AsyncVideoMsg r114 = new AsyncVideoMsg("PREPARED", 10, 207);
        PREPARED = r114;
        AsyncVideoMsg r106 = new AsyncVideoMsg(ChameleonOpenTracker.EventType.RENDER_START, 11, 208);
        RENDER_START = r106;
        AsyncVideoMsg r107 = new AsyncVideoMsg("VIDEO_PLAY", 12, 209);
        VIDEO_PLAY = r107;
        AsyncVideoMsg r108 = new AsyncVideoMsg("VIDEO_PAUSE", 13, 210);
        VIDEO_PAUSE = r108;
        AsyncVideoMsg r109 = new AsyncVideoMsg("PLAYBACK_STATE_CHANGED", 14, 211);
        PLAYBACK_STATE_CHANGED = r109;
        AsyncVideoMsg r115 = new AsyncVideoMsg("LOAD_STATE_CHANGED", 15, 212);
        LOAD_STATE_CHANGED = r115;
        AsyncVideoMsg r116 = new AsyncVideoMsg("BUFFER_START", 16, 213);
        BUFFER_START = r116;
        AsyncVideoMsg r117 = new AsyncVideoMsg("BUFFER_COUNT", 17, 214);
        BUFFER_COUNT = r117;
        AsyncVideoMsg r118 = new AsyncVideoMsg("BUFFERING_UPDATE", 18, 215);
        BUFFERING_UPDATE = r118;
        AsyncVideoMsg r119 = new AsyncVideoMsg("BUFFER_END", 19, 216);
        BUFFER_END = r119;
        AsyncVideoMsg r120 = new AsyncVideoMsg("STREAM_CHANGED", 20, 217);
        STREAM_CHANGED = r120;
        AsyncVideoMsg r121 = new AsyncVideoMsg("VIDEO_PRE_COMPLETED", 21, 218);
        VIDEO_PRE_COMPLETED = r121;
        AsyncVideoMsg r122 = new AsyncVideoMsg("VIDEO_COMPLETED", 22, 219);
        VIDEO_COMPLETED = r122;
        AsyncVideoMsg r123 = new AsyncVideoMsg("VIDEO_PRE_RELEASE", 23, 220);
        VIDEO_PRE_RELEASE = r123;
        AsyncVideoMsg r124 = new AsyncVideoMsg("VIDEO_RELEASED", 24, 221);
        VIDEO_RELEASED = r124;
        AsyncVideoMsg r125 = new AsyncVideoMsg("ERROR", 25, 222);
        ERROR = r125;
        AsyncVideoMsg r126 = new AsyncVideoMsg(LiveStreamCodeMonitor$OnInfoType.MSG_INFO_RESOLUTION_CHANGED, 26, 223);
        RESOLUTION_CHANGED = r126;
        AsyncVideoMsg r127 = new AsyncVideoMsg("PRE_FULLSCREEN", 27, 224);
        PRE_FULLSCREEN = r127;
        AsyncVideoMsg r128 = new AsyncVideoMsg("FULLSCREEN", 28, 225);
        FULLSCREEN = r128;
        AsyncVideoMsg r129 = new AsyncVideoMsg("INTERCEPT_FULLSCREEN", 29, 226);
        INTERCEPT_FULLSCREEN = r129;
        AsyncVideoMsg r130 = new AsyncVideoMsg("EXEC_COMMAND", 30, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL);
        EXEC_COMMAND = r130;
        AsyncVideoMsg r131 = new AsyncVideoMsg("VIDEO_STATUS_EXCEPTION", 31, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2);
        VIDEO_STATUS_EXCEPTION = r131;
        AsyncVideoMsg r132 = new AsyncVideoMsg("PRE_VIDEO_SEEK", 32, 229);
        PRE_VIDEO_SEEK = r132;
        AsyncVideoMsg r133 = new AsyncVideoMsg("SEEK_START", 33, 230);
        SEEK_START = r133;
        AsyncVideoMsg r134 = new AsyncVideoMsg("SEEK_COMPLETE", 34, 231);
        SEEK_COMPLETE = r134;
        AsyncVideoMsg r135 = new AsyncVideoMsg("RENDER_SEEK_COMPLETE", 35, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        RENDER_SEEK_COMPLETE = r135;
        AsyncVideoMsg r136 = new AsyncVideoMsg("REPLAY", 36, 233);
        REPLAY = r136;
        AsyncVideoMsg r137 = new AsyncVideoMsg("RETRY", 37, 234);
        RETRY = r137;
        AsyncVideoMsg r138 = new AsyncVideoMsg("STREAM_BITRATE_CHANGED", 38, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL);
        STREAM_BITRATE_CHANGED = r138;
        AsyncVideoMsg r139 = new AsyncVideoMsg("UPDATE_VIDEO_SIZE", 39, 301);
        UPDATE_VIDEO_SIZE = r139;
        AsyncVideoMsg r140 = new AsyncVideoMsg("VIDEO_THREAD_QUIT", 40, 302);
        VIDEO_THREAD_QUIT = r140;
        f455973b = new AsyncVideoMsg[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140};
        f455972a = new SparseArray();
    }

    public static void a() {
        if (f455972a.size() > 0) goto L7;
        AsyncVideoMsg[] r100 = values();
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        AsyncVideoMsg r103 = r100[r102];
        f455972a.put(r103.what, r103);
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public static AsyncVideoMsg[] values() {
        return (AsyncVideoMsg[]) f455973b.clone();
    }

    public int getWhat() {
        a();
        return this.what;
    }

    public static AsyncVideoMsg getMsg(int r100) {
        a();
        return f455972a.get(r100);
    }

    public static AsyncVideoMsg valueOf(String r100) {
        return (AsyncVideoMsg) a.a(AsyncVideoMsg.class, r100);
    }

    public AsyncVideoMsg(String r100, int r101, int r102) {
        super(r100, r101);
        this.what = r102;
    }
}
