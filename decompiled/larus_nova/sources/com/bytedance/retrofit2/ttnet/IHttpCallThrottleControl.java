package com.bytedance.retrofit2.ttnet;

import com.bytedance.retrofit2.client.Request;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface IHttpCallThrottleControl {

    /* JADX INFO: renamed from: com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Request $default$setOriginalRequestProperties(IHttpCallThrottleControl r100, Request r101) {
            return r101;
        }
    }

    boolean maybeDropRequestOrAsyncDelay(Request r100, Executor r101, Runnable r102) throws Exception;

    void maybeDropRequestOrBlockingDelay(Request r100) throws Exception;

    void notifyRequestCompleted(Request r100);

    Request setOriginalRequestProperties(Request r100);
}
