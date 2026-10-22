package com.bytedance.android.shopping.prepurchase.arch.exposure;

import androidx.lifecycle.LifecycleCoroutineScope;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/shopping/prepurchase/arch/exposure/ExposureEngine$tryStartScheduler$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.arch.exposure.ExposureEngine$tryStartScheduler$1$1", f = "ExposureEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExposureEngine$tryStartScheduler$$inlined$also$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Scheduler $s;
    final /* synthetic */ LifecycleCoroutineScope $scope;
    int label;
    final /* synthetic */ ExposureEngine this$0;

    public ExposureEngine$tryStartScheduler$$inlined$also$lambda$1(Scheduler r1, LifecycleCoroutineScope r2, Continuation r3, ExposureEngine r4) {
        this.$s = r1;
        this.$scope = r2;
        this.this$0 = r4;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        return new ExposureEngine$tryStartScheduler$$inlined$also$lambda$1(this.$s, this.$scope, r5, this.this$0);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        Scheduler r8 = this.$s;
        LifecycleCoroutineScope r0 = this.$scope;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "scope");
        r8.c = true;
        r8.a = r0;
        if (r8.d == false) goto L7;
        BuildersKt.launch$default(r0, Dispatchers.getMain().getImmediate(), null, new Scheduler$start$1(r8, null), 2, null);
    L7:
        this.this$0.g.a.getLifecycle().addObserver(new AnonymousClass1(this));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
