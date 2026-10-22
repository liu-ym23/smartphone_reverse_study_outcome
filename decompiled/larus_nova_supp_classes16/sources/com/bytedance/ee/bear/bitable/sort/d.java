package com.bytedance.ee.bear.bitable.sort;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ BitableSortPanelFragment a;

    public d(BitableSortPanelFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r7, boolean r8) {
        BitableSortData r9 = this.a.n;
        if (r9 == null) goto L5;
        boolean r10 = Intrinsics.areEqual(Boolean.valueOf(r8), r9.getAutoSort());
    L6:
        if (r10 == true) goto L14;
        BitableSortData r11 = this.a.n;
        if (r11 == null) goto L10;
        r11.setAutoSort(Boolean.valueOf(r8));
    L10:
        this.a.ca0();
        this.a.V90();
        BitableToolboxAnalytic r0 = this.a.X90();
        if (r0 == null) goto L15;
        BitableToolboxAnalytic.O(r0, "auto_sort", Boolean.valueOf(r8), null, null, 12);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r10 = false;
        goto L6
    }
}
