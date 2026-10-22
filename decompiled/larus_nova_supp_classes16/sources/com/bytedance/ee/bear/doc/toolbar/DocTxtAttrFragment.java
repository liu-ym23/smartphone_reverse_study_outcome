package com.bytedance.ee.bear.doc.toolbar;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import oz4.a;
import oz4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocTxtAttrFragment extends AbsDocTxtAttrFragment {
    public static final /* synthetic */ int n = 0;

    public DocTxtAttrFragment() {
        a r0 = (a) org.koin.java.a.b(a.class, null, new b(this));
    }

    @Override // com.bytedance.ee.bear.doc.toolbar.AbsDocTxtAttrFragment
    public final DocToolbarPanelViewModel ea0(FragmentActivity r2) {
        return (DocToolbarPanelViewModel) ViewModelProviders.of(r2).get(DocToolbarPanelViewModel.class);
    }
}
