package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.api.mall.feed.d;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import vg3.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.GULSDKComponent$onAttach$1", f = "GULSDKComponent.kt", i = {}, l = {64, 65}, m = "invokeSuspend", n = {}, s = {})
public final class GULSDKComponent$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GULSDKComponent this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.GULSDKComponent$onAttach$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.GULSDKComponent$onAttach$1$1", f = "GULSDKComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
        int label;
        final /* synthetic */ GULSDKComponent$onAttach$1 this$0;

        public AnonymousClass1(GULSDKComponent$onAttach$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            GULSDKComponent r3 = this.this$0.this$0;
            int r0 = GULSDKComponent.t;
            FragmentActivity r4 = r3.O1().getContainerAbility().mo2525getContext();
            if (r4 == null) goto L8;
            GULShowManager.i.getClass();
            GULShowManager.a.b(r4);
        L8:
            return GULSDKComponent.h2(this.this$0.this$0);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public GULSDKComponent$onAttach$1(GULSDKComponent r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new GULSDKComponent$onAttach$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L22:
        final GULSDKComponent r2 = this.this$0;
        int r3 = GULSDKComponent.t;
        r2.getClass();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r2, "listenAndFetchData");
        final int[] r4 = new int[2];
        ((d0) r12).p0(new GULSDKComponent$listenAndFetchData$1(r2, r4));
        MultiRecyclerNestedScrollView r13 = r2.m;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("parentNestScrollView");
    L26:
        if (r13.h() == true) goto L29;
        r2.k2();
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        GULSDKComponent r5 = (GULSDKComponent) this.L$0;
        ResultKt.throwOnFailure(r12);
    L16:
        r5.n = (d) r12;
        GULSDKComponent r14 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        j r15 = r14.e;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L19:
        r12 = r15.e(d0.class, this);
        if (r12 != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        GULSDKComponent r16 = this.this$0;
        int r6 = GULSDKComponent.t;
        r16.o = BuildersKt.async$default(r16.Q1(), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        r5 = this.this$0;
        Deferred<? extends d> r17 = r5.o;
        if (r17 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("componentLoadJob");
    L13:
        this.L$0 = r5;
        this.label = 1;
        r12 = r17.await(this);
        if (r12 != r0) goto L16;
        return r0;
    }
}
