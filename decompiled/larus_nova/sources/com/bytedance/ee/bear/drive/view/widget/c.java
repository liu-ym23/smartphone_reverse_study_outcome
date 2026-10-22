package com.bytedance.ee.bear.drive.view.widget;

import android.net.Uri;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<d> f225971a;

    public c() {
        this.f225971a = new ArrayList();
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        Iterator<d> r101 = this.f225971a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getClass();
        goto L4
    L6:
        this.f225971a.clear();
        super.onCloseWindow(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        if (this.f225971a.isEmpty() == false) goto L5;
        super.onPermissionRequest(r100);
        return;
    L5:
        Iterator<d> r101 = this.f225971a.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        r101.next().onPermissionRequest(r100);
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r100) {
        if (this.f225971a.isEmpty() == false) goto L5;
        super.onPermissionRequestCanceled(r100);
        return;
    L5:
        Iterator<d> r101 = this.f225971a.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        r101.next().onPermissionRequestCanceled(r100);
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        Iterator<d> r103 = this.f225971a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        if (r103.next().onShowFileChooser(r100, r101, r102) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
