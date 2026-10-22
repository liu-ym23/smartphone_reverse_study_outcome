package com.ss.ttvideoengine.log;

import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoFilterMonitor {
    private static final String TAG = "VideoFilterMonitor";
    private final ArrayList<String> mHistoryList;
    private boolean mIsFilterOn;

    public VideoFilterMonitor() {
        this.mHistoryList = new ArrayList();
    }

    public ArrayList<String> getList() {
        return this.mHistoryList;
    }

    private boolean isEyeProtectionModeOn(Bundle r100) {
        int r101 = r100.getInt("action");
        if (r100.getInt("effect_type") == 2) goto L6;
        return false;
    L6:
        if (r101 != 21) goto L12;
        if (r100.getInt(TextureRenderKeys.KEY_IS_USE_EFFECT) != 1) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (r101 == 19) goto L14;
        return false;
    L14:
        if (r100.getInt(TextureRenderKeys.KEY_IS_INT_VALUE) != 1) goto L19;
        return true;
    L19:
        return false;
    }

    private void updateHistory(boolean r100) {
        HashMap r101 = new HashMap();
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101.put("on", r102);
        r101.put("t", Long.valueOf(System.currentTimeMillis()));
        TTVideoEngineUtils.addToList(this.mHistoryList, new JSONObject(r101).toString());
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public void setEffect(Bundle r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getInt("effect_type") == 2) goto L8;
        TTVideoEngineLog.d(TAG, "not eye protection filter bundle");
        return;
    L8:
        boolean r101 = isEyeProtectionModeOn(r100);
        if (r101 == this.mIsFilterOn) goto L12;
        this.mIsFilterOn = r101;
        updateHistory(r101);
        return;
    }
}
