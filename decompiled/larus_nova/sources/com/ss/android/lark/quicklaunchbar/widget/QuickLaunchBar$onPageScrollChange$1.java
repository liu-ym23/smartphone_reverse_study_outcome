package com.ss.android.lark.quicklaunchbar.widget;

import android.animation.ValueAnimator;
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

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.quicklaunchbar.widget.QuickLaunchBar$onPageScrollChange$1", f = "QuickLaunchBar.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class QuickLaunchBar$onPageScrollChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QuickLaunchBar this$0;

    public QuickLaunchBar$onPageScrollChange$1(QuickLaunchBar r100, Continuation<? super QuickLaunchBar$onPageScrollChange$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new QuickLaunchBar$onPageScrollChange$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((QuickLaunchBar$onPageScrollChange$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:12:0x0027). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        QuickLaunchBar$onPageScrollChange$1 r103 = this;
    L12:
        QuickLaunchBar r104 = r103.this$0;
        int r105 = QuickLaunchBar.f439134g;
        r104.getClass();
        QuickLaunchBar r106 = r103.this$0;
        if (r106.f439140f != 0) goto L14;
    L9:
        r103.label = 1;
        if (DelayKt.delay(400, r103) != r101) goto L12;
        return r101;
    L14:
        r106.getClass();
        int r107 = 0 - r103.this$0.f439140f;
        if (r106.getQuickLaunchBarHeight() <= 0) goto L18;
        r106.g();
    L24:
        QuickLaunchBar r108 = r103.this$0;
        r108.getClass();
        r108.f439140f = 0;
        goto L9
    L18:
        if (Math.abs(r107) < j08.b.a(r106.getContext(), 5.0f)) goto L24;
        if (r107 >= 0) goto L22;
        r106.g();
        goto L24
    L22:
        if (r106.f439139e == false) goto L24;
        ValueAnimator r109 = ValueAnimator.ofInt(new int[]{r106.getQuickLaunchBarHeight(), 0});
        r109.addUpdateListener(new c(r106));
        r109.setDuration(300);
        r109.start();
        r106.f439139e = false;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r103 = this;
        goto L9
    }
}
