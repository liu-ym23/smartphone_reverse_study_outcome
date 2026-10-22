package com.larus.camera.impl.ui.component.capture.edu;

import com.larus.camera.impl.widget.title.TitleRightIconView;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.edu.EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1", f = "EduCaptureTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ TitleRightIconView $iconView;
    /* synthetic */ int I$0;
    int label;

    public EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1(TitleRightIconView r100, Continuation<? super EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1> r101) {
        this.$iconView = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1 r102 = new EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1(this.$iconView, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Unit> r101) {
        return ((EduCaptureTitleComponent$doConfigRightAreaForNormalEduMode$1$1$1$2$1) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        final int r101 = this.I$0;
        this.$iconView.setIcon(new j0(r101));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
