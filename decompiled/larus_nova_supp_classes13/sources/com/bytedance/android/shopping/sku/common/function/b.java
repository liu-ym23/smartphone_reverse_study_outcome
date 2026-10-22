package com.bytedance.android.shopping.sku.common.function;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.buynow.utils.q;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.platform.o;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public static final class a {
    }

    static {
    }

    public b(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r11) {
        Intrinsics.checkNotNullParameter(r11, "input");
        ll3.a.a("selfTransformLocation", "SelfTransformLocation starts");
        Map r0 = r11.q();
        if (r0 == null) goto L5;
        Object r2 = r0.get("match_vo");
    L7:
        if ((r2 instanceof Map) == true) goto L9;
        r2 = null;
    L9:
        final Map r3 = (Map) r2;
        if (r0 == null) goto L12;
        Object r4 = r0.get("slice_key");
    L14:
        if ((r4 instanceof String) == true) goto L16;
        r4 = null;
    L16:
        String r5 = (String) r4;
        if (r0 == null) goto L19;
        Object r1 = r0.get("ignore_null");
    L21:
        if ((r1 instanceof Boolean) == true) goto L23;
        r1 = null;
    L23:
        boolean r6 = Intrinsics.areEqual((Boolean) r1, Boolean.TRUE);
        boolean r7 = true;
        if (r3 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L48;
        AndroidYaTaInstance r12 = this.a.bV();
        if (r12 == null) goto L36;
        c r13 = (c) CollectionsKt.firstOrNull(r12.q(new SkuSelfTransformLocation$findSliceView$targetNodeKey$1(r3)));
        if (r13 == null) goto L36;
        String r14 = r13.getKey();
    L37:
        if (r14 != null) goto L39;
    L42:
        boolean r9 = true;
    L43:
        if (r9 == true) goto L51;
        AndroidYaTaInstance r10 = this.a.bV();
        if (r10 == null) goto L51;
        View r15 = r10.K(r14);
    L52:
        if (r15 == null) goto L58;
        if (r5 == null) goto L58;
        if (this.a.Ul() == null) goto L57;
        r15 = SlcRenderContext.f(r15, r5);
        goto L58
    L57:
        r15 = null;
    L58:
        if (r15 == null) goto L60;
        View r16 = this.a.i();
        com.bytedance.android.ecom.arch.slice.render.context.b r17 = this.a.d8();
        Map r18 = MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r15.getWidth()), r17))), TuplesKt.to("height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r15.getHeight()), r17))), TuplesKt.to("top", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(q.b(r15, r16)), r17))), TuplesKt.to("left", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(q.a(r15, r16)), r17)))});
    L61:
        if (r6 == true) goto L71;
        if (r18 != null) goto L64;
    L67:
        if (r7 == false) goto L71;
        int r19 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "boundingRect is empty", null, null, 57);
    L64:
        if (r18.isEmpty() == true) goto L67;
        r7 = false;
    L71:
        int r20 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("boundingRect", r18)), null, 5);
    L60:
        r18 = null;
    L51:
        r15 = null;
        goto L52
    L39:
        if (r14.length() == 0) goto L42;
        r9 = false;
    L36:
        r14 = null;
        goto L37
    L48:
        o r110 = r11.d.b;
        if (r110 == null) goto L51;
        r15 = r110.a;
        goto L52
    L26:
        if (r3.isEmpty() == true) goto L29;
        r8 = false;
        goto L30
    L19:
        r1 = null;
        goto L21
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
