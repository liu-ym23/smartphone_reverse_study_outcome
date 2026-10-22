package com.larus.doc.impl.operation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$validatePermissionWithObjType$1$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocOpManager$validatePermissionWithObjType$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasPermission;
    final /* synthetic */ Function0<Unit> $onDenied;
    final /* synthetic */ Function0<Unit> $onGranted;
    int label;

    public DocOpManager$validatePermissionWithObjType$1$1(boolean r100, Function0<Unit> r101, Function0<Unit> r102, Continuation<? super DocOpManager$validatePermissionWithObjType$1$1> r103) {
        this.$hasPermission = r100;
        this.$onGranted = r101;
        this.$onDenied = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocOpManager$validatePermissionWithObjType$1$1(this.$hasPermission, this.$onGranted, this.$onDenied, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DocOpManager$validatePermissionWithObjType$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (this.$hasPermission == false) goto L7;
        this.$onGranted.invoke();
    L9:
        return Unit.INSTANCE;
    L7:
        this.$onDenied.invoke();
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
