package com.bytedance.ttnet.priority;

import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class ModePriorityManagement extends TTHttpCallPriorityControl.BaseModeControl {
    private final Set<String> mBlackListForPriority;
    private final RequestDropController mDropController;
    private int mMaxDelayTimeMs;
    private final RequestPriorityController mPriorityController;
    private final RequestSpeedController mRequestSpeedThrottleController;
    private final Set<String> mWhiteListForPriority;

    public ModePriorityManagement() {
        this.mDropController = new RequestDropController();
        this.mPriorityController = new RequestPriorityController();
        this.mRequestSpeedThrottleController = new RequestSpeedController();
        this.mBlackListForPriority = new CopyOnWriteArraySet();
        this.mWhiteListForPriority = new CopyOnWriteArraySet();
        this.mMaxDelayTimeMs = 60000;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStart() {
        super.modeStart();
        this.mRequestSpeedThrottleController.connectionThrottleStart();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestSpeedThrottleController.connectionThrottleStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.PRIORITY;
    }

    private boolean checkIfDelayOrDropWithPriority(Request r100) throws DroppedByThrottleControlException {
        this.mDropController.raiseExceptionIfDrop(r100);
        if (this.mBlackListForPriority.isEmpty() == true) goto L7;
        return TTHttpCallPriorityControl.isMatch(this.mBlackListForPriority, r100.getPath());
    L7:
        if (this.mWhiteListForPriority.isEmpty() == false) goto L9;
        return false;
    L9:
        return !TTHttpCallPriorityControl.isMatch(this.mWhiteListForPriority, r100.getPath());
    }

    public void initRequestDropController(Set<String> r100) {
        this.mDropController.initWithLocal(r100);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject r100) {
        super.initWithTncConfig(r100);
        this.mDropController.initWithTncConfig(r100);
        this.mRequestDelayController.initWithTncConfig(r100, this.mStateName);
        JSONObject r101 = r100.optJSONObject("priority");
        if (this.mDropController.isValid() == true) goto L7;
        if (r101 != null) goto L7;
        return false;
    L7:
        this.mPriorityController.initWithTncConfig(r101);
        this.mRequestSpeedThrottleController.initWithTncConfig(r100);
        JSONObject r102 = r100.optJSONObject("delay");
        if (r102 == null) goto L12;
        this.mBlackListForPriority.addAll(TTHttpCallPriorityControl.getSetFromJSONArray(r102, "bl_with_priority"));
        this.mWhiteListForPriority.addAll(TTHttpCallPriorityControl.getSetFromJSONArray(r102, "wl_with_priority"));
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r100) throws Exception {
        if (checkIfDelayOrDropWithPriority(r100) == false) goto L6;
        this.mRequestDelayController.requestBlockingDelay(r100, false, true, this.mMaxDelayTimeMs);
        return;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl, com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request r100) {
        Request r101 = this.mPriorityController.setPriorityToRequest(r100);
        return this.mRequestSpeedThrottleController.setThrottleSpeedToRequest(r101);
    }

    public void initRequestPriorityController(Set<String> r100, Set<String> r101, Set<String> r102) {
        this.mPriorityController.initWithLocal(r100, r101, r102);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r100, Executor r110, Runnable r111) throws Exception {
        if (checkIfDelayOrDropWithPriority(r100) == true) goto L5;
        return false;
    L5:
        return this.mRequestDelayController.requestAsyncDelay(r100, false, this.mMaxDelayTimeMs, r111, r110);
    }

    public void initRequestDelayController(Set<String> r100, Set<String> r101, int r102, int r103, int r104, int r105) {
        this.mRequestDelayController.initWithLocal(r103, r104, r105);
        this.mBlackListForPriority.clear();
        this.mWhiteListForPriority.clear();
        this.mBlackListForPriority.addAll(r100);
        this.mWhiteListForPriority.addAll(r101);
        this.mMaxDelayTimeMs = r102;
    }

    public void initRequestSpeedController(Map<String, Integer> r110, Set<String> r111, Set<String> r112, Set<String> r113, Set<String> r210, long r211, long r212, long r213, long r214) {
        this.mRequestSpeedThrottleController.initWithLocal(r110, r112, r112, r113, r210, r211, r212, r213, r214);
    }
}
