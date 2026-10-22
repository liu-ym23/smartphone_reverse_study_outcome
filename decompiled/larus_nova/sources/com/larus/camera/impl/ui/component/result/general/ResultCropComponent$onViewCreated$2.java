package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.view.crop.ImageCropView;
import com.larus.camera.impl.databinding.LarusLayoutViewCropComponentBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultCropComponent$onViewCreated$2", f = "ResultCropComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultCropComponent$onViewCreated$2 extends SuspendLambda implements Function2<Bitmap, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultCropComponent this$0;

    public ResultCropComponent$onViewCreated$2(ResultCropComponent r100, Continuation<? super ResultCropComponent$onViewCreated$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ResultCropComponent$onViewCreated$2 r102 = new ResultCropComponent$onViewCreated$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Bitmap r100, Continuation<? super Unit> r101) {
        return ((ResultCropComponent$onViewCreated$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Bitmap r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        Bitmap r101 = (Bitmap) this.L$0;
        if (r101 == null) goto L12;
        LarusLayoutViewCropComponentBinding r102 = this.this$0.f322142m;
        if (r102 == null) goto L12;
        ImageCropView r103 = r102.f321517c;
        if (r103 == null) goto L12;
        r103.setImageBitmap(r101);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
