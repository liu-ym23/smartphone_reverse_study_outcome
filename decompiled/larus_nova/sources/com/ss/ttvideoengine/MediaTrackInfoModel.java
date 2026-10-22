package com.ss.ttvideoengine;

import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class MediaTrackInfoModel implements MediaTrackInfoModelProvider {
    private final String mGroupId;
    private final int mIndex;
    private final String mLanguage;
    private final String mName;
    private final int mType;

    @Override // com.ss.ttvideoengine.MediaTrackInfoModelProvider
    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("index", this.mIndex);     // Catch: JSONException -> L5
        r100.put("type", this.mType);     // Catch: JSONException -> L5
        r100.put("language", this.mLanguage);     // Catch: JSONException -> L5
        r100.put("name", this.mName);     // Catch: JSONException -> L5
        r100.put("group_id", this.mGroupId);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        TTVideoEngineLog.d(e);
        goto L7
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }

    public MediaTrackInfoModel(JSONObject r100) {
        this.mIndex = r100.optInt("index");
        this.mType = r100.optInt("type");
        this.mLanguage = r100.optString("language");
        this.mName = r100.optString("name");
        this.mGroupId = r100.optString("group_id");
    }
}
