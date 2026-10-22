package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class ModeDefault extends TTHttpCallPriorityControl.BaseModeControl {
    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStart() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
    }

    public ModeDefault() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.DEFAULT;
    }

    private int getDispatchDelayTime(Request r100) {
        List<Header> r101 = r100.headers(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG);
        if (r101 != null) goto L5;
    L9:
        String r102 = "";
    L11:
        return URLDispatcher.inst().getDelayResult(r100.getUrl(), r102);
    L5:
        if (r101.size() < 1) goto L9;
        if (TextUtils.isEmpty(((Header) ListProtector.get(r101, 0)).getValue()) == true) goto L9;
        r102 = ((Header) ListProtector.get(r101, 0)).getValue();
        goto L11
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r100) throws Exception {
        long r101 = getDispatchDelayTime(r100);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeDefault", "get tag delay time " + r101 + " " + r100.getPath());
    L5:
        this.mRequestDelayController.requestBlockingDelay(r100, true, false, r101);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r100, Executor r110, Runnable r111) throws Exception {
        long r101 = getDispatchDelayTime(r100);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeDefault", "get tag delay time " + r101 + " " + r100.getPath());
    L6:
        return this.mRequestDelayController.requestAsyncDelay(r100, true, r101, r111, r110);
    }
}
