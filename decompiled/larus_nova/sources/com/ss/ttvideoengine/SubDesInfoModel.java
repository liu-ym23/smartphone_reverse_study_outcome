package com.ss.ttvideoengine;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SubDesInfoModel implements SubDesInfoModelProvider {
    private final ArrayList<SubModelProvider> mSubModelList;

    @Override // com.ss.ttvideoengine.SubDesInfoModelProvider
    public int subtitleCount() {
        return this.mSubModelList.size();
    }

    @Override // com.ss.ttvideoengine.SubDesInfoModelProvider
    public String toString() {
        if (this.mSubModelList.size() <= 0) goto L24;
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L6:
        if (r102 >= this.mSubModelList.size()) goto L26;
        JSONObject r103 = ((SubModelProvider) ListProtector.get(this.mSubModelList, r102)).toJson();
        if (r103 == null) goto L19;
        if (r103.has("url") == false) goto L19;
        if (r103.has(SubInfo.KEY_LANGUAGE_ID) == false) goto L19;
        if (r103.has(SubInfo.KEY_FORMAT) == false) goto L19;
        if (r103.has(SubInfo.KEY_SUB_ID) == false) goto L19;
        r101.put(r103);
    L19:
        r102 = r102 + 1;
        goto L6
    L26:
        r100.putOpt("list", r101);     // Catch: JSONException -> L22
        return r100.toString();
    L22:
        e = move-exception;
        TTVideoEngineLog.d(e);
    L24:
        return null;
    }

    public ArrayList<SubModelProvider> getSubModelList() {
        return this.mSubModelList;
    }

    public SubDesInfoModel(JSONObject r100) {
        this.mSubModelList = new ArrayList();
        if (r100.has("list") == false) goto L23;
        JSONArray r101 = r100.optJSONArray("list");
        if (r101 != null) goto L7;
        return;
    L7:
        int r102 = 0;
    L9:
        if (r102 >= r101.length()) goto L31;
        JSONObject r103 = r101.optJSONObject(r102);
        if (r103 == null) goto L22;
        if (r103.has(SubInfo.KEY_LANGUAGE_ID) == false) goto L22;
        if (r103.has(SubInfo.KEY_FORMAT) == false) goto L22;
        if (r103.has("url") == false) goto L22;
        if (r103.has(SubInfo.KEY_SUB_ID) == false) goto L22;
        SubModel r104 = new SubModel(r103);
        this.mSubModelList.add(r104);
    L22:
        r102 = r102 + 1;
        goto L9
    L31:
        return;
    }

    @Override // com.ss.ttvideoengine.SubDesInfoModelProvider
    public void addSubModel(SubModelProvider r100) {
        JSONObject r101 = r100.toJson();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.has("url") == true) goto L8;
        return;
    L8:
        if (r101.has(SubInfo.KEY_LANGUAGE_ID) == true) goto L10;
        return;
    L10:
        if (r101.has(SubInfo.KEY_FORMAT) == true) goto L12;
        return;
    L12:
        if (r101.has(SubInfo.KEY_SUB_ID) == false) goto L18;
        this.mSubModelList.add(r100);
        return;
    }

    public SubDesInfoModel(ArrayList<SubModelProvider> r100) {
        this.mSubModelList = new ArrayList();
        if (r100.size() > 0) goto L5;
        return;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.size()) goto L21;
        SubModelProvider r102 = (SubModelProvider) ListProtector.get(r100, r101);
        JSONObject r103 = r102.toJson();
        if (r103 == null) goto L10;
        if (r103.has("url") == false) goto L20;
        if (r103.has(SubInfo.KEY_LANGUAGE_ID) == false) goto L20;
        if (r103.has(SubInfo.KEY_FORMAT) == false) goto L20;
        if (r103.has(SubInfo.KEY_SUB_ID) == false) goto L20;
        this.mSubModelList.add(r102);
    L20:
        r101 = r101 + 1;
        goto L7
    L10:
        return;
    }
}
