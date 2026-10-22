package io.github.alexzhirkevich.compottie;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/github/alexzhirkevich/compottie/internal/assets/LottieAsset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.LottiePainterKt$rememberLottiePainter$painter$2$1$assets$1", f = "LottiePainter.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class LottiePainterKt$rememberLottiePainter$painter$2$1$assets$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends io.github.alexzhirkevich.compottie.internal.assets.d>>, Object> {
    final /* synthetic */ nrc.d $assetsManager;
    final /* synthetic */ LottieComposition $composition;
    final /* synthetic */ boolean $copy;
    int label;

    public LottiePainterKt$rememberLottiePainter$painter$2$1$assets$1(LottieComposition r100, nrc.d r101, boolean r102, Continuation<? super LottiePainterKt$rememberLottiePainter$painter$2$1$assets$1> r103) {
        this.$composition = r100;
        this.$assetsManager = r101;
        this.$copy = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LottiePainterKt$rememberLottiePainter$painter$2$1$assets$1(this.$composition, this.$assetsManager, this.$copy, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends io.github.alexzhirkevich.compottie.internal.assets.d>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<? extends io.github.alexzhirkevich.compottie.internal.assets.d>> r101) {
        return ((LottiePainterKt$rememberLottiePainter$painter$2$1$assets$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        LottieComposition r103 = this.$composition;
        nrc.d r104 = this.$assetsManager;
        if (r104 != null) goto L11;
        r104 = nrc.a.f520273a;
    L11:
        boolean r105 = this.$copy;
        this.label = 1;
        r100 = r103.b(r104, r105, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
