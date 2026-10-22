package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class i0 extends u {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ h0 f401832q;

    @Override // com.obric.oui.orecyclerview.widget.u
    public final float e(DisplayMetrics r100) {
        return 100.0f / r100.densityDpi;
    }

    public i0(h0 r100, Context r101) {
        this.f401832q = r100;
        super(r101);
    }

    @Override // com.obric.oui.orecyclerview.widget.u, com.obric.oui.orecyclerview.widget.RecyclerView.u
    public final void b(View r100, RecyclerView.u.a r101) {
        h0 r102 = this.f401832q;
        RecyclerView r103 = r102.f401825a;
        if (r103 != null) goto L5;
        return;
    L5:
        int[] r104 = r102.b(r103.getLayoutManager(), r100);
        int r105 = r104[0];
        int r106 = r104[1];
        int r107 = (int) Math.ceil(((double) f(Math.max(Math.abs(r105), Math.abs(r106)))) / 0.2d);
        if (r107 <= 0) goto L9;
        r101.update(r105, r106, r107, this.f401957j);
        return;
    }
}
