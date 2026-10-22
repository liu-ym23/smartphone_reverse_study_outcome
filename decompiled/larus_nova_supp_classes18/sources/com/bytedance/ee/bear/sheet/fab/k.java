package com.bytedance.ee.bear.sheet.fab;

import android.widget.LinearLayout;
import com.bytedance.ee.util.observer.DiffObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends DiffObserver<Boolean> {
    public final /* synthetic */ FabFragment b;

    public k(FabFragment r1) {
        this.b = r1;
    }

    public final void a(Object r3) {
        LinearLayout r0 = this.b.e;
        Boolean r1 = Boolean.TRUE;
        if (r1.equals((Boolean) r3) == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }
}
