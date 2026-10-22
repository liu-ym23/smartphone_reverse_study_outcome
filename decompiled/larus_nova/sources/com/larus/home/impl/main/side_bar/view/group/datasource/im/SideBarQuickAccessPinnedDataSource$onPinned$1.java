package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.SideBarQuickAccessPinnedDataSource$onPinned$1", f = "SideBarQuickAccessPinnedDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SideBarQuickAccessPinnedDataSource$onPinned$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NodeType $nodeType;
    final /* synthetic */ String $referenceId;
    int label;
    final /* synthetic */ SideBarQuickAccessPinnedDataSource this$0;

    public SideBarQuickAccessPinnedDataSource$onPinned$1(SideBarQuickAccessPinnedDataSource r100, NodeType r101, String r102, Continuation<? super SideBarQuickAccessPinnedDataSource$onPinned$1> r103) {
        this.this$0 = r100;
        this.$nodeType = r101;
        this.$referenceId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SideBarQuickAccessPinnedDataSource$onPinned$1(this.this$0, this.$nodeType, this.$referenceId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SideBarQuickAccessPinnedDataSource$onPinned$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        SideBarQuickAccessPinnedDataSource r101 = this.this$0;
        if (r101.f345327k == false) goto L7;
        SideBarQuickAccessPinnedDataSource.i(r101, this.$nodeType, this.$referenceId, true);
        this.this$0.l(true);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
