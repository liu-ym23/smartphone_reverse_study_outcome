package com.ss.android.lark.compose.groupinfo;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel", f = "GroupInfoViewModel.kt", i = {0, 2}, l = {77, 95, 101}, m = "updateGroupInfo-IoAF18A", n = {"chatName", "avatarKey"}, s = {"L$0", "L$0"})
public final class GroupInfoViewModel$updateGroupInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GroupInfoViewModel this$0;

    public GroupInfoViewModel$updateGroupInfo$1(GroupInfoViewModel r100, Continuation<? super GroupInfoViewModel$updateGroupInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = GroupInfoViewModel.m8634access$updateGroupInfoIoAF18A(this.this$0, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
