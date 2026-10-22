package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import com.ss.android.lark.chameleon.api.WebviewConfig;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chameleon.util.UserAgentUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebViewConfig;", "", "()V", "TAG", "", "UA_NETWORK", "UA_NETWORK_VERSION", "UA_PLATFORM", "UA_PLATFORM_ANDROID", "configWebSettings", "", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "webSettings", "Landroid/webkit/WebSettings;", "getUserAgent", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "init", "setUserAgent", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonWebViewConfig {
    public static final ChameleonWebViewConfig INSTANCE = null;
    private static final String TAG = "CML_TAG_ChameleonWebSettings";
    private static final String UA_NETWORK = "okhttp";
    private static final String UA_NETWORK_VERSION = "3.2";
    private static final String UA_PLATFORM = "platform";
    private static final String UA_PLATFORM_ANDROID = "android";

    static {
        INSTANCE = new ChameleonWebViewConfig();
    }

    private ChameleonWebViewConfig() {
    }

    public final String getUserAgent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r101 = new StringBuilder();
        String r102 = UserAgentUtil.INSTANCE.getUserAgent(r100);
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L8:
        r101.append(r102);
        r101.append(" Chameleon");
        r101.append(" " + AppInfoUtils.getUaAppName(r100) + '/' + AppInfoUtils.getVersionName(r100));
        r101.append(" platform/android okhttp/3.2");
        return r101.toString();
    L5:
        r103 = false;
        goto L6
    }

    public final void init(ChameleonWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        CookieManager.getInstance().setAcceptThirdPartyCookies(r100, true);
        configWebSettings(r100, r100.getSettings());
    }

    private final void configWebSettings(ChameleonWebView r100, WebSettings r101) {
        r101.setJavaScriptEnabled(true);
        r101.setDomStorageEnabled(true);
        r101.setSupportMultipleWindows(false);
        r101.setJavaScriptCanOpenWindowsAutomatically(true);
        r101.setCacheMode(-1);
        r101.setAllowFileAccess(true);
        r101.setDatabaseEnabled(true);
        r101.setMixedContentMode(2);
        setUserAgent(r100, r101);
    }

    private final void setUserAgent(ChameleonWebView r100, WebSettings r101) {
        String r102 = getUserAgent(r100.getContext());
        WebviewConfig r103 = r100.getChameleonConfig().getWebviewConfig();
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getBizUAgent();
    L7:
        if (TextUtils.isEmpty(r105) == true) goto L12;
        StringBuilder r106 = new StringBuilder();
        r106.append(r102);
        r106.append(' ');
        WebviewConfig r107 = r100.getChameleonConfig().getWebviewConfig();
        if (r107 == null) goto L11;
        r104 = r107.getBizUAgent();
    L11:
        r106.append(r104);
        r102 = r106.toString();
    L12:
        r101.setUserAgentString(r102);
        Log.i(TAG, "initSettings: ua = " + r102);
        return;
    L5:
        r105 = null;
        goto L7
    }
}
