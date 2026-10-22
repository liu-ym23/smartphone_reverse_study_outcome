package com.bytedance.ee.bear.document.edit_toolbar;

import android.os.Bundle;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.AbsSubToolbarFragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocSubToolbarFragment extends AbsSubToolbarFragment {
    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseToolbarV2PanelViewModel<DocToolbarV2> Z90() {
        return (BaseToolbarV2PanelViewModel) q.a(this, ToolbarV2PanelViewModel.class);
    }

    static {
    }

    public DocSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        ((DocViewModel) q.a(this, DocViewModel.class)).getBearUrl();
        com.bytedance.ee.bear.contract.d r2 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
    }
}
