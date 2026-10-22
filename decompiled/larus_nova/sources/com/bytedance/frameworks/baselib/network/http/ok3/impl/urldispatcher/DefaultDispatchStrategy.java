package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDispatchStrategy extends DispatchStrategy {
    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest r100) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String r100, boolean r101, int r102) {
    }

    public DefaultDispatchStrategy() {
        super(DispatchStrategy.DispatchStrategyType.UNKNOWN_DISPATCH_STRATEGY);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri r100) {
        return r100.toString();
    }
}
