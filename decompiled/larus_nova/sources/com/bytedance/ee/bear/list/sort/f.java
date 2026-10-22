package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f229705c;

    public f(h r100) {
        this.f229705c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        tt5.a.h("SortAndFilterView", "onClick done()...");
        h r101 = this.f229705c;
        a.InterfaceC3282a r102 = r101.f229724r;
        if (r102 == null) goto L5;
        r102.z2(r101.o());
    L5:
        h.k(this.f229705c, "done");
        h.h(this.f229705c, "confirm");
    }
}
