package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class RequestDropController {
    private final Set<String> mDropList;

    public boolean isValid() {
        if (this.mDropList.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public RequestDropController() {
        this.mDropList = new CopyOnWriteArraySet();
    }

    public void initWithLocal(Set<String> r100) {
        this.mDropList.clear();
        this.mDropList.addAll(r100);
    }

    public void initWithTncConfig(JSONObject r100) {
        this.mDropList.clear();
        JSONArray r101 = r100.optJSONArray("dl");
        if (r101 == null) goto L11;
        int r102 = 0;
    L6:
        if (r102 >= r101.length()) goto L15;
        String r103 = r101.optString(r102);
        if (TextUtils.isEmpty(r103) == true) goto L10;
        this.mDropList.add(r103);
    L10:
        r102 = r102 + 1;
        goto L6
    L15:
        return;
    }

    public void raiseExceptionIfDrop(Request r100) throws DroppedByThrottleControlException {
        if (TTHttpCallPriorityControl.isMatch(this.mDropList, r100.getPath()) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("RequestDropController", "check drop and match " + r100.getPath());
    L8:
        throw new DroppedByThrottleControlException();
    }
}
