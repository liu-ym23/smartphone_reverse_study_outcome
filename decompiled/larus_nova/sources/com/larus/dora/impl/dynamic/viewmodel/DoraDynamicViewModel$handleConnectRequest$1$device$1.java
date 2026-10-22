package com.larus.dora.impl.dynamic.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dora/device/DoraDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleConnectRequest$1$device$1", f = "DoraDynamicViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicViewModel$handleConnectRequest$1$device$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraDevice>, Object> {
    final /* synthetic */ String $mac;
    int label;

    public DoraDynamicViewModel$handleConnectRequest$1$device$1(String r100, Continuation<? super DoraDynamicViewModel$handleConnectRequest$1$device$1> r101) {
        this.$mac = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraDynamicViewModel$handleConnectRequest$1$device$1(this.$mac, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super DoraDevice> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super DoraDevice> r101) {
        return ((DoraDynamicViewModel$handleConnectRequest$1$device$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        List<DoraDevice> r101 = kj4.a.g().getDoraBindList();
        Object r102 = null;
        if (r101 == null) goto L19;
        String r103 = this.$mac;
        Iterator<T> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((DoraDevice) r105).f204389mac, r103) == false) goto L8;
        r102 = r105;
    L13:
        return (DoraDevice) r102;
    L19:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
