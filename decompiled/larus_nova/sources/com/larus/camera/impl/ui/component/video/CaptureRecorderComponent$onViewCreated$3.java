package com.larus.camera.impl.ui.component.video;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Landroid/view/MotionEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.video.CaptureRecorderComponent$onViewCreated$3", f = "CaptureRecorderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureRecorderComponent$onViewCreated$3 extends SuspendLambda implements Function2<MotionEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureRecorderComponent this$0;

    public CaptureRecorderComponent$onViewCreated$3(CaptureRecorderComponent r100, Continuation<? super CaptureRecorderComponent$onViewCreated$3> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CaptureRecorderComponent$onViewCreated$3 r102 = new CaptureRecorderComponent$onViewCreated$3(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MotionEvent r100, Continuation<? super Unit> r101) {
        return ((CaptureRecorderComponent$onViewCreated$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MotionEvent r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        MotionEvent r101 = (MotionEvent) this.L$0;
        if (r101.getAction() == 0) goto L10;
        View r102 = this.this$0.f322545x;
        if (r102 == null) goto L10;
        Boxing.boxBoolean(r102.dispatchTouchEvent(r101));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
