package com.ss.ttvideoengine.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoAdaptiveInfo {
    public static final String KEY_ADAPTIVE_TYPE = "AdaptiveType";
    public static final String KEY_BACKUP_PLAY_URL = "BackupPlayUrl";
    public static final String KEY_MAIN_PLAY_URL = "MainPlayUrl";
    private String mAdaptiveType;
    private String mBackupPlayUrl;
    private String mMainPlayUrl;

    public VideoAdaptiveInfo() {
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mAdaptiveType = r100.optString(KEY_ADAPTIVE_TYPE);
        this.mMainPlayUrl = r100.optString(KEY_MAIN_PLAY_URL);
        this.mBackupPlayUrl = r100.optString(KEY_BACKUP_PLAY_URL);
    }

    public String getValueStr(int r100) {
        if (r100 == 108) goto L15;
        if (r100 == 109) goto L13;
        if (r100 == 215) goto L11;
        return "";
    L11:
        return this.mAdaptiveType;
    L13:
        return this.mBackupPlayUrl;
    L15:
        return this.mMainPlayUrl;
    }
}
