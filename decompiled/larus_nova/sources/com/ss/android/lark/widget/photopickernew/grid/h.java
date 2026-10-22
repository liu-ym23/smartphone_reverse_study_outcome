package com.ss.android.lark.widget.photopickernew.grid;

import android.view.View;
import com.ss.android.lark.widget.photopickerimpl.view.grid.GridComponent;
import rdc.q;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f447945a;

    public h(g r100) {
        this.f447945a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.ss.android.lark.widget.photopickerimpl.bean.c r101 = new com.ss.android.lark.widget.photopickerimpl.bean.c();
        g r102 = this.f447945a;
        r101.b("selectedPhoto", ((q) r102.f447933b).f537375a.a());
        r101.b("checkedOrigin", Boolean.valueOf(((q) r102.f447933b).f537375a.f537382d));
        r101.b("isVideo", Boolean.valueOf(((q) r102.f447933b).f537375a.f537383e));
        GridComponent.b r103 = this.f447945a.f447934c;
        if (r103 == null) goto L6;
        r103.b(r101);
        return;
    }
}
