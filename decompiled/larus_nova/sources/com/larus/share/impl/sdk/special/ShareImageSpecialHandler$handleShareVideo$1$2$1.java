package com.larus.share.impl.sdk.special;

import android.os.Handler;
import android.os.Looper;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler$handleShareVideo$1$2$1", f = "ShareImageSpecialHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShareImageSpecialHandler$handleShareVideo$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WeakReference<l0> $weakRefDialog;
    int label;

    public ShareImageSpecialHandler$handleShareVideo$1$2$1(WeakReference<l0> r100, Continuation<? super ShareImageSpecialHandler$handleShareVideo$1$2$1> r101) {
        this.$weakRefDialog = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ShareImageSpecialHandler$handleShareVideo$1$2$1(this.$weakRefDialog, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ShareImageSpecialHandler$handleShareVideo$1$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_share_impl_sdk_special_ShareImageSpecialHandler$handleShareVideo$1$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        WeakReference<l0> r101 = this.$weakRefDialog;
        if (r101 == null) goto L9;
        l0 r102 = r101.get();
        if (r102 == null) goto L9;
        INVOKEVIRTUAL_com_larus_share_impl_sdk_special_ShareImageSpecialHandler$handleShareVideo$1$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r102);
        return Unit.INSTANCE;
    L9:
        return null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
