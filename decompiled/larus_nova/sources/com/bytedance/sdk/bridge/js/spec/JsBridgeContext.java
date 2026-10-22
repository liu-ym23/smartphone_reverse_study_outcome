package com.bytedance.sdk.bridge.js.spec;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebView;
import cd7.a;
import cd7.c;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yc7.b;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/bridge/js/spec/JsBridgeContext;", "Lcom/bytedance/sdk/bridge/model/IBridgeContext;", "Landroid/webkit/WebView;", "getWebView", "Lcd7/a;", "getIWebView", "", "getUri", "Landroid/app/Activity;", "getActivity", "Lcom/bytedance/sdk/bridge/model/BridgeResult;", "bridgeResult", "", "callback", "Ljava/lang/ref/WeakReference;", "webViewRef", "Ljava/lang/ref/WeakReference;", "callBackId", "Ljava/lang/String;", "getCallBackId", "()Ljava/lang/String;", "currentUrl", "webView", "<init>", "(Lcd7/a;Ljava/lang/String;Ljava/lang/String;)V", "js-bridge_release"}, k = 1, mv = {1, 4, 0})
public class JsBridgeContext implements IBridgeContext {
    private final String callBackId;
    private final String currentUrl;
    private final WeakReference<a> webViewRef;

    @Override // com.bytedance.sdk.bridge.model.IBridgeContext
    public Activity getActivity() {
        a r100 = this.webViewRef.get();
        if (r100 == null) goto L5;
        Activity r101 = r100.getActivity();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        WebView r102 = getWebView();
        if (r102 == null) goto L11;
        Context r103 = r102.getContext();
    L12:
        if (r103 == null) goto L20;
        if ((r103 instanceof ContextWrapper) == false) goto L20;
        if ((r103 instanceof Activity) == true) goto L18;
        r103 = ((ContextWrapper) r103).getBaseContext();
        goto L12
    L18:
        return (Activity) r103;
    L20:
        WebView r104 = getWebView();
        if (r104 == null) goto L23;
        ViewParent r105 = r104.getParent();
    L24:
        if (r105 == null) goto L36;
        if ((r105 instanceof View) == true) goto L28;
        Object r106 = null;
    L29:
        View r107 = (View) r106;
        if (r107 == null) goto L32;
        Context r108 = r107.getContext();
    L34:
        if ((r108 instanceof Activity) == true) goto L36;
        r105 = r105.getParent();
        goto L24
    L32:
        r108 = null;
        goto L34
    L28:
        r106 = r105;
    L36:
        boolean r109 = r105 instanceof View;
        Object r110 = r105;
        if (r109 == true) goto L39;
        r110 = null;
    L39:
        View r111 = (View) r110;
        if (r111 == null) goto L42;
        Context r112 = r111.getContext();
    L43:
        if (r112 == null) goto L51;
        if ((r112 instanceof ContextWrapper) == false) goto L51;
        if ((r112 instanceof Activity) == true) goto L49;
        r112 = ((ContextWrapper) r112).getBaseContext();
        goto L43
    L49:
        return (Activity) r112;
    L51:
        return null;
    L42:
        r112 = null;
        goto L43
    L23:
        r105 = null;
        goto L24
    L11:
        r103 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.bridge.model.IBridgeContext
    public a getIWebView() {
        return this.webViewRef.get();
    }

    public final String getUri() {
        if (TextUtils.isEmpty(this.currentUrl) == false) goto L9;
        a r100 = this.webViewRef.get();
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.getUrl();
    L9:
        return this.currentUrl;
    }

    @Override // com.bytedance.sdk.bridge.model.IBridgeContext
    public WebView getWebView() {
        a r100 = this.webViewRef.get();
        if ((r100 instanceof c) == true) goto L5;
        r100 = null;
    L5:
        c r101 = (c) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f23410a.get();
    }

    public final String getCallBackId() {
        return this.callBackId;
    }

    @Override // com.bytedance.sdk.bridge.model.IBridgeContext
    public void callback(BridgeResult r100) {
        a r101 = getIWebView();
        if (TextUtils.isEmpty(this.callBackId) == true) goto L10;
        if (r101 == null) goto L11;
        String r102 = b.f567209a;
        String r103 = this.callBackId;
        if (r103 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        b.f(r103, r100.toJSON(), r101, false, null);
        return;
    L11:
        return;
    }

    public JsBridgeContext(a r100, String r101, String r102) {
        this.callBackId = r101;
        this.currentUrl = r102;
        this.webViewRef = new WeakReference(r100);
    }

    public /* synthetic */ JsBridgeContext(a r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
