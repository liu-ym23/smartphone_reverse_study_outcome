package com.bytedance.ee.bear.bitable.sort;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.panel.l;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements l {
    public final /* synthetic */ BitableSortPanelFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BitableSortData.SortedField c;

    public final void onExit() {
        BitableSortPanelFragment r0 = this.a;
        int r1 = BitableSortPanelFragment.u;
        BitableToolboxAnalytic r2 = r0.X90();
        if (r2 == null) goto L6;
        r2.P("cancel", PanelData.TAB_SORT);
        return;
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "id");
        BitableSortData r1 = this.a.n;
        if (r1 == null) goto L11;
        BitableSortData.SortedField[] r2 = r1.getSortInfo();
        if (r2 == null) goto L11;
        int r3 = this.b;
        BitableSortData.SortedField r4 = this.c;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.length <= r3) goto L10;
        r4 = r2[r3];
    L10:
        if (r4 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r6, "id");
        r4.setDesc(Boolean.valueOf(TextUtils.equals(r6, "true")));
        this.a.updateView();
        this.a.aa0();
        BitableToolboxAnalytic r7 = this.a.X90();
        if (r7 == null) goto L16;
        r7.P("input_area", PanelData.TAB_SORT);
        return;
    L16:
        return;
    L11:
        r4 = this.c;
        tt5.a.d("BitableSortPanelFragment", "mCurrentSortData find field error");
        goto L12
    }

    public e(BitableSortPanelFragment r1, int r2, BitableSortData.SortedField r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
