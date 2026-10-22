package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.Choreographer;
import androidx.core.widget.NestedScrollView;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "ability", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoComponent$initView$4", f = "ProductDetailInfoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProductDetailInfoComponent$initView$4 extends SuspendLambda implements Function3<CoroutineScope, vg3.y, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductDetailInfoComponent this$0;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ ProductDetailInfoComponent$initView$4 c;
        public final /* synthetic */ vg3.y d;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoComponent$initView$4$a$a, reason: collision with other inner class name */
        public static final class ChoreographerFrameCallbackC0162a implements Choreographer.FrameCallback {
            public final /* synthetic */ a a;

            public ChoreographerFrameCallbackC0162a(a r1) {
                this.a = r1;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r3) {
                com.bytedance.android.shopping.anchorv4.perf.monitor.c r4 = this.a.d.V();
                if (r4 == null) goto L17;
                com.bytedance.android.shopping.anchorv4.perf.monitor.k r5 = r4.c;
                if (r5 == null) goto L18;
                ProductDetailInfoComponent r6 = this.a.c.this$0;
                NestedScrollView r0 = r6.n;
                if (r0 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
            L9:
                FixedRecyclerView r7 = r6.o;
                if (r7 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
            L12:
                int r1 = r0.getHeight() - r0.getPaddingBottom();
                if (r7.getChildCount() <= 0) goto L15;
                r1 = r1 - r7.getChildAt(r7.getChildCount() - 1).getBottom();
            L15:
                r5.f(r1);
                return;
            L18:
                return;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Choreographer.getInstance().postFrameCallback(new ChoreographerFrameCallbackC0162a(this));
        }

        public a(ProductDetailInfoComponent$initView$4 r1, vg3.y r2) {
            this.c = r1;
            this.d = r2;
            super("setup_MainBlankHeight");
        }
    }

    public ProductDetailInfoComponent$initView$4(ProductDetailInfoComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, vg3.y r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "ability");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        ProductDetailInfoComponent$initView$4 r5 = new ProductDetailInfoComponent$initView$4(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (vg3.y) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        vg3.y r3 = (vg3.y) this.L$0;
        r3.s1(new a(this, r3));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
