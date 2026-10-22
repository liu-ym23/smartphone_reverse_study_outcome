package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import hx5.b;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class ModeRuntimeDelay extends TTHttpCallPriorityControl.BaseModeControl {
    private final Set<String> mBlackListForRuntime;
    private final AtomicLong mLastP0StartTime;
    private int mP0CheckCountdownMs;
    private final Set<String> mP0List;
    private int mP1MaxWaitMs;
    private final RequestDropController mRequestDropController;
    private final Set<Request> mRuntimePOSet;
    private final Set<String> mWhiteListForRuntime;

    public ModeRuntimeDelay() {
        this.mRequestDropController = new RequestDropController();
        this.mP0List = new CopyOnWriteArraySet();
        this.mBlackListForRuntime = new CopyOnWriteArraySet();
        this.mWhiteListForRuntime = new CopyOnWriteArraySet();
        this.mP0CheckCountdownMs = 5000;
        this.mP1MaxWaitMs = 5000;
        this.mLastP0StartTime = new AtomicLong(0);
        this.mRuntimePOSet = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.RUNTIME_DELAY;
    }

    public static /* synthetic */ Set access$000(ModeRuntimeDelay r100) {
        return r100.mRuntimePOSet;
    }

    private boolean checkRequestForRuntime(Request r100) throws DroppedByThrottleControlException {
        this.mRequestDropController.raiseExceptionIfDrop(r100);
        boolean r101 = false;
        if (TTHttpCallPriorityControl.isMatch(this.mP0List, r100.getPath()) == false) goto L7;
        this.mLastP0StartTime.set(System.currentTimeMillis());
        this.mRuntimePOSet.add(r100);
        return false;
    L7:
        if ((System.currentTimeMillis() - this.mLastP0StartTime.get()) <= this.mP0CheckCountdownMs) goto L9;
    L19:
        return r101;
    L9:
        if (this.mRuntimePOSet.isEmpty() == true) goto L19;
        if (this.mBlackListForRuntime.isEmpty() == false) goto L14;
        r101 = true;
        if (this.mWhiteListForRuntime.isEmpty() == true) goto L19;
        return !TTHttpCallPriorityControl.isMatch(this.mWhiteListForRuntime, r100.getPath());
    L14:
        return TTHttpCallPriorityControl.isMatch(this.mBlackListForRuntime, r100.getPath());
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject r100) {
        super.initWithTncConfig(r100);
        this.mRequestDropController.initWithTncConfig(r100);
        this.mRequestDelayController.initWithTncConfig(r100, this.mStateName);
        JSONArray r101 = r100.optJSONArray("p0");
        int r102 = 0;
        if (r101 == null) goto L12;
        int r103 = 0;
    L6:
        if (r103 >= r101.length()) goto L12;
        String r104 = r101.optString(r103);
        if (TextUtils.isEmpty(r104) == true) goto L10;
        this.mP0List.add(r104);
    L10:
        r103 = r103 + 1;
    L12:
        if (this.mRequestDropController.isValid() == false) goto L14;
    L16:
        JSONArray r105 = r100.optJSONArray("bl_for_runtime");
        if (r105 == null) goto L25;
        int r106 = 0;
    L20:
        if (r106 >= r105.length()) goto L25;
        String r107 = r105.optString(r106);
        if (TextUtils.isEmpty(r107) == true) goto L24;
        this.mBlackListForRuntime.add(r107);
    L24:
        r106 = r106 + 1;
    L25:
        JSONArray r108 = r100.optJSONArray("wl_for_runtime");
        if (r108 != null) goto L28;
    L33:
        this.mP0CheckCountdownMs = r100.optInt("p0_check_max_ms", 5000);
        this.mP1MaxWaitMs = r100.optInt("p1_wait_max_ms", 5000);
        return true;
    L28:
        if (r102 >= r108.length()) goto L33;
        String r109 = r108.optString(r102);
        if (TextUtils.isEmpty(r109) == true) goto L32;
        this.mWhiteListForRuntime.add(r109);
    L32:
        r102 = r102 + 1;
        goto L28
    L14:
        if (this.mP0List.isEmpty() == false) goto L16;
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r100) throws Exception {
        if (checkRequestForRuntime(r100) == false) goto L6;
        this.mRequestDelayController.requestBlockingDelay(r100, false, true, this.mP1MaxWaitMs);
        return;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl, com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request r100) {
        b.a(NetworkAsyncTaskType.NETWORK).b(new AnonymousClass1(this, r100));
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r100, Executor r110, Runnable r111) throws Exception {
        if (checkRequestForRuntime(r100) == true) goto L5;
        return false;
    L5:
        return this.mRequestDelayController.requestAsyncDelay(r100, false, this.mP1MaxWaitMs, r111, r110);
    }
}
