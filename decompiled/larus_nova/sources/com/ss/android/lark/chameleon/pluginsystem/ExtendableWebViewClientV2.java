package com.ss.android.lark.chameleon.pluginsystem;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public class ExtendableWebViewClientV2 extends LarkBaseWebViewClient {
    private List<WebViewClient> delegates;

    public ExtendableWebViewClientV2(ILarkWebViewContext r100) {
        super(r100);
        this.delegates = new CopyOnWriteArrayList();
    }

    public void addWebViewClientDelegate(WebViewClient r100) {
        if (this.delegates.contains(r100) == true) goto L6;
        this.delegates.add(r100);
        return;
    }

    public void removeWebViewClientDelegate(WebViewClient r100) {
        this.delegates.remove(r100);
    }

    public void sortDelegates(Comparator<WebViewClient> r100) {
        ArrayList r101 = new ArrayList(this.delegates);
        Collections.sort(r101, r100);
        this.delegates.clear();
        this.delegates.addAll(r101);
    }

    private void innerOnLoadResource(WebView r100, String r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onLoadResource(r100, r101);
        goto L4
    }

    private void innerOnPageCommitVisible(WebView r100, String r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onPageCommitVisible(r100, r101);
        goto L4
    }

    private void innerOnPageFinished(WebView r100, String r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onPageFinished(r100, r101);
        goto L4
    }

    private void innerOnReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onReceivedClientCertRequest(r100, r101);
        goto L4
    }

    private boolean innerOnRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r102.next().onRenderProcessGone(r100, r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private void innerOnUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onUnhandledKeyEvent(r100, r101);
        goto L4
    }

    private WebResourceResponse innerShouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        WebResourceResponse r103 = r102.next().shouldInterceptRequest(r100, r101);
        if (r103 == null) goto L4;
        return r103;
    L8:
        return null;
    }

    private boolean innerShouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r102.next().shouldOverrideKeyEvent(r100, r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean innerShouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r102.next().shouldOverrideUrlLoading(r100, r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void addWebViewClientDelegate(int r100, WebViewClient r101) {
        if (this.delegates.contains(r101) == true) goto L6;
        ListProtector.add(this.delegates, r100, r101);
        return;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        super.onLoadResource(r100, r101);
        innerOnLoadResource(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        super.onPageCommitVisible(r100, r101);
        innerOnPageCommitVisible(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        innerOnPageFinished(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        super.onReceivedClientCertRequest(r100, r101);
        innerOnReceivedClientCertRequest(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        if (innerOnRenderProcessGone(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onRenderProcessGone(r100, r101) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        super.onUnhandledKeyEvent(r100, r101);
        innerOnUnhandledKeyEvent(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        WebResourceResponse r102 = innerShouldInterceptRequest(r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        if (innerShouldOverrideKeyEvent(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.shouldOverrideKeyEvent(r100, r101) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        return innerShouldOverrideUrlLoading(r100, r101);
    }

    private boolean innerShouldOverrideUrlLoading(WebView r100, String r101) {
        Iterator<WebViewClient> r102 = this.delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r102.next().shouldOverrideUrlLoading(r100, r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        return innerShouldOverrideUrlLoading(r100, r101);
    }

    private void innerDoUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().doUpdateVisitedHistory(r100, r101, r102);
        goto L4
    }

    private void innerOnFormResubmission(WebView r100, Message r101, Message r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onFormResubmission(r100, r101, r102);
        goto L4
    }

    private void innerOnPageStarted(WebView r100, String r101, Bitmap r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onPageStarted(r100, r101, r102);
        goto L4
    }

    private void innerOnReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onReceivedError(r100, r101, r102);
        goto L4
    }

    private void innerOnReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onReceivedHttpError(r100, r101, r102);
        goto L4
    }

    private void innerOnReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onReceivedSslError(r100, r101, r102);
        goto L4
    }

    private void innerOnScaleChanged(WebView r100, float r101, float r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onScaleChanged(r100, r101, r102);
        goto L4
    }

    private void innerOnTooManyRedirects(WebView r100, Message r101, Message r102) {
        Iterator<WebViewClient> r103 = this.delegates.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onTooManyRedirects(r100, r101, r102);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        super.doUpdateVisitedHistory(r100, r101, r102);
        innerDoUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onFormResubmission(WebView r100, Message r101, Message r102) {
        super.onFormResubmission(r100, r101, r102);
        innerOnFormResubmission(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        innerOnPageStarted(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        super.onReceivedError(r100, r101, r102);
    L5:
        innerOnReceivedError(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        super.onReceivedHttpError(r100, r101, r102);
    L5:
        innerOnReceivedHttpError(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        super.onReceivedSslError(r100, r101, r102);
        innerOnReceivedSslError(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onScaleChanged(WebView r100, float r101, float r102) {
        super.onScaleChanged(r100, r101, r102);
        innerOnScaleChanged(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        super.onTooManyRedirects(r100, r101, r102);
        innerOnTooManyRedirects(r100, r101, r102);
    }

    private void innerOnReceivedError(WebView r100, int r101, String r102, String r103) {
        Iterator<WebViewClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().onReceivedError(r100, r101, r102, r103);
        goto L4
    }

    private void innerOnReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        Iterator<WebViewClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().onReceivedHttpAuthRequest(r100, r101, r102, r103);
        goto L4
    }

    private void innerOnReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        Iterator<WebViewClient> r104 = this.delegates.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().onReceivedLoginRequest(r100, r101, r102, r103);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        innerOnReceivedError(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        innerOnReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebViewClient, android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        super.onReceivedLoginRequest(r100, r101, r102, r103);
        innerOnReceivedLoginRequest(r100, r101, r102, r103);
    }
}
