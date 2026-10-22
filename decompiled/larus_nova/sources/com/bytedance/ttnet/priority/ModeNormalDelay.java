package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class ModeNormalDelay extends TTHttpCallPriorityControl.BaseModeControl {
    private static final String KEY_BL_WITH_DELAY_MS = "bl_with_delay_ms";
    private static final String KEY_DELAY_TIME_MS = "delay_time_ms";
    private static final String KEY_WL = "wl";
    private final Map<String, Integer> mBlackList;
    private final RequestDropController mDropController;
    private final Set<String> mWhiteList;
    private int mWhiteListDelayTimeMs;

    public ModeNormalDelay() {
        this.mDropController = new RequestDropController();
        this.mBlackList = new ConcurrentHashMap();
        this.mWhiteList = new CopyOnWriteArraySet();
        this.mWhiteListDelayTimeMs = 1000;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.NORMAL_DELAY;
    }

    private int getDelayTimeOrRaiseDroppedByThrottleControlException(Request r100) throws IOException {
        this.mDropController.raiseExceptionIfDrop(r100);
        if (this.mBlackList.isEmpty() == true) goto L9;
        Integer r101 = TTHttpCallPriorityControl.getMapValueIfMatch(this.mBlackList, r100.getPath());
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    L9:
        if (this.mWhiteList.isEmpty() == false) goto L11;
        return -1;
    L11:
        if (TTHttpCallPriorityControl.isMatch(this.mWhiteList, r100.getPath()) == false) goto L13;
        return 0;
    L13:
        return this.mWhiteListDelayTimeMs;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject r100) {
        super.initWithTncConfig(r100);
        if (r100.isNull(KEY_BL_WITH_DELAY_MS) == true) goto L5;
    L7:
        this.mDropController.initWithTncConfig(r100);
        this.mRequestDelayController.initWithTncConfig(r100, this.mStateName);
        JSONObject r101 = r100.optJSONObject(KEY_BL_WITH_DELAY_MS);
        if (r101 == null) goto L13;
        Iterator<String> r102 = r101.keys();
    L11:
        if (r102.hasNext() == false) goto L24;
        String r103 = r102.next();
        this.mBlackList.put(r103, Integer.valueOf(r101.optInt(r103)));
    L24:
        if (this.mDropController.isValid() == false) goto L26;
    L29:
        return true;
    L26:
        if (this.mBlackList.isEmpty() == false) goto L29;
        if (this.mWhiteList.isEmpty() == false) goto L29;
        return false;
    L13:
        JSONArray r104 = r100.optJSONArray(KEY_WL);
        if (r104 == null) goto L22;
        int r105 = 0;
    L17:
        if (r105 >= r104.length()) goto L22;
        String r106 = r104.optString(r105);
        if (TextUtils.isEmpty(r106) == true) goto L21;
        this.mWhiteList.add(r106);
    L21:
        r105 = r105 + 1;
    L22:
        this.mWhiteListDelayTimeMs = r100.optInt(KEY_DELAY_TIME_MS, 1000);
        goto L24
    L5:
        if (r100.isNull(KEY_WL) == false) goto L7;
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r100) throws Exception {
        long r101 = getDelayTimeOrRaiseDroppedByThrottleControlException(r100);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeNormalDelay", "get normal delay time " + r101 + " " + r100.getPath());
    L5:
        this.mRequestDelayController.requestBlockingDelay(r100, false, true, r101);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r100, Executor r110, Runnable r111) throws Exception {
        long r101 = getDelayTimeOrRaiseDroppedByThrottleControlException(r100);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeNormalDelay", "get normal delay time " + r101 + " " + r100.getPath());
    L6:
        return this.mRequestDelayController.requestAsyncDelay(r100, false, r101, r111, r110);
    }
}
