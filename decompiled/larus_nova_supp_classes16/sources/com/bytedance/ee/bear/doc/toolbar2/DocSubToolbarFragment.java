package com.bytedance.ee.bear.doc.toolbar2;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.edit.component.toolbar2.AbsSubToolbarFragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolbarV2PanelViewModel;
import oz4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocSubToolbarFragment extends AbsSubToolbarFragment {
    public static final /* synthetic */ int v = 0;
    public a u;

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment
    public final BaseToolbarV2PanelViewModel<DocToolbarV2> Z90() {
        return (BaseToolbarV2PanelViewModel) q.a(this, ToolbarV2PanelViewModel.class);
    }

    static {
    }

    public DocSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.AbsSubToolbarFragment
    public final void ja0(String r3) {
        a r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3, "#clear") == false) goto L7;
        r0.a("highlight_cancel", null);
        return;
    L7:
        r0.a("highlight_default", r3);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.AbsSubToolbarFragment
    public final void ka0(String r3) {
        a r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3, "#clear") == false) goto L7;
        r0.a("highlight_cancel", null);
        return;
    L7:
        r0.a("highlight_switch_color", r3);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.u = (a) org.koin.java.a.b(a.class, null, new pz4.a(this));
    }
}
