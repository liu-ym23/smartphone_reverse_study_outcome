package com.ss.android.lark.storage.file.statistics;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.storage.file.statistics.FilePathTracker$visitPath$2$1", f = "FilePathTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FilePathTracker$visitPath$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function2<String, Boolean, Unit> $onVisit;
    final /* synthetic */ String $path;
    final /* synthetic */ FilePathTracker $this_run;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathTracker$visitPath$2$1(FilePathTracker r100, Context r101, String r102, Function2<? super String, ? super Boolean, Unit> r103, Continuation<? super FilePathTracker$visitPath$2$1> r104) {
        this.$this_run = r100;
        this.$context = r101;
        this.$path = r102;
        this.$onVisit = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FilePathTracker$visitPath$2$1(this.$this_run, this.$context, this.$path, this.$onVisit, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FilePathTracker$visitPath$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (this.$this_run.f441021c.size() <= 2000) goto L7;
        this.$this_run.f441021c.clear();
    L7:
        String r101 = this.$this_run.a(this.$context, this.$path);
        this.$this_run.f441021c.put(this.$path, r101);
        this.$onVisit.invoke(r101, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
