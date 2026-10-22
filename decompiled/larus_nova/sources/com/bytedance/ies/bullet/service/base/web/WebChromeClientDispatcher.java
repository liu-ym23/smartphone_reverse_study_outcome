package com.bytedance.ies.bullet.service.base.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import b36.j;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.bullet.service.base.YieldError;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J&\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher;", "Landroid/webkit/WebChromeClient;", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "uploadMsg", "", "openFileChooser", "", "acceptType", "capture", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public class WebChromeClientDispatcher extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<j> f247928a;

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Iterator r100 = this.f247928a.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        return ((j) r100.next()).getDefaultVideoPoster();
    L8:
        r100 = r100;
        goto L4
    L10:
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        Iterator r100 = this.f247928a.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        return ((j) r100.next()).getVideoLoadingProgressView();
    L8:
        r100 = r100;
        goto L4
    L10:
        return super.getVideoLoadingProgressView();
    }

    public WebChromeClientDispatcher() {
        this.f247928a = new CopyOnWriteArrayList();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
        Iterator<T> r100 = this.f247928a.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        ((j) r100.next()).onGeolocationPermissionsHidePrompt();     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        super.onHideCustomView();
        Iterator<T> r100 = this.f247928a.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        ((j) r100.next()).onHideCustomView();     // Catch: YieldError -> L8
        goto L4
    }

    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "webChromeClient");
        this.f247928a.add(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        Iterator<T> r101 = this.f247928a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ((j) r101.next()).onPermissionRequest(r100);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r100) {
        super.onPermissionRequestCanceled(r100);
        Iterator<T> r101 = this.f247928a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ((j) r101.next()).onPermissionRequestCanceled(r100);     // Catch: YieldError -> L8
        goto L4
    }

    public final void openFileChooser(ValueCallback<Uri> r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadMsg");
        Iterator<T> r101 = this.f247928a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ((j) r101.next()).c(r100);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String r210, GeolocationPermissions.Callback r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210, r211};
        b r110 = new b();
        a r102 = ApiHookConfig.f245611b.get(100003);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r115 = r111;
        d r106 = r105.preInvoke(100003, "com/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L27
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L27
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        super.onGeolocationPermissionsShowPrompt(r210, r211);
        Iterator<j> r107 = this.f247928a.iterator();
    L21:
        if (r107.hasNext() == false) goto L26;
        r107.next().onGeolocationPermissionsShowPrompt(r210, r211);     // Catch: YieldError -> L25
        goto L21
    L26:
        return;
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        super.onProgressChanged(r100, r101);
        Iterator<T> r102 = this.f247928a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ((j) r102.next()).onProgressChanged(r100, r101);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        super.onReceivedTitle(r100, r101);
        Iterator<T> r102 = this.f247928a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ((j) r102.next()).onReceivedTitle(r100, r101);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        super.onShowCustomView(r100, r101);
        Iterator<T> r102 = this.f247928a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ((j) r102.next()).onShowCustomView(r100, r101);     // Catch: YieldError -> L8
        goto L4
    }

    public final void openFileChooser(ValueCallback<Uri> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uploadMsg");
        Intrinsics.checkNotNullParameter(r101, "acceptType");
        Iterator<T> r102 = this.f247928a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ((j) r102.next()).d(r100, r101);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String r100, int r101, String r102) {
        super.onConsoleMessage(r100, r101, r102);
        Iterator<T> r103 = this.f247928a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        ((j) r103.next()).onConsoleMessage(r100, r101, r102);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, int r101, WebChromeClient.CustomViewCallback r102) {
        super.onShowCustomView(r100, r101, r102);
        Iterator<T> r103 = this.f247928a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        ((j) r103.next()).onShowCustomView(r100, r101, r102);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        Iterator<T> r103 = this.f247928a.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        return ((j) r103.next()).onShowFileChooser(r100, r101, r102);
    L10:
        return super.onShowFileChooser(r100, r101, r102);
    }

    public final void openFileChooser(ValueCallback<Uri> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uploadMsg");
        Intrinsics.checkNotNullParameter(r101, "acceptType");
        Intrinsics.checkNotNullParameter(r102, "capture");
        Iterator<T> r103 = this.f247928a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        ((j) r103.next()).e(r100, r101, r102);     // Catch: YieldError -> L8
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        Iterator<T> r104 = this.f247928a.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        return ((j) r104.next()).onJsAlert(r100, r101, r102, r103);
    L10:
        return super.onJsAlert(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        Iterator<T> r104 = this.f247928a.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        return ((j) r104.next()).onJsBeforeUnload(r100, r101, r102, r103);
    L10:
        return super.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        Iterator<T> r104 = this.f247928a.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        return ((j) r104.next()).onJsConfirm(r100, r101, r102, r103);
    L10:
        return super.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r100, String r110, String r111, String r112, JsPromptResult r113) {
        Iterator<T> r101 = this.f247928a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        return ((j) r101.next()).onJsPrompt(r100, r110, r111, r112, r113);
    L10:
        return super.onJsPrompt(r100, r110, r111, r112, r113);
    }
}
