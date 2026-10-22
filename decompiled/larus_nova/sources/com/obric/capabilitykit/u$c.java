package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.os.Process;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
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
import wia.y;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$2", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u$c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f396320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AssetFileDescriptor f396321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f396322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f396323d;

    public u$c(AssetFileDescriptor r100, y r101, int r102, Continuation<? super u$c> r103) {
        this.f396321b = r100;
        this.f396322c = r101;
        this.f396323d = r102;
        super(2, r103);
    }

    public final Object a(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((u$c) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new u$c(this.f396321b, this.f396322c, this.f396323d, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return a(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f396320a != 0) goto L27;
        ResultKt.throwOnFailure(r100);
        Logger.INSTANCE.i("UriFileOpener", "returning & closing opened fd/" + this.f396321b.hashCode() + " to the receiver: " + this.f396322c.f559912c + " ---> URI " + this.f396322c.f559910a);
        this.f396322c.f559911b.onSessionReady(new UriFileAccessSession(0, "成功", this.f396321b));     // Catch: Throwable -> L7
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L12;
        Logger.INSTANCE.e("UriFileOpener", "cannot notify opened fd to the receiver; e=" + r102, r102);
    L12:
        int r103 = this.f396323d;
        AssetFileDescriptor r104 = this.f396321b;
        y r105 = this.f396322c;
        int r106 = Process.myPid();     // Catch: Throwable -> L19
        if (r103 != r106) goto L16;
        Logger r107 = Logger.INSTANCE;     // Catch: Throwable -> L19
        String r108 = "not closing fd because the sharer/receiver are with the same PID (" + r103 + ").";     // Catch: Throwable -> L19
    L17:
        r107.d("UriFileOpener", r108);     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        AssetFileDescriptor r110 = this.f396321b;
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L25;
        Logger.INSTANCE.e("UriFileOpener", "cannot close opened fd/" + r110.hashCode() + "; e=" + r111, r111);
    L25:
        return Unit.INSTANCE;
    L16:
        r104.close();     // Catch: Throwable -> L19
        Logger r112 = Logger.INSTANCE;     // Catch: Throwable -> L19
        r108 = "sharer closed the shared fd/" + r104.hashCode() + " for URI: " + r105.f559910a + "; rcvPid=" + r103 + "; myPid=" + r106 + '.';     // Catch: Throwable -> L19
        r107 = r112;
    L19:
        th = move-exception;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
