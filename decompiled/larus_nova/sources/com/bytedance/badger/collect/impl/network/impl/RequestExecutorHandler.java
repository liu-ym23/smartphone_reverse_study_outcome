package com.bytedance.badger.collect.impl.network.impl;

import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.constants.ErrorPair;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import com.bytedance.badger.collect.impl.interfaces.INetworkApi;
import com.bytedance.badger.collect.impl.interfaces.IOperatorNetworkApi;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.CommonUtils;
import com.bytedance.badger.collect.impl.utils.KLog;

/* JADX INFO: loaded from: classes47.dex */
public class RequestExecutorHandler implements IChainHandler {

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.network.impl.RequestExecutorHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum = null;

        static {
            int[] r100 = new int[NetworkMethodEnum.values().length];
            $SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum = r100;
            r100[NetworkMethodEnum.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum[NetworkMethodEnum.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public RequestExecutorHandler() {
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ long getRetryDelay(int r100) {
        return IChainHandler.CC.$default$getRetryDelay(this, r100);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ boolean shouldRetry(TTResponse r100, int r101) {
        return IChainHandler.CC.$default$shouldRetry(this, r100, r101);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public TTResponse handle(IChainHandler.IChain r100) {
        TTRequest r101 = r100.getRequest();
        TTResponse r102 = executeNetworkRequest(r101, r101.getBaseUrl());     // Catch: Exception -> L5
    L7:
        if (r102 != null) goto L10;
        r102 = TTResponse.failed();
    L10:
        if (r102.getHeaders() == null) goto L15;
        if (r102.getHeaders().containsKey(Constants.Keys.KEY_X_TT_LOGID) == false) goto L15;
        r102.setLogId(r102.getHeaders().get(Constants.Keys.KEY_X_TT_LOGID));
    L15:
        if (KLog.isDebug() == false) goto L17;
        KLog.d(Constants.TAGS.NETWORK, "RequestExecutorHandler# receive response --- " + r102);
    L17:
        return r102;
    L5:
        e = move-exception;
        TTResponse r103 = TTResponse.failed(e);
        KLog.e(Constants.TAGS.NETWORK, e);
        r102 = r103;
        goto L7
    }

    private TTResponse executeNetworkRequest(TTRequest r100, String r101) throws Exception {
        INetworkApi r102 = BadgerCollectApi.getNetworkApi();
        IOperatorNetworkApi r103 = BadgerCollectApi.getOperatorNetworkApi();
        if (r102 == null) goto L30;
        if (r103 == null) goto L30;
        if (r100.isEnableOperator() == true) goto L9;
        int r104 = AnonymousClass1.$SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum[r100.getMethod().ordinal()];
        if (r104 == 1) goto L28;
        if (r104 == 2) goto L26;
        return TTResponse.failed();
    L26:
        return r102.post(r101, r100.getHeaders(), r100.getBodyMap());
    L28:
        return r102.get(r101, r100.getHeaders());
    L9:
        if (KLog.isDebug() == false) goto L11;
        KLog.d(Constants.TAGS.NETWORK, "RequestExecutorHandler# operator type request... ");
    L11:
        int r105 = AnonymousClass1.$SwitchMap$com$bytedance$badger$collect$impl$constants$NetworkMethodEnum[r100.getMethod().ordinal()];
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L15;
        byte[] r106 = CommonUtils.map2QueryString(r100.getBodyMap()).getBytes("UTF-8");
        return r103.post(r100.getNetwork(), r101, r100.getHeaders(), r106);
    L15:
        return TTResponse.failed();
    L19:
        return r103.get(r100.getNetwork(), r101, r100.getHeaders());
    L30:
        return TTResponse.failed(ErrorPair.ERROR_NET_NOT_IMPL);
    }
}
