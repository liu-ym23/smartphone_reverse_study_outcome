package com.bytedance.sdk.bridge.model;

import android.app.Activity;
import android.webkit.WebView;
import cd7.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/bridge/model/IBridgeContext;", "", "Lcom/bytedance/sdk/bridge/model/BridgeResult;", "bridgeResult", "", "callback", "Landroid/app/Activity;", "getActivity", "Landroid/webkit/WebView;", "getWebView", "Lcd7/a;", "getIWebView", "bridge_release"}, k = 1, mv = {1, 4, 0})
public interface IBridgeContext {
    void callback(BridgeResult r100);

    Activity getActivity();

    a getIWebView();

    WebView getWebView();
}
