package com.ss.android.lark.chameleon.basewebview.config;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import com.ss.android.lark.chameleon.basewebview.BaseWebView;
import com.ss.android.lark.chameleon.idependency.Env;

/* JADX INFO: loaded from: classes35.dex */
public class WebSettingConfig {
    private static final String TAG = "WebSettingConfig";
    private boolean mIsJSEnable;
    private boolean mIsSupportMultipleWindows;
    private String mSpecificUserAgent;

    public static class Builder extends BaseConfigBuilder {
        private WebSettingConfig mWebSettingConfig;

        @Override // com.ss.android.lark.chameleon.basewebview.config.BaseConfigBuilder
        public void initDefaultConfig(Context r100) {
        }

        public WebSettingConfig build() {
            return this.mWebSettingConfig;
        }

        public Builder(LarkWebViewConfig.Builder r100) {
            super(r100);
            this.mWebSettingConfig = new WebSettingConfig();
        }

        public Builder setJavaScriptEnable(boolean r100) {
            WebSettingConfig.access$002(this.mWebSettingConfig, r100);
            return this;
        }

        public Builder setSpecificUserAgent(String r100) {
            WebSettingConfig.access$102(this.mWebSettingConfig, r100);
            return this;
        }

        public Builder setSupportMultipleWindows(boolean r100) {
            WebSettingConfig.access$202(this.mWebSettingConfig, r100);
            return this;
        }
    }

    public WebSettingConfig() {
        this.mIsJSEnable = true;
        this.mIsSupportMultipleWindows = false;
    }

    public String getSpecificUserAgent() {
        return this.mSpecificUserAgent;
    }

    public boolean isJSEnable() {
        return this.mIsJSEnable;
    }

    public void apply(BaseWebView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WebSettings r101 = r100.getSettings();
        r101.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        r101.setLoadWithOverviewMode(true);
        r101.setUseWideViewPort(true);
        r101.setDomStorageEnabled(true);
        r101.setDatabaseEnabled(true);
        r101.setDisplayZoomControls(false);
        r101.setBuiltInZoomControls(true);
        r101.setAllowFileAccess(false);
        r101.setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(r100, true);
        r101.setSupportZoom(true);
        r101.setJavaScriptEnabled(this.mIsJSEnable);
        r101.setSupportMultipleWindows(this.mIsSupportMultipleWindows);
        if (TextUtils.isEmpty(this.mSpecificUserAgent) == false) goto L7;
        r101.getUserAgentString();
        r101.setUserAgentString(Env.getUserAgent());
        return;
    L7:
        r101.setUserAgentString(this.mSpecificUserAgent);
    }

    public static /* synthetic */ boolean access$002(WebSettingConfig r100, boolean r101) {
        r100.mIsJSEnable = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(WebSettingConfig r100, String r101) {
        r100.mSpecificUserAgent = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(WebSettingConfig r100, boolean r101) {
        r100.mIsSupportMultipleWindows = r101;
        return r101;
    }
}
