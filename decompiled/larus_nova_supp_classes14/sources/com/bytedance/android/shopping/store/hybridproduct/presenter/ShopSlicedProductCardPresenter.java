package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSlicedProductCardPresenter extends sm.l<com.bytedance.android.ec.store.repository.vo.l> {
    public String m;
    public e0 n;
    public final Lazy o;
    public final com.bytedance.android.ecom.arch.slice.render.r p;
    public final ECStoreViewModel q;

    public final void c0() {
        com.bytedance.android.ecom.arch.slice.render.r r0 = this.p;
        if (r0 == null) goto L7;
        SlcTemplateContext r1 = r0.b;
        if (r1 == null) goto L7;
        r1.u(this.m);
    L7:
        e0 r2 = this.n;
        if (r2 == null) goto L15;
        com.bytedance.android.ecom.arch.slice.render.r r3 = this.p;
        if (r3 == null) goto L16;
        View r4 = r3.c;
        if (r4 == null) goto L17;
        r4.removeOnLayoutChangeListener(r2);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void e0(StoreV2ProductItemVO r5) {
        final com.bytedance.android.ec.store.repository.vo.l r6 = (com.bytedance.android.ec.store.repository.vo.l) r5;
        if (r6 == null) goto L60;
        Map r0 = com.bytedance.android.ec.store.repository.vo.m.a(r6, this.q.getSliceService().a());
        com.bytedance.android.ecom.arch.slice.render.r r1 = this.p;
        if (r1 == null) goto L7;
        r1.b((ShopSlicedProductCardPresenter$slcActionHandler$2.a) this.o.getValue());
    L7:
        String r2 = ShopSliceUniqueId.SHOP_PRODUCT_CARD.getId() + "_{data.productId}_" + ((StoreV2ProductItemVO) r6).w;
        this.m = r2;
        com.bytedance.android.ecom.arch.slice.render.r r3 = this.p;
        if (r3 == null) goto L12;
        SlcTemplateContext r4 = r3.b;
        if (r4 == null) goto L12;
        r4.s(r2, new ShopSlicedProductCardPresenter$onElementBind$$inlined$let$lambda$1(r6, this));
    L12:
        com.bytedance.android.ecom.arch.slice.render.r r7 = this.p;
        if (r7 == null) goto L15;
        r7.a(r0, this.m);
    L15:
        e0 r8 = new e0(this);
        this.n = r8;
        com.bytedance.android.ecom.arch.slice.render.r r9 = this.p;
        com.bytedance.android.ec.store.repository.dto.o r10 = null;
        if (r9 == null) goto L18;
        View r11 = r9.c;
    L19:
        if (r11 == null) goto L29;
        r11.addOnLayoutChangeListener(r8);
        ((sm.l) this).f.b();
        sm.h r12 = ((sm.l) this).f;
        com.bytedance.android.ecom.arch.slice.render.r r13 = this.p;
        if (r13 == null) goto L27;
        SlcTemplateContext r14 = r13.b;
        if (r14 == null) goto L27;
        if (r14.w == null) goto L27;
        View r15 = SlcRenderContext.f(r11, ShopSliceKey.PRODUCT_COVER.getKey());
    L28:
        r12.i(r15);
    L30:
        sm.j r16 = ((sm.l) this).j;
        if (r16 == null) goto L33;
        r16.b(Reflection.getOrCreateKotlinClass(sm.k.class), new h0(this));
    L33:
        com.bytedance.android.ecom.arch.slice.render.r r17 = this.p;
        if (r17 == null) goto L38;
        View r18 = r17.c;
        if (r18 == null) goto L38;
        sm.h r19 = ((sm.l) this).f;
        SlcRenderContext r20 = r17.b.w;
        String r21 = ShopSliceKey.PRODUCT_COVER.getKey();
        r20.getClass();
        r19.i(SlcRenderContext.f(r18, r21));
    L39:
        com.bytedance.android.ec.store.repository.vo.l r22 = ((sm.l) this).k;
        if (r22 == null) goto L44;
        com.bytedance.android.ec.store.repository.vo.b r23 = ((StoreV2ProductItemVO) r22).x;
        if (r23 == null) goto L44;
        Boolean r24 = r23.d;
    L46:
        if (Intrinsics.areEqual(r24, Boolean.TRUE) == false) goto L48;
        sm.g r25 = ((sm.l) this).g;
        StoreV2ProductItemVO r26 = ((sm.l) this).k;
        Intrinsics.checkNotNull(r26);
        r25.c(r26);
    L48:
        com.bytedance.android.ec.store.repository.vo.l r27 = ((sm.l) this).k;
        com.bytedance.android.ec.store.repository.vo.l r28 = r27;
        if (r28 == null) goto L51;
        r10 = ((StoreV2ProductItemVO) r28).t;
    L51:
        if (r10 == null) goto L53;
        sm.g r29 = ((sm.l) this).g;
        Intrinsics.checkNotNull(r27);
        r29.h(r27);
    L53:
        sm.j r30 = ((sm.l) this).j;
        if (r30 == null) goto L56;
        r30.b(Reflection.getOrCreateKotlinClass(sm.n.class), new f0(this));
    L56:
        jm.a r31 = ((sm.l) this).f.q();
        if (r31 == null) goto L61;
        r31.a(Y().e(), new g0(this), false);
        return;
    L61:
        return;
    L44:
        r24 = null;
    L38:
        ((sm.l) this).f.i(null);
    L27:
        r15 = null;
        goto L28
    L29:
        ((sm.l) this).f.i(null);
        goto L30
    L18:
        r11 = null;
        goto L19
    }

    public ShopSlicedProductCardPresenter(Fragment r2, com.bytedance.android.ecom.arch.slice.render.r r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r2);
        this.p = r3;
        this.q = r4;
        this.m = "";
        this.o = LazyKt.lazy(new ShopSlicedProductCardPresenter$slcActionHandler$2(this));
    }
}
