package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
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
import vg3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/s;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.TopNavigationComponentV2$onAttach$8", f = "TopNavigationComponentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopNavigationComponentV2$onAttach$8 extends SuspendLambda implements Function3<CoroutineScope, s, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopNavigationComponentV2 this$0;

    public static final class a implements com.bytedance.android.shopping.prepurchase.arch.container.component.f {
        public final /* synthetic */ TopNavigationComponentV2$onAttach$8 a;
        public final /* synthetic */ s b;

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.f
        public final void a(com.bytedance.android.shopping.prepurchase.arch.container.ability.a r2) {
            Intrinsics.checkNotNullParameter(r2, "ability");
            if (Intrinsics.areEqual(r2, this.b) == true) goto L5;
            return;
        L5:
            if (this.a.this$0.e2().getVisibility() != 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == true) goto L12;
            ExtensionsKt.visible(this.a.this$0.e2());
            return;
        L12:
            return;
        L7:
            r3 = false;
            goto L8
        }

        public a(TopNavigationComponentV2$onAttach$8 r1, s r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2$onAttach$8 a;

        public b(TopNavigationComponentV2$onAttach$8 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L5;
            ExtensionsKt.gone(this.a.this$0.e2());
            return;
        L5:
            ExtensionsKt.visible(this.a.this$0.e2());
        }
    }

    public TopNavigationComponentV2$onAttach$8(TopNavigationComponentV2 r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, s r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        TopNavigationComponentV2$onAttach$8 r5 = new TopNavigationComponentV2$onAttach$8(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (s) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        s r5 = (s) this.L$0;
        TopNavigationComponentV2 r0 = this.this$0;
        a r1 = new a(this, r5);
        int r2 = TopNavigationComponentV2.A;
        r0.J1(r5, r1);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.a0(), this.this$0, new b(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
