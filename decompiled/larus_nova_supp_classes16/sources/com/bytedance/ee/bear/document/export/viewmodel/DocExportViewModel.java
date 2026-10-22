package com.bytedance.ee.bear.document.export.viewmodel;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocExportViewModel extends BaseExportViewModel<a> {
    private static final String TAG = "DocExportViewModel";

    public interface a extends BaseExportViewModel.a {
        void c(String r1);

        boolean e();
    }

    public a getDelegate() {
        return (a) this.delegate;
    }

    public boolean shouldShowDocShot() {
        Delegate r0 = this.delegate;
        if (r0 != 0) goto L5;
        return false;
    L5:
        return ((a) r0).e();
    }

    public DocExportViewModel() {
    }

    public void startDocShot(m.b r2) {
        startDocShot(null, r2);
    }

    public void startDocShot(String r3, m.b r4) {
        ((m) org.koin.java.a.a(m.class)).h(ShareType.ExportImage.name(), r3, r4);
    }
}
