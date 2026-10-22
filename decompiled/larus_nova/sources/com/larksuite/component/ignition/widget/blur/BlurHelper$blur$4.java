package com.larksuite.component.ignition.widget.blur;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.ignition.widget.blur.BlurHelper$blur$4", f = "BlurHelper.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class BlurHelper$blur$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ a $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ float $radius;
    final /* synthetic */ int $scale;
    int label;

    public BlurHelper$blur$4(Context r100, Bitmap r101, float r102, int r103, a r104, Continuation<? super BlurHelper$blur$4> r105) {
        this.$context = r100;
        this.$bitmap = r101;
        this.$radius = r102;
        this.$scale = r103;
        this.$callback = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BlurHelper$blur$4(this.$context, this.$bitmap, this.$radius, this.$scale, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BlurHelper$blur$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        a r103 = this.$callback;
        Resources r104 = this.$context.getResources();
        r103.a(new BitmapDrawable(r104, (Bitmap) r100));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        BlurProcessor r105 = BlurProcessor.f283997a;
        Context r106 = this.$context;
        Bitmap r107 = this.$bitmap;
        float r108 = this.$radius;
        int r109 = this.$scale;
        this.label = 1;
        r100 = BlurProcessor.a(r106, r107, r108, r109, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
