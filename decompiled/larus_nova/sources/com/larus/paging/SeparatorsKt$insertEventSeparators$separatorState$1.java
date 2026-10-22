package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0005\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0000*\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "R", "before", "after", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.SeparatorsKt$insertEventSeparators$separatorState$1", f = "Separators.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
final class SeparatorsKt$insertEventSeparators$separatorState$1 extends SuspendLambda implements Function3<Object, Object, Continuation<Object>, Object> {
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $generator;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SeparatorsKt$insertEventSeparators$separatorState$1(Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r100, Continuation<? super SeparatorsKt$insertEventSeparators$separatorState$1> r101) {
        this.$generator = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Continuation<Object> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Object r101, Continuation<Object> r102) {
        SeparatorsKt$insertEventSeparators$separatorState$1 r103 = new SeparatorsKt$insertEventSeparators$separatorState$1(this.$generator, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Object r103 = this.L$0;
        Object r104 = this.L$1;
        Function3<Object, Object, Continuation<Object>, Object> r105 = this.$generator;
        this.L$0 = null;
        this.label = 1;
        r100 = r105.invoke(r103, r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
