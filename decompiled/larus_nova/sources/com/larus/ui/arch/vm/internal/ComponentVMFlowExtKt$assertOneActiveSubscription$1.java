package com.larus.ui.arch.vm.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$assertOneActiveSubscription$1", f = "ComponentVMFlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComponentVMFlowExtKt$assertOneActiveSubscription$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $activeSubscriptions;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ ComponentVMFlowExtKt$assertOneActiveSubscription$observer$1 $observer;
    final /* synthetic */ String $subscriptionId;
    int label;

    public ComponentVMFlowExtKt$assertOneActiveSubscription$1(Set<String> r100, String r101, LifecycleOwner r102, ComponentVMFlowExtKt$assertOneActiveSubscription$observer$1 r103, Continuation<? super ComponentVMFlowExtKt$assertOneActiveSubscription$1> r104) {
        this.$activeSubscriptions = r100;
        this.$subscriptionId = r101;
        this.$lifecycleOwner = r102;
        this.$observer = r103;
        super(3, r104);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Throwable r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Throwable r101, Continuation<? super Unit> r102) {
        return new ComponentVMFlowExtKt$assertOneActiveSubscription$1(this.$activeSubscriptions, this.$subscriptionId, this.$lifecycleOwner, this.$observer, r102).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$activeSubscriptions.remove(this.$subscriptionId);
        this.$lifecycleOwner.getLifecycle().removeObserver(this.$observer);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
