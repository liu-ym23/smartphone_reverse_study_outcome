package com.bytedance.ee.bear.middleground.docsdk.v2.toolbar;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.toolbar.AbsDocTxtAttrFragment;
import com.bytedance.ee.bear.doc.toolbar.DocToolbarPanelViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocSdkTxtAttrFragment extends AbsDocTxtAttrFragment {
    public DocSdkTxtAttrFragment() {
    }

    public final DocToolbarPanelViewModel ea0(FragmentActivity r1) {
        return q.a(this, DocToolbarPanelViewModel.class);
    }
}
