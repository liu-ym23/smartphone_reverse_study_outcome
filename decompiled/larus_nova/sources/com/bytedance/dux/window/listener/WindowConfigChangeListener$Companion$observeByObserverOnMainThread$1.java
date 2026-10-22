package com.bytedance.dux.window.listener;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.dux.common.live_data.NextLiveData;
import hm4.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.dux.window.listener.WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Observer<d> $observer;
    final /* synthetic */ LifecycleOwner $owner;
    int label;

    public WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(LifecycleOwner r100, Observer<d> r101, Continuation<? super WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1> r102) {
        this.$owner = r100;
        this.$observer = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(this.$owner, this.$observer, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        WindowConfigChangeListener.Companion r101 = WindowConfigChangeListener.Companion;
        LifecycleOwner r102 = this.$owner;
        r101.getClass();
        NextLiveData r103 = WindowConfigChangeListener.Companion.b(r102);
        if (r103 == null) goto L8;
        r103.observe(this.$owner, this.$observer);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
