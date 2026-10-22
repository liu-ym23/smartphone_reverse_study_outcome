package com.bytedance.ee.bear.bitable.sort;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.filtersortviewsetting.BitableFilterSortViewSettingPanel;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ BitableSortPanelFragment a;

    public c(BitableSortPanelFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        String r5 = (String) r4;
        tt5.a.h("BitableSortPanelFragment", "on tab changed tab=" + r5);
        BitableFilterSortViewSettingPanel r0 = this.a.getParentFragment();
        TextView r2 = null;
        if ((r0 instanceof BitableFilterSortViewSettingPanel) == false) goto L5;
        BitableFilterSortViewSettingPanel r1 = r0;
    L7:
        if (Intrinsics.areEqual(r5, PanelData.TAB_SORT) == false) goto L9;
        BitableSortPanelFragment r6 = this.a;
        int r3 = BitableSortPanelFragment.u;
        r6.ba0();
        return;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.fa0() == null) goto L27;
        View r7 = ((BaseActionPanelFragment) r1).x;
        if (r7 != null) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L18;
        r7.setEnabled(true);
    L18:
        TextView r8 = ((BaseActionPanelFragment) r1).y;
        if (r8 == null) goto L22;
        r2 = r8;
    L22:
        if (r2 == null) goto L28;
        r2.setEnabled(true);
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
