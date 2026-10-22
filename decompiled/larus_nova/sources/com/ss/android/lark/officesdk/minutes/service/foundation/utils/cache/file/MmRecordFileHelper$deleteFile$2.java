package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$deleteFile$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$deleteFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    int label;

    public MmRecordFileHelper$deleteFile$2(String r100, Continuation<? super MmRecordFileHelper$deleteFile$2> r101) {
        this.$filePath = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordFileHelper$deleteFile$2(this.$filePath, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmRecordFileHelper$deleteFile$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        h r101 = a.f434038a;     // Catch: Throwable -> L9
        VFSFile r102 = a.c(this.$filePath);     // Catch: Throwable -> L9
        if (r102.exists() == false) goto L12;
        FilesKt.deleteRecursively(r102);     // Catch: Throwable -> L9
    L12:
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        lvb.a.b("MmRecordFileHelper", "[deleteFile] error:" + th);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
