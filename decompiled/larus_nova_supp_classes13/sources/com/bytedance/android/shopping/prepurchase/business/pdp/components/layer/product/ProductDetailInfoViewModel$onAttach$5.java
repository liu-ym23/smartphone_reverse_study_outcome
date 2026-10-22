package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/n;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoViewModel$onAttach$5", f = "ProductDetailInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProductDetailInfoViewModel$onAttach$5 extends SuspendLambda implements Function3<CoroutineScope, vg3.n, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.intf.j $networkAbility;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductDetailInfoViewModel this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ ProductDetailInfoViewModel$onAttach$5 a;

        public a(ProductDetailInfoViewModel$onAttach$5 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r13) {
            List r9 = (List) r13;
            Intrinsics.checkNotNullParameter(r9, "instantFeed");
            if (r9.isEmpty() == true) goto L17;
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k r14 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) this.a.$networkAbility.q0().a();
            if ((r14 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) == true) goto L8;
        L10:
            boolean r15 = false;
        L11:
            com.bytedance.android.shopping.anchorv4.vm.j r0 = this.a.this$0.f;
            if (r0 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.vm.j r1 = com.bytedance.android.shopping.anchorv4.vm.j.a(r0, r9);
        L15:
            ProductDetailInfoViewModel r2 = this.a.this$0;
            r2.f = r1;
            List<com.bytedance.android.ecom.arch.slice.adapter.b> r3 = ProductDetailInfoViewModel.g(r2, r1);
            this.a.this$0.g.g(r3);
            ProductDetailInfoViewModel r4 = this.a.this$0;
            r4.getContext().b().s1(new y(r4, r1, r15));
            return;
        L14:
            r1 = new com.bytedance.android.shopping.anchorv4.vm.j(null, null, null, null, null, null, null, null, r9, 255);
            goto L15
        L8:
            if ((r14 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.a) == false) goto L10;
            r15 = true;
            goto L11
        }
    }

    public ProductDetailInfoViewModel$onAttach$5(ProductDetailInfoViewModel r1, com.bytedance.android.shopping.prepurchase.arch.container.intf.j r2, Continuation r3) {
        this.this$0 = r1;
        this.$networkAbility = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, vg3.n r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        ProductDetailInfoViewModel$onAttach$5 r6 = new ProductDetailInfoViewModel$onAttach$5(this.this$0, this.$networkAbility, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.n) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((vg3.n) this.L$0).F1(), this.this$0.p, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
