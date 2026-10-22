package com.ss.ttvideoengine.preload;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PreloadScene {
    private List<PreloadTaskConfig> configs;
    private String mAlgorithmName;
    public int mAutoPlay;
    public String mBriefSceneId;
    private String mConfigString;
    public int mMaxVisibleCardCnt;
    public int mMute;
    public String mSceneId;

    public String toJsonString() {
        HashMap r100 = new HashMap();
        r100.put("scene_id", this.mSceneId);
        r100.put("brief_scene_id", this.mBriefSceneId);
        r100.put("auto_play", Integer.valueOf(this.mAutoPlay));
        r100.put(ITTVideoEngineEventSource.KEY_MUTE, Integer.valueOf(this.mMute));
        r100.put("card_cnt", Integer.valueOf(this.mMaxVisibleCardCnt));
        r100.put("json", this.mConfigString);
        return new JSONObject(r100).toString();
    }

    public PreloadScene(String r100) {
        this.mBriefSceneId = null;
        this.mAutoPlay = 0;
        this.mMute = 0;
        this.mMaxVisibleCardCnt = 1;
        this.mConfigString = null;
        this.mAlgorithmName = null;
        this.configs = null;
        this.mSceneId = r100;
    }

    public void setAlgorithmName(String r100) {
        this.mAlgorithmName = r100;
    }

    public void setConfigJsonString(String r100) {
        this.mConfigString = r100;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        this.mAlgorithmName = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "preload_strategy"), "name");     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        TTVideoEngineLog.i("Scene", e.toString());
    }

    public void setConfigs(List<PreloadTaskConfig> r100) {
        this.configs = r100;
    }
}
