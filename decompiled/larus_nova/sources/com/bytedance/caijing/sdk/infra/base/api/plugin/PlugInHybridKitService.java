package com.bytedance.caijing.sdk.infra.base.api.plugin;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInHybridKitService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getAK", "", "getOfflineDir", "shouldInterceptRequestByUrl", "Landroid/webkit/WebResourceResponse;", "url", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PlugInHybridKitService extends ICJService {
    String getAK();

    String getOfflineDir();

    WebResourceResponse shouldInterceptRequestByUrl(String r100, Context r101);
}
