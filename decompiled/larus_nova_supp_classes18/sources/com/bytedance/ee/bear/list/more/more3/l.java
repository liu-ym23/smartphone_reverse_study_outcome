package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.MoreGroup;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends BaseMoreProvider {
    public final Document m;
    public final String n;
    public final SpaceMoreItemFactory o;
    public final com.bytedance.ee.bear.more.protocol3.panel.e p;

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        this.p.d("more.share", new c(this));
        this.p.d("more.move_to", new d(this));
        this.p.d("more.pin", new e(this));
        this.p.d("more.star", new f(this));
        this.p.d("more.secret_level", new g(this));
        this.p.d("more.retention_label", new h(this));
        this.p.d("more.copy_link", new i(this));
        this.p.d("more.transfer_ownership", j.a);
        this.p.d("more.delete", new k(this));
        b r0 = new b(this.o.k, this, this.p);
        int r1 = com.bytedance.ee.bear.more.protocol3.panel.v.a;
        com.bytedance.ee.bear.more.protocol3.panel.e r2 = this.p;
        com.bytedance.ee.bear.more.protocol3.panel.l r3 = new com.bytedance.ee.bear.more.protocol3.panel.l();
        ItemUIStyle r4 = ItemUIStyle.FEISHU;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.a = r4;
        r3.a(MoreGroup.TOP, new MiaodaMoreProvider$buildPanelConfig$1$1(this));
        r3.a(MoreGroup.NORMAL, MiaodaMoreProvider$buildPanelConfig$1$2.INSTANCE);
        r3.a(MoreGroup.DANGER, MiaodaMoreProvider$buildPanelConfig$1$3.INSTANCE);
        return com.bytedance.ee.bear.more.protocol3.panel.v.d(this, r2, r0, new com.bytedance.ee.bear.more.protocol3.panel.w(r3.a, CollectionsKt.toList(r3.b)));
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

    public l(Document r2, String r3, SpaceMoreItemFactory r4) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = new com.bytedance.ee.bear.more.protocol3.panel.e();
    }
}
