package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.WideNavigationRailKt$ModalWideNavigationRailContent$4$1", f = "WideNavigationRail.kt", i = {}, l = {1042}, m = "invokeSuspend", n = {}, s = {})
public final class WideNavigationRailKt$ModalWideNavigationRailContent$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Float, Continuation<? super Unit>, Object> $settleToDismiss;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public WideNavigationRailKt$ModalWideNavigationRailContent$4$1(Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super WideNavigationRailKt$ModalWideNavigationRailContent$4$1> r2) {
        this.$settleToDismiss = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((CoroutineScope) r1, ((Number) r2).floatValue(), (Continuation) r3);
    }

    public final Object invoke(CoroutineScope r2, float r3, Continuation<? super Unit> r4) {
        WideNavigationRailKt$ModalWideNavigationRailContent$4$1 r5 = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(this.$settleToDismiss, r4);
        r5.F$0 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        float r5 = this.F$0;
        Function2<Float, Continuation<? super Unit>, Object> r2 = this.$settleToDismiss;
        Float r6 = Boxing.boxFloat(r5);
        this.label = 1;
        if (r2.invoke(r6, this) != r0) goto L12;
        return r0;
    }
}
