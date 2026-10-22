package com.ss.bduploader;

import android.text.TextUtils;
import com.ss.bduploader.logupload.AppLogEngineUploader;
import com.ss.bduploader.logupload.VideoEventEngineUploader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final enum UploadEventManager extends Enum<UploadEventManager> {
    private static final /* synthetic */ UploadEventManager[] $VALUES = null;
    private static final String TAG = "UploadEventManager";
    public static final UploadEventManager instance = null;
    private boolean mEnableUseEngineUploader;
    private VideoEventEngineUploader mEngineUploader;
    private JSONArray mJsonArray;

    static {
        UploadEventManager r100 = new UploadEventManager("instance", 0);
        instance = r100;
        $VALUES = new UploadEventManager[]{r100};
    }

    public static UploadEventManager[] values() {
        return (UploadEventManager[]) $VALUES.clone();
    }

    public JSONArray popAllEvents() {
        JSONArray r100 = this.mJsonArray;
        monitor-enter(UploadEventManager.class);
        this.mJsonArray = new JSONArray();     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static UploadEventManager valueOf(String r100) {
        return (UploadEventManager) r27.a.a(UploadEventManager.class, r100);
    }

    public void addEvent(JSONObject r100) {
        monitor-enter(UploadEventManager.class);
        if (r100 != null) goto L24;
    L17:
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L24:
        if (this.mEngineUploader != null) goto L8;
    L16:
        this.mJsonArray.put(r100);     // Catch: Throwable -> L19
        goto L17
    L8:
        if (this.mEnableUseEngineUploader == false) goto L16;
        String r101 = r100.getString("event");     // Catch: JSONException -> L11 Throwable -> L19
    L14:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        this.mEngineUploader.onEventV3(r101, r100);     // Catch: Throwable -> L19
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        r101 = null;
        goto L14
    }

    public void putEvent(JSONObject r100) {
        monitor-enter(UploadEventManager.class);
        this.mJsonArray.put(r100);     // Catch: Throwable -> L9
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
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

    public void setUseEngineUploader(boolean r100) {
        this.mEnableUseEngineUploader = r100;
    }

    private UploadEventManager(String r100, int r101) {
        super(r100, r101);
        this.mJsonArray = new JSONArray();
        this.mEnableUseEngineUploader = true;
        setEngineUploader(AppLogEngineUploader.getInstance());
    }
}
