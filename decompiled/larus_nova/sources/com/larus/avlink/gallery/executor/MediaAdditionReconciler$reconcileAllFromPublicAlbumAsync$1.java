package com.larus.avlink.gallery.executor;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1", f = "MediaAdditionReconciler.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1(Continuation<? super MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L12;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7 CancellationException -> L9
    L21:
    L19:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r100);
        MediaAdditionReconciler r103 = MediaAdditionReconciler.f292495a;     // Catch: Exception -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
        if (MediaAdditionReconciler.b(r103, this) != r101) goto L21;
        return r101;
    L9:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        FLogger.f375446a.e("MediaAdditionReconciler", "Full reconcile failed: " + e.getMessage(), e);
        goto L19
    }
}
