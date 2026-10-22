package com.bytedance.ee.bear.document.export.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseExportViewModel<Delegate extends a> extends ViewModel {
    private static final String TAG = "BaseExportViewModel";
    protected Delegate delegate;

    public interface a {
        void a(n r1, String r2, rw4.a r3);

        void b(String r1);

        void d(String r1);

        void g();

        String getToken();

        void j(String r1);
    }

    public void cancelExport() {
        tt5.a.h(TAG, "cancelExport");
        Delegate r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public String getToken() {
        tt5.a.h(TAG, "getToken");
        Delegate r0 = this.delegate;
        if (r0 == null) goto L7;
        r0.getToken();
        return "";
    L7:
        return "";
    }

    public void onDestroy() {
        tt5.a.h(TAG, "onDestroy");
        cancelExport();
        this.delegate = null;
    }

    public BaseExportViewModel() {
    }

    public void reportExportCanceled(String r2) {
        Delegate r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    public void reportExportFailed(String r2) {
        Delegate r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    public void reportExportSuccess(String r2) {
        Delegate r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public void setDelegate(Delegate r1) {
        this.delegate = r1;
    }

    public void exportDocument(n r2, rw4.a r3) {
        exportDocument(r2, null, r3);
    }

    public void exportDocument(n r3, String r4, rw4.a r5) {
        tt5.a.h(TAG, "exportDocument, format = " + r3);
        Delegate r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.a(r3, r4, r5);
        return;
    }
}
