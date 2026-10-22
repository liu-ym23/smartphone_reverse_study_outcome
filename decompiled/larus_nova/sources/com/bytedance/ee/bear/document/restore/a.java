package com.bytedance.ee.bear.document.restore;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements DocDeletedView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocDeletedCtrlView f221445a;

    @Override // com.bytedance.ee.bear.document.restore.DocDeletedView.b
    public final void a() {
        int r100 = d.f221466a;
        HashMap<String, Object> r101 = this.f221445a.f221415e;
        if (r101 == null) goto L6;
        HashMap r102 = new HashMap();
        r102.putAll(r101);
        r102.put("click", "recover_docs");
        r102.put(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_delete_click", r102);
    L6:
        DocDeletedViewModel r103 = this.f221445a.f221412b;
        if (r103 == null) goto L10;
        r103.restoreFile();
        return;
    }

    public a(DocDeletedCtrlView r100) {
        this.f221445a = r100;
    }
}
