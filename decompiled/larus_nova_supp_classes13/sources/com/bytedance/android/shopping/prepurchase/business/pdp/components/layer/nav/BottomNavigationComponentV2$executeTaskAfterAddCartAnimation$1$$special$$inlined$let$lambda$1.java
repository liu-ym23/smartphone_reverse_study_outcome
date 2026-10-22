package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.prepurchase.business.pdp.util.BottomNavigationToaster;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/shopping/prepurchase/business/pdp/components/layer/nav/BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$1$1", f = "BottomNavigationComponentV2.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
public final class BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$$special$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1 this$0;

    public BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$$special$$inlined$let$lambda$1(Continuation r1, BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1 r2) {
        this.this$0 = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new BottomNavigationComponentV2$executeTaskAfterAddCartAnimation$1$$special$$inlined$let$lambda$1(r3, this.this$0);
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
        AddCartMeta r11 = BottomNavigationComponentV2.i2(this.this$0.a).i();
        if (r11 == null) goto L11;
        String r12 = r11.getAddCartPopupSchema();
    L12:
        this.label = 1;
        if (r3.b(r4, r12, 2000, this) != r0) goto L16;
        return r0;
    L11:
        r12 = null;
        goto L12
    }
}
