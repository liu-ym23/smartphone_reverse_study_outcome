package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.graphics.Bitmap;
import android.graphics.Color;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.bitable.core.infoarch.arch.ThemeBackgroundView$getAverageColor$2", f = "ThemeBackgroundView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ThemeBackgroundView$getAverageColor$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ int $row;
    int label;

    public ThemeBackgroundView$getAverageColor$2(Bitmap r100, int r101, Continuation<? super ThemeBackgroundView$getAverageColor$2> r102) {
        this.$bitmap = r100;
        this.$row = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ThemeBackgroundView$getAverageColor$2(this.$bitmap, this.$row, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Integer> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Integer> r101) {
        return ((ThemeBackgroundView$getAverageColor$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r110);
        int r100 = this.$bitmap.getWidth();     // Catch: Throwable -> L10
        int[] r101 = new int[r100];     // Catch: Throwable -> L10
        this.$bitmap.getPixels(r101, 0, r100, 0, this.$row, r100, 1);     // Catch: Throwable -> L10
        long r102 = 0;
        long r103 = 0;
        long r104 = 0;
        long r105 = 0;
        int r111 = 0;
    L6:
        if (r111 >= r100) goto L8;
        int r112 = r101[r111];     // Catch: Throwable -> L10
        r103 = r103 + ((long) Color.red(r112));     // Catch: Throwable -> L10
        r104 = r104 + ((long) Color.green(r112));     // Catch: Throwable -> L10
        r105 = r105 + ((long) Color.blue(r112));     // Catch: Throwable -> L10
        r102 = r102 + ((long) Color.alpha(r112));     // Catch: Throwable -> L10
        r111 = r111 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        long r106 = r100;
        return Boxing.boxInt(Color.argb((int) (r102 / r106), (int) (r103 / r106), (int) (r104 / r106), (int) (r105 / r106)));
    L10:
        th = move-exception;
        tt5.a.e("ThemeBackgroundView", "getAverageColor err", th, false);
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
