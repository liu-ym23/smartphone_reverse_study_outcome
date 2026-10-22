package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.nav.controls.ShareBtnAnimController;
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
import vg3.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/d0;", "ability", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1$initData$1", f = "TopNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TopNavigationComponentV1$initData$1 extends SuspendLambda implements Function3<CoroutineScope, d0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopNavigationComponentV1 this$0;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV1$initData$1 a;

        public a(TopNavigationComponentV1$initData$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            int r5 = ((Number) r4).intValue();
            TopNavigationComponentV1 r0 = this.a.this$0;
            int r1 = TopNavigationComponentV1.y;
            r0.i2().d(r5);
            float r2 = r5;
            TopNavigationComponentV1 r3 = this.a.this$0;
            r3.getClass();
            vg3.l r6 = (vg3.l) r3.N1(vg3.l.class);
            if (r6 == null) goto L5;
            float r7 = r6.B1();
        L6:
            float r8 = r2 / r7;
            if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.this$0.O1())).b.a == false) goto L11;
            AnchorV4NavArea r9 = this.a.this$0.i2();
            if (r9 == null) goto L14;
            r9.e(1.0f);
        L14:
            AnchorV4TabArea r10 = this.a.this$0.k2();
            if (r10 == null) goto L21;
            r10.setAlpha(r8);
            if (r10.getAlpha() < 0.1f) goto L19;
            boolean r11 = true;
        L20:
            r10.h = r11;
            goto L21
        L19:
            r11 = false;
        L21:
            com.bytedance.android.shopping.anchorv4.nav.controls.c r12 = this.a.this$0.j2().b;
            if (r12 == null) goto L27;
            ShareBtnAnimController r13 = r12.a();
            if (r13 == null) goto L28;
            r13.f(r5);
            return;
        L28:
            return;
        L27:
            return;
        L11:
            AnchorV4NavArea r14 = this.a.this$0.i2();
            if (r14 == null) goto L14;
            r14.e(r8);
            goto L14
        L5:
            r7 = 0.0f;
            goto L6
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV1$initData$1 a;

        public b(TopNavigationComponentV1$initData$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            com.bytedance.android.ecom.arch.slice.adapter.b r4 = (com.bytedance.android.ecom.arch.slice.adapter.b) r3;
            if (r4 == null) goto L8;
            TopNavigationComponentV1 r0 = this.a.this$0;
            int r1 = TopNavigationComponentV1.y;
            AnchorV4TabArea r2 = r0.k2();
            if (r2 == null) goto L9;
            r2.setDockTab(r4);
            return;
        L9:
            return;
        }
    }

    public TopNavigationComponentV1$initData$1(TopNavigationComponentV1 r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, d0 r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "ability");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        TopNavigationComponentV1$initData$1 r5 = new TopNavigationComponentV1$initData$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (d0) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        d0 r5 = (d0) this.L$0;
        r5.X0(new AnonymousClass1(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.R(), this.this$0, new a(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r5.z0(), this.this$0, new b(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
