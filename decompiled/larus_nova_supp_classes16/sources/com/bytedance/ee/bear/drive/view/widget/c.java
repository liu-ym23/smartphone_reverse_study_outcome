package com.bytedance.ee.bear.drive.view.widget;

import android.net.Uri;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends WebChromeClient {
    public final ArrayList<d> a;

    public c() {
        this.a = new ArrayList();
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r3) {
        Iterator<d> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getClass();
        goto L4
    L6:
        this.a.clear();
        super.onCloseWindow(r3);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r3) {
        if (this.a.isEmpty() == false) goto L5;
        super.onPermissionRequest(r3);
        return;
    L5:
        Iterator<d> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        r0.next().onPermissionRequest(r3);
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r3) {
        if (this.a.isEmpty() == false) goto L5;
        super.onPermissionRequestCanceled(r3);
        return;
    L5:
        Iterator<d> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        r0.next().onPermissionRequestCanceled(r3);
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r3, ValueCallback<Uri[]> r4, WebChromeClient.FileChooserParams r5) {
        Iterator<d> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().onShowFileChooser(r3, r4, r5) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
