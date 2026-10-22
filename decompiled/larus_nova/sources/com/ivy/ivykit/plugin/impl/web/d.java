package com.ivy.ivykit.plugin.impl.web;

import android.content.Intent;
import android.webkit.WebChromeClient;
import b36.n;

/* JADX INFO: loaded from: classes23.dex */
public final class d extends WebChromeClient.FileChooserParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b36.a f278486a;

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final Intent createIntent() {
        b36.a r100 = this.f278486a;
        if (r100 == null) goto L7;
        Intent r101 = r100.a();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new Intent();
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final String[] getAcceptTypes() {
        b36.a r100 = this.f278486a;
        if (r100 == null) goto L7;
        String[] r101 = r100.d();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new String[0];
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final String getFilenameHint() {
        b36.a r100 = this.f278486a;
        if (r100 == null) goto L7;
        CharSequence r101 = r100.b();
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final int getMode() {
        b36.a r100 = this.f278486a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMode();
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final CharSequence getTitle() {
        b36.a r100 = this.f278486a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTitle();
    }

    @Override // android.webkit.WebChromeClient.FileChooserParams
    public final boolean isCaptureEnabled() {
        b36.a r100 = this.f278486a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    public d(n r100) {
        this.f278486a = r100;
    }
}
