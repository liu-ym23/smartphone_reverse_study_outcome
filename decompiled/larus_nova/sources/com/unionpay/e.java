package com.unionpay;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewJavascriptBridge f462163a;

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView r100, String r101) {
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        "shouldOverrideUrlLoading：".concat(String.valueOf(r101));
        if (WebViewJavascriptBridge.access$200(this.f462163a) == false) goto L16;
        if (TextUtils.isEmpty(r101) == true) goto L16;
        if (r101.startsWith("http") == true) goto L16;
        if (r101.startsWith("HTTP") == true) goto L16;
        Intent r102 = new Intent();     // Catch: Exception -> L13
        r102.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L13
        r102.setData(UriProtector.parse(r101));     // Catch: Exception -> L13
        this.f462163a.mContext.startActivity(r102);     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    public e(WebViewJavascriptBridge r100) {
        this.f462163a = r100;
    }
}
