package com.larus.bmhome.web;

import android.os.Bundle;
import com.larus.platform.model.webview.AbsWebFragment;
import kotlin.Metadata;
import zt8.b;
import zt8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/web/IAiChatHostWebService;", "", "getWebFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "webViewScrollCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", "getWebFragmentArguments", "Landroid/os/Bundle;", "config", "Lcom/larus/bmhome/web/HostWebFragmentConfig;", "getUrlForCodePreview", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAiChatHostWebService {
    AbsWebFragment a(c r100);

    String b();

    Bundle c(b r100);
}
