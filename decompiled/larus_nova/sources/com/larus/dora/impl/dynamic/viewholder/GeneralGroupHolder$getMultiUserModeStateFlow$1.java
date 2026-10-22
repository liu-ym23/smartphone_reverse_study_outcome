package com.larus.dora.impl.dynamic.viewholder;

import com.larus.dora.impl.core.DoraUserManager;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$getMultiUserModeStateFlow$1", f = "GeneralGroupHolder.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 273, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
final class GeneralGroupHolder$getMultiUserModeStateFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public GeneralGroupHolder$getMultiUserModeStateFlow$1(Continuation<? super GeneralGroupHolder$getMultiUserModeStateFlow$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        GeneralGroupHolder$getMultiUserModeStateFlow$1 r102 = new GeneralGroupHolder$getMultiUserModeStateFlow$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Boolean> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Boolean> r100, Continuation<? super Unit> r101) {
        return ((GeneralGroupHolder$getMultiUserModeStateFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L10;
        if (r102 != 3) goto L9;
        ResultKt.throwOnFailure(r100);
    L25:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L19:
        Pair r104 = (Pair) r100;
        boolean r105 = ((Boolean) r104.component1()).booleanValue();
        boolean r106 = ((Boolean) r104.component2()).booleanValue();
        if (r105 == false) goto L25;
        Boolean r107 = Boxing.boxBoolean(r106);
        this.L$0 = null;
        this.label = 3;
        if (r103.emit(r107, this) != r101) goto L25;
        return r101;
    L11:
        r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L16:
        DoraUserManager r108 = DoraUserManager.f332169a;
        this.L$0 = r103;
        this.label = 2;
        r100 = r108.c(this);
        if (r100 != r101) goto L19;
        return r101;
    L12:
        ResultKt.throwOnFailure(r100);
        FlowCollector r109 = (FlowCollector) this.L$0;
        DoraUserManager r110 = DoraUserManager.f332169a;
        Boolean r111 = Boxing.boxBoolean(DoraUserManager.b());
        this.L$0 = r109;
        this.label = 1;
        if (r109.emit(r111, this) != r101) goto L15;
        return r101;
    L15:
        r103 = r109;
        goto L16
    }
}
