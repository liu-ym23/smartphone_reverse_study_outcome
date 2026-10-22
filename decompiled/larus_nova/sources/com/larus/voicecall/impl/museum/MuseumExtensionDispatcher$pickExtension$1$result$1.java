package com.larus.voicecall.impl.museum;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/voicecall/impl/museum/MuseumPickExtensionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.museum.MuseumExtensionDispatcher$pickExtension$1$result$1", f = "MuseumExtensionDispatcher.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME}, m = "invokeSuspend", n = {}, s = {})
public final class MuseumExtensionDispatcher$pickExtension$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super j>, Object> {
    final /* synthetic */ a $banner;
    int label;

    public MuseumExtensionDispatcher$pickExtension$1$result$1(a r100, Continuation<? super MuseumExtensionDispatcher$pickExtension$1$result$1> r101) {
        this.$banner = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MuseumExtensionDispatcher$pickExtension$1$result$1(this.$banner, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super j> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super j> r101) {
        return ((MuseumExtensionDispatcher$pickExtension$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        MuseumExtensionRepository r103 = MuseumExtensionRepository.f378372a;
        a r104 = this.$banner;
        String r105 = r104.f378376d;
        String r106 = r104.f378377e;
        this.label = 1;
        r100 = r103.a(r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
