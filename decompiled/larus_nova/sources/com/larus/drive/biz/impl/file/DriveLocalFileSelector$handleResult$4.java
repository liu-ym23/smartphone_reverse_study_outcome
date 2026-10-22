package com.larus.drive.biz.impl.file;

import android.content.Context;
import android.net.Uri;
import com.larus.utils.logger.FLogger;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.file.DriveLocalFileSelector$handleResult$4", f = "DriveLocalFileSelector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DriveLocalFileSelector$handleResult$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ u $listener;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ List<Uri> $uris;
    int label;

    public DriveLocalFileSelector$handleResult$4(Context r100, List<Uri> r101, int r102, u r103, Continuation<? super DriveLocalFileSelector$handleResult$4> r104) {
        this.$context = r100;
        this.$uris = r101;
        this.$requestCode = r102;
        this.$listener = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DriveLocalFileSelector$handleResult$4(this.$context, this.$uris, this.$requestCode, this.$listener, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DriveLocalFileSelector$handleResult$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        DriveLocalFileSelector.a(DriveLocalFileSelector.f341191a, this.$context, this.$uris, this.$requestCode, this.$listener);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        FLogger.f375446a.e("DriveLocalFileSelector", "handleResultUris failed", th);
        this.$listener.b(th);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
