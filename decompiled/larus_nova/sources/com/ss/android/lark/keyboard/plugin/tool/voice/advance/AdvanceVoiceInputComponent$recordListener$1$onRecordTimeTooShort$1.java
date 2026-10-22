package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.advance.AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1", f = "AdvanceVoiceInputComponent.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
final class AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $r;
    int label;
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1(b r100, a r101, Continuation<? super AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1> r102) {
        this.this$0 = r100;
        this.$r = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1(this.this$0, this.$r, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L18;
        if (r101 != 1) goto L17;
        ResultKt.throwOnFailure(r100);
        Object r102 = ((g) r100).f504697a;
        g.c r103 = g.f504696b;
        if ((!(r102 instanceof g.c)) == false) goto L15;
        Boolean r104 = (Boolean) g.b(r102);
        if (r104 == null) goto L15;
        a r105 = this.$r;
        if (r104.booleanValue() == true) goto L15;
        r105.getClass();
        throw null;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        this.label = 1;
        throw null;
    }
}
