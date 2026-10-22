package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar2;

import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.edit.component.toolbar2.AbsSubToolbarFragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolbarV2PanelViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SDKSubToolbarFragment extends AbsSubToolbarFragment {
    public final BaseToolbarV2PanelViewModel<DocToolbarV2> Z90() {
        return q.a(this, ToolbarV2PanelViewModel.class);
    }

    static {
    }

    public SDKSubToolbarFragment() {
    }
}
