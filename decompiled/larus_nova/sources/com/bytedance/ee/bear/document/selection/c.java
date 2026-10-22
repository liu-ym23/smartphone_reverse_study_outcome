package com.bytedance.ee.bear.document.selection;

import android.view.ActionMode;
import android.view.Menu;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f221601g;

    public c(WebView r100, String r101) {
        super(r100, r101);
        this.f221591d = 100;
    }

    public final void d(final Menu r100, final com.bytedance.ee.bear.contract.d r110, final ActionMode r111, final boolean r112) {
        if (r111 != null) goto L4;
        return;
    L4:
        this.f221588a.evaluateJavascript("(function(){return window.getSelection().toString()})()", new b(this, r100, r112, r111, r110));
    }
}
