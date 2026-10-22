package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceWikiMoreProvider extends BaseMoreProvider {
    public final Document m;
    public final String n;
    public final SpaceMoreItemFactory o;
    public final String p;
    public final String q;

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        final boolean r0 = !t0.u(this.m, this.o.b);
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new SpaceWikiMoreProvider$buildMoreItems$1(this, r0));
    }

    public final boolean m() {
        oj5.a r0 = t0.h(this.m, this.n, this.o.j);
        if ((r0 instanceof oj5.f) == false) goto L10;
        oj5.d r1 = ((oj5.f) r0).H;
        if (r1 == null) goto L11;
        Boolean r2 = r1.b();
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.booleanValue();
    L11:
        return false;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        oj5.a r0 = t0.h(this.m, this.n, this.o.j);
        int r2 = t.a;
        BearUrl r3 = t.b(this.m);
        Intrinsics.checkNotNull(r0);
        k(new wj5.a(r3, r0));
    }

    public SpaceWikiMoreProvider(Document r2, String r3, SpaceMoreItemFactory r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
    }
}
