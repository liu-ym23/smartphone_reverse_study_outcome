package vv4;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends ws5.b {
    public final List<WebChromeClient> d;

    public final Bitmap getDefaultVideoPoster() {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Bitmap r1 = ((WebChromeClient) r0.next()).getDefaultVideoPoster();
        if (r1 == null) goto L4;
        return r1;
    L9:
        return super.getDefaultVideoPoster();
    }

    public final View getVideoLoadingProgressView() {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((WebChromeClient) r0.next()).getVideoLoadingProgressView();
        goto L4
    L7:
        return super.getVideoLoadingProgressView();
    }

    public final void onGeolocationPermissionsHidePrompt() {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onGeolocationPermissionsHidePrompt();
        goto L4
    }

    public final void onHideCustomView() {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onHideCustomView();
        goto L4
    }

    public final boolean onJsTimeout() {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onJsTimeout() == false) goto L4;
        return true;
    L10:
        return super.onJsTimeout();
    }

    public c(ys5.c r1) {
        super(r1);
        this.d = new CopyOnWriteArrayList();
    }

    public final void getVisitedHistory(ValueCallback<String[]> r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).getVisitedHistory(r3);
        goto L4
    }

    public final void onCloseWindow(WebView r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onCloseWindow(r3);
        goto L4
    }

    public final boolean onConsoleMessage(ConsoleMessage r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onConsoleMessage(r3) == false) goto L4;
        return true;
    L10:
        return super.onConsoleMessage(r3);
    }

    public final void onPermissionRequest(PermissionRequest r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((WebChromeClient) r0.next()).onPermissionRequest(r3);     // Catch: Throwable -> L7
        goto L4
    L14:
        return;
    L7:
        th = move-exception;
        tt5.a.d("ExtendableWebChromeClient", th.getMessage());
    }

    public final void onPermissionRequestCanceled(PermissionRequest r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onPermissionRequestCanceled(r3);
        goto L4
    }

    public final void onRequestFocus(WebView r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onRequestFocus(r3);
        goto L4
    }

    public final void onGeolocationPermissionsShowPrompt(String r21, GeolocationPermissions.Callback r22) {
        ArrayList r2 = new ArrayList();
        Object[] r3 = {r21, r22};
        f06.b r13 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(100003);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r17 = r9;
        int r18 = r10;
        f06.a[] r19 = r11;
        f06.d r6 = r8.preInvoke(100003, "com/bytedance/ee/bear/browser/ExtendableWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r3, "void", r13);     // Catch: Exception -> L24
        if (r6.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L24
    L17:
        if (r6.a == false) goto L19;
        return;
    L19:
        Iterator r7 = ((CopyOnWriteArrayList) this.d).iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        ((WebChromeClient) r7.next()).onGeolocationPermissionsShowPrompt(r21, r22);
        goto L21
    L23:
        return;
    L14:
        r9 = r17 + 1;
        r10 = r18;
        r11 = r19;
        goto L8
    L15:
        r6 = new f06.d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }

    public final void onProgressChanged(WebView r3, int r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onProgressChanged(r3, r4);
        goto L4
    }

    public final void onReceivedIcon(WebView r3, Bitmap r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onReceivedIcon(r3, r4);
        goto L4
    }

    public final void onReceivedTitle(WebView r3, String r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onReceivedTitle(r3, r4);
        goto L4
    }

    public final void onShowCustomView(View r3, WebChromeClient.CustomViewCallback r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onShowCustomView(r3, r4);
        goto L4
    }

    public final void onConsoleMessage(String r3, int r4, String r5) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onConsoleMessage(r3, r4, r5);
        goto L4
    }

    public final void onReceivedTouchIconUrl(WebView r3, String r4, boolean r5) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onReceivedTouchIconUrl(r3, r4, r5);
        goto L4
    }

    public final void onShowCustomView(View r3, int r4, WebChromeClient.CustomViewCallback r5) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebChromeClient) r0.next()).onShowCustomView(r3, r4, r5);
        goto L4
    }

    public final boolean onShowFileChooser(WebView r1, ValueCallback<Uri[]> r2, WebChromeClient.FileChooserParams r3) {
        super.onShowFileChooser(r1, r2, r3);
        return true;
    }

    public final boolean onCreateWindow(WebView r3, boolean r4, boolean r5, Message r6) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onCreateWindow(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onCreateWindow(r3, r4, r5, r6);
    }

    public final boolean onJsAlert(WebView r3, String r4, String r5, JsResult r6) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onJsAlert(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onJsAlert(r3, r4, r5, r6);
    }

    public final boolean onJsBeforeUnload(WebView r3, String r4, String r5, JsResult r6) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onJsBeforeUnload(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onJsBeforeUnload(r3, r4, r5, r6);
    }

    public final boolean onJsConfirm(WebView r3, String r4, String r5, JsResult r6) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onJsConfirm(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onJsConfirm(r3, r4, r5, r6);
    }

    public final boolean onJsPrompt(WebView r9, String r10, String r11, String r12, JsPromptResult r13) {
        Iterator r0 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (((WebChromeClient) r0.next()).onJsPrompt(r9, r10, r11, r12, r13) == false) goto L4;
        return true;
    L10:
        return super.onJsPrompt(r9, r10, r11, r12, r13);
    }

    public final void onExceededDatabaseQuota(String r14, String r16, long r17, long r18, long r20, WebStorage.QuotaUpdater r22) {
        Iterator r1 = ((CopyOnWriteArrayList) this.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((WebChromeClient) r1.next()).onExceededDatabaseQuota(r14, r16, r17, r18, r20, r22);
        goto L4
    }
}
