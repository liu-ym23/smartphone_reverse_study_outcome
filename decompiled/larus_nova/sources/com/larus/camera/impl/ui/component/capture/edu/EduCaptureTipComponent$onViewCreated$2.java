package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.ValueAnimator;
import com.larus.camera.impl.widget.EduCaptureTipView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.edu.EduCaptureTipComponent$onViewCreated$2", f = "EduCaptureTipComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EduCaptureTipComponent$onViewCreated$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ EduCaptureTipComponent this$0;

    public EduCaptureTipComponent$onViewCreated$2(EduCaptureTipComponent r100, Continuation<? super EduCaptureTipComponent$onViewCreated$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        EduCaptureTipComponent$onViewCreated$2 r102 = new EduCaptureTipComponent$onViewCreated$2(this.this$0, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Unit> r101) {
        return ((EduCaptureTipComponent$onViewCreated$2) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        int r101 = this.I$0;
        final EduCaptureTipView r102 = this.this$0.f321895m;
        if (r102 == null) goto L17;
        int r103 = com.larus.camera.impl.utils.c0.f322738d;
        int r104 = ((int) com.larus.camera.impl.utils.c0.a.a(r101, false)) % 360;
        if (r104 <= 180) goto L10;
        r104 = r104 - 360;
    L12:
        float r105 = r104;
        ValueAnimator r106 = r102.f322860k;
        if (r106 == null) goto L15;
        r106.cancel();
    L15:
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{r102.f322855f, r105});
        r107.addUpdateListener(new com.larus.camera.impl.widget.j(r102));
        r107.start();
        r102.f322860k = r107;
        goto L17
    L10:
        if (r104 >= (-180)) goto L12;
        r104 = r104 + 360;
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
