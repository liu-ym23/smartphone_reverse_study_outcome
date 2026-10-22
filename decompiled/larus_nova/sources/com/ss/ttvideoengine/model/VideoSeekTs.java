package com.ss.ttvideoengine.model;

import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoSeekTs {
    public static final String KEY_ENDING = "ending";
    public static final String KEY_OPENING = "opening";
    private static final String KEY_VER2_ENDING = "Ending";
    private static final String KEY_VER2_OPENING = "Opening";
    public static final int VALUE_VIDEO_SEEKTS_ENDING = 1;
    public static final int VALUE_VIDEO_SEEKTS_OPENING = 0;
    public float mEnding;
    private float mEndingVer2;
    public float mOpening;
    private float mOpeningVer2;
    private int mVersion;

    public void parseFromPb(VideoModelPb.SeekOffSet r100) {
    }

    public VideoSeekTs() {
        this.mOpening = -1.0f;
        this.mEnding = -1.0f;
        this.mOpeningVer2 = -1.0f;
        this.mEndingVer2 = -1.0f;
        this.mVersion = 1;
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.has(KEY_OPENING) == false) goto L7;
    L18:
        this.mVersion = 1;
        this.mOpening = (float) r100.optDouble(KEY_OPENING);     // Catch: Exception -> L21
        this.mEnding = (float) r100.optDouble(KEY_ENDING);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    L7:
        if (r100.has(KEY_ENDING) == true) goto L18;
        if (r100.has(KEY_VER2_ENDING) == false) goto L12;
    L13:
        this.mVersion = 2;
        this.mOpeningVer2 = (float) r100.optDouble(KEY_VER2_OPENING);     // Catch: Exception -> L16
        this.mEndingVer2 = (float) r100.optDouble(KEY_VER2_ENDING);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    L12:
        if (r100.has(KEY_VER2_OPENING) == true) goto L13;
    }

    public float getValueFloat(int r100) {
        if (this.mVersion != 2) goto L11;
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return -1.0f;
    L8:
        return this.mEndingVer2;
    L10:
        return this.mOpeningVer2;
    L11:
        if (r100 == 0) goto L17;
        if (r100 == 1) goto L15;
        return -1.0f;
    L15:
        return this.mEnding;
    L17:
        return this.mOpening;
    }

    public void setVersion(int r100) {
        this.mVersion = r100;
    }
}
