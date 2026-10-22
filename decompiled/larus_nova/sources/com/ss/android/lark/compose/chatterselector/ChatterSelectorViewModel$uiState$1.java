package com.ss.android.lark.compose.chatterselector;

import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorUiState;", "membersState", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersUiState;", "selectedIds", "", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.ChatterSelectorViewModel$uiState$1", f = "ChatterSelectorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatterSelectorViewModel$uiState$1 extends SuspendLambda implements Function3<com.ss.android.lark.compose.chat_member_list.d, Set<? extends String>, Continuation<? super b>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ChatterSelectorViewModel$uiState$1(Continuation<? super ChatterSelectorViewModel$uiState$1> r100) {
        super(3, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.ss.android.lark.compose.chat_member_list.d r100, Set<String> r101, Continuation<? super b> r102) {
        ChatterSelectorViewModel$uiState$1 r103 = new ChatterSelectorViewModel$uiState$1(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(com.ss.android.lark.compose.chat_member_list.d r100, Set<? extends String> r101, Continuation<? super b> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r110);
        com.ss.android.lark.compose.chat_member_list.d r111 = (com.ss.android.lark.compose.chat_member_list.d) this.L$0;
        Set r100 = (Set) this.L$1;
        return new b(r111.f417339a, r111.f417340b, r100, r111.f417341c, r111.f417342d, r111.f417343e, r111.f417344f);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
