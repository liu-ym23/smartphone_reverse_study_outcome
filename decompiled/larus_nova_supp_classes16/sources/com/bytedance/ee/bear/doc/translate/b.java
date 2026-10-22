package com.bytedance.ee.bear.doc.translate;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends CommonActionPanelLayout.b {
    public final /* synthetic */ ChooseLanguageFragment a;

    public final void b() {
        ChooseLanguageFragment r0 = this.a;
        r0.getClass();
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r3 = new HashMap(r1.m("docCommonParams"));
        r3.put("click", "close");
        r3.put("target", "none");
        r1.n("ccm_space_docs_topbar_click", r3);
        tt5.a.b(r0.k, "reportTopBarClickCloseEvent, params = " + r3);
        TranslateViewModel r2 = this.a.l;
        if (r2 == null) goto L8;
        MutableLiveData<Boolean> r4 = r2.getShowingChooseLanguagePanel();
        if (r4 == null) goto L9;
        r4.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }

    public b(ChooseLanguageFragment r1) {
        this.a = r1;
    }
}
