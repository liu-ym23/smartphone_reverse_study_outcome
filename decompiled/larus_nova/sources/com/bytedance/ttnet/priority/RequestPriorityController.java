package com.bytedance.ttnet.priority;

import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class RequestPriorityController {
    private Set<String> mHighList;
    private Set<String> mLowList;
    private Set<String> mNormalList;

    public RequestPriorityController() {
        this.mHighList = new CopyOnWriteArraySet();
        this.mNormalList = new CopyOnWriteArraySet();
        this.mLowList = new CopyOnWriteArraySet();
    }

    public void initWithTncConfig(JSONObject r100) {
        this.mHighList = TTHttpCallPriorityControl.getSetFromJSONArray(r100, "high");
        this.mNormalList = TTHttpCallPriorityControl.getSetFromJSONArray(r100, "normal");
        this.mLowList = TTHttpCallPriorityControl.getSetFromJSONArray(r100, "low");
    }

    public Request setPriorityToRequest(Request r110) {
        Request.Builder r100 = r110.newBuilder();
        if (setPriorityToRequestInternal(this.mHighList, r110.getPath(), r100, 3, 4) == false) goto L7;
        return r100.build();
    L7:
        if (setPriorityToRequestInternal(this.mLowList, r110.getPath(), r100, -1, 1) == true) goto L9;
        int r101 = r110.getPriorityLevel();
        if (r101 < 3) goto L14;
        r101 = 1;
    L14:
        if (r101 > (-1)) goto L16;
        int r102 = 0;
    L17:
        int r103 = r110.getRequestPriorityLevel();
        if (r103 < 4) goto L20;
        r103 = 3;
    L20:
        if (r103 < 1) goto L22;
        int r104 = 2;
    L24:
        if (setPriorityToRequestInternal(this.mNormalList, r110.getPath(), r100, r102, r104) == false) goto L28;
        return r100.build();
    L28:
        return r100.priorityLevel(1).requestPriorityLevel(3).build();
    L22:
        r104 = r103;
        goto L24
    L16:
        r102 = r101;
        goto L17
    L9:
        return r100.build();
    }

    public void initWithLocal(Set<String> r100, Set<String> r101, Set<String> r102) {
        this.mHighList.clear();
        this.mNormalList.clear();
        this.mLowList.clear();
        this.mHighList.addAll(r100);
        this.mNormalList.addAll(r101);
        this.mLowList.addAll(r102);
    }

    private boolean setPriorityToRequestInternal(Set<String> r100, String r101, Request.Builder r102, int r103, int r104) {
        if (TTHttpCallPriorityControl.isMatch(r100, r101) == false) goto L6;
        r102.priorityLevel(r103);
        r102.requestPriorityLevel(r104);
        return true;
    L6:
        return false;
    }
}
