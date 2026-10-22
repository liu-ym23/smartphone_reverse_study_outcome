package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer;

import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
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
import vg3.f;
import vg3.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/f;", "ability", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.LoadingComponent$observeBottomOverlayInset$1", f = "LoadingComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LoadingComponent$observeBottomOverlayInset$1 extends SuspendLambda implements Function3<CoroutineScope, f, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LoadingComponent this$0;

    public static final class a<T> implements g {
        public final /* synthetic */ LoadingComponent$observeBottomOverlayInset$1 a;

        public a(LoadingComponent$observeBottomOverlayInset$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            l0 r4 = (l0) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.this$0.w.b(r4.a, r4.b);
        }
    }

    public LoadingComponent$observeBottomOverlayInset$1(LoadingComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, f r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "ability");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        LoadingComponent$observeBottomOverlayInset$1 r5 = new LoadingComponent$observeBottomOverlayInset$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (f) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        e.a.a(((f) this.L$0).Y(), this.this$0, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
