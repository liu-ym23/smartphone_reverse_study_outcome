package com.bytedance.android.shopping.sku.inner.function.business;

import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.sku.common.ability.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ Function1 b;

    @Override // com.bytedance.android.shopping.sku.common.ability.a
    public final void a() {
    }

    public a(b r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.a
    public final void b(th3.c r4, Throwable r5) {
        Integer r0 = null;
        if (r5 != null) goto L8;
        if (r4 == null) goto L8;
        if (r4.a != 0) goto L8;
        this.a.b.n20().b("加购成功");
        Function1 r6 = this.b;
        int r7 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r6.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L8:
        this.a.b.n20().b("加购失败");
        b r1 = this.a;
        if (r4 == null) goto L11;
        r0 = Integer.valueOf(r4.a);
    L11:
        b.d(r1, r0, r5, this.b);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.a
    public final void c(SkuOuterAddToCartResponse r4, Throwable r5) {
        Integer r0 = null;
        if (r5 != null) goto L8;
        if (r4 == null) goto L8;
        if (r4.getStatusCode() != 0) goto L8;
        this.a.b.n20().b("加购成功");
        Function1 r6 = this.b;
        int r7 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r6.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L8:
        this.a.b.n20().b("加购失败");
        b r1 = this.a;
        if (r4 == null) goto L11;
        r0 = Integer.valueOf(r4.getStatusCode());
    L11:
        b.d(r1, r0, r5, this.b);
    }
}
