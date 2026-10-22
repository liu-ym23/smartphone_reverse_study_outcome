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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.adapter.SideBarCaseHolder$initEvents$1$1", f = "SideBarCaseHolder.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
final class SideBarCaseHolder$initEvents$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.home.impl.main.side_bar.data.j0 $config;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ SideBarCaseHolder this$0;

    public SideBarCaseHolder$initEvents$1$1(com.larus.home.impl.main.side_bar.data.j0 r100, SideBarCaseHolder r101, int r102, Continuation<? super SideBarCaseHolder$initEvents$1$1> r103) {
        this.$config = r100;
        this.this$0 = r101;
        this.$position = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SideBarCaseHolder$initEvents$1$1(this.$config, this.this$0, this.$position, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SideBarCaseHolder$initEvents$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L17:
        boolean r103 = ((Boolean) r100).booleanValue();
        Function3<Integer, com.larus.home.impl.main.side_bar.data.j0, String, Unit> r104 = this.this$0.f344885b;
        if (r104 == null) goto L21;
        r104.invoke(Boxing.boxInt(this.$position), this.$config, "click_checkbox");
    L21:
        if (r103 == true) goto L23;
        SideBarCaseHolder r105 = this.this$0;
        r105.f344889f = true;
        r105.T3().setChecked(false);
        this.this$0.f344889f = false;
    L30:
        return Unit.INSTANCE;
    L23:
        com.larus.home.impl.main.side_bar.data.j0 r106 = this.$config;
        if (r106 == null) goto L28;
        Case r107 = r106.f344508c;
        if (r107 == null) goto L28;
        r107.setStatus(Boxing.boxInt(1));
    L28:
        this.this$0.T3().setEnabled(false);
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ICaseService.Companion r108 = ICaseService.f369257a;
        com.larus.home.impl.main.side_bar.data.j0 r109 = this.$config;
        if (r109 == null) goto L13;
        Case r110 = r109.f344508c;
        if (r110 == null) goto L13;
        String r111 = r110.getCaseId();
    L14:
        this.label = 1;
        r100 = r108.p(r111, this);
        if (r100 != r101) goto L17;
        return r101;
    L13:
        r111 = null;
        goto L14
    }
}
