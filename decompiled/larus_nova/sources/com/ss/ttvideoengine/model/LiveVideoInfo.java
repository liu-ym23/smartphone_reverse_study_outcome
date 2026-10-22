package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class LiveVideoInfo {
    public String mBackupUrl;
    public String mMainUrl;
    public String[] mURLs;

    public LiveVideoInfo() {
    }

    public void extractFields(JSONObject r100) {
        ArrayList r101 = new ArrayList();
        String r102 = r100.optString("main_play_url");
        this.mMainUrl = r102;
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r101.add(this.mMainUrl);
    L5:
        String r103 = r100.optString("backup_play_url");
        this.mBackupUrl = r103;
        if (TextUtils.isEmpty(r103) == true) goto L8;
        r101.add(this.mBackupUrl);
    L8:
        String[] r104 = new String[r101.size()];
        this.mURLs = r104;
        r101.toArray(r104);
    }
}
