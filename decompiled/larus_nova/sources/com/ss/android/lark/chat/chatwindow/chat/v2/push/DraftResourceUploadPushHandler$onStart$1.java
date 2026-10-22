package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.ss.android.lark.log.Log;
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

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.push.DraftResourceUploadPushHandler$onStart$1", f = "DraftResourceUploadPushHandler.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
final class DraftResourceUploadPushHandler$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ u this$0;

    public DraftResourceUploadPushHandler$onStart$1(u r100, Continuation<? super DraftResourceUploadPushHandler$onStart$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DraftResourceUploadPushHandler$onStart$1 r102 = new DraftResourceUploadPushHandler$onStart$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DraftResourceUploadPushHandler$onStart$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r102 = (CoroutineScope) this.L$0;
        u r103 = this.this$0;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        int r105 = u.f414665a;     // Catch: Throwable -> L17
        r103.getClass();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L5:
        if (r101 != 1) goto L13;
        com.larksuite.rucket.job.extension.a r106 = (com.larksuite.rucket.job.extension.a) this.L$1;
        u r107 = (u) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L17
        if (((Boolean) r100).booleanValue() == true) goto L10;
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L23;
        Log.e("DraftResourceUploadPushHandler", "listen PUSH_UPLOAD_RESOURCE_STATUS failed", r109);
    L23:
        return Unit.INSTANCE;
    L10:
        com.larksuite.rucket.job.base.b r110 = r106.a();     // Catch: Throwable -> L17
        int r111 = u.f414665a;     // Catch: Throwable -> L17
        r107.getClass();     // Catch: Throwable -> L17
        PushUploadResourceStatus r112 = (PushUploadResourceStatus) r110.b();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
