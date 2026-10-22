package com.bytedance.android.shopping.prepurchase.business.pdp.services.event;

import android.util.Log;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4FissionBackFlowReq;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.api.anchorv3.ECShareFission;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.l;
import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.j0;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService$onAttach$1", f = "ProductDetailEventService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProductDetailEventService$onAttach$1 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProductDetailEventService this$0;

    public static final class a<T> implements g {
        public final /* synthetic */ ProductDetailEventService$onAttach$1 a;

        public a(ProductDetailEventService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if (r4.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            ProductDetailEventService r1 = this.a.this$0;
            int r2 = ProductDetailEventService.u;
            r1.c2("ecom_log_id", r4);
            return;
        L9:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class b implements j0 {
        public final /* synthetic */ ProductDetailEventService$onAttach$1 a;

        public b(ProductDetailEventService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // vg3.j0
        public final void a(l<n> r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            ProductDetailEventService.b2(this.a.this$0, r3);     // Catch: Throwable -> L5
            Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L13;
            com.bytedance.android.shopping.prepurchase.arch.container.component.b.b(this.a.this$0, Log.getStackTraceString(r5), null);
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class c<T> implements g {
        public final /* synthetic */ ProductDetailEventService$onAttach$1 a;

        public c(ProductDetailEventService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            List r5 = (List) r4;
            if (r5 == null) goto L17;
            Iterator<T> r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L25;
            AnchorV4HeadV2VO r0 = (com.bytedance.android.ecom.arch.slice.adapter.b) r6.next();
            if ((r0 instanceof AnchorV4HeadVO) == true) goto L6;
            if ((r0 instanceof AnchorV4HeadV2VO) == false) goto L6;
            ProductDetailEventService r1 = this.a.this$0;
            boolean r2 = true;
            if (r0.getSizeType() == 1) goto L16;
            r2 = false;
        L16:
            r1.q = r2;
            goto L6
        L25:
            return;
        }
    }

    public static final class d<T> implements g {
        public final /* synthetic */ ProductDetailEventService$onAttach$1 a;

        public d(ProductDetailEventService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            k r5 = (k) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            if ((r5 instanceof k.d.a) == false) goto L5;
        L10:
            ProductDetailEventService r6 = this.a.this$0;
            int r0 = ProductDetailEventService.u;
            ECShareFission r1 = r6.a2().getNativeParams().getShareFission();
            String r7 = r6.a2().getSessionId();
            String r2 = null;
            if (r1 == null) goto L13;
            String r3 = r1.getShareScene();
        L14:
            if (r1 == null) goto L16;
            r2 = r1.getSecActivityInfo();
        L16:
            if (r7 == null) goto L25;
            if (r3 == null) goto L26;
            if (r2 != null) goto L20;
            return;
        L20:
            if (Intrinsics.areEqual(r3, "product_detail_fission") == false) goto L28;
            com.bytedance.android.shopping.anchorv4.data.k r8 = AnchorV4DataManager.a;
            AnchorV4DataManager.p(new AnchorV4FissionBackFlowReq(r3, r2), r7);
            return;
        L28:
            return;
        L26:
            return;
        L25:
            return;
        L13:
            r3 = null;
            goto L14
        L5:
            if ((r5 instanceof k.d.c) == true) goto L10;
            if ((r5 instanceof k.d.b) == true) goto L9;
            return;
        L9:
            if (((k.d.b) r5).b == 0) goto L10;
        }
    }

    public ProductDetailEventService$onAttach$1(ProductDetailEventService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        ProductDetailEventService$onAttach$1 r5 = new ProductDetailEventService$onAttach$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        x r5 = (x) this.L$0;
        e.a.a(r5.getData().e(), this.this$0, new a(this));
        r5.o0(new b(this));
        e.a.a(r5.getData().b(), this.this$0, new c(this));
        e.a.a(r5.q0(), this.this$0, new d(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
