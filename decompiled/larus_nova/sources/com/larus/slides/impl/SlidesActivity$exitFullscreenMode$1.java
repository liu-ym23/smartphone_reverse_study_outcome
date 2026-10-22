package com.larus.slides.impl;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.ss.ttvideoengine.TTVideoEngineInterface;
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

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.slides.impl.SlidesActivity$exitFullscreenMode$1", f = "SlidesActivity.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPT_SUB_LOAD_TIME}, m = "invokeSuspend", n = {}, s = {})
final class SlidesActivity$exitFullscreenMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsControllerCompat $controller;
    final /* synthetic */ View $decorView;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    public SlidesActivity$exitFullscreenMode$1(View r100, WindowInsetsControllerCompat r101, Continuation<? super SlidesActivity$exitFullscreenMode$1> r102) {
        this.$decorView = r100;
        this.$controller = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SlidesActivity$exitFullscreenMode$1(this.$decorView, this.$controller, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SlidesActivity$exitFullscreenMode$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        WindowInsetsControllerCompat r104 = (WindowInsetsControllerCompat) this.L$1;
        View r105 = (View) this.L$0;
        ResultKt.throwOnFailure(r110);
        SlidesActivity$exitFullscreenMode$1 r111 = this;
    L13:
        WindowInsetsCompat r106 = ViewCompat.getRootWindowInsets(r105);
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L22;
        r104.show(WindowInsetsCompat.Type.systemBars());
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
        r104 = this.$controller;
        r102 = 0;
        r111 = this;
        goto L9
    }
}
