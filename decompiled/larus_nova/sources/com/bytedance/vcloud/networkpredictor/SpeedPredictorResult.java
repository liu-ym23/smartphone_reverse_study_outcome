package com.bytedance.vcloud.networkpredictor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorResult {
    private String fileId;
    private ArrayList<SpeedPredictorResultItem> resultItems;

    public int size() {
        return this.resultItems.size();
    }

    public JSONObject toJsonObject() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L18
        String r101 = this.fileId;     // Catch: Exception -> L18
        if (r101 == null) goto L5;
        r100.put("fileid", r101);     // Catch: Exception -> L18
    L5:
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L18
        Iterator<SpeedPredictorResultItem> r103 = this.resultItems.iterator();     // Catch: Exception -> L18
    L7:
        if (r103.hasNext() == false) goto L15;
        SpeedPredictorResultItem r104 = r103.next();     // Catch: Exception -> L18
        if (r104 == null) goto L7;
        JSONObject r105 = r104.toJsonObject();     // Catch: Exception -> L18
        if (r105 == null) goto L7;
        r102.put(r105);     // Catch: Exception -> L18
        goto L7
    L15:
        if (r102.length() <= 0) goto L32;
        r100.put("predictInfo", r102);     // Catch: Exception -> L18
        return r100;
    L32:
        return null;
    L18:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public SpeedPredictorResult() {
        this.resultItems = new ArrayList();
    }

    public String getFileId() {
        return this.fileId;
    }

    public ArrayList<SpeedPredictorResultItem> getResultItems() {
        return this.resultItems;
    }

    public void add(SpeedPredictorResultItem r100) {
        this.resultItems.add(r100);
    }

    public SpeedPredictorResultItem get(int r100) {
        return (SpeedPredictorResultItem) ListProtector.get(this.resultItems, r100);
    }

    public void setFileId(String r100) {
        this.fileId = r100;
    }

    public void setResultItems(ArrayList<SpeedPredictorResultItem> r100) {
        this.resultItems = r100;
    }
}
