package com.larus.bmhome.chat.component.playback;

import com.larus.bmhome.social.page.datasource.event.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import xc8.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1", f = "MessagePlaybackHelper.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
public final class MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c<b> $it;
    int label;
    final /* synthetic */ MessagePlaybackHelper this$0;

    public MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1(MessagePlaybackHelper r100, c<b> r101, Continuation<? super MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1> r102) {
        this.this$0 = r100;
        this.$it = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1(this.this$0, this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function3<? super c<b>, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> r103 = this.this$0.f301334l;
        if (r103 == null) goto L14;
        c<b> r104 = this.$it;
        Boolean r105 = Boxing.boxBoolean(false);
        this.label = 1;
        if (r103.invoke(r104, r105, this) != r101) goto L16;
        return r101;
    L14:
        return null;
    }
}
