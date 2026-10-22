package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/image/uploader/utils/ImageInfo;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowSendMessageUtils$getFlowImageInfo$imageInfo$1", f = "FlowSendMessageUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowSendMessageUtils$getFlowImageInfo$imageInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageInfo>, Object> {
    final /* synthetic */ String $filePath;
    int label;

    public FlowSendMessageUtils$getFlowImageInfo$imageInfo$1(String r100, Continuation<? super FlowSendMessageUtils$getFlowImageInfo$imageInfo$1> r101) {
        this.$filePath = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowSendMessageUtils$getFlowImageInfo$imageInfo$1(this.$filePath, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ImageInfo> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ImageInfo> r101) {
        return ((FlowSendMessageUtils$getFlowImageInfo$imageInfo$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return com.ss.android.lark.image.uploader.utils.b.d(this.$filePath, true, false);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
