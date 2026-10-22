package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import zd5.q;
import zd5.r;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f229691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f229692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SortAdapter f229693e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SortAdapter r101 = this.f229693e;
        if (r101.f229646d == true) goto L5;
    L8:
        r101.f229645c = this.f229691c;
        SortAdapter.a r102 = r101.f229647e;
        if (r102 == null) goto L13;
        q r103 = this.f229692d;
        m r104 = ((r) r102).f571316a;
        b.a r105 = r104.f229748i;
        if (r105 == null) goto L13;
        r105.g6(r104.h(r103));
    L13:
        this.f229693e.notifyDataSetChanged();
        return;
    L5:
        if (r101.f229645c != this.f229691c) goto L7;
        q r106 = this.f229692d;
        r106.f571312c = !r106.f571312c;
        goto L8
    L7:
        this.f229692d.f571312c = false;
        goto L8
    }

    public c(SortAdapter r100, int r101, q r102) {
        this.f229693e = r100;
        this.f229691c = r101;
        this.f229692d = r102;
    }
}
