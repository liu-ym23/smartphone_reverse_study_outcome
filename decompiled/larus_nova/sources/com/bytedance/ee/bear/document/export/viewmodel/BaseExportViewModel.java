package com.bytedance.ee.bear.document.export.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a;
import rw4.n;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseExportViewModel<Delegate extends a> extends ViewModel {
    private static final String TAG = "BaseExportViewModel";
    protected Delegate delegate;

    public interface a {
        void a(n r100, String r101, rw4.a r102);

        void b(String r100);

        void d(String r100);

        void g();

        String getToken();

        void j(String r100);
    }

    public void cancelExport() {
        tt5.a.h(TAG, "cancelExport");
        Delegate r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    public String getToken() {
        tt5.a.h(TAG, "getToken");
        Delegate r100 = this.delegate;
        if (r100 == null) goto L7;
        r100.getToken();
        return "";
    L7:
        return "";
    }

    public void onDestroy() {
        tt5.a.h(TAG, LiveCommonConstants.REASON_ON_DEDTROY);
        cancelExport();
        this.delegate = null;
    }

    public BaseExportViewModel() {
    }

    public void reportExportCanceled(String r100) {
        Delegate r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    public void reportExportFailed(String r100) {
        Delegate r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public void reportExportSuccess(String r100) {
        Delegate r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void setDelegate(Delegate r100) {
        this.delegate = r100;
    }

    public void exportDocument(n r100, rw4.a r101) {
        exportDocument(r100, null, r101);
    }

    public void exportDocument(n r100, String r101, rw4.a r102) {
        tt5.a.h(TAG, "exportDocument, format = " + r100);
        Delegate r103 = this.delegate;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }
}
