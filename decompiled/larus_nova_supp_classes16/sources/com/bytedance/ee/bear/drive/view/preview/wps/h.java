package com.bytedance.ee.bear.drive.view.preview.wps;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends com.bytedance.ee.bear.drive.view.widget.d {
    public ValueCallback<Uri[]> a;
    public final a b;

    public interface a {
        void requestCamera();

        void requestFilePicker(boolean r1);

        void requestMediaPicker(boolean r1, boolean r2);
    }

    public h(a r1) {
        this.b = r1;
    }

    public final void a(Uri[] r3) {
        tt5.a.h("WPSWebChromeClient", "setOnReceiveValue(): " + r3.length);
        ValueCallback<Uri[]> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onReceiveValue(r3);
        this.a = null;
    }

    public static boolean b(String r2, String r3) {
        boolean r0 = TextUtils.isEmpty(r2);
        boolean r1 = TextUtils.isEmpty(r3);
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        return true;
    L7:
        if (r0 == true) goto L12;
        if (r1 == false) goto L11;
        return false;
    L11:
        return r2.toLowerCase().startsWith(r3);
    L12:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.d, android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r5, ValueCallback<Uri[]> r6, WebChromeClient.FileChooserParams r7) {
        tt5.a.h("WPSWebChromeClient", "onShowFileChooser click");
        boolean r0 = false;
        if (r7 != null) goto L5;
    L25:
        return false;
    L5:
        if (this.b == null) goto L25;
        tt5.a.h("WPSWebChromeClient", "onShowFileChooser: AcceptTypes=" + Arrays.toString(r7.getAcceptTypes()) + ", Mode=" + r7.getMode() + ", CaptureEnabled=" + r7.isCaptureEnabled());
        this.a = r6;
        if (r7.isCaptureEnabled() == false) goto L11;
        this.b.requestCamera();
        return true;
    L11:
        String[] r8 = r7.getAcceptTypes();
        boolean r1 = b(r8[0], VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE);
        boolean r2 = b(r8[0], "image");
        if (r8.length >= 2) goto L17;
        if (r2 == true) goto L16;
        if (r1 == false) goto L17;
    L16:
        boolean r9 = false;
    L19:
        if (r7.getMode() != 1) goto L21;
        r0 = true;
    L21:
        if (r9 == false) goto L23;
        this.b.requestFilePicker(r0);
    L24:
        return true;
    L23:
        this.b.requestMediaPicker(r0, r2);
    L17:
        r9 = true;
        goto L19
    }
}
