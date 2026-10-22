package com.larus.bmhome.chat.component.playback;

import com.larus.bmhome.social.page.datasource.event.c;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$showAllCase$2$1", f = "MessagePlaybackHelper.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
public final class MessagePlaybackHelper$showAllCase$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MessagePlaybackHelper this$0;

    public MessagePlaybackHelper$showAllCase$2$1(MessagePlaybackHelper r100, Continuation<? super MessagePlaybackHelper$showAllCase$2$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessagePlaybackHelper$showAllCase$2$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MessagePlaybackHelper$showAllCase$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L17:
        MessagePlaybackHelper r103 = this.this$0;
        c<b> r104 = r103.f301323a;
        if (r104 == null) goto L22;
        List<b> r105 = r104.f314033a;
        if (r105 == null) goto L22;
        int r106 = r105.size();
    L23:
        r103.f301326d = r106 + 1;
        return Unit.INSTANCE;
    L22:
        r106 = 0;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MessagePlaybackHelper r107 = this.this$0;
        Function3<? super c<b>, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> r108 = r107.f301334l;
        if (r108 == null) goto L17;
        c<b> r109 = r107.f301323a;
        if (r109 == null) goto L13;
        Boolean r110 = Boxing.boxBoolean(true);
        this.label = 1;
        if (r108.invoke(r109, r110, this) != r101) goto L17;
        return r101;
    L13:
        return Unit.INSTANCE;
    }
}
