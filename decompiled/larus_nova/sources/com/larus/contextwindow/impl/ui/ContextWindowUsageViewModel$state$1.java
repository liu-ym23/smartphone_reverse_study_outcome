package com.larus.contextwindow.impl.ui;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/larus/contextwindow/impl/ui/ContextWindowPanelState;", "latestContextSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "isContextCompressing", "", "repositoryState", "Lcom/larus/contextwindow/impl/membership/MembershipQuotaRepositoryState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.ui.ContextWindowUsageViewModel$state$1", f = "ContextWindowUsageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContextWindowUsageViewModel$state$1 extends SuspendLambda implements Function4<ContextWindowSnapshot, Boolean, com.larus.contextwindow.impl.membership.h, Continuation<? super a>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    public ContextWindowUsageViewModel$state$1(Continuation<? super ContextWindowUsageViewModel$state$1> r100) {
        super(4, r100);
    }

    public final Object invoke(ContextWindowSnapshot r100, boolean r101, com.larus.contextwindow.impl.membership.h r102, Continuation<? super a> r103) {
        ContextWindowUsageViewModel$state$1 r104 = new ContextWindowUsageViewModel$state$1(r103);
        r104.L$0 = r100;
        r104.Z$0 = r101;
        r104.L$1 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(ContextWindowSnapshot r100, Boolean r101, com.larus.contextwindow.impl.membership.h r102, Continuation<? super a> r103) {
        return invoke(r100, r101.booleanValue(), r102, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        ContextWindowSnapshot r101 = (ContextWindowSnapshot) this.L$0;
        boolean r102 = this.Z$0;
        com.larus.contextwindow.impl.membership.h r103 = (com.larus.contextwindow.impl.membership.h) this.L$1;
        int r104 = b.f330471a;
        if (r102 == true) goto L7;
    L9:
        boolean r105 = false;
    L11:
        return b.a(r101, r103, r105);
    L7:
        if (r101.f330264k == false) goto L9;
        r105 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
