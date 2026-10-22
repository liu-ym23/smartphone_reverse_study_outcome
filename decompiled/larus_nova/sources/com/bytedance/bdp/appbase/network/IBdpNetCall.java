package com.bytedance.bdp.appbase.network;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/bdp/appbase/network/IBdpNetCall;", "", "cancel", "", "execute", "Lcom/bytedance/bdp/appbase/network/BdpNetResponse;", "getRequest", "Lcom/bytedance/bdp/appbase/network/BdpNetRequest;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public interface IBdpNetCall {
    void cancel();

    BdpNetResponse execute();

    BdpNetRequest getRequest();
}
