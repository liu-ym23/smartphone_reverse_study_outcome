package ld4;

import android.app.Activity;
import android.webkit.WebView;
import com.bytedance.caijing.sdk.infra.base.api.container.interfaceWrapper.JSBResult;

/* JADX INFO: loaded from: classes15.dex */
public interface a {
    void callback(JSBResult r100);

    Activity getActivity();

    String getCallbackId();

    WebView getWebView();
}
