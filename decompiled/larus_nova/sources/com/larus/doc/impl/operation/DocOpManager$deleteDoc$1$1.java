package com.larus.doc.impl.operation;

import android.content.Context;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
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
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$deleteDoc$1$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocOpManager$deleteDoc$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $hasPermission;
    final /* synthetic */ Function0<Unit> $showDialog;
    int label;

    public DocOpManager$deleteDoc$1$1(boolean r100, Function0<Unit> r101, Context r102, Continuation<? super DocOpManager$deleteDoc$1$1> r103) {
        this.$hasPermission = r100;
        this.$showDialog = r101;
        this.$context = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocOpManager$deleteDoc$1$1(this.$hasPermission, this.$showDialog, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DocOpManager$deleteDoc$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        if (this.$hasPermission == false) goto L11;
        FLogger.f375446a.i("DocOpManager", "delete document has permission");
        this.$showDialog.invoke();     // Catch: Exception -> L9
    L13:
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        FLogger.f375446a.e("DocOpManager", "delete document error: " + e);
        goto L13
    L11:
        s r101 = s.f544207a;
        Context r102 = this.$context;
        r101.getClass();
        s.s(r102, R.string.larus_doc_tooltip_disable_noPermit);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
