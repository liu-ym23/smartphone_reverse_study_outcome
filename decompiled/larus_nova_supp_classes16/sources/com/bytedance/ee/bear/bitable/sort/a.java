package com.bytedance.ee.bear.bitable.sort;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    public final /* synthetic */ BitableSortPanel c;

    public a(BitableSortPanel r1) {
        this.c = r1;
    }

    public final void a(View r2) {
        Fragment r3 = this.c.getChildFragmentManager().findFragmentByTag("BitableSortPanel");
        if ((r3 instanceof BitableSortPanelFragment) == false) goto L5;
        BitableSortPanelFragment r4 = (BitableSortPanelFragment) r3;
    L6:
        if (r4 == null) goto L9;
        r4.Z90();
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
