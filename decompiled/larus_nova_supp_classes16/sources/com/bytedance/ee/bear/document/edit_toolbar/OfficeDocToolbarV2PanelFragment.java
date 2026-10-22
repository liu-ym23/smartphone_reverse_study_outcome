package com.bytedance.ee.bear.document.edit_toolbar;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeDocToolbarV2PanelFragment extends OfficeAbsToolbarV2PanelFragment {
    public an4.a F;

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final BaseToolbarV2PanelViewModel<DocToolbarV2> ea0() {
        return (BaseToolbarV2PanelViewModel) q.a(this, ToolbarV2PanelViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment
    public final a0 wa0() {
        return DocToolbarV2Compat.of(requireActivity());
    }

    public OfficeDocToolbarV2PanelFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final an4.a Z90() {
        return this.F;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment, com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment
    public final Class<? extends BaseSubToolbarV2Fragment<?>> xa0() {
        return DocSubToolbarFragment.class;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment, com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void ma0(ItemIdV2 r1, String r2) {
        super.ma0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        r1.setOnGenericMotionListener(new f());
    }
}
