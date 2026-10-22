package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004H&J&\u0010\u000b\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH&J*\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H&J/\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "", "", "eventName", "", "map", "", "onEventV3Map", "params", "", "isApi", "putCommonParams", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeContext", "name", "Lre7/g;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IReportADLogResultCallback;", "callback", "handleReportADLog", "reportJSBError", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Ljava/util/Map;)Lkotlin/Unit;", "reportJSBFetchError", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostLogDepend {
    void handleReportADLog(IBDXBridgeContext r100, String r101, re7.g r102, IReportADLogResultCallback r103);

    void onEventV3Map(String r100, Map<String, String> r101);

    void putCommonParams(Map<String, String> r100, boolean r101);

    Unit reportJSBError(IBDXBridgeContext r100, Map<String, ? extends Object> r101);

    Unit reportJSBFetchError(IBDXBridgeContext r100, Map<String, ? extends Object> r101);
}
