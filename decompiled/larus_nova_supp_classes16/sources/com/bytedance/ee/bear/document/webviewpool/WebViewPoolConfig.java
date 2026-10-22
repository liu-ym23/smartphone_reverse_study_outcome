package com.bytedance.ee.bear.document.webviewpool;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = WebViewPoolConfig.KEY)
public class WebViewPoolConfig implements NonProguard {
    public static final String KEY = "webview_pool_config";
    public int coreSize;
    public int initialSize;
    public int maxSize;
    public int maxUseCount;
    public Map<String, OfficeWebViewPoolConfig> officeWebViewPoolConfigMap;
    public int preloadNextGapTime;
    public boolean preloadNextWebView;

    public static class OfficeWebViewPoolConfig extends WebViewPoolConfig {
        public OfficeWebViewPoolConfig() {
        }
    }

    public WebViewPoolConfig changeToOfficeWebViewPoolConfig() {
        OfficeWebViewPoolConfig r0 = this.officeWebViewPoolConfigMap.get(LarkContext.getApplication().getPackageName());
        if (r0 == null) goto L6;
        Log.i(KEY, "getWebViewPoolConfig, use officePoolConfig: " + r0);
        return r0;
    L6:
        return this;
    }

    public String toString() {
        return "WebViewPoolConfig{initialSize=" + this.initialSize + ", coreSize=" + this.coreSize + ", maxSize=" + this.maxSize + ", maxUseCount=" + this.maxUseCount + ", preloadNextGapTime=" + this.preloadNextGapTime + ", preloadNextWebView=" + this.preloadNextWebView + '}';
    }

    public WebViewPoolConfig() {
        this.preloadNextGapTime = 0;
        this.preloadNextWebView = true;
        this.officeWebViewPoolConfigMap = new HashMap();
    }

    public WebViewPoolConfig(int r2, int r3, int r4, int r5) {
        this.preloadNextGapTime = 0;
        this.preloadNextWebView = true;
        this.officeWebViewPoolConfigMap = new HashMap();
        this.initialSize = r2;
        this.coreSize = r3;
        this.maxSize = r4;
        this.maxUseCount = r5;
    }
}
