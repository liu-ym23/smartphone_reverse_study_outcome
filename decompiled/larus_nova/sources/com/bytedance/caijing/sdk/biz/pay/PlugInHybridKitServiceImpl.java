package com.bytedance.caijing.sdk.biz.pay;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayGeckoService;
import com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInHybridKitService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/PlugInHybridKitServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInHybridKitService;", "()V", "getAK", "", "getOfflineDir", "shouldInterceptRequestByUrl", "Landroid/webkit/WebResourceResponse;", "url", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "cjpay-se-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlugInHybridKitServiceImpl implements PlugInHybridKitService {
    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInHybridKitService
    public String getAK() {
        ICJPayGeckoService r100 = (ICJPayGeckoService) CJPayServiceManager.getInstance().getIService(ICJPayGeckoService.class);
        if (r100 == null) goto L8;
        ICJPayOfflineHelper r101 = r100.getOfflineHelper();
        if (r101 == null) goto L8;
        String r102 = r101.getAK();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInHybridKitService
    public String getOfflineDir() {
        ICJPayGeckoService r100 = (ICJPayGeckoService) CJPayServiceManager.getInstance().getIService(ICJPayGeckoService.class);
        if (r100 == null) goto L8;
        ICJPayOfflineHelper r101 = r100.getOfflineHelper();
        if (r101 == null) goto L8;
        String r102 = r101.getOfflineDir();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public PlugInHybridKitServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInHybridKitService
    public WebResourceResponse shouldInterceptRequestByUrl(String r100, Context r101) {
        ICJPayGeckoService r102 = (ICJPayGeckoService) CJPayServiceManager.getInstance().getIService(ICJPayGeckoService.class);
        if (r102 == null) goto L7;
        ICJPayOfflineHelper r103 = r102.getOfflineHelper();
        if (r103 == null) goto L7;
        return r103.shouldInterceptRequestByUrl(r100, r101);
    L7:
        return null;
    }
}
