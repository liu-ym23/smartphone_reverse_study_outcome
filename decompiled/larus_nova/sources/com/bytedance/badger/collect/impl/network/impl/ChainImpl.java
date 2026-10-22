package com.bytedance.badger.collect.impl.network.impl;

import android.util.Log;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public class ChainImpl implements IChainHandler.IChain {
    private final List<IChainHandler> handlers;
    private final int index;
    private final TTRequest request;

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler.IChain
    public TTRequest getRequest() {
        return this.request;
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler.IChain
    public TTResponse process(TTRequest r100) {
    L8:
        e = move-exception;
        KLog.d(Constants.TAGS.NETWORK, "请求异常：" + Log.getStackTraceString(e));
        return TTResponse.failed(e);
    L3:
        if (this.index >= this.handlers.size()) goto L7;
        return ((IChainHandler) ListProtector.get(this.handlers, this.index)).handle(new ChainImpl(this.handlers, this.index + 1, r100));
    L7:
        return TTResponse.failed(r100);
    }

    public ChainImpl(List<IChainHandler> r100, int r101, TTRequest r102) {
        this.handlers = r100;
        this.index = r101;
        this.request = r102;
    }
}
