package com.bytedance.ee.bear.document.export.viewmodel;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.m;

/* JADX INFO: loaded from: classes16.dex */
public class DocExportViewModel extends BaseExportViewModel<a> {
    private static final String TAG = "DocExportViewModel";

    public interface a extends BaseExportViewModel.a {
        void c(String r100);

        boolean e();
    }

    public a getDelegate() {
        return (a) this.delegate;
    }

    public boolean shouldShowDocShot() {
        Delegate r100 = this.delegate;
        if (r100 != 0) goto L5;
        return false;
    L5:
        return ((a) r100).e();
    }

    public DocExportViewModel() {
    }

    public void startDocShot(m.b r100) {
        startDocShot(null, r100);
    }

    public void startDocShot(String r100, m.b r101) {
        ((m) org.koin.java.a.a(m.class)).h(ShareType.ExportImage.name(), r100, r101);
    }
}
