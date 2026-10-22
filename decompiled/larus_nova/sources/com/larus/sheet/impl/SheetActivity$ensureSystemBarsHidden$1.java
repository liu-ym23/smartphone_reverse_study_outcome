package com.larus.sheet.impl;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.sheet.impl.SheetActivity$ensureSystemBarsHidden$1", f = "SheetActivity.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
final class SheetActivity$ensureSystemBarsHidden$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $decorView;
    final /* synthetic */ Ref.IntRef $uiOptions;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    public SheetActivity$ensureSystemBarsHidden$1(View r100, Ref.IntRef r101, Continuation<? super SheetActivity$ensureSystemBarsHidden$1> r102) {
        this.$decorView = r100;
        this.$uiOptions = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SheetActivity$ensureSystemBarsHidden$1(this.$decorView, this.$uiOptions, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SheetActivity$ensureSystemBarsHidden$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0043 -> B:13:0x0046). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$1;
        int r103 = this.I$0;
        Ref.IntRef r104 = (Ref.IntRef) this.L$1;
        View r105 = (View) this.L$0;
        ResultKt.throwOnFailure(r110);
        SheetActivity$ensureSystemBarsHidden$1 r111 = this;
    L13:
        WindowInsetsCompat r106 = ViewCompat.getRootWindowInsets(r105);
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == false) goto L22;
        r105.setSystemUiVisibility(r104.element);
        r102 = r102 + 1;
    L9:
        if (r102 >= r103) goto L24;
        r111.L$0 = r105;
        r111.L$1 = r104;
        r111.I$0 = r103;
        r111.I$1 = r102;
        r111.label = 1;
        if (DelayKt.delay(100, r111) != r100) goto L13;
        return r100;
    L24:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L16:
        if (r106.isVisible(WindowInsetsCompat.Type.systemBars()) != true) goto L18;
        r107 = true;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        View r112 = this.$decorView;
        r103 = 3;
        r105 = r112;
        r104 = this.$uiOptions;
        r102 = 0;
        r111 = this;
        goto L9
    }
}
