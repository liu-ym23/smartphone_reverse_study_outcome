package com.bytedance.ee.bear.document.selection;

import android.view.ActionMode;
import android.view.Menu;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends a {
    public String g;

    public c(WebView r1, String r2) {
        super(r1, r2);
        this.d = 100;
    }

    public final void d(final Menu r9, final com.bytedance.ee.bear.contract.d r10, final ActionMode r11, final boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.a.evaluateJavascript("(function(){return window.getSelection().toString()})()", new b(this, r9, r12, r11, r10));
    }
}
