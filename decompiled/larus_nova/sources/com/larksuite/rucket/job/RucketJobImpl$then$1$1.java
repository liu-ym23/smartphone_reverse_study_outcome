package com.larksuite.rucket.job;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "data"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$then$1$1", f = "RucketJobImpl.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class RucketJobImpl$then$1$1<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $h;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RucketJobImpl$then$1$1(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super RucketJobImpl$then$1$1> r101) {
        this.$h = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RucketJobImpl$then$1$1 r102 = new RucketJobImpl$then$1$1(this.$h, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T r100, Continuation<? super Unit> r101) {
        return ((RucketJobImpl$then$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.larksuite.rucket.job.RucketJobImpl$then$1$1<T> for r3v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r3.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r4);
    L11:
        kotlin.Unit r4 = kotlin.Unit.INSTANCE;
        return r4;
    L6:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r4;
    L8:
        kotlin.ResultKt.throwOnFailure(r4);
        java.lang.Object r4 = r3.L$0;
        kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r3.$h;
        r3.label = 1;
        T r4 = (T) r4;
        java.lang.Object r3 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3;
        java.lang.Object r4 = r1.invoke(r4, r3);
        if (r4 != r0) goto L11;
        return r0;
    }
}
