package com.bytedance.ee.bear.container;

import com.bytedance.ee.bear.document.b4;
import com.bytedance.ee.bear.document.v4;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == false) goto L9;
        yx4.a r0 = yx4.b.a;
        yx4.b.a(bk5.d.f.b, new i());
        yx4.b.a(bk5.d.a.b, new j());
        yx4.b.a(bk5.d.c.b, new k());
        yx4.b.a(bk5.d.g.b, new l());
        yx4.b.a(bk5.d.e.b, new m());
        yx4.b.a(bk5.d.h.b, new n());
        yx4.b.a(bk5.d.b.b, new o());
        yx4.b.a(bk5.d.d.b, new p());
        Map<sbb.e, v4> r1 = b4.a;
        b4.c(com.bytedance.ee.bear.document.render.node.n.f.b, new q());
        b4.c(com.bytedance.ee.bear.document.render.node.n.C0099n.b, new s());
        b4.c(com.bytedance.ee.bear.document.render.node.n.l.b, new t());
        b4.b(sbb.e.o, new tn4.a());
        b4.b(sbb.e.h, new un4.a());
        b4.b(sbb.e.i, new com.bytedance.ee.bear.basesdk.config.strategy.base.bitable.e());
        b4.b(sbb.e.j, new com.bytedance.ee.bear.basesdk.config.strategy.base.bitable.e());
        b4.b(sbb.e.m, new vn4.a());
        if (com.bytedance.ee.bear.bitable.chameleon.h.a.compareAndSet(false, true) == false) goto L7;
        tt5.a.h("BitableSdkInit", "register Bitable Chameleon render nodes");
        b4.c(com.bytedance.ee.bear.document.render.node.n.a.b, new com.bytedance.ee.bear.bitable.chameleon.d());
        b4.c(com.bytedance.ee.bear.document.render.node.n.b.b, new com.bytedance.ee.bear.bitable.chameleon.e());
        b4.c(com.bytedance.ee.bear.document.render.node.n.d.b, new com.bytedance.ee.bear.bitable.chameleon.f());
        b4.c(com.bytedance.ee.bear.document.render.node.n.c.b, new com.bytedance.ee.bear.bitable.chameleon.g());
        tt5.a.h("BitableSdkInit", "Bitable Chameleon render nodes registered");
        return;
    L7:
        tt5.a.h("BitableSdkInit", "skip Bitable Chameleon render node registration, already initialized");
        return;
    }
}
