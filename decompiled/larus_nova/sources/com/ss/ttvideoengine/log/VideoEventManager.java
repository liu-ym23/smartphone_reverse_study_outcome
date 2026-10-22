package com.ss.ttvideoengine.log;

import android.content.Context;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final enum VideoEventManager extends Enum<VideoEventManager> {
    private static final /* synthetic */ VideoEventManager[] $VALUES = null;
    public static final int LOGGER_VERSION_NEW = 2;
    public static final int LOGGER_VERSION_OLD = 1;
    private static final int MAX_LOG_LINE_LENGTH = 3900;
    private static final String TAG = "VideoEventManager";
    public static final VideoEventManager instance = null;
    private Context mContext;
    private VideoEventEngineUploader mEngineUploader;
    private JSONArray mJsonArray;
    private JSONArray mJsonArrayV2;
    private VideoEventListener mListener;
    private int mLoggerVersion;
    private IVideoEventUploader mUploader;

    public static /* synthetic */ void a(JSONObject r100) {
        lambda$addEventV2$3(r100);
    }

    public static /* synthetic */ void b(JSONObject r100) {
        lambda$addEvent$0(r100);
    }

    public static /* synthetic */ void c(JSONObject r100) {
        lambda$addEventV2$2(r100);
    }

    public static /* synthetic */ void d(JSONObject r100) {
        lambda$addEvent$1(r100);
    }

    public synchronized JSONArray popAllEvents() {
        monitor-enter(this);
        JSONArray r100 = this.mJsonArray;     // Catch: Throwable -> L6
        this.mJsonArray = new JSONArray();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        VideoEventManager r100 = new VideoEventManager("instance", 0);
        instance = r100;
        $VALUES = new VideoEventManager[]{r100};
    }

    public static VideoEventManager[] values() {
        return (VideoEventManager[]) $VALUES.clone();
    }

    public int getLoggerVersion() {
        TTVideoEngineLog.e(TAG, "getLoggerVersion: " + this.mLoggerVersion);
        return this.mLoggerVersion;
    }

    public JSONArray popAllEventsV2() {
        JSONArray r100 = this.mJsonArrayV2;
        monitor-enter(VideoEventManager.class);
        this.mJsonArrayV2 = new JSONArray();     // Catch: Throwable -> L7
        monitor-exit(VideoEventManager.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$addEvent$0(JSONObject r100) {
        showEvent(r100);
    }

    private static /* synthetic */ void lambda$addEvent$1(JSONObject r100) {
        showEvent(r100);
    }

    private static /* synthetic */ void lambda$addEventV2$2(JSONObject r100) {
        showEvent(r100);
    }

    private static /* synthetic */ void lambda$addEventV2$3(JSONObject r100) {
        showEvent(r100);
    }

    public static void showEvent(JSONObject r100) {
        if (((TTVideoEngineLog.getLogNotifyLevel() >> 1) & 1) != 1) goto L5;
    L11:
        showLongLog(r100.toString());     // Catch: ConcurrentModificationException -> L8
        return;
    L8:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.toString());
        return;
    L5:
        if (((TTVideoEngineLog.getLogTurnOn() >> 1) & 1) == 1) goto L11;
    }

    private static void showLongLog(String r100) {
        if (r100 == null) goto L12;
        int r101 = r100.length();
        int r102 = MAX_LOG_LINE_LENGTH;
        if (r101 <= MAX_LOG_LINE_LENGTH) goto L12;
        int r103 = r100.length();
        int r104 = 0;
    L8:
        if (r102 >= r103) goto L10;
        TTVideoEngineLog.d(TAG, r100.substring(r104, r102));
        r104 = r104 + MAX_LOG_LINE_LENGTH;
        r102 = Math.min(r102 + MAX_LOG_LINE_LENGTH, r103);
        goto L8
    L10:
        TTVideoEngineLog.d(TAG, r100.substring(r104, r102));
        return;
    L12:
        TTVideoEngineLog.d(TAG, r100);
    }

    public static VideoEventManager valueOf(String r100) {
        return (VideoEventManager) r27.a.a(VideoEventManager.class, r100);
    }

    public void setContext(Context r100) {
        this.mContext = r100.getApplicationContext();
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader r100) {
        monitor-enter(this);
        this.mEngineUploader = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setListener(VideoEventListener r100) {
        this.mListener = r100;
    }

    public void setLoggerVersion(int r100) {
        TTVideoEngineLog.e(TAG, "setLoggerVersion: " + r100);
        if (r100 != 1) goto L5;
    L6:
        this.mLoggerVersion = r100;
        return;
    L5:
        if (r100 == 2) goto L6;
    }

    public void setUploader(IVideoEventUploader r100) {
        this.mUploader = r100;
    }

    private VideoEventManager(String r100, int r101) {
        super(r100, r101);
        this.mListener = null;
        this.mJsonArray = new JSONArray();
        this.mJsonArrayV2 = new JSONArray();
        this.mLoggerVersion = 2;
    }

    public void addEvent(boolean r100, final JSONObject r101) {
        monitor-enter(VideoEventManager.class);
        if (r101 != null) goto L7;
        monitor-exit(VideoEventManager.class);     // Catch: Throwable -> L21
        return;
    L7:
        TTVideoEngineLog.d(TAG, "addEvent  uploadLog = " + r100);     // Catch: Throwable -> L21
        VideoEventEngineUploader r102 = this.mEngineUploader;     // Catch: Throwable -> L21
        if (r102 == null) goto L10;
        r102.onEvent("video_playq", r101);     // Catch: Throwable -> L21
    L19:
        monitor-exit(VideoEventManager.class);     // Catch: Throwable -> L21
        return;
    L10:
        IVideoEventUploader r103 = this.mUploader;     // Catch: Throwable -> L21
        if (r103 == null) goto L15;
        if (r100 == false) goto L15;
        r103.onUplaod("video_playq", r101);     // Catch: Throwable -> L21
        EngineThreadPool.addExecuteTask(new m(r101));     // Catch: Throwable -> L21
    L15:
        if (this.mListener == null) goto L17;
        this.mJsonArray.put(r101);     // Catch: Throwable -> L21
        this.mListener.onEvent();     // Catch: Throwable -> L21
    L18:
        EngineThreadPool.addExecuteTask(new n(r101));     // Catch: Throwable -> L21
        goto L19
    L17:
        TTVideoEngineLog.e(TAG, "no listener set");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public void addEventV2(boolean r100, final JSONObject r101, String r102) {
        monitor-enter(VideoEventManager.class);
        if (r101 != null) goto L7;
        monitor-exit(VideoEventManager.class);     // Catch: Throwable -> L21
        return;
    L7:
        TTVideoEngineLog.d(TAG, "addEventV2  uploadLog = " + r100 + ", listener:" + this.mListener + ", uploader:" + this.mUploader);     // Catch: Throwable -> L21
        VideoEventEngineUploader r103 = this.mEngineUploader;     // Catch: Throwable -> L21
        if (r103 == null) goto L10;
        r103.onEventV2(r102, r101);     // Catch: Throwable -> L21
    L19:
        monitor-exit(VideoEventManager.class);     // Catch: Throwable -> L21
        return;
    L10:
        IVideoEventUploader r104 = this.mUploader;     // Catch: Throwable -> L21
        if (r104 == null) goto L15;
        if (r100 == false) goto L15;
        r104.onUplaod(r102, r101);     // Catch: Throwable -> L21
        EngineThreadPool.addExecuteTask(new o(r101));     // Catch: Throwable -> L21
    L15:
        if (this.mListener == null) goto L17;
        this.mJsonArrayV2.put(r101);     // Catch: Throwable -> L21
        this.mListener.onEventV2(r102);     // Catch: Throwable -> L21
    L18:
        EngineThreadPool.addExecuteTask(new p(r101));     // Catch: Throwable -> L21
        goto L19
    L17:
        TTVideoEngineLog.e(TAG, "no listener set");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
