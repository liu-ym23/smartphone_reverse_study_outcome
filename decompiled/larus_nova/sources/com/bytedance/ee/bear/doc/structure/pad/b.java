package com.bytedance.ee.bear.doc.structure.pad;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnHoverListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CatalogListAdapter f218224a;

    public b(CatalogListAdapter r100) {
        this.f218224a = r100;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 9) goto L5;
        r100.setHovered(true);
    L9:
        View.OnHoverListener r103 = this.f218224a.f218209f;
        if (r103 != null) goto L12;
        return false;
    L12:
        return r103.onHover(r100, r101);
    L5:
        if (r102 != 10) goto L9;
        r100.setHovered(false);
        goto L9
    }
}
