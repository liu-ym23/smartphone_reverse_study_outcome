package com.ss.android.lark.integrator.im.impl;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.integrator.im.impl.ChatPreviewApiImpl$getPreviewByHangPoints$1", f = "ChatPreviewApiImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class ChatPreviewApiImpl$getPreviewByHangPoints$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Map<String, UrlCardPreviewEntity>> $callback;
    final /* synthetic */ w4b.f $dependency;
    final /* synthetic */ List<PreviewHangPoint> $hangPoints;
    int label;

    public ChatPreviewApiImpl$getPreviewByHangPoints$1(w4b.f r100, List<PreviewHangPoint> r101, IGetDataCallback<Map<String, UrlCardPreviewEntity>> r102, Continuation<? super ChatPreviewApiImpl$getPreviewByHangPoints$1> r103) {
        this.$dependency = r100;
        this.$hangPoints = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatPreviewApiImpl$getPreviewByHangPoints$1(this.$dependency, this.$hangPoints, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatPreviewApiImpl$getPreviewByHangPoints$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        IGetDataCallback<Map<String, UrlCardPreviewEntity>> r103 = this.$callback;
        r103.onSuccess((Map) r100);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        w4b.f r104 = this.$dependency;
        List<PreviewHangPoint> r105 = this.$hangPoints;
        this.label = 1;
        r100 = r104.a(r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
