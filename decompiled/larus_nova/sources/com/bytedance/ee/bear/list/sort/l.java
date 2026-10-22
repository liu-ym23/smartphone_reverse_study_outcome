package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f229739c;

    public l(m r100) {
        this.f229739c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        m r101 = this.f229739c;
        List<q> r102 = r101.f229747h.f229644b;
        if (r102 == null) goto L15;
        q r103 = (q) ListProtector.get(r102, r101.f229743d);
        if (r103 == null) goto L16;
        m r104 = this.f229739c;
        if (r104.f229745f == true) goto L9;
    L13:
        r104.f229748i.g6(r104.h(r103));
        return;
    L9:
        if (r103.f571315f != SortAscType.TITLE) goto L11;
        boolean r105 = true;
    L12:
        r103.f571312c = r105;
        goto L13
    L11:
        r105 = false;
        goto L12
    L16:
        return;
    }
}
