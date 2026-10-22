package com.bytedance.ee.bear.bitable.sort;

import com.bytedance.ee.bear.bitable.panel.l;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements l {
    public final /* synthetic */ BitableSortPanelFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BitableSortData.SortedField c;

    public final void onExit() {
        BitableSortPanelFragment r0 = this.a;
        int r1 = BitableSortPanelFragment.u;
        BitableToolboxAnalytic r2 = r0.X90();
        if (r2 == null) goto L6;
        r2.P("cancel", "field");
        return;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        BitableSortData r0 = this.a.n;
        if (r0 == null) goto L11;
        BitableSortData.SortedField[] r1 = r0.getSortInfo();
        if (r1 == null) goto L11;
        int r2 = this.b;
        BitableSortData.SortedField r3 = this.c;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.length <= r2) goto L10;
        r3 = r1[r2];
    L10:
        if (r3 == null) goto L11;
    L13:
        if (Intrinsics.areEqual(r5, r3.getFieldId()) == true) goto L18;
        r3.setFieldId(r5);
        this.a.updateView();
        this.a.aa0();
        BitableToolboxAnalytic r6 = this.a.X90();
        if (r6 == null) goto L19;
        r6.P("input_area", "field");
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r3 = this.c;
        tt5.a.d("BitableSortPanelFragment", "mCurrentSortData find field error");
        goto L13
    }

    public f(BitableSortPanelFragment r1, int r2, BitableSortData.SortedField r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
