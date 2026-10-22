package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.core.widget.NestedScrollView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.shopping.anchorv3.AnchorV3GridLayoutManager;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/e;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/shopping/prepurchase/business/pdp/components/layer/product/ProductDetailInfoComponent$initView$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoComponent$initView$2$1", f = "ProductDetailInfoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProductDetailInfoComponent$initView$$inlined$let$lambda$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.e, Continuation<? super Unit>, Object> {
    final /* synthetic */ FixedRecyclerView $recycleView;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductDetailInfoComponent this$0;

    public ProductDetailInfoComponent$initView$$inlined$let$lambda$1(FixedRecyclerView r1, Continuation r2, ProductDetailInfoComponent r3) {
        this.$recycleView = r1;
        this.this$0 = r3;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r3, vg3.e r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        ProductDetailInfoComponent$initView$$inlined$let$lambda$1 r6 = new ProductDetailInfoComponent$initView$$inlined$let$lambda$1(this.$recycleView, r5, this.this$0);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.e) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        final vg3.e r6 = (vg3.e) this.L$0;
        final ProductDetailInfoComponent r0 = this.this$0;
        final FixedRecyclerView r1 = this.$recycleView;
        d r2 = r0.p;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mainFeedInitializer");
    L7:
        ((AnchorV3GridLayoutManager) r2.e.getValue()).setItemPrefetchEnabled(false);
        r1.setClipToPadding(true);
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).a.getNativeParams().getFullMode() == false) goto L10;
    L15:
        r0.O1().b().e1(new w(r0, r6));
    L17:
        return Unit.INSTANCE;
    L10:
        if (PdpPerfOpt.a().b() == false) goto L15;
        NestedScrollView r3 = r0.n;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L14:
        final x r4 = new x(r0, r6, r3.getPaddingBottom());
        r1.getViewTreeObserver().addOnGlobalLayoutListener(r4);
        r0.v = new ProductDetailInfoComponent$updateRecyclerViewVisibleArea$1(r0, r1, r4, r6);
        r0.O1().b().e1(new v(r0));
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
