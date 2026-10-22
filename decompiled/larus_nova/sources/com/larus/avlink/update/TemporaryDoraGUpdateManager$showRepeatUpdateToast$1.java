package com.larus.avlink.update;

import android.app.Activity;
import android.widget.Toast;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.update.TemporaryDoraGUpdateManager$showRepeatUpdateToast$1", f = "TemporaryDoraGUpdateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemporaryDoraGUpdateManager$showRepeatUpdateToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public TemporaryDoraGUpdateManager$showRepeatUpdateToast$1(Continuation<? super TemporaryDoraGUpdateManager$showRepeatUpdateToast$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TemporaryDoraGUpdateManager$showRepeatUpdateToast$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TemporaryDoraGUpdateManager$showRepeatUpdateToast$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L12;
        if (r101.isFinishing() == true) goto L12;
        Toast.makeText(r101, r101.getResources().getString(R.string.larus_update_popup_downloading), 1).show();
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
