package com.ss.ttvideoengine;

import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SubModel implements SubModelProvider {
    private final long mExpireTime;
    private final String mFormat;
    private final int mIndex;
    private final String mLanguage;
    private final int mLanguageId;
    private final int mSubId;
    private final String mUrlString;

    @Override // com.ss.ttvideoengine.SubModelProvider
    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("url", this.mUrlString);     // Catch: JSONException -> L5
        r100.put(SubInfo.KEY_LANGUAGE_ID, this.mLanguageId);     // Catch: JSONException -> L5
        r100.put(SubInfo.KEY_FORMAT, this.mFormat);     // Catch: JSONException -> L5
        r100.put("language", this.mLanguage);     // Catch: JSONException -> L5
        r100.put("id", this.mIndex);     // Catch: JSONException -> L5
        r100.put("expire", this.mExpireTime);     // Catch: JSONException -> L5
        r100.put(SubInfo.KEY_SUB_ID, this.mSubId);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        TTVideoEngineLog.d(e);
        goto L7
    }

    @Override // com.ss.ttvideoengine.SubModelProvider
    public String toString() {
        JSONObject r100 = toJson();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.has("url") == true) goto L8;
        return null;
    L8:
        if (r100.has(SubInfo.KEY_LANGUAGE_ID) == true) goto L10;
        return null;
    L10:
        if (r100.has(SubInfo.KEY_FORMAT) == true) goto L12;
        return null;
    L12:
        if (r100.has(SubInfo.KEY_SUB_ID) == true) goto L14;
        return null;
    L14:
        return r100.toString();
    }

    public long getExpireTime() {
        return this.mExpireTime;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public int getLanguageId() {
        return this.mLanguageId;
    }

    public int getSubId() {
        return this.mSubId;
    }

    public String getUrlString() {
        return this.mUrlString;
    }

    public SubModel(JSONObject r100) {
        this.mUrlString = r100.optString("url");
        this.mLanguageId = r100.optInt(SubInfo.KEY_LANGUAGE_ID);
        this.mFormat = r100.optString(SubInfo.KEY_FORMAT);
        this.mLanguage = r100.optString("language");
        this.mIndex = r100.optInt("id");
        this.mExpireTime = r100.optLong("expire");
        this.mSubId = r100.optInt(SubInfo.KEY_SUB_ID);
    }
}
