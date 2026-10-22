package com.larus.home.impl.main.side_bar.view.adapter;

import com.larus.platform.model.showcase.Case;
import com.larus.showcase.api.ICaseService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.adapter.SideBarCaseHolder$initEvents$2$1", f = "SideBarCaseHolder.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class SideBarCaseHolder$initEvents$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.home.impl.main.side_bar.data.j0 $config;
    int label;
    final /* synthetic */ SideBarCaseHolder this$0;

    public SideBarCaseHolder$initEvents$2$1(com.larus.home.impl.main.side_bar.data.j0 r100, SideBarCaseHolder r101, Continuation<? super SideBarCaseHolder$initEvents$2$1> r102) {
        this.$config = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SideBarCaseHolder$initEvents$2$1(this.$config, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SideBarCaseHolder$initEvents$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L18:
        if (((Boolean) r100).booleanValue() == false) goto L25;
        SideBarCaseHolder r103 = this.this$0;
        r103.f344889f = true;
        r103.T3().setChecked(true);
        this.this$0.f344889f = false;
        com.larus.home.impl.main.side_bar.data.j0 r104 = this.$config;
        if (r104 == null) goto L25;
        Case r105 = r104.f344508c;
        if (r105 == null) goto L25;
        r105.setStatus(Boxing.boxInt(1));
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ICaseService.Companion r106 = ICaseService.f369257a;
        com.larus.home.impl.main.side_bar.data.j0 r107 = this.$config;
        if (r107 == null) goto L13;
        Case r108 = r107.f344508c;
        if (r108 == null) goto L13;
        String r109 = r108.getCaseId();
    L14:
        this.label = 1;
        r100 = r106.p(r109, this);
        if (r100 != r101) goto L18;
        return r101;
    L13:
        r109 = null;
        goto L14
    }
}
