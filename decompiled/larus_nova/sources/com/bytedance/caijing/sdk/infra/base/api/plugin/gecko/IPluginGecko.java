package com.bytedance.caijing.sdk.infra.base.api.plugin.gecko;

import android.webkit.WebResourceResponse;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.List;
import je4.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/gecko/IPluginGecko;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lje4/a;", "getGeckoConfig", "", "url", "Landroid/webkit/WebResourceResponse;", "loadCustomRes", "", "urlList", "", "preloadCustomRes", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IPluginGecko extends ICJService {
    a getGeckoConfig();

    WebResourceResponse loadCustomRes(String r100);

    void preloadCustomRes(List<String> r100);
}
