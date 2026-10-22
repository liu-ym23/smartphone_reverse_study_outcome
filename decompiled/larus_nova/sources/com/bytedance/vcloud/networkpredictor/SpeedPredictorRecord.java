package com.bytedance.vcloud.networkpredictor;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorRecord {
    private String mFileId;
    private ArrayList<SpeedPredictorRecordItem> mSpeedRecordItems;

    public SpeedPredictorRecord() {
        this.mFileId = "";
    }

    public String getFileId() {
        return this.mFileId;
    }

    public ArrayList<SpeedPredictorRecordItem> getSpeedRecordItems() {
        return this.mSpeedRecordItems;
    }

    public void extractFields(JSONObject r100) throws Throwable {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mFileId = r100.optString("stream_id");
        JSONArray r101 = r100.optJSONArray("downinfo");
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.length() <= 0) goto L19;
        this.mSpeedRecordItems = new ArrayList();
        int r102 = 0;
    L10:
        if (r102 >= r101.length()) goto L20;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r102);     // Catch: Exception -> L13
        SpeedPredictorRecordItem r104 = new SpeedPredictorRecordItem();     // Catch: Exception -> L13
        r104.extractFields(r103);     // Catch: Exception -> L13
        this.mSpeedRecordItems.add(r104);     // Catch: Exception -> L13
        r102 = r102 + 1;
    L13:
        e = move-exception;
        throw e;
    L20:
        return;
    }

    public void setFileId(String r100) {
        this.mFileId = r100;
    }

    public void setSpeedRecordItems(ArrayList<SpeedPredictorRecordItem> r100) {
        this.mSpeedRecordItems = r100;
    }
}
