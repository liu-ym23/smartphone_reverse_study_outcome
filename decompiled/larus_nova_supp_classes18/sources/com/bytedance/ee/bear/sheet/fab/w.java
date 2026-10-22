package com.bytedance.ee.bear.sheet.fab;

import android.widget.LinearLayout;
import com.bytedance.ee.util.observer.DiffObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w extends DiffObserver<Boolean> {
    public final /* synthetic */ OfficeFabFragment b;

    public w(OfficeFabFragment r1) {
        this.b = r1;
    }

    public final void a(Object r3) {
        Boolean r4 = (Boolean) r3;
        LinearLayout r0 = this.b.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Boolean.TRUE.equals(r4) == false) goto L8;
        int r5 = 0;
    L9:
        r0.setVisibility(r5);
        return;
    L8:
        r5 = 8;
        goto L9
    }
}
