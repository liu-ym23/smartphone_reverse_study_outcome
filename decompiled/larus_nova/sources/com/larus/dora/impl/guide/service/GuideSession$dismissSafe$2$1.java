package com.larus.dora.impl.guide.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$dismissSafe$2$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK}, m = "invokeSuspend", n = {}, s = {})
final class GuideSession$dismissSafe$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ l $target;
    int label;

    public GuideSession$dismissSafe$2$1(l r100, Fragment r101, View r102, Continuation<? super GuideSession$dismissSafe$2$1> r103) {
        this.$target = r100;
        this.$fragment = r101;
        this.$anchorView = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new GuideSession$dismissSafe$2$1(this.$target, this.$fragment, this.$anchorView, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((GuideSession$dismissSafe$2$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        l r103 = this.$target;
        Fragment r104 = this.$fragment;
        View r105 = this.$anchorView;
        this.label = 1;
        if (r103.d(r104, r105, this) != r101) goto L12;
        return r101;
    }
}
