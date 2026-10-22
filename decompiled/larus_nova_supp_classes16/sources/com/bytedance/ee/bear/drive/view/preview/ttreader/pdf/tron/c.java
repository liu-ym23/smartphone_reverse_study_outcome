package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements RequestPasswordView.b {
    public final /* synthetic */ PDFContentView a;

    public c(PDFContentView r1) {
        this.a = r1;
    }

    public final void a(String r2) {
        PDFContentView.b r0 = this.a.getViewDelegate();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
