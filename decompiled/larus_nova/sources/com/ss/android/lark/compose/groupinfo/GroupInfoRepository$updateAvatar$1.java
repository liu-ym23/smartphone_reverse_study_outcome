package com.ss.android.lark.compose.groupinfo;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoRepository", f = "GroupInfoRepository.kt", i = {}, l = {41}, m = "updateAvatar-0E7RQCE", n = {}, s = {})
public final class GroupInfoRepository$updateAvatar$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GroupInfoRepository this$0;

    public GroupInfoRepository$updateAvatar$1(GroupInfoRepository r100, Continuation<? super GroupInfoRepository$updateAvatar$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.a(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
