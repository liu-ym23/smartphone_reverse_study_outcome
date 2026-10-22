package com.ss.android.lark.compose.chatsetting.groupmanage;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.runtime.MutableState;
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

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageScreenKt$GroupManageScreen$3$1", f = "GroupManageScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupManageScreenKt$GroupManageScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $showTransferOwnerSheet$delegate;
    final /* synthetic */ MutableState<Integer> $transferOwnerInstance$delegate;
    final /* synthetic */ MutableTransitionState<Boolean> $transferOwnerVisibleState;
    int label;

    public GroupManageScreenKt$GroupManageScreen$3$1(MutableTransitionState<Boolean> r100, MutableState<Boolean> r101, MutableState<Integer> r102, Continuation<? super GroupManageScreenKt$GroupManageScreen$3$1> r103) {
        this.$transferOwnerVisibleState = r100;
        this.$showTransferOwnerSheet$delegate = r101;
        this.$transferOwnerInstance$delegate = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GroupManageScreenKt$GroupManageScreen$3$1(this.$transferOwnerVisibleState, this.$showTransferOwnerSheet$delegate, this.$transferOwnerInstance$delegate, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GroupManageScreenKt$GroupManageScreen$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (this.$showTransferOwnerSheet$delegate.getValue().booleanValue() == false) goto L7;
        int r101 = this.$transferOwnerInstance$delegate.getValue().intValue();
        this.$transferOwnerInstance$delegate.setValue(Integer.valueOf(r101 + 1));
    L7:
        this.$transferOwnerVisibleState.setTargetState(Boxing.boxBoolean(this.$showTransferOwnerSheet$delegate.getValue().booleanValue()));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
