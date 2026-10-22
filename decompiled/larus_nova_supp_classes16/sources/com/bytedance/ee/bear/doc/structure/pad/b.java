package com.bytedance.ee.bear.doc.structure.pad;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnHoverListener {
    public final /* synthetic */ CatalogListAdapter a;

    public b(CatalogListAdapter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View r4, MotionEvent r5) {
        int r0 = r5.getAction();
        if (r0 != 9) goto L5;
        r4.setHovered(true);
    L9:
        View.OnHoverListener r1 = this.a.f;
        if (r1 != null) goto L12;
        return false;
    L12:
        return r1.onHover(r4, r5);
    L5:
        if (r0 != 10) goto L9;
        r4.setHovered(false);
        goto L9
    }
}
