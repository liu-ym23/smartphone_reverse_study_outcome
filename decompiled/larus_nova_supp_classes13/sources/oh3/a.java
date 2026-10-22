package oh3;

import com.bytedance.android.shopping.sku.inner.container.b;
import com.bytedance.android.shopping.sku.inner.function.base.c;
import com.bytedance.android.shopping.sku.inner.function.base.d;
import com.bytedance.android.shopping.sku.inner.function.base.e;
import com.bytedance.android.shopping.sku.inner.function.base.f;
import com.bytedance.android.shopping.sku.inner.function.base.h;
import com.bytedance.android.shopping.sku.inner.function.base.i;
import com.bytedance.android.shopping.sku.inner.function.base.j;
import com.bytedance.android.shopping.sku.inner.function.base.k;
import com.bytedance.android.shopping.sku.inner.function.base.l;
import com.bytedance.android.shopping.sku.inner.function.base.m;
import com.bytedance.android.shopping.sku.inner.function.base.n;
import com.bytedance.android.shopping.sku.inner.function.base.o;
import com.bytedance.android.shopping.sku.inner.function.base.p;
import com.bytedance.android.shopping.sku.inner.function.base.q;
import com.bytedance.android.shopping.sku.inner.function.base.r;
import com.bytedance.android.shopping.sku.inner.function.business.g;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public a() {
    }

    public static void a(b r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Iterator r0 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("selfToast", new n(r4)), TuplesKt.to("selfQuitSkuPage", new j(r4)), TuplesKt.to("selfCalCurSkuIdToUpdate", new c(r4)), TuplesKt.to("selfPreviewImg", new i(r4)), TuplesKt.to("selfScrollToView", new l(r4)), TuplesKt.to("selfDelay", new d(r4)), TuplesKt.to("selfHandleEventWhenAppear", new f(r4)), TuplesKt.to("selfAutoApplyCoupon", new com.bytedance.android.shopping.sku.inner.function.base.b(r4)), TuplesKt.to("selfAddCurVersion", new com.bytedance.android.shopping.sku.inner.function.base.a(r4)), TuplesKt.to("selfUpdateStatusInfo", new r(r4)), TuplesKt.to("selfSaveSpecShowMode", new k(r4)), TuplesKt.to("selfSaveBizFields", new com.bytedance.android.shopping.sku.inner.function.business.j(r4)), TuplesKt.to("selfAppendParamsToSchema", new com.bytedance.android.shopping.sku.inner.function.business.c(r4)), TuplesKt.to("selfClickLoadingButton", new g(r4)), TuplesKt.to("selfCancelStashedClickEvent", new com.bytedance.android.shopping.sku.inner.function.business.d(r4)), TuplesKt.to("selfOpenSkuSchema", new com.bytedance.android.shopping.sku.inner.function.base.g(r4)), TuplesKt.to("selfUpdateCommonEventParams", new o(r4)), TuplesKt.to("selfPollQueueEvents", new h(r4)), TuplesKt.to("selfUpdateLocalCommonEventParams", new p(r4)), TuplesKt.to("selfUpdateSkipTriggers", new q(r4)), TuplesKt.to("selfDoNothing", new e()), TuplesKt.to("selfSendJsEvent", new com.bytedance.android.shopping.sku.inner.function.business.k()), TuplesKt.to("selfTransformLocation", new com.bytedance.android.shopping.sku.common.function.b(r4)), TuplesKt.to("selfPublishEvent", new m()), TuplesKt.to("selfOpenDetail", new com.bytedance.android.shopping.sku.inner.function.business.i(r4)), TuplesKt.to("selfOpenCoupon", new com.bytedance.android.shopping.sku.inner.function.business.h(r4)), TuplesKt.to("selfClickBuyNowButton", new com.bytedance.android.shopping.sku.inner.function.business.e(r4)), TuplesKt.to("selfClickConfirmButton", new com.bytedance.android.shopping.sku.inner.function.business.f(r4)), TuplesKt.to("selfAddToCart", new com.bytedance.android.shopping.sku.inner.function.business.b(r4))}).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Pair r1 = (Pair) r0.next();
        AndroidYaTaInstance r2 = r4.bV();
        if (r2 == null) goto L4;
        r2.B((String) r1.getFirst(), (com.bytedance.kmp.ec.yata.event.common.d) r1.getSecond());
        goto L4
    }
}
