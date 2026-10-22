package com.larus.camera.impl.edulibs.camera.internal.util;

import com.larus.camera.api.IFlowCamera;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ix8.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.internal.util.EduNetUtils$requestCloudDetectionByVlm$detectResult$1", f = "EduNetUtils.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
final class EduNetUtils$requestCloudDetectionByVlm$detectResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ ix8.c $request;
    int label;

    public EduNetUtils$requestCloudDetectionByVlm$detectResult$1(ix8.c r100, Continuation<? super EduNetUtils$requestCloudDetectionByVlm$detectResult$1> r101) {
        this.$request = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EduNetUtils$requestCloudDetectionByVlm$detectResult$1(this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super d> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super d> r101) {
        return ((EduNetUtils$requestCloudDetectionByVlm$detectResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return (d) r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IFlowCamera r103 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r103 == null) goto L14;
        ix8.c r104 = this.$request;
        this.label = 1;
        r100 = r103.d(r104, this);
        if (r100 != r101) goto L16;
        return r101;
    L14:
        return null;
    }
}
