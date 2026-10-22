package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.utils.d;
import g66.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import s56.e;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004H&J&\u0010\u000b\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH&J2\u0010\u0014\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J/\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLogDepend;", "", "", "eventName", "", "map", "", "onEventV3Map", "params", "", "isApi", "putCommonParams", "Lg66/c;", "contextProviderFactory", "name", "Ls56/e;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;", "callback", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "type", "handleReportADLog", "reportJSBError", "(Lg66/c;Ljava/util/Map;)Lkotlin/Unit;", "reportJSBFetchError", "Lcom/bytedance/ies/xbridge/utils/d;", "getLogService", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostLogDepend {
    d getLogService();

    void handleReportADLog(c r100, String r101, e r102, IReportADLogResultCallback r103, XBridgePlatformType r104);

    void onEventV3Map(String r100, Map<String, String> r101);

    void putCommonParams(Map<String, String> r100, boolean r101);

    Unit reportJSBError(c r100, Map<String, ? extends Object> r101);

    Unit reportJSBFetchError(c r100, Map<String, ? extends Object> r101);
}
