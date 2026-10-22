package com.larus.doc.impl.offline;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.offline.OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1", f = "OfflineDocCreateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $realToken;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ OfflineDocCreateComponent this$0;

    public OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1(OfflineDocCreateComponent r100, String r101, String r102, int r103, Continuation<? super OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1> r104) {
        this.this$0 = r100;
        this.$realToken = r101;
        this.$source = r102;
        this.$resourceType = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1(this.this$0, this.$realToken, this.$source, this.$resourceType, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r100);
        d r101 = this.this$0.f331215r;
        if (r101 != null) goto L9;
        return Unit.INSTANCE;
    L9:
        if (r101.XL(this.$realToken) == false) goto L11;
        boolean r102 = r101.HS();
        OfflineDocCreateComponent r103 = this.this$0;
        if (r103.f331213p == true) goto L18;
        if (r102 == false) goto L18;
        r103.f331213p = true;
        int r104 = m39.b.f511804a;
        m39.b.c(this.$source, this.$realToken, true, null);
        r101.ND(this.$resourceType);
        return Unit.INSTANCE;
    L18:
        int r105 = m39.b.f511804a;
        m39.b.c(this.$source, this.$realToken, false, "hasRefreshed=" + this.this$0.f331213p + ",chatAdded=" + r102);
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
