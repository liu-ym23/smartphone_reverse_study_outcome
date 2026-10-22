package com.larus.bmhome.music.widget;

import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$shuffleAction$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
public final class MusicPlayerDetailFragment$shuffleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.music.player.j $newMusicState;
    final /* synthetic */ boolean $next;
    final /* synthetic */ MusicCreationContent $nextState;
    final /* synthetic */ boolean $previous;
    int label;

    public MusicPlayerDetailFragment$shuffleAction$1(com.larus.bmhome.music.player.j r100, boolean r101, boolean r102, MusicCreationContent r103, Continuation<? super MusicPlayerDetailFragment$shuffleAction$1> r104) {
        this.$newMusicState = r100;
        this.$next = r101;
        this.$previous = r102;
        this.$nextState = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MusicPlayerDetailFragment$shuffleAction$1(this.$newMusicState, this.$next, this.$previous, this.$nextState, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MusicPlayerDetailFragment$shuffleAction$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ad9.b r103 = this.$newMusicState.f312978g;
        if (r103 == null) goto L23;
        MutableSharedFlow<ad9.b.C0057b> r104 = r103.b();
        if (r104 == null) goto L23;
        if (this.$next == false) goto L16;
        int r105 = 1;
    L19:
        ad9.b.C0057b r106 = new ad9.b.C0057b(r105, this.$nextState);
        this.label = 1;
        if (r104.emit(r106, this) != r101) goto L23;
        return r101;
    L16:
        if (this.$previous == false) goto L18;
        r105 = -1;
        goto L19
    L18:
        r105 = 0;
        goto L19
    }
}
