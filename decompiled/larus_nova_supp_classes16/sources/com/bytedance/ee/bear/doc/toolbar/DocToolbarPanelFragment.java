package com.bytedance.ee.bear.doc.toolbar;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelFragment;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.media.impl.InsertMediaCompatFragment;
import com.bytedance.ee.bear.document.toolbar.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarPanelFragment extends BaseToolbarPanelFragment<DocToolbar> {
    public DocToolbarPanelFragment() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelFragment
    public final Class<? extends DialogFragment> Y90(ItemId r4) {
        if (r4 != DocItemId.attribution) goto L7;
        return DocTxtAttrFragment.class;
    L7:
        if (r4 != DocItemId.insertImage) goto L11;
        return InsertMediaCompatFragment.class;
    L11:
        throw new IllegalStateException("get subToolbarFragmentClass on:" + r4);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelFragment
    public final int Z90(ItemId r1) {
        return o.a((DocItemId) r1);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelFragment
    public final BaseToolbarPanelViewModel aa0(FragmentActivity r2) {
        return (BaseToolbarPanelViewModel) ViewModelProviders.of(r2).get(DocToolbarPanelViewModel.class);
    }
}
