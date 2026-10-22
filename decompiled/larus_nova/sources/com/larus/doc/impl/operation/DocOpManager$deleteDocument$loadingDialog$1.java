package com.larus.doc.impl.operation;

import android.content.Context;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$deleteDocument$loadingDialog$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocOpManager$deleteDocument$loadingDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l0>, Object> {
    final /* synthetic */ Context $context;
    int label;

    public DocOpManager$deleteDocument$loadingDialog$1(Context r100, Continuation<? super DocOpManager$deleteDocument$loadingDialog$1> r101) {
        this.$context = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocOpManager$deleteDocument$loadingDialog$1(this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super l0> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super l0> r101) {
        return ((DocOpManager$deleteDocument$loadingDialog$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$deleteDocument$loadingDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        l0 r101 = new l0(this.$context, 0.0f, false, 6);
        INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$deleteDocument$loadingDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r101);
        return r101;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
