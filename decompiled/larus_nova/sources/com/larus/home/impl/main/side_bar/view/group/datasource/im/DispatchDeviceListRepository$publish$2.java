package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.DispatchDeviceListRepository$publish$2", f = "DispatchDeviceListRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DispatchDeviceListRepository$publish$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<n0> $items;
    int label;
    final /* synthetic */ DispatchDeviceListRepository this$0;

    public DispatchDeviceListRepository$publish$2(DispatchDeviceListRepository r100, List<n0> r101, Continuation<? super DispatchDeviceListRepository$publish$2> r102) {
        this.this$0 = r100;
        this.$items = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DispatchDeviceListRepository$publish$2(this.this$0, this.$items, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DispatchDeviceListRepository$publish$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        CopyOnWriteArrayList<Function1<List<n0>, Unit>> r101 = this.this$0.f345226f;
        List<n0> r102 = this.$items;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        ((Function1) r103.next()).invoke(r102);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
