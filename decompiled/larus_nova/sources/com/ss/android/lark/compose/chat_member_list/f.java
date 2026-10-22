package com.ss.android.lark.compose.chat_member_list;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;

/* JADX INFO: loaded from: classes35.dex */
public final class f {
    public static final Object a(Flow r100, Function2 r101, Function2 r102, Continuation r103) {
        Object r104 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(r100, new ChatMembersViewModelKt$collectDataOrError$2(r102, null)).collect(new e(r101), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }
}
