package com.bytedance.ee.bear.drive.view.preview.wps;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends com.bytedance.ee.bear.drive.view.widget.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueCallback<Uri[]> f225678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f225679b;

    public interface a {
        void requestCamera();

        void requestFilePicker(boolean r100);

        void requestMediaPicker(boolean r100, boolean r101);
    }

    public h(a r100) {
        this.f225679b = r100;
    }

    public final void a(Uri[] r100) {
        tt5.a.h("WPSWebChromeClient", "setOnReceiveValue(): " + r100.length);
        ValueCallback<Uri[]> r101 = this.f225678a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.onReceiveValue(r100);
        this.f225678a = null;
    }

    public static boolean b(String r100, String r101) {
        boolean r102 = TextUtils.isEmpty(r100);
        boolean r103 = TextUtils.isEmpty(r101);
        if (r102 == false) goto L7;
        if (r103 == false) goto L7;
        return true;
    L7:
        if (r102 == true) goto L12;
        if (r103 == false) goto L11;
        return false;
    L11:
        return r100.toLowerCase().startsWith(r101);
    L12:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.d, android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        tt5.a.h("WPSWebChromeClient", "onShowFileChooser click");
        boolean r103 = false;
        if (r102 != null) goto L5;
    L25:
        return false;
    L5:
        if (this.f225679b == null) goto L25;
        tt5.a.h("WPSWebChromeClient", "onShowFileChooser: AcceptTypes=" + Arrays.toString(r102.getAcceptTypes()) + ", Mode=" + r102.getMode() + ", CaptureEnabled=" + r102.isCaptureEnabled());
        this.f225678a = r101;
        if (r102.isCaptureEnabled() == false) goto L11;
        this.f225679b.requestCamera();
        return true;
    L11:
        String[] r104 = r102.getAcceptTypes();
        boolean r105 = b(r104[0], "video");
        boolean r106 = b(r104[0], "image");
        if (r104.length >= 2) goto L17;
        if (r106 == true) goto L16;
        if (r105 == false) goto L17;
    L16:
        boolean r107 = false;
    L19:
        if (r102.getMode() != 1) goto L21;
        r103 = true;
    L21:
        if (r107 == false) goto L23;
        this.f225679b.requestFilePicker(r103);
    L24:
        return true;
    L23:
        this.f225679b.requestMediaPicker(r103, r106);
    L17:
        r107 = true;
        goto L19
    }
}
