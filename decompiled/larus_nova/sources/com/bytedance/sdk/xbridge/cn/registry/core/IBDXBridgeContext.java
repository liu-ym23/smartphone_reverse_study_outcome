package com.bytedance.sdk.xbridge.cn.registry.core;

import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXContainerContext;", "Lle7/a;", "getBridgeCall", "()Lle7/a;", "bridgeCall", "", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", FailedBinderCallBack.CALLER_ID, "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IBDXBridgeContext extends IBDXContainerContext {
    le7.a<?> getBridgeCall();

    String getCallId();

    void setCallId(String r100);
}
