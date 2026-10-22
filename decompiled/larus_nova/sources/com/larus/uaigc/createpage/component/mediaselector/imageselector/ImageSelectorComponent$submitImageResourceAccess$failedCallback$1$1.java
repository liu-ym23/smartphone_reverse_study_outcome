package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$submitImageResourceAccess$failedCallback$1$1", f = "ImageSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSelectorComponent$submitImageResourceAccess$failedCallback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceUploadError $it;
    final /* synthetic */ Function1<ResourceUploadError, Unit> $onFailed;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSelectorComponent$submitImageResourceAccess$failedCallback$1$1(Function1<? super ResourceUploadError, Unit> r100, ResourceUploadError r101, Continuation<? super ImageSelectorComponent$submitImageResourceAccess$failedCallback$1$1> r102) {
        this.$onFailed = r100;
        this.$it = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImageSelectorComponent$submitImageResourceAccess$failedCallback$1$1(this.$onFailed, this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ImageSelectorComponent$submitImageResourceAccess$failedCallback$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$onFailed.invoke(this.$it);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
