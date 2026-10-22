package com.larus.bmhome.instruction.core.impl.controller;

import androidx.exifinterface.media.ExifInterface;
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

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/larus/bmhome/instruction/core/impl/base/ControllerContextKt$runOnMainThreadIfNeed$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.controller.TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1", f = "TranslatorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ long $defaultValue$inlined;
    final /* synthetic */ String $key$inlined;
    int label;
    final /* synthetic */ TranslatorController this$0;

    public TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1(Continuation r100, TranslatorController r101, String r102, long r103) {
        this.this$0 = r101;
        this.$key$inlined = r102;
        this.$defaultValue$inlined = r103;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1(r101, this.this$0, this.$key$inlined, this.$defaultValue$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Long> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Long> r101) {
        return ((TranslatorController$getLong$$inlined$runOnMainThreadIfNeed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        gb6.c r101 = (gb6.c) this.this$0.f311980q.getValue();
        if (r101 == null) goto L7;
        long r102 = r101.getLong(this.$key$inlined, this.$defaultValue$inlined);
    L9:
        return Boxing.boxLong(r102);
    L7:
        r102 = this.$defaultValue$inlined;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
