package com.bytedance.ee.bear.drive.view.preview.wps;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.WpsPreviewView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u0 extends com.bytedance.ee.bear.drive.view.widget.j {
    public final /* synthetic */ WpsView a;

    public u0(WpsView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void a(WebView r1, String r2) {
        f r3 = this.a.x;
        if (r3 == null) goto L5;
        ((WpsPreviewView.a) r3).a.trackLoadTemplateSuccess();
    L5:
        tt5.a.h("WpsWebView", "showDocuments loadRes time ");
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void b(int r2, String r3, String r4) {
        tt5.a.h("WpsWebView", "onReceivedError errorcode is " + r2 + " description is " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        boolean r5 = false;
    L6:
        if (r5 == true) goto L8;
        return;
    L8:
        if (this.a.w == true) goto L12;
        tt5.a.h("WpsWebView", "onReceivedError reload");
        this.a.a.reload();
        this.a.w = true;
        return;
    L12:
        return;
    L5:
        r5 = r3.contains("ERR_FILE_NOT_FOUND");
        goto L6
    }
}
