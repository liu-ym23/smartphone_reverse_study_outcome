package com.ss.ttvideoengine.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class LiveVideoRef {
    public static final int LIVE_STATUS_DOING = 3;
    public static final int LIVE_STATUS_END = 1;
    public static final int LIVE_STATUS_ERROR = 0;
    public static final int LIVE_STATUS_WAIT = 2;
    public int mBackupStatus;
    public long mEndTime;
    public String mLiveId;
    public int mLiveStatus;
    public LiveVideoInfo mLiveVideo1;
    public LiveVideoInfo mLiveVideo2;
    public long mStartTime;
    public int mStatus;
    public String mUserId;

    public LiveVideoRef() {
    }

    public LiveVideoInfo getLiveVideoInfo() {
        LiveVideoInfo r100 = this.mLiveVideo1;
        if (r100 == null) goto L5;
        return r100;
    L5:
        LiveVideoInfo r101 = this.mLiveVideo2;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return null;
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r101 = r100.optJSONObject("live_info");
    L14:
        e = move-exception;
        TTVideoEngineLog.d(e);
    L16:
        this.mUserId = r100.optString("user_id");
        this.mLiveId = r100.optString("live_id");
        return;
    L7:
        if (r101.has("live_0") == false) goto L10;
        LiveVideoInfo r102 = new LiveVideoInfo();     // Catch: JSONException -> L14
        this.mLiveVideo1 = r102;     // Catch: JSONException -> L14
        r102.extractFields(JSONObjectProtectorUtils.getJSONObject(r101, "live_0"));     // Catch: JSONException -> L14
    L10:
        if (r101.has("live_1") == false) goto L12;
        LiveVideoInfo r103 = new LiveVideoInfo();     // Catch: JSONException -> L14
        this.mLiveVideo2 = r103;     // Catch: JSONException -> L14
        r103.extractFields(JSONObjectProtectorUtils.getJSONObject(r101, "live_1"));     // Catch: JSONException -> L14
    L12:
        this.mBackupStatus = r101.optInt("backup_status");     // Catch: JSONException -> L14
        this.mLiveStatus = r101.optInt("live_status");     // Catch: JSONException -> L14
        this.mStatus = r101.optInt("status");     // Catch: JSONException -> L14
        this.mStartTime = r101.optLong(ILoadStallMonitor.START_TIME);     // Catch: JSONException -> L14
        this.mEndTime = r101.optLong("end_time");     // Catch: JSONException -> L14
        goto L16
    }
}
