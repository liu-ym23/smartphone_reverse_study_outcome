package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.camera.impl.databinding.LarusLayoutViewResultDetectComponentBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "bounds", "Landroid/graphics/Rect;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultDetectComponent$onViewCreated$2", f = "ResultDetectComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultDetectComponent$onViewCreated$2 extends SuspendLambda implements Function2<Rect, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultDetectComponent this$0;

    public ResultDetectComponent$onViewCreated$2(ResultDetectComponent r100, Continuation<? super ResultDetectComponent$onViewCreated$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ResultDetectComponent$onViewCreated$2 r102 = new ResultDetectComponent$onViewCreated$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Rect r100, Continuation<? super Unit> r101) {
        return ((ResultDetectComponent$onViewCreated$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Rect r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        Rect r101 = (Rect) this.L$0;
        FLogger.f375446a.i("ResultDetectComponent", "[resultPreviewBounds] update " + r101);
        ResultDetectComponent r102 = this.this$0;
        LarusLayoutViewResultDetectComponentBinding r103 = r102.f322151m;
        if (r103 == null) goto L14;
        r102.getClass();
        ViewGroup.LayoutParams r104 = r103.f321532b.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L9;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
    L10:
        if (r105 == null) goto L14;
        int[] r106 = new int[2];
        r103.f321531a.getLocationOnScreen(r106);
        int r107 = r101.left - r106[0];
        int r108 = r101.top - r106[1];
        r105.width = r101.width();
        r105.height = r101.height();
        r105.leftMargin = r107;
        r105.topMargin = r108;
        r103.f321532b.setLayoutParams(r105);
        r103.f321531a.invalidate();
        goto L14
    L9:
        r105 = null;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
