package com.bytedance.ee.bear.middleground.docsdk.v2.toolbar;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.toolbar.DocItemId;
import com.bytedance.ee.bear.doc.toolbar.DocToolbar;
import com.bytedance.ee.bear.doc.toolbar.DocToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelFragment;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.media.impl.InsertMediaCompatFragment;
import com.bytedance.ee.bear.document.toolbar.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocSDKAppletsToolbarPanelFragment extends BaseToolbarPanelFragment<DocToolbar> {
    public DocSDKAppletsToolbarPanelFragment() {
    }

    public final Class<? extends DialogFragment> Y90(ItemId r4) {
        if (r4 != DocItemId.attribution) goto L7;
        return DocSdkTxtAttrFragment.class;
    L7:
        if (r4 != DocItemId.insertImage) goto L11;
        return InsertMediaCompatFragment.class;
    L11:
        throw new IllegalStateException("get subToolbarFragmentClass on:" + r4);
    }

    public final int Z90(ItemId r1) {
        return o.a((DocItemId) r1);
    }

    public final BaseToolbarPanelViewModel aa0(FragmentActivity r1) {
        return q.a(this, DocToolbarPanelViewModel.class);
    }
}
