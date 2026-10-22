package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f229704c;

    public e(h r100) {
        this.f229704c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        tt5.a.h("SortAndFilterView", "onClick reset()...");
        h r101 = this.f229704c;
        if (r101.f229709c == false) goto L5;
        FilterTypeAdapter r102 = r101.f229722p;
        r102.f229631c = r101.f229713g;
        r102.notifyDataSetChanged();
    L5:
        h r103 = this.f229704c;
        if (r103.f229710d == false) goto L8;
        ((q) ListProtector.get(r103.f229723q.f229683b, r103.f229714h)).f571312c = false;
        h r104 = this.f229704c;
        SortTypeAdapter r105 = r104.f229723q;
        r105.f229684c = r104.f229714h;
        r105.notifyDataSetChanged();
    L8:
        this.f229704c.s();
        h r106 = this.f229704c;
        a.InterfaceC3282a r107 = r106.f229724r;
        if (r107 == null) goto L11;
        r107.y2(r106.o());
    L11:
        h.k(this.f229704c, BasicTestActionHandler.TEST_ACTION_RESET);
        h.h(this.f229704c, BasicTestActionHandler.TEST_ACTION_RESET);
    }
}
