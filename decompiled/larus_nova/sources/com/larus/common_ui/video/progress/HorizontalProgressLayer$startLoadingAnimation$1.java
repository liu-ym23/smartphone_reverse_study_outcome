package com.larus.common_ui.video.progress;

import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.video.progress.HorizontalProgressLayer$startLoadingAnimation$1", f = "HorizontalProgressLayer.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class HorizontalProgressLayer$startLoadingAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ HorizontalProgressLayer this$0;

    public HorizontalProgressLayer$startLoadingAnimation$1(HorizontalProgressLayer r100, Continuation<? super HorizontalProgressLayer$startLoadingAnimation$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new HorizontalProgressLayer$startLoadingAnimation$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((HorizontalProgressLayer$startLoadingAnimation$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0039 -> B:15:0x0043). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0058 -> B:19:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        int r103 = this.I$1;
        int r104 = this.I$0;
        ObjectAnimator[] r105 = (ObjectAnimator[]) this.L$0;
        ResultKt.throwOnFailure(r100);
        HorizontalProgressLayer$startLoadingAnimation$1 r106 = this;
    L19:
        r104 = r104 + 1;
    L15:
        if (r104 < r103) goto L16;
    L9:
        r104 = 0;
        if (r106.this$0.getVisibility() != 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L21;
        ObjectAnimator[] r108 = HorizontalProgressLayer.c(r106.this$0);
        r105 = r108;
        r103 = r108.length;
        goto L15
    L21:
        return Unit.INSTANCE;
    L12:
        r107 = false;
        goto L13
    L16:
        r105[r104].start();
        r106.L$0 = r105;
        r106.I$0 = r104;
        r106.I$1 = r103;
        r106.label = 1;
        if (DelayKt.delay(700, r106) != r101) goto L19;
        return r101;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        HorizontalProgressLayer r109 = this.this$0;
        int r110 = HorizontalProgressLayer.f328063g;
        r109.getClass();
        r106 = this;
        goto L9
    }
}
