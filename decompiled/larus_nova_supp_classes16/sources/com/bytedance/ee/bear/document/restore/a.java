package com.bytedance.ee.bear.document.restore;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements DocDeletedView.b {
    public final /* synthetic */ DocDeletedCtrlView a;

    @Override // com.bytedance.ee.bear.document.restore.DocDeletedView.b
    public final void a() {
        int r0 = d.a;
        HashMap<String, Object> r1 = this.a.e;
        if (r1 == null) goto L6;
        HashMap r2 = new HashMap();
        r2.putAll(r1);
        r2.put("click", "recover_docs");
        r2.put("target", "ccm_docs_page_view");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_delete_click", r2);
    L6:
        DocDeletedViewModel r3 = this.a.b;
        if (r3 == null) goto L10;
        r3.restoreFile();
        return;
    }

    public a(DocDeletedCtrlView r1) {
        this.a = r1;
    }
}
