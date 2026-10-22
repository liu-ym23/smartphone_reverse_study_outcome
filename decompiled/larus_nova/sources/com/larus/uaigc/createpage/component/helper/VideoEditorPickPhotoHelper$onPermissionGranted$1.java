package com.larus.uaigc.createpage.component.helper;

import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.helper.VideoEditorPickPhotoHelper$onPermissionGranted$1", f = "VideoEditorPickPhotoHelper.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
final class VideoEditorPickPhotoHelper$onPermissionGranted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ f this$0;

    public VideoEditorPickPhotoHelper$onPermissionGranted$1(f r100, Continuation<? super VideoEditorPickPhotoHelper$onPermissionGranted$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VideoEditorPickPhotoHelper$onPermissionGranted$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VideoEditorPickPhotoHelper$onPermissionGranted$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L21;
        r104.printStackTrace();
        g.f365738a.ensureNotReachHere(r104);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        f r105 = this.this$0;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        FLogger.f375446a.i("VideoEditorPickPhotoHelper", "onPermissionGranted emit");     // Catch: Throwable -> L15
        MutableSharedFlow<b> r107 = r105.f371590g;     // Catch: Throwable -> L15
        b r108 = new b(0);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r107.emit(r108, this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
