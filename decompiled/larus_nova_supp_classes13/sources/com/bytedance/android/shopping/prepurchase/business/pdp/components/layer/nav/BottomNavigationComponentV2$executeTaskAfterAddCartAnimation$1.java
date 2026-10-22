package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.anchorv4.dto.elements.ToastElement;
import com.bytedance.android.shopping.prepurchase.business.pdp.util.BottomNavigationToaster;
import com.larus.apm.impl.protector.RunnableProtector;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1 implements Runnable {
    public final /* synthetic */ BottomNavigationComponentV2 a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$2", f = "BottomNavigationComponentV2.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AddCartMeta $addCartMeta;
        int label;
        final /* synthetic */ BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1 this$0;

        public AnonymousClass2(BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1 r1, AddCartMeta r2, Continuation r3) {
            this.this$0 = r1;
            this.$addCartMeta = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass2(this.this$0, this.$addCartMeta, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            BottomNavigationToaster r3 = (BottomNavigationToaster) this.this$0.a.p.getValue();
            boolean r4 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.this$0.a.O1())).a.getNativeParams().getFullMode();
            AddCartMeta r11 = this.$addCartMeta;
            if (r11 == null) goto L11;
            String r12 = r11.getAddCartPopupSchema();
        L12:
            this.label = 1;
            if (r3.b(r4, r12, 0, this) != r0) goto L16;
            return r0;
        L11:
            r12 = null;
            goto L12
        }
    }

    public BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1(BottomNavigationComponentV2 r1) {
        this.a = r1;
    }

    public final void a() {
        AddCartMeta r0 = BottomNavigationComponentV2.i2(this.a).i();
        if (r0 != null) goto L5;
    L9:
        BuildersKt.launch$default(this.a.Q1(), null, null, new AnonymousClass2(this, r0, null), 3, null);
        return;
    L5:
        if (r0.getAddCartAnimationStyle() != 1) goto L9;
        ToastElement r1 = r0.getAddCartToast();
        if (r1 == null) goto L11;
        BottomNavigationComponentV2 r2 = this.a;
        BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$$special$$inlined$let$lambda$1 r3 = new BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$$special$$inlined$let$lambda$1(null, this);
        BuildersKt.launch$default(r2.Q1(), Dispatchers.getMain().getImmediate(), null, new BottomNavigationComponentV2$showAddCartToast$1(r2, r1, r3, null), 2, null);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
