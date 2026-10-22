package com.bytedance.sdk.bridge.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.sdk.bridge.BridgeConfig;
import com.bytedance.sdk.bridge.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/bridge/api/BridgeService;", "Lcom/bytedance/news/common/service/manager/IService;", "Lcom/bytedance/sdk/bridge/BridgeConfig;", "initBridgeConfig", "", "initBridgeSDK", "", "tag", "msg", "reportErrorInfo", "Lcom/bytedance/sdk/bridge/c;", "initBridgeLazyConfig", "bridge_release"}, k = 1, mv = {1, 4, 0})
public interface BridgeService extends IService {
    BridgeConfig initBridgeConfig();

    c initBridgeLazyConfig();

    void initBridgeSDK();

    void reportErrorInfo(String r100, String r101);
}
