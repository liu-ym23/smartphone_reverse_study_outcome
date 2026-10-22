package com.bytedance.ee.bear.slides.toolbar;

import an4.a;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.edit_toolbar.DocToolbarV2Compat;
import com.bytedance.ee.bear.document.edit_toolbar.ToolbarV2PanelViewModel;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment;
import tn5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SlidesToolbarV2PanelFragment extends OfficeAbsToolbarV2PanelFragment {
    public a F;

    public final BaseToolbarV2PanelViewModel<DocToolbarV2> ea0() {
        return q.a(this, ToolbarV2PanelViewModel.class);
    }

    public final a0 wa0() {
        return DocToolbarV2Compat.of(requireActivity());
    }

    public SlidesToolbarV2PanelFragment() {
    }

    public final a Z90() {
        return this.F;
    }

    public final Class<? extends BaseSubToolbarV2Fragment<?>> xa0() {
        return SlidesSubToolbarFragment.class;
    }

    public final void ma0(ItemIdV2 r1, String r2) {
        super.ma0(r1, r2);
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super/*com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment*/.onViewCreated(r1, r2);
        r1.setOnGenericMotionListener(new d());
    }
}
