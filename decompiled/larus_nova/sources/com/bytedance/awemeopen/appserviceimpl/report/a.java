package com.bytedance.awemeopen.appserviceimpl.report;

import com.bytedance.awemeopen.domain.report.ReportWebView;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements f34.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReportWebView f198148a;

    @Override // f34.a
    public final boolean onBackPressed() {
        ReportWebView r100 = this.f198148a;
        if (r100.canGoBack() == false) goto L5;
        r100.goBack();
        return true;
    L5:
        return false;
    }

    @Override // f34.a
    public final void reload() {
        this.f198148a.reload();
    }

    public a(ReportWebView r100) {
        this.f198148a = r100;
    }
}
