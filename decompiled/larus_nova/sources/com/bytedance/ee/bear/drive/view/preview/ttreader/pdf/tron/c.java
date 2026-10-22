package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements RequestPasswordView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFContentView f225329a;

    public c(PDFContentView r100) {
        this.f225329a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView.b
    public final void a(String r100) {
        PDFContentView.b r101 = this.f225329a.getViewDelegate();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
