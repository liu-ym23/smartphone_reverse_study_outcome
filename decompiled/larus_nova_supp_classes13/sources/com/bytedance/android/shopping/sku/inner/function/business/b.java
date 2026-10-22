package com.bytedance.android.shopping.sku.inner.function.business;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataStatusController;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.platform.o;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.a {
    public final String a;
    public final com.bytedance.android.shopping.sku.inner.container.b b;

    public b(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
        this.a = "sku_header_image";
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfAddToCart", "selfAddToCart");
        Context r2 = this.b.context();
        if (r2 != null) goto L6;
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r11.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "localContext_is_null", null, null, 57));
        return;
    L6:
        Map r0 = r10.q();
        if (r0 != null) goto L9;
        r0 = MapsKt.emptyMap();
    L9:
        Map r6 = r0;
        this.b.n20().c(SkuYataStatusController.StatusType.DOUBLE_BALL);
        AndroidYaTaInstance r1 = this.b.bV();
        if (r1 == null) goto L15;
        com.bytedance.kmp.ec.yata.store.node.c r3 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r1.q(SkuYataAddToCartFunction$onExecuteAsync$slcRootViewNodeKey$1.INSTANCE));
        if (r3 == null) goto L15;
        String r4 = r3.getKey();
        if (r4 == null) goto L15;
    L16:
        AndroidYaTaInstance r5 = this.b.bV();
        View r7 = null;
        if (r5 == null) goto L19;
        View r8 = r5.K(r4);
    L21:
        if (this.b.Ul() == null) goto L31;
        if (r8 != null) goto L24;
    L29:
        float[] r9 = null;
    L30:
        float[] r13 = r9;
    L32:
        com.bytedance.android.shopping.sku.common.ability.c r14 = this.b.zJ();
        if (r14 == null) goto L39;
        o r15 = r10.d.b;
        if (r15 == null) goto L37;
        r7 = r15.a;
    L37:
        r14.j(r2, r7, this.b.tS(), this.b, r6, new a(this, r11), r13);
        return;
    L39:
        return;
    L24:
        if (this.b.Ul() == null) goto L26;
        View r16 = SlcRenderContext.f(r8, this.a);
    L27:
        if (r16 == null) goto L29;
        r9 = sh3.c.a(r16);
        goto L30
    L26:
        r16 = null;
        goto L27
    L31:
        r13 = null;
        goto L32
    L19:
        r8 = null;
    L15:
        r4 = "";
        goto L16
    }

    public static final void d(b r6, Integer r7, Throwable r8, Function1 r9) {
        r6.getClass();
        if (r8 == null) goto L5;
        boolean r10 = com.bytedance.kmp.ec.yata.common.utils.g.a(r8);
    L6:
        if (r10 == false) goto L12;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        StringBuilder r12 = new StringBuilder("ttnet_exception:");
        if (r8 == null) goto L10;
        String r13 = r8.getMessage();
    L11:
        r12.append(r13);
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, r12.toString(), r8, null, 49));
        return;
    L10:
        r13 = null;
        goto L11
    L12:
        if (r8 == null) goto L14;
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "biz_crash", r8, null, 49));
        return;
    L14:
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "st-" + r7, r8, null, 49));
        return;
    L5:
        r10 = false;
        goto L6
    }
}
