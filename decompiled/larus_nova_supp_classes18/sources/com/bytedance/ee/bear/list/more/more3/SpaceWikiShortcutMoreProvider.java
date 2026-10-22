package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceWikiShortcutMoreProvider extends BaseMoreProvider {
    public final Document m;
    public final String n;
    public final SpaceMoreItemFactory o;

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        final boolean r0 = !t0.u(this.m, this.o.b);
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new SpaceWikiShortcutMoreProvider$buildMoreItems$1(this, r0));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        oj5.a r0 = t0.h(this.m, this.n, this.o.j);
        int r2 = t.a;
        BearUrl r3 = t.b(this.m);
        String r4 = this.m.c;
        Intrinsics.checkNotNull(r0);
        k(new wj5.l(r3, r4, r0));
    }

    public SpaceWikiShortcutMoreProvider(Document r2, String r3, SpaceMoreItemFactory r4) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.m = r2;
        this.n = r3;
        this.o = r4;
    }
}
